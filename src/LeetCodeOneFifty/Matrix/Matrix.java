package LeetCodeOneFifty.Matrix;

import java.util.*;

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




    // 48. rotate image
    public void rotate(int[][] matrix) {

        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];

                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }



    }







    // 73. Set matrix zeros
    public void setZeroes(int[][] matrix) {

        boolean fr = false, fc = false;


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        fr = true;
                    }
                    if (j == 0) {
                        fc = true;
                    }
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }


        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }


        if (fr) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        if (fc) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }



    }







    // 463 island perimeter
    public int islandPerimeter(int[][] grid) {

            int answer = 0;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        int count = 0;
                        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                            count++;
                        }
                        if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                            count++;
                        }
                        if (i + 1 < grid.length && grid[i + 1][j] == 1) {
                            count++;
                        }
                        if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
                            count++;
                        }
                        answer += 4 - count;
                    }
                }
            }

            return answer;


    }







    // 566. reshape the matrix
    public int[][] matrixReshape(int[][] matrix, int r, int c) {

        int row = matrix.length;
        int col = matrix[0].length;


        if ((row * col) != (r * c)) {
            return matrix;
        }



        int[][] arr = new int[r][c];

        int rowNum = 0;
        int colNum = 0;


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[rowNum][colNum] = matrix[i][j];
                colNum++;
                if (colNum == c) {
                    colNum = 0;
                    rowNum++;
                }
            }
        }

        return arr;
    }





    // 200. Number of islands
    public int numIslands(char[][] grid) {

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    clearRestOfLand(grid, i, j);
                }
            }
        }

        return count;
    }

    private static void clearRestOfLand(char[][] grid, int i, int j) {

        if (i < 0 || j < 0 || i >= grid.length || j > grid[i].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        clearRestOfLand(grid, i + 1, j);
        clearRestOfLand(grid, i - 1, j);
        clearRestOfLand(grid, i, j + 1);
        clearRestOfLand(grid, i, j - 1);
        return;

    }






    // 1992. Find all groups of farmland
    public int[][] findFarmLand(int[][] land) {

        List<int[]> list = new LinkedList<>();

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 1) {
                    int[] arr = {i, j, 0, 0};
                    landSearch(land, i, j, arr);
                    list.add(arr);
                }
            }
        }
        return list.toArray(new int[0][]);
    }




    private void landSearch(int[][] land, int i, int j, int[] arr) {

        if (i >= land.length || j >= land[0].length || land[i][j] == 0) {
            return;
        }


        land[i][j] = 0;
        arr[2] = Math.max(i, arr[2]);
        arr[3] = Math.max(arr[3], j);

        landSearch(land, i + 1, j, arr);
        landSearch(land, i, j + 1, arr);

    }



    // 289. Game of life
    public void gameOfLife(int[][] board) {
        int[][] nextState = new int[board.length][board[0].length];


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int liveNeighbors = countLiveNeighbors(board, i, j);

                if (board[i][j] == 1) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        nextState[i][j] = 0;
                    } else {
                        nextState[i][j] = 1;
                    }
                } else {
                    if (liveNeighbors == 3) {
                        nextState[i][j] = 1;
                    }
                }




            }
        }


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = nextState[i][j];
            }
        }



    }


    private int countLiveNeighbors(int[][] board, int row, int col) {

        int count = 0;

        int[][] directions = {{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1}};


        for (int[] dir : directions) {


            int newRow = row + dir[0];
            int newCol = col + dir[1];



            if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length) {
                count += board[newRow][newCol];
            }

        }
        return count;

    }
















}
