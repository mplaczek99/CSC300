package sorting;

/**
 * @author Michael Placzek
 */
// made it extend SorterBase to have access to the swap and less method
public class HeapSort extends SorterBase implements Sorter {
    @SuppressWarnings("rawtypes")
    @Override
    public void sort(Comparable[] target) {
        int n = target.length;

        // Build the heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(target, n, i);

        // "Get" each element from the heap
        for (int i = n - 1; i > 0; i--) {
            // move the root to the end
            swap(target, 0, i);

            // call heapify on the reduced heap
            heapify(target, i, 0);
        }
    }

    private void heapify(Comparable[] a, int n, int i) {
        int largest = i; // largest is the root
        int l = 2 * i + 1; // left child
        int r = 2 * i + 2; // right child

        // Checks if left child is larger than the root
        if (l < n && less(a[largest], a[l])) largest = l;

        // Checks if the right child is larger than the root
        if (r < n && less(a[largest], a[r])) largest = r;

        // Checks if largest is not the root (a child was greater than the root)
        if (largest != i) {
            swap(a, i, largest);
            heapify(a, n, largest); // Recursively heapify
        }
    }
}