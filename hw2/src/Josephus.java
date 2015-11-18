import javax.swing.*;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 08-722 Data Structures for Application Programmers.
 * Homework Assignment 2
 * Solve Josephus problem with different data structures
 * and different algorithms and compare running times
 *
 * Andrew ID: lipingx
 * @author liping xiong
 */

public class Josephus {
    private final static boolean debug = false;
    private final static boolean showResult = true;

    /**
     * Uses ArrayDeque class as Queue/Deque to find the survivor's position.
     * @param size Number of people in the circle that is bigger than 0
     * @param rotation Elimination order in the circle. The value has to be greater than 0
     * @return The position value of the survivor
     */
    public int playWithAD(int size, int rotation)  {
        if( size <= 0 ) throw new IllegalArgumentException("Size is illegal.");
        if( rotation <= 0 ) throw new IllegalArgumentException("Rotation is illegal.");

        Queue<Integer> queue = new ArrayDeque<>();
        // Build the queue
        for(int i = 1; i <= size; i++){
            queue.offer(i);
        }
        /*
        After killing one, put all people before the killed one to the end of queue.
        So that the front of the queue is always the starting position "start".
        And the one who is rotation after the "start" is the one should be killed.
        Keep killing until there is only one people in the queue.
         */
        while(queue.size()>1){
            for(int j = 1; j < rotation; j++){
                queue.offer(queue.poll());
            }
            int killed = queue.poll();
            if(debug)System.out.println("kill " + killed);
        }
        // The last person left in list is the survivor
        int survivor = queue.poll();
        if(showResult) System.out.println("survivor " + survivor);
        return  survivor;
    }

    /**
     * Uses LinkedList class as Queue/Deque to find the survivor's position.
     * @param size Number of people in the circle that is bigger than 0
     * @param rotation Elimination order in the circle. The value has to be greater than 0
     * @return The position value of the survivor
     */
    public int playWithLL(int size, int rotation) {
        if( size <= 0 ) throw new IllegalArgumentException("Size is illegal.");
        if( rotation <= 0 ) throw new IllegalArgumentException("Rotation is illegal.");

        Queue<Integer> queue = new LinkedList<>();
        // Build the queue
        for(int i=1; i <= size; i++){
            queue.offer(i);
        }
        if(debug) System.out.println(queue);
        /*
        After killing one, put all people before the killed one to the end of queue.
        So that the front of the queue is always the starting position "start".
        And the one who is rotation after the "start" is the one should be killed.
        Keep killing until there is only one people in the queue.
         */
        while(queue.size() > 1) {
            for (int j = 1; j < rotation; j++) {
                queue.offer(queue.poll());
            }
            int killed = queue.poll(); // Kill one
            if(debug) System.out.println("kill " + killed);
        }
        // The last person left in list is the survivor
        int survivor = queue.poll();
        if(showResult) System.out.println("survivor " + survivor);
        return survivor;
    }

    /**
     * Uses LinkedList class to find the survivor's position.
     * However, do NOT use the LinkedList as Queue/Deque
     * Instead, use the LinkedList as "List"
     * That means, it uses index value to find and remove a person to be executed in the circle
     *
     * Note: Think carefully about this method!!
     * When in doubt, please come to one of the office hours!!
     *
     * @param size Number of people in the circle that is bigger than 0
     * @param rotation Elimination order in the circle. The value has to be greater than 0
     * @return The position value of the survivor
     */

    public int playWithLLAt(int size, int rotation) {
        if( size <= 0 ) throw new IllegalArgumentException("Size is illegal.");
        if( rotation <= 0 ) throw new IllegalArgumentException("Rotation is illegal.");

        LinkedList<Integer> list = new LinkedList<>();

        // Build the list
        for(int i=1; i<=size; i++){
            list.addLast(i);
        }

        int start = 0; // Start position of current round, at first round, start = 0
        int index = (start + rotation - 1 ) % list.size();// Index of the person who should be killed at this round

        while(list.size() > 1) {
            if(debug) System.out.println(list);
            if (debug) System.out.printf("list[start]=%d,list[index]=%d\n", list.get(start), list.get(index));

            int killed = list.remove(index); // Kill the person at "index" position

            // After killing a person, update start and index and go to next round
            start = index % list.size();
            index = (start + rotation - 1) % list.size();
        }

        // The only person left in the list is the survivor
        int survivor = list.getFirst();
        if(showResult) System.out.println("survivor " + survivor);

        return survivor;
    }

}
