package ReviewProblems;

import java.util.*;

public class LeetCode150 {

    /** This class is just intended to review leetcode 150, contains dups **/

    /** Array/Strings **/


    // 88. Merge Sorted Array
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // index of last nums1 element
       int i = m - 1;
       // index of last nums2 element
       int j = n - 1;

       // index of last element in return array nums1
       int k = m + n - 1;

       // traverse nums2 to compare nums
        while (j >= 0) {

            // i  greater than 0 and nums1[i] > nums2[j]
            // make nums[k] our current nums1[i] value and decrement
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
                // this condition will run once i < 0 (no more elements in nums1
                // or nums2[j] is greater, effectively moving greater element to the end
            } else {
                nums1[k--] = nums2[j--];
            }

        }

    }





        // 27. Remove Element
        public int removeElement(int[] nums, int val) {

            int k = 0;

            for (int i = 0; i < nums.length; i++) {

                if (nums[i] != val) {
                    nums[k] = nums[i];
                    k++;
                }
            }
            return k;

    }






    //26 Remove duplicates from sorted array
    public int removeDuplicates(int[] nums) {

//       THIS WORKS

//        if (nums.length == 0) {
//            return 0;
//        }
//
//
//        Set<Integer> dups = new HashSet<>();
//
//        int k = 0;
//
//
//        for (int i = 0; i < nums.length; i++) {
//            if (!dups.contains(nums[i])) {
//                nums[k++] = nums[i];
//                dups.add(nums[i]);
//            }
//        }


        int k = 1;

        for (int i = 1; i < nums.length ; i++) {

            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }

        }


        return k;

    }





    // 80. Remove Duplicates from Sorted Array II
    public int removeDuplcatesTwo(int[] nums) {

        if (nums.length <= 2) {
            return nums.length;
        }


        int k = 2;

        for (int i = 2; i < nums.length; i++) {

            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }




    // 169 Majority Element
    int majorityElement(int[] nums) {

        int n = nums.length;

        int maj = 0;
        int majorityCount = 0;


        Map<Integer, Integer> result = new HashMap<>();
        for (int num : nums) {
            result.put(num, result.getOrDefault(num, 0) + 1);
        }



        for (Map.Entry<Integer, Integer> res : result.entrySet()) {

            int curr = res.getValue();

            if (curr > majorityCount && curr > n / 2) {
                maj = res.getKey();
                majorityCount = curr;
            }
        }
        return maj;

    }




    // 189. Rotate Array
    public static void rev(int[] arr, int start, int end) {

            while (start < end) {

                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
    }

    public void rotate(int[] nums, int k) {

        k = k % nums.length;

        int d = nums.length - k;

        rev(nums, 0, d - 1);
        rev(nums, d, nums.length - 1);
        rev(nums, 0, nums.length - 1);
    }




    // another solution for rotate
    public void revAgain(int[] arr, int k) {


        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[(i + k) % arr.length] = arr[i];
        }


        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }

    }






    // 121. Best time to buy and sell stock
    public int maxProfit(int[] prices) {

        // nothing in array, return 0
        if (prices.length == 0) {
            return 0;
        }

        // set initial value to compare
        int start = prices[0];

        // maxProfit will be compared and used later
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {

            // if our prices[i] is < start, we reset start to the lower value
            // we want the lower value to see potential maximum profits
            if (prices[i] < start) {
                start = prices[i];
            } else {
                // our prices were bigger, get difference
                int currentProfit = prices[i] - start;

                // if the difference is greater than out current profit, set it to max
                if (currentProfit > maxProfit) {
                    maxProfit = currentProfit;
                }


            }
        }
        // return max
        return maxProfit;
    }






    // 122. Best time to buy and sell stock II
    public int maxProfitTwo(int[] prices) {

        // if array is empty, return 0
        if (prices.length == 0) {
            return 0;
        }

        // set initial max profit
        int maxProfit = 0;

        // start loop at one because we want to compare previous amount
        for (int i = 1; i < prices.length; i++) {

            // if our current prices[i] is greater than our previous
            // continue
            if (prices[i] > prices[i - 1]) {
                // set out max profit to the difference of our prices[i] and the previous value
                maxProfit += prices[i] - prices[i - 1];
            }
        }

        // return our max profit
        return maxProfit;


    }







    // 55. Jump game
    public boolean canJump(int[] nums) {

        // get the last index
        int len = nums.length - 1;


        // start at the end of array
        for (int i = len; i >= 0; i--) {

            // if our current index of i + the value of nums[i] is greater than len
            // we can reach the last index, return true;
            if (i + nums[i] >= len) {
                return true;
            }

        }
        // return our length = 0 if it only has one element
        // it will return false, meaning we can't get to last index
        return len == 0;
    }




    // 45. Jump game II
    public int jump(int[] nums) {

        int len = nums.length - 1;

        // furthest index that can be reached
        int end = 0;

        // max position that can be reached with current i
        int maxPosition = 0;

        // step counter
        int steps = 0;

        for (int i = 0; i < len; i++) {

            // the current max index that can be reached with i and nums[i]
            maxPosition = Math.max(maxPosition, i + nums[i]);

            // if our i == end, we have reached maximum distance with current number of jumps
            if (i == end) {
                // set the end to max position, furthest reachable index with at least one more jump
                end = maxPosition;
                // increment steps
                steps++;
            }

        }

        // this is our min, return
        return steps;

    }






    // 274. H-Index
    public int hIndex(int[] citations) {

        Arrays.sort(citations);

        int n = citations.length;

        for (int i = 0; i < n; i++) {

            int h = n - i;

            if (citations[i] >= h) {
                return h;
            }

        }

        return 0;




    }




    // 238. product of array except self
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        int[] prefixes = new int[n];

        int prefix = 1;

        for (int i = 0; i < n; i++) {

                prefixes[i] = prefix;

                prefix *= nums[i];
        }



        int postfix = 1;

        for (int i = n - 1; i >= 0; i--) {

            prefixes[i] *= postfix;

            postfix *= nums[i];

        }
        return prefixes;

    }






    // 134. gas station
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totalGas = 0;

        int totalCost = 0;

        int tank = 0;

        int startStation = 0;


        for (int i = 0; i < gas.length; i++) {

            totalGas += gas[i];

            totalCost += cost[i];


            tank += gas[i] - cost[i];

            // reset if tank goes below 0
            if (tank < 0) {

                startStation = i + 1;
                tank = 0;

            }

        }



        return totalGas < totalCost ? -1 : startStation;


    }






    // 42. Trapping Rain Water
    public int trap(int[] height) {

        int[] lmax = new int[height.length];
        int[] rmax = new int[height.length];

        int max = Integer.MIN_VALUE;

        // find left max
        for (int i = 0; i < height.length; i++) {
            if (max < height[i]) {
                max = height[i];
            }
            lmax[i] = max;
        }

        max = Integer.MIN_VALUE;

        // find right max
        for (int i = height.length - 1; i >= 0; i--) {

            if (max < height[i]) {
                max = height[i];
            }
            rmax[i] = max;

        }

        // find how many units of rain water trapped
        int count = 0;
        for (int i = 0; i < height.length; i++) {
            count += (Math.min(lmax[i], rmax[i]) - height[i]);
        }


        return count;

    }



    // 58. Length of last word
    public int lengthOfLastWord(String s) {

        String[] split = s.split(" ");

        return split[split.length - 1].length();

    }






    // 14. Longest common prefix
    public String longestCommonPrefix(String[] strings) {

        if (strings == null || strings.length == 0) {
            return "";
        }


        int minLen = Integer.MAX_VALUE;
        for (String str : strings) {
            minLen = Math.min(minLen, str.length());
        }



        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < minLen; i++) {

            char current = strings[0].charAt(i);

            for (int j = 1; j < strings.length; j++) {

                if (current != strings[j].charAt(i)) {
                    return sb.toString();
                }

            }

            sb.append(current);

        }

        return sb.toString();

    }




    // 151. Reverse words in a string
    public String reverseWords(String s) {

        s = s.trim().replaceAll("\\s+", " ");

        String[] strings = s.split(" ");

        StringBuilder sb = new StringBuilder();

        for (int i = strings.length - 1; i >= 0; i--) {

            sb.append(strings[i]);

            if (i > 0) {
                sb.append(" ");
            }

        }

        return sb.toString();

    }



    // Zig zag conversion
    public String convert(String s, int numRows) {

        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }


        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }


        int index = 0;
        int direction = -1;

        for (char c : s.toCharArray()) {
            rows[index].append(c);
            if (index == 0 || index == numRows - 1) {
                direction = -direction;
            }
            index += direction;
        }


        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }


        return result.toString();


    }




    // 28. find the index of the first occurrence in a string
    public int strStr(String haystack, String needle) {


        return haystack.indexOf(needle);


    }





    /** Two Pointers **/


    // 125. Valid Palindrome
    public boolean isPalindrome(String s) {

        s= s.toLowerCase().replaceAll("[^a-z0-9]", "");

        int start = 0;
        int end = s.length() - 1;


        while (start <= end) {

            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;


        }

        return true;


    }















}
