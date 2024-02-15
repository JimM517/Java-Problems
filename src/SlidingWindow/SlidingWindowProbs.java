package SlidingWindow;

public class SlidingWindowProbs {


    // 121 Best time to buy and sell stock
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
                int current = prices[i] - start;

                if (current > maxProfit) {
                    maxProfit = current;
                }


            }
        }

        return maxProfit;




    }






}
