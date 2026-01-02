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























































































































}
