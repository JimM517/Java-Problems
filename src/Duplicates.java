import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Duplicates {


    // 40. Combination Sum
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(candidates);

        comeBack(list, new ArrayList<>(), candidates, target, 0);

        return list;
    }

    public void comeBack(List<List<Integer>> list, List<Integer> temp, int[] nums, int remain, int start) {
        if (remain < 0) {
            return;
        }
        else if (remain == 0) {
            list.add(new ArrayList<>(temp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                temp.add(nums[i]);
                comeBack(list, temp, nums, remain - nums[i], i + 1);
                temp.remove(temp.size() - 1);
            }
        }


    }




    // 567. permutation in string
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] arrS1 = new int[26];
        int[] arrS2 = new int[26];


        for (int i = 0; i < s1.length(); i++) {
            arrS1[s1.charAt(i) - 'a']++;
            arrS2[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(arrS1, arrS2)) {
            return true;
        }


        int start = 0;
        int end = s1.length();
        while (end < s2.length()) {
            arrS2[s2.charAt(start) - 'a']--;
            arrS2[s2.charAt(end) - 'a']++;

            if (Arrays.equals(arrS1, arrS2)) {
                return true;
            }
            start++;
            end++;

        }

        return false;

    }








}
