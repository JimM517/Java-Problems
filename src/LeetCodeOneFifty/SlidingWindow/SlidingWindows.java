package LeetCodeOneFifty.SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class SlidingWindows {

    /*** Sliding window problems from leetcode 150 ***/



    // 209. Minimum size subarray
    public int minSubArrayLen(int target, int[] nums) {

        int n = nums.length;
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;

        for (int i = 0; i < n; i++) {

            sum += nums[i];

            while (sum >= target) {


                minLen = Math.min(minLen, i - left + 1);

                sum -= nums[left];

                left++;


            }

        }


        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;


    }




    // 3. longest substring without repeating characters
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
