package HashMapHashingFunction.CustomHashMap;

import java.util.LinkedList;

class MyHashMap {

    private static final int SIZE = 16;

    // An array of LinkedLists to handle collisions using separate chaining
    private LinkedList<Node>[] table;

    // Constructor
    public MyHashMap() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = hash(key);
        LinkedList<Node> bucket = table[index];

        for (Node node : bucket) {
            if (node.key == key) {
                node.value = value;
                return;
            }
        }

        bucket.add(new Node(key, value));
    }

    // Get the value associated with the key
    public int get(int key) {
        int index = hash(key);
        LinkedList<Node> bucket = table[index];

        for (Node node : bucket) {
            if (node.key == key) {
                return node.value;
            }
        }

        return -1; // Return -1 if key doesn't exist
    }

    // Remove a key-value pair
    public void remove(int key) {
        int index = hash(key);
        LinkedList<Node> bucket = table[index];

        for (Node node : bucket) {
            if (node.key == key) {
                bucket.remove(node);
                return;
            }
        }
    }

    // Node class representing a key-value pair
    private static class Node {
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();

        map.put(1, 10);
        map.put(2, 20);
        map.put(1, 30);

        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println(map.get(3));

        map.remove(2);
        System.out.println(map.get(2));
    }
}
