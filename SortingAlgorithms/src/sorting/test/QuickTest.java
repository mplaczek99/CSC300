package sorting.test;

import org.junit.BeforeClass;
import org.junit.Test;

import com.gradescope.jh61b.grader.GradedTest;

import ledger.LoggedTest;
import sorting.QuickSort;
import sorting.Sorter;
import sorting.test.timing.TimingTests;

public class QuickTest extends TimingTests
{
	public QuickTest()
	{
		this.tests = new Sorter[]{new QuickSort()};
	}
	
	@Test
    @GradedTest(name="Test simple statements", max_score=20)
    public void testSimple() 
    {
		super.testSort(new QuickSort(), super.setupRandomTest(TEST_SIZE));
    }	
	
	private static final String CODE_FILE= "src/sorting/QuickSort";
	@BeforeClass
	public static void grabCode()
	{
		LoggedTest.grabCode(CODE_FILE);
	}
}