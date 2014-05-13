package collection.list.ex;

import collection.list.Stack;


/**
 * @author Andrei Petraru
 * 12 Aug 2013
 */
public class Parentheses {
	private static final char L_PAREN = '(';
	private static final char R_PAREN = ')';
	private static final char L_BRACE = '{';
	private static final char R_BRACE = '}';
	private static final char L_BRACKET = '[';
	private static final char R_BRACKET = ']';
	
	private static Stack<Character> stack = new Stack<>();

	/**
	 * Checks to see if a text containing only braces is balanced or not
	 * @param text the text containing braces
	 * @return true if the braces are balanced, false otherwise
	 * @throws IllegalArgumentException if the text contains something other than braces 
	 */
	public static boolean isBalanced(String text) {
		if (text == null) {
			return false;
		}

		for (int i = 0; i < text.length(); i++) {
			char letter = text.charAt(i);
			switch (letter) {
			case L_PAREN:
				stack.push(letter);
				break;
			case L_BRACE:
				stack.push(letter);
				break;
			case L_BRACKET:
				stack.push(letter);
				break;
			case R_PAREN:
				if (checkStack(L_PAREN)) {
					return false;
				}
				break;
			case R_BRACE:
				if (checkStack(L_BRACE)) {
					return false;
				}
				break;
			case R_BRACKET:
				if (checkStack(L_BRACKET)) {
					return false;
				}
				break;
			default:
				throw new IllegalArgumentException("Non brace character found");
			}
		}
		return true;
	}

	private static boolean checkStack(char c) {
		if (stack.isEmpty() || stack.pop() != c) {
			return true;
		}
		return false;
	}
}
