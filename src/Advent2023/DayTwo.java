package Advent2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayTwo {


    public static void main(String[] args) {

        String fPath = "src/InputFiles/";

        File file = new File(fPath + "CubeInput.txt");

        try (Scanner sc = new Scanner(file)) {

            int total = 0;


            while (sc.hasNext()) {

                String line = sc.nextLine();

                total += possibleGames(line);

            }

            System.out.println(total);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }





    }




    public static int possibleGames(String line) {

        // get the index of :
        int colon = line.indexOf(": ");

        // get game id
        int gameId = Integer.parseInt(line.substring(5, colon));


        String stripGame = line.substring(colon + 2);


        System.out.println(stripGame);


        return 1;
    }



}
