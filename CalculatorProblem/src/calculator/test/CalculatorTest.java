package calculator.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.gradescope.jh61b.grader.GradedTest;

import calculator.Calculator;
import calculator.Commands;
import ledger.LoggedTest;

/**
 * @author Tony
 */
public class CalculatorTest extends LoggedTest
{
	Commands commands = new Commands();
	
	private void runTests(Calculator uut, String[][] testCases)
	{
	    for (String[] testCase : testCases)
	    {
	        String input = testCase[0];
	        String expected = testCase[1];
	        String actual = uut.processCommand(commands.parseInput(input));
	        assertEquals(expected, actual);
	    }
	}
	
	@Test		
    @GradedTest(name="Test simple statements", max_score=5)
    public void testSimple() 
    {
		Calculator uut = new Calculator();
	    String[][] testCases =
	    { {"2 2 +","4.0"},
	      {"2 2 -","0.0"},
	      {"2 2 *","4.0"},
	      {"2 2 /","1.0"} };
	    runTests(uut, testCases);
    }

	@Test		
    @GradedTest(name="Test compund statements", max_score=10)
    public void testCompound() 
    {
		Calculator uut = new Calculator();
	    String[][] testCases =
	    { {"4 8 3 * +","28.0"},
	      {"4 8 + 3 *","36.0"},
	      {"78 30 0.5 28 8 + * - 6 / +","80.0"},
	      {"2.1 2 ^ 5.2 + 7.2 - 7.1 *","17.110999999999994"},
	      {"2 20 * 2 / 3 4 + 3 2 ^ * + 6 - 15 +","92.0"} };
	    runTests(uut, testCases);
    }

	@Test		
    @GradedTest(name="Test invalid statements", max_score=5)
    public void testInvalid() 
    {
		Calculator uut = new Calculator();
	    String[][] testCases =
	    { {"2 2 +","4.0"}, // To avoid all invalid
	      {"2 + 2", Calculator.INVALID_MESSAGE},
	      {"2 2 2 +", Calculator.INVALID_MESSAGE} };
	    runTests(uut, testCases);
    }
	
	private static final String CODE_FILE= "src/calculator/Calculator";
	@BeforeClass
	public static void grabCode()
	{
		LoggedTest.grabCode(CODE_FILE);
	}
}