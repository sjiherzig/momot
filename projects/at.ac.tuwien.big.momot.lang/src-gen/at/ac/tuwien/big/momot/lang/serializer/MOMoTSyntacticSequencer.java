/*
 * generated by Xtext
 */
package at.ac.tuwien.big.momot.lang.serializer;

import at.ac.tuwien.big.momot.lang.services.MOMoTGrammarAccess;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class MOMoTSyntacticSequencer extends AbstractSyntacticSequencer {

	protected MOMoTGrammarAccess grammarAccess;
	protected AbstractElementAlias match_ExperimentOrchestration___CollectorsKeyword_13_0_OpSingleAssignParserRuleCall_13_1_LeftSquareBracketKeyword_13_2_RightSquareBracketKeyword_13_4__q;
	protected AbstractElementAlias match_ExperimentOrchestration___ProgressListenersKeyword_12_0_OpSingleAssignParserRuleCall_12_1_LeftSquareBracketKeyword_12_2_RightSquareBracketKeyword_12_4__q;
	protected AbstractElementAlias match_FitnessDimensionOCL___LeftCurlyBracketKeyword_4_0_RightCurlyBracketKeyword_4_2__q;
	protected AbstractElementAlias match_TransformationOrchestration___ParameterValuesKeyword_6_0_OpSingleAssignParserRuleCall_6_1_LeftCurlyBracketKeyword_6_2_RightCurlyBracketKeyword_6_4__q;
	protected AbstractElementAlias match_XBlockExpression_SemicolonKeyword_2_1_q;
	protected AbstractElementAlias match_XExpressionInClosure_SemicolonKeyword_1_1_q;
	protected AbstractElementAlias match_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q;
	protected AbstractElementAlias match_XImportDeclaration_SemicolonKeyword_2_q;
	protected AbstractElementAlias match_XParenthesizedExpression_LeftParenthesisKeyword_0_a;
	protected AbstractElementAlias match_XParenthesizedExpression_LeftParenthesisKeyword_0_p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (MOMoTGrammarAccess) access;
		match_ExperimentOrchestration___CollectorsKeyword_13_0_OpSingleAssignParserRuleCall_13_1_LeftSquareBracketKeyword_13_2_RightSquareBracketKeyword_13_4__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getExperimentOrchestrationAccess().getCollectorsKeyword_13_0()), new TokenAlias(false, false, grammarAccess.getExperimentOrchestrationAccess().getOpSingleAssignParserRuleCall_13_1()), new TokenAlias(false, false, grammarAccess.getExperimentOrchestrationAccess().getLeftSquareBracketKeyword_13_2()), new TokenAlias(false, false, grammarAccess.getExperimentOrchestrationAccess().getRightSquareBracketKeyword_13_4()));
		match_ExperimentOrchestration___ProgressListenersKeyword_12_0_OpSingleAssignParserRuleCall_12_1_LeftSquareBracketKeyword_12_2_RightSquareBracketKeyword_12_4__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getExperimentOrchestrationAccess().getProgressListenersKeyword_12_0()), new TokenAlias(false, false, grammarAccess.getExperimentOrchestrationAccess().getOpSingleAssignParserRuleCall_12_1()), new TokenAlias(false, false, grammarAccess.getExperimentOrchestrationAccess().getLeftSquareBracketKeyword_12_2()), new TokenAlias(false, false, grammarAccess.getExperimentOrchestrationAccess().getRightSquareBracketKeyword_12_4()));
		match_FitnessDimensionOCL___LeftCurlyBracketKeyword_4_0_RightCurlyBracketKeyword_4_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getFitnessDimensionOCLAccess().getLeftCurlyBracketKeyword_4_0()), new TokenAlias(false, false, grammarAccess.getFitnessDimensionOCLAccess().getRightCurlyBracketKeyword_4_2()));
		match_TransformationOrchestration___ParameterValuesKeyword_6_0_OpSingleAssignParserRuleCall_6_1_LeftCurlyBracketKeyword_6_2_RightCurlyBracketKeyword_6_4__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getTransformationOrchestrationAccess().getParameterValuesKeyword_6_0()), new TokenAlias(false, false, grammarAccess.getTransformationOrchestrationAccess().getOpSingleAssignParserRuleCall_6_1()), new TokenAlias(false, false, grammarAccess.getTransformationOrchestrationAccess().getLeftCurlyBracketKeyword_6_2()), new TokenAlias(false, false, grammarAccess.getTransformationOrchestrationAccess().getRightCurlyBracketKeyword_6_4()));
		match_XBlockExpression_SemicolonKeyword_2_1_q = new TokenAlias(false, true, grammarAccess.getXBlockExpressionAccess().getSemicolonKeyword_2_1());
		match_XExpressionInClosure_SemicolonKeyword_1_1_q = new TokenAlias(false, true, grammarAccess.getXExpressionInClosureAccess().getSemicolonKeyword_1_1());
		match_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getXFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getXFunctionTypeRefAccess().getRightParenthesisKeyword_0_2()));
		match_XImportDeclaration_SemicolonKeyword_2_q = new TokenAlias(false, true, grammarAccess.getXImportDeclarationAccess().getSemicolonKeyword_2());
		match_XParenthesizedExpression_LeftParenthesisKeyword_0_a = new TokenAlias(true, true, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
		match_XParenthesizedExpression_LeftParenthesisKeyword_0_p = new TokenAlias(true, false, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getArrayBracketsRule())
			return getArrayBracketsToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getOpKeyAssignRule())
			return getOpKeyAssignToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getOpSingleAssignRule())
			return getOpSingleAssignToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * ArrayBrackets :
	 * 	'[' ']'
	 * ;
	 */
	protected String getArrayBracketsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "[]";
	}
	
	/**
	 * OpKeyAssign:
	 * 	":"
	 * ;
	 */
	protected String getOpKeyAssignToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return ":";
	}
	
	/**
	 * OpSingleAssign:
	 * 	'='
	 * ;
	 */
	protected String getOpSingleAssignToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "=";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_ExperimentOrchestration___CollectorsKeyword_13_0_OpSingleAssignParserRuleCall_13_1_LeftSquareBracketKeyword_13_2_RightSquareBracketKeyword_13_4__q.equals(syntax))
				emit_ExperimentOrchestration___CollectorsKeyword_13_0_OpSingleAssignParserRuleCall_13_1_LeftSquareBracketKeyword_13_2_RightSquareBracketKeyword_13_4__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ExperimentOrchestration___ProgressListenersKeyword_12_0_OpSingleAssignParserRuleCall_12_1_LeftSquareBracketKeyword_12_2_RightSquareBracketKeyword_12_4__q.equals(syntax))
				emit_ExperimentOrchestration___ProgressListenersKeyword_12_0_OpSingleAssignParserRuleCall_12_1_LeftSquareBracketKeyword_12_2_RightSquareBracketKeyword_12_4__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_FitnessDimensionOCL___LeftCurlyBracketKeyword_4_0_RightCurlyBracketKeyword_4_2__q.equals(syntax))
				emit_FitnessDimensionOCL___LeftCurlyBracketKeyword_4_0_RightCurlyBracketKeyword_4_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_TransformationOrchestration___ParameterValuesKeyword_6_0_OpSingleAssignParserRuleCall_6_1_LeftCurlyBracketKeyword_6_2_RightCurlyBracketKeyword_6_4__q.equals(syntax))
				emit_TransformationOrchestration___ParameterValuesKeyword_6_0_OpSingleAssignParserRuleCall_6_1_LeftCurlyBracketKeyword_6_2_RightCurlyBracketKeyword_6_4__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XBlockExpression_SemicolonKeyword_2_1_q.equals(syntax))
				emit_XBlockExpression_SemicolonKeyword_2_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XExpressionInClosure_SemicolonKeyword_1_1_q.equals(syntax))
				emit_XExpressionInClosure_SemicolonKeyword_1_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q.equals(syntax))
				emit_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XImportDeclaration_SemicolonKeyword_2_q.equals(syntax))
				emit_XImportDeclaration_SemicolonKeyword_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XParenthesizedExpression_LeftParenthesisKeyword_0_a.equals(syntax))
				emit_XParenthesizedExpression_LeftParenthesisKeyword_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XParenthesizedExpression_LeftParenthesisKeyword_0_p.equals(syntax))
				emit_XParenthesizedExpression_LeftParenthesisKeyword_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     ('collectors' OpSingleAssign '[' ']')?
	 *
	 * This ambiguous syntax occurs at:
	 *     nrRuns=XNumberLiteral ('progressListeners' OpSingleAssign '[' ']')? (ambiguity) '}' (rule end)
	 *     progressListeners+=XConstructorCall ']' (ambiguity) '}' (rule end)
	 *     referenceSet=XExpression ('progressListeners' OpSingleAssign '[' ']')? (ambiguity) '}' (rule end)
	 */
	protected void emit_ExperimentOrchestration___CollectorsKeyword_13_0_OpSingleAssignParserRuleCall_13_1_LeftSquareBracketKeyword_13_2_RightSquareBracketKeyword_13_4__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('progressListeners' OpSingleAssign '[' ']')?
	 *
	 * This ambiguous syntax occurs at:
	 *     nrRuns=XNumberLiteral (ambiguity) 'collectors' OpSingleAssign '[' collectors=CollectorArray
	 *     nrRuns=XNumberLiteral (ambiguity) ('collectors' OpSingleAssign '[' ']')? '}' (rule end)
	 *     referenceSet=XExpression (ambiguity) 'collectors' OpSingleAssign '[' collectors=CollectorArray
	 *     referenceSet=XExpression (ambiguity) ('collectors' OpSingleAssign '[' ']')? '}' (rule end)
	 */
	protected void emit_ExperimentOrchestration___ProgressListenersKeyword_12_0_OpSingleAssignParserRuleCall_12_1_LeftSquareBracketKeyword_12_2_RightSquareBracketKeyword_12_4__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('{' '}')?
	 *
	 * This ambiguous syntax occurs at:
	 *     query=XStringLiteral (ambiguity) (rule end)
	 */
	protected void emit_FitnessDimensionOCL___LeftCurlyBracketKeyword_4_0_RightCurlyBracketKeyword_4_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('parameterValues' OpSingleAssign '{' '}')?
	 *
	 * This ambiguous syntax occurs at:
	 *     modules=ArrayLiteral (ambiguity) '}' (rule end)
	 *     nonSolutionParameters=ArrayLiteral (ambiguity) '}' (rule end)
	 *     unitsToRemove=ArrayLiteral (ambiguity) '}' (rule end)
	 */
	protected void emit_TransformationOrchestration___ParameterValuesKeyword_6_0_OpSingleAssignParserRuleCall_6_1_LeftCurlyBracketKeyword_6_2_RightCurlyBracketKeyword_6_4__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ';'?
	 *
	 * This ambiguous syntax occurs at:
	 *     expressions+=XExpressionOrVarDeclaration (ambiguity) '}' ')' (rule end)
	 *     expressions+=XExpressionOrVarDeclaration (ambiguity) '}' (rule end)
	 *     expressions+=XExpressionOrVarDeclaration (ambiguity) expressions+=XExpressionOrVarDeclaration
	 */
	protected void emit_XBlockExpression_SemicolonKeyword_2_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ';'?
	 *
	 * This ambiguous syntax occurs at:
	 *     expressions+=XExpressionOrVarDeclaration (ambiguity) (rule end)
	 *     expressions+=XExpressionOrVarDeclaration (ambiguity) expressions+=XExpressionOrVarDeclaration
	 */
	protected void emit_XExpressionInClosure_SemicolonKeyword_1_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('(' ')')?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) '=>' returnType=JvmTypeReference
	 */
	protected void emit_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ';'?
	 *
	 * This ambiguous syntax occurs at:
	 *     importedNamespace=QualifiedNameWithWildcard (ambiguity) (rule end)
	 *     importedType=[JvmDeclaredType|QualifiedName] (ambiguity) (rule end)
	 *     memberName=ValidID (ambiguity) (rule end)
	 *     wildcard?='*' (ambiguity) (rule end)
	 */
	protected void emit_XImportDeclaration_SemicolonKeyword_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '('*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) '#' '[' ']' (rule start)
	 *     (rule start) (ambiguity) '#' '[' elements+=XExpression
	 *     (rule start) (ambiguity) '#' '{' '}' (rule start)
	 *     (rule start) (ambiguity) '#' '{' elements+=XExpression
	 *     (rule start) (ambiguity) '<' typeArguments+=JvmArgumentTypeReference
	 *     (rule start) (ambiguity) '[' declaredFormalParameters+=JvmFormalParameter
	 *     (rule start) (ambiguity) '[' explicitSyntax?='|'
	 *     (rule start) (ambiguity) '[' expression=XExpressionInClosure
	 *     (rule start) (ambiguity) 'do' body=XExpression
	 *     (rule start) (ambiguity) 'false' (rule start)
	 *     (rule start) (ambiguity) 'for' '(' ';' ';' ')' eachExpression=XExpression
	 *     (rule start) (ambiguity) 'for' '(' ';' ';' updateExpressions+=XExpression
	 *     (rule start) (ambiguity) 'for' '(' ';' expression=XExpression
	 *     (rule start) (ambiguity) 'for' '(' declaredParam=JvmFormalParameter
	 *     (rule start) (ambiguity) 'for' '(' initExpressions+=XExpressionOrVarDeclaration
	 *     (rule start) (ambiguity) 'if' '(' if=XExpression
	 *     (rule start) (ambiguity) 'new' constructor=[JvmConstructor|QualifiedName]
	 *     (rule start) (ambiguity) 'null' (rule start)
	 *     (rule start) (ambiguity) 'return' (rule start)
	 *     (rule start) (ambiguity) 'return' expression=XExpression
	 *     (rule start) (ambiguity) 'switch' '(' declaredParam=JvmFormalParameter
	 *     (rule start) (ambiguity) 'switch' declaredParam=JvmFormalParameter
	 *     (rule start) (ambiguity) 'switch' switch=XExpression
	 *     (rule start) (ambiguity) 'synchronized' '(' param=XExpression
	 *     (rule start) (ambiguity) 'throw' expression=XExpression
	 *     (rule start) (ambiguity) 'try' expression=XExpression
	 *     (rule start) (ambiguity) 'typeof' '(' type=[JvmType|QualifiedName]
	 *     (rule start) (ambiguity) 'while' '(' predicate=XExpression
	 *     (rule start) (ambiguity) '{' '}' (rule start)
	 *     (rule start) (ambiguity) '{' expressions+=XExpressionOrVarDeclaration
	 *     (rule start) (ambiguity) feature=[JvmIdentifiableElement|FeatureCallID]
	 *     (rule start) (ambiguity) feature=[JvmIdentifiableElement|IdOrSuper]
	 *     (rule start) (ambiguity) feature=[JvmIdentifiableElement|OpUnary]
	 *     (rule start) (ambiguity) isTrue?='true'
	 *     (rule start) (ambiguity) value=Number
	 *     (rule start) (ambiguity) value=STRING
	 *     (rule start) (ambiguity) {XAssignment.assignable=}
	 *     (rule start) (ambiguity) {XBinaryOperation.leftOperand=}
	 *     (rule start) (ambiguity) {XCastedExpression.target=}
	 *     (rule start) (ambiguity) {XInstanceOfExpression.expression=}
	 *     (rule start) (ambiguity) {XMemberFeatureCall.memberCallTarget=}
	 *     (rule start) (ambiguity) {XPostfixOperation.operand=}
	 */
	protected void emit_XParenthesizedExpression_LeftParenthesisKeyword_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '('+
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) '#' '[' ']' ')' (rule start)
	 *     (rule start) (ambiguity) '#' '[' elements+=XExpression
	 *     (rule start) (ambiguity) '#' '{' '}' ')' (rule start)
	 *     (rule start) (ambiguity) '#' '{' elements+=XExpression
	 *     (rule start) (ambiguity) '<' typeArguments+=JvmArgumentTypeReference
	 *     (rule start) (ambiguity) '[' declaredFormalParameters+=JvmFormalParameter
	 *     (rule start) (ambiguity) '[' explicitSyntax?='|'
	 *     (rule start) (ambiguity) '[' expression=XExpressionInClosure
	 *     (rule start) (ambiguity) 'do' body=XExpression
	 *     (rule start) (ambiguity) 'false' ')' (rule start)
	 *     (rule start) (ambiguity) 'for' '(' ';' ';' ')' eachExpression=XExpression
	 *     (rule start) (ambiguity) 'for' '(' ';' ';' updateExpressions+=XExpression
	 *     (rule start) (ambiguity) 'for' '(' ';' expression=XExpression
	 *     (rule start) (ambiguity) 'for' '(' declaredParam=JvmFormalParameter
	 *     (rule start) (ambiguity) 'for' '(' initExpressions+=XExpressionOrVarDeclaration
	 *     (rule start) (ambiguity) 'if' '(' if=XExpression
	 *     (rule start) (ambiguity) 'new' constructor=[JvmConstructor|QualifiedName]
	 *     (rule start) (ambiguity) 'null' ')' (rule start)
	 *     (rule start) (ambiguity) 'return' ')' (rule start)
	 *     (rule start) (ambiguity) 'return' expression=XExpression
	 *     (rule start) (ambiguity) 'switch' '(' declaredParam=JvmFormalParameter
	 *     (rule start) (ambiguity) 'switch' declaredParam=JvmFormalParameter
	 *     (rule start) (ambiguity) 'switch' switch=XExpression
	 *     (rule start) (ambiguity) 'synchronized' '(' param=XExpression
	 *     (rule start) (ambiguity) 'throw' expression=XExpression
	 *     (rule start) (ambiguity) 'try' expression=XExpression
	 *     (rule start) (ambiguity) 'typeof' '(' type=[JvmType|QualifiedName]
	 *     (rule start) (ambiguity) 'while' '(' predicate=XExpression
	 *     (rule start) (ambiguity) '{' '}' ')' (rule start)
	 *     (rule start) (ambiguity) '{' expressions+=XExpressionOrVarDeclaration
	 *     (rule start) (ambiguity) feature=[JvmIdentifiableElement|FeatureCallID]
	 *     (rule start) (ambiguity) feature=[JvmIdentifiableElement|IdOrSuper]
	 *     (rule start) (ambiguity) feature=[JvmIdentifiableElement|OpUnary]
	 *     (rule start) (ambiguity) isTrue?='true'
	 *     (rule start) (ambiguity) value=Number
	 *     (rule start) (ambiguity) value=STRING
	 *     (rule start) (ambiguity) {XAssignment.assignable=}
	 *     (rule start) (ambiguity) {XBinaryOperation.leftOperand=}
	 *     (rule start) (ambiguity) {XCastedExpression.target=}
	 *     (rule start) (ambiguity) {XInstanceOfExpression.expression=}
	 *     (rule start) (ambiguity) {XMemberFeatureCall.memberCallTarget=}
	 *     (rule start) (ambiguity) {XPostfixOperation.operand=}
	 */
	protected void emit_XParenthesizedExpression_LeftParenthesisKeyword_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}