package LeetCode.Dailys;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntUnaryOperator;

public class October {




    // 1518. water bottles
    public int numWaterBottles(int numBottles, int numExchange) {

        int drank = 0;
        int empty = 0;

        while (numBottles > 0) {

            drank += numBottles;
            empty += numBottles;


            // exchange?
            numBottles = empty / numExchange;
            empty = empty % numExchange;


        }



        return drank;



    }



    // 3100. water bottles II
    public int maxBottlesDrunk(int numBottles, int numExchange) {

        int answer = numBottles;
        for (int empty = numBottles; empty >= numExchange; numExchange++) {
            answer++;
            empty -= numExchange - 1;
        }

        return answer;


    }


    // 407. Trapping rain water II
    // not my solution
        public int trapRainWater(int[][] heightMap) {
            // Direction arrays
            int[] dRow = { 0, 0, -1, 1 };
            int[] dCol = { -1, 1, 0, 0 };

            int numOfRows = heightMap.length;
            int numOfCols = heightMap[0].length;

            boolean[][] visited = new boolean[numOfRows][numOfCols];

            // Priority queue (min-heap) to process boundary cells in increasing height order
            PriorityQueue<Cell> boundary = new PriorityQueue<>();

            // Add the first and last column cells to the boundary and mark them as visited
            for (int i = 0; i < numOfRows; i++) {
                boundary.offer(new Cell(heightMap[i][0], i, 0));
                boundary.offer(
                        new Cell(heightMap[i][numOfCols - 1], i, numOfCols - 1)
                );
                // Mark left and right boundary cells as visited
                visited[i][0] = visited[i][numOfCols - 1] = true;
            }

            // Add the first and last row cells to the boundary and mark them as visited
            for (int i = 0; i < numOfCols; i++) {
                boundary.offer(new Cell(heightMap[0][i], 0, i));
                boundary.offer(
                        new Cell(heightMap[numOfRows - 1][i], numOfRows - 1, i)
                );
                // Mark top and bottom boundary cells as visited
                visited[0][i] = visited[numOfRows - 1][i] = true;
            }

            // Initialize the total water volume to 0
            int totalWaterVolume = 0;

            // Process cells in the boundary (min-heap will always pop the smallest height)
            while (!boundary.isEmpty()) {
                // Pop the cell with the smallest height from the boundary
                Cell currentCell = boundary.poll();

                int currentRow = currentCell.row;
                int currentCol = currentCell.col;
                int minBoundaryHeight = currentCell.height;

                // Explore all 4 neighboring cells
                for (int direction = 0; direction < 4; direction++) {
                    // Calculate the row and column of the neighbor
                    int neighborRow = currentRow + dRow[direction];
                    int neighborCol = currentCol + dCol[direction];

                    // Check if the neighbor is within the grid bounds and not yet visited
                    if (
                            isValidCell(
                                    neighborRow,
                                    neighborCol,
                                    numOfRows,
                                    numOfCols
                            ) &&
                                    !visited[neighborRow][neighborCol]
                    ) {
                        // Get the height of the neighbor cell
                        int neighborHeight = heightMap[neighborRow][neighborCol];

                        // If the neighbor's height is less than the current boundary height, water can be trapped
                        if (neighborHeight < minBoundaryHeight) {
                            // Add the trapped water volume
                            totalWaterVolume += minBoundaryHeight - neighborHeight;
                        }

                        // Push the neighbor into the boundary with updated height (to prevent water leakage)
                        boundary.offer(
                                new Cell(
                                        Math.max(neighborHeight, minBoundaryHeight),
                                        neighborRow,
                                        neighborCol
                                )
                        );
                        visited[neighborRow][neighborCol] = true;
                    }
                }
            }

            // Return the total amount of trapped water
            return totalWaterVolume;
        }

        // Class to store the height and coordinates of a cell in the grid
        private static class Cell implements Comparable<Cell> {

            int height;
            int row;
            int col;

            // Constructor to initialize a cell
            public Cell(int height, int row, int col) {
                this.height = height;
                this.row = row;
                this.col = col;
            }

            // Overload the compareTo method to make the priority queue a min-heap based on height
            @Override
            public int compareTo(Cell other) {
                // Min-heap comparison
                return Integer.compare(this.height, other.height);
            }
        }

        // Helper function to check if a cell is valid (within grid bounds)
        private boolean isValidCell(
                int row,
                int col,
                int numOfRows,
                int numOfCols
        ) {
            return row >= 0 && col >= 0 && row < numOfRows && col < numOfCols;
        }







        // 11. container with most water
    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left < right) {

            int w = right - left;
            int h = Math.min(height[left], height[right]);
            int area = w * h;

            max = Math.max(max, area);

            if (height[left] < height[right]) {
                left++;
            } else if (height[left] > height[right]) {
                right--;
            } else {
                left++;
                right--;
            }

        }
        return max;
    }



    // 417. pacific atlantic water flow
    private int m, n;
    private int[][] directions = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
            m = heights.length;
            n = heights[0].length;
            boolean[][] pacific = new boolean[m][n];
            boolean[][] atlantic = new boolean[m][n];

        for (int j = 0; j < n; j++) dfs(0, j, heights, pacific);
        for (int i = 0; i < m; i++) dfs(i, 0, heights, pacific);
        for (int j = 0; j < n; j++) dfs(m - 1, j, heights, atlantic);
        for (int i = 0; i < m; i++) dfs(i, n - 1, heights, atlantic);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;


    }


    public void dfs(int i, int j, int[][] heights, boolean[][] visited) {

        if (visited[i][j]) return;
        visited[i][j] = true;
        for (int[] d : directions) {
            int x = i + d[0], y = j + d[1];
            if (x < 0 || x >= m || y < 0 || y >= n) continue;
            if (heights[x][y] < heights[i][j]) continue;
            dfs(x, y, heights, visited);
        }



    }





    // 778. swim in rising water
    int dirs[][] = {{0,-1},{0,1},{-1,0},{1,0}};
    public int swimInWater(int[][] grid) {
            int n = grid.length;
            int answer = Integer.MAX_VALUE;
            int low = 0, high = n * n - 1;

            while (low <= high) {

                int mid = (low + high) / 2;
                boolean[][] vis = new boolean[n][n];
                if (grid[0][0] <= mid && dfsWater(0, 0, mid, grid, vis)) {
                    answer = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

            }

            return answer;


    }



    public boolean dfsWater(int x, int y, int t, int[][] grid, boolean[][] vis) {

        int n = grid.length;
        vis[x][y] = true;
        if (x == n - 1 && y == n - 1) return true;

        for (int[] d : dirs) {
            int nx = x + d[0], ny = y + d[1];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && !vis[nx][ny] && grid[nx][ny] <= t) {
                if (dfsWater(nx, ny, t, grid, vis)) return true;
            }
        }
        return false;


    }






// 1488. avoid flood in the city
    public int[] avoidFlood(int[] rains) {

        int[] answer = new int[rains.length];
        Arrays.fill(answer, 1);
        TreeSet<Integer> st = new TreeSet<>();

        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < rains.length; i++) {

            if (rains[i] == 0) {
                st.add(i);
            } else {
                answer[i] = -1;
                if (mp.containsKey(rains[i])) {
                    Integer it = st.ceiling(mp.get(rains[i]));
                    if (it == null) {
                        return new int[0];
                    }
                    answer[it] = rains[i];
                    st.remove(it);
                }
                mp.put(rains[i], i);
            }

        }

        return answer;

    }




    // 2300 successful pairs or spells and potions
    public int[] successfulPairs(int[] spells, int[] potions, long success) {

        int n = spells.length;
        int m = potions.length;


        int[] result = new int[n];

        Arrays.sort(potions);

        for (int i = 0; i < n; i++) {

            int spell = spells[i];

            int left = 0;

            int right = m - 1;

            while (left <= right) {

                int mid = left + (right - left) / 2;

                long product = (long) spell * potions[mid];

                if (product >= success) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }


            }
            result[i] = m - left;


        }

        return result;


    }




    // 3494. find the minimum amount of time to brew potions
    public long minTime(int[] skill, int[] mana) {

            int n = skill.length, m = mana.length;

            long[] done = new long[n + 1];

            for (int j = 0; j < m; j++) {
                for (int i = 0; i < n; i++) {
                    done[i + 1] = Math.max(done[i + 1], done[i]) + (long) mana[j] * skill[i];
                }
                for (int i = n - 1; i > 0; i--) {
                    done[i] = done[i + 1] - (long) mana[j] * skill[i];
                }
            }



            return done[n];



    }




    // 3147. taking maximum energy from the mystic dungeon
    public int maxmimumEnergy(int[] energy, int k) {

        int n = energy.length;
        int answer = Integer.MIN_VALUE;

        for (int i = n - k; i < n; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j-= k) {
                sum += energy[j];
                answer = Math.max(answer, sum);
            }
        }

        return answer;


    }







    // 3186. maximum total damage with spell casting

        public long maximumTotalDamage(int[] power) {
            TreeMap<Integer, Integer> count = new TreeMap<>();
            for (int p : power) {
                count.put(p, count.getOrDefault(p, 0) + 1);
            }
            List<int[]> vec = new ArrayList<>();
            vec.add(new int[] { -1000000000, 0 });
            for (Map.Entry<Integer, Integer> e : count.entrySet()) {
                vec.add(new int[] { e.getKey(), e.getValue() });
            }
            int n = vec.size();
            long[] f = new long[n];
            long mx = 0;
            long ans = 0;
            int j = 1;
            for (int i = 1; i < n; i++) {
                while (j < i && vec.get(j)[0] < vec.get(i)[0] - 2) {
                    mx = Math.max(mx, f[j]);
                    j++;
                }
                f[i] = mx + 1L * vec.get(i)[0] * vec.get(i)[1];
                ans = Math.max(ans, f[i]);
            }
            return ans;
        }




        // 3539. find sum of array product of magical sequences

            public long quickmul(long x, long y, long mod) {
                long res = 1;
                long cur = x % mod;
                while (y > 0) {
                    if ((y & 1) == 1) {
                        res = (res * cur) % mod;
                    }
                    y >>= 1;
                    cur = (cur * cur) % mod;
                }
                return res;
            }

            public int magicalSum(int m, int k, int[] nums) {
                int n = nums.length;
                long mod = 1000000007;
                long[] fac = new long[m + 1];
                fac[0] = 1;
                for (int i = 1; i <= m; i++) {
                    fac[i] = (fac[i - 1] * i) % mod;
                }
                long[] ifac = new long[m + 1];
                ifac[0] = 1;
                ifac[1] = 1;
                for (int i = 2; i <= m; i++) {
                    ifac[i] = quickmul(i, mod - 2, mod);
                }
                for (int i = 2; i <= m; i++) {
                    ifac[i] = (ifac[i - 1] * ifac[i]) % mod;
                }
                long[][] numsPower = new long[n][m + 1];
                for (int i = 0; i < n; i++) {
                    numsPower[i][0] = 1;
                    for (int j = 1; j <= m; j++) {
                        numsPower[i][j] = (numsPower[i][j - 1] * nums[i]) % mod;
                    }
                }
                long[][][][] f = new long[n][m + 1][m * 2 + 1][k + 1];
                for (int j = 0; j <= m; j++) {
                    f[0][j][j][0] = (numsPower[0][j] * ifac[j]) % mod;
                }
                for (int i = 0; i + 1 < n; i++) {
                    for (int j = 0; j <= m; j++) {
                        for (int p = 0; p <= m * 2; p++) {
                            for (int q = 0; q <= k; q++) {
                                int q2 = (p % 2) + q;
                                if (q2 > k) {
                                    break;
                                }
                                for (int r = 0; r + j <= m; r++) {
                                    int p2 = p / 2 + r;
                                    f[i + 1][j + r][p2][q2] +=
                                            (((f[i][j][p][q] * numsPower[i + 1][r]) % mod) *
                                                    ifac[r]) %
                                                    mod;
                                    f[i + 1][j + r][p2][q2] %= mod;
                                }
                            }
                        }
                    }
                }
                long res = 0;
                for (int p = 0; p <= m * 2; p++) {
                    for (int q = 0; q <= k; q++) {
                        if (Integer.bitCount(p) + q == k) {
                            res = (res + ((f[n - 1][m][p][q] * fac[m]) % mod)) % mod;
                        }
                    }
                }
                return (int) res;
            }





        // find resultant array after removing anagrams
    public List<String> removeAnagrams(String[] words) {

        List<String> res = new ArrayList<>();
        res.add(words[0]);
        int n = words.length;
        for (int i = 1; i < n; i++) {
            if (!compare(words[i], words[i - 1])) {
                res.add(words[i]);
            }
        }


        return res;


    }

    public boolean compare(String word1, String word2) {

        int[] freq = new int[26];
        for (char ch : word1.toCharArray()) {
            freq[ch - 'a']++;
        }
        for (char ch : word2.toCharArray()) {
            freq[ch - 'a']--;
        }
        for (int x : freq) {
            if (x != 0) {
                return false;
            }
        }
        return true;
    }



    // 3349. adjacent increasing subarrays detection I
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {

        int n = nums.size();
        int inc = 1, prevInc = 0, maxLen = 0;
        for (int i = 1; i  < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                inc++;
            } else {
                prevInc = inc;
                inc = 1;
            }
            maxLen = Math.max(maxLen, Math.max(inc >> 1, Math.min(prevInc, inc)));
            if (maxLen >= k) {
                return true;
            }
        }

        return false;
    }


    // 3350. adjacent increasing subarrays detection II
    public int maxIncreasingSubarrays(List<Integer> nums) {

        int n = nums.size();
        int cnt = 1;
        int precnt = 0;
        int answer = 0;

        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                cnt++;
            } else {
                precnt = cnt;
                cnt = 1;
            }
            answer = Math.max(answer, Math.min(precnt, cnt));
            answer = Math.max(answer, cnt / 2);
        }

        return answer;

    }



    // 2598. smallest missing non-negative integer after operations
    public int findSmallestInteger(int[] nums, int value) {

        int[] mp = new int[value];
        for (int x : nums) {
            int v = ((x % value) + value) % value;
            mp[v]++;
        }
        int mex = 0;
        while (mp[mex % value] > 0) {
            mp[mex % value]--;
            mex++;
        }

        return mex;

    }



    // maximize the number of partitions after operations

        public int maxPartitionsAfterOperations(String s, int k) {
            int n = s.length();
            int[][] left = new int[n][3];
            int[][] right = new int[n][3];

            int num = 0;
            int mask = 0;
            int count = 0;
            for (int i = 0; i < n - 1; i++) {
                int binary = 1 << (s.charAt(i) - 'a');
                if ((mask & binary) == 0) {
                    count++;
                    if (count <= k) {
                        mask |= binary;
                    } else {
                        num++;
                        mask = binary;
                        count = 1;
                    }
                }
                left[i + 1][0] = num;
                left[i + 1][1] = mask;
                left[i + 1][2] = count;
            }

            num = 0;
            mask = 0;
            count = 0;
            for (int i = n - 1; i > 0; i--) {
                int binary = 1 << (s.charAt(i) - 'a');
                if ((mask & binary) == 0) {
                    count++;
                    if (count <= k) {
                        mask |= binary;
                    } else {
                        num++;
                        mask = binary;
                        count = 1;
                    }
                }
                right[i - 1][0] = num;
                right[i - 1][1] = mask;
                right[i - 1][2] = count;
            }

            int maxVal = 0;
            for (int i = 0; i < n; i++) {
                int seg = left[i][0] + right[i][0] + 2;
                int totMask = left[i][1] | right[i][1];
                int totCount = Integer.bitCount(totMask);
                if (left[i][2] == k && right[i][2] == k && totCount < 26) {
                    seg++;
                } else if (Math.min(totCount + 1, 26) <= k) {
                    seg--;
                }
                maxVal = Math.max(maxVal, seg);
            }
            return maxVal;
        }



        // 3397. maximum number of distinct elements after operations
    public int maxDistinctElements(int[] nums, int k) {

        Arrays.sort(nums);
        int cnt = 0;
        int prev = Integer.MIN_VALUE;
        for (int num : nums) {
            int curr = Math.min(Math.max(num - k, prev + 1), num + k);
            if (curr > prev) {
                cnt++;
                prev = curr;
            }
        }

        return cnt;



    }




    // 2011. final value of variable after performing operations
    public int finalValueAfterOperations(String[] operations) {

        int result = 0;

        for (int i = 0; i < operations.length; i++) {
            if (operations[i].startsWith("++") || operations[i].substring(1).equals("++")) {
                result++;
            } else {
                result--;
            }
        }
        return result;
    }



    // 3346. maximum frequency of an element after performing operations I
    public int maxFrequency(int[] A, int k, int numOperations) {
        Arrays.sort(A);

        // Case 1
        Map<Integer, Integer> count = new HashMap<>();
        int res = 0, i = 0, j = 0, n = A.length;
        for (int a : A) {
            while (j < n && A[j] <= a + k) {
                count.put(A[j], count.getOrDefault(A[j], 0) + 1);
                j++;
            }
            while (i < n && A[i] < a - k) {
                count.put(A[i], count.get(A[i]) - 1);
                i++;
            }
            int cur = Math.min(j - i, count.getOrDefault(a, 0) + numOperations);
            res = Math.max(res, cur);
        }

        // Case 2
        for (i = 0, j = 0; j < n; j++) {
            while (A[i] + k + k < A[j]) {
                i++;
            }
            res = Math.max(res, Math.min(j - i + 1, numOperations));
        }
        return res;
    }




    // 3347. maximum frequency of an element after performing operations II
    public int maxFrequencyTwo(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        int ans = 0;
        Map<Integer, Integer> numCount = new HashMap<>();
        Set<Integer> modes = new TreeSet<>();

        Consumer<Integer> addMode = value -> {
            modes.add(value);
            if (value - k >= nums[0]) {
                modes.add(value - k);
            }
            if (value + k <= nums[nums.length - 1]) {
                modes.add(value + k);
            }
        };

        int lastNumIndex = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != nums[lastNumIndex]) {
                numCount.put(nums[lastNumIndex], i - lastNumIndex);
                ans = Math.max(ans, i - lastNumIndex);
                addMode.accept(nums[lastNumIndex]);
                lastNumIndex = i;
            }
        }

        numCount.put(nums[lastNumIndex], nums.length - lastNumIndex);
        ans = Math.max(ans, nums.length - lastNumIndex);
        addMode.accept(nums[lastNumIndex]);

        IntUnaryOperator leftBound = value -> {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[mid] < value) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        };

        IntUnaryOperator rightBound = value -> {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = (left + right + 1) / 2;
                if (nums[mid] > value) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }
            return left;
        };

        for (int mode : modes) {
            int l = leftBound.applyAsInt(mode - k);
            int r = rightBound.applyAsInt(mode + k);
            int tempAns;
            if (numCount.containsKey(mode)) {
                tempAns = Math.min(
                        r - l + 1,
                        numCount.get(mode) + numOperations
                );
            } else {
                tempAns = Math.min(r - l + 1, numOperations);
            }
            ans = Math.max(ans, tempAns);
        }

        return ans;
    }




    // 3461. check if digits are equal in string after operations I
    public boolean hasSameDigits(String s) {

        int n = s.length();
        char[] sArray = s.toCharArray();
        for (int i = 1; i <= n - 2; i++) {
            for (int j = 0; j <= n - 1 - i; j++) {
                int digit1 = sArray[j] - '0';
                int digit2 = sArray[j + 1] - '0';
                sArray[j] = (char) (((digit1 + digit2) % 10) + '0');
            }
        }

        return sArray[0] == sArray[1];


    }



    // 2048. next greater numerically balances number
    public int nextBeautifulNumber(int n) {

        for (int i = n + 1; i <= 1224444; i++) {
            if (isBalance(i)) {
                return i;
            }
        }

        return -1;


    }


    private boolean isBalance(int x) {


        int[] count = new int[10];
        while (x > 0) {
            count[x % 10]++;
            x /= 10;
        }
        for (int d = 0; d < 10; d++) {
            if (count[d] > 0 && count[d] != d) {
                return false;
            }
        }
        return true;
    }




    // 1716. calculate money in leetcode bank
    public int totalMoney(int n) {
        int k = n / 7;
        int F = 28;
        int L = 28 + (k - 1) * 7;
        int arithmeticSum = k * (F + L) / 2;

        int monday = k + 1;
        int finalWeek = 0;
        for (int day = 0; day < n % 7; day++) {
            finalWeek += monday + day;
        }
        return arithmeticSum + finalWeek;
    }



    // 3354. make array elements equal to zero
    public int countValidSelections(int[] nums) {

        int n = nums.length;
        int answer = 0;
        int sum = 0;
        for (int x : nums) {
            sum += x;
        }
        int leftSum = 0;
        int rightSum = sum;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (leftSum - rightSum >= 0 && leftSum - rightSum <= 1) {
                    answer++;
                }
                if (rightSum - leftSum >= 0 && rightSum - leftSum <= 1) {
                    answer++;
                }
            } else {
                leftSum += nums[i];
                rightSum -= nums[i];
            }
        }
        return answer;
    }




    // 3370. smallest number with all set bits
    public int smallestNumber(int n) {

            int x = 1;
            while (x < n) {
                x = x * 2 + 1;
            }

            return x;



    }



    // 1526. minimum number of increments on subarrays to form a target array
    public int minNumberOperations(int[] target) {

        int n = target.length;
        int ans = target[0];
        for (int i = 1; i < n; ++i) {
            ans += Math.max(target[i] - target[i - 1], 0);
        }
        return ans;




    }







    // 3289. the two sneaky numbers of digitville
    public int[] getSneakyNumbers(int[] nums) {


        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] result = new int[2];
        int idx = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 2) {
                result[idx++] = entry.getKey();
                if (idx == 2) break;
            }
        }
        return result;
    }





















































































































}
