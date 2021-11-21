package sorting.test;

import org.junit.BeforeClass;
import org.junit.Test;

import com.gradescope.jh61b.grader.GradedTest;

import ledger.LoggedTest;
import sorting.BubbleSort;
import sorting.Sorter;
import sorting.test.timing.TimingTests;

/**
 * @author Tony
 */
public class BubbleTest extends TimingTests
{
	public BubbleTest()
	{
		this.tests = new Sorter[]{new BubbleSort()};
		super.numberOfItemsToSort = 10000;
	}
	
	@Test		
    @GradedTest(name="Test simple statements", max_score=5)
    public void testSimple() 
    {
		super.testSort(new BubbleSort(), super.setupRandomTest(TEST_SIZE));
    }	
	
	private static final String CODE_FILE= "src/sorting/BubbleSort";
	@BeforeClass
	public static void grabCode()
	{
		LoggedTest.grabCode(CODE_FILE);
	}
}