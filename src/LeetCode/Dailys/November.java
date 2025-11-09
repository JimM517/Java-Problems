package LeetCode.Dailys;

import java.util.*;

public class November {


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {};
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; };
    }


    public ListNode modifiedList(int[] nums, ListNode head) {

        Set<Integer> valuesToRemove = new HashSet<>();
        for (int num : nums) {
            valuesToRemove.add(num);
        }

        while (head != null && valuesToRemove.contains(head.val)) {
            head = head.next;
        }


        if (head == null) {
            return null;
        }

        ListNode current = head;
        while (current.next != null) {
            if (valuesToRemove.contains(current.next.val)) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }



 // 2257. count unguarded cells in the grid

     private static final int UNGUARDED = 0;
     private static final int GUARDED = 1;
     private static final int GUARD = 2;
     private static final int WALL = 3;

     public void markguarded(int row, int col, int[][] grid) {
         // Traverse upwards
         for (int r = row - 1; r >= 0; r--) {
             if (grid[r][col] == WALL || grid[r][col] == GUARD) break;
             grid[r][col] = GUARDED;
         }
         // Traverse downwards
         for (int r = row + 1; r < grid.length; r++) {
             if (grid[r][col] == WALL || grid[r][col] == GUARD) break;
             grid[r][col] = GUARDED;
         }
         // Traverse leftwards
         for (int c = col - 1; c >= 0; c--) {
             if (grid[row][c] == WALL || grid[row][c] == GUARD) break;
             grid[row][c] = GUARDED;
         }
         // Traverse rightwards
         for (int c = col + 1; c < grid[0].length; c++) {
             if (grid[row][c] == WALL || grid[row][c] == GUARD) break;
             grid[row][c] = GUARDED;
         }
     }

     public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
         int[][] grid = new int[m][n];

         // Mark guards' positions
         for (int[] guard : guards) {
             grid[guard[0]][guard[1]] = GUARD;
         }

         // Mark walls' positions
         for (int[] wall : walls) {
             grid[wall[0]][wall[1]] = WALL;
         }

         // Mark cells as guarded by traversing from each guard
         for (int[] guard : guards) {
             markguarded(guard[0], guard[1], grid);
         }

         // Count unguarded cells
         int count = 0;
         for (int[] row : grid) {
             for (int cell : row) {
                 if (cell == UNGUARDED) count++;
             }
         }
         return count;
     }





    // 1578. minimum time to make rope colorful
    public int minCost(String colors, int[] neededTime) {

        int n = colors.length();
        int sum = 0;

        for (int i = 1; i < n; i++) {

            int maxi = 0;
            while (i < n && colors.charAt(i) == colors.charAt(i - 1)) {
                sum += neededTime[i - 1];
                maxi = Math.max(maxi, neededTime[i - 1]);
                i++;
            }
            sum += neededTime[i - 1];
            maxi = Math.max(maxi, neededTime[i - 1]);
            if (maxi != 0) {
                sum -= maxi;
            }

        }

        return sum;



    }




    // find x-sum of all k-long subarrays I
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int res[] = new int[n-k+1];
        for(int i=0; i<res.length; i++) {
            int sum = 0;
            Set<Integer> set = new HashSet<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int j=i; j < i+k; j++) {
                sum += nums[j];
                set.add(nums[j]);
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            }

            if(set.size() < x) res[i] = sum;
            else {
                PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
                    if(map.get(a) == map.get(b)) return b-a;
                    return map.get(b)-map.get(a);
                });
                for(int ele : set) pq.add(ele);
                int ct = x;
                while(ct-- > 0) {
                    int top = pq.remove();
                    res[i] += (top*map.get(top));
                }
            }
        }

        return res;
    }




    // 3321. find x-sum of all k-long subarrays II
    class Helper {

        private int x;
        private long result;
        private TreeSet<Pair> large, small;
        private Map<Integer, Integer> occ;

        private static class Pair implements Comparable<Pair> {

            int first;
            int second;

            Pair(int first, int second) {
                this.first = first;
                this.second = second;
            }

            @Override
            public int compareTo(Pair other) {
                if (this.first != other.first) {
                    return Integer.compare(this.first, other.first);
                }
                return Integer.compare(this.second, other.second);
            }

            @Override
            public boolean equals(Object obj) {
                if (this == obj) return true;
                if (obj == null || getClass() != obj.getClass()) return false;
                Pair pair = (Pair) obj;
                return first == pair.first && second == pair.second;
            }

            @Override
            public int hashCode() {
                return Objects.hash(first, second);
            }
        }

        public Helper(int x) {
            this.x = x;
            this.result = 0;
            this.large = new TreeSet<>();
            this.small = new TreeSet<>();
            this.occ = new HashMap<>();
        }

        public void insert(int num) {
            if (occ.containsKey(num) && occ.get(num) > 0) {
                internalRemove(new Pair(occ.get(num), num));
            }
            occ.put(num, occ.getOrDefault(num, 0) + 1);
            internalInsert(new Pair(occ.get(num), num));
        }

        public void remove(int num) {
            internalRemove(new Pair(occ.get(num), num));
            occ.put(num, occ.get(num) - 1);
            if (occ.get(num) > 0) {
                internalInsert(new Pair(occ.get(num), num));
            }
        }

        public long get() {
            return result;
        }

        private void internalInsert(Pair p) {
            if (large.size() < x || p.compareTo(large.first()) > 0) {
                result += (long) p.first * p.second;
                large.add(p);
                if (large.size() > x) {
                    Pair toRemove = large.first();
                    result -= (long) toRemove.first * toRemove.second;
                    large.remove(toRemove);
                    small.add(toRemove);
                }
            } else {
                small.add(p);
            }
        }

        private void internalRemove(Pair p) {
            if (p.compareTo(large.first()) >= 0) {
                result -= (long) p.first * p.second;
                large.remove(p);
                if (!small.isEmpty()) {
                    Pair toAdd = small.last();
                    result += (long) toAdd.first * toAdd.second;
                    small.remove(toAdd);
                    large.add(toAdd);
                }
            } else {
                small.remove(p);
            }
        }
    }

    class Solution {

        public long[] findXSum(int[] nums, int k, int x) {
            Helper helper = new Helper(x);
            List<Long> ans = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                helper.insert(nums[i]);
                if (i >= k) {
                    helper.remove(nums[i - k]);
                }
                if (i >= k - 1) {
                    ans.add(helper.get());
                }
            }

            return ans.stream().mapToLong(Long::longValue).toArray();
        }
    }


// 3607. power grid maintenance

    class Vertex {

        public int vertexId;
        public boolean offline = false;
        public int powerGridId = -1;

        public Vertex() {}

        public Vertex(int id) {
            this.vertexId = id;
        }
    }

    class Graph {

        private Map<Integer, List<Integer>> adj;
        private Map<Integer, Vertex> vertices;

        public Graph() {
            this.adj = new HashMap<>();
            this.vertices = new HashMap<>();
        }

        public void addVertex(int id, Vertex value) {
            this.vertices.put(id, value);
            this.adj.put(id, new ArrayList<>());
        }

        public void addEdge(int u, int v) {
            this.adj.get(u).add(v);
            this.adj.get(v).add(u);
        }

        public Vertex getVertexValue(int id) {
            return this.vertices.get(id);
        }

        public List<Integer> getConnectedVertices(int id) {
            return this.adj.get(id);
        }
    }



        private void traverse(
                Vertex u,
                int powerGridId,
                PriorityQueue<Integer> powerGrid,
                Graph graph
        ) {
            u.powerGridId = powerGridId;
            powerGrid.add(u.vertexId);
            for (int vid : graph.getConnectedVertices(u.vertexId)) {
                Vertex v = graph.getVertexValue(vid);
                if (v.powerGridId == -1) {
                    traverse(v, powerGridId, powerGrid, graph);
                }
            }
        }

        public int[] processQueries(int c, int[][] connections, int[][] queries) {
            Graph graph = new Graph();
            for (int i = 0; i < c; i++) {
                Vertex v = new Vertex(i + 1);
                graph.addVertex(i + 1, v);
            }

            for (int[] conn : connections) {
                graph.addEdge(conn[0], conn[1]);
            }

            List<PriorityQueue<Integer>> powerGrids = new ArrayList<>();
            for (int i = 1, powerGridId = 0; i <= c; i++) {
                Vertex v = graph.getVertexValue(i);
                if (v.powerGridId == -1) {
                    PriorityQueue<Integer> powerGrid = new PriorityQueue<>();
                    traverse(v, powerGridId, powerGrid, graph);
                    powerGrids.add(powerGrid);
                    powerGridId++;
                }
            }

            List<Integer> ans = new ArrayList<>();
            for (int[] q : queries) {
                int op = q[0];
                int x = q[1];
                if (op == 1) {
                    Vertex vertex = graph.getVertexValue(x);
                    if (!vertex.offline) {
                        ans.add(x);
                    } else {
                        PriorityQueue<Integer> powerGrid = powerGrids.get(
                                vertex.powerGridId
                        );
                        while (
                                !powerGrid.isEmpty() &&
                                        graph.getVertexValue(powerGrid.peek()).offline
                        ) {
                            powerGrid.poll();
                        }
                        ans.add(!powerGrid.isEmpty() ? powerGrid.peek() : -1);
                    }
                } else if (op == 2) {
                    graph.getVertexValue(x).offline = true;
                }
            }

            return ans.stream().mapToInt(Integer::intValue).toArray();
        }







        // 2528. maximize the minimum powered city
    public long maxPower(int[] stations, int r, int k) {


            int n = stations.length;
            long[] cnt = new long[n + 1];

            for (int i = 0; i < n; i++) {
                int left = Math.max(0, i - r);
                int right = Math.min(n, i + r + 1);
                cnt[left] += stations[i];
                cnt[right] -= stations[i];
            }


            long lo = Arrays.stream(stations).min().getAsInt();
            long hi = Arrays.stream(stations).asLongStream().sum() + k;
            long res = 0;

            while (lo <= hi) {
                long mid = lo + (hi - lo) / 2;
                if (check(cnt, mid, r, k)) {
                    res = mid;
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

        return res;
    }



    private boolean check(long[] cnt, long val, int r, int k) {

         int n = cnt.length - 1;
         long[] diff = cnt.clone();
         long sum = 0;
         long remaining = k;

         for (int i = 0; i < n; i++) {
             sum += diff[i];
             if (sum < val) {
                 long add = val - sum;
                 if (remaining < add) {
                     return false;
                 }
                 remaining -= add;
                 int end = Math.min(n, i + 2 * r + 1);
                 diff[end] -= add;
                 sum += add;
             }
         }


         return true;


    }







    // 1611. minimum one bit operations to make integers zero
    public int minimumOneBitOperations(int n) {

         int answer = 0;
         int k = 0;
         int mask = 1;

         while (mask <= n) {
             if ((n & mask) != 0) {
                 answer = (1 << (k + 1)) - 1 - answer;
             }
             mask <<= 1;
             k++;
         }


        return answer;

    }



    // 2169. count operations to obtain zero
    public int countOperations(int num1, int num2) {

         int count = 0;

         while (num1 != 0 && num2 != 0) {
             if (num1 >= num2) {
                 num1 -= num2;
             } else {
                 num2 -= num1;
             }
             count++;
         }
        return count;
    }



























































































































}
