package sorting;

/**
 * @author Michael Placzek
 */
public class SelectionSort extends SorterBase 
{
	@SuppressWarnings("rawtypes")
	@Override
	public void sort(Comparable[] target)
	{
		int length = target.length;

		for (int i = 0; i < length; i ++) {
			// Exchange target[i] with the smallest entry in target until length - 1
			// Index of minimal entry
			int min = i;
			for (int j = i + 1; j < length; j ++) {
				if (less(target[j], target[min])) {
					min = j;
				}
			}
			swap(target, i, min);
		}
	}
}
