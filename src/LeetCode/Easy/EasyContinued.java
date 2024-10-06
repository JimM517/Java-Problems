package LeetCode.Easy;

import java.util.Arrays;

public class EasyContinued {

    // 628. maximum product of three numbers
    public int maximumProduct(int[] nums) {


        Arrays.sort(nums);

        int min = nums[0] * nums[1] * nums[nums.length - 1];
        int max = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];

        return Math.max(min, max);


    }





}
