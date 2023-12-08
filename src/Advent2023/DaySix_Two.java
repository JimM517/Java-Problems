package Advent2023;

public class DaySix_Two {


    public static void main(String[] args) {

        long time = 58996469L;

        long distanceRecord = 478223210191071L;

        int countWins = 0;

            for (int j = 1; j < time; j++) {

                long distance = (time - j) * j;

                if (distance > distanceRecord) {
                    countWins++;
                }

            }


        System.out.println(countWins);
        }







}
