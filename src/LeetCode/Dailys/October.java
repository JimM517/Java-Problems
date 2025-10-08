package LeetCode.Dailys;

import java.util.*;

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










































































































































































































}
