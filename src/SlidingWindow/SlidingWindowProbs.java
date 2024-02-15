package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

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






}
