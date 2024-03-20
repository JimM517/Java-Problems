package ReviewProblems.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
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






    // 77. combinations
    public List<List<Integer>> combine(int n, int k) {

        // this will store all combos
        List<List<Integer>> result = new ArrayList<>();

        // temporarily store each combo as it is being constructed
        List<Integer> path = new ArrayList<>();


        int[] arr = new int[n];

        // fills array with numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            arr[i - 1] = i;
        }

        solve(arr, result, path, 0, n, k);

        return result;

    }



    public void solve(int[] arr, List<List<Integer>> result, List<Integer> path, int index, int n, int k) {

        // we have formed a valid combo, add path to result and return
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        // we have reached end, return
        if (index == n) {
            return;
        }


        // add each element at arr[index] to path
        path.add(arr[index]);
        // call solve with next index
        solve(arr, result, path, index + 1, n, k);
        // remove last element to backtrack
        path.remove(path.size() - 1);

        // call to solve where we don't include arr[index], basically search other decision tree
        solve(arr, result, path, index + 1, n, k);

    }





    // 46. Permutations
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        permuteBacktrack(result, new ArrayList<>(), nums);

        return result;


    }




    private void permuteBacktrack(List<List<Integer>> result, List<Integer> temp, int[] nums) {

        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
        } else {

            for (int i = 0; i < nums.length; i++) {

                if (temp.contains(nums[i])) {
                    continue;
                }

                temp.add(nums[i]);

                permuteBacktrack(result, temp, nums);

                temp.remove(temp.size() - 1);

            }
        }




    }








    // 39. Combination Sum
    public List<List<Integer>> combinationSum(int[] candidates, int target) {


        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates);

        backTrack(result, new ArrayList<>(), candidates, target, 0);

        return result;

    }







    private void backTrack(List<List<Integer>> list, List<Integer> temp, int[] nums, int remain, int start) {

        if (remain < 0) {
            return;
        } else if (remain == 0) {
            list.add(new ArrayList<>(temp));
        } else {
            for (int i = start; i < nums.length; i++) {

                temp.add(nums[i]);
                backTrack(list, temp, nums, remain - nums[i], i);
                temp.remove(temp.size() - 1);

            }
        }




    }






    /** doesn't work **/
    int count = 0;

    // 52. N-Queens II
    public int totalNQueens(int n) {

        dfs(0, n, 0, 0, 0);

        return count;
    }






    private void dfs(int row, int n, int column, int diag, int antiDiag) {

        if (row == n) {
            count++;
            return;
        }


        for (int i = 0; i < n; i++) {
            boolean isColSafe = ((1 << i) & column) == 0;
            boolean isDiagSafe = ((1 << (n - 1 + row - 1)) & diag) == 0;
            boolean isAntiDiagSafe = ((1 << (row + i)) & antiDiag) == 0;
            if (isColSafe && isDiagSafe && isAntiDiagSafe) {
                dfs(row + 1, n, (1 << i) | column, (1 << (n - 1 + row - i)) | diag, (1 << (row + i)) | antiDiag);
            }
        }



    }









}
