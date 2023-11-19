package LeetCode.Easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EasyLeetQues {

    // 13 Roman to Integer

    public int romanToInt(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int ans = 0;

        for(int i=0;i<s.length()-1;i++){
            char ch= s.charAt(i);
            char chc= s.charAt(i+1);
            if(ch=='I' && (chc=='V' || chc=='X')){
                ans+=-1*map.get(ch);
            }
            else if(ch=='X' && (chc=='L' || chc=='C')){
                ans+=-1*map.get(ch);
            }
            else if(ch=='C' && (chc=='D' || chc=='M')){
                ans+=-1*map.get(ch);
            }
            else ans+=map.get(ch);
        }
        char ch=s.charAt(s.length()-1);
        ans+=map.get(ch);
        return ans;
    }



    // 283 Move Zeroes
    public void moveZeroes(int[] nums) {

            int start = 0;


            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    if (i != start) {
                        int temp = nums[start];
                        nums[start] = nums[i];
                        nums[i] = temp;
                    }
                }
                start++;
            }


    }


    // 1827 Minimum operations to make the array increasing

    public int minOperations(int[] nums) {

       int n = nums.length;

       int[] numMoves = new int[n];

       for (int i = 1; i < n; i++) {

           numMoves[i] = Math.max(0, nums[i - 1] + 1 - nums[i]);
           nums[i] += Math.max(0, nums[i - 1] + 1 - nums[i]);
           numMoves[i] += numMoves[i - 1];


       }
       return numMoves[n - 1];



    }


    // 206 Reverse Linked List
//    public ListNode reverseList(ListNode head) {
//        ListNode prev = null;
//        ListNode curr = head;
//
//        while(curr != null) {
//            ListNode next = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = next;
//        }
//        return prev;
//
//
//    }


    // 2235 Add two integers
    public int sum(int num1, int num2) {
        return num1 + num2;
    }



    // 1108 defanging an IP address
    public String defangIPaddr(String address) {


        return address.replace(".", "[.]");

    }



    // 1672 richest customer wealth

    public int maximumWealth(int[][] accounts) {

        int max = 0;

        for (int i = 0; i < accounts.length; i++) {
            int temp = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                temp += accounts[i][j];
            }


            if (temp > max) {
                max = temp;
            }
        }
        return max;

    }


    // 1470 shuffle the array
    public int[] shuffle(int[] nums, int n) {

        int[] results = new int[2 * n];


        for (int i = 0; i < n; i++) {

        results[2 * i] = nums[i];
        results[2 * i + 1] = nums[i + n];


        }
        return results;

    }


    // 1512 Number of good pairs
    public int numIdenticalPairs(int[] nums) {

        HashMap<Integer, Integer> count = new HashMap<>();

        int result = 0;

        for (int num : nums) {


            count.put(num, count.getOrDefault(num, 0) + 1);
            result += count.get(num) - 1;
        }
        return result;

    }


    // 771 Jewels and Stones
    public int numJewelsInStones(String jewels, String stones) {

        Set<Character> jewelSet = new HashSet<>();


        for (char jewel : jewels.toCharArray()) {
            jewelSet.add(jewel);
        }

        int count = 0;

        for (char stone : stones.toCharArray()) {
            if (jewelSet.contains(stone)) {
                count++;
            }
        }

        return count;


    }


    // 1603 Design Parking System

//    private int numBigSlots;
//    private int numMediumSlots;
//    private int numSmallSlots;
//
//    public ParkingSystem(int big, int medium, int small) {
//        this.numBigSlots = big;
//        this.numMediumSlots = medium;
//        this.numSmallSlots = small;
//    }

//    public boolean addCar(int carType) {
//
//        if (carType == 1) {
//            if (this.numBigSlots > 0) {
//                this.numBigSlots -= 1;
//                return true;
//            }
//        }
//        if (carType == 2) {
//            if (this.numMedSlots > 0) {
//                this.numMedSlots -= 1;
//                return true;
//            }
//        }
//        if (carType == 3) {
//            if (this.numSmallSlots > 0) {
//                this.numSmallSlots -= 1;
//                return true;
//            }
//        }
//        return false;
//
//    }


    // 1365 How many numbers are smaller than the current number
    public int[] smallerNumbersThanCurrent(int[] nums) {

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < nums[i] && j != i) {
                    count++;
                }
            }
            result[i] = count;
        }

        return result;
    }



    // 938 - Sum Range BST
//    public int rangeSumBST(TreeNode root, int low, int high) {
//
//        if (root == null) {
//            return 0;
//        }
//
//        if (root.val < low) {
//            return rangeSumBST(root.right, low, high);
//        } else if (root.val > high) {
//            return rangeSumBST(root.left, low high);
//        } else {
//            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
//        }
//
//
//
//    }



    // 1290 Convert Binary Number in a Linked List to Integer
//    public int getDecimalValue(LeetCode.LeetCode.ListNode head) {
//        int decimalValue = 0;
//
//        LeetCode.LeetCode.ListNode current = head;
//
//        while (current != null) {
            // left shift << is essentially multiplying by 2
            // 101 = 5 but left shit becomes 1010 which is 10
//            decimalValue = (decimalValue << 1) | current.val;
//            current = current.next;
//        }
//        return decimalValue;
//    }



    // 557 Reverse Words in a String
    public String reverseWords(String s) {

        String[] words = s.split(" ");

        StringBuilder sb = new StringBuilder();

        for (String word : words) {

            StringBuilder reversed = new StringBuilder(word);
            sb.append(reversed.reverse()).append(" ");

        }

        return sb.toString().trim();
    }





    // 202. Happy Number
    public boolean isHappy(int n) {

        HashSet<Integer> seenNumbers = new HashSet<>();

        while (n != 1 && !seenNumbers.contains(n)) {

            seenNumbers.add(n);

            String str = String.valueOf(n);
            int sum = 0;

            for (int i = 0; i < str.length(); i++) {

                int digit = Character.getNumericValue(str.charAt(i));
                sum += digit * digit;

            }

            n = sum;

        }
         return n == 1;

    }


    // 217. Contains duplicates
    public boolean containsDuplicates(int[] nums) {

        Map<Integer, Integer> result = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (result.containsKey(nums[i])) {
                return true;
            } else {
                result.put(nums[i], 1);
            }
        }

       return false;

    }



    // 242. Valid Anagram
    public boolean isAnagram(String s, String t) {

        Map<Character, Integer> result = new HashMap<>();

        Map<Character, Integer> tMap = new HashMap<>();

        // populate result with chars and count from s
        for (int i = 0; i < s.length(); i++) {
           result.put(s.charAt(i), result.getOrDefault(s.charAt(i), 0) + 1);
        }
        // populate tMap with chars and count from t
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);

        }

        // if the two maps are equal they are anagrams
        return result.equals(tMap);
    }


    // 1. Two sum
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
