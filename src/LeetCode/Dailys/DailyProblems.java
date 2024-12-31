package LeetCode.Dailys;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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



    // 1639. Number of ways to form a target string given a dictionary
    // top-down dp
    public int numWays(String[] words, String target) {

        int wordLength = words[0].length();
        int targetLength = target.length();

        int[][] dp = new int[wordLength][targetLength];
        for (int i = 0; i < wordLength; i++) {
            Arrays.fill(dp[i], -1);
        }

        int[][] charFrequency = new int[wordLength][26];

        for (String word : words) {
            for (int j = 0; j < wordLength; j++) {
                int character = word.charAt(j) - 'a';
                charFrequency[j][character]++;
            }
        }
        return (int) getWords(words, target, 0, 0, dp, charFrequency);

    }


    private long getWords(String[] words, String target, int wordsIndex, int targetIndex, int[][] dp, int[][] charFrequency) {
        int MOD = 1000000007;

        if (targetIndex == target.length()) return 1;

        if (wordsIndex == words[0].length() || words[0].length() - wordsIndex < target.length() - targetIndex) return 0;

        if (dp[wordsIndex][targetIndex] != -1) return dp[wordsIndex][targetIndex];


        long countWays = 0;
        int curPos = target.charAt(targetIndex) - 'a';

        countWays += getWords(words, target, wordsIndex + 1, targetIndex, dp, charFrequency);

        countWays += charFrequency[wordsIndex][targetIndex] * getWords(words, target, wordsIndex + 1, targetIndex + 1, dp, charFrequency);


        dp[wordsIndex][targetIndex] = (int) (countWays % MOD);

        return dp[wordsIndex][targetIndex];
    }




    // 2466. count ways to build good strings
    public int countGoodStrings(int low, int high, int zero, int one) {

      int[] dp = new int[high + 1];
      dp[0] = 1;
      int mod = 1000000007;

      for (int end = 1; end <= high; end++) {
          if (end >= zero) {
              dp[end] += dp[end - zero];
          }
          if (end >= one) {
              dp[end] += dp[end - one];
          }
          dp[end] %= mod;
      }


      int answer = 0;
      for (int i = low; i <= high; i++) {
          answer += dp[i];
          answer %= mod;
      }

      return answer;



    }


    // minimum cost for tickets
    Set<Integer> isTravelNeeded = new HashSet<>();

    public int solve(int[] dp, int[] days, int[] costs, int currDay) {

        if (currDay > days[days.length - 1]) {
            return 0;
        }
        if (!isTravelNeeded.contains(currDay)) {
            return solve(dp, days, costs, currDay + 1);
        }

        if (dp[currDay] != -1) {
            return dp[currDay];
        }

        int oneDay = costs[0] + solve(dp, days, costs, currDay + 1);
        int sevenDay = costs[1] + solve(dp, days, costs, currDay + 7);
        int thirtyDay = costs[2] + solve(dp, days, costs, currDay + 30);

        return dp[currDay] = Math.min(oneDay, Math.min(sevenDay, thirtyDay));
    }



    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];
        int[] dp = new int[lastDay + 1];
        Arrays.fill(dp, -1);

        for (int day : days) {
            isTravelNeeded.add(day);
        }
        return solve(dp, days, costs, 1);
    }


























































































}
