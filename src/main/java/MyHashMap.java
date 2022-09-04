import java.util.Arrays;
import java.util.Objects;

public class MyHashMap<K, V> {
    private Node<K, V>[] hashTable;
    private int size = 0;
    private float hold;

    public MyHashMap() {
        hashTable = new Node[16];
        hold = hashTable.length * 0.75f;
    }

    public int hash(K key) {
        return (31 * 17 + Objects.hashCode(key)) % hashTable.length;
    }

    public void put(K key, V value) {
        Node<K, V> node = new Node<>(null, key, value);
        int index = node.hash(hashTable.length);
        System.out.println(index);

        if (hashTable[index] == null) {
            hashTable[index] = node;
        } else {
            addLastNode(index, node);
        }
        size++;

    }

    private void addLastNode(int index, Node<K, V> node) {
        Node<K, V> oldNode = hashTable[index];
        while (oldNode.next != null) {
            oldNode = oldNode.next;
        }
        oldNode.next = node;
    }

    public void remove(K key) {
        //видаляє пару по ключу
    }

    public void clear() {
        hashTable = new Node[16];
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        int index = hash(key);
        System.out.println(index + " in get method");
        Node<K, V> oldNode = hashTable[index];
        if (oldNode != null) {
            while (oldNode.key != key) {
                oldNode = oldNode.next;
                if (oldNode == null) {
                    throw new RuntimeException("No element with key '" + key + "'");
                }
            }
            return oldNode.value;
        }
        return null;
    }

    private Node<K, V> getNode() {
        for (Node<K, V> node : hashTable) {

        }
        return null;
    }

    @Override
    public String toString() {
        return "MyHashMap{" +
                "hashTable=" + Arrays.toString(hashTable) +
                '}';
    }

    private static class Node<Key, Value> {
        public Node<Key, Value> next;
        public final Key key;
        public Value value;
        private final int hash;

        public Node(Node<Key, Value> next, Key key, Value value) {
            this.next = next;
            this.key = key;
            this.value = value;
            hash = hashCode();
        }

        @Override
        public String toString() {
            return "Node {" + key + ':' + value + '}' + (next != null ? "+++" : "-");
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
            return 31 * 17 + Objects.hashCode(key);
        }

        public int hash(int length) {
            return hash % length;
        }
    }
}
