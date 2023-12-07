package Advent2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DayFour {

    public static void main(String[] args) {

        String fPath = "src/InputFiles/";

        File file = new File(fPath + "DayFourInput.txt");

        try {

            Scanner sc = new Scanner(file);

            int total = 0;

            while (sc.hasNext()) {

                String line = sc.nextLine();

                String[] cards = line.split("\\|");

                int winningNumIndex = cards[0].indexOf(": ");

                String winningNumStr = cards[0].substring(winningNumIndex + 2);

                List<Integer> winningList = getNums(winningNumStr);

                List<Integer> elfList = getNums(cards[1]);




                total += compareLists(winningList, elfList);


            }
            System.out.println(total);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }




    }



    public static List<Integer> getNums(String listNums) {

        String[] nums = listNums.split(" ");

        List<Integer> list = new ArrayList<>();

        for (String num : nums) {

            try {

                list.add(Integer.parseInt(num));



            } catch (NumberFormatException e) {
                // skip because it is a space
            }




        }


        return list;

    }


    public static int compareLists(List<Integer> winningList, List<Integer> elfList) {


        Collections.sort(winningList);
        Collections.sort(elfList);

        int matchCount = 0;
        int total = 0;


        for (int winNum : winningList) {

            for (int elfNum : elfList) {

                if (winNum == elfNum) {
                    // have a match
                    matchCount++;
                }


            }



        }

        if (matchCount == 0) {
            return total;
        }
        matchCount--;

        total = (int) Math.pow(2, matchCount);
        return total;

    }






}
