package CodeWars.SevenKyu;

import java.time.LocalDate;
import java.util.*;

public class SevenKyu {


    public static void main(String[] args) {


        System.out.println(generateShape(3));


    }








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




    // small enough?
    public static boolean smallEnough(int[] a, int limit) {

        for (int num : a) {
            if (num > limit) {
                return false;
            }
        }


        return true;
    }




    // power of two
    public static boolean isPowerOfTwo(long n) {


        if (n <= 0) {
            return false;
        }

        while (n > 1) {
            if (n % 2 == 1) {
                return false;
            }
            n /= 2;
        }
        return true;
    }





    // sum of numbers from 0 to N
    public static String showSequence(int value) {

        if (value < 0) return value + "<0";
        if (value == 0) return "0=0";


        StringBuilder result = new StringBuilder();
        int total = 0;
        for (int i = 0; i <= value; i++) {

            total += i;

            result.append(String.valueOf(i));

            if (i < value) {
                result.append("+");
            }



        }

        result.append(" = ").append(total);

        return result.toString();





    }







// the highest profit wins!
    public static int[] minMax(int[] arr) {

        int min = arr[0];
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {

            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);


        }


        return new int[]{min, max};

    }





    // love vs friendship
    public static int wordsToMarks(String text) {


        int total = 0;

        for (char ch : text.toCharArray()) {

            total += ch - 'a' + 1;


        }


        return total;



    }





    // build a square
    public static final String generateShape(int n) {


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append("+");
            }
            if (i < n - 1) {
                sb.append("\n");
            }
        }


        return sb.toString();


    }








    // disemvowel trolls
    public static String disemvowel(String str) {

        StringBuilder sb = new StringBuilder();
        String vowels = "aeiouAEIOU";
        for (int i = 0; i < str.length(); i++) {
            if (vowels.contains(String.valueOf(str.charAt(i)))) {
                continue;
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();

    }





    // powers of I
    public static String pofi(int n) {

        switch (n % 4) {
            case 0: return "1";
            case 1: return "i";
            case 2: return "-1";
            case 3: return "-i";
        }


        return "";



    }




    // product of maximums
    public static long maxProduct(int[] numbers, int sub_size) {


        Arrays.sort(numbers);
        long total = 1;
        int len = numbers.length;
        for (int i = len - 1; i >= len - sub_size; i--) {
            total *= numbers[i];
        }
        return total;
    }



    // string scramble
    public static String scramble(String str, int[] indices) {

        char[] result = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            result[indices[i]] = str.charAt(i);
        }
        return new String(result);
    }





// breaking chocolate problem
    public static long breakChocolate(long n, long m) {


        return (n * m) - 1;



    }


    // find the next perfect square
    public static long findNextSquare(long sq) {

        long root = (long) Math.sqrt(sq);

        if (root * root != sq) {
            return -1;
        }

        return (root + 1) * (root + 1);
    }






    // is this a triangle?
    public static boolean isTriangle(int a, int b, int c) {

        if (a <= 0 || b <= 0 || c <= 0) {
            return false;
        }

        return a + b > c && a + c > b && b + c > a;

    }





    // convert a linked list to a string
    static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public int getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }
    }
    public static String stringify(Node list) {

        StringBuilder sb = new StringBuilder();

        while (list != null) {
            sb.append(list.getData()).append(" -> ");
            list = list.getNext();
        }

        sb.append("null");
        return sb.toString();


    }




    // center of the matrix
    public static Integer center(int[][] matrix) {

        if (matrix.length == 0) return null;

        int row = matrix.length;
        int col = matrix[0].length;

        if ((row * col) % 2 == 0) return null;
        else {
            int midRow = row / 2;
            int midCol = col / 2;
            return matrix[midRow][midCol];
        }

    }





    // count the digit
    public static int nbDig(int n, int d) {

        int total = 0;
        for (int i = 0; i <= n; i++) {

            int curr = i * i;

            if (curr == 0 && d == 0) {
                total++;
            }

            while (curr > 0) {
                if (curr % 10 == d) {
                    total++;
                }
                curr /= 10;
            }


        }

        return total;



    }



    // even numbers in an array
    public static int[] evenNumbers(int[] arr, int n) {

        List<Integer> evens = new ArrayList<>();
        for (int x : arr) {
            if (x % 2 == 0) {
                evens.add(x);
            }
        }


        int[] result = new int[n];
        int k = evens.size() - n;
        for (int i = 0; i < n; i++) {
            result[i] = evens.get(k + i);
        }


        return result;


    }





// sum of odd cubed numbers
    public static int cubeOdd(int[] arr) {

        int sum = 0;

        for (int x : arr) {
            int cube = x * x * x;
            if (cube % 2 != 0) {
                sum += cube;
            }
        }


        return sum;



    }



// convert string to camel case
    public static String toCamelCase(String s) {


        String[] arr = s.split("[-_]");
        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]);
        for (int i = 1; i < arr.length; i++) {

            char first = Character.toUpperCase(arr[i].charAt(0));
            String sub = arr[i].substring(1);

            sb.append(first).append(sub);



        }

        return sb.toString();

    }




    // rotate for max
    public static long maxRot(long n) {

        String s = Long.toString(n);
        long max = n;

        for (int i = 0; i < s.length() - 1; i++) {

            String fixed = s.substring(0, i);
            String rotate = s.substring(i);

            rotate = rotate.substring(1) + rotate.charAt(0);

            s = fixed + rotate;

            long current = Long.parseLong(s);
            if (current > max) {
                max = current;
            }


        }

        return max;



    }



    // pony express
    public static int riders(final int[] stations) {

        int riders = 1;
        int sum = 0;

        for (int distance : stations) {
            if (sum + distance > 100) {
                riders++;
                sum = distance;
            } else {
                sum += distance;
            }
        }

        return riders;

    }



    // valid parentheses
    public static boolean validParentheses(String parenStr) {

        Stack<Character> stack = new Stack<>();
        for (char c : parenStr.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();
                if (c == ')' && top != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }





// round up to the next multiple of 5
public static int roundToNext5(int number) {

    return (int) (Math.ceil(number / 5.0) * 5);
}








// sum of array singles
    public static int repeats(int[] arr) {

        int sum = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> key : map.entrySet()) {

            int value = key.getValue();

            if (value == 1) {
                sum += key.getKey();
            }

        }


        return sum;

    }




    // steps
    public static int step(int x, int y) {

       if (x == y) return 0;

       return (int) Math.ceil(2 * Math.sqrt(y - x) - 1);





    }




    // number of people in the bus
    public static int countPassengers(ArrayList<int[]> stops) {

        int total = 0;

        for (int[] x : stops) {

            int beginners = x[0];
            total += beginners;


        }

        for (int[] j : stops) {
            int end = j[1];
            total -= end;
        }

        return total;

    }




    // dont give me five!
    public static int dontGiveMeFive(int start, int end) {


        int nonFives = 0;

        for (int i = start; i <= end; i++) {
            String fiveStr = Integer.toString(i);
            if (!fiveStr.contains("5")) {
                nonFives++;
            }

        }

        return nonFives;



    }



    // 2D Vector Mapping
    public static double[] mapVector(double[] vector, double[] circle1, double[] circle2) {

        double vx = vector[0];
        double vy = vector[1];

        double c1x = circle1[0];
        double c1y = circle1[1];
        double r1 = circle1[2];

        double c2x = circle2[0];
        double c2y = circle2[1];
        double r2 = circle2[2];

        double dx = vx - c1x;
        double dy = vy - c1y;

        double scale = r2 / r1;

        double newX = c2x + dx * scale;
        double newY = c2y + dy * scale;

        newX = Math.round(newX * 100.0) / 100.0;
        newY = Math.round(newY * 100.0) / 100.0;

        return new double[] { newX, newY};

    }



    // largest 5 digit number in a series
    public static int solve(final String digits) {

        int largest = 0;
        int limit = 5;

        for (int i = 0; i <= digits.length() - limit; i++) {

            String chunk = digits.substring(i, i + limit);

            int value = Integer.parseInt(chunk);

            if (value > largest) {
                largest = value;
            }

        }

        return largest;




    }




    // all inclusive
    public static boolean containsAllRots(String strng, List<String> arr) {

        if (strng.isEmpty()) return true;

        int len = strng.length();
        String doubled = strng + strng;

        for (int i = 0; i < len; i++) {
            String rotation = doubled.substring(i, i + len);
            if (!arr.contains(rotation)) {
                return false;
            }
        }

        return true;

    }






    // largest pair sum in array
    public static int largestPairSum(int[] numbers) {
        Arrays.sort(numbers);

        return numbers[numbers.length - 1] + numbers[numbers.length - 2];
    }






    // sorted? yes? no? how?
    public static String isSortedAndHow(int[] array) {

        boolean ascending = true;
        boolean descending = true;

        for (int i = 0; i < array.length - 1; i++) {

            if (array[i] > array[i + 1]) {
                ascending = false;
            }
            if (array[i] < array[i + 1]) {
                descending = false;
            }


        }

        if (ascending) {
            return "yes, ascending";
        } else if (descending) {
            return "yes, descending";
        } else {
            return "no";
        }

    }




    // alternate capitalization
    public static String[] capitalize(String s) {



        StringBuilder even = new StringBuilder();
        StringBuilder odd = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {


            if (i % 2 == 0) {
                char current = Character.toUpperCase(s.charAt(i));
                even.append(current);
            } else {
                even.append(s.charAt(i));
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 1) {
                char current = Character.toUpperCase(s.charAt(i));
                odd.append(current);
            } else {
                odd.append(s.charAt(i));
            }
        }



        return new String[]{ even.toString(), odd.toString() };


    }





    // two oldest ages
    public static int[] twoOldestAges(int[] ages) {


        Arrays.sort(ages);

        return new int[]{ ages[ages.length - 2], ages[ages.length - 1] };

    }







    // compoundArray
    public static int[] compoundArray(int[] a, int[] b) {

        int m = a.length + b.length;
        int[] result = new int[m];


        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a.length && j < b.length) {

            result[k++] = a[i++];
            result[k++] = b[j++];


        }


        while (i < a.length) {
            result[k++] = a[i++];
        }

        while (j < b.length) {
            result[k++] = b[j++];
        }

        return result;

    }








































}
