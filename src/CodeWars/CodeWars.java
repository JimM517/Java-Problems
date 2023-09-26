package CodeWars;

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












}
