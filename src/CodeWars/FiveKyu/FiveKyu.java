package CodeWars.FiveKyu;

import java.math.BigInteger;
import java.util.*;

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






    // first non-repeating character
    public static String firstNonRepeatingLetter(String s) {

        Map<Character, Integer> freq = new HashMap<>();

        // Count characters in a case-insensitive way
        for (char c : s.toCharArray()) {
            char lower = Character.toLowerCase(c);
            freq.put(lower, freq.getOrDefault(lower, 0) + 1);
        }

        // Second pass: find first non-repeating
        for (char c : s.toCharArray()) {
            char lower = Character.toLowerCase(c);
            if (freq.get(lower) == 1) {
                return String.valueOf(c);  // return original case
            }
        }

        return "";
    }





    // String n iterations
    public static String jumbledString(String s, long n) {

        if (s == null || s.length() < 2 || n == 0) {
            return s;
        }

        String original = s;
        String current = s;

        int cycle = 0;
        do {
            current = shuffle(current);
            cycle++;
        } while (!current.equals(original));

        long effective = n % cycle;
        current = s;

        for (int i = 0; i < effective; i++) {
            current = shuffle(current);
        }

        return current;

    }



    private static String shuffle(String s) {
        StringBuilder even = new StringBuilder();
        StringBuilder odd = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                even.append(s.charAt(i));
            } else {
                odd.append(s.charAt(i));
            }
        }
        return even.append(odd).toString();
    }






    // product of consecutive fib numbers
    public static long[] productFib(long prod) {

        int n = 0;
        long fn = fib(n);
        long fn1 = fib(n + 1);

        while (fn * fn1 < prod) {
            n++;
            fn = fn1;
            fn1 = fib(n + 1);
        }

        return new long[]{fn, fn1, fn * fn1 == prod ? 1 : 0};

    }



    // helper
    public static long fib(int n) {

        long one = 0;
        long two = 1;

        for (int i = 0; i < n; i++) {

            long next = one + two;
            one = two;
            two = next;




        }

        return two;


    }




    // directions reduction
    public static String[] dirReduc(String[] arr) {


        Stack<String> stack = new Stack<>();

        for (String dir : arr) {
            if (!stack.isEmpty() && isOpposite(stack.peek(), dir)) {
                stack.pop();
            } else {
                stack.push(dir);
            }
        }
        return stack.toArray(new String[0]);
    }


    // helper
    private static boolean isOpposite(String a, String b) {

        return (a.equals("NORTH") && b.equals("SOUTH")) ||
                (a.equals("SOUTH") && b.equals("NORTH")) ||
                (a.equals("EAST") && b.equals("WEST")) ||
                (a.equals("WEST") && b.equals("EAST"));



    }





    // integers: recreation one
    public static String listSquared(long m, long n) {

        List<String> result = new ArrayList<>();
        for(long i = m; i <= n; i++){
            long sum = 0;
            for(long j = 1; j <= i; j++){
                if(i % j == 0){
                    sum = sum + (j*j);
                }
            }
            double x = Math.sqrt(sum);
            if(x - Math.floor(x) == 0){
                result.add("[" + i + ", " + sum + "]");
            }
        }
        return result.toString();


    }





    // simple encryption #1 - alternating split
    public static String encrpyt(final String text, final int n) {

        if (text == null || text.isEmpty() || n <= 0) return text;

        String result = text;

        for (int i = 0; i < n; i++) {
            StringBuilder odd = new StringBuilder();
            StringBuilder even = new StringBuilder();

            for (int idx = 0; idx < result.length(); idx++) {
                if (idx % 2 == 1) odd.append(result.charAt(idx));
                else even.append(result.charAt(idx));
            }
            result = odd.append(even).toString();
        }
        return result;

    }


    public static String decrypt(final String encryptedText, final int n) {

        if (encryptedText == null || encryptedText.isEmpty() || n <= 0) return encryptedText;

        String result = encryptedText;

        for (int i = 0; i < n; i++) {
            int half = result.length() / 2;
            String odd = result.substring(0, half);
            String even = result.substring(half);

            StringBuilder sb = new StringBuilder();

            int idxOdd = 0, idxEven = 0;
            for (int idx = 0; idx < result.length(); idx++) {
                if (idx % 2 == 1) sb.append(odd.charAt(idxOdd++));
                else sb.append(even.charAt(idxEven++));
            }
            result = sb.toString();
        }

        return result;

    }































































































}
