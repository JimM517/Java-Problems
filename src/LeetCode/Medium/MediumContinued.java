package LeetCode.Medium;

import java.util.*;

public class MediumContinued {


    // 72. edit distance
    public int minDistance(String word1, String word2) {

      int m = word1.length();
      int n = word2.length();

      int[][] dp = new int[m + 1][n + 1];

      for (int i = 0; i <= n; i++) {
          dp[0][i] = i;
      }
      for (int i = 0; i <= m; i++) {
          dp[i][0] = i;
      }

      for (int i = 1; i <= m; i++) {
          for (int j = 1; j <= n; j++) {

              if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                  dp[i][j] = dp[i - 1][j - 1];
              } else {
                  dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
              }


          }
      }

        return dp[m][n];
    }




    // 1813. sentence similarity III
    public boolean areSentencesSimilar(String sentence1, String sentence2) {

        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");

        int i = 0;
        int j = 0;

        while (i < s1.length && i < s2.length && s1[i].equals(s2[i])) {
            i++;
        }

        while (j < s1.length - i && j < s2.length - i && s1[s1.length - 1 - j].equals(s2[s2.length - 1 - j])) {
            j++;
        }


        return i + j == s1.length || i + j == s2.length;

    }




    // 1963. Minimum number of swaps to make the string balanced
    public int minSwaps(String s) {

        Stack<Character> stack = new Stack<>();

        int start = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            if (ch == '[') {
                stack.push(ch);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    start++;
                }
            }


        }

        return (start + 1) / 2;



    }




    // 921. Minimum add to make parentheses valid
    public int minAddToMakeValid(String s) {

        int opens = 0;
        int closed = 0;

        for (Character ch : s.toCharArray()) {

            if (ch == '(') {
                closed++;
            } else {
                if (closed == 0) {
                    opens++;
                } else {
                    closed--;
                }
            }


        }


        return opens + closed;

    }





    // 962. maximum width of ramp
    public int maxWidthRamp(int[] nums) {

        Stack<Integer> stack = new Stack<>();

        // build stack with decreasing indices
        for (int i = 0; i < nums.length; i++) {

            // we will only push indices where the current val is less or equal to the previous
            // will form a decreasing stack of values
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }


        int maxW = 0;

        // start at the end of the array to find max width
        for (int j = nums.length - 1; j >= 0; j--) {

            // check largest possible ramp
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[j]) {
                int i = stack.pop();
                maxW = Math.max(maxW, j - i);
            }
        }


        return maxW;




    }




    // 1942. the number of the smallest unoccupied chair
    public int smallestChair(int[][] times, int targetFriend) {

        int[] targetTime = times[targetFriend];

        Arrays.sort(times, (a, b) -> Integer.compare(a[0], b[0]));


        int n = times.length;
        int[] chairTime = new int[n];

        for (int[] time : times) {

            for (int i = 0; i < n; i++) {

                if (chairTime[i] <= time[0]) {
                    chairTime[i] = time[1];
                    if (Arrays.equals(time, targetTime)) {
                        return i;
                    }
                    break;
                }


            }


        }


        return 0;

    }





    // 2406. Divide intervals into minimum number of groups
    // very similar question to meeting rooms II
    public int minGroups(int[][] intervals) {

        List<int[]> events = new ArrayList<>();

        for (int[] interval : intervals) {
            events.add(new int[] {interval[0], 1});
            events.add(new int[] {interval[1] + 1, - 1});
        }

        Collections.sort(events, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            } else {
                return Integer.compare(a[0], b[0]);
            }
        });

        int concurrent = 0;
        int maxIntervals = 0;



        for (int[] event : events) {

            concurrent += event[1];

            maxIntervals = Math.max(maxIntervals, concurrent);



        }

        return maxIntervals;

    }




    // 2530. maximal score after applying k operations
    public int maxKElements(int[] nums, int k) {

        int result = 0;

        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int num : nums) {
            heap.add(num);
        }


        for (int i = 0; i < k; i++) {

            int currMax = heap.poll();

            result += currMax;

            heap.add((int) Math.ceil(currMax / 3.0));



        }


        return result;



    }



    // 2938. separate black and white balls
    public long minimumSteps(String s) {

        long count = 0;

        int whiteCount = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                count += whiteCount;
            } else {
                whiteCount++;
            }
        }


        return count;


    }




    // 1405. Longest Happy String
    public String longestDiverseString(int a, int b, int c) {

        StringBuilder result = new StringBuilder();

        int len = a + b + c;

        int A = 0;
        int B = 0;
        int C = 0;

        for (int i = 0; i < len; i++) {
            if ((a >= b && a >= c && A < 2) || (B == 2 && a > 0) || (C == 2 && a > 0)) {
                result.append("a");
                a--;
                A++;
                B = 0;
                C = 0;
            } else if ((b >= a && b >= c && B < 2) || (A == 2 && b > 0) || (C == 2 && b > 0)) {
                result.append("b");
                b--;
                B++;
                A = 0;
                C = 0;

            } else if ((c >= a && c >= b && C < 2) || (A == 2 && c > 0) || (B == 2 && c > 0)) {
                result.append("c");
                c--;
                C++;
                A = 0;
                B = 0;
            }
        }
        return result.toString();
    }






    // 670. Maximum swap
    public int maximumSwap(int num) {

            char[] digits = String.valueOf(num).toCharArray();


            int[] last = new int[10];


            for (int i = 0; i < digits.length; i++) {
                last[digits[i] - '0'] = i;
            }



            for (int i = 0; i < digits.length; i++) {
                for (int d = 9; d > digits[i] - '0'; d--) {
                    if (last[d] > i) {
                        char temp = digits[i];
                        digits[i] = digits[last[d]];
                        digits[last[d]] = temp;


                        return Integer.parseInt(new String(digits));
                    }
                }
            }
            return num;
    }





    // 2044 count number of maximum bitwise or subsets
    public int countMaxOrSubsets(int[] nums) {
        int maxValue = 0;
        for (int num : nums) {
            maxValue |= num;
        }
        return countSubsets(nums, 0, 0, maxValue);
    }


    private int countSubsets(int[] nums, int idx, int currentOr, int targetOr) {

        if (idx == nums.length) {
            return (currentOr == targetOr) ? 1 : 0;
        }

        int countWithout = countSubsets(nums, idx + 1, currentOr, targetOr);

        int countWith = countSubsets(nums, idx + 1, currentOr | nums[idx], targetOr);

        return countWithout + countWith;



    }



    // 1545. find the kth bit in nth binary string
    public char findKthBit(int n, int k) {

        if (n == 1) return '0';

        int length = (1 << n) - 1;

        int mid = length / 2 + 1;

        if (k == mid) return '1';

        if (k < mid) return findKthBit(n - 1, k);

        return findKthBit(n - 1, length - k + 1) == '0' ? '1' : '0';


    }





    // 1593. split a string into the max number of unique substrings
    int maxCount = 0;
    public int maxUniqueSplit(String s) {

        backTrackingForUniqueSplit(0, new HashSet<>(), s);

        return maxCount;
    }



    private void backTrackingForUniqueSplit(int start, Set<String> seen, String s) {

        if (start == s.length()) {
            maxCount = Math.max(seen.size(), maxCount);
        }

        for (int i = start + 1; i <= s.length(); i++) {
            String temp = s.substring(start, i);
            if (!seen.contains(temp)) {
                seen.add(temp);
                backTrackingForUniqueSplit(i, seen, s);
                seen.remove(temp);
            }
        }
    }





    // 1233. remove sub folders from the filesystem
    public List<String> removeSubFolders(String[] folder) {
        Set<String> folderSet = new HashSet<>(Arrays.asList(folder));
        List<String> result = new ArrayList<>();


        for (String f : folder) {
            boolean isSubFolder = false;
            String prefix = f;

            while (!prefix.isEmpty()) {
                int pos = prefix.lastIndexOf('/');
                if (pos == -1) {
                    break;
                }

                prefix = prefix.substring(0, pos);


                if (folderSet.contains(prefix)) {
                    isSubFolder = true;
                    break;
                }
            }

            if (!isSubFolder) {
                result.add(f);
            }
        }
        return result;
    }




    // 2501 longest square streak in an array
    public int longestSquareStreak(int[] nums) {
        int max = -1;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        List<Integer> setArr = new ArrayList<>(set);
        Collections.sort(setArr);

        for (int i = 0; i < setArr.size(); i++) {
            int curr = setArr.get(i);
            int count = 0;

            while (set.contains(curr)) {
                set.remove(curr);
                curr = curr * curr;
                count++;
            }

            max = Math.max(max, count);
        }

        return max > 1 ? max : -1;

    }




    // 2684. maximum number of moves in grid
    public int maxMoves(int[][] grid) {

        int M = grid.length, N = grid[0].length;

        // Create a dp array to store moves, with each cell having a size of 2.
        int[][] dp = new int[M][2];

        // Initialize the first column cells as reachable.
        for (int i = 0; i < M; i++) {
            dp[i][0] = 1;
        }

        int maxMoves = 0;

        // Iterate over each column starting from the second one.
        for (int j = 1; j < N; j++) {
            for (int i = 0; i < M; i++) {
                // Check if moving from the same row
                // of the previous column is possible.
                if (grid[i][j] > grid[i][j - 1] && dp[i][0] > 0) {
                    dp[i][1] = Math.max(dp[i][1], dp[i][0] + 1);
                }
                // Check if moving from the upper diagonal is possible.
                if (
                        i - 1 >= 0 &&
                                grid[i][j] > grid[i - 1][j - 1] &&
                                dp[i - 1][0] > 0
                ) {
                    dp[i][1] = Math.max(dp[i][1], dp[i - 1][0] + 1);
                }
                // Check if moving from the lower diagonal is possible.
                if (
                        i + 1 < M &&
                                grid[i][j] > grid[i + 1][j - 1] &&
                                dp[i + 1][0] > 0
                ) {
                    dp[i][1] = Math.max(dp[i][1], dp[i + 1][0] + 1);
                }

                // Update the maximum moves so far.
                maxMoves = Math.max(maxMoves, dp[i][1] - 1);
            }

            // Shift dp values for the next iteration.
            for (int k = 0; k < M; k++) {
                dp[k][0] = dp[k][1];
                dp[k][1] = 0;
            }
        }

        return maxMoves;


    }







    // 3163. String compression III
    public String compressString(String word) {

        StringBuilder sb = new StringBuilder();

        int count = 1;
        int n = word.length();

        char ch = word.charAt(0);

        for (int i = 1; i < n; i++) {
            if (word.charAt(i) == ch && count < 9) {
                count++;
            } else {
                sb.append(count).append(ch);
                ch = word.charAt(i);
                count = 1;
            }
        }
        sb.append(count).append(ch);
        return sb.toString();
    }





    // 2914. minimum number of changes to make a binary string beautiful
    public int minChanges(String s) {

        int count = 0;
        for (int i = 0; i < s.length(); i += 2) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                count++;
            }
        }
        return count;
    }




}
