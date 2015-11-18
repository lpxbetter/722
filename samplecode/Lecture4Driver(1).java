import java.util.List;
import java.util.ArrayList;

/**
 * 08-722 Data Structures for Application Programmers.
 * A Simple Binary Search Implementation
 *
 * @author Terry Lee
 */
public class Lecture4Driver {

    /**
     * Simple test program for ArrayList's operations.
     * @param args arguments
     */
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<Integer>(0);
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 == 0) {
                numbers.remove(i);
            }
        }

        System.out.print(numbers);
    }

    /**
     * A simple binary search in an array that is not null.
     * Note: we will look into this in more details on Tuesday
     *
     * @param data int array to search against
     * @param key int key value to search for
     * @return index value if found, -1 if not found
     */
    public static int binarySearch(int[] data, int key) {
        int lowerBound = 0;
        int upperBound = data.length - 1;
        int mid;

        while (true) {
            // not found
            if (lowerBound > upperBound) {
                return -1;
            }

            mid = lowerBound + (upperBound - lowerBound) / 2;
            // found
            if (data[mid] == key) {
                return mid;
            }

            if (data[mid] < key) {
                // go to right
                lowerBound = mid + 1;
            } else {
                // go to left
                upperBound = mid - 1;
            }
        }
    }

}
