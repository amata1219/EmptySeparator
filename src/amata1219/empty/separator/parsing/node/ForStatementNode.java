package amata1219.empty.separator.parsing.node;

public class ForStatementNode extends Node {

	public final Node initialization, condition, update, body;

	public ForStatementNode(Node initialization, Node condition, Node update, Node body) {
		super(NodeType.FOR);
		this.initialization = initialization;
		this.condition = condition;
		this.update = update;
		this.body = body;
	}

}
