package CodeWars;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CodeWars {


    // Sum a list but ignore any duplicates

    // ***** THIS SOLUTION DOESN'T WORK YET *****
    public int sumNoDuplicates(int[] arr) {
        int total = 0;

        // use a set so that there can be no duplicates
        Set<Integer> nums = new HashSet<>();

        for (int num : arr) {
            if (!nums.contains(num)) {
                total += num;
                nums.add(num);
            }
        }
        return total;
    }



    // Find the stray number
    // [1, 1, 2] ==> 2

    // ***** THIS SOLUTION DOESN'T WORK YET *****
    public int stray(int[] numbers) {
        int start = 0;
        int end = numbers.length - 1;

        int stray = 0;
        while(start <= end) {
            if (numbers[start] != numbers[end]) {
                stray = (numbers[start] == numbers[start + 1]) ? numbers[end] : numbers[start];
                break;
            }
            start++;
            end--;
        }
        return stray;
    }


    // String ends with??
    public boolean solution(String str, String ending) {
        return str.endsWith(ending);
    }


    // Minimum steps
    public int minimumSteps(int[] numbers, int k) {

        Arrays.sort(numbers);
        int sum = 0;
        int i = 0;

        while (sum < k) {
            sum += numbers[i];
            i++;
        }

        return i - 1;


    }

    // Even or Odd
    public String evenOrOdd(int number) {
        return number % 2 == 0 ? "Even" : "Odd";
    }


    // Number star ladder
    // *** THIS DOESN"T WORK YET ***
    public String pattern(int n) {

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            sb.append("1");
            for (int j = 1; j <= i; j++) {
                sb.append("*");
            }
            sb.append(i);
            if (i != n) {
                sb.append("\n");
            }
        }

        return sb.toString();

    }


    // nickname generator
    public String nickname(String name) {

        String vowels = "aeiouAEIOU";

        if (name.length() < 4) {
            return "Error: Name too short";
        }

        char thirdLetter = name.charAt(2);

        if (vowels.contains(String.valueOf(thirdLetter))) {
            return name.substring(0, 4);
        } else {
            return name.substring(0, 3);
        }
    }










}
