package Sorting;

import java.util.Map;

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






    // simple search

    public int findAgeByName(Map<String, Integer> map, String name) {

//        basic solution
//            if (map.containsKey(name)) {
//                return map.get(name);
//            }
//            return -1;

        // second solution
            return map.containsKey(name) ? map.get(name) : -1;
        }




        // bubble sort
    public void bubbleSort(int[] nums) {

        int n = nums.length;
        int temp = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - 1); j++) {

               if (nums[j - 1] > nums[j]) {

                   // swap elements

                   temp = nums[j - 1];
                   nums[j - 1] = nums[j];
                   nums[j] = temp;
               }

            }
        }





    }








}
