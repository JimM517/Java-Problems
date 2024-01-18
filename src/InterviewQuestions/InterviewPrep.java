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







}
