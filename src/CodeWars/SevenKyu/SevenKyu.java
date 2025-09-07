package CodeWars.SevenKyu;

import java.util.*;

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




    // beginner series #3 sum of numbers
    public int GetSum(int a, int b) {

        int total = 0;

        int larger = Math.max(a, b);
        int smaller = Math.min(a, b);

     for (int i = smaller; i <= larger; i++) {
         if (smaller == larger) {
             return smaller;
         }
         total += i;
     }
     return total;
    }



    // mumbling
    public static String accum(String s) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            sb.append(Character.toUpperCase(s.charAt(i)));

            for (int j = 0; j < i; j++) {
                sb.append(Character.toLowerCase(s.charAt(i)));
            }

            if (i < s.length() - 1) {
                sb.append("-");
            }

        }




        return sb.toString();


    }




    // ones and zeroes
    public static int ConvertBinaryArrayToInt(List<Integer> binary) {


        String convert = "";
        for (int i = 0; i < binary.size(); i++) {
            convert += Integer.toString(binary.get(i));
        }

        int num = Integer.parseInt(convert, 2);


        return num;



    }





    // sum of odd numbers
    public static int rowSumOddNumbers(int n) {

            return n * n * n;



    }




    // sum of two lowest positive integers
    public static long sumTwoSmallestNumbers(long[] numbers) {

        long answer = 0;

        Arrays.sort(numbers);


        answer += numbers[0] + numbers[1];

        return answer;

    }



    // odd or even
    public static String oddOrEven(int[] array) {

        int total = Arrays.stream(array).sum();


        return total % 2 == 0 ? "even" : "odd";

    }





    // complimentary DNA
    public static String makeComplement(String dna) {

        StringBuilder sb = new StringBuilder();

        for (char ch : dna.toCharArray()) {
            switch (ch) {
                case 'A':
                    sb.append('T');
                    break;
                case 'T':
                    sb.append('A');
                    break;
                case 'C':
                    sb.append('G');
                    break;
                case 'G':
                    sb.append('C');
                    break;
            }
        }


       return sb.toString();

    }



    // geometry basics: DOT product in 3D
//    public static double dotProduct(final Vector3D a, final Vector3D b) {
//
//        return (a.x * b.x) + (a.y * b.y) + (a.z * b.z);
//    }


    // isograms
    public static boolean isIsogram(String str) {

        Set<Character> characterSet = new HashSet<>();
        String lower = str.toLowerCase();

        for (char ch : lower.toCharArray()) {
            if (characterSet.contains(ch)) {
                return false;
            }
            characterSet.add(ch);
        }
        return true;
    }



    // parse int from char problem
    public static int howOld(final String herOld) {

        return herOld.charAt(0) - '0';

    }





    // find the stray number
    public static int stray(int[] numbers) {

        int a = numbers[0], b = numbers[1], c = numbers[2];

        int majority = (a == b || a == c) ? a : b;

        for (int num : numbers) {
            if (num != majority) {
                return num;
            }
        }
        return -1;
    }







    // remove the anchor from URL
    public static String removeUrlAnchor(String url) {

        int idx = url.indexOf("#");

        return (idx == -1) ? url : url.substring(0, idx);

    }




    // money, money, money
    public static int calculateYears(double principal, double interest, double tax, double desired) {

            int years = 0;
            while (principal < desired) {
                double net = principal * interest * (1 - tax);
                principal += net;
                years++;
            }


            return years;

    }




    // anagram detection
    public static boolean isAnagram(String a, String b) {

            if (a == null || b == null) {
                return false;
            }

            a = a.toLowerCase();
            b = b.toLowerCase();

            if (a.length() != b.length()) {
                return false;
            }

            char[] charA = a.toCharArray();
            char[] charB = b.toCharArray();

            Arrays.sort(charA);
            Arrays.sort(charB);

            return Arrays.equals(charA, charB);

    }



































































































































































































































































}
