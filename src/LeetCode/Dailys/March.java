package LeetCode.Dailys;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class March {

    // march 2025 dailys
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        int[] modifiedNums = new int[n];
        int zeroCount = 0;

        // Step 1: Apply operations on the array
        for (int index = 0; index < n - 1; index++) {
            if (nums[index] == nums[index + 1] && nums[index] != 0) {
                nums[index] *= 2;
                nums[index + 1] = 0;
            }
        }

        // Step 2: Move non-zero elements to the front
        for (int num : nums) {
            if (num != 0) {
                modifiedNums[zeroCount++] = num;
            }
        }

        // Step 3: Append zeros to maintain the original size
        while (zeroCount < n) {
            modifiedNums[zeroCount++] = 0;
        }

        return modifiedNums;
    }


    // 2570. merge two 2D arrays by summing values
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {

        Map<Integer, Integer> map = new TreeMap<>();

        for (int[] nums : nums1) {
            map.put(nums[0], nums[1]);
        }

        for (int[] nums : nums2) {
            map.put(nums[0], map.getOrDefault(nums[0], 0) + nums[1]);
        }

        List<int[]> merged = new ArrayList<>();
        for (Map.Entry<Integer, Integer> x : map.entrySet()) {
            merged.add(new int[] {x.getKey(), x.getValue()});
        }


        int[][] result = new int[merged.size()][2];
        for (int i = 0; i < merged.size(); i++) {
            result[i] = merged.get(i);
        }
        return result;
    }



    // 2161. partition array according to given pivot
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> less = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();

        for (int num : nums) {
            if (num < pivot) {
                less.add(num);
            } else if (num > pivot) {
                greater.add(num);
            } else {
                equal.add(num);
            }
        }

        less.addAll(equal);
        less.addAll(greater);

        int[] result = new int[nums.length];
        int idx = 0;
        for (int num : less) {
            result[idx++] = num;
        }

        return result;
    }




    // 1780. check if number is a sum of powers of three
    public boolean checkPowersOfThree(int n) {

        while (n > 0) {

            if (n % 3 == 2) {
                return false;
            }

            n /= 3;
        }


        return true;

    }








































}
