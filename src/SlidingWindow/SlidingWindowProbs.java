package SlidingWindow;

import java.util.*;

public class SlidingWindowProbs {


    // 121 Best time to buy and sell stock
    public int maxProfit(int[] prices) {

        if (prices.length == 0) {
            return 0;
        }

        int start = prices[0];
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {

            if (prices[i] < start) {
                start = prices[i];
            } else {
                int current = prices[i] - start;

                if (current > maxProfit) {
                    maxProfit = current;
                }


            }
        }

        return maxProfit;
    }






    // 3. Longest substring without repeating characters
    public int lengthOfLongestSubstring(String s) {

        Set<Character> checkChars = new HashSet<>();

        int left = 0;
        int right = 0;

        int count = 0;

        while (right < s.length()) {


            if (checkChars.contains(s.charAt(right))) {
                checkChars.remove(s.charAt(left));
                left++;
            } else {
                checkChars.add(s.charAt(right));
                count = Math.max(count, right - left + 1);
                right++;
            }
        }

        return count;

    }





    // 438 Find All Anagrams in a String
    // TODO FINISH
    public List<Integer> findAnagrams(String s, String p) {


        if (p.length() > s.length()) {
            return new ArrayList<>();
        }


        List<Integer> result = new ArrayList<>();

        Map<Character, Integer> pCount = new HashMap<>();
        Map<Character, Integer> sCount = new HashMap<>();


        for (int i = 0; i < p.length(); i++) {
            pCount.put(p.charAt(i), pCount.getOrDefault(p.charAt(i), 0) + 1);
        }



        int i = 0;
        int j = 0;


        while (j < s.length()) {


            sCount.put(s.charAt(j), sCount.getOrDefault(s.charAt(j), 0) + 1);

            if (j - 1 + 1 < p.length()) {
                j++;
            }
            else if (j - i + 1 == p.length()) {
                if (sCount.equals(pCount)) {
                    result.add(i);
                }

                sCount.put(s.charAt(i), sCount.getOrDefault(s.charAt(i), 0) - 1);
                if (sCount.get(s.charAt(i)) == 0) {
                    pCount.remove(s.charAt(i));
                }

            }

            i++;
            j++;

        }

        return result;



    }
















    // 76. Minimum Window Substring
    public String minWindow(String s, String t) {

        if (s.equals(t)) {
            return s;
        }


        Map<Character, Integer> needT = new HashMap<>();

        for (Character ch : t.toCharArray()) {
            needT.put(ch, needT.getOrDefault(ch, 0) + 1);
        }


        int left = 0;
        int right = 0;

        int count = 0;


        // TODO FINISH





        return "";
    }







    // 1456. Maximum number of vowels in a substring of given length
    public int maxVowels(String s, int k) {

      Set<Character> vowelSet = new HashSet<>();
        vowelSet.add('a');
        vowelSet.add('e');
        vowelSet.add('i');
        vowelSet.add('o');
        vowelSet.add('u');


        int vowel = 0;

        for (int i = 0; i < k; i++) {
            if (vowelSet.contains(s.charAt(i))) {
                vowel++;
            }
        }



        int max = vowel;

        for (int i = k; i < s.length(); i++) {
            if (vowelSet.contains(s.charAt(i - k))) {
                vowel--;
            }
            if (vowelSet.contains(s.charAt(i))) {
                vowel++;
            }
            max = Math.max(max, vowel);
        }

        return max;

    }



    // 485 max consecutive ones
    public int findMaxConsecutive(int[] nums) {

      int count = 0;
      int len = 0;


      for (int i = 0; i < nums.length; i++) {
          if (nums[i] == 0) {
              count = 0;
          }
          else {
              count++;
              len = Math.max(len, count);
          }
      }
      return len;

    }









    // 1004. Max Consecutive Ones III
    public int longestOnes(int[] nums, int k) {





    }


}
