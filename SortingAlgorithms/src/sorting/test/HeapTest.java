package sorting.test;

import org.junit.BeforeClass;
import org.junit.Test;

import com.gradescope.jh61b.grader.GradedTest;

import ledger.LoggedTest;
import sorting.HeapSort;
import sorting.Sorter;
import sorting.test.timing.TimingTests;

public class HeapTest extends TimingTests
{
	public HeapTest()
	{
		this.tests = new Sorter[]{new HeapSort()};
	}
	
	@Test		
    @GradedTest(name="Test simple statements", max_score=10)
    public void testSimple() 
    {
		super.testSort(new HeapSort(), super.setupRandomTest(TEST_SIZE));
    }	
	
	private static final String CODE_FILE= "src/sorting/HeapSort";
	@BeforeClass
	public static void grabCode()
	{
		LoggedTest.grabCode(CODE_FILE);
	}
}