public interface MyCollection<T> {
    void add(T object);
    void remove(int index);
    void clear();
    int size();
    T get(int index);
}
