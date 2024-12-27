package LeetCode.Dailys;

import java.util.Arrays;

public class DailyProblems {

    // 455. assign cookies
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;

        for (int j = 0; i < g.length && j < s.length; j++) {
            if (g[i] <= s[j]) {
                i++;
            }
        }
        return i;


    }





    // 494. target sum
    int totalWays = 0;
    public int findTargetSumWays(int[] nums, int target) {
        calculateWays(nums, 0, 0, target);
        return totalWays;
    }


    private void calculateWays(int[] nums, int currentIndex, int currentSum, int target) {
        if (currentIndex == nums.length) {
            if (currentSum == target) {
                totalWays++;
            }
        } else {
            calculateWays(nums, currentIndex + 1, currentSum + nums[currentIndex], target);
            calculateWays(nums, currentIndex + 1, currentSum - nums[currentIndex], target);
        }
    }



    // 1014. best sightseeing pair
    public int maxScoreSightseeingPair(int[] values) {

        int m = values[0];
        int answer = values[0] + values[1] + 1;
        int n = values.length;

        for (int i = 1; i < n; i++) {
            answer = Math.max(answer, m + (values[i] - i));
            m = Math.max(m, values[i] + i);
        }
        return answer;
    }




}
