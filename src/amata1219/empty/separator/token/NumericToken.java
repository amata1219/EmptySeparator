package amata1219.empty.separator.token;

public class NumericToken<N extends Number> extends Token {

	public final N number;

	protected NumericToken(Token current, N  number) {
		super(TokenType.NUMBER, current);
		this.number = number;
	}

}
