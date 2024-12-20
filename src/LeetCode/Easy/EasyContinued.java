package LeetCode.Easy;

import java.util.*;

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



    // 2824. count pairs whose sum is less than target
    public int countPairs(List<Integer> nums, int target) {

        int count = 0;

        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                int total = nums.get(i) + nums.get(j);
                if (total < target) {
                    count++;
                }
            }
        }
        return count;
    }




    // 1346. check if N and its double exist
    public boolean checkIfExists(int[] arr) {

       for (int i = 0; i < arr.length; i++) {
           for (int j = 0; j < arr.length; j++) {
               if (i != j && arr[i] == 2 * arr[j]) {
                   return true;
               }
           }
       }

        return false;

    }



    // 1455. check if a word occurs as a prefix of any word in a sentence
    public int isPrefixOfWord(String sentence, String searchWord) {

        String[] words = sentence.split(" ");
        int index = -1;

        for (int i = 0; i < words.length; i++) {


            if (words[i].startsWith(searchWord)) {
                index = i + 1;
                break;
            }
        }
        return index;
    }





    // 2558. take gifts from the richest pile
    public long pickGifts(int[] gifts, int k) {

        List<Integer> gList = new ArrayList<>();
        for (int gift : gifts) {
            gList.add(-gift);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(gList);
        for (int i = 0; i < k; i++) {
            int maxElement = -heap.poll();

            heap.offer(-(int) Math.sqrt(maxElement));
        }

        long remainingGifts = 0;
        while (!heap.isEmpty()) {
            remainingGifts -= heap.poll();
        }
        return remainingGifts;
    }





    // 3264. final array state after k multiplication operations I
    public int[] getFinalState(int[] nums, int k, int multiplier) {

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });


        for (int i = 0; i < nums.length; i++) {
            heap.add(new int[] {nums[i], i});
        }



        for (int i = 0; i < k; i++) {
            int[] arr = heap.poll();
            int val = arr[0];
            int idx = arr[1];

            nums[idx] = val * multiplier;

            heap.add(new int[] {nums[idx], idx});
        }

        return nums;

    }



    // 1475. Final prices with special discount in a shop
    public int[] finalPrices(int[] prices) {

        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int discount = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    discount = prices[j];
                    break;
                }
            }
            answer[i] = prices[i] - discount;
        }


        return answer;

    }








}