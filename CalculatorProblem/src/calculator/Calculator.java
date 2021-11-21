package calculator;

import java.util.List;
import java.util.Stack;

/**
 * @author Michael Placzek
 */
public class Calculator {
	public static final String INVALID_MESSAGE = "Invalid Command";

	/**
	 * Process the calculator command assuming post-fix notation commands - a vector
	 * that is assured to be numbers (doubles) or valid operators returns a String
	 * that is either the computed number or the INVALID_MESSAGE constant
	 */
	public String processCommand(List<String> commands) {
		Stack<String> stack = new Stack<>();

		// Make a stack for the command
		for (String command : commands) {
			if (isDouble(command)) {
				stack.push(command);
			} else {
				try {
					// gets last two items from the stack
					double item2 = Double.parseDouble(stack.pop());
					double item1 = Double.parseDouble(stack.pop());
					String result;

					// ... does some math
					if (command.equals(Operator.ADD.label)) {
						result = Double.toString(item1 + item2);
					} else if (command.equals(Operator.SUBTRACT.label)) {
						result = Double.toString(item1 - item2);
					} else if (command.equals(Operator.MULTIPLY.label)) {
						result = Double.toString(item1 * item2);
					} else if (command.equals(Operator.DIVIDE.label)) {
						result = Double.toString(item1 / item2);
					} else { // command is ^
						result = Double.toString(Math.pow(item1, item2));
					}

					// ... and pushes the result of the math of the items
					stack.push(result);
				} catch (Exception e) {
					return INVALID_MESSAGE;
				}
			}
		}

		if (stack.size() > 1) {
			return INVALID_MESSAGE;
		}
		return stack.peek();
	}

	/**
	 * Check if a String value is indeed a double value - the value to check returns
	 * true if the number is a double, false otherwise
	 */
	public boolean isDouble(String value) {
		try {
			Double.parseDouble(value);
			return true;
		} catch (Exception ignored) {
		}
		return false;
	}
}