package amata1219.empty.separator.tokenization;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Tokenizer {

	private static final List<String> RESERVED_WORDS = Collections.unmodifiableList(Arrays.asList(
		"+",
		"-",
		"*",
		"/",
		"%",
		"!",
		"=",
		"≠",
		">",
		"≧",
		"<",
		"≦",
		"::",
		",",
		":",
		"(",
		")",
		"[",
		"]",
		"{",
		"}",
		"T",
		"F",
		"if",
		"elif",
		"else",
		"for",
		"while",
		"loop",
		"return",
		"break",
		"skip"
	));

	private static final String LINE_FEED_CODE = "\r\n";

	private final String source;
	private int index, line;

	public Tokenizer(String source){
		this.source = source;
	}

	public Token<?> tokenize(){
		Token<?> head = new Token<>(null, null, null);
		Token<?> current = head;

		label: while(index < source.length()){
			if(Character.isWhitespace(source.charAt(index))){
				index++;
				continue;
			}

			if(source.startsWith(LINE_FEED_CODE, index)){
				current = new Token<>(TokenType.RESERVED_WORD, LINE_FEED_CODE, current);
				index += 2;
				line++;
				continue;
			}

			for(String reserved : RESERVED_WORDS) if(source.startsWith(reserved, index)){
				current = new Token<>(TokenType.RESERVED_WORD, reserved, current);
				index += reserved.length();
				continue label;
			}

			String identifier = conditionallySliceSource(Character::isAlphabetic);
			if(identifier != null){
				current = new Token<>(TokenType.IDENTIFIER, identifier, current);
				index += identifier.length();
				continue;
			}

			String number = conditionallySliceSource(Character::isDigit);
			if(number != null){
				current = new Token<>(TokenType.NUMBER, number, current);
				index += number.length();
				continue;
			}

			String[] lines = source.split(LINE_FEED_CODE);

			int problematicLineIndex = index - IntStream.range(0, line - 1)
					.map(i -> lines[i].length())
					.sum();

			String indicator = Stream.generate(() -> " ")
					.limit(problematicLineIndex)
					.collect(Collectors.joining()) + "^";

			Arrays.asList(
				lines[line],
				indicator,
				"at (line, index) = (" + line + ", " + problematicLineIndex + ")"
			)
			.forEach(System.out::println);
		}

		return head.next();
	}

	private String conditionallySliceSource(Predicate<Character> condition){
		int current = index;
		while(current < source.length() && condition.test(source.charAt(current))) current++;
		return current == index ? null : source.substring(index, current);
	}

}
