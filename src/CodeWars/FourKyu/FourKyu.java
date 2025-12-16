package CodeWars.FourKyu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourKyu {


// strip comments
    /** DOESNT WORK YET **/
    public static String stripComments(String text, String[] commentSymbols) {

        String[] lines = text.split("\n");
        StringBuilder result = new StringBuilder();

        for (String line : lines) {
            String cleaned = line;

            for (String symbol : commentSymbols) {
                int index = cleaned.indexOf(symbol);
                if (index != -1) {
                    cleaned = cleaned.substring(0, index);
                }
            }

            cleaned = cleaned.stripTrailing();

            result.append(cleaned).append("\n");


        }



        return result.toString().stripTrailing();


    }






    // snail sort
    public static int[] snail(int[][] array) {

        if (array == null || array.length == 0 || array[0].length == 0) {
            return new int[0];
        }

        int n = array.length;
        List<Integer> result = new ArrayList<>();

        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                result.add(array[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                result.add(array[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(array[bottom][i]);
                }
                bottom--;
            }


            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(array[i][left]);
                }
                left++;
            }

        }


        return result.stream().mapToInt(i -> i).toArray();




    }






    // so many permutations!!!!
    public static List<String> singlePermutations(String s) {

       Set<String> result = new HashSet<>();

       boolean[] used = new boolean[s.length()];
       permuteBT(result, new StringBuilder(), s, used);
       return new ArrayList<>(result);

    }



    public static void permuteBT(Set<String> result, StringBuilder current, String s, boolean[] used) {

        if (current.length() == s.length()) {
            result.add(current.toString());
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (used[i]) continue;

            used[i] = true;
            current.append(s.charAt(i));

            permuteBT(result, current, s, used);

            current.deleteCharAt(current.length() - 1);
            used[i] = false;
        }




    }


















































































































































}
