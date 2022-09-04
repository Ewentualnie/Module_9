import java.util.Objects;

public class MyHashMap<Key, Value> {
    private Node<Key, Value>[] hashTable;
    int size = 0;

    public MyHashMap() {

    }

    public void put(Key key, Value value) {

    }

    public void remove(Key key) {
        //видаляє пару по ключу
    }

    public void clear() {
        //очищає колекцію
    }

    public int size() {
        return size;
    }

    public Value get(Key key) {
        return null;
        //повертає значення (Object value)по ключу
    }

    private Node<Key, Value> getNode() {
        return null;
    }

    private static class Node<K, V> {
        public Node<K, V> next;
        public K key;
        public V value;
        public int hash;

        public Node(Node<K, V> next, K key, V value) {
            this.next = next;
            this.key = key;
            this.value = value;
            hash = hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?, ?> node = (Node<?, ?>) o;
            return next.equals(node.next) && key.equals(node.key) && value.equals(node.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(next, key, value);
        }
    }
}
