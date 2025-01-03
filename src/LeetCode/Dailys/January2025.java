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




    // 2270. number of ways to split array
    public int waysToSplitArray(int[] nums) {
//        int n = nums.length;
//
//        long[] prefix = new long[n];
//        prefix[0] = nums[0];
//
//        for (int i = 1; i < n; i++) {
//            prefix[i] = prefix[i - 1] + nums[i];
//        }
//
//
//        int count = 0;
//
//        for (int i = 0; i < n - 1; i++) {
//            long leftSum = prefix[i];
//            long rightSum = prefix[n - 1] - prefix[i];
//
//            if (leftSum >= rightSum) {
//                count++;
//            }
//        }
//        return count;


        /** another solution **/
        long leftSum = 0;
        long rightSum = 0;
        int count = 0;

        for (int num : nums) {
            rightSum += num;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            leftSum += nums[i];
            rightSum -= nums[i];

            if (leftSum >= rightSum) {
                count++;
            }
        }
        return count;

    }




}
