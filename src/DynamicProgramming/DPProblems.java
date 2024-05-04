package DynamicProgramming;

public class DPProblems {


    // 1025. Divisor Game
    public boolean divisorGame(int n) {
        return n % 2 == 0;
    }





    // 1668. maximum repeating substring
    public int maxRepeating(String sequence, String word) {

       int count = 0;

       String add = word;

       while (sequence.contains(word)) {
           count++;
           word += add;
       }
        return count;
    }





}
