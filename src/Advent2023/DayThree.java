package Advent2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayThree {

    private List<String> list = new ArrayList<>();

    public static void main(String[] args) {

        DayThree app = new DayThree();

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





//    public static int parseSymbols(String line) {
//
//        int result = 0;
//
//        char[] symbols = {'@', '*', '$', '#', '&', '%', '/', '+', '-', '='};
//
//
//        String patternString = "\\b\\d+\\s*[" + new String(symbols) + "]\\b";
//        Pattern pattern = Pattern.compile(patternString);
//        Matcher matcher = pattern.matcher(line);
//
//
//        while(matcher.find()) {
//
//            int start = matcher.start();
//            int end = matcher.end();
//
//
//            if ((start > 0 && isSymbol(line.charAt(start - 1))) || (end < line.length() && isSymbol(line.charAt(end)))) {
//                // Extract the number from the match and add to the total
//                String match = matcher.group();
//                result += Integer.parseInt(match.replaceAll("[^\\d]", ""));
//            }
//
//
//
//        }
//
//        return result;
//    }




    private static boolean isSymbol(char c) {

        char[] symbols = {'@', '*', '$', '#', '&', '%', '/', '+', '-', '='};

        for (char sym : symbols) {
            if (c == sym) {
                return true;
            }
        }

        return false;
    }





}



