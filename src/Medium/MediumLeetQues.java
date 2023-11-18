package Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MediumLeetQues {


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



    // 334. increasing triplet subsequence
    public boolean increasingTriplet(int[] nums) {

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;


        for (int num : nums) {
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
            } else {
                return true;
            }
        }

        return false;

    }



    // 392. Is subsequence
    public boolean isSubsequence(String s, String t) {

        int sPointer = 0;

        for (int tPointer = 0; tPointer < t.length() && sPointer < s.length(); tPointer++) {
            if (s.charAt(sPointer) == t.charAt(tPointer)) {
                sPointer++;
            }
        }

        return sPointer == s.length();


    }



    // 153. Find Minimum in Rotated Sorted Array

    public int findMin(int[] nums) {
        // need in O(log n)
        int left = 0;
        int right = nums.length - 1;


        while (left < right) {

            int mid = left + (right - left) / 2;


            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }
        return nums[left];

    }





    // 3. Longest Substring without repeating characters
    public int lengthOfLongestSubstring(String s) {

        // sliding window
        // O(n)

        Set<Character> characterSet = new HashSet<>();

        int left = 0;
        int right = 0;

        int count = 0;

        while (right < s.length()) {

            if (characterSet.contains(s.charAt(right))) {
               characterSet.remove(s.charAt(left));
               left++;
            } else {
                characterSet.add(s.charAt(right));
                count = Math.max(count, right - left + 1);
                right++;
            }


        }


        return count;



    }



    // 424. longest repeating character replacement
    public int characterReplacement(String s, int k) {

        // O(n)
        // sliding window
        // the longest substring that contains a single character
        // HashMap

        int left = 0;
        int right = 0;

        int result = 0;
        int maxCount = 0;

        Map<Character, Integer> charMap = new HashMap<>();


        while (right < s.length()) {

            charMap.put(s.charAt(right), charMap.getOrDefault(s.charAt(right), 0) + 1);

            maxCount = Math.max(maxCount, charMap.get(s.charAt(right)));


            if ((right - left + 1) - maxCount > k) {
                charMap.put(s.charAt(left), charMap.get(s.charAt(left) - 1));
                left++;
            }

            result = Math.max(result, right - left + 1);
            right++;


        }

        return result;
    }



    // 567. Permutation in String

    public boolean checkInclusion(String s1, String s2) {

        // sliding window

        if (s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> stringOne = new HashMap<>();
        Map<Character, Integer> stringTwo = new HashMap<>();


        for (char c : s1.toCharArray()) {
            stringOne.put(c, stringOne.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i <= s2.length() - s1.length(); i++) {

            String subString = s2.substring(i, i + s1.length());

            for (char s : subString.toCharArray()) {
                stringTwo.put(s, stringTwo.getOrDefault(s, 0) + 1);
            }

            if (stringOne.equals(stringTwo)) {
                return true;
            } else {
                stringTwo.clear();
            }



        }
        return false;
    }








}
