package sorting;

/**
 * @author Michael Placzek
 */
public class InsertionSort extends SorterBase 
{
	@SuppressWarnings("rawtypes")
	@Override
	public void sort(Comparable[] target) 
	{
		int length = target.length;

		for (int i = 1; i < length; i ++) {
			for (int j = i; j > 0 && less(target[j], target[j - 1]); j --) {
				swap(target, j, j - 1);
			}
		}
	}
}