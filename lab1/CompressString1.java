/**
 * 08-722 Data Structures for Application Programmers.
 * Lab 1 ArrayList time comparison and String manipulation.
 *
 * Andrew ID: lipingx
 * @author Liping Xiong
 */
public class CompressString1 {
    /**
     * You may change the main method while you are working on. But, when you
     * submit your code, make sure to have the original code of the Main method.
     * @param args arguments
     */
    public static void main(String[] args) {
        String str = "aabbccaabbccaabbccaabbccbbbaaabbbcccaaabbbcccaaabbbcccaaabbbccaaabbbcccaaabbbbccccaaaaabbbbbccccaaabbbcccaaabbbcccaaabbbcccaaabbbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcaabbccaabbccaabbccaabbccbbbaaabbbcccaaabbbcccaaabbbcccaaabbbccaaabbbcccaaabbbbccccaaaaabbbbbccccaaabbbcccaaabbbcccaaabbbcccaaabbbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcaabbccaabbccaabbccaabbccbbbaaabbbcccaaabbbcccaaabbbcccaaabbbccaaabbbcccaaabbbbccccaaaaabbbbbccccaaabbbcccaaabbbcccaaabbbcccaaabbbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcaabbccaabbccaabbccaabbccbbbaaabbbcccaaabbbcccaaabbbcccaaabbbccaaabbbcccaaabbbbccccaaaaabbbbbccccaaabbbcccaaabbbcccaaabbbcccaaabbbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcaabbccaabbccaabbccaabbccbbbaaabbbcccaaabbbcccaaabbbcccaaabbbccaaabbbcccaaabbbbccccaaaaabbbbbccccaaabbbcccaaabbbcccaaabbbcccaaabbbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcaabbccaabbccaabbccaabbccbbbaaabbbcccaaabbbcccaaabbbcccaaabbbccaaabbbcccaaabbbbccccaaaaabbbbbccccaaabbbcccaaabbbcccaaabbbcccaaabbbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcaabbccaabbccaabbccaabbccbbbaaabbbcccaaabbbcccaaabbbcccaaabbbccaaabbbcccaaabbbbccccaaaaabbbbbccccaaabbbcccaaabbbcccaaabbbcccaaabbbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcaabbccaabbccaabbccaabbccbbbaaabbbcccaaabbbcccaaabbbcccaaabbbccaaabbbcccaaabbbbccccaaaaabbbbbccccaaabbbcccaaabbbcccaaabbbcccaaabbbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcaabbccaabbccaabbccaabbccbbbaaabbbcccaaabbbcccaaabbbcccaaabbbccaaabbbcccaaabbbbccccaaaaabbbbbccccaaabbbcccaaabbbcccaaabbbcccaaabbbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaabbbcccaaannncccaaabbbcccaaabbbcccaaabbbcccaaabbbaaabbbccc";
        CompressString1 compressor = new CompressString1();
        Stopwatch timer1 = new Stopwatch();
        System.out.println("output:" + compressor.compress(str));
        System.out.print("running time:" + timer1.elapsedTime() + " millisec");
    }

    /**
     * method to compress a string using String.
     * @param str input string that should have at least two characters
     * @return Compressed or original string depending on the size of the
     *         compressed
     */
    public String compress(String str) {
        // initialize compressed string
        if(str.length() < 2) return str;
        String compressed = "";

        char prev = str.charAt(0);
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            char curr = str.charAt(i);
            if (curr == prev) {
                count++;
            } else { // new char occur, add the prev char to result and update count and prev
                compressed += prev + "" + count;
                count = 1;
                prev = curr;
            }
        }
        //The last character should be added
        compressed += str.charAt(str.length()-1) + "" + count;
//        System.out.println(compressed);
        /*
         * do some post process here, if necessary.
         * If you feel that you took care of everything in the loop above,
         * no need to worry about this post process section.
         */

        // check length and return accordingly
        // return final string that is compressed
        if (compressed.length() > str.length()) {
            return str;
        } else {
            return compressed;
        }
    }

}
