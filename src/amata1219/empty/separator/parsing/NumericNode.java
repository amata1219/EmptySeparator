package amata1219.empty.separator.parsing;

public class NumericNode extends Node {

	public final int number;

	protected NumericNode(int number) {
		super(NodeType.NUMBER);
		this.number = number;
	}

}
