public class MyStack<T> {
    private final MyArrayList<T> array;

    public MyStack() {
        array = new MyArrayList<>();
    }

    public void push(T object) {
        array.add(object);
    }

    public void remove(int index) {
        array.remove(index);
    }

    public void clear() {
        array.clear();
    }

    public int size() {
        return array.size();
    }

    public T peek() {
        return array.get(array.size() - 1);
    }

    public T poll() {
        T object = array.get(array.size() - 1);
        array.remove(array.size() - 1);
        return object;
    }
}
