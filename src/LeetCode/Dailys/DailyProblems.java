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




    // 2054. two nest non-overlapping events
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int[][] dp = new int[events.length][3];
        for (int[] d : dp) Arrays.fill(d, -1);
        return findEvents(events, 0, 0, dp);

    }

    int findEvents(int[][] events, int idx, int cnt, int[][] dp) {

        if (cnt == 2 || idx >= events.length) return 0;
        if (dp[idx][cnt] == -1) {
            int end = events[idx][1];
            int lo = idx + 1;
            int hi = events.length - 1;
            while (lo < hi) {
                int mid = lo + ((hi - lo) >> 1);
                if (events[mid][0] > end) hi = mid;
                else lo = mid + 1;
            }
            int include = events[idx][2] +
                    (lo < events.length && events[lo][0] > end ? findEvents(events, lo, cnt + 1, dp) : 0);
            int exclude = findEvents(events, idx + 1, cnt, dp);
            dp[idx][cnt] = Math.max(include, exclude);
        }
        return dp[idx][cnt];


    }



}
