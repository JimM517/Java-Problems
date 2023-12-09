package Advent2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayEight {

    public static void main(String[] args) {


        String fPath = "src/InputFiles/";

        File file = new File(fPath + "DayEightTest.txt");


        try {

            Scanner sc = new Scanner(file);


            while (sc.hasNext()) {

                String line = sc.nextLine();

                String[] strArr = line.split(" ");

                System.out.println(strArr[0]);


            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }



    }













}
