package Advent2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayOne_PartTwo {


    public static void main(String[] args) {

        String fPath = "src/InputFiles/";

        File file = new File(fPath + "AdventInput.txt");

        int total = 0;

        try {
            Scanner sc = new Scanner(file);

            while (sc.hasNext()) {
                // get each line
                String line = sc.nextLine();

                String numFrontStr = parseFrontString(line);
                String numBackStr = parseBackString(line);

                String numStr = numFrontStr + numBackStr;

                int num = Integer.parseInt(numStr);

            // 54845

                // add the total
                total += num;


            }
            System.out.println("The total is " + total);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }




    }


    public static String parseFrontString(String line) {

        String numStr1 = "";

        for (int i = 0; i < line.length(); i++) {
            numStr1 = determineNumber(line, i);
            if (numStr1 != "") {
                break;
            }
        }

        return numStr1;
    }



    public static String parseBackString(String line) {

        String numStr2 = "";

        for (int i = line.length() - 1; i >= 0; i--) {

            numStr2 = determineNumber(line, i);

            if (numStr2 != "") {
                break;
            }
        }

        return numStr2;
    }



    // helper method
    public static String determineNumber(String line, int index) {

        String num = "";

        char possibleNum = line.charAt(index);

        try {

            if (possibleNum == 'o') {
                String str = line.substring(index, index + 3);
                if (str.equalsIgnoreCase("one")) {
                    num = "1";
                }
            } else if (possibleNum == 't') {
                String str = line.substring(index, index + 3);
                if (str.equalsIgnoreCase("two")) {
                    num = "2";
                } else {
                    str = line.substring(index, index + 5);
                    if (str.equalsIgnoreCase("three")) {
                        num = "3";
                    }
                }
            } else if (possibleNum == 'f') {
                String str = line.substring(index, index + 4);
                if (str.equalsIgnoreCase("four")) {
                    num = "4";
                }
                if (str.equalsIgnoreCase("five")) {
                    num = "5";
                }
            } else if (possibleNum == 's') {
                String str = line.substring(index, index + 3);
                if (str.equalsIgnoreCase("six")) {
                    num = "6";
                } else {
                    str = line.substring(index, index + 5);
                    if (str.equalsIgnoreCase("seven")) {
                        num = "7";
                    }
                }
            } else if (possibleNum == 'e') {
                String str = line.substring(index, index + 5);
                if (str.equalsIgnoreCase("eight")) {
                    num = "8";
                }
            } else if (possibleNum == 'n') {
                String str = line.substring(index, index + 4);
                if (str.equalsIgnoreCase("nine")) {
                    num = "9";
                }
            } else if (Character.isDigit(possibleNum)) {
                num = possibleNum + "";
            }



        } catch (StringIndexOutOfBoundsException e) {
            // not a number, return ""

        }
        return num;
    }




}
