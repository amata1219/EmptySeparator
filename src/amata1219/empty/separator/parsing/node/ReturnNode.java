package amata1219.empty.separator.parsing.node;

public class ReturnNode extends Node {

	public final Node value;

	public ReturnNode(Node value) {
		super(NodeType.RETURN);
		this.value = value;
	}

}
