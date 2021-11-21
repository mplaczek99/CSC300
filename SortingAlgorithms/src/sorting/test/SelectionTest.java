package sorting.test;

import org.junit.BeforeClass;
import org.junit.Test;

import com.gradescope.jh61b.grader.GradedTest;

import ledger.LoggedTest;
import sorting.SelectionSort;
import sorting.Sorter;
import sorting.test.timing.TimingTests;

public class SelectionTest extends TimingTests
{
	public SelectionTest()
	{
		this.tests = new Sorter[]{new SelectionSort()};
		super.numberOfItemsToSort = 10000;
	}
	
	@Test
    @GradedTest(name="Test simple statements", max_score=10)
    public void testSimple() 
    {
		super.testSort(new SelectionSort(), super.setupRandomTest(TEST_SIZE));
    }	
	
	private static final String CODE_FILE= "src/sorting/SelectionSort";
	@BeforeClass
	public static void grabCode()
	{
		LoggedTest.grabCode(CODE_FILE);
	}
}