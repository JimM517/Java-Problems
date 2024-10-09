package LeetCode.Medium;

import java.util.Stack;

public class MediumContinued {


    // 72. edit distance
    public int minDistance(String word1, String word2) {

      int m = word1.length();
      int n = word2.length();

      int[][] dp = new int[m + 1][n + 1];

      for (int i = 0; i <= n; i++) {
          dp[0][i] = i;
      }
      for (int i = 0; i <= m; i++) {
          dp[i][0] = i;
      }

      for (int i = 1; i <= m; i++) {
          for (int j = 1; j <= n; j++) {

              if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                  dp[i][j] = dp[i - 1][j - 1];
              } else {
                  dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
              }


          }
      }

        return dp[m][n];
    }




    // 1813. sentence similarity III
    public boolean areSentencesSimilar(String sentence1, String sentence2) {

        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");

        int i = 0;
        int j = 0;

        while (i < s1.length && i < s2.length && s1[i].equals(s2[i])) {
            i++;
        }

        while (j < s1.length - i && j < s2.length - i && s1[s1.length - 1 - j].equals(s2[s2.length - 1 - j])) {
            j++;
        }


        return i + j == s1.length || i + j == s2.length;

    }




    // 1963. Minimum number of swaps to make the string balanced
    public int minSwaps(String s) {

        Stack<Character> stack = new Stack<>();

        int start = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            if (ch == '[') {
                stack.push(ch);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    start++;
                }
            }


        }

        return (start + 1) / 2;



    }




    // 921. Minimum add to make parentheses valid
    public int minAddToMakeValid(String s) {

        int opens = 0;
        int closed = 0;

        for (Character ch : s.toCharArray()) {

            if (ch == '(') {
                closed++;
            } else {
                if (closed == 0) {
                    opens++;
                } else {
                    closed--;
                }
            }


        }


        return opens + closed;

    }

















}
