import java.util.Arrays;
import java.util.Objects;

public class MyHashMap<K, V> {
    private Node<K, V>[] hashTable;
    private int size = 0;

    public MyHashMap() {
        hashTable = new Node[16];
    }

    public int hash(K key) {
        return Math.abs((31 * 17 + Objects.hashCode(key)) % hashTable.length);
    }

    public void put(K key, V value) {
        Node<K, V> node = new Node<>(null, key, value);
        int index = node.hash(hashTable.length);

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
        int index = hash(key);
        Node<K, V> oldNode = hashTable[index];
        Node<K, V> current = null;
        if (oldNode != null) {
            while (!oldNode.key.equals(key)) {
                current = oldNode;
                oldNode = oldNode.next;
            }
        }
        System.out.println("current: " + current.value + "    old:" + oldNode.value);
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
        Node<K, V> oldNode = hashTable[index];
        if (oldNode != null) {
            while (!oldNode.key.equals(key)) {
                oldNode = oldNode.next;
                if (oldNode != null) {
                    continue;
                }
                throw new RuntimeException("No element with key '" + key + "'");
            }
            return oldNode.value;
        }
        throw new RuntimeException("No element with key '" + key + "'");
    }

    private Node<K, V> getNode() {
        for (Node<K, V> node : hashTable) {

        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("MyHashMap {");
        for (Node node : hashTable) {
            if (node != null) {
                res.append(node).append("\n");
            }
        }
        return res.toString();
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
            StringBuilder res = new StringBuilder("");
            res.append("{").append("key: ").append(key).append(" value: ").append(value).append(";");
            if (next != null) {
                while (next != null) {
                    res.append("\n").append("key: ").append(next.key).append(" value: ").append(next.value).append(";");
                    next = next.next;
                }
            }
            res.deleteCharAt(res.length() - 1).append("}");
            return res.toString();
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
            return Math.abs(hash % length);
        }
    }
}
