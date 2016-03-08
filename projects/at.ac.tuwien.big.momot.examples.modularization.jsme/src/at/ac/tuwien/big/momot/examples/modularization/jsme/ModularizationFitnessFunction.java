package at.ac.tuwien.big.momot.examples.modularization.jsme;

import org.eclipse.emf.henshin.interpreter.EGraph;

import at.ac.tuwien.big.moea.search.fitness.dimension.IFitnessDimension.FunctionType;
import at.ac.tuwien.big.momot.examples.modularization.jsme.metric.ModelMetrics;
import at.ac.tuwien.big.momot.examples.modularization.jsme.modularization.ModularizationModel;
import at.ac.tuwien.big.momot.problem.solution.TransformationSolution;
import at.ac.tuwien.big.momot.search.fitness.EGraphMultiDimensionalFitnessFunction;
import at.ac.tuwien.big.momot.search.fitness.IEGraphMultiDimensionalFitnessFunction;
import at.ac.tuwien.big.momot.search.fitness.dimension.AbstractEGraphFitnessDimension;
import at.ac.tuwien.big.momot.search.solution.repair.TransformationPlaceholderRepairer;
import at.ac.tuwien.big.momot.util.MomotUtil;

public class ModularizationFitnessFunction extends EGraphMultiDimensionalFitnessFunction implements IEGraphMultiDimensionalFitnessFunction {

	protected static final String KEY = "calculation";
	
	public ModularizationFitnessFunction() {
		addObjective(new AbstractEGraphFitnessDimension("Coupling", FunctionType.Minimum) {
			@Override
			protected double internalEvaluate(TransformationSolution solution) {
				ModularizationCalculator calculator = solution.getAttribute(KEY, ModularizationCalculator.class);
				ModelMetrics _metrics = calculator.getMetrics();
				return _metrics.coupling;
			}
		});
		
		addObjective(new AbstractEGraphFitnessDimension("Cohesion", FunctionType.Maximum) {
			@Override
			protected double internalEvaluate(TransformationSolution solution) {
				ModularizationCalculator calculator = solution.getAttribute(KEY, ModularizationCalculator.class);
				ModelMetrics _metrics = calculator.getMetrics();
				return _metrics.cohesion;
			}
		});
		
		addObjective(new AbstractEGraphFitnessDimension("NrModules", FunctionType.Maximum) {
			@Override
			protected double internalEvaluate(TransformationSolution solution) {
				ModularizationCalculator calculator = solution.getAttribute(KEY, ModularizationCalculator.class);
				ModelMetrics _metrics = calculator.getMetrics();
				return _metrics.nrModules - _metrics.nrEmptyModules;
			}
		});
		
		addObjective(new AbstractEGraphFitnessDimension("MQ", FunctionType.Maximum) {
			@Override
			protected double internalEvaluate(TransformationSolution solution) {
				ModularizationCalculator calculator = solution.getAttribute(KEY, ModularizationCalculator.class);
				ModelMetrics _metrics = calculator.getMetrics();
				return _metrics.modularizationQuality;
			}
		});
		
		addObjective(new AbstractEGraphFitnessDimension("MinMaxDiff", FunctionType.Minimum) {
			@Override
			protected double internalEvaluate(TransformationSolution solution) {
				ModularizationCalculator calculator = solution.getAttribute(KEY, ModularizationCalculator.class);
				ModelMetrics _metrics = calculator.getMetrics();
				return _metrics.minMaxDiff;
			}
		});
		
		setSolutionRepairer(new TransformationPlaceholderRepairer());
	}
	
	@Override
    protected void preprocessEvaluation(final TransformationSolution solution) {
		EGraph _execute = solution.execute();
		ModularizationModel root = MomotUtil.getRoot(_execute, ModularizationModel.class);
		solution.setAttribute("root", root);
		ModularizationCalculator _modularizationCalculator = new ModularizationCalculator(root);
		solution.setAttribute(KEY, _modularizationCalculator);
    }
}
