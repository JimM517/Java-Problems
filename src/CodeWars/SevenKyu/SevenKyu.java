package CodeWars.SevenKyu;

import java.time.LocalDate;
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



    // nth smallest element
    public static int nthSmallest(final int[] arr, final int n) {

        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);
        return sorted[n - 1];
    }




    // previous multiple of three
    public static int prevMultOfThree(int n) {

        while (n > 0) {
            if (n % 3 == 0) {
                return n;
            }
            n /= 10;
        }
        return -1;
    }




    // simple fun #176 reverse letter
    public static String reverseLetter(final String str) {


        StringBuilder sb = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {

            if (!Character.isLetter(str.charAt(i))) {
                continue;
            }
            sb.append(str.charAt(i));

        }
        return sb.toString();
    }





    // row weights
    public static int[] rowWeights(final int[] weights) {

        int evenWeight = 0;
        int oddWeight = 0;

        for (int i = 0; i < weights.length; i++) {
            if (i % 2 == 0) {
                evenWeight += weights[i];
            } else {
                oddWeight += weights[i];
            }
        }


        return new int[] {evenWeight, oddWeight};


    }


    // sum of angles
    public static int sumOfAngles(int n) {
        return (n - 2) * 180;
    }



    // find the capitals
    public static int[] capitals(String s) {


        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {

            if (Character.isUpperCase(s.charAt(i))) {
                temp.add(i);
            }


        }

        int[] result = new int[temp.size()];
        int k = 0;
        for (int x : temp) {
            result[k++] = x;
        }

        return result;
    }


    // max length difference
    public static int mxdiflg(String[] a1, String[] a2) {

        if (a1 == null || a2 == null || a1.length == 0 || a2.length == 0) {
            return -1;
        }

        int minA1 = Integer.MAX_VALUE;
        int maxA1 = Integer.MIN_VALUE;

        int minA2 = Integer.MAX_VALUE;
        int maxA2 = Integer.MIN_VALUE;


        for (String s : a1) {

            int len = s.length();
            minA1 = Math.min(minA1, len);
            maxA1 = Math.max(maxA1, len);
        }

        for (String s : a2) {

            int len = s.length();
            minA2 = Math.min(minA2, len);
            maxA2 = Math.max(maxA2, len);

        }

        return Math.max(Math.abs(maxA1 - minA2), Math.abs(maxA2 - minA1));

    }





    // name array capping
    public static String[] capMe(String[] strings) {

        for (int i = 0; i < strings.length; i++) {

            if (strings[i].isEmpty()) {
                continue;
            }
            strings[i] = strings[i].substring(0, 1).toUpperCase() + strings[i].substring(1).toLowerCase();
        }
        return strings;
    }




    // form the minimum
    public static int minValues(int[] values) {

        Arrays.sort(values);
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < values.length; i++) {

            String digit = String.valueOf(values[i]);

            if (temp.indexOf(digit) == -1) {
                temp.append(digit);
            }

        }

        return Integer.parseInt(temp.toString());

    }




    // sum of minimums
    public static int sumOfMinimums(int[][] arr) {
        int total = 0;

        for (int i = 0; i < arr.length; i++) {
            int min = Integer.MAX_VALUE;  // reset for each row
            for (int j = 0; j < arr[i].length; j++) {
                min = Math.min(min, arr[i][j]);
            }
            total += min;  // add min of this row
        }

        return total;
    }





    // find your villain name
    public static String getVillainName(LocalDate birthDate) {



        String[] first = { "The Evil","The Vile","The Cruel", "The Trashy","The Despicable", "The Embarrassing", "The Disreputable","The Atrocious", "The Twirling",  "The Orange","The Terrifying", "The Awkward" };
        String[] last = { "Mustache", "Pickle", "Hood Ornament", "Raisin", "Recycling Bin", "Potato", "Tomato", "House Cat", "Teaspoon", "Laundry Basket" };

        int month = birthDate.getMonthValue() - 1;
        int date = birthDate.getDayOfMonth() % 10;


        return first[month] + " " + last[date];
    }





    // friend or for?
    public static List<String> friend(List<String> x) {

        List<String> result = new ArrayList<>();

        for (String temp : x) {

            if (temp.length() == 4) {
                result.add(temp);
            }


        }

        return result;



    }



    // sum of the first nth term of series
    public static String seriesSum(int n) {

        if (n == 0) {
            return "0.00";
        }

        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            sum += 1.0 / (1 + 3 * i);
        }
        return String.format("%.2f", sum);

    }




    // two to one
    public static String longest(String s1, String s2) {

        Set<Character> combinedStringSet = new HashSet<>();
        for (char c : (s1 + s2).toCharArray()) {
            combinedStringSet.add(c);
        }

        List<Character> sortedChars = new ArrayList<>(combinedStringSet);
        Collections.sort(sortedChars);

        StringBuilder sb = new StringBuilder();
        for (char c : sortedChars) {
            sb.append(c);
        }
        return sb.toString();

    }







    // summing a numbers digits
    public static int sumDigits(int number) {

        number = Math.abs(number);
        int sum = 0;

        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }



    // remove the minimum
    public static int[] removeSmallest(int[] numbers) {

        if (numbers.length == 0) {
            return new int[]{};
        }

        int min = numbers[0];

        for (int num : numbers) {
            min = Math.min(min, num);
        }

        List<Integer> result = new ArrayList<>();
        boolean removed = false;

        for (int num : numbers) {

            if (!removed && num == min) {
                removed = true;
            } else {
                result.add(num);
            }


        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }



    // factorial
    public static long factorial(int n) {

        if (n == 0 || n == 1) {
            return 1;
        }

        return n * factorial(n - 1);



    }



    // flatten and sort array
    public static int[] flattenAndSort(int[][] array) {


        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                temp.add(array[i][j]);
            }
        }

        Collections.sort(temp);
        int[] result = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            result[i] = temp.get(i);
        }
        return result;
    }




    // predict your age
    public static int predictAge(int age1, int age2, int age3, int age4, int age5, int age6, int age7, int age8) {


        int total = (age1 * age1) + (age2 * age2) + (age3 * age3) + (age4 * age4) + (age5 * age5) + (age6 * age6) + (age7 * age7) + (age8 * age8);
        total = (int) Math.sqrt(total);
        total /= 2;


        return total;

    }





    // odd-even string sort
    public static String sortMyString(String s) {

        String even = "";
        String odd = "";

        for (int i = 0; i < s.length(); i++) {

            if (i % 2 == 0) {
                even += s.charAt(i);
            } else {
                odd += s.charAt(i);
            }

        }

        return even + " " + odd;


    }



    // you're square
    public static boolean isSquare(int n) {

        int num = (int) Math.sqrt(n);

        return num * num == n;


    }





    // binary addition
    public static String binaryAddition(int a, int b) {

        int sum = a + b;

        return Integer.toBinaryString(sum);



    }



















































































































































































}
