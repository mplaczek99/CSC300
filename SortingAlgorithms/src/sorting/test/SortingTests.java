package sorting.test;
import static org.junit.Assert.assertFalse;

import java.util.Arrays;
import java.util.Random;

import ledger.LoggedTest;
import sorting.Sorter;

@SuppressWarnings("rawtypes")
public class SortingTests extends LoggedTest
{
	protected static final int TEST_SIZE = 10;
	private final Random r = new Random(); 
	
	private Character[] createRandomTester(int size)
	{
		Character[] tester = new Character[size];
		for (int i = 0; i < size; i++)
		{
			tester[i] = (char) ('A' + r.nextInt(26));
		}
		return tester;
	}
	
	protected TestCase setupRandomTest(int size)
	{
		TestCase test = new TestCase();
		test.original = createRandomTester(size);
		test.expected = Arrays.copyOf(test.original, size);
		Arrays.sort(test.expected);
		return test;
	}
	
	@SuppressWarnings("unchecked")
	protected void testSort(Sorter sorter, TestCase test)
	{
		Comparable[] testCase = test.getTestCase();

		sorter.sort(testCase);
		for (int i = 1; i < testCase.length; i++)
		{
			assertFalse("Array is not sorted\n" +
					    "Original : " + Arrays.toString(test.original) + "\n" +
					    "Your sort: " + Arrays.toString(testCase) + "\n" +
					    "Target   : " + Arrays.toString(test.expected), 
					    testCase[i].compareTo(testCase[i-1]) < 0);
		}
	}
}