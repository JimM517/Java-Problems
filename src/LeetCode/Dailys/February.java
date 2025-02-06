package LeetCode.Dailys;

import java.util.*;

public class February {


    // 3151. Special Array I
    public boolean isArraySpecial(int[] nums) {


        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int prev = nums[i - 1];

            if ((curr % 2 == 0) && (prev % 2 == 0)) {
                return false;
            }

            if ((curr % 2 == 1) && (prev % 2 == 1)) {
                return false;
            }

        }
        return true;
    }





    // 1752. check if array is sorted and rotated
    public boolean check(int[] nums) {

        int n = nums.length;

        int[] checkedSorted = new int[n];

        for (int rotationOffSet = 0; rotationOffSet < n; rotationOffSet++) {
            int currInx = 0;
            for (int index = rotationOffSet; index < n; index++) {
                checkedSorted[currInx++] = nums[index];
            }
            for (int index = 0; index < rotationOffSet; index++) {
                checkedSorted[currInx++] = nums[index];
            }

            boolean isSorted = true;
            for (int index = 0; index < n - 1; index++) {
                if (checkedSorted[index] > checkedSorted[index + 1]) {
                    isSorted = false;
                    break;
                }
            }

            if (isSorted) {
                return true;
            }

        }
        return false;
    }



    // 3105. longest strictly increasing or strictly decreasing subarray
    public int longestMonotonicSubarray(int[] nums) {
            int maxLength = 0;

            // Find longest strictly increasing subarray
            for (int start = 0; start < nums.length; start++) {
                int currLength = 1;
                for (int pos = start + 1; pos < nums.length; pos++) {
                    // Extend subarray if next element is larger
                    if (nums[pos] > nums[pos - 1]) {
                        currLength++;
                    } else {
                        // Break if sequence is not increasing anymore
                        break;
                    }
                }
                maxLength = Math.max(maxLength, currLength);
            }

            // Find longest strictly decreasing subarray
            for (int start = 0; start < nums.length; start++) {
                int currLength = 1;
                for (int pos = start + 1; pos < nums.length; pos++) {
                    // Extend subarray if next element is smaller
                    if (nums[pos] < nums[pos - 1]) {
                        currLength++;
                    } else {
                        // Break if sequence is not decreasing anymore
                        break;
                    }
                }
                maxLength = Math.max(maxLength, currLength);
            }

            return maxLength; // Return the longer of increasing or decreasing sequences
        }





        // 1800 maximum ascending subarray sum
        public int maxAscendingSum(int[] nums) {

            int maxSum = 0;
            int currentSubarraySum = nums[0];

            for (int currentIdx = 1; currentIdx < nums.length; currentIdx++) {
                if (nums[currentIdx] <= nums[currentIdx - 1]) {
                    maxSum = Math.max(maxSum, currentSubarraySum);

                    currentSubarraySum = 0;
                }
                currentSubarraySum += nums[currentIdx];
            }

            return Math.max(maxSum, currentSubarraySum);
        }







        // 1790. check if one string swap can make strings equal
        public boolean areAlmostEqual(String s1, String s2) {

            int firstIndexDiff = 0;
            int secondIndexDiff = 0;
            int numDifference = 0;

            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    numDifference++;

                    if (numDifference > 2) {
                        return false;
                    } else if (numDifference == 1) {
                        firstIndexDiff = i;
                    } else {
                        secondIndexDiff = i;
                    }

                }
            }

            return (s1.charAt(firstIndexDiff) == s2.charAt(secondIndexDiff) && (s1.charAt(secondIndexDiff) == s2.charAt(firstIndexDiff)));
        }




        // 1726. tuple with same product
        public int tupleSameProduct(int[] nums) {

            int numsLength = nums.length;
            Arrays.sort(nums);

            int totalNumberOfTuples = 0;

            for (int aIndex = 0; aIndex < numsLength; aIndex++) {

                for (int bIndex = nums.length - 1; bIndex >= aIndex + 1; bIndex--) {

                    int product = nums[aIndex] * nums[bIndex];

                    Set<Integer> possibleDValues = new HashSet<>();

                    for (int cIndex = aIndex + 1; cIndex < bIndex; cIndex++) {

                        if (product % nums[cIndex] == 0) {
                            int dValue = product / nums[cIndex];

                            if (possibleDValues.contains(dValue)) {
                                totalNumberOfTuples += 8;
                            }

                            possibleDValues.add(nums[cIndex]);
                        }

                    }
                }

            }

            return totalNumberOfTuples;
        }




























































































































































































































































































































}
