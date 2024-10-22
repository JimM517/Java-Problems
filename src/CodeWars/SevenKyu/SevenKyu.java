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















}
