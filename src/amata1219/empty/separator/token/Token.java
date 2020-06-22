package amata1219.empty.separator.token;

public class Token {

	public final TokenType type;
	private Token next;

	public Token(TokenType type, Token current){
		this.type = type;
		if(current != null) current.next = this;
	}

	public Token next(){
		return next;
	}

}
