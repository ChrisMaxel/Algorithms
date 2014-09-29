package collection.list.ex;

import collection.list.Stack;

/**
 * @author Andrei Petraru 12 Aug 2013
 */
public class Parentheses {

	private static final char L_PAREN = '(';
	private static final char R_PAREN = ')';
	private static final char L_BRACE = '{';
	private static final char R_BRACE = '}';
	private static final char L_BRACKET = '[';
	private static final char R_BRACKET = ']';

	private static final Stack<Character> stack = new Stack<>();

	/**
	 * Checks to see if a text containing only braces is balanced or not
	 *
	 * @param text the text containing braces
	 * @return true if the braces are balanced, false otherwise
	 * @throws IllegalArgumentException if the text contains something other than braces
	 */
	public static boolean isBalanced(String text) {
		if (text == null) {
			return false;
		}

		for (char letter : text.toCharArray()) {
			switch (letter) {
				case L_PAREN:
				case L_BRACE:
				case L_BRACKET:
					stack.push(letter);
					break;
				case R_PAREN:
					return !checkStack(L_PAREN);
				case R_BRACE:
					return !checkStack(L_BRACE);
				case R_BRACKET:
					return !checkStack(L_BRACKET);
				default:
					throw new IllegalArgumentException("Non brace character found");
			}
		}
		return true;
	}

	private static boolean checkStack(char c) {
		return stack.isEmpty() || stack.pop() != c;
	}
}
