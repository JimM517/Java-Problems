package Sorting;

public class SortingProblems {




    // binary search problem

    public int searchIndex(int[] nums, int target) {


        int start = nums[0];
        int end = nums.length - 1;

        while (start <= end) {
            // set middle index
            int middle = (start + end) / 2;

            // if middle value is target, stop we found index
            if (nums[middle] == target) {
                return middle;
                // if target is greater than nums[middle], start index becomes middle index + 1
            } else if (target > nums[middle]) {
                start = middle + 1;
                // our target is less than our end, set end index as middle - 1
            } else {
                end = middle - 1;
            }

        }


        // return -1 if nothing found
        return -1;

    }




}