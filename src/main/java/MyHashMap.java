import java.util.Objects;

public class MyHashMap<Key, Value> {
    Node<Key, Value> head;
    int size = 0;

    public MyHashMap() {
        head = new Node<>(null, null, null);
    }

    public void put(Key key, Value value) {
        Node<Key,Value> current = new Node<>(null,key,value);
        head.next = current;
        size++;
        Node<Key, Value> next = head;

    }

    public void remove(Key key) {
        видаляє пару по ключу
    }

    public void clear() {
        очищає колекцію
    }

    public int size() {
        повертає розмір колекції
    }

    public Value get(Key key) {
        повертає значення (Object value) по ключу
    }
private Node<Key,Value> getNode () {

}
    private static class Node<K, V> {
        public Node<K, V> next;
        public K key;
        public V value;

        public Node(Node<K, V> next, K key, V value) {
            this.next = next;
            this.key = key;
            this.value = value;
        }
    }
}
