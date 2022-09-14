public class MyArrayList<T> implements MyCollection<T> {
    private static final int DEFAULT_SIZE = 0;
    private static final double EXPANSION_COEFFICIENT = 1.5;
    private T[] data;
    private int size = 0;

    public MyArrayList() {
        data = (T[]) new Object[DEFAULT_SIZE];
    }

    @Override
    public void add(T object) {
        if (size >= data.length - 1) {
            increaseSize();
        }
        data[size++] = object;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        T[] temp = data;
        System.arraycopy(temp, 0, data, 0, index);
        System.arraycopy(temp, index + 1, data, index, temp.length - index - 1);
        size--;
    }

    @Override
    public void clear() {
        size = 0;
        data = (T[]) new Object[DEFAULT_SIZE];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return data[index];
    }

    private void increaseSize() {
        T[] temp = data;
        int newSize = (int) (temp.length * EXPANSION_COEFFICIENT);
        if (newSize == temp.length) {
            newSize += 1;
        }
        data = (T[]) new Object[newSize];
        System.arraycopy(temp, 0, data, 0, temp.length);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            result.append((i < size - 1) ?
                    data[i] + ", " :
                    data[i]);
        }
        result.insert(0, "[").append("]");
        return result.toString();
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        }
    }
}
