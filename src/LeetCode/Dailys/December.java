package LeetCode.Dailys;

import java.util.HashMap;
import java.util.Map;

public class December {



    // 2141. maximum running time of N computers
    public long maxRunTime(int n, int[] batteries) {

        long sumPower = 0;
        for (int power : batteries) {
            sumPower += power;
        }

        long left = 1, right = sumPower / n;

        while (left < right){
            long target = right - (right - left) / 2;
            long extra = 0;

            for (int power : batteries)
                extra += Math.min(power, target);

            if (extra >= (long)(n * target))
                left = target;
            else
                right = target - 1;
        }
        return left;
    }






    // 3623. count number of trapezoids I
    public int countTrapezoids(int[][] points) {

        Map<Integer, Integer> pointNum = new HashMap<>();
        final int MOD = 1000000007;

        long answer = 0;
        long sum = 0;

        for (int[] point : points) {
            pointNum.put(point[1], pointNum.getOrDefault(point[1], 0) + 1);
        }
        for (int pNum : pointNum.values()) {
            long edge = ((long) pNum * (pNum - 1)) / 2;
            answer = (answer + edge * sum) % MOD;
            sum = (sum + edge) % MOD;
        }

        return (int) answer;

    }





































































































































































































































}
