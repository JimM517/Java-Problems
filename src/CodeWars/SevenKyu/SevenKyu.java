package CodeWars.SevenKyu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SevenKyu {

    // change two-dimensional array
    public int[][] matrix(int[][] array) {

        for (int i = 0; i < array.length; i++) {

            if (array[i][i] < 0) {
                array[i][i] = 0;
            } else {
                array[i][i] = 1;
            }


        }

        return array;

    }






    // character counter
    public boolean validateWord(String word) {

        String lower = word.toLowerCase();

        Map<Character, Integer> charMap = new HashMap<>();

        for (Character idx : lower.toCharArray()) {

            charMap.put(idx, charMap.getOrDefault(idx, 0) + 1);
        }


        List<Integer> charCount = new ArrayList<>(charMap.values());


        for (int i = 0; i < charCount.size() - 1; i++) {
            if (charCount.get(i) != charCount.get(i + 1)) {
                return false;
            }
        }


        return true;


    }





    // cogs 2
    public double[] cogRpm(int[] cogs, int n) {

        double first =1;
        double second =1;

        for (int i =0; i<n; i++) {
            first *= -(double) cogs[n-i] / cogs[i];

        }
        for (int i = n+1; i<cogs.length; i++) {
            second *= -(double) cogs[i-1]  / cogs[i];

        }
        return new double[]{first, second};
    }




    // Circular list
    public class Circular<T> {

        private final T[] elements;
        private int currentIdx = -1;
        private int length;

        public Circular(final T... elements) {
            if (elements == null || elements.length == 0) {
                throw new IllegalArgumentException("${T}");

            }
            this.elements = elements;
            this.length = elements.length;
        }

        T next() {

            if (++currentIdx == length) {
                currentIdx = 0;
            }
            return elements[currentIdx];

        }


        T prev() {

            if (--currentIdx < 0) {
                currentIdx = length - 1;
            }

            return elements[currentIdx];
        }



    }




    // smallest value of an array
    public int findSmallest(int[] numbers, String mode) {

        int min = numbers[0];
        int index = 0;


        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
                index = i;
            }
        }


        return mode.equals("value") ? min : index;

    }




    // move in squared strings I
    public static String vertMirror(String strng) {
        String[] mirror = strng.split("\n");

        StringBuilder result = new StringBuilder();


        for (String s : mirror) {

          result.append(new StringBuilder(s).reverse()).append("\n");


        }
        return result.toString().trim();
    }


    public static String horMirror(String strng) {
        String[] mirror = strng.split("\n");

        StringBuilder result = new StringBuilder();

        for (int i = mirror.length - 1; i >= 0; i--) {
            result.append(mirror[i]).append("\n");
        }
        return result.toString().trim();
    }


    public static String oper(java.util.function.Function<String, String> operator, String s) {
        // your code and complete ... before operator
        return operator.apply(s);
    }








    // list filtering
    public static List<Object> filterList(final List<Object> list) {

        List<Object> result = new ArrayList<>();

        for (Object item : list) {
            if (item instanceof String) {
                continue;
            }
            result.add(item);
        }



        return result;
    }





    // highest and lowest
    public static String highAndLow(String numbers) {
        String[] split = numbers.split(" ");
        int highest = Integer.parseInt(split[0]);
        int lowest = Integer.parseInt(split[0]);

        for (int i = 1; i < split.length; i++) {
            int current = Integer.parseInt(split[i]);

            if (current > highest) {
                highest = current;
            }
            if (current < lowest) {
                lowest = current;
            }
        }


        return highest + " " + lowest;
    }




    // regex validate PIN code
    public static boolean validatePIN(String pin) {
        return pin.matches("^\\d{4}$") || pin.matches("^\\d{6}$");
    }



    // jaden casing strings
    public String toJadenCase(String phrase) {

        if (phrase == null || phrase.isEmpty()) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        String[] words = phrase.split(" ");

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (!word.isEmpty()) {
                sb.append(Character.toUpperCase(word.charAt(0)));
                if (word.length() > 1) {
                    sb.append(word.substring(1));
                }
            }
            if (i < words.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }



    // vowel count
    public static int getCount(String str) {


        String vowels = "aeiouAEIOU";

        int count = 0;
        for (char ch : str.toCharArray()) {
            if (vowels.contains(String.valueOf(ch))) {
                count++;
            }
        }


        return count;

    }
























































































































































































































































































































}
