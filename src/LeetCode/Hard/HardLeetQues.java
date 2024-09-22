package LeetCode.Hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class HardLeetQues {


    // 1639. Number of ways to form a target string given a dictionary
    /** Had this in an interview! **/
    public int numWays(String[] words, String target) {

        // brute force by backtracking or recursion?

        // O(w * k + t * k)

        // length of each word
        int n = words[0].length();
        // length of target string
        int m = target.length();
        int mod = 1000000007;
        // array to store number of ways to form the target string
        int[] dp = new int[m+1];
        dp[0] = 1;

        // store count of occurrences of each character at each position in the words array
        int[][] count = new int[n][26];
        for (String word : words) {
            for (int i = 0; i < n; i++) {
                count[i][word.charAt(i) - 'a']++;
            }
        }

        for (int i = 0; i < n; i++) {
            // iterate each position in words and each character in the target string in reverse order
            for (int j = m-1; j >= 0; j--) {
                dp[j+1] += (int)((long)dp[j] * count[i][target.charAt(j) - 'a'] % mod);
                dp[j+1] %= mod;
            }
        }

        return dp[m];

    }














    // 41. first missing positive
    public int firstMissingPositive(int[] nums) {

        for (int i = 0; i < nums.length; ) {
            if (nums[i] <= 0 || nums[i] >= nums.length || nums[i] - 1 == i || nums[i] == nums[nums[i] - 1]) i++;
            else {
                int index = nums[i] - 1;
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) {
                return i + 1;
            }
        }
       return nums.length + 1;
    }




    private static class Project {
        int capital;
        int profit;

        Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }


    // 502. IPO
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        // k is initial projects we can use at a time
        // w is initial capital

        int n = profits.length;
        List<Project> projects = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            projects.add(new Project(capital[i], profits[i]));
        }


        Collections.sort(projects, (a, b) -> a.capital - b.capital);


        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> y - x);


        int i = 0;


        for (int j = 0; j < k; j++) {

            while (i < n && projects.get(i).capital <= w) {
                maxHeap.add(projects.get(i).profit);
                i++;
            }

            if (maxHeap.isEmpty()) {
                break;
            }


            w += maxHeap.poll();
        }

        return w;

    }






    // 214. Shortest Palindrome
    public String shortestPalindrome(String s) {

        int len = s.length();

        String reversed = new StringBuilder(s).reverse().toString();

        for (int i = 0; i < len; i++) {
            if (s.substring(0, len - i).equals(reversed.substring(i))) {
                return new StringBuilder(reversed.substring(0, i)).append(s).toString();
            }
        }


        return "";
    }






    // 440 K-th smallest in lexicographical order
    public int findKthNumber(int n, int k) {
        // start at first lexicographical order
        int curr = 1;
        // decrement k because starts at 1, not 0
        k--;

        while (k > 0) {
            int steps = countLexSteps(curr, n);
            if (steps <= k) {
                // if there are fewer or equal steps than k, skip subtree
                curr++;
                k -= steps;
            }
            else {
                // if there are more steps, descend into the subtree
                curr *= 10;
                k--;
            }

        }
        return curr;
    }

    // will count steps between curr and curr + 1 in lexicographical tree
    public int countLexSteps(int curr, int limit) {
        long steps = 0;
        long first = 0;
        long last = curr;

        while (first <= limit) {

            steps += Math.min(last, limit) - first + 1;
            first *= 10;
            last = last * 10 + 9;
        }

        return (int) steps;

    }





}
