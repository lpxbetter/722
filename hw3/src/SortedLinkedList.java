/**
 * Created by lipingxiong on 11/17/15.
 */

public class SortedLinkedList implements MyListInterface {
    class Node {
        String val;
        Node next;
        Node(String val){
            this.val = val;
        }
    }
    private Node head;

    SortedLinkedList(){
        head = null;
    }

    /**
     * Inserts a new String.
     * No duplicates allowed and maintain the order in ascending order.
     * @param value String to be added.
     */
    /*
    null

    // insert to head, need to update head
    "" -    b -
    |       |
    pre    cur
      c
     */
    public void add(String value){
        // is empty
        if(head == null) {
            Node newNode = new Node(value); // New one node
            head = newNode;
            return;
        }

        Node dummy = new Node("");
        Node cur = head;
        Node pre = dummy;
        while(cur != null){
            // duplicate
            if(cur.val.compareTo(value) == 0 ){
                return;
            }

            // Found the place that the value should be inserted
            if(cur.val.compareTo(value) > 0){
                // New one node and inert to between pre and cur
                Node newNode = new Node(value); // New one node
                newNode.next = cur;
                pre.next = newNode;
                // Insert to the front, need to update the head
                if(head == cur){
                    head = newNode;
                }
            }
            cur = cur.next;
            pre = pre.next;
        }

        // insert to the end
        if(cur ==  null){
            Node newNode = new Node(value); // New one node
            pre.next = newNode;
        }

    }

    /**
     * Checks the size (number of data items) of the list.
     * @return the size of the list
     */

    public int size(){
        int n = 0;
        Node cur = head;
        while(cur != null){
            cur = cur.next;
            n++;
        }
        return n;
    }
    /**
     * Displays the values of the list.
     */
    public void display(){
        if(this.isEmpty()) return;
        Node cur = head;
        while(cur != null){
            System.out.println(cur.val+",");
        }
        System.out.println();
    }

    /**
     * Returns true if the key value is in the list.
     * @param key String key to search
     * @return true if found, false if not found
     */
    /*
    a-b-c-d
     */
    public boolean contains(String key){
        if(this.isEmpty()) return false;
        Node cur = head;
        while(cur != null){
            if(cur.val.equals(key)) return true;
            cur = cur.next;
        }
        return false;
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

    }

    /**
     * Removes and returns String object at the specified index.
     * @param index index to remove String object
     * @return String object that is removed
     */
    public String removeAt(int index){

    }


}
