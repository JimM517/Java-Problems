package Advent2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayThree_Two {


    private List<String> list = new ArrayList<>();

    public static void main(String[] args) {

        DayThree_Two app = new DayThree_Two();

        app.run();

    }




    private void run() {

        String fPath = "src/InputFiles/";

        File file = new File(fPath + "DayThreeInput.txt");


        try {
            Scanner sc = new Scanner(file);

            while (sc.hasNext()) {

                // get each line and add to list
                list.add(sc.nextLine());
            }

            int total = validParts();
            System.out.println(total);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    private int validParts() {

        // need to look at three lines at a time

        int total = 0;

        for (int lineNum = 0; lineNum < list.size(); lineNum++) {

            // we need to find a number, then look for symbol
            String line = list.get(lineNum);

            String numStr = "";

            int num = 0;

            int numStart = -1;
            int numEnd = -1;

            // j is keeping track on index in each line
            for (int j = 0; j < line.length(); j++) {
                char ch = line.charAt(j);

                // ASCII values for 0-9
                if (ch > 47 && ch < 58) {
                    numStr += ch;
                    // will keep looping as long as there is a char
                    if (numStart < 0) {
                        numStart = j;
                    }
                } else {
                    if (numStr != "") {
                        num = Integer.parseInt(numStr);

                        // ending index of the number
                        numEnd = j - 1;

                        boolean symbolFound = checkForSymbol(numStart, numEnd, lineNum);

                        if (symbolFound) {
                            total += num;
                        }
                        numStr = "";
                        numStart = -1;
                        numEnd = -1;
                    }
                }
            }
            if (numStr != "") {
                num = Integer.parseInt(numStr);

                // ending index of the number
                numEnd = line.length();

                boolean symbolFound = checkForSymbol(numStart, numEnd, lineNum);

                if (symbolFound) {
                    total += num;
                }
            }

        }



        return total;
    }



    private boolean checkForSymbol(int numStart, int numEnd, int lineNum) {


        // if a character isn't in this expression, skip
        String regex = "[^A-Za-z0-9. ]";

        try {
            String left = list.get(lineNum).charAt(numStart - 1) + "";

            if (left.matches(regex)) {
                return true;
            }
        } catch (IndexOutOfBoundsException e) {

            // don't need error handling as this will flow through
        } try {

            String right = list.get(lineNum).charAt(numEnd + 1) + "";

            if (right.matches(regex)) {
                return true;
            }

        }  catch (IndexOutOfBoundsException e) {

            // don't need error handling as this will flow through
        } try {

            String diagLeft = list.get(lineNum - 1).charAt(numStart - 1) + "";

            if (diagLeft.matches(regex)) {
                return true;
            }

        }  catch (IndexOutOfBoundsException e) {

            // don't need error handling as this will flow through
        } try {

            String diagRight = list.get(lineNum - 1).charAt(numEnd + 1) + "";

            if (diagRight.matches(regex)) {
                return true;
            }

        }   catch (IndexOutOfBoundsException e) {

            // don't need error handling as this will flow through
        } try {

            String diagUpLeft = list.get(lineNum + 1).charAt(numStart - 1) + "";

            if (diagUpLeft.matches(regex)) {
                return true;
            }

        }  catch (IndexOutOfBoundsException e) {

            // don't need error handling as this will flow through
        } try {

            String diagUpRight = list.get(lineNum + 1).charAt(numEnd + 1) + "";

            if (diagUpRight.matches(regex)) {
                return true;
            }

        }   catch (IndexOutOfBoundsException e) {

            // don't need error handling as this will flow through
        }

        // loop to check directly above each index and directly below

        for (int i = numStart; i < numEnd + 1; i++) {
            // check line above
            try {

                String up = list.get(lineNum - 1).charAt(i) + "";
                if (up.matches(regex)) {
                    return true;
                }


            } catch (IndexOutOfBoundsException e) {

            }
            // check line below
            try {

                String down = list.get(lineNum + 1).charAt(i) + "";
                if (down.matches(regex)) {
                    return true;
                }


            } catch (IndexOutOfBoundsException e) {

            }



        }



        return false;
    }


}
