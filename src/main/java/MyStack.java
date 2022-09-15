public class MyStack<T> {
    private Node<T> tail;
    private int size;

    public MyStack() {
        tail = null;
        size = 0;
    }

    public void push(T object) {
        Node<T> node = new Node<>(null, null, object);
        if (tail != null) {
            node.previous = tail;
            tail.next = node;
        }
        tail = node;
        size++;
    }

    public void remove(int index) {
        checkIndex(index);
        Node<T> current = getNode(index);
        if (current.previous != null) {
            current.previous.next = current.next;
        }
        if (current.next != null) {
            current.next.previous = current.previous;
        }
        size--;
    }

    public void clear() {
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        return tail.data;
    }

    public T poll() {
        Node<T> node = tail;
        tail = tail.previous;
        if (size > 1) {
            tail.next = null;
        }
        size--;
        return node.data;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node<T> node = getNode(size - 1);
        for (int i = 0; i < size; i++) {
            result.append((i < size - 1) ?
                    node.data + ", " :
                    node.data);
            node = node.next;
        }
        result.insert(0, "[").append("]");
        return result.toString();
    }

    private Node<T> getNode(int index) {
        Node<T> node = tail;
        for (int i = 0; i < index; i++) {
            node = node.previous;
        }
        return node;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        }
    }


    private static class Node<E> {
        Node<E> previous;
        Node<E> next;
        E data;

        public Node(Node<E> previous, Node<E> next, E data) {
            this.previous = previous;
            this.next = next;
            this.data = data;
        }
    }
}