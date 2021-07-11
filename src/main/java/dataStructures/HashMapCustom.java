package dataStructures;

public class HashMapCustom<K, V> {

    private Entry<K, V>[] bucket;
    private int capacity = 4;

    public HashMapCustom() {
        this.bucket = new Entry[this.capacity];
    }

    public HashMapCustom(int capacity) {
        this.capacity = capacity;
        this.bucket = new Entry[this.capacity];
    }

    public static void main(String[] args) {
        HashMapCustom<Integer, Integer> hash = new HashMapCustom<>(4);
        hash.put(21, 12);
        hash.put(25, 121);
        hash.put(40, 65);
        hash.put(50, 52);
        hash.put(23, 42);
        hash.display();
        System.out.println(hash.get(40));
        hash.remove(25);
        hash.remove(21);
        hash.display();
    }

    public void put(K key, V value) {
        if (key == null) {
            return;
        }
        int hash = hash(key);

        Entry<K, V> entry = new Entry<>(key, value, null);

        if (bucket[hash] == null) {
            bucket[hash] = entry;
        } else {
            Entry<K, V> current = bucket[hash];

            while (current.next != null) {
                if (current.key.equals(key)) {
                    current.value = value; //here
                    return;
                }
                current = current.next;
            }
            if (current.key.equals(key)) {
                current.value = value;
            } else {
                current.next = entry;
            }
        }
    }

    public boolean remove(K key) {
        int hash = hash(key);
        if (bucket[hash] == null) {
            return false;
        }
        Entry<K, V> current = bucket[hash];
        Entry<K, V> prev = null;
        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null && current.next == null) {
                    bucket[hash] = null;
                    return true;
                } else if (prev == null) {
                    bucket[hash] = current.next;
                    return true;
                } else {
                    prev.next = current.next;
                    return true;
                }
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    public V get(K key) {
        int hash = hash(key);

        if (bucket[hash] == null) {
            return null;
        }
        Entry<K, V> temp = bucket[hash];
        while (temp != null) {
            if (temp.key.equals(key)) {
                return temp.value;
            }
            temp = temp.next;
        }
        return null;
    }

    public void display() {
        for (int i = 0; i < capacity; i++) {
            if (bucket[i] != null) {
                Entry<K, V> temp = bucket[i];
                while (temp != null) {
                    System.out.print("(" + temp.key + ", " + temp.value + ")" + " ");
                    temp = temp.next;
                }
            }
            System.out.println();
        }
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
