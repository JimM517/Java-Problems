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




    // take a ten minute walk
    public static boolean isValid(char[] walk) {


        if (walk.length != 10) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : walk) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int north = map.getOrDefault('n', 0);
        int south = map.getOrDefault('s', 0);
        int east = map.getOrDefault('e', 0);
        int west = map.getOrDefault('w', 0);

        return north == south && east == west;

    }


   // is number prime
    public static boolean isPrime(int num) {

        if (num <= 1) {
            return false;
        }

        if (num <= 3) {
            return true;
        }

        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }

        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }





    // the supermarket queue
    public static int solveSuperMarketQueue(int[] customers, int n) {

        int[] tills = new int[n];

        for (int time : customers) {

            int idx = 0;
            for (int i = 1; i < n; i++) {
                if (tills[i] < tills[idx]) {
                    idx = i;
                }
            }

            tills[idx] += time;
        }

        int max = 0;
        for (int t : tills) {
            if (t > max) {
                max = t;
            }
        }

        return max;

    }




    // counting duplicates
    public static int duplicateCount(String text) {

        Map<Character, Integer> charMap = new HashMap<>();

        for (char ch : text.toCharArray()) {

            char curr = Character.toLowerCase(ch);

            charMap.put(curr, charMap.getOrDefault(curr, 0) + 1);

        }


        int total = 0;

        for (int x : charMap.values()) {
            if (x > 1) {
                total++;
            }
        }


        return total;

    }






    // multiplication table
    public static int[][] multiplicationTable(int n) {

        int[][] table = new int[n][n];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }


        return table;


    }







    // playing with passphrases
    public static String playPass(String s, int n) {

        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {

            if (Character.isLetter(ch)) {

                char base = 'A';

                char shifted = (char) ((ch - base + n) % 26 + base);
                sb.append(shifted);

            } else if (Character.isDigit(ch)) {
                int digit = ch - '0';
                sb.append(9 - digit);
            } else {
                sb.append(ch);
            }
        }


        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (Character.isLetter(c)) {
                if (i % 2 == 0) {
                    sb.setCharAt(i, Character.toUpperCase(c));
                } else {
                    sb.setCharAt(i, Character.toLowerCase(c));
                }
            }
        }

        sb.reverse();

        return sb.toString();

    }






    // bouncing balls
    public static int bouncingBall(double h, double bounce, double window) {

        if (h <= 0 || bounce <= 0 || bounce >= 1 || window >= h) {
            return -1;
        }

        int seen = 1;
        double height = h * bounce;

        while (height > window) {
            seen += 2;
            height *= bounce;
        }

        return seen;
    }





    // help the bookseller
    public static String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {

        if (lstOfArt.length == 0 || lstOf1stLetter.length == 0) {
            return "";
        }

        int[] totals = new int[lstOf1stLetter.length];

        for (String art : lstOfArt) {

            String letter = art.substring(0, 1);
            int qty = Integer.parseInt(art.split(" ")[1]);

            for (int j = 0; j < lstOf1stLetter.length; j++) {
                if (letter.equals(lstOf1stLetter[j])) {
                    totals[j] += qty;
                }
            }


        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lstOf1stLetter.length; i++) {
            if (i > 0) {
                sb.append(" - ");
            }
            sb.append("(")
                    .append(lstOf1stLetter[i])
                    .append(" : ")
                    .append(totals[i])
                    .append(")");
        }

        return sb.toString();


    }




    // detect pangram
    public boolean check(String sentence) {

        Set<Character> letters = new HashSet<>();
        for (char ch : sentence.toLowerCase().toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                letters.add(ch);
            }
        }
        return letters.size() == 26;


    }


    // two sum
    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }


        }

        return new int[]{-1, -1};




    }



    // consecutive strings
    public static String longestConsec(String[] strarr, int k) {

        if (strarr == null || strarr.length == 0 || k > strarr.length || k <= 0) {
            return "";
        }

        String longest = "";
        int maxLen = 0;

        for (int i = 0; i <= strarr.length - k; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < k; j++) {
                sb.append(strarr[i + j]);
            }
            String temp = sb.toString();
            if (temp.length() > maxLen) {
                maxLen = temp.length();
                longest = temp;
            }
        }

        return longest;
    }





    // persistent bugger
    public static int persistence(long n) {

        int count = 0;

        while (n >= 10) {


            long product = 1;

            while (n > 0) {

                product *= (n % 10);
                n /= 10;

            }
            n = product;
            count++;

        }

        return count;



    }




    // reverse or rotate
    public static String revRot(String strng, int sz) {

        if (sz <= 0 || strng.isEmpty() || sz > strng.length()) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i + sz <= strng.length(); i += sz) {
            String chunk = strng.substring(i, i + sz);
            int sum = 0;


            for (char c : chunk.toCharArray()) {
                sum += Character.getNumericValue(c);
            }

            if (sum % 2 == 0) {
                result.append(new StringBuilder(chunk).reverse());
            } else {
                result.append(chunk.substring(1)).append(chunk.charAt(0));
            }
        }

        return result.toString();





    }






    // who likes it?
    public static String whoLikesIt(String... names) {


        int n = names.length;

        if (n == 0) {
            return "no one likes this";
        } else if (n == 1) {
            return names[0] + " likes this";
        } else if (n == 2) {
            return names[0] + " and " + names[1] + " like this";
        } else if (n == 3) {
            return names[0] + ", " + names[1] + " and " + names[2] + " like this";
        } else { // n >= 4
            return names[0] + ", " + names[1] + " and " + (n - 2) + " others like this";
        }
    }



    // your order please
    public static String order(String words) {

        if (words == null || words.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        String[] wordsArray = words.split(" ");


        for (int i = 1; i <= wordsArray.length; i++) {
            String key = Integer.toString(i);
            for (String word : wordsArray) {
                if (word.contains(key)) {
                    if (sb.length() > 0) {
                        sb.append(" ");
                    }
                    sb.append(word);
                    break;
                }
            }
        }


        return sb.toString();


    }





    // string subpattern recognition I
    public static boolean hasSubpattern(String str) {

        if (str.length() == 1) {
            return false;
        }

        String doubled = str + str;
        String trimmed = doubled.substring(1, doubled.length() - 1);
        return trimmed.contains(str);
    }





    // 2043. simple bank system
    class Bank {

        long[] balance;

        public Bank(long[] balance) {
            this.balance = balance;
        }

        public boolean transfer(int account1, int account2, long money) {
            if (
                    account1 > balance.length ||
                            account2 > balance.length ||
                            balance[account1 - 1] < money
            ) {
                return false;
            }
            balance[account1 - 1] -= money;
            balance[account2 - 1] += money;
            return true;
        }

        public boolean deposit(int account, long money) {
            if (account > balance.length) {
                return false;
            }
            balance[account - 1] += money;
            return true;
        }

        public boolean withdraw(int account, long money) {
            if (account > balance.length || balance[account - 1] < money) {
                return false;
            }
            balance[account - 1] -= money;
            return true;
        }
    }


    // IP address to number
    class IpTranslator {

        public static long ipToNum(String ip) {
            String[] parts = ip.split("\\.");
            long num = 0;
            num |= (Long.parseLong(parts[0]) << 24);
            num |= (Long.parseLong(parts[1]) << 16);
            num |= (Long.parseLong(parts[2]) << 8);
            num |= (Long.parseLong(parts[3]));
            return num;
        }


        public static String numToIp(long num) {
            return String.format("%d.%d.%d.%d",
                    (num >> 24) & 0xFF,
                    (num >> 16) & 0xFF,
                    (num >> 8) & 0xFF,
                    num & 0xFF
            );
        }



    }





    // 2125. number of laser beams in bank
        public int numberOfBeams(String[] bank) {
            int prev = 0, ans = 0;

            for (String s: bank) {
                int count = 0;
                for (int i = 0; i < s.length(); i++)
                    if (s.charAt(i) == '1') {
                        count++;
                    }

                if (count > 0) {
                    ans += prev * count;
                    prev = count;
                }
            }

            return ans;
        }




    // decode the morse code
//    public static String decode(String morseCode) {
//
//        morseCode = morseCode.trim();
//
//        String[] words = morseCode.split(" {3}");
//        StringBuilder decoded = new StringBuilder();
//
//        for (int i = 0; i < words.length; i++) {
//            String[] letters = words[i].split(" ");
//            for (String letter : letters) {
//                if (!letter.isEmpty()) {
//                    decoded.append(MorseCode.get(letter));
//                }
//            }
//            if (i < words.length - 1) {
//                decoded.append(' ');
//            }
//        }
//        return decoded.toString();
//    }



    // rectangle into squares
    public static List<Integer> sqInRect(int lng, int wdth) {

        if (lng == wdth) {
            return null;
        }

        List<Integer> result = new ArrayList<>();

        while (lng > 0 && wdth > 0) {
            if (lng > wdth) {
                result.add(wdth);
                lng -= wdth;
            } else {
                result.add(lng);
                wdth -= lng;
            }
        }


        return result;


    }






// consonant value
    public static int solve(final String s) {



            String vowels = "aeiouAEIOU";
            int max = 0;
            int current = 0;

            for (char c : s.toCharArray()) {
                if (!vowels.contains(String.valueOf(c))) {
                    current += (c - 'a' + 1);
                } else {
                    max = Math.max(max, current);
                    current = 0;
                }
            }




            return Math.max(max, current);

    }






    // count the smiley faces
    public static int countSmileys(List<String> arr) {
        int total = 0;

        for (String face : arr) {
            if (isValidSmiley(face)) {
                total++;
            }
        }
        return total;
    }

    public static boolean isValidSmiley(String s) {


        if (s.length() == 2) {
            return (s.charAt(0) == ':' || s.charAt(0) == ';') &&
                    (s.charAt(1) == ')' || s.charAt(1) == 'D');
        }

        if (s.length() == 3) {
            return (s.charAt(0) == ':' || s.charAt(0) == ';') &&
                    (s.charAt(1) == '-' || s.charAt(1) == '~') &&
                    (s.charAt(2) == ')' || s.charAt(2) == 'D');
        }

        return false;
    }





    // encrypt this!
    public static String encryptThis(String text) {

        if (text == null || text.isEmpty()) return "";

        String[] words = text.split(" ");
        StringBuilder result = new StringBuilder();

        for (String w : words) {
            if (w.length() == 0) {
                continue;
            }

            StringBuilder sb = new StringBuilder();
            sb.append((int) w.charAt(0));

            if (w.length() == 1) {
                result.append(sb).append(" ");
                continue;
            }

            if (w.length() == 2) {
                sb.append(w.charAt(1));
                result.append(sb).append(" ");
                continue;
            }

            char second = w.charAt(1);
            char last = w.charAt(w.length() - 1);

            sb.append(last);
            sb.append(w.substring(2, w.length() - 1));
            sb.append(second);

            result.append(sb).append(" ");
        }

        return result.toString().trim();
    }










    // data reverse
    public static int[] DataReverse(int[] data) {


        int len = data.length;
        int[] result = new int[len];

        int numBytes = len / 8;

        for (int i = 0; i < numBytes; i++) {
            System.arraycopy(data, i * 8, result, (numBytes - 1 - i) * 8, 8);
        }

        return result;


    }



    // camelcase method
    public static String camelCase(String str) {


        String[] temp = str.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String word : temp) {
            if (word.isEmpty()) continue;
            sb.append(Character.toUpperCase(word.charAt(0)));
            if (word.length() > 1) {
                sb.append(word.substring(1));
            }
        }
        return sb.toString();
    }






    // playing with digits
    public static long digPow(int n, int p) {


        String str = Integer.toString(n);
        long total = 0;

        for (int i = 0; i < str.length(); i++) {
            int digit = str.charAt(i) - '0';
            total += Math.pow(digit, p + i);
        }
        if (total % n == 0) {
            return total / n;
        } else {
            return -1;
        }


    }




    // replace with alphabet position
    public String alphabetPosition(String text) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {

            char c = text.charAt(i);

            if (!Character.isLetter(text.charAt(i))) continue;

            int position = Character.toLowerCase(c) - 'a' + 1;

            result.append(position).append(" ");




        }

        if (result.length() > 0) {
            result.setLength(result.length() - 1);
        }

        return result.toString();

    }




    // simple frequency sort
    public static int[] sortByFrequency(int[] array) {

        Map<Integer, Integer> freq = new HashMap<>();

        // Count frequency of each number
        for (int num : array) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Convert array → list for sorting
        List<Integer> list = new ArrayList<>();
        for (int num : array) {
            list.add(num);
        }

        // Sort by:
        // 1) frequency descending
        // 2) value ascending
        Collections.sort(list, (a, b) -> {
            int freqCompare = freq.get(b) - freq.get(a);
            if (freqCompare != 0) {
                return freqCompare; // higher frequency first
            }
            return a - b; // smaller number first
        });

        // Convert back to int[]
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = list.get(i);
        }

        return result;

    }




    // unique substring from joined string
    public int longestSubstring(String a, String b) {

        Set<Character> common = new HashSet<>();
        Set<Character> setA = new HashSet<>();

        for (char c : a.toCharArray()) {
            setA.add(c);
        }

        for (char c : b.toCharArray()) {
            if (setA.contains(c)) {
                common.add(c);
            }
        }

        return Math.max(
                longestWithoutCommon(a + b, common),
                longestWithoutCommon(b + a, common)
        );


    }



    private static int longestWithoutCommon(String s, Set<Character> common) {

        int maxLen = 0;
        int current = 0;

        for (char c : s.toCharArray()) {
            if (common.contains(c)) {
                current = 0;
            } else {
                current++;
                maxLen = Math.max(maxLen, current);
            }
        }
        return maxLen;

    }





    // a rule of divisibility by 13
    public static long thirt(long n) {



        int[] pattern = {1, 10, 9, 12, 3, 4};

        long prev = -1;

        while (prev != n) {

            prev = n;

            long sum = 0;
            String s = new StringBuilder(Long.toString(n)).reverse().toString();

            for (int i = 0; i < s.length(); i++) {
                int digit = s.charAt(i) - '0';
                sum += digit * pattern[i % pattern.length];
            }

            n = sum;

        }
        return n;

    }




    // pizza pieces
    public static int maxPizza(int cuts) {

        if (cuts < 0) return -1;

        return (cuts * (cuts + 1)) / 2 + 1;





    }






























































































}
