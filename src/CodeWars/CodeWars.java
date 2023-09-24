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




}
