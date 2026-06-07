package CodeWars;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Duplicates {

    /** duplicates for all levels **/


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






    // find the odd int
    public static int findIt(int[] a) {

        Map<Integer, Integer> intCount = new HashMap<>();
        for (int i : a) {
            intCount.put(i, intCount.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> x : intCount.entrySet()) {
            if (x.getValue() % 2 != 0) {
                return x.getKey();
            }
        }
        return -1;

    }


    // find the smallest integer in the array
    public static int findSmallestInt(int[] args) {

        int min = Integer.MAX_VALUE;

        for (int i : args) {
            min = Math.min(min, i);
        }

        return min;



    }



    // string repeat
    public static String repeatSr(final int repeat, final String string) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < repeat; i++) {
            sb.append(string);
        }
        return sb.toString();

    }




    // detect pangram
    public boolean check(String sentence) {

        Set<Character> characterSet = new HashSet<>();

        for (char x : sentence.toLowerCase().toCharArray()) {
            if (x >= 'a' && x <= 'z') {
                characterSet.add(x);
            }
        }

        return characterSet.size() == 26;




    }






    // maximum contiguous sum
    public static int maxContiguousSum(final int[] arr) {

        int current = 0;
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            current += arr[i];
            if (current > max) {
                max = current;
            }
            if (current < 0) {
                current = 0;
            }
        }
        return max;

    }







    // sum of positive
    public static int sum(int[] arr) {

        int total = 0;
        for (int num : arr) {
            if (num > 0) {
                total += num;
            }
        }

        return total;

    }




    // reversed words
    public static String reverseWords(String str) {

        StringBuilder sb = new StringBuilder();
        String[] strSplit = str.split(" ");
        for (int i = strSplit.length - 1; i >= 0; i--) {
            sb.append(strSplit[i]);

            if (i != 0) {
                sb.append(" ");
            }

        }


        return sb.toString();

    }








































































}
