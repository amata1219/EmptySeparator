package amata1219.empty.separator.parsing.node;

public class ConditionalStatementNode extends Node {

	public final Node condition, then, e1se;

	public ConditionalStatementNode(Node condition, Node then, Node e1se) {
		super(NodeType.IF);
		this.condition = condition;
		this.then = then;
		this.e1se = e1se;
	}

}
