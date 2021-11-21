package lists;

/**
 * @author Michael Placzek
 */
public class MyLinkedList implements SimplifiedList {
    Node head; // make private
    Node tail;
    int size;

    public class Node { // make static?
        Node next; // make protected?
        Node previous;
        Object data;

        public Node(Object o) {
            next = null;
            previous = null;
            data = o;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }

    public MyLinkedList() {
        head = null;
        tail = null;
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
        Node newNode = new Node(e);

        // Special case where head is null
        if (head == null) {
            head = newNode;
        } else {
            // Sets the newNode's previous to be the (previous) tail
            newNode.setPrevious(tail);

            // Sets the next node in the list to be newNode
            tail.setNext(newNode);
        }
        // The newNode is to be the new tail
        tail = newNode;
        // Increments the size
        size++;

        return true;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public Object get(int index) {
        if (indexSpecialCase(index)) {
            return null;
        }

        Node current = head;

        // Makes the next Node to be current
        for (int i = 0; i < index; i++) {
            if (current != null) {
                current = current.getNext();
            }
        }
        assert current != null; // IntelliJ complains if this line is not here
        return current.getData();
    }

    @Override
    public Object set(int index, Object element) {
        if (indexSpecialCase(index)) {
            return null;
        }

        Node current = head;

        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        Node pop = new Node(current.getData());
        current.setData(element);

        return pop.getData();
    }

    @Override
    public Object remove(int index) {
        // Check if index is in bounds
        if (indexSpecialCase(index)) {
            return null;
        }

        // Check if special case
        if (index == 0) {
            Node temp = head;

            head = head.getNext();
            temp.setNext(null);
            size--;
            return temp.getData();
        } else { // index > 0
            Node previous = head;

            for (int count = 1; count < index; count++) {
                previous = previous.getNext();
            }

            Node current = previous.getNext();

            previous.setNext(current.getNext());
            current.setNext(null);
            size--;
            return current.getData();
        }
    }

    @Override
    public boolean contains(Object o) {
        Node current = head;

        while (current != null) {
            if (current.getData() == o) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @Override
    public int indexOf(Object o) {
        Node current = head;

        for (int i = 0; i < size; i++) {
            if (current.getData() == o) {
                return i;
            }
            current = current.getNext();
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node current = tail;

        for (int i = size - 1; i >= 0; i--) {
            if (current.getData() == o) {
                return i;
            }
            current = current.getPrevious();
        }
        return -1;
    }

    @Override
    public boolean remove(Object o) {
        if (!contains(o)) {
            return false;
        }

        Node current = head;

        // Loop index number of times
        while (current != null) {
            if (current.getData() == o) {
                current.setPrevious(current.getNext());
            }
            current = current.getNext();
        }

        // Decrement Size
        size--;

        return true;
    }

    private boolean indexSpecialCase(int i) {
        // Special case where i is too small or too big
        return i < 0 || i >= size;
    }
}