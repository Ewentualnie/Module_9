public class MyLinkedList<T> implements MyCollection<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public MyLinkedList() {
        tail = new Node<>(head, null, null);
        head = new Node<>(null, tail, null);
    }

    @Override
    public void add(T object) {
        Node<T> previous = tail;
        previous.data = object;
        tail = new Node<>(null, previous, null);
        previous.next = tail;
        size++;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        Node<T> current = getNode(index);
        if (index == 0) {
            head.next = current.next;
        } else if (index == size) {
            tail.previous = current.previous;
        } else {
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }
        size--;
    }

    @Override
    public void clear() {
        head.next = tail;
        tail.previous = head;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return getNode(index).data;
    }

    private Node<T> getNode(int index) {
        Node<T> node = head.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new RuntimeException("Index " + index + " out of bounds for length " + size);
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
