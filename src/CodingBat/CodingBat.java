package CodingBat;

import java.util.HashMap;
import java.util.Map;

public class CodingBat {


    // mapBully
    public Map<String, String> mapBully(Map<String, String> map) {

        if (map.containsKey("a")) {
            map.put("b", map.get("a"));

            map.put("a", "");
        }

        return map;

    }



    // mapShare
    public Map<String, String> mapShare(Map<String, String> map) {

        if (map.containsKey("a")) {
            map.put("b", map.get("a"));
        }

        map.remove("c");

        return map;

    }


    // mapAb
    public Map<String, String> mapAB(Map<String, String> map) {

        if (map.containsKey("a") && map.containsKey("b")) {

            String abValue = map.get("a") + map.get("b");

            map.put("ab", abValue);
        }
        return map;
    }


    // topping1
    public Map<String, String> topping1(Map<String, String> map) {

        if (map.containsKey("ice cream")) {
            map.put("ice cream", "cherry");
        }
        map.put("bread", "butter");

        return map;



    }



    // topping2
    public Map<String, String> topping2(Map<String, String> map) {
        if (map.get("ice cream") != null) {
            map.put("yogurt", map.get("ice cream"));
        }
        if (map.get("spinach") != null) {
            map.put("spinach", "nuts");
        }


        return map;

    }


    // topping3
    public Map<String, String> topping3(Map<String, String> map) {

        if (map.get("potato") != null) {
            map.put("fries", map.get("potato"));
        }
        if (map.get("salad") != null) {
            map.put("spinach", map.get("salad"));
        }
        return map;

    }


    // mapAB2
    public Map<String, String> mapAB2(Map<String, String> map) {

        if ((map.containsKey("a") && map.containsKey("b")) && (map.get("a").equals(map.get("b")))) {
            map.remove("a");
            map.remove("b");
        }
        return map;

    }


    // mapAB3
    public Map<String, String> mapAB3(Map<String, String> map) {

        if (map.containsKey("a") && !map.containsKey("b")) {
            map.put("b", map.get("a"));
        }

        if (map.containsKey("b") && !map.containsKey("a")) {
            map.put("a", map.get("b"));
        }
        return map;


    }



    // mapAB4
    public Map<String, String> mapAB4(Map<String, String> map) {
        if (map.containsKey("a") && map.containsKey("b")) {
            int a = map.get("a").length();
            int b = map.get("b").length();
            if (a > b) {
                map.put("c", map.get("a"));
            } else if (b > a) {
                map.put("c", map.get("b"));
            } else {
                map.put("a", "");
                map.put("b", "");
            }
        }
        return map;
    }


    // word0
    public Map<String, Integer> word0(String[] strings) {

        Map<String, Integer> results = new HashMap<>();

        for (int i = 0; i < strings.length; i++) {
            results.put(strings[i], 0);
        }
        return results;

    }


    // wordLen
    public Map<String, Integer> wordLen(String[] strings) {

        Map<String, Integer> results = new HashMap<>();

        for (int i = 0; i < strings.length; i++) {
            if (results.containsKey(strings[i])) {
                continue;
            } else {
                results.put(strings[i], strings[i].length());
            }
        }
        return results;

    }


    // pairs
    public Map<String, String> pairs(String[] strings) {

        Map<String, String> results = new HashMap<>();


        for (int i = 0; i < strings.length; i++) {
            results.put(strings[i].substring(0, 1), strings[i].substring(strings[i].length() - 1));
        }

        return results;
    }

    // wordCount
    public Map<String, Integer> wordCount(String[] strings) {

        Map<String, Integer> results = new HashMap<>();

        for (int i = 0; i < strings.length; i++) {

            results.put(strings[i], results.getOrDefault(strings[i], 0) + 1);

        }

        return results;
    }

    // firstChar
    public Map<String, String> firstChar(String[] strings) {

        Map<String, String> results = new HashMap<>();


        for (int i = 0; i < strings.length; i++) {

            String firstChar = strings[i].substring(0, 1);

            if (results.containsKey(firstChar)) {
                results.put(firstChar, results.get(firstChar) + strings[i]);
            } else {
                results.put(firstChar, strings[i]);
            }

        }

        return results;
    }


    // wordAppend
    public String wordAppend(String[] strings) {

        Map<String, Integer> count = new HashMap<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < strings.length; i++) {

            count.put(strings[i], count.getOrDefault(strings[i], 0) + 1);

            if (count.get(strings[i]) % 2 == 0) {
                sb.append(strings[i]);
            }


        }

        return sb.toString();
    }



    // wordMultiple
    public Map<String, Boolean> wordMultiple(String[] strings) {

        Map<String, Boolean> results = new HashMap<>();

        for (int i = 0; i < strings.length; i++) {

            if (results.containsKey(strings[i])) {
                results.put(strings[i], true);
            } else {
                results.put(strings[i], false);
            }


        }
        return results;

    }


    // allSwap
    public String[] allSwap(String[] strings) {

        Map<String, Integer> results = new HashMap<>();

        for (int i = 0; i < strings.length; i++) {

            String key = String.valueOf(strings[i].charAt(0));

            if (results.containsKey(key)) {

                int curr = results.get(key);
                String temp = strings[curr];
                strings[curr] = strings[i];
                strings[i] = temp;

                results.remove(key);

            } else {
                results.put(key, i);
            }


        }
        return strings;
    }


    // firstSwap
    public String[] firstSwap(String[] strings) {

        Map<String, Integer> results = new HashMap<>();

        for (int i = 0; i < strings.length; i++) {

            String key = String.valueOf(strings[i].charAt(0));

            if (results.containsKey(key)) {
                int index = results.get(key);


                if (index != -1) {
                    String temp = strings[i];
                    strings[i] = strings[index];
                    strings[index] = temp;



                    results.put(key, -1);
                }

            } else {
                results.put(key, i);
            }

        }

        return strings;

    }


    // scoresIncreasing
    public boolean scoresIncreasing(int[] scores) {

        for (int i = 0; i < scores.length - 1; i++) {
            if (scores[i] > scores[i + 1]) {
                return false;
            }
        }
        return true;
    }


    // scores100
    public boolean scores100(int[] scores) {

        for (int i = 0; i < scores.length - 1; i++) {

            if ((scores[i] == 100) && (scores[i + 1] == 100)) {
                return true;
            }


        }

        return false;
    }



    // scoresClump
    public boolean scoresClump(int[] scores) {

        for (int i = 0; i < scores.length - 2; i++) {

            if ((scores[i + 1] - scores[i] <= 2) && (scores[i + 2] - scores[i] <= 2)) {
                return true;
            }


        }
        return false;
    }










}
