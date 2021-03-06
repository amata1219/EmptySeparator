package amata1219.empty.separator.parsing.node;

public enum NodeType {

	NUMBER,
	IDENTIFIER,
	INTERVAL,

	ADDITION,
	SUBTRACTION,
	MULTIPLICATION,
	DIVISION,
	MODULO,

	ASSIGNMENT,
	EQUAL,
	UNEQUAL,
	LESS_THAN,
	LESS_THAN_OR_EQUAL,

	IF,
	FOR,
	FOR_EACH,
	WHILE,
	LOOP,
	RETURN,
	BREAK,
	SKIP,
	BLOCK,

	VARIABLE,
	FUNCTION_DECLARER,
	FUNCTION_CALL;

}
