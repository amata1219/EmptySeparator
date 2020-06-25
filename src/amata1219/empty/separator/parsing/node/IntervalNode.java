package amata1219.empty.separator.parsing.node;

public class IntervalNode extends Node {

	public final Node lower, upper;

	public IntervalNode(Node lower, Node upper) {
		super(NodeType.INTERVAL);
		this.lower = lower;
		this.upper = upper;
	}

}
