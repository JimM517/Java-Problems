package ReviewProblems;

import java.util.HashMap;
import java.util.Map;

public class LeetCode150 {

    /** This class is just intended to review leetcode 150 **/



    // 88. Merge Sorted Array
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // index of last nums1 element
       int i = m - 1;
       // index of last nums2 element
       int j = n - 1;

       // index of last element in return array nums1
       int k = m + n - 1;

       // traverse nums2 to compare nums
        while (j >= 0) {

            // i  greater than 0 and nums1[i] > nums2[j]
            // make nums[k] our current nums1[i] value and decrement
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
                // this condition will run once i < 0 (no more elements in nums1
                // or nums2[j] is greater, effectively moving greater element to the end
            } else {
                nums1[k--] = nums2[j--];
            }

        }

    }





        // 27. Remove Element
        public int removeElement(int[] nums, int val) {

            int k = 0;

            for (int i = 0; i < nums.length; i++) {

                if (nums[i] != val) {
                    nums[k] = nums[i];
                    k++;
                }
            }
            return k;

    }






    //26 Remove duplicates from sorted array
    public int removeDuplicates(int[] nums) {

//       THIS WORKS

//        if (nums.length == 0) {
//            return 0;
//        }
//
//
//        Set<Integer> dups = new HashSet<>();
//
//        int k = 0;
//
//
//        for (int i = 0; i < nums.length; i++) {
//            if (!dups.contains(nums[i])) {
//                nums[k++] = nums[i];
//                dups.add(nums[i]);
//            }
//        }


        int k = 1;

        for (int i = 1; i < nums.length ; i++) {

            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }

        }


        return k;

    }





    // 80. Remove Duplicates from Sorted Array II
    public int removeDuplcatesTwo(int[] nums) {

        if (nums.length <= 2) {
            return nums.length;
        }


        int k = 2;

        for (int i = 2; i < nums.length; i++) {

            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }




    // 169 Majority Element
    int majorityElement(int[] nums) {

        int n = nums.length;

        int maj = 0;
        int majorityCount = 0;


        Map<Integer, Integer> result = new HashMap<>();
        for (int num : nums) {
            result.put(num, result.getOrDefault(num, 0) + 1);
        }



        for (Map.Entry<Integer, Integer> res : result.entrySet()) {

            int curr = res.getValue();

            if (curr > majorityCount && curr > n / 2) {
                maj = res.getKey();
                majorityCount = curr;
            }
        }
        return maj;

    }




    // 189. Rotate Array
    public static void rev(int[] arr, int start, int end) {

            while (start < end) {

                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
    }

    public void rotate(int[] nums, int k) {

        k = k % nums.length;

        int d = nums.length - k;

        rev(nums, 0, d - 1);
        rev(nums, d, nums.length - 1);
        rev(nums, 0, nums.length - 1);
    }




    // another solution for rotate
    public void revAgain(int[] arr, int k) {


        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[(i + k) % arr.length] = arr[i];
        }


        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }

    }






}
