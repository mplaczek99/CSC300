package sorting.test;

import org.junit.BeforeClass;
import org.junit.Test;

import com.gradescope.jh61b.grader.GradedTest;

import ledger.LoggedTest;
import sorting.ShellSort;
import sorting.Sorter;
import sorting.test.timing.TimingTests;

public class ShellTest extends TimingTests
{
	public ShellTest()
	{
		this.tests = new Sorter[]{new ShellSort()};
	}
	
	@Test
    @GradedTest(name="Test simple statements", max_score=15)
    public void testSimple() 
    {
		super.testSort(new ShellSort(), super.setupRandomTest(TEST_SIZE));
    }	
	
	private static final String CODE_FILE= "src/sorting/ShellSort";
	@BeforeClass
	public static void grabCode()
	{
		LoggedTest.grabCode(CODE_FILE);
	}
}