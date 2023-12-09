package Advent2023;

import Advent2023.model.CamelCard;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DaySeven {


    public static void main(String[] args) {

        String fPath = "src/InputFiles/";

        File file = new File(fPath + "DaySevenInput.txt");

        List<CamelCard> camelCardList = new ArrayList<>();

        try {
            Scanner sc = new Scanner(file);

            while (sc.hasNext()) {

                String line = sc.nextLine();

                String[] parts = line.split(" ");

                String card = parts[0];

                int bid = Integer.parseInt(parts[1]);

                CamelCard temp = new CamelCard(card, bid);

                char[] tempArray = card.toCharArray();
                Arrays.sort(tempArray);
                temp.setSortedCard(new String (tempArray));

                camelCardList.add(temp);
            }
            Collections.sort(camelCardList);

            long total = 0;

            for (int i = 1; i < camelCardList.size(); i++) {
                int cardTotal = camelCardList.get(i).getBid() * (i + 1);
                total += cardTotal;
            }
            System.out.println(total);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }





}
