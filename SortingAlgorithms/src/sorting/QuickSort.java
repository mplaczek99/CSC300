package sorting;

/**
 * @author Michael Placzek
 */
@SuppressWarnings("rawtypes")
public class QuickSort extends QuickSortBase {
    @Override
    public void sort(Comparable[] target) {
        shuffle(target);
        quickSort(target, 0, target.length - 1);
    }

    private void quickSort(Comparable[] a, int low, int hi) {
        if (hi <= low) { // Base case
            return;
        }

        int j = partition(a, low, hi);
        quickSort(a, low, j - 1); // Sort left part (a[low..j-1])
        quickSort(a, j + 1, hi); // Sort right part (a[j+1..hi])
    }

    private int partition(Comparable[] a, int low, int hi) {
        int i = low, j = hi + 1; // left and right scan indices
        Comparable v = a[low]; // partitioning item

        while (true) {
			// Scan right, scan left, check for scan complete, and swap
            while (less(a[++i], v)) if (i == hi) break; // I am experimenting with one-line code...I kinda like it :)
            while (less(v, a[--j])) if (j == low) break; // Also requires ++i and --j...strange why i++ and j-- don't work...

            if (i >= j) break;
            swap(a, i, j);
        }
        swap(a, low, j);
        return j;
    }
}
