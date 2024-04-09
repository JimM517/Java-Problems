package LeetCodeOneFifty.Matrix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Matrix {

    /** Matrix problems from leetcode 150 **/




    // 36. Valid Sudoku
    public boolean isValidSudoku(char[][] board) {

        Set<String> seen = new HashSet();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
              if (board[i][j] != '.') {
                  char number = board[i][j];
                  if (!seen.add(number + "in row" + i)
                  || !seen.add(number + "in column" + j)
                  || !seen.add(number + "in block" + i / 3 + "-" + j / 3)) {
                      return false;
                  }
              }
            }
        }
        return true;

    }








    // 54. spiral matrix
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();


        if (matrix == null || matrix.length == 0) {
            return result;
        }



        int rows = matrix.length;
        int cols = matrix[0].length;
        int top = 0, bottom = rows - 1, left = 0, right = cols - 1;



        while (top <= bottom && left <= right) {

            // traverse top row
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;


            // traverse right column
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;


            // traverse bottom row
            // ensure not to revisit top row
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // traverse left column
            // ensure not to revisit the right column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }

        }
        return result;

    }



}
