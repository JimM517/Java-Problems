package CodeWars.SixKyu;

import java.util.*;

public class SixKyuQuestions {

    // tribonacci sequence
    public double[] tribonacci(double[] s, int n) {

        if (n == 0) {
            return new double[0];
        }

        double[] result = new double[n];
        for (int i = 0; i < n; i++) {
            if (i < 3) {
                result[i] = s[i];
            } else {
                result[i] = result[i - 1] + result[i - 2] + result[i - 3];
            }
        }

        return result;
    }





    // find the odd int
    public static int findIt(int[] a) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : a) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int count = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
           if (entry.getValue() % 2 != 0) {
               return entry.getKey();
           }
        }


        return -1;

    }







    // sort the odd
    public static int[] sortArray(int[] array) {

            List<Integer> odds = new ArrayList<>();

            for (int i = 0; i < array.length; i++) {
                if (array[i] % 2 == 1) {
                    odds.add(array[i]);
                }
            }

            Collections.sort(odds);
            int oddIdx = 0;

            for (int i = 0; i < array.length; i++) {

                if (array[i] % 2 != 0) {

                    array[i] = odds.get(oddIdx++);
                }
            }



            return array;
    }





    // highest scoring word
    public static String high(String s) {

        String[] words = s.split(" ");
        int maxScore = 0;
        String maxWord = "";

        for (String word : words) {
            int score = 0;
            for (char c : word.toCharArray()) {
                score += c - 'a' + 1;
            }
            if (score > maxScore) {
                maxScore = score;
                maxWord = word;
            }
        }


        return maxWord;

    }






    // delete occurrences of an element if it occurs more than n times
    public static int[] deleteNth(int[] elements, int maxOccurrences){

        List<Integer> result = new ArrayList<>();


        Map<Integer, Integer> freq = new HashMap<>();

      for (int elem : elements) {
          int count = freq.getOrDefault(elem, 0);
          if (count < maxOccurrences) {
              result.add(elem);
              freq.put(elem, count + 1);
          }
      }



      int[] total = new int[result.size()];
      for (int i = 0; i < result.size(); i++) {
          total[i] = result.get(i);
      }

      return total;

    }



    // are they the "same"
    public static boolean comp(int[] a, int[] b) {

        if (a == null || b == null) return false;
        if (a.length != b.length) return false;

        int[] sqaured = Arrays.stream(a).map(x -> x * x).toArray();

        Arrays.sort(sqaured);
        Arrays.sort(b);

        return Arrays.equals(sqaured, b);

    }





    // write numbers in expanded form
    public static String expandedForm(int num) {

        String temp = Integer.toString(num);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < temp.length(); i++) {
            int digit = temp.charAt(i) - '0';
            if (digit != 0) {
                int placeValue = (int) (digit * Math.pow(10, temp.length() - i - 1));

                if (sb.length() > 0) {
                    sb.append(" + ");
                }
                sb.append(placeValue);
            }
        }
        return sb.toString();
    }








    // build a pile of cubes
    public static long findNb(long m) {

        long sum = 0;
        long n = 0;

        while (sum < m) {
            n++;
            sum += n * n * n;
        }
        return sum == m ? n : -1;
    }





    // equal sides of an array
    public static int findEvenIndex(int[] arr) {

        int totalSum = 0;
        int leftSum = 0;

        // First, get the total sum of the array
        for (int num : arr) {
            totalSum += num;
        }

        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            // Right sum = totalSum - leftSum - current element
            int rightSum = totalSum - leftSum - arr[i];

            if (leftSum == rightSum) {
                return i; // return index, not value
            }

            // Add current element to leftSum for next iteration
            leftSum += arr[i];
        }

        return -1; // no index found
    }




    // Array.diff
    public static int[] arrayDiff(int[] a, int[] b) {

       Set<Integer> setB = new HashSet<>();
       for (int x : b) {
           setB.add(x);
       }

       List<Integer> resultList = new ArrayList<>();
       for (int x : a) {
           if (!setB.contains(x)) {
               resultList.add(x);
           }
       }

       int[] result = new int[resultList.size()];
       for (int i = 0; i < resultList.size(); i++) {
           result[i] = resultList.get(i);
       }

        return result;

    }















































}
