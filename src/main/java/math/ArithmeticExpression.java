package math;

import java.util.Stack;

/**
 * @author Andrei Petraru
 *         29 Sep 2014
 */
public class ArithmeticExpression {
	private static final char LEFT_PARENTHESES = '(';
	private static final char RIGHT_PARENTHESES = ')';
	private static final char LEFT_BRACE = '{';
	private static final char RIGHT_BRACE = '}';
	private static final char LEFT_BRACKET = '[';
	private static final char RIGHT_BRACKET = ']';

	private static final String LEFT_PARENTHESES_STRING = "(";
	private static final String RIGHT_PARENTHESES_STRING = ")";
	private static final String PLUS = "+";
	private static final String MINUS = "-";
	private static final String MULTIPLY = "*";
	private static final String DIVIDE = "/";
	private static final String SQRT = "sqrt";

	/**
	 * Computes the value of an arithmetical expression
	 *
	 * @param expression a valid arithmetic expression
	 * @return the value of the computed expresison
	 */
	public static double compute(String expression) {
		Stack<String> ops = new Stack<>();
		Stack<Double> vals = new Stack<>();
		String noSpaces = stripSpaces(expression);
		for (char c : noSpaces.toCharArray()) {
			String s = String.valueOf(c);
			switch (s) {
				case LEFT_PARENTHESES_STRING:
					break;
				case PLUS:
				case MINUS:
				case MULTIPLY:
				case DIVIDE:
				case SQRT:
					ops.push(s);
					break;
				case RIGHT_PARENTHESES_STRING:
					String op = ops.pop();
					double val = vals.pop();
					switch (op) {
						case PLUS:
							val = vals.pop() + val;
							break;
						case MINUS:
							val = vals.pop() - val;
							break;
						case MULTIPLY:
							val = vals.pop() * val;
							break;
						case DIVIDE:
							val = vals.pop() / val;
							break;
						case SQRT:
							val = Math.sqrt(val);
							break;
					}
					vals.push(val);
					break;
				default:
					vals.push(Double.parseDouble(s));
					break;
			}
		}
		return vals.pop();
	}

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
		Stack<Character> stack = new Stack<>();
		for (Character letter : text.toCharArray()) {
			switch (letter) {
				case LEFT_PARENTHESES:
				case LEFT_BRACE:
				case LEFT_BRACKET:
					stack.push(letter);
					break;
				case RIGHT_PARENTHESES:
					return !checkStack(stack, LEFT_PARENTHESES);
				case RIGHT_BRACE:
					return !checkStack(stack, LEFT_BRACE);
				case RIGHT_BRACKET:
					return !checkStack(stack, LEFT_BRACKET);
				default:
					throw new IllegalArgumentException("Non brace character found");
			}
		}
		return true;
	}

	private static String stripSpaces(String s) {
		return s.replaceAll("\\s+", "");
	}

	private static boolean checkStack(Stack<Character> stack, char c) {
		return stack.isEmpty() || stack.pop() != c;
	}
}
