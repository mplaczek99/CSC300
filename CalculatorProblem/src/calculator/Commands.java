package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author Tony
 */
public class Commands
{
	Calculator c = new Calculator();

	private void runUI()
	{
	    @SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
	    
	    System.out.println("Welcome to the Calculator");
	    while (true)
	    {
	        System.out.print("calc>>");
	        String input = in.nextLine();
	        if ("quit".equals(input) || "q".equals(input))
	        {
	            break;
	        }
	
	        List<String> commands = parseInput(input);
	        if (commands.size() == 0)
	        {
	            System.out.println("Your command was invalid");
	            System.out.println("Enter a valid post-fix expression to process or quit to end the program");
	        }
	        else
	        {
	            System.out.println(c.processCommand(commands));
	        }
	    }
	}	

	/**
	 * Parse the input value into a series of numbers and valid operators
	 *   input - any String that might be a calculator command
	 *  returns a vector including a sequence of numbers and operators, or an empty vector 
	 *         if the input included invalid elements
	 */
	public List<String> parseInput(String input)
	{
	    List<String> commands = new ArrayList<String>();
	    StringTokenizer tokens = new StringTokenizer(input, " ");
	    
	    CheckTokens:
	    while (tokens.hasMoreTokens())
	    {
	    	String token = tokens.nextToken().trim();
	    	if (c.isDouble(token))
	    	{
                commands.add(token);
                continue; // It's a number, move on to the next token
	    	}
	    	
	        for (Operator op : Operator.values())
	        {
	            if (token.equals(op.label))
	            {
	                commands.add(token);
	                continue CheckTokens;
	            }
	        }
            commands.clear();
            break;
	    }
	    return commands;
	}

	/**
	 * The main method for the program, calls the test cases and then presents the user with the UI
	 */
	public static void main(String args[])
	{
		new Commands().runUI();
	}
}