package sorting;
import java.util.Random;

/**
 * @author Tony
 */
public abstract class QuickSortBase extends SorterBase 
{
	/**
	 * Shuffles the array provided to ensure it is not already sorted
	 * @param target the array to shuffle
	 */
	@SuppressWarnings("rawtypes")
	protected void shuffle(Comparable[] target)
	{
		Random r = new Random();
		for (int i = 0; i < target.length/2; i++)
		{
			int from = r.nextInt(target.length);
			int to = r.nextInt(target.length);
			swap(target, from, to);
		}
	}
}