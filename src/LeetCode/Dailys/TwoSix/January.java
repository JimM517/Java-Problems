package LeetCode.Dailys.TwoSix;

import java.util.HashMap;
import java.util.Map;

public class January {


    // plus one
    public int[] plusOne(int[] digits) {


        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;


    }






    // 961. N-repeated element in size 2N array
    public int repeatedNTimes(int[] nums) {

        int len = nums.length;

        Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        int key = 0;
        for (Map.Entry<Integer, Integer> map : count.entrySet()) {

            int val = map.getValue();
            if (len == (2 * val) && count.size() == val + 1) {
                key = map.getKey();
            }


        }
        return key;


    }






    // 1411. number of ways to paint a N X 3 grid
    public int numOfWays(int n) {
        final int MOD = 1_000_000_007;
        long A = 6, B = 6;

        for (int i = 2; i <= n; i++) {
            long newA = (2 * A + 2 * B) % MOD;
            long newB = (2 * A + 3 * B) % MOD;
            A = newA;
            B = newB;
        }

        return (int) ((A + B) % MOD);
    }

















































































































}
