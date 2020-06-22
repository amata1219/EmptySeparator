package amata1219.empty.separator.token;

public class IdentifierToken extends Token {

	public final String identifier;

	public IdentifierToken(Token current, String identifier) {
		super(TokenType.IDENTIFIER, current);
		this.identifier = identifier;
	}

}
