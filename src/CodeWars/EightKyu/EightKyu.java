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






}
