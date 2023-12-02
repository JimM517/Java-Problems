package Advent2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayOne {



    public static void main(String[] args) {

        String fPath = "src/InputFiles/";

        File file = new File(fPath + "AdventInput.txt");

        int total = 0;

        try {
            Scanner sc = new Scanner(file);

            while (sc.hasNext()) {
                // get each line
                String line = sc.nextLine();
                // get the number from each line
                String numStr = parseString(line);
                // convert to int
                int num = Integer.parseInt(numStr);
                // add the total
                total += num;


            }
            System.out.println("The total is " + total);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }




    }




    public static String parseString(String line) {


        char num1 = ' ';
        char num2 = ' ';

        for (int i = 0; i < line.length(); i++) {

            char numberOne = line.charAt(i);

            if (Character.isDigit(numberOne)) {
                num1 = numberOne;
                break;
            }

        }

        for (int i = line.length() - 1; i >= 0; i--) {

            char numberTwo = line.charAt(i);

            if (Character.isDigit(numberTwo)) {
                num2 = numberTwo;
                break;
            }


        }



        return "" + num1 + num2;

    }







}
