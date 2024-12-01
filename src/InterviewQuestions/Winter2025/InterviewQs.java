package InterviewQuestions.Winter2025;

import java.util.*;

public class InterviewQs {

    /** Mix of easy, medium and hard interview questions for 2024/25 **/


    // 1529. Minimum suffix flips
    public int minFlips(String target) {

        int max = 0;
        char bit = '0';

        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) != bit) {
                max++;
                bit = target.charAt(i);
            }
        }
        return max;
    }






    // 1200. Minimum absolute difference
    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 1; i++) {
            int difference = arr[i + 1] - arr[i];

            if (difference < min) {
                min = difference;

                result.clear();
                result.add(Arrays.asList(arr[i], arr[i + 1]));
            } else if (difference == min) {
                result.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }
        return result;
    }






    // 387. first unique character in a string
    public int firstUniqChar(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {

            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }


        return -1;
    }




    // 1356. sort integer by number of 1 bits
    public int[] sortByBits(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            arr[i] += Integer.bitCount(arr[i]) * 10001;
        }

        Arrays.sort(arr);


        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] % 10001;
        }
        return arr;
    }





    // 2068. check whether two strings are almost equivalent
    public boolean checkAlmostEquivalent(String word1, String word2) {

        if (word1.length() != word2.length()) {
            return false;
        }

        Map<Character, Integer> answer = new HashMap<>();
        for (int i = 0; i < word1.length(); i++) {
            answer.put(word1.charAt(i), answer.getOrDefault(word1.charAt(i), 0) + 1);
            answer.put(word2.charAt(i), answer.getOrDefault(word2.charAt(i), 0) - 1);

        }

        for (int i : answer.values()) {
            if (i > 3 || i < -3) {
                return false;
            }
        }
        return true;
    }







}
