package ReviewProblems.BackTracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BackTracking {


    /** Backtracking problems from leet code 150 **/



    // 17. letter combinations of a phone number
    public List<String> letterCombination(String digits) {

        if (digits.isEmpty()) {
            return Collections.emptyList();
        }

        String[] phoneNums = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        List<String> result = new ArrayList<>();

        stringBT("", digits, phoneNums, result);

        return result;


    }


    private void stringBT(String combination, String nextDigits, String[] phoneNums, List<String> result) {

        if (nextDigits.isEmpty()) {
            result.add(combination);
        } else {
            String letters = phoneNums[nextDigits.charAt(0) - '2'];
            for (char letter : letters.toCharArray()) {
                stringBT(combination + letter, nextDigits.substring(1), phoneNums, result);
            }
        }
    }












}
