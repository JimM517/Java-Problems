package CodeWars.FourKyu;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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







    // sum strings as numbers
    public static String sumStrings(String a, String b) {


        int i = a.length() - 1;
        int j = b.length() - 1;

        int carry = 0;

        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0 || carry > 0) {

            int da = (i >= 0) ? a.charAt(i--) - '0' : 0;
            int db = (j >= 0) ? b.charAt(j--) - '0' : 0;

            int sum = da + db + carry;
            sb.append(sum % 10);
            carry = sum / 10;

        }


        while (sb.length() > 1 && sb.charAt(sb.length() - 1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
        }


        return sb.reverse().toString();



    }




    // most frequently used words in a text
    public static List<String> top3(String s) {

        Map<String, Integer> count = new HashMap<>();

        Pattern pattern = Pattern.compile("[a-zA-Z']*[a-zA-Z][a-zA-Z']*");
        Matcher matcher = pattern.matcher(s.toLowerCase());

        while (matcher.find()) {
            String word = matcher.group();
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(count.entrySet());

        List<String> result = new ArrayList<>();
        for (int i = 0; i < 3 && !pq.isEmpty(); i++) {
            result.add(pq.poll().getKey());
        }
        return result;
    }








// observed pins
    private static final Map<Character, String> ADJACENTS = new HashMap<>() {{
    put('1', "124");
    put('2', "2135");
    put('3', "326");
    put('4', "4157");
    put('5', "54268");
    put('6', "6953");
    put('7', "748");
    put('8', "87590");
    put('9', "986");
    put('0', "00");
}};

    public static List<String> getPins(String observed) {

        List<String> ans = Arrays.asList("");

        for (char c: observed.toCharArray()) {

            List<String> tmp = new ArrayList<String>();
            for (char cc: ADJACENTS.get(c).toCharArray()) {
                for (String s: ans) tmp.add(s+cc);
            }
            ans = tmp;
        }
        return ans;
    }






    // matrix determinant
    public static int determinant(int[][] matrix) {

        int n = matrix.length;

        if (n == 1) {
            return matrix[0][0];
        }

        if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        int det = 0;

        for (int col = 0; col < n; col++) {
            int[][] minor = buildMinor(matrix, 0, col);
            int sign = (col % 2 == 0) ? 1 : -1;

            det += sign * matrix[0][col] * determinant(minor);
        }

        return det;

    }


    private static int[][] buildMinor(int[][] matrix, int rowToRemove, int colToRemove) {

        int n = matrix.length;
        int[][] minor = new int[n - 1][n - 1];

        int r = 0;

        for (int i = 0; i < n; i++) {
            if (i == rowToRemove) continue;

            int c = 0;
            for (int j = 0; j < n; j++) {
                if (j == colToRemove) continue;


                minor[r][c] = matrix[i][j];

                c++;

            }
            r++;

        }



        return minor;


    }





    // String -> x-iterations -> String
    /** doesn't work yet **/
    public static String stringFunc(String s, long x) {

            int n = s.length();
            char[] result = new char[n];

            boolean[] visited = new boolean[n];

            for (int i = 0; i < n; i++) {
                if (visited[i]) continue;

                int current = i;
                StringBuilder cycle = new StringBuilder();

                while (!visited[current]) {
                    visited[current] = true;
                    cycle.append(s.charAt(current));
                    current = permute(current, n);
                }

                int len = cycle.length();
                int shift = (int) (x % len);

                current = i;
                for (int j = 0; j < len; j++) {
                    result[current] = cycle.charAt((j + shift) % len);
                    current = permute(current, n);
                }


            }

            return new String(result);

    }



    public static int permute(int i, int n) {

        return (i % 2 == 0) ? i / 2 : n - 1 - i / 2;



    }
















































































































}
