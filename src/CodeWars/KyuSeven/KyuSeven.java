package CodeWars.KyuSeven;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KyuSeven {

    // change two-dimensional array
    public int[][] matrix(int[][] array) {

        for (int i = 0; i < array.length; i++) {

            if (array[i][i] < 0) {
                array[i][i] = 0;
            } else {
                array[i][i] = 1;
            }


        }

        return array;

    }






    // character counter
    public boolean validateWord(String word) {

        String lower = word.toLowerCase();

        Map<Character, Integer> charMap = new HashMap<>();

        for (Character idx : lower.toCharArray()) {

            charMap.put(idx, charMap.getOrDefault(idx, 0) + 1);
        }


        List<Integer> charCount = new ArrayList<>(charMap.values());


        for (int i = 0; i < charCount.size() - 1; i++) {
            if (charCount.get(i) != charCount.get(i + 1)) {
                return false;
            }
        }


        return true;


    }



















}
