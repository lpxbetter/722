import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 08-722 Data Structures for Application Programmers.
 * Example code for lecture 5 LinkedList
 *
 * @author Terry Lee
 */
public class Lecture5Driver {

    /**
     * Simple test program to show iterator usages.
     * @param args arguments
     */
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        Iterator<Integer> itr = numbers.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        System.out.println();

        SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();
        linkedList.addLast("data");
        linkedList.addLast("strutures");
        linkedList.addLast("rock");
        linkedList.addLast("the");
        linkedList.addLast("world");
        linkedList.addFirst("way");
        linkedList.insertAfter("way", "to");
        linkedList.insertAfter("hello", "so");
        linkedList.insertBefore("data", "go");

        Iterator<String> itr2 = linkedList.iterator();

        while (itr2.hasNext()) {
            System.out.println(itr2.next());
        }
    }

}
