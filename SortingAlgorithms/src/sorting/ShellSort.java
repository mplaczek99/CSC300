package sorting;

/**
 * @author Michael Placzek
 */
public class ShellSort extends SorterBase
{
	@SuppressWarnings("rawtypes")
	@Override
	public void sort(Comparable[] target) 
	{
		int length = target.length;

		// Start with a big gap, then make gap smaller over time
		for (int gap = length / 2; gap > 0; gap /= 2)
		{
			// The first gap elements are already in order
			// so keep adding one more element until entire array
			// is sorted
			for (int i = gap; i < length; i += 1)
			{
				// saves target[i] as temp
				Comparable temp = target[i];
				int j = i; // may not be necessary to save i

				// shift earlier sorted elements until
				// the correct location for target[i] is found
				while (j >= gap && less(temp, target[j - gap])) {
					swap(target, j, j - gap);
					j -= gap;
				}

				// put temp in its correct location
				target[j] = temp;
			}
		}
	}
}