//https://leetcode.com/problems/lru-cache/description/



import java.util.HashMap;
class LRUCache {

    static class Node {
        Node prev;
        Node next;
        int key;
        int value;
    }

    Node head;
    Node tail;
    int cap;
    int size;

    HashMap<Integer, Node> map = new HashMap<>();

    void remove(Node node){
        if(head == null){
            return;
        }
        else if(head == tail){
            head = tail = null;
        }else if(node == head){
            head = head.next;
            head.prev = null;
        }else if(node == tail){
            Node nm1 = tail.prev;
            nm1.next = null;
            tail = nm1;
        }else {
            Node np1 = node.next;
            Node nm1 = node.prev;
            nm1.next = np1;
            np1.prev = nm1;
        }

        size--;
    }

    void addFront(int key, int val){
        Node node = new Node();
        node.key = key;
        node.value = val;

        if(size == 0){
            head = tail = node;
        }else{
            node.next = head;
            head.prev = node;
            head = node; 
        }

        size ++;
    }


    public LRUCache(int capacity) {
        this.cap = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);

            remove(node);
            addFront(key, node.value);
            map.put(key, head);

            return node.value;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key) == true){
            Node node = map.get(key);
            remove(node);
            addFront(key, value);
            map.put(key, head);
        }else{
            if(size == cap){
                map.remove(tail.key);
                remove(tail);
                addFront(key, value);
                map.put(key, head);
            }else{
                addFront(key, value);
                map.put(key, head);
            }
        }
    }
}