package amata1219.empty.separator.parsing.node;

import java.util.List;

public class FunctionCallNode extends Node {

	public final String functionIdentifier;
	public final List<VariableNode> arguments;

	public FunctionCallNode(String functionIdentifier, List<VariableNode> arguments) {
		super(NodeType.FUNCTION_CALL);
		this.functionIdentifier = functionIdentifier;
		this.arguments = arguments;

	}

}
