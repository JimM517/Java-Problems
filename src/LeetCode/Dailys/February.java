package LeetCode.Dailys;

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








}
