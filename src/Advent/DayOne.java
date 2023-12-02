package Advent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayOne {



    public static void main(String[] args) {

        String fPath = "src/InputFiles/";

        File file = new File(fPath + "AdventInput.txt");



        try {
            Scanner sc = new Scanner(file);

            while (sc.hasNext()) {

                String line = sc.nextLine();

                parseString(line);

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }




    }




    public String parseString(String line) {







    }







}
