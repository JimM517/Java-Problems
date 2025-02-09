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






        // 3160. find the number of distinct colors among the balls
        public int[] queryResults(int limit, int[][] queries) {
            int n = queries.length;
            int[] result = new int[n];
            Map<Integer, Integer> colorMap = new HashMap<>();
            Map<Integer, Integer> ballMap = new HashMap<>();

            // Iterate through queries
            for (int i = 0; i < n; i++) {
                // Extract ball label and color from query
                int ball = queries[i][0];
                int color = queries[i][1];

                // Check if ball is already colored
                if (ballMap.containsKey(ball)) {
                    // Decrement count of the previous color on the ball
                    int prevColor = ballMap.get(ball);
                    colorMap.put(prevColor, colorMap.get(prevColor) - 1);

                    // If there are no balls with previous color left, remove color from color map
                    if (colorMap.get(prevColor) == 0) {
                        colorMap.remove(prevColor);
                    }
                }
                // Set color of ball to the new color
                ballMap.put(ball, color);

                // Increment the count of the new color
                colorMap.put(color, colorMap.getOrDefault(color, 0) + 1);

                result[i] = colorMap.size();
            }
            return result;
        }







        // 2349. design a number container system
    class NumberContainers {

            // Maps from number to set of indices and from index to number
            private Map<Integer, TreeSet<Integer>> numberToIndices;
            private Map<Integer, Integer> indexToNumbers;

            // Constructor
            public NumberContainers() {
                // Initialize the data structures
                numberToIndices = new HashMap<>();
                indexToNumbers = new HashMap<>();
            }

            public void change(int index, int number) {
                // If index already has a number, remove it from the old number's index set
                if (indexToNumbers.containsKey(index)) {
                    int previousNumber = indexToNumbers.get(index);
                    numberToIndices.get(previousNumber).remove(index);
                    if (numberToIndices.get(previousNumber).isEmpty()) {
                        numberToIndices.remove(previousNumber);
                    }
                }
                // Update the number and add the index to the new number's set
                indexToNumbers.put(index, number);
                numberToIndices.putIfAbsent(number, new TreeSet<>());
                numberToIndices.get(number).add(index);
            }

            public int find(int number) {
                // Return the smallest index for the given number, or -1 if not found
                if (numberToIndices.containsKey(number)) {
                    return numberToIndices.get(number).first(); // Get the smallest index
                }
                return -1;
            }



        }





















































































































































































































































































































}
