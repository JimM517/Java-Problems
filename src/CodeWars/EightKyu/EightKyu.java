package CodeWars.EightKyu;

import java.util.*;

public class EightKyu {

    // well of ideas
    public String well(String[] x) {

        int count = 0;

        for (String idx : x) {
            if (idx.equals("good")) {
                count++;
            }
        }

        if (count > 2) {
            return "I smell a series!";
        } else if (count == 1 || count == 2) {
            return "Publish!";
        } else {
            return "Fail!";
        }


    }




    // sum arrays
    public double sum(double[] numbers) {

        return Arrays.stream(numbers).sum();
    }





    // beginner series #4 Cockroach
    public int cockroachSpeed(double x) {

        double cmsPerSec = x * 100000 / 3600;


        return (int) Math.floor(cmsPerSec);
    }




    // sentence smash
    public String smash(String... words) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);

            if (i < words.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }





    // collinear vectors
    public boolean collinearity(int x1, int y1, int x2, int y2) {

        return x1 * y2 == y1 * x2;

    }




    // calculate BMI
    public String bmi(double weight, double height) {

        double BMI = weight / Math.pow(height, 2);


        if (BMI <= 18.5) {
            return "Underweight";
        } else if (BMI <= 25.0) {
            return "Normal";
        } else if (BMI <= 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }




    }






    // find th nth occurrence of a word in a string
    public static int findNthOccurrence(String subStr, String str, int occurrence) {


        int count = 0;

        for (int i = 0; i <= str.length() - subStr.length(); i++) {
            if (str.substring(i, i + subStr.length()).equals(subStr)) {
                count++;
                if (count == occurrence) {
                    return i;
                }
            }
        }

        return -1;


    }



    // simple calculator
    public static double calculate(double a, double b, String op) {

        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
            default:
                throw new IllegalArgumentException();
        }


    }






    // sum of multiples
    public static long sumMul(int n, int m) {

        if (n <= 0 || m <= 0) {
            throw new IllegalArgumentException("Both n and m must be natural numbers (positive integers).");
        }

        long sum = 0;

        for (int i = n; i < m; i += n) {
            sum += i;
        }

        return sum;

    }



    // third angle of a triangle
    public static int otherAngle(int angle1, int angle2) {

        return 180 - (angle1 + angle2);


    }



    // convert a string to an array
    public static String[] stringToArray(String s) {
        return s.split(" ");
    }




    // fake binary
    public static String fakeBin(String numberString) {

        StringBuilder sb = new StringBuilder();

        for (char c : numberString.toCharArray()) {
            int current = c - '0';
            if (current < 5) {
                sb.append("0");
            } else {
                sb.append("1");
            }
        }

        return sb.toString();

    }


    // sum without highest and lowest number
    public static int sum(int[] numbers) {
      if (numbers == null || numbers.length <= 2) {
          return 0;
      }
      int max = Integer.MIN_VALUE;
      int min = Integer.MAX_VALUE;
      int total = 0;

      for (int num : numbers) {
          total += num;
          if (num < min) {
              min = num;
          }
          if (num > max) {
              max = num;
          }
      }
      return total - min - max;
    }




    // square (n) sum
    public static int squareSum(int[] n) {

        int total = 0;

        for (int num : n) {
            total += Math.pow(num, 2);
        }

        return total;
    }



    // opposites attract
    public static boolean isLove(final int flower1, final int flower2) {

        return (flower1 % 2) != (flower2 % 2);

    }








    // volume of a cuboid
    public static double getVolumeOfCuboid(final double length, final double width, final double height) {


        return length * width * height;



    }



    // reverse strings
    public static String reversedString(String str) {

        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }


        return sb.toString();
    }




    // get character from ASCII value
    public static char getChar(int c) {

        return (char) c;

    }




    // alternating case
    public static String toAlternatingString(String string) {

        StringBuilder sb = new StringBuilder();

        for (char ch : string.toCharArray()) {

            if (ch == Character.toLowerCase(ch)) {
                sb.append(Character.toUpperCase(ch));
            } else {
                sb.append(Character.toLowerCase(ch));
            }


        }

        return sb.toString();

    }





    // reversed sequence
    public static int[] reverse(int n) {

        int[] result = new int[n];
        int idx = 0;
        for (int i = n; i >= 1; i--) {
            result[idx++] = i;
        }

        return result;
    }




    // function 2 - squaring an argument
    public static int square(int n) {
        return (int) Math.pow(n, 2);
    }







    // grasshopper - basic function fixer
    public static int addFive(int num) {

        return num + 5;


    }


    // double char
    public static String doubleChar(String s) {

        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {

            sb.append(ch).append(ch);


        }


        return sb.toString();

    }







    // no zeros for heroes
    public static int noBoringZeros(int n) {


        if (n == 0) {
            return 0;
        }

        while (n % 10 == 0) {
            n /= 10;
        }
        return n;
    }



    // add length
    public static String[] addLength(String str) {

        String[] result = str.split(" ");

        for (int i = 0; i < result.length; i++) {

            String current = result[i];
            int len = current.length();

            current += " " + len;

            result[i] = current;


        }

        return result;

    }


    // remove duplicates from a list
    public static int[] distinct(int[] array) {
        Set<Integer> set = new LinkedHashSet<>();

        for (int num : array) {
            set.add(num);
        }


        int[] result = new int[set.size()];
        int k = 0;
        for (int num : set) {
            result[k++] = num;
        }

        return result;
    }


    // multiple of index
    public static int[] multipleOfIndex(int[] array) {

        List<Integer> list = new ArrayList<>();
        if (array[0] == 0) {
            list.add(0);
        }

        for (int i = 1; i < array.length; i++) {
            if (array[i] % i == 0) {
                list.add(array[i]);
            }
        }
        return list.stream().mapToInt(x -> x).toArray();
    }





    // a needle in the haystack
    public static String findNeedle(Object[] haystack) {

        for (int i = 0; i < haystack.length; i++) {
            if ("needle".equals(haystack[i])) {
                return "found the needle at position " + i;
            }
        }
        return "needle not found";
    }



    // plural
    public static boolean isPlural(float f) {

        return f != 1;


    }


    // removing elements
    public static Object[] removeEveryOther(Object[] arr) {

        List<Object> myList = new ArrayList<>();

        for (int i = 0; i < arr.length; i+=2) {
            myList.add(arr[i]);
        }

        Object[] result = new Object[myList.size()];
        int k = 0;
        for (Object x : myList) {
            result[k++] = x;
        }

        return result;
    }




    // surface area and volume of a box
    public static int[] getSize(int w, int h, int d) {

        int[] result = new int[2];

        int surfaceArea = 2 * (w * h + w * d + h * d);
        int volume = w * h * d;

        result[0] = surfaceArea;
        result[1] = volume;

        return result;
    }




    // is it even?
    public boolean isEven(double n) {

        return n % 2 == 0;

    }




    // find the smallest integer in an array
    public static int findSmallestInt(int[] args) {

        int min = args[0];
        for (int i = 1; i < args.length; i++) {
            min = Math.min(min, args[i]);
        }

        return min;
    }



    // area or perimeter
    public static int areaOrPerimeter(int l, int w) {

        if (l == w) {
            return l * w;
        }
        return (2 * l) + (2 * w);
    }




    // DNA to RNA conversion
    public String dnaToRna(String dna) {

        StringBuilder sb = new StringBuilder();

        for (char c : dna.toCharArray()) {

            if (c == 'T') {
                sb.append('U');
            } else {
                sb.append(c);
            }


        }

        return sb.toString();

    }


    // hex to decimal
    public static int hexToDecimal(final String hexString) {

        return Integer.parseInt(hexString, 16);


    }




    // abbreviate a two word name
    public static String abbrevName(String name) {


        String[] splitName = name.split(" ");
        char first = Character.toUpperCase(splitName[0].charAt(0));
        char last = Character.toUpperCase(splitName[1].charAt(0));

        return first + "." + last;



    }






    // find out whether the shape is a cube
    public static boolean isCube(int volume, int side) {

        if (volume <= 0 || side <= 0) {
            return false;
        }
        return volume == side * side * side;


    }



    // a wolf in sheep's clothing
    public static String warnTheSheep(String[] array) {


             // "Oi! Sheep number 1! You are about to be eaten by a wolf!";

            // "Pls go away and stop eating my sheep";

        int wolfIndex = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i].equals("wolf")) {
                wolfIndex = i;
                break;
            }
        }

        if (wolfIndex == array.length - 1) {
            return "Pls go away and stop eating my sheep";
        }

        int sheepNumber = array.length - wolfIndex - 1;
        return "Oi! Sheep number " + sheepNumber + "! You are about to be eaten by a wolf!";

    }




    // enumerable magic #25 - take the first N elements
    public static int[] take(int[] arr, int n) {

        if (arr == null || arr.length == 0 || n <= 0) {
            return new int[]{};
        }

        int limit = Math.min(n, arr.length);
        int[] result = new int[limit];

        for (int i = 0; i < limit; i++) {
            result[i] = arr[i];
        }
        return result;
    }



    // convert to binary
    public static int toBinary(int n) {


        String temp = Integer.toBinaryString(n);


        return Integer.parseInt(temp);

    }

    // another solution to converting to binary
    public static int toBinaryTwo(int n) {

        int multiplier = 1;
        int value = 0;

        do {
            value += (n % 2) * multiplier;
            n /= 2;
            multiplier *= 10;
        } while (n > 0);

        return value;


    }





 // exclamation marks series 11: replace all vowel to exclamation mark in sentence
    public static String replace(final String s) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ("aeiouAEIOU".indexOf(c) != -1) {
                result.append('!');
            } else {
                result.append(c);
            }
        }

        return result.toString();

    }






    // count by x
    public static int[] countBy(int x, int n) {

        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {

            answer[i] = x * (i + 1);


        }

        return answer;

    }





    // keep hydrated
    public static int liters(double time) {


        return (int) ((int) time * 0.5);


    }





    // 1625. lexicograpically smallest string after applying operations

        public String findLexSmallestString(String s, int a, int b) {
            int n = s.length();
            String res = s;
            s = s + s;
            int g = gcd(b, n);

            for (int i = 0; i < n; i += g) {
                char[] t = s.substring(i, i + n).toCharArray();
                add(t, n, a, 1);
                if (b % 2 != 0) {
                    add(t, n, a, 0);
                }
                String tStr = new String(t);
                if (tStr.compareTo(res) < 0) {
                    res = tStr;
                }
            }
            return res;
        }

        public void add(char[] t, int n, int a, int start) {
            int minVal = 10;
            int times = 0;
            for (int i = 0; i < 10; i++) {
                int added = ((t[start] - '0') + i * a) % 10;
                if (added < minVal) {
                    minVal = added;
                    times = i;
                }
            }
            for (int i = start; i < n; i += 2) {
                t[i] = (char) ('0' + (((t[i] - '0') + times * a) % 10));
            }
        }

        public int gcd(int num1, int num2) {
            while (num2 != 0) {
                int temp = num1;
                num1 = num2;
                num2 = temp % num2;
            }
            return num1;
        }




    // sum differences of arrays
    public static int sumOfDifferences(int[] arr) {



        int sumDiff = 0;

        for (int i = 0; i < arr.length - 1; i++) {


            sumDiff += (arr[i] - arr[i + 1]);

        }

        return Math.abs(sumDiff);


    }


    // beginner series #1 school paperwork
    public static int paperWork(int n, int m) {

        if (n < 0 || m < 0) {
            return 0;
        }

        return n * m;
    }







    // find the position
    public static String position(char alphabet) {


        int res = alphabet - 'a' + 1;


        return "Position of alphabet: " + res;

    }





    // is it a palindrome?
    public static Boolean isPalindrome(String x) {

        x = x.toLowerCase().replaceAll("[^a-z0-9]", "");
        int i = 0;
        int j = x.length() - 1;

        while (i < j) {
            if (x.charAt(i) != x.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;

    }



    // welcome to the city
    public String sayHello(String[] name, String city, String state) {

        if (name.length == 1) {
            return "Hello, " + name[0] + "! Welcome to " + city + ", " + state + "!";
        }

        if (name.length == 3) {
            return "Hello, " + name[0] + " " + name[1] + " " + name[2] + "! Welcome to " + city + ", " + state + "!";
        }


        return "Hello, " + name[0] + " " + name[1] + "! Welcome to " + city + ", " + state + "!";


    }




    // tip calculator
    public static Integer calculateTip(double amount, String rating) {
        if (rating == null) return null;

        return switch (rating.toLowerCase()) {
            case "terrible" -> 0;
            case "poor" -> (int) Math.ceil(amount * 0.05);
            case "good" -> (int) Math.ceil(amount * 0.10);
            case "great" -> (int) Math.ceil(amount * 0.15);
            case "excellent" -> (int) Math.ceil(amount * 0.20);
            default -> null;
        };
    }




    // switch it up
    public static String switchItUp(int number) {

        return switch (number) {
            case 1 -> "One";
            case 2 -> "Two";
            case 3 -> "Three";
            case 4 -> "Four";
            case 5 -> "Five";
            case 6 -> "Six";
            case 7 -> "Seven";
            case 8 -> "Eight";
            case 9 -> "Nine";
            default -> "Zero";
        };



    }





    // to sqaure(root) or not to square(root)
    public static int[] squareOrSquareRoot(int[] array) {

        for (int i = 0; i < array.length; i++) {

            double sqrt = Math.sqrt(array[i]);

            if (sqrt == (int) sqrt) {
                array[i] = (int) sqrt;
            } else {
                array[i] = array[i] * array[i];
            }



        }
        return array;
    }



    // lario and muigi pipe problem
    public static int[] pipeFix(int[] numbers) {

        int start = numbers[0];
        int end = numbers[numbers.length - 1];

        int[] result = new int[end - start + 1];

        for (int i = 0; i < result.length; i++) {
            result[i] = start + i;
        }

        return result;

    }




    // calculate average
    public static double findAverage(int[] array) {

        if (array.length == 0) {
            return 0.0;
        }


        double result = 0.0;

        for (int i = 0; i < array.length; i++) {
            result += array[i];
        }


        return result / array.length;



    }





    // gravitation force between two objects
    public static double findGrav(double[] arrVal, String[] arrUnit) {

        // both len 3 - > mass ob1, mass ob2, distance

        final double G = 6.67e-11;

        // convert m1, m2 to kg
        // convert r into meters

        double m1 = arrVal[0];
        double m2 = arrVal[1];
        double r = arrVal[2];

        // convert mass 1
        switch (arrUnit[0]) {
            case "g": m1 /= 1_000; break;
            case "mg": m1 /= 1_000_000; break;
            case "μg": m1 /= 1_000_000_000; break;
            case "lb": m1 *= 0.453592; break;
        }

        switch (arrUnit[1]) {
            case "g": m2 /= 1_000; break;
            case "mg": m2 /= 1_000_000; break;
            case "μg": m2 /= 1_000_000_000; break;
            case "lb": m2 *= 0.453592; break;
        }

        switch (arrUnit[2]) {
            case "cm": r /= 100; break;
            case "mm": r /= 1_000; break;
            case "μm": r /= 1_000_000; break;
            case "ft": r *= 0.3048; break;
        }

        return G * m1 * m2 / (r * r);

    }



    // grasshopper - terminal game combat function
    public static int combat(int health, int damage) {

        int total = health - damage;

        return total < 0 ? 0 : total;

    }






    // will you make it?
    public static boolean zeroFuel(double distanceToPump, double mpg, double fuelLeft) {

        return mpg * fuelLeft >= distanceToPump;

    }






// USD => CNY
    public static String usdcny(int usd) {

        double cnyCon = usd * 6.75;
        String result = String.format("%.2f", cnyCon);

        return result + " Chinese Yuan";


    }





// determine offspring sex based on genes XX and XY chromosomes
    public static String chromosomeCheck(String sperm) {

        if (sperm.equals("XX")) {
            return "Congratulations! You're going to have a daughter.";
        }

        if (sperm.equals("XY")) {
            return "Congratulations! You're going to have a son.";
        }



        return "";


    }





    // FIXME: replace all dots
    public static String replaceDots(final String str) {


        return str.replaceAll("\\.", "-");


    }










































































































}
