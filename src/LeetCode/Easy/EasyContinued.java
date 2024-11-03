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



    // 1957. delete characters to make a fancy string
    public String makeFancyString(String s) {


        StringBuilder sb = new StringBuilder();

        char prev = s.charAt(0);
        int freq = 1;
        sb.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == prev) {
                freq++;
            } else {
                prev = s.charAt(i);
                freq = 1;
            }

            if (freq < 3) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }




    // 2490. Circular Sentence
    public boolean isCircularSentence(String sentence) {

        for (int i = 0; i < sentence.length(); i++) {

            if (sentence.charAt(i) == ' ') {
                if (sentence.charAt(i - 1) != sentence.charAt(i + 1)) {
                    return false;
                }
            }


        }

        return sentence.charAt(0) == sentence.charAt(sentence.length() - 1);


    }



    //
    public boolean rotateString(String s, String goal) {

        if (s.length() != goal.length()) {
            return false;
        }

        // concatenate s with s, check if goal is in s
        s = s + s;

        return s.contains(goal);

    }












}
