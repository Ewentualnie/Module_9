public class MyQueue<T> {
    private final MyLinkedList<T> base;

    public MyQueue() {
        base = new MyLinkedList<>();
    }

    public void add(T object) {
        base.add(object);
    }

    public void remove(int index) {
        base.remove(index);
    }

    public void clear() {
        base.clear();
    }

    public int size() {
        return base.size();
    }

    public T peek() {
        return base.get(0);
    }

    public T poll() {
        T object = base.get(0);
        base.remove(0);
        return object;
    }
}
