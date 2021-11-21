package sorting;

/**
 * @author Michael Placzek
 */
public class BubbleSort extends SorterBase 
{
	@SuppressWarnings("rawtypes")
	@Override
	public void sort(Comparable[] target) 
	{
		int length = target.length;

		for (int i = 0; i < length; i ++) {
			for (int j = 1; j < (length - i); j ++) {
				if (less(target[j], target[j - 1])) {
					swap(target, j - 1, j);
				}
			}
		}
	}
}
