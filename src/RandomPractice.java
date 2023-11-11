import java.util.*;

public class RandomPractice {

    /*
    Problem:
        Given a list of integers, write a program to classify each number into one of the following categories:

        Positive Even: Even numbers greater than zero.
        Positive Odd: Odd numbers greater than zero.
        Negative Even: Even numbers less than zero.
        Negative Odd: Odd numbers less than zero.
        Zero: The number zero.
        Your task is to implement a function called numberClassification that takes a list of integers as input and returns a map that contains the count of each category. The map should have the categories as keys and the count of numbers in each category as values.
*/

    // get a list in method header
    // create variables to count how many positive even, positive odd, negative even, negative odd, zeros
    // walk through the data
    // conditional statements to check each number
    // create a map where key is string and value is count, put values into map
    // return map


    public Map<String, Integer> numberClassification(List<Integer> numbers) {
        // variables
        int positiveEven = 0;
        int positiveOdd = 0;
        int negativeEven = 0;
        int negativeOdd = 0;
        int zero = 0;


        for (int i = 0; i < numbers.size(); i++) {
            // create temp variable to always compare
            int temp = numbers.get(i);
            if (temp == 0) {
                zero++;
            } else if (temp > 0) {
                if (temp % 2 == 0) {
                    positiveEven++;
                } else {
                    positiveOdd++;
                }
            } else { // must be odd numbers
                if (temp % 2 == 0) {
                    negativeEven++;
                } else {
                    negativeOdd++;
                }
            }

        }
        Map<String, Integer> results = new HashMap<>();
        if (zero > 0) {
            results.put("zero", zero);
        }
        if (positiveEven > 0) {
            results.put("positiveEven", positiveEven);
        }
        if (positiveOdd > 0) {
            results.put("positiveOdd", positiveOdd);
        }
        if (negativeEven > 0) {
            results.put("negativeEven", negativeEven);
        }
        if (negativeOdd > 0) {
            results.put("negativeOdd", negativeOdd);
        }
        return results;

    }


    /*

    Problem:
        You are building a password strength checker for a web application. The password criteria are as follows:

        The password must contain at least 8 characters.
        The password must contain at least one uppercase letter (A-Z).
        The password must contain at least one lowercase letter (a-z).
        The password must contain at least one digit (0-9).
        The password must contain at least one special character (e.g., !, @, #, $, %, ^, &, *).
        Your task is to implement a function called isStrongPassword that takes a password as input and returns a boolean value indicating whether the password meets the above criteria or not.


        System.out.println(isStrongPassword("Abcd1234@"));  // Output: true
        System.out.println(isStrongPassword("helloWorld")); // Output: false
        System.out.println(isStrongPassword("P@ssw0rd"));   // Output: true
        System.out.println(isStrongPassword("12!45^67"));  // Output: false
        System.out.println(isStrongPassword("Abc1234"))

*/


    public boolean isStrongPassword(String password) {
        // check if length >= 0 characters
        // if length < 0 -> return false;
        // upper, lower, digit, special flags -> set to false
        // loop through string and check flags

        // create string for special
        String special = "!@#$%&*";

        // return false is length < 8
        if (password.length() < 8) {
            return false;
        }

        // set flags
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        char[] chars = password.toCharArray();
        // loop through string
        for (char index : chars) {
            if (Character.isUpperCase(index)) {
                hasUpper = true;
            }
            if (Character.isLowerCase(index)) {
                hasLower = true;
            }
            if (Character.isDigit(index)) {
                hasDigit = true;
            }

            // how to know if special character?
            // this method may cause errors
//            if (!Character.isWhitespace(index)) {
//                hasSpecial = true;
//            }

            if (special.contains(Character.toString(index))) {
                hasSpecial = true;
            }

        }

        return hasUpper && hasLower && hasDigit && hasSpecial;

    }



    /*

    Problem Description:

        Write a Java function called diamondPattern that takes an odd integer n as input and prints a diamond pattern made of asterisks ('*') with a width of n characters.

        Example:
        diamond(5) =>
             *
            ***
           *****
            ***
             *

*/

    public void diamondPattern(int num) {

        // loop for the top half
        // print n *s in the middle
        // loop for the bottom half


        int midway = num / 2;
        int spaces = midway;
        int stars = 1;
        for (int i = 0; i < midway; i++) {
            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < stars; k++) {
                System.out.println("*");
            }
            spaces--;
            stars++;
        }
        for (int i = 0; i < num; i++) {
            System.out.println("*");
        }
        System.out.println();
        stars -= 2;
        spaces = 1;
        for (int i = 0; i < midway; i++) {
            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < stars; k++) {
                System.out.println("*");
            }
            spaces++;
            stars -= 2;
            System.out.println();
        }

    }

    //square every digit in nums
    // ex -> 765 should return 493625
    public int squareDigits(int n) {
        String s = n + "";
        String[] digits = s.split("");
        String output = "";

        for (String str : digits) {
            int i = Integer.parseInt(str);
            output += i * i;
        }

        return Integer.parseInt(output);
    }


//    There are n kids with candies. You are given an integer array candies, where each candies[i] represents the number of candies the ith kid has, and an integer extraCandies, denoting the number of extra candies that you have.
//    Return a boolean array result of length n, where result[i] is true if, after giving the ith kid all the extraCandies, they will have the greatest number of candies among all the kids, or false otherwise.
//    Note that multiple kids can have the greatest number of candies.

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int len = candies.length;
        int maxCandy = 0;
        for (int i = 0; i < len; i++) {
            maxCandy = Math.max(maxCandy, candies[i]);
        }
        for (int j = 0; j < len; j++) {
            if ((candies[j] + extraCandies) >= maxCandy) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }

//    You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
//    Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int i = 0;

        while (i < flowerbed.length) {
            if (flowerbed[i] == 0) {
                //Check if the current position is empty and its adjacent positions are also empty.
                boolean canPlant = ((i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0));
                if (canPlant) {
                    flowerbed[i] = 1; // plant flower at current position
                    count++; // increment the count
                }
            }
            i++;
        }
        return count >= n;
    }


//        Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
//        A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters
//        without disturbing the relative positions of the remaining characters.
//        (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

    public boolean isSubsequence(String s, String t) {
        int sIndex = 0;
        int tIndex = 0;

        while (sIndex < s.length() && tIndex < t.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
            }
            tIndex++;
        }

          return s.length() == sIndex;

    }


    // Determine if an integer is even or odd
    // write a method called evenOdd that takes in an integer
    // return true if the integer is even
    // Otherwise return false
    public boolean evenOdd(int n) {
        // solution one
//        if (n % 2 == 0) {
//            return true;
//        }
//        return false;

        // better solution
        return n % 2 == 0;
    }



    // given an array of integers, determine if each value is even or odd
    // write a method called evenOddArray that take in an integer array.
    // return an array of boolean values where true if n is even otherwise false
    public boolean[] evenOddArray(int[] nums) {
        boolean[] results = new boolean[nums.length];

        for (int i = 0; i < nums.length; i++) {
            // solution one
//            if (nums[i] % 2 == 0) {
//                results[i] = true;
//            } else {
//                results[i] = false;
//            }
            results[i] = (nums[i] % 2 == 0);
        }
        return results;
    }


    // get middle character
    // given a word, return the middle character
    // if the word's length is odd return the middle character
    // if the word's length is even return the middle two character

    public String getMiddle(String word) {
        if (word.length() % 2 == 0) {
            return word.substring(word.length() / 2 - 1, word.length() / 2 + 1);
        }
        return word.substring(word.length() / 2, word.length() / 2 + 1);
    }



    // create an array and return true if there is a 1 followed by a 2 somewhere in the array
    public boolean hasTwelve(int[] nums) {
        boolean hasOne = false;
        for (int i = 0; i < nums.length; i++) {
          if (nums[i] == 1) {
              // keep track that a 1 was found
              hasOne = true;
          }
          if (nums[i] == 2 && hasOne) {
              return true;
          }
        }
        return false;
    }


    // write method findAgeByName - takes in a Map of <String, Integer> search for age corresponding to the name
    // if the name is found return the name
    public int findAgeByName(Map<String, Integer> nums, String name) {

        for (Map.Entry<String, Integer> entry : nums.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(name)) {
                return entry.getValue();
            }
        }
        // another possible solution??
//       if (nums.containsKey(name)) {
//            return nums.get(name);
//        }
        return -1;
    }


    // calculate average from a list of ints
    public double calculateAverage(List<Integer> nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        return (double) total / nums.size();
    }



    // write method that modifies a map if "a" and "b" keys are present
    // add key "ab" and their values together
    // else return the original map
    public Map<String, String> mapAB(Map<String, String> map) {
        String ab = "";

        if (map.containsKey("a") && map.containsKey("b")) {
            ab = map.get("a") + map.get("b");
            map.put("ab", ab);
        }


        return map;
    }


    // remove duplicates

    public List<Integer> removeDuplicates(List<Integer> nums) {
        List<Integer> results = new ArrayList<>();
        // loop through the list and check is num is already in the list
        // if not add it
        for (Integer index : nums) {
            if (!results.contains(index)) {
                results.add(index);
            }
        }
        return results;
    }


    // reverse vowels in sentence
    // "hello" should return "holle"

    public String reverseVowels(String s) {

        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

        StringBuilder vowelChars = new StringBuilder();

        // extract all vowels from the input String
        for (char c : s.toCharArray()) {
            if (isVowel(c, vowels)) {
                vowelChars.append(c);
            }
        }


        // reverse the vowel characters
        vowelChars.reverse();

        // replace the original vowels in the string with the reversed vowels
        StringBuilder result = new StringBuilder();
        int index = 0;

        for (char c : s.toCharArray()) {
            if (isVowel(c, vowels)) {
                result.append(vowelChars.charAt(index));
                index++;
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    private boolean isVowel(char c, char[] vowels) {
        for (char vowel : vowels) {
            if (c == vowel) {
                return true;
            }
        }
        return false;
    }


    // what is a palimdrome?
    // palindrome is the same both forwards and backwards ie "racecar"
    public boolean palindrome(String str) {

//         str.equals(new StringBuffer(str).reverse().toString()) ? "Yes" : "No");

        // compare first char with last with two pointers;
        int front = 0;
        int back = str.length() - 1;

        while(front < back) {
            if (str.charAt(front) != str.charAt(back)) {
                return false;
            }
            front++;
            back--;
        }
        return true;


    }


    // count vowels

    public int countVowels(String str) {
        // want to make account for lower and upper
        String total = "aeiouAEIOU";
        // our return total
        int count = 0;

        // instead of two loops just compare total string to str at i
        for (int i = 0; i < str.length(); i++) {
            if (total.contains(String.valueOf(str.charAt(i)))) {
                count++;
            }
        }
        return count;
    }


    // reverse a String
    public String reverseString(String str) {

        String result = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }

        return result;

    }


    // title case -> capitalize first letter of every word
    public String titleCase(String str) {

        String[] words = str.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            // skip empty words
            if (!word.isEmpty()) {
                String cappedWord = word.substring(0, 1).toUpperCase() + word.substring(1);
                result.append(cappedWord).append(" ");
            }
        }
        // trim trailing white space
        return result.toString().trim();

    }


    // Multiples of 3 or 5 up to 1000
    public int multiplesOfThreeOrFive() {
        int total = 0;

        for (int i = 0; i < 1000; i++) {

            if (i % 3 == 0 || i % 5 == 0) {
                total += i;
            }


        }
        return total;
    }


    // Even fibonacci numbers
    public long evenFibonacci() {

        long total = 0;
        long a = 1;
        long b = 1;

        while (a <= 4000000) {
            if (a % 2 == 0) {
                total += a;
            }

            long temp = a + b;
            a = b;
            b = temp;

        }
        return total;
    }


    // largest prime factor of 600851475143
    public long largestPrimeFactor(long number) {

        long largestPrime = 0;

        // check for evens
        while (number % 2 == 0) {
            largestPrime = 2;
            number /= 2;
        }


        // check for odd
        for (long i = 3; i <= Math.sqrt(number); i+=2) {
            while(number % i == 0) {
                largestPrime = i;
                number /= i;
            }
        }

        if (number > 1) {
            largestPrime = number;
        }

        return largestPrime;

    }


    // largest palindrome product from two three digit numbers
    public int largestPalindromeProduct() {

        int largestPalindrome = 0;

        for (int i = 999; i >= 100; i--) {
            for (int j = i; j >= 100; j--) {
                int product = i * j;
                if (isPalindrome(product) && product > largestPalindrome) {
                    largestPalindrome = product;
                }
            }
        }
    return largestPalindrome;

    }


    public static boolean isPalindrome(int number) {
        int reversed = 0;
        int original = number;

        while(number > 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }
        return original == reversed;
    }


    // smallest multiple
    public int smallestMultiple() {
        return 0;
    }


    // calculateAverageTwo
    public double calculateAverageTwo(List<Integer> nums) {

        int total = 0;

        for (int i = 0; i < nums.size(); i++) {
            total += nums.get(i);
        }
        return (double) total / nums.size();

    }




    // mapAb two
    public Map<String, String> mapAbAgain(Map<String, String> map) {

        String ab = "";

        if (map.containsKey("a") && map.containsKey("b")) {
            ab = map.get("a") + map.get("b");
            map.put("ab", ab);
        }
        return map;


    }


    // wordCount
    public Map<String, Integer> wordCount(String[] strings) {

        Map<String, Integer> results = new HashMap<>();

        for (String str : strings) {

            if (results.containsKey(str)) {
                results.put(str, results.get(str) + 1);
            } else {
                results.put(str, 1);
            }

        }


        return results;
    }



    // validParens
    public boolean validParens(String string) {

        Stack<Character> stack = new Stack<>();


        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);

            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false; // unmatched closing parenthesis
                }
            }



        }
        return stack.isEmpty();
    }



    // removeDuplicates
    public List<Integer> removeDuplicatesTwo(List<Integer> nums) {

        Set<Integer> unique = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (Integer num : nums) {
            if (unique.add(num)) {
                result.add(num);
            }
        }

        return result;
    }



    /** REPEATED PRACTICE TO TEST CONCEPTS ARE BEING RETAINED **/

    // countEvens
    public int countEvens(int[] nums) {
        int total = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                total++;
            }
        }

        return total;
    }



    // bigDiff
    public int bigDiff(int[] nums) {

        int smallest = nums[0];
        int largest = nums[0];

        for (int i = 0; i < nums.length; i++) {
            smallest = Math.min(smallest, nums[i]);
            largest = Math.max(largest, nums[i]);
        }
        return largest - smallest;
    }


























}