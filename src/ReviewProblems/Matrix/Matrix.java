package ReviewProblems.Matrix;

import java.util.HashSet;
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



}
