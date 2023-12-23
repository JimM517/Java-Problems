package Leet75;

import java.util.HashMap;
import java.util.Map;

public class Leet75 {


    // two sum
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> result = new HashMap<>();


        for (int i = 0; i < nums.length; i++) {

            if (result.containsKey(target - nums[i])) {
                return new int[]{result.get(target - nums[i]), i};
            } else {
                result.put(nums[i], i);
            }



        }
        return new int[]{-1, -1};
    }











}
