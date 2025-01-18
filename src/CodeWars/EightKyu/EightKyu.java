package CodeWars.EightKyu;

import java.util.Arrays;

public class EightKyu {

    // well of ideas
    public String well(String[] x) {

        int count = 0;

        for (String idx : x) {
            if (idx.equals("good")) {
                count++;
            }
        }

        if (count > 2) {
            return "I smell a series!";
        } else if (count == 1 || count == 2) {
            return "Publish!";
        } else {
            return "Fail!";
        }


    }




    // sum arrays
    public double sum(double[] numbers) {

        return Arrays.stream(numbers).sum();
    }





    // beginner series #4 Cockroach
    public int cockroachSpeed(double x) {

        double cmsPerSec = x * 100000 / 3600;


        return (int) Math.floor(cmsPerSec);
    }




    // sentence smash
    public String smash(String... words) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);

            if (i < words.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }





    // collinear vectors
    public boolean collinearity(int x1, int y1, int x2, int y2) {

        return x1 * y2 == y1 * x2;

    }




    // calculate BMI
    public String bmi(double weight, double height) {

        double BMI = weight / Math.pow(height, 2);


        if (BMI <= 18.5) {
            return "Underweight";
        } else if (BMI <= 25.0) {
            return "Normal";
        } else if (BMI <= 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }




    }


















}
