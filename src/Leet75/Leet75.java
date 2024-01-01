package Leet75;

import java.util.*;

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





    // 15. 3Sum
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> results = new ArrayList<>();

        // sort the array
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // skip duplicate elements for i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }


            int j = i + 1;
            int k = nums.length - 1;


            while (j < k) {

                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    // found a triplet with zero sum
                    results.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    // skip duplicate elements for j
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }

                    // skip duplicate elements for k
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }

                    // move pointers
                    j++;
                    k--;

                } else if (sum < 0) {
                    // sum is less than zero, increment j to increase sum
                    j++;
                } else {
                    // sum is greater than zero, decrement k to decrease the sum
                    k--;
                }



            }



        }



        return results;

    }



    // 11. Container with most water
    // TODO need to go over this!
    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int max = 0;


        while (left < right) {

            int w = right - left;
            int h = Math.min(height[left], height[right]);
            int area = h * w;


            max = Math.max(max, area);

            if (height[left] < height[right]) left++;
            else if (height[left] > height[right]) right--;
            else {
                left++;
                right--;
            }

        }

        return max;

    }


    // 191. Number of 1 Bits
    public int hammingWeight(int n) {
        // this works
        // return Integer.bitCount(n);

        int count = 0;

        while (n != 0) {
            count++;

            n &= (n - 1);


        }
        return count;


    }


    // 338. Counting Bits
    public int[] countBits(int n) {

        // result array, will hold the number of 1s
        int[] result = new int[n + 1];

        // set first index to 0 because count of 1s in 0 is 0
        result[0] = 0;

        for (int i = 1; i <= n; i++) {

            // store current number
            int temp = i;
            // counter to count the number of 1s
            int count = 0;

            // use bitwise AND operation to count the number of 1s
            while (temp != 0) {
                // remove the rightmost set bit
                temp = temp & (temp - 1);
                count++;
            }
            // store the count in result array
            result[i] = count;

        }
        return result;

    }


    // 268. Missing Number
    public int missingNumber(int[] nums) {

        int result = nums.length;


        for (int i = 0; i < nums.length; i++) {

            result += i - nums[i];

        }
        return result;

    }



    // 190. Reverse Bits
    public int reverseBits(int n) {

        int result = 0;

        for (int i = 0; i < 32; i++) {
            result = result << 1;
            if ((n & 1) == 1) {
                result = result | 1;
            }
            n = n >> 1;
        }

        return result;

    }


    // 70. Climbing Stairs
    public int climbStairs(int n) {

        // dynamic programming - bottom up approach
        // basically use fibonacci numbers to solve

        int one = 1;
        int two = 1;


        for (int i = 0; i < n - 1; i++) {

           int temp = one;
           one = one + two;
           two = temp;
        }
        return one;
    }



    // 322. Coin Change
    /** not my solution, need to review **/
    // TODO review this!
    public int coinChange(int[] coins, int amount) {

        // dynamic programming approach -> bottom up

        int[] dp = new int[(amount + 1)];

        for (int i = 1; i <= amount; i++) {

            int min = Integer.MAX_VALUE;

            for (int j = 0; j < coins.length; j++) {

                if (i >= coins[j] && dp[i - coins[j]] != -1) {
                    min = Math.min(min, dp[i - coins[j]]);
                }

            }

            dp[i] = (min == Integer.MAX_VALUE) ? -1 : min + 1;
        }
        return dp[amount];
    }


    // 300 Longest Increasing Subsequence
    public int lengthOfLIS(int[] nums) {

        // store the length of LIS at each index
        int[] cache = new int[nums.length];

        // start at the last index
        for (int i  = nums.length - 1; i >= 0; i--) {

            int max = Integer.MIN_VALUE;

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] < nums[j]) {
                    // update max to store max length if nums[i] is < nums[j]
                    max = Math.max(max, 1 + cache[j]);

                }

            }
            // update cache to store max
            // if this is still integer.min_value, no element was > nums[i] so we return 1
            cache[i] = (max == Integer.MIN_VALUE) ? 1 : max;


        }

        int result = 0;

        // loop through cache array to return the greatest max value
        // set to result
        for (int len : cache) {
            result = Math.max(result, len);
        }

        // and then return result
        return result;
    }


    // 1143. Longest Common Subsequence
    // TODO review this!
    public int longestCommonSubsequence(String text1, String text2) {

            int n = text1.length();
            int m = text2.length();


            int[][] dp = new int[n + 1][m + 1];

            for (int i = 1; i <= n; i++) {

                for (int j = 1; j <= m; j++) {

                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    }
                    else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[n][m];
    }




    // 139. Word Break
    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length()];

        for (int i = 0; i < dp.length; i++) {

            for (int j = 0; j <= i; j++) {

                if (j == 0 || dp[j - 1]) {
                    if (wordDict.contains(s.substring(j, i + 1))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[dp.length - 1];
    }


    // 39. Combination Sum
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

            List<List<Integer>> list = new ArrayList<>();

            Arrays.sort(candidates);

            backtrack(list, new ArrayList<>(), candidates, target, 0);

            return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {

        if (remain < 0) {
            return;
        } else if (remain == 0) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < nums.length; i++) {
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }



    // 198. House Robber
    public int rob(int[] nums) {

        // two variables to represent the max amount of money from previous two houses
        int rob1 = 0;
        int rob2 = 0;

        for (int i = 0; i < nums.length; i++) {

            // nums[i] + rob1 will be max amount from two positions before
            // rob2 will be the previous house
            int temp = Math.max(nums[i] + rob1, rob2);

            // update rob1 to now hold previous house
            rob1 = rob2;
            // rob2 is now the current house
            rob2 = temp;


        }
        // return rob2 because this will be max amount at the end
        return rob2;


    }




    // House Robber
    public int robTwo(int[] nums) {

        // cant rob first and last house as they are neighbors

        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int s1 = helpRob(nums, 0, n - 2);
        int s2 = helpRob(nums, 1, n - 1);

        return Math.max(s1, s2);
    }


    // use same solution from rob I as helper function with a little modification
    public int helpRob(int[] nums, int l, int r) {

        int a = 0;
        int b = nums[l];

        for (int i = l + 1; i <= r; i++) {
            int temp = Math.max(nums[i] + a, b);

            a = b;

            b = temp;
        }
        return b;
    }











}
