package sorting.test;

import org.junit.BeforeClass;
import org.junit.Test;

import com.gradescope.jh61b.grader.GradedTest;

import ledger.LoggedTest;
import sorting.MergeSort;
import sorting.Sorter;
import sorting.test.timing.TimingTests;

public class MergeTest extends TimingTests
{
	public MergeTest()
	{
		this.tests = new Sorter[]{new MergeSort()};
	}
	
	@Test
    @GradedTest(name="Test simple statements", max_score=20)
    public void testSimple() 
    {
		super.testSort(new MergeSort(), super.setupRandomTest(TEST_SIZE));
    }	
	
	private static final String CODE_FILE= "src/sorting/MergeSort";
	@BeforeClass
	public static void grabCode()
	{
		LoggedTest.grabCode(CODE_FILE);
	}
}