package LeetCode.Dailys;

public class January2025 {


    // 1422. maximum score after splitting a string
    public int maxScore(String s) {

        int result = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            int current = 0;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == '0') {
                    current++;
                }
            }

            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) == '1') {
                    current++;
                }
            }
            result = Math.max(result, current);
        }
        return result;
    }




}
