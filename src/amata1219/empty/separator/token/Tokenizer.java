package amata1219.empty.separator.token;

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
		"else",
		"elif",
		"for",
		"while",
		"loop",
		"skip",
		"break"
	));

	private static final String LINE_FEED_CODE = "\r\n";

	private final String source;
	private int index, line;

	public Tokenizer(String source){
		this.source = source;
	}

	public Token tokenize(){
		Token head = new Token(null, null);
		Token current = head;

		label: while(index < source.length()){
			if(Character.isWhitespace(source.charAt(index))){
				index++;
				continue;
			}

			if(source.startsWith(LINE_FEED_CODE, index)){
				current = new ReservedWordToken(current, LINE_FEED_CODE);
				index += 2;
				line++;
				continue;
			}

			for(String reserved : RESERVED_WORDS) if(source.startsWith(reserved, index)){
				current = new ReservedWordToken(current, reserved);
				index += reserved.length();
				continue label;
			}

			String identifier = conditionallySliceSource(Character::isAlphabetic);
			if(identifier != null){
				current = new IdentifierToken(current, identifier);
				index += identifier.length();
				continue;
			}

			String number = conditionallySliceSource(Character::isDigit);
			if(number != null){
				current = new NumericToken<Integer>(current, Integer.parseInt(number));
				index += number.length();
				continue;
			}

			String[] lines = source.split(LINE_FEED_CODE);

			int indexOfProblematicLine = index - IntStream.range(0, line - 1)
					.map(i -> lines[i].length())
					.sum();

			String indicator = Stream.generate(() -> " ")
					.limit(indexOfProblematicLine)
					.collect(Collectors.joining()) + "^";

			printlnForEachText(
				"at (line, index) = (" + line + ", " + indexOfProblematicLine + ")",
				lines[line],
				indicator
			);
		}

		return head.next();
	}

	private String conditionallySliceSource(Predicate<Character> condition){
		int current = index;
		while(current < source.length() && condition.test(source.charAt(current))) current++;
		return current == index ? null : source.substring(index, current);
	}

	private void printlnForEachText(String... texts){
		for(String text : texts) System.out.println(text);
	}

}
