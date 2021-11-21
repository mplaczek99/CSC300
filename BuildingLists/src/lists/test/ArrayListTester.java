package lists.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.gradescope.jh61b.grader.GradedTest;

import ledger.LoggedTest;
import lists.MyArrayList;
import lists.SimplifiedList;

/**
 * @author Tony
 */
public class ArrayListTester extends BaseListTester
{
	@Test		
    @GradedTest(name="Test load performance", max_score=5)
    public void testLoad()
    {
		SimplifiedList uut = getUUT();
		List<String> exemplar = getExemplar();
		for (int i =0; i < 1000; i++)
		{
			assertTrue("Did not report success on add", uut.add(i+""));
			exemplar.add(i+"");
			assertEquals("Size was not expected", exemplar.size(), uut.size());
		}
    }
	
	@Override
	protected SimplifiedList getUUT()
	{
		return new MyArrayList();
	}

	@Override
	protected List<String> getExemplar()
	{
		return new ArrayList<>();
	}
	
	private static final String CODE_FILE= "src/lists/MyArrayList";
	@BeforeClass
	public static void grabCode()
	{
		LoggedTest.grabCode(CODE_FILE);
	}
}