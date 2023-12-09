package Advent2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DaySeven {


    public static void main(String[] args) {

        String fPath = "src/InputFiles/";

        File file = new File(fPath + "DaySevenInput.txt");

        try {
            Scanner sc = new Scanner(file);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }





}
