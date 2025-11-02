package LeetCode.Dailys;

import java.util.HashSet;
import java.util.Set;

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
































































































































































}
