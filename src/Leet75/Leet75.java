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


    // 53. Maximum subarray
    public int maxSubArray(int[] nums) {

    /** Solution One **/
//      int start = Integer.MIN_VALUE;
//      int end = 0;
//
//
//      for (int i = 0; i < nums.length; i++) {
//
//          end += nums[i];
//
//          if (start < end) {
//              start = end;
//          }
//
//          if (end < 0) {
//              end = 0;
//          }
//
//      }
//
//      return start;

        /** Solution Two **/

        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            max = Math.max(sum, max);

            if (sum < 0) {
                sum = 0;
            }
        }

        return max;
    }



    // 152. Maximum product subarray
    public int maxProduct(int[] nums) {

        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int temp = max;

            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);

            if (max > ans) {
                ans = max;
            }


        }
        return ans;
    }


    // 153. Find Minimum in rotated sorted array
    public int findMin(int[] nums) {

        // binary search approach
        // O (log n)
        int left = 0;
        int right = nums.length - 1;

       while (left < right) {
           int mid = left + (right - left) / 2;
           // if nums[mid] > nums[right] the minimum must be in the right portion
           if (nums[mid] > nums[right]) {
               left = mid + 1;
               // the minimum must be in the left portion
           } else {
               right = mid;
           }
       }

        return nums[left];


    }



    // 33. Search in rotated sorted array
    public int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;


        while (start <= end) {

            int mid = (start + end) / 2;

            if (nums[mid] == target) {
                // target found, exit
                return mid;
            }

            // left portion
            else if (nums[start] <= nums[mid]) {
                if (target > nums[mid] || target < nums[start]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            // right portion
            else {
                if (target < nums[mid] || target > nums[end]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }



        }



        return -1;

    }






}
