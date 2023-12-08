package Advent2023;

import java.util.Arrays;
import java.util.List;

public class DaySix {


    public static void main(String[] args) {

        List<Integer> timeList = Arrays.asList(58, 99, 64, 69);

        List<Integer> distList = Arrays.asList(478, 2232, 1019, 1071);

        int product = 1;

        for (int i = 0; i < timeList.size(); i++) {

            int time = timeList.get(i);
            int distRecord = distList.get(i);

            int countWins = 0;

            for (int j = 1; j < time; j++) {

                int distance = (time - j) * j;

                if (distance > distRecord) {
                    countWins++;
                }

            }
            product *= countWins;


        }

        System.out.println(product);
    }








}
