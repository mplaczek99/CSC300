package calculator;

import java.util.List;

/**
 * @author <Your Name Here>
 */
public class Calculator 
{
	public static final String INVALID_MESSAGE = "Invalid Command";
	
	/**
	 * Process the calculator command assuming post-fix notation
	 *    commands - a vector that is assured to be numbers (doubles) or valid operators
	 *  returns a String that is either the computed number or the INVALID_MESSAGE constant
	 */
	public String processCommand(List<String> commands)
	{
	    // Use a stack to process the incoming user command
	    // The user entry has been broken into a vector of Strings.  Each String is assured to be
	    //  1.) a number
	    //  2.) a valid operator from the operators above
	    // The inputs will NOT BE invalid themselves, but they may not amount to a valid command.
	    // For instance, 2+2 would be blocked, but 2 + 2 could come through and would be invalid 
	    // since it is not in post-fix notation.  
	    //
	    //  Your task is to process the command into a single numerical response and return that response
	    //  as a String (no formatting required).  If the command is invalid, return the constant INVALID_MESSAGE
		return INVALID_MESSAGE;
	}	
	
	/**
	 * Check if a String value is indeed a double 
	 *    value - the value to check
	 *  returns true if the number is a double, false otherwise
	 */
	public boolean isDouble(String value)
	{
	    try
	    {
	        Double.parseDouble(value);
	        return true;
	    } catch (Exception e) {}
	    return false;
	}
}