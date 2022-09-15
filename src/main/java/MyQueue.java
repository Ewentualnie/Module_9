public class MyQueue<T> {
    private Node<T> head;
    int size;

    public MyQueue() {
        head = null;
        size = 0;
    }

    public void add(T object) {
        Node<T> node = new Node<>(null, null, object);
        if (head == null) {
            head = node;
        } else {
            Node<T> lastNode = getNode();
            lastNode.next = node;
            node.previous = lastNode;
        }
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
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        return head.data;
    }

    public T poll() {
        Node<T> node = head;
        if (size > 1) {
            head = head.next;
            head.previous = null;
        } else {
            head = null;
        }
        size--;
        return node.data;
    }

    private Node<T> getNode() {
        if (head == null) {
            return head;
        } else {
            Node<T> node = head;
            while (node.next != null) {
                node = node.next;
            }
            return node;
        }
    }

    private Node<T> getNode(int index) {
        Node<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
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
