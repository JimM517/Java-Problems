package Leet75;

import java.util.HashMap;
import java.util.Map;

public class Leet75 {


    // 1. two sum
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> result = new HashMap<>();


        for (int i = 0; i < nums.length; i++) {

            if (result.containsKey(target - nums[i])) {
                return new int[]{result.get(target - nums[i]), i};
            } else {
                result.put(nums[i], i);
            }



        }
        return new int[]{-1, -1};
    }




    // 121. Best Time to Buy and Sell Stock
    public int maxProfit(int[] prices) {

        if (prices.length == 0) {
            return 0;
        }

        int start = prices[0];
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {

            if (prices[i] < start) {
                start = prices[i];
            } else {
                int currentProfit = prices[i] - start;

                if (currentProfit > maxProfit) {
                    maxProfit = currentProfit;
                }
            }
        }

        return maxProfit;
    }


    // 217. contains duplicates
    public boolean containsDuplicates(int[] nums) {

        Map<Integer, Integer> result = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (result.containsKey(nums[i])) {
                return true;
            } else {
                result.put(nums[i], i);
            }


        }

        return false;

    }




    // 238. product of array except self
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        int[] result = new int[n];


        int prefix = 1;
        for (int i = 0; i < n; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }

        int postfix = 1;
        for (int i = n - 1; i >= 0; i--) {

            result[i] *= postfix;
            postfix *= nums[i];


        }

        return result;
    }










}
