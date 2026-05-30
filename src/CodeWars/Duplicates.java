package CodeWars;

import java.util.HashMap;
import java.util.Map;

public class Duplicates {




    // two sum
    public static int[] twoSum(int[] numbers, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {

            if (map.containsKey(target - numbers[i])) {
                return new int[] {map.get(target - numbers[i]), i};
            } else {
                map.put(numbers[i], i);
            }


        }


        return new int[]{-1, -1};




    }








    // sqaure every digit
    public int squareDigits(int n) {

        String strN = Integer.toString(n);

        String result = "";

        for (int i = 0; i < strN.length(); i++) {

            int digit = Character.getNumericValue(strN.charAt(i));

            result += (digit * digit);


        }

        return Integer.parseInt(result);

    }













































































































}
