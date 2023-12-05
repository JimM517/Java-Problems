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

        // get just the games
        String stripGame = line.substring(colon + 2);

        // split into array for each game as ; indicates end of one game
        String[] subset = stripGame.split("; ");

        boolean isValidGame = true;


        // loop over array of games
        for (String group : subset) {

            // split each line by , as this separates different colors
            String[] colors = group.split(", ");


            for (String color : colors) {

                // get index of spaces, need to isolate number
                int indexSpace = color.indexOf(" ");

                // this is the number
                String numStr = color.substring(0, indexSpace);

                // this is the color that corresponds to numStr
                String colorName = color.substring(indexSpace + 1);



                int num = Integer.parseInt(numStr);

                // check if each num/colorName is valid per parameters
                boolean isValid = isValidCount(num, colorName);

                if (!isValid) {
                    isValidGame = false;
                }

            }

        }

        if (isValidGame) {
            return gameId;
        }

        return 0;
    }





    public static boolean isValidCount(int num, String colorName) {

        switch(colorName) {

            case "red":
                if (num <= 12) {
                    return true;
                }
                return false;
            case "green":
                if (num <= 13) {
                    return true;
                }
                return false;
            case "blue":
                if (num <= 14) {
                    return true;
                }
                return false;
        }


        return false;
    }



}
