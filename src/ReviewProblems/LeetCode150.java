package ReviewProblems;

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













}
