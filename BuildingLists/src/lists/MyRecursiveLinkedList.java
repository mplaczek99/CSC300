package lists;

/**
 * @author Michael Placzek
 */
public class MyRecursiveLinkedList implements SimplifiedList
{
	private Node head;
	private int size;

	private class Node {
		private Object value; // make final?
		private Node next;

		public Node(Object value) {
			this.value = value;
			next = null;
		}

		public boolean add(Object o) {
			if (this.next == null) {
				this.next = new Node(o);
				return true;
			}
			return this.next.add(o);
		}

		public boolean contains(Object o) {
			if (this.value == o) {
				return true;
			}
			if (this.next == null) {
				return false;
			}
			return this.next.contains(o);
		}

		public Object get(int index, int num) {
			if (index == 0) {
				return this.value;
			}

			if (num == index) {
				return this.next.value;
			}
			return this.next.get(index, num + 1);
		}

		public Object set(int index, Object element, int num) {
			if (index == 0) {
				Object pop = this.value;
				this.value = element;
				return pop;
			}

			if (num == index) {
				Object pop = this.next.value;
				this.next.value = element;
				return pop;
			}
			return this.next.set(index, element,num + 1);
		}

		public int indexOf(Object o, int num) {
			if (indexIsNotLegal(num)) {
				return -1;
			}

			if (this.next.value == o) {
				return num;
			}
			return this.next.indexOf(o, num + 1);
		}

		public Node remove(int index, Node current) {
			if (current != null) {
				Node temp = new Node(get(index, 0)).next;
				if (temp != null) {
					this.next = remove(index, temp);
				}
			}
			return null;
		}
	}

	public MyRecursiveLinkedList() {
		head = null;
		size = 0;
	}

	@Override
	public int size() 
	{
		return size;
	}

	@Override
	public boolean isEmpty() 
	{
		return size == 0;
	}

	@Override
	public boolean add(Object e) 
	{
		if (head == null) {
			head = new Node(e);
		}
		size++;
		return head.add(e);
	}

	@Override
	public void clear() 
	{
		head = null;
		size = 0;
	}

	@Override
	public Object get(int index) 
	{
		if (indexIsNotLegal(index)) {
			return null;
		}
		return head.get(index, 0);
	}

	@Override
	public Object set(int index, Object element) 
	{
		if (indexIsNotLegal(index)) {
			return null;
		}
		return head.set(index, element, 0);
	}

	@Override
	public Object remove(int index) 
	{
		size--;
		return head.remove(index, head).value;
	}

	@Override
	public boolean contains(Object o) 
	{
		if (head == null) {
			return false;
		}
		return head.contains(o);
	}

	@Override
	public int indexOf(Object o) 
	{
		return head.indexOf(o, 0);
	}

	@Override
	public int lastIndexOf(Object o) 
	{
		return -1;
	}

	@Override
	public boolean remove(Object o) 
	{
		return false;
	}

	private boolean indexIsNotLegal(int index) {
		return index < 0 || index >= size;
	}
}