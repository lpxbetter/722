/**
* Andrew ID: lipingx
* @author liping xiong
*/

public class SortedLinkedList implements MyListInterface {
    /**
     *
     *  @param
     */
    final static boolean debug = false;
    /**
     * Node structure of the linked list
     */
    class Node {
        String val;
        Node next;
        Node(String val){
            this.val = val;
            this.next = null;
        }
    }
    /**
     * head of the linked list
     */
    private Node head;
    /**
     * No-arg constructor
     */
    SortedLinkedList(){
        head = null;
    }
    /**
     * Constructor with an array of string as parameter
     * @param unsorted an unsorted array of string
     */
    SortedLinkedList(String[] unsorted){
        head = null;
        build(unsorted, 0);
    }
    /**
     * Innner function called by Constructor
     *  @param strs unsorted array of string
     *  @param i Index of current word
     */
    private void build(String[] strs,int i){
        if(i == strs.length) return;
        add(strs[i]);
        build(strs,i+1);
    }

    /**
     * Inserts a new String.
     * No duplicates allowed and maintain the order in ascending order.
     * @param value String to be added.
     */
    private void add(String value,Node pre,Node front){
        // Add to the end of the list
        if(front == null) {
            Node newNode = new Node(value);
            pre.next = newNode;
            return;
        }

        if(front.val.equals(value) ){
            return;
        }
        // Insert before the node "front"
        if(front.val.compareTo(value) > 0){
            Node newNode = new Node(value);
            newNode.next = front;
            pre.next = newNode;
            if(front == head) head = newNode; // update head
        }
        else{ // continue to find the insertion position
            add(value, pre.next,front.next);
        }
    }
    /**
     * Inserts a new String.
     * No duplicates allowed and maintain the order in ascending order.
     * @param value String to be added.
     */
    public void add(String value){
        if(head == null) {
            Node newNode = new Node(value); // New one node
            head = newNode;
            return;
        }

        Node dummy = new Node("");
        dummy.next = head;
        Node front = head;
        Node pre = dummy;

        add(value, pre, front);
    }

    /**
     * Checks the size (number of data items) of the list.
     * @return the size of the list
     */
    public int size(){
        return size(head);
    }
    /**
     * Checks the size (number of data items) of the list.
     * @return the size of the list
     */
    private int size(Node front){
        if(front == null) return 0;
        return 1 + size(front.next);
    }
    /**
     * Displays the values of the list.
     */
    public void display(){
//        if(head == null) return;
        System.out.print("[");
        display(head);
        System.out.print("]");
        System.out.println();
    }
    /**
     * Displays the values of the list.
     */
    private void display(Node front){
        if(front == null) {
            return;
        }
        if(front.next == null) System.out.print(front.val);
        else System.out.print(front.val+", ");
        display(front.next);
    }

    /**
     * Returns true if the key value is in the list.
     * @param key String key to search
     * @return true if found, false if not found
     */
    public boolean contains(String key){
        return contains(key,head);
    }
    /**
     * Returns true if the key value is in the list.
     * @param key String key to search
     * @return true if found, false if not found
     */
    private boolean contains(String key, Node front){
        if(front == null) return false;
        if(front.val.equals(key)) return true;
        return contains(key,front.next);
    }

    /**
     * Returns true is the list is empty.
     * @return true if it is empty, false if it is not empty
     */
    public boolean isEmpty(){
        return  head == null;
    }

    /**
     * Removes and returns the first String object of the list.
     * @return String object that is removed
     */
    public String removeFirst(){
        if(head == null) return "";
        String res = head.val;
        head = head.next;
        return res;
    }

    /**
     * Removes and returns String object at the specified index.
     * @param index index to remove String object
     * @return String object that is removed
     */
    public String removeAt(int index){
        if(index >= this.size()) return "";
        //throw new IllegalArgumentException("Index should be less than the size of the list.");
        if(index == 0 ) return removeFirst();

        Node pre = new Node("");
        pre.next = head;
        // pre is the previous node of node AT index
        return removeAt(index,-1,pre); // index of pre, and pre node
    }
    /**
     * Removes and returns String object at the specified index.
     * @param index index to remove String object
     * @return String object that is removed
     */
    private String removeAt(int index, int preIdx, Node pre){
        String res = "";
        if(preIdx+1 == index) {
            res = pre.next.val;
            pre.next = pre.next.next;// remove the node
            return  res;
        }
        return removeAt(index,preIdx+1,pre.next);
    }

}
