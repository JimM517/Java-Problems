package LeetCode.Dailys.TwoSix;

public class March {




    // 1689. partitioning into minimum number of deci-binary numbers
    public int minPartitions(String n) {

        int minPartitions = Integer.MIN_VALUE;

        for (char c : n.toCharArray()) {

            int current = Character.getNumericValue(c);

            minPartitions = Math.max(minPartitions, current);

        }

        return minPartitions;


    }





































































































}
