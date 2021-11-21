package sorting;

/**
 * @author Michael Placzek
 */
@SuppressWarnings("rawtypes")
// made it extend SorterBase, so I have access to the less method
public class MergeSort extends SorterBase implements Sorter {
	public void sort(Comparable[] target) {
		mergeSort(target, target.length);
	}

	private void mergeSort(Comparable[] a,  int n) {
		if (n < 2) { // Base case
			return;
		}

		int mid = n / 2;
		Comparable[] left = new Comparable[mid];
		Comparable[] right = new Comparable[n - mid];

		for (int i = 0; i < mid; i ++) {
			left[i] = a[i];
		}
		for (int i = mid; i < n; i ++) {
			right[i - mid] = a[i];
		}

		mergeSort(left, mid); // Recursively sort the left
		mergeSort(right, n - mid); // Recursively sort the right

		merge(a, left, right, mid, n - mid); // Finally, merge the two together
	}

	private void merge(Comparable[] a, Comparable[] left, Comparable[] right, int leftInt, int rightInt) {
		int i = 0, j = 0, k = 0;

		while (i < leftInt && j < rightInt) {
			if (less(left[i], right[j])) {
				a[k] = left[i];

				i++;
			} else {
				a[k] = right[j];

				j++;
			}
			k++;
		}

		while (i < leftInt) {
			a[k] = left[i];

			i++;
			k++;
		}

		while (j < rightInt) {
			a[k] = right[j];

			j++;
			k++;
		}
	}
}
