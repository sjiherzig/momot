package at.ac.tuwien.big.momot.lang.ui.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.core.runtime.*;
import org.eclipse.jface.operation.*;
import java.lang.reflect.InvocationTargetException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.core.resources.*;
import org.eclipse.core.runtime.CoreException;
import java.io.*;
import org.eclipse.ui.*;
import org.eclipse.ui.ide.IDE;

/**
 * This is a sample new wizard. Its role is to create a new file 
 * resource in the provided container. If the container resource
 * (a folder or a project) is selected in the workspace 
 * when the wizard is opened, it will accept it as the target
 * container. The wizard creates one file with the extension
 * "momot". If a sample multi-page editor (also available
 * as a template) is registered for the same extension, it will
 * be able to open it.
 */

public class MOMoTNewWizard extends Wizard implements INewWizard {
	private MOMoTNewWizardFilePage page;
	private ISelection selection;

	/**
	 * Constructor for MOMoTNewWizard.
	 */
	public MOMoTNewWizard() {
		super();
		setNeedsProgressMonitor(true);
	}
	
	/**
	 * Adding the page to the wizard.
	 */

	public void addPages() {
		page = new MOMoTNewWizardFilePage(selection);
		addPage(page);
	}

	/**
	 * This method is called when 'Finish' button is pressed in
	 * the wizard. We will create an operation and run it
	 * using wizard as execution context.
	 */
	public boolean performFinish() {
		final String containerName = page.getContainerFullPath().toString();
		final String fileName = page.getFileName();
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					doFinish(containerName, fileName, monitor);
				} catch (CoreException e) {
					throw new InvocationTargetException(e);
				} finally {
					monitor.done();
				}
			}
		};
		try {
			getContainer().run(true, false, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			Throwable realException = e.getTargetException();
			MessageDialog.openError(getShell(), "Error", realException.getMessage());
			return false;
		}
		return true;
	}
	
	/**
	 * The worker method. It will find the container, create the
	 * file if missing or just replace its contents, and open
	 * the editor on the newly created file.
	 */

	private void doFinish(
		String containerName,
		String fileName,
		IProgressMonitor monitor)
		throws CoreException {
		// create a sample file
		monitor.beginTask("Creating " + fileName, 2);
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IResource resource = root.findMember(new Path(containerName));
		if (!resource.exists() || !(resource instanceof IContainer)) {
			throwCoreException("Container \"" + containerName + "\" does not exist.");
		}
		IContainer container = (IContainer) resource;
		final IFile file = container.getFile(new Path(fileName));
		try {
			InputStream stream = openContentStream();
			if (file.exists()) {
				file.setContents(stream, true, true, monitor);
			} else {
				file.create(stream, true, monitor);
			}
			stream.close();
		} catch (IOException e) {
		}
		monitor.worked(1);
		monitor.setTaskName("Opening file for editing...");
		getShell().getDisplay().asyncExec(new Runnable() {
			public void run() {
				IWorkbenchPage page =
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				try {
					IDE.openEditor(page, file, true);
				} catch (PartInitException e) {
				}
			}
		});
		monitor.worked(1);
	}
	
	/**
	 * We will initialize file contents with a sample text.
	 */

	private InputStream openContentStream() {
		StringBuilder sb = new StringBuilder();
		sb.append("package momot.^search\n");
		sb.append("\n");
		
		sb.append("import at.ac.tuwien.big.momot.^search.^fitness.dimension.TransformationLengthDimension\n");
		sb.append("import at.ac.tuwien.big.moea.^experiment.executor.listener.SeedRuntimePrintListener\n");
		sb.append("\n");
		
		sb.append("initialization = {\n");
		sb.append("\t" + "System.out.println(\"Search started.\");\n");
		sb.append("}\n");
		sb.append("\n");
		
		sb.append("search = {\n");
		sb.append("\t" + "model          = {\n");
		sb.append("\t" + "\t" + "file       = \"input/model.xmi\"\n");
		sb.append("\t" + "}\n");
		sb.append("\t" + "solutionLength  = 10\n");
		sb.append("\n");
		sb.append("\t" + "transformations = {\n");
		sb.append("\t" + "\t" + "modules = [ \"input/transformations.henshin\" ]\n");
		sb.append("\t" + "}\n");
		sb.append("\n");
		sb.append("\t" + "fitness         = {\n");
		sb.append("\t" + "\t" + "objectives = {\n");
		sb.append("\t" + "\t" + "\t" + "FirstObjective : minimize { 0.0 }\n");
		sb.append("\t" + "\t" + "\t" + "SolutionLength : minimize new TransformationLengthDimension\n");
		sb.append("\t" + "\t" + "}\n");
		sb.append("\t" + "}\n");
		sb.append("\n");
		sb.append("\t" + "algorithms      = {\n");
		sb.append("\t" + "\t" + "Random  : moea.createRandomSearch()\n");
		sb.append("\t" + "\t" + "NSGAII  : moea.createNSGAII()\n");
		sb.append("\t" + "\t" + "NSGAIII : moea.createNSGAIII()\n");
		sb.append("\t" + "}\n");
		sb.append("}\n");
		sb.append("\n");
		
		sb.append("experiment = {\n");
		sb.append("\t" + "populationSize    = 100\n");
		sb.append("\t" + "maxEvaluations    = 10000\n");
		sb.append("\t" + "nrRuns            = 30\n");
		sb.append("\t" + "progressListeners = [ new SeedRuntimePrintListener ]\n");
		sb.append("}\n");
		sb.append("\n");
		
		sb.append("analysis = {\n");
		sb.append("\t" + "indicators       = [ hypervolume generationalDistance ]\n");
		sb.append("\t" + "significance     = 0.01\n");
		sb.append("\t" + "show             = [ aggregateValues statisticalSignificance individualValues ]\n");
		sb.append("\t" + "outputFile       = \"output/analysis/analysis.txt\"\n");
		sb.append("\t" + "boxplotDirectory = \"output/analysis/\"\n");
		sb.append("\t" + "printOutput\n");
		sb.append("}\n");
		sb.append("\n");
		
		sb.append("results = {\n");
		sb.append("\t" + "objectives = {\n");
		sb.append("\t" + "\t" + "outputFile      = \"output/objectives/objective_values.txt\"\n");
		sb.append("\t" + "\t" + "printOutput\n");
		sb.append("\t" + "}\n");
		sb.append("\n");
		sb.append("\t" + "solutions  = {\n");
		sb.append("\t" + "\t" + "outputFile      = \"output/solutions/objective_values.txt\"\n");
		sb.append("\t" + "\t" + "outputDirectory = \"output/solutions/\"\n");
		sb.append("\t" + "}\n");
		sb.append("\n");
		sb.append("\t" + "models     = {\n");
		sb.append("\t" + "\t" + "outputDirectory = \"output/models/\"\n");
		sb.append("\t" + "}\n");
		sb.append("}\n");
		sb.append("\n");
		
		sb.append("finalization = {\n");
		sb.append("\t" + "System.out.println(\"Search finished.\");\n");
		sb.append("}\n");
		return new ByteArrayInputStream(sb.toString().getBytes());
	}

	private void throwCoreException(String message) throws CoreException {
		IStatus status =
			new Status(IStatus.ERROR, "at.ac.tuwien.big.momot.lang.ui", IStatus.OK, message, null);
		throw new CoreException(status);
	}

	/**
	 * We will accept the selection in the workbench to see if
	 * we can initialize from it.
	 * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
	}
}