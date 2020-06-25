package amata1219.empty.separator.parsing.node;

public class BlockNode extends Node {

	public final Node block;

	public BlockNode(Node block) {
		super(NodeType.BLOCK);
		this.block = block;
	}

}
