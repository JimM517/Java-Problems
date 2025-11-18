package CodeWars.FiveKyu;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FiveKyu {



    // maximum subarray sum
    public static int sequence(int[] arr) {


        if (arr.length == 0) {
            return 0;
        }

        int current = 0;
        int max = 0;

        for (int num : arr) {

            current = Math.max(0, current + num);
            max = Math.max(max, current);

        }
        return max;

    }



    // mean square error
    public static double solution(int[] arr1, int[] arr2) {

        int n = arr1.length;

        double total = 0;

        for (int i = 0; i < n; i++) {
            double diff = arr1[i] - arr2[i];
            total += Math.pow(diff, 2);

        }


        return total / n;


    }


    // land perimeter
    public static String landPerimeter(String[] arr) {
        int perimeter = 0;
        int cols = arr[0].length();
        int rows = arr.length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr[i].charAt(j) == 'x') {
                    // add 4 -> each island has 4 sides
                    perimeter += 4;
                    if (i > 0 && arr[i - 1].charAt(j) == 'x') perimeter -= 1;
                    if (i < rows - 1 && arr[i + 1].charAt(j) == 'x') perimeter -= 1;
                    if (j > 0 && arr[i].charAt(j - 1) == 'x') perimeter -= 1;
                    if (j < cols - 1 && arr[i].charAt(j + 1) == 'x') perimeter -= 1;
                }
            }
        }

        String result = Integer.toString(perimeter);

        return "Total land perimeter: " + result;


    }




    // Rot13
    public static String rot13(String str) {

        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {

            if (c >= 'a' && c <= 'z') {
                // lowercase character
                char shifted = (char) ('a' + ((c - 'a' + 13) % 26));
                sb.append(shifted);
            } else if (c >= 'A' && c <= 'Z') {
                // uppercase character
                char shifted = (char)('A' + ((c - 'A' + 13) % 26));
                sb.append(shifted);
            } else {
                // non-alphabetic character will not change
                sb.append(c);
            }


        }


        return sb.toString();


    }






    // simple string expansion
    public static String solve(String s) {

        char[] a = new StringBuilder(s).reverse().toString().toCharArray();
        String b = "", c;
        for (char ch : a) {
            if (Character.isLetter(ch)) b += ch;
            else if (Character.isDigit(ch)) {
                int i = ch - '0' - 1;
                c = b;
                while (i > 0) {
                    b += c;
                    i--;
                }
            }
        }
        return new StringBuilder(b).reverse().toString();
    }




    // geometric series of events
    private static final List<String> DAYS = Arrays.asList("Mo", "Tu", "We", "Th", "Fr", "Sa", "Su");
    public static BigInteger findNthOccurrence(final String startDay, final int r, final BigInteger n, final String targetDay) {


        final int start = DAYS.indexOf(startDay);
        final int target = DAYS.indexOf(targetDay);
        final List<Integer> cycle = new ArrayList<>();
        int day = start;

        for (int i = 1; i <= 7; i++) {
            cycle.add(day);
            final int pow = BigInteger.valueOf(r).modPow(BigInteger.valueOf(i), BigInteger.valueOf(7)).intValue();
            day = (day + pow) % 7;
            if (day == start) break;
        }

        if (!cycle.contains(target)) return BigInteger.valueOf(-1);

        final int offset = cycle.indexOf(target);
        final int cycleLength = cycle.size();

        return n.subtract(BigInteger.ONE)
                .multiply(BigInteger.valueOf(cycleLength))
                .add(BigInteger.valueOf(offset + 1));


    }





    // string incrementer
    public static String incrementString(String str) {

        StringBuilder sb = new StringBuilder(" " + str);
        for (int i = sb.length() - 1; i >= 0; i--) {
            char ch = sb.charAt(i);
            if (Character.isDigit(ch)) {
                ch = ch == '9' ? '0' : ch++;
                sb.replace(i, i + 1, String.valueOf(ch));
                if (ch != '0') {
                    break;
                }
                continue;
            }
            sb.insert(i + 1, "1");
            break;
        }
        return sb.substring(1);

    }




































































































































}
