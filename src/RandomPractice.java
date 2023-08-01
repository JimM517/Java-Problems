import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        stars-= 2;
        spaces = 1;
        for (int i = 0; i < midway; i++) {
            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < stars; k++) {
                System.out.println("*");
            }
            spaces++;
            stars-= 2;
            System.out.println();
        }

    }



}
