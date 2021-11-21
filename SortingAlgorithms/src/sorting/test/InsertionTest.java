package sorting.test;

import org.junit.BeforeClass;
import org.junit.Test;

import com.gradescope.jh61b.grader.GradedTest;

import ledger.LoggedTest;
import sorting.InsertionSort;
import sorting.Sorter;
import sorting.test.timing.TimingTests;

public class InsertionTest extends TimingTests
{
	public InsertionTest()
	{
		this.tests = new Sorter[]{new InsertionSort()};
		super.numberOfItemsToSort = 10000;
	}
	
	@Test
    @GradedTest(name="Test simple statements", max_score=10)
    public void testSimple() 
    {
		super.testSort(new InsertionSort(), super.setupRandomTest(TEST_SIZE));
    }	
	
	private static final String CODE_FILE= "src/sorting/InsertionSort";
	@BeforeClass
	public static void grabCode()
	{
		LoggedTest.grabCode(CODE_FILE);
	}
}