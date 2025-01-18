package CodeWars.SixKyu;

public class SixKyuQuestions {

    // tribonacci sequence
    public double[] tribonacci(double[] s, int n) {

        if (n == 0) {
            return new double[0];
        }

        double[] result = new double[n];
        for (int i = 0; i < n; i++) {
            if (i < 3) {
                result[i] = s[i];
            } else {
                result[i] = result[i - 1] + result[i - 2] + result[i - 3];
            }
        }

        return result;
    }





}
