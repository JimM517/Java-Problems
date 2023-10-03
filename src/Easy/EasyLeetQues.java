package Easy;

import java.util.HashMap;

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






}
