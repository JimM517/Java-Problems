package LeetCode.Medium;

import java.util.*;

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

        // check length because is s1 is greater it's impossible for s1 to be a permutation
        if (s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> stringOne = new HashMap<>();
        Map<Character, Integer> stringTwo = new HashMap<>();

        // populate the s1 map
        for (char c : s1.toCharArray()) {
            stringOne.put(c, stringOne.getOrDefault(c, 0) + 1);
        }

        // subtract length from s2 to ensure there are valid number of characters
        for (int i = 0; i <= s2.length() - s1.length(); i++) {

            String subString = s2.substring(i, i + s1.length());

            // populate stringTwo map with the substring characters
            for (char s : subString.toCharArray()) {
                stringTwo.put(s, stringTwo.getOrDefault(s, 0) + 1);
            }

            // if maps are equal, true
            if (stringOne.equals(stringTwo)) {
                return true;
            } else {
                stringTwo.clear();
            }



        }
        return false;
    }



    // 153. Find Minimum in Rotated Sorted Array
    public int findMinAgain(int[] nums) {

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


    // 49. Group Anagrams

    public List<List<String>> groupAnagrams(String[] strs) {

        // map where key is the sorted word, and the list is all the words that are anagrams
        Map<String, List> testAnagram = new HashMap<>();

        // loop through strs array
        for (String word : strs) {

            // split each word into char array
            char[] chars = word.toCharArray();

            // sort chars
            Arrays.sort(chars);

            // change word back to string
            String sortedWord = new String(chars);

            // if the map doesn't contain the sorted word, we add it
            if (!testAnagram.containsKey(sortedWord)) {
                testAnagram.put(sortedWord, new ArrayList<>());
            }

            // add original word to the list associated with the sorted key
            testAnagram.get(sortedWord).add(word);

        }


        // return list of all values
        return new ArrayList<>(testAnagram.values());


    }

















}
