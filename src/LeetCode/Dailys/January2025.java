package LeetCode.Dailys;

import java.util.*;

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





    // 1930. unique length-3 palindromic subsequences
    public int countPalindromicSubsequence(String s) {

       Set<Character> letters = new HashSet<>();
       for (Character ch : s.toCharArray()) {
           letters.add(ch);
       }

       int answer = 0;
       for (Character letter : letters) {
           int i = -1;
           int j = 0;


           for (int k = 0; k < s.length(); k++) {
               if (s.charAt(k) == letter) {
                   if (i == -1) {
                       i = k;
                   }
                   j = k;
               }
           }

           Set<Character> between = new HashSet<>();
           for (int k = i + 1; k < j; k++) {
               between.add(s.charAt(k));
           }
           answer += between.size();
       }
        return answer;
    }




    // 2381. shifting letters II
    public String shiftingLetters(String s, int[][] shifts) {

        int n = s.length();
        int[] diffArray = new int[n];

        for (int[] shift : shifts) {
            if (shift[2] == 1) {
                diffArray[shift[0]]++;
                if (shift[1] + 1 < n) {
                    diffArray[shift[1] + 1]--;
                }
            } else {
                diffArray[shift[0]]--;
                if (shift[1] + 1 < n) {
                    diffArray[shift[1] + 1]++;
                }
            }
        }

        StringBuilder answer = new StringBuilder(s);
        int numberOfShifts = 0;

        for (int i = 0; i < n; i++) {
            numberOfShifts = (numberOfShifts + diffArray[i]) % 26;

            if (numberOfShifts < 0) {
                numberOfShifts += 26;
            }

            char shiftedChar = (char) ('a' + ((s.charAt(i) - 'a' + numberOfShifts) % 26));
            answer.setCharAt(i, shiftedChar);
        }
        return answer.toString();
    }



    // 1769. minimum number of operations to move all balls in each box
    public int[] minOperations(String boxes) {
        int[] answer = new int[boxes.length()];
        for (int currentBox = 0; currentBox < boxes.length(); currentBox++) {
            if (boxes.charAt(currentBox) == '1') {
                for (int newPosition = 0; newPosition < boxes.length(); newPosition++) {
                    answer[newPosition] += Math.abs(newPosition - currentBox);
                }
            }
        }
        return answer;
    }




    // 1408. string matching in an array
    public List<String> stringMatching(String[] words) {

        List<String> matchingWords = new ArrayList<>();
        for (int currentWordIndex = 0; currentWordIndex < words.length; currentWordIndex++) {
            for (int otherWordIndex = 0; otherWordIndex < words.length; otherWordIndex++) {
                if (currentWordIndex == otherWordIndex) continue;
                if (isSubstringOf(words[currentWordIndex], words[otherWordIndex])) {
                    matchingWords.add(words[currentWordIndex]);
                    break;
                }
            }
        }
        return matchingWords;
    }

    private boolean isSubstringOf(String sub, String main) {
        for (int startIndex = 0; startIndex < main.length(); startIndex++) {
            boolean subFits = true;

            for (int subIndex = 0; subIndex < sub.length(); subIndex++) {
                if (startIndex + subIndex >= main.length() || main.charAt(startIndex + subIndex) != sub.charAt(subIndex)) {
                    subFits = false;
                    break;
                }
            }
            if (subFits) {
                return true;
            }

        }

        return false;
    }

































}
