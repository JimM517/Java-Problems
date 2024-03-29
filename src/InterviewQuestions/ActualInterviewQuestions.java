package InterviewQuestions;

public class ActualInterviewQuestions {

    /*** All of the questions listed here are from actual interviews so far ***/

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










    // remove vowels, return string
    public String removeVowels(String str) {

        if (str == null) {
            return null;
        }


        String result = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!hasVowel(ch)) {
                result += str.charAt(i);
            }
        }


        return result;

    }

    public static boolean hasVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) != -1;
    }







    // count occurrences of substring in parent
    public int countSubstringOccurrences(String parent, String sub) {

        if (parent == null || sub == null) {
            return 0;
        }


        int count = 0;
        int index = parent.indexOf(sub);
        while (index != -1) {
            count++;
            index = parent.indexOf(sub, index + 1);
        }

        return count;
    }




















}
