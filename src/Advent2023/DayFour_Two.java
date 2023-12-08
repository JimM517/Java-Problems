package Advent2023;

import Advent2023.model.LotteryCard;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DayFour_Two {

    public static void main(String[] args) {

        String fPath = "src/InputFiles/";

        File file = new File(fPath + "DayFourInput.txt");

        List<LotteryCard> lotteryCardList = new ArrayList<>();

        int gameNum = 0;

        try {

            Scanner sc = new Scanner(file);

            int total = 0;

            while (sc.hasNext()) {

                String line = sc.nextLine();

                gameNum++;

                String[] cards = line.split("\\|");

                int winningNumIndex = cards[0].indexOf(": ");

                String winningNumStr = cards[0].substring(winningNumIndex + 2);

                List<Integer> winningList = getNums(winningNumStr);

                List<Integer> elfList = getNums(cards[1]);




                total = compareLists(winningList, elfList);

                // System.out.println(gameNum + " : " + total);

                lotteryCardList.add(new LotteryCard(gameNum, total));

            }
           int totalCards = calculateTicketTotal(lotteryCardList);

            System.out.println(totalCards);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }




    }





    public static int calculateTicketTotal(List<LotteryCard> list) {

        for (int i = 0; i < list.size(); i++) {

            LotteryCard card = list.get(i);

            for (int copies = 0; copies <= card.getNumOfCards(); copies++) {

                    for (int wins = 1; wins <= card.getOriginalWins(); wins++) {
                        // gives back internal wins
                        LotteryCard cardToAddWins = list.get(i + wins);

                        int numOfCards = cardToAddWins.getNumOfCards();
                        numOfCards++;

                        cardToAddWins.setNumOfCards(numOfCards);

                    }



            }

        }


        int total = 0;

        for (LotteryCard card : list) {
            int count = card.getNumOfCards();
            total += count + 1;

        }


        return total;
    }



    public static List<Integer> getNums(String listNums) {

        String[] nums = listNums.split(" ");

        List<Integer> list = new ArrayList<>();

        for (String num : nums) {

            try {

                list.add(Integer.parseInt(num));



            } catch (NumberFormatException e) {
                // skip because it is a space
            }




        }


        return list;

    }


    public static int compareLists(List<Integer> winningList, List<Integer> elfList) {


        Collections.sort(winningList);
        Collections.sort(elfList);

        int matchCount = 0;



        for (int winNum : winningList) {

            for (int elfNum : elfList) {

                if (winNum == elfNum) {
                    // have a match
                    matchCount++;
                }


            }



        }
        return matchCount;

    }



}
