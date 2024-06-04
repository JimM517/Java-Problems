package LeetCodeOneFifty.BitManipulation;

public class BitManipulation {


    /*** Bit manipulation problems from leet code 150 ***/


    // 67. add binary
    public String addBinary(String a, String b) {

        StringBuilder result = new StringBuilder();

        int carry = 0;

        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry > 0) {

            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }

            result.insert(0, sum % 2);
            carry = sum / 2;

        }
        return result.toString();

    }




    // 137. Single Number II
    public int singleNumber(int[] nums) {
        int number = 0;

        for (int i = 0; i < nums.length; i++) {
            int flag = 0;
            number = nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;
                if (nums[j] == number) {
                    flag++;
                }
            }
            if (flag == 0) break;
        }
        return number;
    }


}
