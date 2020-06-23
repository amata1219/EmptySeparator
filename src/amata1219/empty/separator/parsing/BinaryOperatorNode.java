package amata1219.empty.separator.parsing;

public class BinaryOperatorNode extends Node {

	public final Node lhs, rhs;

	public BinaryOperatorNode(NodeType type, Node lhs, Node rhs){
		super(type);
		this.lhs = lhs;
		this.rhs = rhs;
	}

}
