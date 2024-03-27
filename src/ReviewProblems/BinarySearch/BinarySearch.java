package ReviewProblems.BinarySearch;

public class BinarySearch {


    /*** Binary Search problems from leet code 150 ***/



    // 35. Search insert position
    public int searchInsert(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }





    // 74. Search a 2D matrix
    public boolean searchMatrix(int[][] matrix, int target) {

        int left = 0;
        int right = matrix.length - 1;

        while (left <= right) {

            int row = (left + right) / 2;

            if (target > matrix[row][matrix[row].length - 1]) {
                left = row + 1;
            } else if (target < matrix[row][0]) {
                right = row - 1;
            } else {
                int l = 0;
                int r = matrix[row].length - 1;

                while (l < r) {
                    int m = (l + r) / 2;

                    if (target > matrix[row][m]) {
                        l = m + 1;
                    } else if (target < matrix[row][m]) {
                        r = m - 1;
                    } else {
                        return true;
                    }


                }
                break;
            }


        }

        return false;
    }






    // 162 find peak element
    public int findPeakElement(int[] nums) {

        int start = 0;
        int end = nums.length - 1;


        while (start < end) {

            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[mid + 1]) {
                // potential peak is on the left side
                end = mid;
            } else {
                // potential peak is on the right side or nums[mid] <= nums[mid + 1]
                start = mid + 1;
            }



        }

        // return start as this will point to the peak element
        return start;



    }





    // 33. Search in rotated sorted array
    public int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            int mid = (start + end) / 2;


            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[start] <= nums[mid]) {
                if (target > nums[mid] || target < nums[start]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            else {
                if (target < nums[mid] || target > nums[end]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }






    // 34. find first and last position of element in sorted array
    public int[] searchRange(int[] nums, int target) {

       int[] res = new int[nums.length];

       int j = 0;

       int i = 0;

       int count = 0;


       while (i < nums.length) {
           if (nums[i] == target) {
               res[j] = i;
               j++;
               count++;
           }
           i ++;
       }

       if (count == 0) {
           return new int[]{-1, -1};
       }


        return new int[] {res[0], res[j - 1]};




    }








}
