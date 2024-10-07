package LeetCode.Easy;

import java.util.Arrays;
import java.util.Stack;

public class EasyContinued {

    // 628. maximum product of three numbers
    public int maximumProduct(int[] nums) {


        Arrays.sort(nums);

        int min = nums[0] * nums[1] * nums[nums.length - 1];
        int max = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];

        return Math.max(min, max);


    }




    // 2696. Minimum string length after removing substrings
    public int minLength(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (!stack.isEmpty() && ((stack.peek() == 'A' && c == 'B') || stack.peek() == 'C' && c == 'D')) {
                stack.pop();
            } else {
                stack.push(c);
            }



        }

        return stack.size();




    }





}
