package LeetCode.Dailys;

public class June {



// 2929. distribute candies among children II
    public long distributeCandies(int n, int limit) {

            long result = 0;

            for (int i = 0; i <= Math.min(limit, n); i++) {
                if (n - i > 2 * limit) {
                    continue;
                }
                result += Math.max(Math.min(limit, n - i) - Math.max(0, n - i - limit) + 1, 0);

            }
            return result;
    }




































































































}
