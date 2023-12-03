package Advent2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayThree {

    public static void main(String[] args) {

        String fPath = "src/InputFiles/";

        File file = new File(fPath + "DayThreeSample.txt");

        int total = 0;

        try {
            Scanner sc = new Scanner(file);

            while (sc.hasNext()) {
                // get each line


                String line = sc.nextLine();

                int checkStr = parseSymbols(line);

                System.out.println(checkStr);

//                total += checkStr;

            }
            System.out.println("The total is " + total);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }






    public static int parseSymbols(String line) {

        int result = 0;

        char[] symbols = {'@', '*', '$', '#', '&', '%', '/', '+', '-', '='};


        String patternString = "\\b\\d+\\s*[" + new String(symbols) + "]\\b";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(line);


        while(matcher.find()) {

            int start = matcher.start();
            int end = matcher.end();


            if ((start > 0 && isSymbol(line.charAt(start - 1))) || (end < line.length() && isSymbol(line.charAt(end)))) {
                // Extract the number from the match and add to the total
                String match = matcher.group();
                result += Integer.parseInt(match.replaceAll("[^\\d]", ""));
            }



        }

        return result;
    }




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



