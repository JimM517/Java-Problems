package ReviewProblems.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoPointers {


    /*** Two pointer problems from leet code 150 ***/




    // 125. Valid Palindrome
    public boolean isPalindrome(String s) {

        s= s.toLowerCase().replaceAll("[^a-z0-9]", "");

        int start = 0;
        int end = s.length() - 1;


        while (start <= end) {

            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;


        }

        return true;


    }




    // 392. Is subsequence
    public boolean isSubsequence(String s, String t) {

        int sIdx = 0;

        for (int i = 0; i < t.length() && sIdx < s.length(); i++) {

            if (s.charAt(sIdx) == t.charAt(i)) {
                sIdx++;
            }

        }

        return sIdx == s.length();



    }





    // 167. Two sum II - input array is sorted
    public int[] twoSumTwo(int[] numbers, int target) {

        int start = 0;
        int end = numbers.length - 1;

        while (start < end) {

            int sum = numbers[start] + numbers[end];

            if (sum > target) {
                end--;
            } else if (sum < target) {
                start++;
            } else {
                return new int[]{start + 1, end + 1};
            }



        }

        return null;




    }



    // 11. Container with most water
    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int max = 0;

        while (left < right) {

            int w = right - left;
            int h = Math.min(height[left], height[right]);

            int area = h * w;

            max = Math.max(max, area);

            if (height[left] < height[right]) {
                left++;
            } else if (height[left] > height[right]) {
                right--;
            } else {
                left++;
                right--;
            }
        }

        return max;
    }




    // 15. 3Sum
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> results = new ArrayList<>();

        Arrays.sort(nums);


        for (int i = 0; i < nums.length - 2; i++) {


            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }


            int j = i + 1;
            int k = nums.length - 1;

            // basically two sum two

            while (j < k) {


                int sum = nums[i] + nums[j] + nums[k];


                if (sum == 0) {
                    results.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }


                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }


                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }


            }
        }

        return results;
    }









}
