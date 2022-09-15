import java.util.Objects;

public class MyHashMap<K, V> {
    private Node<K, V>[] hashTable;
    private int size = 0;

    public MyHashMap() {
        hashTable = new Node[16];
    }


    public void put(K key, V value) {
        Node<K, V> node = new Node<>(null, key, value);
        int index = node.hash(hashTable.length);

        if (hashTable[index] == null) {
            hashTable[index] = node;
            size++;
        } else {
            addNode(index, node);
        }
    }


    public void remove(K key) {
        int index = hash(key);
        Node<K, V> oldNode = hashTable[index];
        Node<K, V> current = oldNode;
        if (oldNode != null && oldNode.key.equals(key)) {
            hashTable[index] = null;
            size--;
        } else if (oldNode != null) {
            while (!oldNode.key.equals(key) && oldNode.next != null) {
                current = oldNode;
                oldNode = oldNode.next;
            }
            current.next = oldNode.next != null ? oldNode.next : null;
            size--;
        }
    }

    public void clear() {
        hashTable = new Node[16];
        size = 0;
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        int index = hash(key);
        Node<K, V> oldNode = hashTable[index];
        if (oldNode != null) {
            while (oldNode.key != key) {
                oldNode = oldNode.next;
            }
            return oldNode.value;
        }
        return null;
    }

    private void addNode(int index, Node<K, V> newNode) {
        Node<K, V> node = hashTable[index];
        while (node.next != null) {
            if (changeNodeValue(node, newNode)) {
                return;
            }
            node = node.next;
        }
        if (!changeNodeValue(node, newNode)) {
            node.next = newNode;
            size++;
        }
    }

    private boolean changeNodeValue(Node<K, V> node, Node<K, V> newNode) {
        if (node.hashCode() == newNode.hashCode()) {
            node.value = newNode.value;
            return true;
        }
        return false;
    }

    private int hash(K key) {
        return Math.abs((31 * 17 + Objects.hashCode(key)) % hashTable.length);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("{");
        for (Node<K, V> node : hashTable) {
            StringBuilder subRes = new StringBuilder();
            subRes.append(node != null ? node : "");
            if (node != null) {
                subRes.append(", ");
            }
            while (node != null && node.next != null) {
                node = node.next;
                subRes.append(node);
                subRes.append(", ");
            }
            res.append(subRes);

        }
        return res.substring(0, res.length() - 2) + "}";
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
            return key + "=" + value;
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
