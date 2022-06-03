package striverSDEsheet.day14;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheDriver {
    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);
        obj.put(1, 1);
        obj.put(2, 2);
        System.out.println(obj.get(1));
        obj.put(3, 3);
        System.out.println(obj.get(2));
        obj.put(4, 4);
        System.out.println(obj.get(1));
        System.out.println(obj.get(3));
        System.out.println(obj.get(4));
    }
}

class LRUCache {

    Node head = new Node(0, 0), tail = new Node(0, 0);
    Map<Integer, Node> map = new HashMap<>();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insert(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.val;
        } else
            return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key))
            remove(map.get(key));
        if (map.size() == capacity)
            remove(tail.prev);
        insert(new Node(key, value));
    }

    class Node {
        Node prev, next;
        int key, val;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}