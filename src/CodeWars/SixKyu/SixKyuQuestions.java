package CodeWars.SixKyu;

import java.util.HashMap;
import java.util.Map;

public class SixKyuQuestions {

    // tribonacci sequence
    public double[] tribonacci(double[] s, int n) {

        if (n == 0) {
            return new double[0];
        }

        double[] result = new double[n];
        for (int i = 0; i < n; i++) {
            if (i < 3) {
                result[i] = s[i];
            } else {
                result[i] = result[i - 1] + result[i - 2] + result[i - 3];
            }
        }

        return result;
    }





    // find the odd int
    public static int findIt(int[] a) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : a) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int count = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
           if (entry.getValue() % 2 != 0) {
               return entry.getKey();
           }
        }


        return -1;

    }

































}
