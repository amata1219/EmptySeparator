package amata1219.empty.separator.tokenization;

public class Token<V> {

	public final TokenType type;
	public final V value;
	private Token<?> next;

	public Token(TokenType type, V value, Token<?> current){
		this.type = type;
		this.value = value;
		if(current != null) current.next = this;
	}

	public Token(TokenType type, Token<?> current){
		this(type, null, current);
	}

	public Token<?> next(){
		return next;
	}

}
