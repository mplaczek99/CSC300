# CalculatorProblem

Getting Started

A classic example of a problem that uses Stacks is the calculator problem.   In this problem, you will write the engine for a calculator that processes ‘ postfix’ commands.  The traditional method of representing math statements is called ‘in-fix’ notation, such as:

	2 + 2
	4 + 8 * 3
	
However, a postfix version would be:

	2 2 +
	4 8 3 * +
	
In the postfix scheme, the operation comes after the two numbers involved, not between them.  The postfix notation was common for a time in some calculators but is not common in computing as we learn in-fix notation, and that is what is familiar.  Post-fix processing is relatively simple; the math operation occurs on the prior two numbers (possibly taken from another operation).  The postfix approach avoids confusion over operator precedence by taking advantage of the concept of a stack.  
Your task in completing the calculator only requires completing a single method (you can create more as helpers to your method!).   The calculator user interface framework already exists, but you must complete the processCommand method within the Calculator class.  The only other code in the Calculator class is a helper method to determine if a string input is a Double or not.  The processCommand method takes a list of individual strings guaranteed to be only numbers and valid operators.  For example, the list might contain the strings “2”, “2”, and “+”.  Your could should process the strings and return the answer as a string.  

While the supporting code filters invalid inputs, it does not process if valid inputs are in an invalid order.  For instance, your code could receive “2”, “+”, and “2”, which is not valid for postfix notation, and thus your code should return the constant value INVALID_MESSAGE.   Likewise, if a command does not resolve to a single number, the input was invalid.  

Testing your code

Your code is ‘finished’ when it passes the provided unit tests.  The unit tests include simple, compound, and invalid test cases, but feel free to focus on one test at a time.  The Commands class includes a main method that will run the calculator as a command-line application if you wish to test specific inputs different from the test case.

Additional Hints

Before using the following resource, try your best to solve the problem.  If you are hopelessly stuck, use the following website that offers a spectacular visualization for the process of using stacks to process postfix commands.  If you look at this website, remember to mention that in your cover sheet!
https://www.free-online-calculator-use.com/postfix-evaluator.html#
