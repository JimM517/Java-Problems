package LeetCode.Hard;

import java.util.*;

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





    // 2416. Sum of prefix scores of strings

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        int count = 0;
    }

    TrieNode root = new TrieNode();

    void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new TrieNode();
            }
            node.next[c - 'a'].count++;
            node = node.next[c - 'a'];
        }
    }

    int count(String s) {
        TrieNode node = root;
        int answer = 0;

        for (char c : s.toCharArray()) {
            answer += node.next[c - 'a'].count;
            node = node.next[c - 'a'];
        }

        return answer;
    }

    public int[] sumPrefixScores(String[] words) {

        int N = words.length;

        for (int i = 0; i < N; i++) {
            insert(words[i]);
        }

        int[] scores = new int[N];

        for (int i = 0; i < N; i++) {
            scores[i] = count(words[i]);
        }


        return scores;

    }


    // smallest range covering elements from K lists
    public int[] smallestRange(List<List<Integer>> nums) {
            int k = nums.size();
            // Stores the current index of each list
            int[] indices = new int[k];
            // To track the smallest range
            int[] range = new int[] { 0, Integer.MAX_VALUE };

            while (true) {
                int curMin = Integer.MAX_VALUE, curMax =
                        Integer.MIN_VALUE, minListIndex = 0;

                // Find the current minimum and maximum values across the lists
                for (int i = 0; i < k; i++) {
                    int currentElement = nums.get(i).get(indices[i]);

                    // Update the current minimum
                    if (currentElement < curMin) {
                        curMin = currentElement;
                        minListIndex = i;
                    }

                    // Update the current maximum
                    if (currentElement > curMax) {
                        curMax = currentElement;
                    }
                }

                // Update the range if a smaller one is found
                if (curMax - curMin < range[1] - range[0]) {
                    range[0] = curMin;
                    range[1] = curMax;
                }

                // Move to the next element in the list that had the minimum value
                if (++indices[minListIndex] == nums.get(minListIndex).size()) break;
            }

            return range;
        }





        // 1106. parsing a boolean expression
        public boolean parseBoolExpression(String expression) {

            while (expression.length() > 1) {
                int start = Math.max(
                        expression.lastIndexOf('!'),
                        Math.max(
                                expression.lastIndexOf('&'),
                                expression.lastIndexOf('|')
                        )
                );
                int end = expression.indexOf(')', start);
                String subExpr = expression.substring(start, end + 1);
                char result = evaluateSubExpr(subExpr);
                expression = expression.substring(0, start) +
                        result +
                        expression.substring(end + 1);
            }
            return expression.charAt(0) == 't';
    }


    private char evaluateSubExpr(String subExpr) {

        char op = subExpr.charAt(0);
        String values = subExpr.substring(2, subExpr.length() - 1);

        if (op == '!') return values.charAt(0) == 't' ? 'f' : 't';
        if (op == '&') return values.contains("f") ? 'f' : 't';
        if (op == '|') return values.contains("t") ? 't' : 'f';
        return 'f';



    }




}
