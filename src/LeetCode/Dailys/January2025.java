package LeetCode.Dailys;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class January2025 {


    // 1422. maximum score after splitting a string
    public int maxScore(String s) {

        int result = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            int current = 0;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == '0') {
                    current++;
                }
            }

            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) == '1') {
                    current++;
                }
            }
            result = Math.max(result, current);
        }
        return result;
    }




    // 2559 count vowels strings in ranges
    public int[] vowelStrings(String[] words, int[][] queries) {

        int[] result = new int[queries.length];

        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        int[] prefixSum = new int[words.length];
        int sum = 0;

        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];
            if (vowels.contains(currentWord.charAt(0)) && vowels.contains(currentWord.charAt(currentWord.length() - 1))) {
                sum++;
            }
            prefixSum[i] = sum;
        }

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            result[i] = prefixSum[query[1]] - (query[0] == 0 ? 0 : prefixSum[query[0] - 1]);
        }
        return result;
    }




}
