package InterviewQuestions;

import java.util.*;

public class InterviewPrep {

    // 151 Reverse Words in a string
    public String reverseWords(String s) {
//        StringBuilder sb = new StringBuilder();
//
//        String[] strings = s.split(" ");
//        for (int i = strings.length - 1; i >= 0; i--) {
//            sb.append(strings[i]);
//        }
//        return sb.toString();

        // trying another solution to remove white space
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



    // 200  Number of islands
    public int numIslands(char[][] grid) {

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    clearRestOfLand(grid, i, j);
                }
            }
        }

        return count;
    }

    private void clearRestOfLand(char[][] grid, int i, int j) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0') return;

        grid[i][j] = '0';
        clearRestOfLand(grid, i + 1, j);
        clearRestOfLand(grid, i - 1, j);
        clearRestOfLand(grid, i, j + 1);
        clearRestOfLand(grid, i, j - 1);
        return;

    }



    // 1304 Find N unique integers sum up to zero
    public int[] sumZero(int n) {

        int d = -(n / 2);

        int[] result = new int[n];

        if (n % 2 == 0) {
            for (int i = 0; i < n; i++) {
                result[i] = d;
                d = d + 1;
            }
        } else {
            for (int i = 0; i < n; i++) {
                result[i] = d;
                d = d + 1;
            }
        }
        return result;
    }


    // 53 Maximum Subarray
    // find maximum subarray with the largest sum, return the sum
    public int maxSubArray(int[] nums) {

        // Kadane's algorithm

        int startTotal = Integer.MIN_VALUE;
        int endTotal = 0;

        for (int i = 0; i < nums.length; i++) {
            endTotal += nums[i];
            if (startTotal < endTotal) {
                startTotal = endTotal;
            }
            if (endTotal < 0) {
                endTotal = 0;
            }
            return startTotal;

        }



        return 0;
    }



    // 121 Best Time to Buy and Sell Stock

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
               int currProfit = prices[i] - start;
               if (currProfit > maxProfit) {
                   maxProfit = currProfit;
               }
           }
       }
       return maxProfit;
    }



    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return rec1[0] < rec2[2] && rec1[1] < rec2[3] && rec1[2] > rec2[0] && rec1[3] > rec2[1];
    }






    /******** Interview Prep for New Year 2024 ********/

    /**** EASY  ****/


    // 202. Happy Number
    public boolean isHappy(int n) {

        // keep track of numbers already seen during the loop
        Set<Integer> seenNumbers = new HashSet<>();

        while (n != 1 && !seenNumbers.contains(n)) {

            // add current number to seenNumbers
            seenNumbers.add(n);

            // convert to string to iterate through the digits
            String str = String.valueOf(n);

            int sum = 0;

            // calculate the sum of each digit squared
            for (int i = 0; i < str.length(); i++) {

                int digit = Character.getNumericValue(str.charAt(i));

                sum += digit * digit;


            }

            // update our sum
            n = sum;


        }

        // if n == 1 we are happy aka true
        return n == 1;

    }





    // 20. Valid Parentheses
    public boolean isValid(String s) {

        Stack<Character> checkParen = new Stack<>();

        for (char c : s.toCharArray()) {

            if (c == '(' || c == '{' || c == '[') {
                checkParen.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (checkParen.isEmpty()) {
                    return false;
                }


                char top = checkParen.pop();

                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return false;
                }

            }




        }

        return checkParen.isEmpty() ? true : false;
    }





    // 121. Best time to buy and sell stock
    public int maxProfitRevisited(int[] prices) {

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




    // 9. Palindrome Number
    public boolean isPalindrome(int x) {

        String numToStr = Integer.toString(x);

        int start = 0;
        int end = numToStr.length() - 1;


        while (start < end) {

            if (numToStr.charAt(start) != numToStr.charAt(end)) {
                return false;
            }

            start++;
            end--;

        }
        return true;

    }



    //1. Two Sum.....again
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






    // 7. Reverse Integer
    public int reverse(int x) {


        boolean isNegative = x < 0;

        long num = Math.abs((long) x);

        long reversed = 0;

        while (num > 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }


        if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
            return 0;
        }


        if (isNegative) {
            reversed = -reversed;
        }


        return (int) reversed;


    }





    // 53. Maximum Subarray
    public int maxSubArrayRevisited(int[] nums) {

        int start = Integer.MIN_VALUE;

        int end = 0;


        for (int i = 0; i < nums.length; i++) {

            end += nums[i];

            if (start < end) {
                start = end;
            }

            if (end < 0) {
                end = 0;
            }

        }

        return start;
    }







    // 349 Intersection of Two Arrays
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> num1Count = new HashSet<>();

        Set<Integer> num2Count = new HashSet<>();

        for (int num : nums1) {
            num1Count.add(num);
        }

        for (int num : nums2) {
            if (num1Count.contains(num)) {
                num2Count.add(num);
            }
        }

        int[] result = new int[num2Count.size()];

        int index = 0;

        for (int num : num2Count) {
            result[index++] = num;
        }

        return result;

    }





    // 387. First Unique Character String
    public int firstUniqChar(String s) {

        Map<Character, Integer> count = new HashMap<>();

        for (char c : s.toCharArray()) {

            count.put(c, count.getOrDefault(c, 0) + 1);
        }


        for (int i = 0; i < s.length(); i++) {

           if (count.get(s.charAt(i)) == 1) return i;

        }
        return -1;

    }





    /**** MEDIUM ****/

    // 322. Coin Change

    public int coinChange(int[] coins, int amount) {

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






    // 1328. Break a Palindrome
    public String breakPalindrome(String palindrome) {

        int length = palindrome.length();

        if (length == 1) {
            return "";
        }

        char[] ch = palindrome.toCharArray();

        // only iterate first half, in a palindrome, the halves are mirrors of each other
        int itrLen = (length / 2) - 1;

        for (int i = 0; i <= itrLen; i++) {

            // if char at index i != a, we replace with a because this will make it lexicographically smaller
            if (ch[i] != 'a') {
                ch[i] = 'a';
                return String.valueOf(ch);
            }

        }

        // replace one char with b if all are 'a' to make it smallest
        ch[length - 1] = 'b';
        return String.valueOf(ch);

    }






    // 31. Next Permutation
    public void nextPermutation(int[] nums) {


        // find point of change
        // find number for substitution

        int i = nums.length - 2;

        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;

            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        reverse(nums, i + 1);

    }



    private void swap(int[] nums, int i, int j) {


        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    private void reverse(int[] nums, int start) {

        int end = nums.length - 1;

        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }


    }





    // 17. Letter Combinations of a Phone Number
    public List<String> letterCombinations(String digits) {

        if (digits.isEmpty()) {
            return Collections.emptyList();
        }

        String[] phoneNums = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        List<String> result = new ArrayList<>();

        stringBT("", digits, phoneNums, result);

        return result;
    }


    private void stringBT(String combination, String nextDigits, String[] phoneNums, List<String> result) {


        if (nextDigits.isEmpty()) {
            result.add(combination);
        } else {
            String letters = phoneNums[nextDigits.charAt(0) - '2'];
            for (char letter : letters.toCharArray()) {
                stringBT(combination + letter, nextDigits.substring(1), phoneNums, result);
            }
        }



    }




    // 5. Longest Palindromic Substring
    public String longestPalindrome(String s) {

        String result = "";
        int resultLen = 0;


        for (int i = 0; i < s.length(); i++) {

            // expand around the center with current character as center
            // odd length
            int left = i;
            int right = i;



            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {

                // update result if the current palindrome is longer
                if ((right - left + 1) > resultLen) {

                    result = s.substring(left, right + 1);
                    resultLen = right - left + 1;
                }
                left -= 1;
                right += 1;
            }

            // expand around the center with current and next character as centers
            // even length
            left = i;
            right = i + 1;


            while ((left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))) {
                // update result if the current palindrome is longer
                if ((right - left + 1) > resultLen) {
                    result = s.substring(left, right + 1);
                    resultLen = right - left + 1;
                }
                left -= 1;
                right += 1;

            }


        }




        return result;

    }





    // 33. Search in Rotated Sorted Array
    public int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;


        while (start <= end) {

            int mid = (start + end) / 2;


            if (nums[mid] == target) {
                return mid;
            }

            else if (nums[start] <= nums[mid]) {
                if (target > nums[mid] || target < nums[start]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

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




    // 215. Kth Largest Element Array
    public int findKthLargest(int[] nums, int k) {


            PriorityQueue<Integer> p = new PriorityQueue<>();

            for (int x : nums) {
                p.offer(x);

                if (p.size() > k) {
                    p.poll();
                }
            }


        return p.peek();


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
            for (int i = 0; i < nums.length; i++) {
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i);
                tempList.remove(tempList.size() - 1);
            }
        }


    }






    /**** HARD ****/

    // 4. Median of Two Sorted Arrays
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;

        int[] arr = new int[m + n];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < n & j < m) {
            if (nums1[i] < nums2[j]) {
                arr[k] = nums1[i];
                i++;
                k++;
            } else {
                arr[k] = nums2[j];
                j++;
                k++;
            }
        }

        while (i < n) {
            arr[k] = nums1[i];
            i++;
            k++;
        }

        while (j < m) {
            arr[k] = nums2[j];
            j++;
            k++;
        }


        int length = arr.length;

        double median = 0;

        int ans = length / 2;

        if (length % 2 == 0) {
            median = arr[ans - 1] + arr[ans] / 2.0;
        } else {
            median = arr[ans];
        }
        return median;
    }












}
