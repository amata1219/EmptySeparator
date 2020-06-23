package amata1219.empty.separator.parsing;

import java.util.List;

public class CallingFunctionNode extends Node {

	public final String functionIdentifier;
	public final List<VariableNode> arguments;

	public CallingFunctionNode(String functionIdentifier, List<VariableNode> arguments) {
		super(NodeType.CALLING_FUNCTION);
		this.functionIdentifier = functionIdentifier;
		this.arguments = arguments;

	}

}
