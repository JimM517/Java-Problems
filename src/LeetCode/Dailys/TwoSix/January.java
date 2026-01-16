package LeetCode.Dailys.TwoSix;

import java.util.*;

public class January {


    // plus one
    public int[] plusOne(int[] digits) {


        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;


    }


    // 961. N-repeated element in size 2N array
    public int repeatedNTimes(int[] nums) {

        int len = nums.length;

        Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        int key = 0;
        for (Map.Entry<Integer, Integer> map : count.entrySet()) {

            int val = map.getValue();
            if (len == (2 * val) && count.size() == val + 1) {
                key = map.getKey();
            }


        }
        return key;


    }


    // 1411. number of ways to paint a N X 3 grid
    public int numOfWays(int n) {
        final int MOD = 1_000_000_007;
        long A = 6, B = 6;

        for (int i = 2; i <= n; i++) {
            long newA = (2 * A + 2 * B) % MOD;
            long newB = (2 * A + 3 * B) % MOD;
            A = newA;
            B = newB;
        }

        return (int) ((A + B) % MOD);
    }


    // 1390. four divisors
    public int sumFourDivisors(int[] nums) {

        int totalSum = 0;

        for (int n : nums) {
            int sum = 0;
            int count = 0;

            for (int d = 1; d * d <= n; d++) {
                if (n % d == 0) {
                    int other = n / d;

                    sum += d;
                    count++;

                    if (other != d) {
                        sum += other;
                        count++;
                    }

                    if (count > 4) break;
                }
            }

            if (count == 4) {
                totalSum += sum;
            }
        }

        return totalSum;
    }


    // 1975. maximum matrix sum
    public long maxMatrixSum(int[][] matrix) {

        long totalSum = 0;
        int minAbsVal = Integer.MAX_VALUE;
        int negativeCount = 0;

        for (int[] row : matrix) {
            for (int val : row) {
                totalSum += Math.abs(val);
                if (val < 0) {
                    negativeCount--;
                }
                minAbsVal = Math.min(minAbsVal, Math.abs(val));
            }
        }

        if (negativeCount % 2 != 0) {
            totalSum -= 2 * minAbsVal;
        }

        return totalSum;
    }


    // 1161. maximum level sum of a binary tree
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        ;

        TreeNode(int val) {
            this.val = val;
        }

        ;

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxLevelSum(TreeNode root) {

        int maxSum = Integer.MIN_VALUE;
        int answer = 0;
        int level = 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            level++;
            int sumAtCurrentLevel = 0;

            for (int sz = q.size(); sz > 0; sz--) {
                TreeNode node = q.poll();
                sumAtCurrentLevel += node.val;

                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            if (maxSum < sumAtCurrentLevel) {
                maxSum = sumAtCurrentLevel;
                answer = level;
            }
        }

        return answer;


    }


    // 1339. maximum product of splitted binary tree
    private long total = 0;
    private long best = 0;
    private static final int MOD = 1_000_000_007;

    public long sum(TreeNode node) {
        if (node == null) return 0;
        return node.val + sum(node.left) + sum(node.right);
    }

    public long dfs(TreeNode node) {
        if (node == null) return 0;
        long s = node.val + dfs(node.left) + dfs(node.right);
        best = Math.max(best, s * (total - s));
        return s;
    }

    public int maxProduct(TreeNode root) {

        total = sum(root);
        dfs(root);

        return (int) (best % MOD);


    }


    // 1458. max dot product of two subsequences
    public int maxDotProduct(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;

        int NEG = (int) -1e9;

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= m; j++)
                dp[i][j] = NEG;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int take = nums1[i - 1] * nums2[j - 1] + Math.max(0, dp[i - 1][j - 1]);
                dp[i][j] = Math.max(take, Math.max(dp[i - 1][j], dp[i][j - 1]));
            }
        }

        return dp[n][m];


    }


    // 865 smallest subtree with all deepest nodes
    Map<TreeNode, Integer> depth;
    int max_depth;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        depth = new HashMap();
        depth.put(null, -1);
        dfs(root, null);
        max_depth = -1;
        for (Integer d : depth.values())
            max_depth = Math.max(max_depth, d);

        return answer(root);
    }

    public void dfs(TreeNode node, TreeNode parent) {
        if (node != null) {
            depth.put(node, depth.get(parent) + 1);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }

    public TreeNode answer(TreeNode node) {
        if (node == null || depth.get(node) == max_depth)
            return node;
        TreeNode L = answer(node.left),
                R = answer(node.right);
        if (L != null && R != null) return node;
        if (L != null) return L;
        if (R != null) return R;
        return null;
    }


    // 712. minimum ASCII delete sum for two strings
    public int minimumDeleteSum(String s1, String s2) {

        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = s1.charAt(i) + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        int total = 0;
        for (char c : s1.toCharArray()) total += c;
        for (char c : s2.toCharArray()) total += c;

        return total - 2 * dp[0][0];


    }


// maximal rectangle

    /**
     * TODO: REVIEW THIS SOLUTION
     **/
    public int maximalRectangle(char[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        int answer = 0;

        int[] hist = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != '0') {
                    hist[j] += 1;
                } else {
                    hist[j] = 0;
                }
            }
            int area = area(hist);
            answer = Math.max(answer, area);
        }

        return answer;


    }


    public static int area(int[] heights) {

        int n = heights.length;
        int maxArea = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        return maxArea;


    }


    // 1266. minimum time visiting all points
    public int minTimeToVisitAllPoints(int[][] points) {

        int answer = 0;

        for (int i = 0; i < points.length - 1; i++) {

            int currX = points[i][0];
            int currY = points[i][1];

            int targetX = points[i + 1][0];
            int targetY = points[i + 1][1];

            answer += Math.max(Math.abs(targetX - currX), Math.abs(targetY - currY));


        }


        return answer;


    }


    // 3453. separate squares I
    public double separateSquares(int[][] squares) {

        double max_y = 0;
        double total_area = 0;
        for (int[] sq : squares) {
            int y = sq[1];
            int l = sq[2];
            total_area += (double) l * l;
            max_y = Math.max(max_y, (double) (y + l));
        }

        double lo = 0;
        double hi = max_y;
        double eps = 1e-5;
        while (Math.abs(hi - lo) > eps) {
            double mid = (hi + lo) / 2;
            if (check(mid, squares, total_area)) {
                hi = mid;
            } else {
                lo = mid;
            }
        }

        return hi;


    }


    private Boolean check(double limit_y, int[][] squares, double total_area) {
        double area = 0;
        for (int[] sq : squares) {
            int y = sq[1];
            int l = sq[2];
            if (y < limit_y) {
                area += (double) l * Math.min(limit_y - y, (double) l);
            }
        }
        return area >= total_area / 2;
    }


    // 3454. separate squares II
    class SegmentTree {

        private int[] count;
        private int[] covered;
        private int[] xs;
        private int n;

        public SegmentTree(int[] xs_) {
            xs = xs_;
            n = xs.length - 1;
            count = new int[4 * n];
            covered = new int[4 * n];
        }

        private void modify(
                int qleft,
                int qright,
                int qval,
                int left,
                int right,
                int pos
        ) {
            if (xs[right + 1] <= qleft || xs[left] >= qright) {
                return;
            }
            if (qleft <= xs[left] && xs[right + 1] <= qright) {
                count[pos] += qval;
            } else {
                int mid = (left + right) / 2;
                modify(qleft, qright, qval, left, mid, pos * 2 + 1);
                modify(qleft, qright, qval, mid + 1, right, pos * 2 + 2);
            }

            if (count[pos] > 0) {
                covered[pos] = xs[right + 1] - xs[left];
            } else {
                if (left == right) {
                    covered[pos] = 0;
                } else {
                    covered[pos] = covered[pos * 2 + 1] + covered[pos * 2 + 2];
                }
            }
        }

        public void update(int qleft, int qright, int qval) {
            modify(qleft, qright, qval, 0, n - 1, 0);
        }

        public int query() {
            return covered[0];
        }
    }


    public double separateSquares2(int[][] squares) {
        // save events: (y-coordinate, type, left boundary, right boundary)
        List<int[]> events = new ArrayList<>();
        Set<Integer> xsSet = new TreeSet<>();

        for (int[] sq : squares) {
            int x = sq[0];
            int y = sq[1];
            int l = sq[2];
            int xr = x + l;
            events.add(new int[]{y, 1, x, xr});
            events.add(new int[]{y + l, -1, x, xr});
            xsSet.add(x);
            xsSet.add(xr);
        }

        // sort events by y-coordinate
        events.sort((a, b) -> Integer.compare(a[0], b[0]));
        // discrete coordinates
        int[] xs = xsSet.stream().mapToInt(i -> i).toArray();
        // initialize the segment tree
        SegmentTree segTree = new SegmentTree(xs);

        List<Long> psum = new ArrayList<>();
        List<Integer> widths = new ArrayList<>();
        Long totalArea = 0L;
        int prev = events.get(0)[0];

        // scan: calculate total area and record intermediate states
        for (int[] event : events) {
            int y = event[0];
            int delta = event[1];
            int xl = event[2];
            int xr = event[3];
            int len = segTree.query();
            totalArea += (long) len * (y - prev);
            segTree.update(xl, xr, delta);
            // record prefix sums and widths
            psum.add(totalArea);
            widths.add(segTree.query());
            prev = y;
        }

        // calculate the target area (half rounded up)
        long target = (long) (totalArea + 1) / 2;
        // binary search
        int i = binarySearch(psum, target);
        double area = psum.get(i);
        // get the corresponding area, width, and height
        int width = widths.get(i);
        int height = events.get(i)[0];

        return height + (totalArea - area * 2) / (width * 2.0);
    }

    private int binarySearch(List<Long> list, long target) {
        int left = 0;
        int right = list.size() - 1;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < target) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }




    // 2943. maximize area of square hole in grid
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int hmax = 1;
        int vmax = 1;
        int hcur = 1;
        int vcur = 1;
        for (int i = 1; i < hBars.length; i++) {
            if (hBars[i] == hBars[i - 1] + 1) {
                hcur++;
            } else {
                hcur = 1;
            }
            hmax = Math.max(hmax, hcur);
        }
        for (int i = 1; i < vBars.length; i++) {
            if (vBars[i] == vBars[i - 1] + 1) {
                vcur++;
            } else {
                vcur = 1;
            }
            vmax = Math.max(vmax, vcur);
        }
        int side = Math.min(hmax, vmax) + 1;
        return side * side;
    }






    // 2975. maximum square area by removing fences from field
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {

        Set<Integer> hEdges = getEdges(hFences, m);
        Set<Integer> vEdges = getEdges(vFences, n);

        long res = 0;
        for (int e : hEdges) {
            if (vEdges.contains(e)) {
                res = Math.max(res, e);
            }
        }

        if (res == 0) {
            return -1;
        } else {
            return (int) ((res * res) % 1000000007);
        }
    }

    private Set<Integer> getEdges(int[] fences, int border) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for (int fence : fences) {
            list.add(fence);
        }

        list.add(1);
        list.add(border);
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                set.add(list.get(j) - list.get(i));
            }
        }

        return set;






    }






































}
