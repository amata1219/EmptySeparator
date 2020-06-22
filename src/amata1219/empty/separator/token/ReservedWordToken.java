package amata1219.empty.separator.token;

public class ReservedWordToken extends Token {

	public final String keyword;

	public ReservedWordToken(Token current, String keyword) {
		super(TokenType.RESERVED_WORD, current);
		this.keyword = keyword;
	}

}
