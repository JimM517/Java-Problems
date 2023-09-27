package InterviewQuestions;

public class InterviewPrep {

    // 151 Reverse Words in a string
    public String reverseWords(String s) {
//        StringBuilder sb = new StringBuilder();
//
//        String[] strings = s.split(" ");
//        for (int i = strings.length - 1; i >= 0; i--) {
//            sb.append(strings[i]);
//        }
//        return sb.toString();

        // trying another solution to remove white space
        s = s.trim().replaceAll("\\s+", " ");

        String[] strings = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = strings.length - 1; i >= 0; i--) {
            sb.append(strings[i]);
            if (i > 0) {
                sb.append(" ");
            }
        }

        return sb.toString();

    }



    // 200  Number of islands
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

    private void clearRestOfLand(char[][] grid, int i, int j) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0') return;

        grid[i][j] = '0';
        clearRestOfLand(grid, i + 1, j);
        clearRestOfLand(grid, i - 1, j);
        clearRestOfLand(grid, i, j + 1);
        clearRestOfLand(grid, i, j - 1);
        return;

    }



}
