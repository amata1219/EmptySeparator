package amata1219.empty.separator.parsing.node;

public class VariableNode extends Node {

	public final int offset;

	public VariableNode(int offset) {
		super(NodeType.VARIABLE);
		this.offset = offset;
	}

}
