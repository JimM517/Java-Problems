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






    // 1390. four divisors
    public int sumFourDivisors(int[] nums) {

        int totalSum = 0;

        for (int n : nums) {
            int sum = 0;
            int count = 0;

            for (int d = 1; d * d <= n; d++) {
                if (n % d == 0) {
                    int other = n / d;

                    sum += d;
                    count++;

                    if (other != d) {
                        sum += other;
                        count++;
                    }

                    if (count > 4) break;
                }
            }

            if (count == 4) {
                totalSum += sum;
            }
        }

        return totalSum;
    }




    // 1975. maximum matrix sum
    public long maxMatrixSum(int[][] matrix) {

        long totalSum = 0;
        int minAbsVal = Integer.MAX_VALUE;
        int negativeCount = 0;

        for (int[] row : matrix) {
            for (int val : row) {
                totalSum += Math.abs(val);
                if (val < 0) {
                    negativeCount--;
                }
                minAbsVal = Math.min(minAbsVal, Math.abs(val));
            }
        }

        if (negativeCount % 2 != 0) {
            totalSum -= 2 * minAbsVal;
        }

        return totalSum;
    }







































































































}
