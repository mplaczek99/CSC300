package lists;

/**
 * @author Michael Placzek
 */
public class MyArrayList implements SimplifiedList
{
	private Object[] storage;
	private int size;

	public MyArrayList() {
		// Instantiates storage
		storage = new Object[10];
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean add(Object e) {
		// Special case where storage is full
		if (size == storage.length) {
			storage = new Object[size + 10];
		}

		// Adds e to storage
		storage[size] = e;

		// Increment size
		size++;

		return true;
	}

	@Override
	public void clear() {
		// Creates and sets storage to be a new Object[]
		storage = new Object[10];

		// Sets size to be 0
		size = 0;
	}

	@Override
	public Object get(int index) {
		if (index < 0 || index >= size) {
			// returns null if the index is too small or too big
			return null;
		}
		return storage[index];
	}

	@Override
	public Object set(int index, Object element) {
		if (index < 0 || index >= size) {
			return null;
		}

		// Trickery to replace storage's index AND keep it in memory
		Object temp = storage[index];
		storage[index] = element;

		// ... and return it
		return temp;
	}

	@Override
	public Object remove(int index) {
		// Special cases where either index is too big or too small
		if (index < 0 || index >= size) {
			return null;
		}

		// Trickery to keep pop in memory even after storage changes
		Object pop = storage[index];

		// Loop through storage from index to size
		// Shift contents down
		System.arraycopy(storage, index + 1, storage, index, size - index);

		// Decrement size
		size--;
		return pop;
	}

	@Override
	public boolean contains(Object o) {
		// Loops through storage
		for (int i = 0; i < size; i ++) {
			// return true if storage[index] is the same as o
			if (storage[i] == o) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int indexOf(Object o) {
		// Loops through storage
		for (int i = 0; i < size; i ++) {
			// returns i if storage[i] = o
			if (storage[i] == o) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		// Loops through the list backwards
		for (int i = size - 1; i >= 0; i --) {
			if (storage[i] == o) {
				// returns i if storage has o
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean remove(Object o) {
		if (size < 0) {
			return false;
		}

		int index = indexOf(o);

		// Special case where it did not find the object in storage
		if (index == -1) {
			return false;
		}

		// Loop through storage from 0 to size
		// Shift contents down
		if (size - index >= 0) System.arraycopy(storage, index + 1, storage, index, size - index);
		// IntelliJ (my IDE) recommended I use System.arrayCopy() instead of a for loop
		// I have no idea how System.arrayCopy() works... I'll have to look into it

		// Decrement size
		size--;
		return true;
	}
}