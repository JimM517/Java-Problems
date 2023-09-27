package InterviewQuestions;

public class InterviewPrep {

    // 151 Reverse Words in a string
    public String reverseWords(String s) {
//        StringBuilder sb = new StringBuilder();
//
//        String[] strings = s.split(" ");
//        for (int i = strings.length - 1; i >= 0; i--) {
//            sb.append(strings[i]);
//        }
//        return sb.toString();

        // trying another solution to remove white space
        s = s.trim().replaceAll("\\s+", " ");

        String[] strings = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = strings.length - 1; i >= 0; i--) {
            sb.append(strings[i]);
            if (i > 0) {
                sb.append(" ");
            }
        }

        return sb.toString();

    }



    // 200  Number of islands
    public int numIslands(char[][] grid) {

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    clearRestOfLand(grid, i, j);
                }
            }
        }

        return count;
    }

    private void clearRestOfLand(char[][] grid, int i, int j) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0') return;

        grid[i][j] = '0';
        clearRestOfLand(grid, i + 1, j);
        clearRestOfLand(grid, i - 1, j);
        clearRestOfLand(grid, i, j + 1);
        clearRestOfLand(grid, i, j - 1);
        return;

    }



    // 1304 Find N unique integers sum up to zero
    public int[] sumZero(int n) {

        int d = -(n / 2);

        int[] result = new int[n];

        if (n % 2 == 0) {
            for (int i = 0; i < n; i++) {
                result[i] = d;
                d = d + 1;
            }
        } else {
            for (int i = 0; i < n; i++) {
                result[i] = d;
                d = d + 1;
            }
        }
        return result;
    }


    // 53 Maximum Subarray
    // find maximum subarray with the largest sum, return the sum
    public int maxSubArray(int[] nums) {

        // Kadane's algorithm

        int startTotal = Integer.MIN_VALUE;
        int endTotal = 0;

        for (int i = 0; i < nums.length; i++) {
            endTotal += nums[i];
            if (startTotal < endTotal) {
                startTotal = endTotal;
            }
            if (endTotal < 0) {
                endTotal = 0;
            }
            return startTotal;

        }



        return 0;
    }



    // 121 Best Time to Buy and Sell Stock

    public int maxProfit(int[] prices) {

       if (prices.length == 0) {
           return 0;
       }

       int start = prices[0];
       int maxProfit = 0;

       for (int i = 0; i < prices.length; i++) {
           if (prices[i] < start) {
               start = prices[i];
           } else {
               int currProfit = prices[i] - start;
               if (currProfit > maxProfit) {
                   maxProfit = currProfit;
               }
           }
       }
       return maxProfit;
    }



}
