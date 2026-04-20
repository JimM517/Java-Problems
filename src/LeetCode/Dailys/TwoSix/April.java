package LeetCode.Dailys.TwoSix;

public class April {




// 657. robot return to origin
    public boolean judgeCircle(String moves) {

        int x = 0;
        int y = 0;

        for (int i = 0; i < moves.length(); i++) {

            if (moves.charAt(i) == 'R') {
                x++;
            }
            else if (moves.charAt(i) == 'L') {
                x--;
            }
            else if (moves.charAt(i) == 'U') {
                y++;
            }
            else if (moves.charAt(i) == 'D') {
                y--;
            }

        }



        return x == 0 && y == 0;

    }






    // 2078. two furthest houses with different colors
    public int maxDistance(int[] colors) {

        int maxDist = Integer.MIN_VALUE;

        for (int i = 0; i < colors.length; i++) {
            for (int j = i + 1; j < colors.length; j++) {
                if (colors[i] != colors[j]) {
                    maxDist = Math.max(maxDist, j - i);
                }
            }
        }

        return maxDist;

    }







































































}
