package sorting.test.timing;

import java.util.Arrays;

import org.junit.Test;

import com.gradescope.jh61b.grader.GradedTest;

import sorting.BubbleSort;
import sorting.HeapSort;
import sorting.InsertionSort;
import sorting.MergeSort;
import sorting.QuickSort;
import sorting.SelectionSort;
import sorting.ShellSort;
import sorting.Sorter;
import sorting.test.SortingTests;
import sorting.test.TestCase;

/**
 * @author Tony
 */
public class TimingTests extends SortingTests
{
	protected int numberOfItemsToSort = 1000000;
	protected int numberofRepeatedTests = 3;
	protected Sorter[] tests = {
                              new ShellSort(), 
                              new MergeSort(), 
                              new HeapSort(), 
                              new QuickSort(),
							  new BubbleSort(), 
							  new InsertionSort(), 
							  new SelectionSort(), 
                             };

	@SuppressWarnings("rawtypes")
	protected long timeSort(Sorter sorter, Comparable[] testMe)
	{
		long start = System.currentTimeMillis();
		sorter.sort(testMe);
		return System.currentTimeMillis() - start;
	}

	protected TestCase setupOrdered(int size)
	{
		TestCase test = new TestCase();
		Integer[] sorted = new Integer[size];
		for (int i = 0; i < sorted.length; i++)
		{
			sorted[i] = i;
		}
		test.original = sorted;
		test.expected = sorted;
		return test;
	}

	protected TestCase setupInverse(int size)
	{
		TestCase test = new TestCase();
		Integer[] inverse = new Integer[size];
		for (int i = 0; i < inverse.length; i++)
		{
			inverse[i] = inverse.length - i;
		}
		test.original = inverse;
		test.expected = Arrays.copyOf(inverse, inverse.length);
		Arrays.sort(test.expected);
		return test;
	}

	public Timing testTiming(Sorter sorter, TestCase random, TestCase ordered, TestCase inverseOrdered)
	{
		Timing timings = new Timing();
		timings.sorter = sorter;
		timings.randomized = timeSort(sorter, random.getTestCase());
		timings.sorted = timeSort(sorter, ordered.getTestCase());

		timings.inverseSorted = timeSort(sorter, inverseOrdered.getTestCase());
		return timings;
	}

	@Test
    @GradedTest(name="Timing Results", max_score=0)
	public void testTiming() 
	{
		TestCase random  = setupRandomTest(numberOfItemsToSort);
		TestCase ordered = setupOrdered(numberOfItemsToSort);
		TestCase inverted = setupInverse(numberOfItemsToSort);
		for (Sorter s : tests)
		{
			Timings total = new Timings();
			for (int i = 0; i < numberofRepeatedTests; i++)
			{
				Timing t = testTiming(s, random, ordered, inverted);
				total.add(t);
			}
			System.out.println(total);
			System.out.println();
		}
	}	
}