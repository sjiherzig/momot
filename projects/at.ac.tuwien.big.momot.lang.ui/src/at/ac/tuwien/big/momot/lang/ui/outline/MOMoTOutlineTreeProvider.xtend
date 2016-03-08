/*
 * generated by Xtext
 */
package at.ac.tuwien.big.momot.lang.ui.outline

import at.ac.tuwien.big.momot.lang.momot.ExperimentOrchestration
import at.ac.tuwien.big.momot.lang.momot.ResultManagement
import at.ac.tuwien.big.momot.lang.momot.ResultManagementCommand
import at.ac.tuwien.big.momot.lang.momot.SaveAnalysisCommand
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider

/**
 * Customization of the default outline structure.
 *
 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#outline
 */
class MOMoTOutlineTreeProvider extends DefaultOutlineTreeProvider {
	
	def Boolean _isLeaf(ResultManagementCommand it) {
		return true
	}
	
	
	def Boolean _isLeaf(SaveAnalysisCommand it) {
		return true
	}
	
	def Boolean _isLeaf(ExperimentOrchestration it) {
		return true
	}
	def String _text(SaveAnalysisCommand it) {
		return "saveAnalysis(" + file + ")"
	}
	
	def String _text(ResultManagement it) {
		return "ResultManagement"
	}
	
	def String _text(ExperimentOrchestration it) {
		return "Experiment"
	}
}
