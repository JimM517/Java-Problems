package LeetCode.Dailys;

import java.util.*;

public class August {


    // 118. Pascals triangle
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }

        if (numRows == 1) {
            List<Integer> firstRow = new ArrayList<>();
            firstRow.add(1);
            result.add(firstRow);
            return result;
        }

        result = generate(numRows - 1);
        List<Integer> prevRow = result.get(numRows - 2);
        List<Integer> currentRow = new ArrayList<>();
        currentRow.add(1);

        for (int i = 1; i < numRows - 1; i++) {
            currentRow.add(prevRow.get(i - 1) + prevRow.get(i));
        }

        currentRow.add(1);
        result.add(currentRow);

        return result;

    }




    // 2561. rearranging fruits
    public long minCost(int[] basket1, int[] basket2) {

        TreeMap<Integer, Integer> freq = new TreeMap<>();

        int m = Integer.MAX_VALUE;

        for (int b1 : basket1) {
            freq.put(b1, freq.getOrDefault(b1, 0) + 1);
            m = Math.min(m, b1);
        }

        for (int b2 : basket2) {
            freq.put(b2, freq.getOrDefault(b2, 0) - 1);
            m = Math.min(m, b2);
        }

        List<Integer> merge = new ArrayList<>();
        for (var entry : freq.entrySet()) {
            int count = entry.getValue();
            if (count % 2 != 0) {
                return -1;
            }
            for (int i = 0; i < Math.abs(count) / 2; i++) {
                merge.add(entry.getKey());
            }
        }

        Collections.sort(merge);
        long res = 0;
        for (int i = 0; i < merge.size() / 2; i++) {
            res += Math.min(2 * m, merge.get(i));
        }
        return res;
    }






    // 2106. maximum fruits harvested after at most k steps
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int left = 0;
        int right = 0;
        int n = fruits.length;
        int sum = 0;
        int answer = 0;

        while (right < n) {
            sum += fruits[right][1];

            while (left <= right && step(fruits, startPos, left, right) > k) {
                sum -= fruits[left][1];
                left++;
            }
            answer = Math.max(answer, sum);
            right++;
        }
        return answer;
    }


    public int step(int[][] fruits, int startPos, int left, int right) {

        return (
                Math.min(
                Math.abs(startPos - fruits[right][0]),
                Math.abs(startPos - fruits[left][0])
        ) +
                fruits[right][0] -
                fruits[left][0]
        );

    }



    // 904. fruits into baskets
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> basket = new HashMap<>();
        int left = 0, max = 0;

        for (int right = 0; right < fruits.length; right++) {
            // Add the current fruit to the basket
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);

            // If we have more than 2 types of fruits, shrink from the left
            while (basket.size() > 2) {
                basket.put(fruits[left], basket.get(fruits[left]) - 1);
                if (basket.get(fruits[left]) == 0) {
                    basket.remove(fruits[left]);
                }
                left++;
            }

            // Update the max window length
            max = Math.max(max, right - left + 1);
        }

        return max;
    }























































}
