import java.util.Objects;

public class MyHashMap<Key, Value> {
    private Node<Key, Value>[] hashTable;
    private int size = 0;
    private float hold;

    public MyHashMap() {
        hashTable = new Node[16];
        hold = hashTable.length * 0.75f;
    }

    public int hash(Key key) {
        int result = 31;
        result = 17 * result + Objects.hashCode(key);
        return result % hashTable.length;
    }

    public void put(Key key, Value value) {
        Node<Key, Value> node = new Node<>(null, key, value);
        int index = node.hash(hashTable.length);
        size++;
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
        private final int hash;

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
            int result = 31;
            result = 17 * result + Objects.hashCode(key);
            return result;
        }

        public int hash(int length) {
            return hash % length;
        }
    }
}
