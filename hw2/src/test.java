/**
 * Created by lipingxiong on 11/12/15.
 */
public class test {
    public static void main (String[] args) {
        int survivor = 0;
        Josephus game =  new Josephus();
        try {
            int[][] data = new int[][]{
                    {6,3},
                    {5,1},
                    {5,2},
                    {11,1},
                    {40,7},
                    {55,1},
                    {66,100},
                    {1000,1000},
//                    {-1,2},
//                    {5,0},
            };
            for(int[] pair: data){
                int resLL = game.playWithLL(pair[0],pair[1]);
                int resAD = game.playWithAD(pair[0],pair[1]);
                int resLLAt = game.playWithLLAt(pair[0],pair[1]);
//            assert resLL != resAD;
            }
//            game.playWithLL(2,5);
//        survivor = game.playWithLLAt(2,5);

////        assert survivor == 1;
//        survivor = j.playWithAD(5,1);
//        survivor = j.playWithAD(5,2);
//        survivor = j.playWithAD(11,1);
//        survivor = j.playWithAD(40,7);
//        survivor = j.playWithAD(55,1);
//        survivor = j.playWithAD(66,100);
//        survivor = j.playWithAD(1000,1000);
//            survivor = j.playWithAD(-1, 2);
//        survivor = j.playWithAD(5,0);
        }
        catch (RuntimeException error){
            System.out.println(error);
        }

    }

}
