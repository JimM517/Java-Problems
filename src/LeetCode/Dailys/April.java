package LeetCode.Dailys;

public class April {


    // 2140. solving questions with brainpower
    public long mostPoints(int[][] questions) {

        int n = questions.length;

        long[] result = new long[n];

        result[n - 1] = questions[n - 1][0];

        for (int i = n - 2; i >= 0; i--) {
            if (questions[i][1] + i + 1 >= n) {
                result[i] = Math.max(questions[i][0], result[i + 1]);
            } else {
                result[i] = Math.max(result[i + 1], questions[i][0] + result[i + 1 + questions[i][1]]);
            }
        }

        return result[0];

    }





    // 2873. maximum value of an ordered triplet
    public long maximumTripletValue(int[] nums) {

        int n = nums.length;
        long maximumVal = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    long current = (long) (nums[i] - nums[j]) * nums[k];
                    maximumVal = Math.max(maximumVal, current);
                }
            }
        }
        return maximumVal;

    }












































































































}
