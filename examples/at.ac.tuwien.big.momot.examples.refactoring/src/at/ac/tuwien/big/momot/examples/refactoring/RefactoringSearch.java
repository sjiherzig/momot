package at.ac.tuwien.big.momot.examples.refactoring;

import at.ac.tuwien.big.moea.SearchExperiment;
import at.ac.tuwien.big.moea.SearchResultManager;
import at.ac.tuwien.big.moea.experiment.executor.listener.RuntimePrintListener;
import at.ac.tuwien.big.moea.experiment.executor.listener.SeedRuntimePrintListener;
import at.ac.tuwien.big.moea.search.algorithm.EvolutionaryAlgorithmFactory;
import at.ac.tuwien.big.momot.ModuleManager;
import at.ac.tuwien.big.momot.TransformationSearchOrchestration;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.search.algorithm.operator.mutation.TransformationPlaceholderMutation;
import at.ac.tuwien.big.momot.search.fitness.IEGraphMultiDimensionalFitnessFunction;
import at.ac.tuwien.big.momot.search.fitness.dimension.OCLQueryDimension;
import at.ac.tuwien.big.momot.search.fitness.dimension.TransformationLengthDimension;
import at.ac.tuwien.big.momot.search.solution.repair.TransformationPlaceholderRepairer;

import java.io.IOException;

import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.ocl.ParserException;
import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.Solution;
import org.moeaframework.core.operator.OnePointCrossover;
import org.moeaframework.core.operator.TournamentSelection;

public class RefactoringSearch {

   public static TransformationSearchOrchestration createOrchestration() throws ParserException {
      final ModuleManager henshin = new ModuleManager("model/", "Refactoring.henshin");
      final TransformationSearchOrchestration orchestration = new TransformationSearchOrchestration(henshin,
            "SeveralRefactorings.xmi", 10);

      final IEGraphMultiDimensionalFitnessFunction fitnessFunction = orchestration.getFitnessFunction();

      fitnessFunction.addObjective(new OCLQueryDimension("ContentSize", "properties->size() * 1.1 + entities->size()",
            orchestration.createOCLHelper()));

      fitnessFunction.addObjective(new TransformationLengthDimension());
      fitnessFunction.setSolutionRepairer(new TransformationPlaceholderRepairer());
      orchestration.setSolutionWriter(new RefactoringSolutionWriter(orchestration.getFitnessFunction()));

      return orchestration;
   }

   public static void executeEvolutionarySearch(final TransformationSearchOrchestration orchestration)
         throws IOException {
      System.out.println(orchestration.write(orchestration.getProblemGraph()));

      final EvolutionaryAlgorithmFactory<TransformationSolution> moea = orchestration
            .createEvolutionaryAlgorithmFactory(15);
      orchestration.addAlgorithm("NSGA-II", moea.createNSGAIII(new TournamentSelection(2), new OnePointCrossover(1.0),
            new TransformationPlaceholderMutation(0.15)));

      final SearchExperiment<TransformationSolution> experiment = new SearchExperiment<>(orchestration, 150);
      experiment.addProgressListener(new RuntimePrintListener());
      experiment.addProgressListener(new SeedRuntimePrintListener());
      experiment.setNumberOfRuns(1);

      final SearchResultManager manager = new SearchResultManager(experiment);

      final NondominatedPopulation results = manager.createApproximationSet();
      System.out.println(orchestration.print(results));
      for(final Solution solution : results) {
         final TransformationSolution matchSolution = (TransformationSolution) solution;
         final EGraph graph = matchSolution.execute();
         if(graph != null) {
            orchestration.getModuleManager().saveGraph(graph,
                  "SeveralRefactorings_Solution_" + matchSolution.getSolutionLength() + ".xmi");
         }
      }
      manager.saveObjectives("output/evolutionary_reference_set.csv");
      // experiment.show(false, AccumulatorUtil.Keys.INDICATOR_HYPERVOLUME);
      // experiment.printAnalysis();
   }

   public static void main(final String[] args) throws ParserException, IOException {
      executeEvolutionarySearch(createOrchestration());
   }
}
