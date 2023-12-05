package Advent2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayTwo {


    public static void main(String[] args) {

        String fPath = "src/InputFiles/";

        File file = new File(fPath + "CubeInput.txt");

        try {


            Scanner sc = new Scanner(file);

            while (sc.hasNext()) {








            }




        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }





    }



}
