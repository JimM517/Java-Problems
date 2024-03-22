import java.io.File;
import java.io.FileNotFoundException;
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


    // centeredAverage
    public int centeredAverage(int[] nums) {

        int max = nums[0];
        int min = nums[0];

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            // get sum first
            sum += nums[i];

            // find one instance of largest and smallest values
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        // return the sum excluding the one instance of largest and smallest values
        // nums.length - 2 because we removed the two values of max and min
        return (sum - max - min) / (nums.length - 2);

    }


    // sum13
    public int sum13(int[] nums) {

        int total = 0;
        int index = 0;

        while (index < nums.length) {
            if (nums[index] == 13) {
                // we are adding two to the index here because 13 and the number right after need to be skipped
                index += 2;
            } else {
                total += nums[index];
            }
            index++;
        }

        return total;

    }


    // sum67
    public int sum67(int[] nums) {

        int total = 0;

        boolean inRange = false;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 6) {
                inRange = true;
            } else if (inRange && nums[i] == 7) {
                inRange = false;
            } else {
                total += nums[i];
            }

        }

        return total;

    }


    // has22
    public boolean has22(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 2 && nums[i + 1] == 2) {
                return true;
            }
        }


        return false;
    }



    // lucky13
    public boolean lucky13(int[] nums) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1 || nums[i] == 3) {
                count++;
            }
        }

        return count <= 0;
    }


    // sum28
    public boolean sum28(int[] nums) {

        int twoEight = 0;

        for (int num : nums) {
            if (num == 2) {
                twoEight += num;
            }
        }

        return twoEight == 8;

    }


    // more14
    public boolean more14(int[] nums) {

        int oneCount = 0;
        int fourCount = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 1) {
                oneCount++;
            }

            if (nums[i] == 4) {
                fourCount++;
            }


        }

        return oneCount > fourCount;


    }



    // fizzArray
    public int[] fizzArray(int n) {

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = i;
        }

        return result;
    }


    // only14
    public boolean only14(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 1 && nums[i] != 4) {
                return false;
            }
        }

        return true;

    }


    // fizzArray2
    public String[] fizzArray2(int n) {

        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            result[i] = String.valueOf(i);
        }

        return result;
    }


    // no14
    public boolean no14(int[] nums) {
        boolean hasOne = false;
        boolean hasFour = false;

        for (int num : nums) {
            if (num == 1) {
                hasOne = true;
            }
            if (num == 4) {
                hasFour = true;
            }
        }


        return !(hasOne && hasFour);

    }



    // isEverywhere
    public boolean isEverywhere(int[] nums, int val) {

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != val && nums[i + 1] != val) {
                return false;
            }
        }

        return true;

    }


    // either24
    public boolean either24(int[] nums) {

        boolean found22 = false;
        boolean found44 = false;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 2 && nums[i + 1] == 2) {
                found22 = true;
            }
            if (nums[i] == 4 && nums[i + 1] == 4) {
                found44 = true;
            }
        }


//        return (found22 || found44) && !(found22 && found44);

        return found22 != found44;
    }


    // matchUp
    public int matchUp(int[] nums1, int[] nums2) {
        int count = 0;

        for (int i = 0; i < nums1.length && i < nums2.length; i++) {


            int diff = Math.abs(nums1[i] - nums2[i]);

            if (diff <= 2 && diff > 0) {
                count++;
            }


        }


        return count;

    }


    // has77
    public boolean has77(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 7 && nums[i + 1] == 7) {
                return true;
            } else if (i < nums.length - 2 && nums[i] == 7 && nums[i + 2] == 7) {
                return true;
            }
        }

        return false;
    }


    // has12
    public boolean has12(int[] nums) {

        boolean hasOne = false;

        for (int num : nums) {
            if (num == 1) {
                hasOne = true;
            }
            if (hasOne && num == 2) {
                return true;
            }
        }

        return false;

    }



    // modThree
    public boolean modThree(int[] nums) {


        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] % 2 == 0) {
                if (nums[i + 1] % 2 == 0 && nums[i + 2] % 2 == 0) {
                    return true;
                }
            }
            if (nums[i] % 2 == 1) {
                if (nums[i + 1] % 2 == 1 && nums[i + 2] % 2 == 1) {
                    return true;
                }
            }
        }

        return false;



    }


    // haveThree
    public boolean haveThree(int[] nums) {

        int threeCount = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 3) {
                threeCount++;
                if (i > 0 && nums[i - 1] == 3) {
                    return false;
                }
            }



        }

        return threeCount == 3;


    }




    // twoTwo
    public boolean twoTwo(int[] nums) {
        // return true if every 2 that appears is next to another 2


        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 2) {
                if (i > 0 && nums[i - 1] == 2) {
                    continue;
                }
                if (i < nums.length - 1 && nums[i + 1] == 2) {
                    continue;
                }
                return false;
            }
        }
        return true;

    }


    // scoresIncreasing
    public boolean scoresIncreasing(int[] scores) {

        for (int i = 0; i < scores.length - 1; i++) {
            if (scores[i] > scores[i + 1]) {
                return false;
            }
        }


        return true;

    }


    // scores100
    public boolean scores100(int[] scores) {

        for (int i = 0; i < scores.length - 1; i++) {
            if (scores[i] == 100 && scores[i + 1] == 100) {
                return true;
            }
        }

        return false;

    }


    // sameEnds
    public boolean sameEnds(int[] nums, int len) {

        int length = nums.length;

        if (len < 0 || len > nums.length) {
            return false;
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] != nums[length - len + i]) {
                return false;
            }
        }


        return true;

    }



    // tripleUp

    public boolean tripleUp(int[] nums) {

        for (int i = 0; i < nums.length - 2; i++) {

            if (nums[i] + 1 == nums[i + 1] && nums[i + 1] + 1 == nums[i + 2]) {
                return true;
            }


        }

        return false;

    }



    // twoSum
    public int[] twoSum(int[] nums, int target) {

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



    //fizzArray3
    public int[] fizzArray3(int start, int end) {

        int len = end - start;

        int[] result = new int[len];

        int count = 0;

        while (start < end) {
            result[count] = start;
            count++;
            start++;
        }

        return result;
    }



    // shiftLeft
    public int[] shiftLeft(int[] nums) {
        // check length
        if (nums.length <= 1) {
            return nums;
        }

        // capturing first element
        int firstEl = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {

            nums[i] = nums[i + 1];


        }

        // after everything is shifted, we add that first element now at the end
        nums[nums.length - 1] = firstEl;

        return nums;
    }



    // fibonacci using recursion
    public int fibonacci(int n) {

            if (n == 0) {
                return 0;
            } else if (n == 1) {
                return 1;
            }


        return  fibonacci(n - 1) + fibonacci(n - 2);

    }


    // tenRun

    public int[] tenRun(int[] nums) {

        int[] result = new int[nums.length];

        // keep track of 10 value
        boolean inRange = false;
        // store ten value to set later
        int tenValue = 0;


        for (int i = 0; i < nums.length; i++) {

            if (nums[i] % 10 == 0) {
                inRange = true;
                tenValue = nums[i];
            }

            if (inRange) {
                result[i] = tenValue;
            } else {
                result[i] = nums[i];
            }




        }


        return result;

    }



    // pre4

    public int[] pre4(int[] nums) {


        int length = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 4) {
                length = i;
                break;
            }
        }


        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            result[i] = nums[i];
        }

        return result;


    }


    // post4
    public int[] post4(int[] nums) {


        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 4) {
                int[] result = new int[nums.length - i - 1];

                for (int j = 0; j < result.length; j++) {
                    result[j] = nums[i + j + 1];
                }
                return result;
            }
        }



        return null;

    }


    // scoresAverage
    public int scoresAverage(int[] scores) {

        int firstHalf = average(scores, 0, scores.length / 2);
        int secondHalf = average(scores, scores.length / 2, scores.length);

        if (firstHalf > secondHalf) {
            return firstHalf;
        } else {
            return secondHalf;
        }



    }


    // helper
    private int average(int[] scores, int start, int end) {

        int sum = 0;

        for (int i = start; i < end; i++) {
            sum += scores[i];
        }
        // get the number of elements counted to get average
        int count = end - start;
        return sum / count;

    }

    // wordsCount

    public int wordsCount(String[] words, int len) {

        int total = 0;

        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == len) {
                total++;
            }
        }

        return total;

    }


    // countYZ
    public int countYZ(String str) {
//
//        int count = 0;
//        String[] splitWord = str.split("\\W ");
//
//        for (int i = 0; i < splitWord.length; i++) {
//            String lowerCase = splitWord[i].toLowerCase();
//         if (lowerCase.endsWith("y") || lowerCase.endsWith("z")) {
//                count++;
//            }
//        }
//
//        return count;

        int len = str.length();
        int count = 0;
        str = str.toLowerCase();

        for (int i = 0; i < len; i++) {

            if (str.charAt(i) == 'y' || str.charAt(i) == 'z') {
                if (i < len-1 && !Character.isLetter(str.charAt(i+1)))
                    count++;
                else if (i == len-1)
                    count++;
            }
        }
        return count;
    }



    //withoutString
    public String withoutString(String base, String remove) {

        int baseLength = base.length();
        int removeLength = remove.length();

        String lowerBase = base.toLowerCase();
        String lowerRemove = remove.toLowerCase();

        String result = "";


        for (int i = 0; i < baseLength; i++) {
            if (i <= baseLength - removeLength) {
                String temp = lowerBase.substring(i, i + removeLength);
                if (!temp.equals(lowerRemove)) {
                    result += base.substring(i, i + 1);
                } else {
                    i += removeLength - 1;
                }
            } else {
                String tempTwo = lowerBase.substring(i, i + 1);
                if (!tempTwo.equals(lowerRemove)) {
                    result += base.substring(i, i + 1);
                }
            }
        }

        return result;

    }


    // equalIsNot
    public boolean equalIsNot(String str) {

        int countIs = 0;
        int countNot = 0;

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.regionMatches(i, "is", 0, 2)) {
                countIs++;
            }
            if (str.regionMatches(i, "not", 0, 3)) {
                countNot++;
            }
        }
        return countIs == countNot;
    }


    // mapBully

    public Map<String, String> mapBully(Map<String, String> map) {

        if (map.containsKey("a")) {
            map.put("b", map.get("a"));
            map.put("a", "");
        }

        return map;

    }



    // mapShare
    public Map<String, String> mapShare(Map<String, String> map) {

        if (map.containsKey("a")) {
            map.put("b", map.get("a"));

        }

        map.remove("c");

        return map;
    }




    // mapAB
    public Map<String, String> mapABAgain(Map<String, String> map) {

        String ab = map.get("a") + map.get("b");

        if (map.containsKey("a") && map.containsKey("b")) {
            map.put("ab", ab);
        }


        return map;

    }


    // topping 1
    public Map<String, String> topping1(Map<String, String> map) {

        if (map.containsKey("ice cream")) {
            map.put("ice cream", "cherry");
        }

        map.put("bread", "butter");

        return map;

    }



    // topping 2
    public Map<String, String> topping2(Map<String, String> map) {

        if (map.containsKey("ice cream")) {

            map.put("yogurt", map.get("ice cream"));
        }
        if (map.containsKey("spinach")) {
            map.put("spinach", "nuts");
        }


        return map;

    }


    // topping 3
    public Map<String, String> topping3(Map<String, String> map) {

        if (map.containsKey("potato")) {
            map.put("fries", map.get("potato"));
        }

        if (map.containsKey("salad")) {
            map.put("spinach", map.get("salad"));
        }

        return map;
    }


    // mapAB2
    public Map<String, String> mapAB2(Map<String, String> map) {

        String stringA = map.get("a");
        String stringB = map.get("b");

        if (map.containsKey("a") && map.containsKey("b")) {
            if (stringA.equals(stringB)) {
                map.remove("a");
                map.remove("b");
            }
        }


        return map;
    }


    // mapAB3
    public Map<String, String> mapAB3(Map<String, String> map) {

        if (map.containsKey("a") && !map.containsKey("b")) {
            map.put("b", map.get("a"));
        }
        if (map.containsKey("b") && !map.containsKey("a")) {
            map.put("a", map.get("b"));
        }
        return map;
    }


    // mapAB4
    public Map<String, String> mapAB4(Map<String, String> map) {

        if (map.containsKey("a") && map.containsKey("b")) {
            int aLen = map.get("a").length();
            int bLen = map.get("b").length();

            if (aLen > bLen) {
                map.put("c", map.get("a"));
            } else if (bLen > aLen) {
                map.put("c", map.get("b"));
            } else {
                map.put("a", "");
                map.put("b", "");
            }
        }

        return map;


    }



    /** Random interview practice **/

    // Given two words s and t, find subsequence t of s and remove words
    // return s
    public String removeWords(String input, String search) {

        // split each string into arrays, one for input and one for search
        String[] inputArr = input.split("");
        String[] searchArr = search.split("");

        // create string builder instead of concatenation
        StringBuilder result = new StringBuilder();

        // loop through input array
        for (String inputWord : inputArr) {
            // create boolean to keep track of found word
            boolean found = false;
            // loop through search array
            for (String searchWord : searchArr) {
                // if the word is found in input, change found to true break out of the loop
                if (inputWord.equals(searchWord)) {
                    found = true;
                    break;
                }

            }
            // if the word is not found, add the word
            if (!found) {
                result.append(inputWord);
            }
        }

        return result.toString();

    }


    // another solution for removeWords
    public String removeWordsTwo(String input, String search) {

        String[] inputArr = input.split(" ");
        String[] searchArr = search.split(" ");


        for (String word : searchArr) {
            input = input.replaceFirst(word, "");
        }
        // replace double spaces with single space
        input = input.replace("  ", " ");

        return input;

    }


 /** Example File Reader problem  **/

 public void readFile()  {

     File inputFile = new File("input.txt");

     List<Integer> result = new ArrayList<>();

     try {
         Scanner input = new Scanner(inputFile);
         while(input.hasNext()) {
             result.add(input.nextInt());
         }


         int num1 = 0;
         int num2 = 0;

         for (int i = 0; i < result.size(); i++) {
             num1 = result.get(i);
             for (int j = i + 1; j < result.size(); j++) {
                 num2 = result.get(j);

                 if (num1 + num2 == 2020) {
                     int answer = num1 * num2;
                     System.out.println(answer);
                 }

             }
         }



     } catch (FileNotFoundException e) {
         throw new RuntimeException(e);
     }



 }



    /** Another solution using recursion **/

    public void readAnotherFile() {

        File inputFile = new File("input.txt");

        List<Integer> list = new ArrayList<>();

        try {
            Scanner input = new Scanner(inputFile);
            while(input.hasNext()) {
                list.add(input.nextInt());
            }
            List<Integer> result = findNumbers(list, 2020, 0);
            int num1 = result.get(0);
            int num2 = result.get(1);
            System.out.println(num1 + " " + num2);
            System.out.println(num1 + num2);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }




    private static List<Integer> findNumbers(List<Integer> arr, int target, int currentIndex) {
        if (currentIndex >= arr.size()) {
            return null;  // base case
        }

        int currentNumber = arr.get(currentIndex);
        int complement = target - currentNumber;
        for (int i = currentIndex + 1; i < arr.size(); i++) {

            if (arr.get(i) == complement) {
                return Arrays.asList(new Integer[] {currentNumber, complement});
            }

        }

        return findNumbers(arr, target, currentIndex + 1); // call method moving out our index

    }



    // search for number
    public boolean searchForNumber(int[] arr, int target) {

        for (int num : arr) {
            if (num == target) {
                return true;
            }
        }

        return false;

    }


    // has one two
    public boolean hasOneTwo(int[] arr) {
        boolean foundOne = false;

        for (int num : arr) {
            if (num == 1) {
                foundOne = true;
            }
            if (num == 2 && foundOne) {
                return true;
            }
        }


        return false;

    }




    // highest number
    public int highestNum(int[] arr) {

        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int highestCount = 0;
        int highestNumber = 0;

        Set<Integer> set = countMap.keySet();

        for (int key : set) {
            if (countMap.get(key) > highestNumber) {
                highestCount = countMap.get(key);
                highestNumber = key;
            } else if (countMap.get(key) == highestCount && key > highestNumber) {
                highestNumber = key;
            }
        }


        return highestNumber;

    }


    /** Just for practice, already solved this**/
    // 20. Valid Parentheses
    public boolean isValidParen(String s) {

        Stack<Character> checkParen = new Stack<>();


        for (char c : s.toCharArray()) {

            if (c == '(' || c == '{' || c == '[') {
                checkParen.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (checkParen.isEmpty()) {
                    return false;
                }


                char top = checkParen.pop();
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return false;
                }


            }



        }


        return checkParen.isEmpty() ? true : false;


    }


    /** Just for practice **/
    // 53. Maximum Sub-array

    public int maxSubArray(int[] nums) {

        // want to find subarray with the largest total

        int start = Integer.MIN_VALUE;
        int end = 0;

        for (int i = 0; i < nums.length; i++) {

            end += nums[i];

            if (start < end) {
                start = end;
            }
            if (end < 0) {
                end = 0;
            }


        }


        return start;



    }



//    private static List<Integer> sortBySetBits(List<Integer> numbers) {
//        Collections.sort(numbers, Comparator
//                .comparingInt(Integer::bitCount)
//                .thenComparingInt(n -> n));
//        return numbers;
//    }



    /** Two interview questions I had **/

   // sort list of integers by the number of 1s in their binary representation

    public List<Integer> sortBinary(List<Integer> elements) {

        return sortBySetBits(elements);
    }


    private static List<Integer> sortBySetBits(List<Integer> numbers) {

        Collections.sort(numbers, Comparator
                // first compare numbers based on count of set bits
                .comparingInt(Integer::bitCount)
                // in case of the same number of 1s, compare based on int value
                .thenComparingInt(n -> n));
        return numbers;
    }



    // calculate subarray sums
    public long calculateSubarraySums(List<Integer> numbers) {

        int n = numbers.size();
        long totalSum = 0;

        // calculate prefix sums
        long[] prefixSums = new long[n + 1];

        for (int i = 0; i < n; i++) {

            prefixSums[i + 1] = prefixSums[i] + numbers.get(i);

        }


        // calculate the sum of all subarrays
        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) {
                totalSum += prefixSums[j + 1] - prefixSums[i];
            }


        }

        return totalSum;


    }





    /** Sliding window example **/

    // find max subarray of length k
    public int maxSumSubarray(int[] nums, int k) {

        int n = nums.length;
        int sum = 0;

        // calculate the initial sum of the first window of size k
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;

        // slide the window through the array
        for (int i = k; i < n; i++) {

            // add the next element to the sum
            sum += nums[i];

            // subtract the leftmost element that is no longer in the window
            sum -= nums[i - k];

            // update the maximum sum
            maxSum = Math.max(maxSum, sum);

        }

        return maxSum;
    }






    // 1768. Merge strings alternately
    public String mergeAlternately(String word1, String word2) {

        int i = 0;

        int n = word1.length();
        int m = word2.length();

        StringBuilder sb = new StringBuilder();

        while (i < n && i < m) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
            i++;
        }

        while (i < n) {
            sb.append(word1.charAt(i));
            i++;
        }

        while (i < m) {
            sb.append(word2.charAt(i));
            i++;
        }


        return sb.toString();



    }





    // 1071. greatest common divisor of strings
    public String gcdOfStrings(String str1, String str2) {

      if (!(str1 + str2).equals(str2 + str1)) {
          return "";
      }
      int gdcLen = gcd(str1.length(), str2.length());

      return str1.substring(0, gdcLen);

    }


    private int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x & y);
        }
    }






    public String reverseVowelsAgain(String s) {

      char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

    StringBuilder vChars = new StringBuilder();

      for (char c : s.toCharArray()) {
          if (isVowel(c, vowels)) {
              vChars.append(c);
          }
      }


      vChars.reverse();


      StringBuilder sb = new StringBuilder();
      int index = 0;

      for (char c : s.toCharArray()) {
          if (isVowel(c, vowels)) {
              sb.append(vChars.charAt(index));
              index++;
          } else {
              sb.append(c);
          }
      }

    return sb.toString();

    }



    private boolean isVowelsss(char c, char[] vowels) {
        for (char vowel : vowels) {
            if (c == vowel) {
                return true;
            }
        }
        return false;
    }








}