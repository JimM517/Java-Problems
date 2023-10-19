package CodingBat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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



    // scoresAverage
    public int scoresAverage(int[] scores) {

        int firstHalf = average(scores, 0, scores.length / 2);
        int secondHalf = average(scores, scores.length / 2, scores.length);

        if (firstHalf > secondHalf) {
            return firstHalf;
        } else {
            return secondHalf;
        }

    }

    private int average(int[] scores, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += scores[i];
        }
        // number of scores that are calculated in the average
        int count = end - start;

        return sum / count;

    }



    // wordsCount
    public int wordsCount(String[] words, int len) {

        int total = 0;

        for (int i = 0; i < words.length; i++) {

            if (words[i].length() == len) {
                total++;
            }

        }

        return total;

    }



    // wordsFront
    public String[] wordsFront(String[] words, int n) {

        String[] results = new String[n];

        for (int i = 0; i < n; i++) {
            results[i] = words[i];
        }
        return results;

    }



    // wordsWithoutList
    public List wordsWithoutList(String[] words, int len) {

        List<String> results = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {

            if (words[i].length() == len) {
                continue;
            }
            results.add(words[i]);
        }

        return results;

    }


    // hasOne
    public boolean hasOne(int n) {

      while (n > 0) {
          int digit = n % 10;
          if (digit == 1) {
              return true;
          }
          n /= 10;
      }
        return false;
    }


    // dividesSelf
    public boolean dividesSelf(int n) {

        int original = n;


        while(n > 0) {

            int firstDiv = n % 10;

            if (firstDiv == 0 || original % firstDiv != 0) {
                return false;
            }


            n /= 10;
        }

        return true;

    }


    // copyEvens
    public int[] copyEvens(int[] nums, int count) {

        int[] result = new int[count];
        int evens = 0;

        for (int i = 0; evens < count && i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                result[evens] = nums[i];
                evens++;
            }
        }

        return result;

    }


    // copyEndy
    public int[] copyEndy(int[] nums, int count) {

        int[] result = new int[count];
        int endyCount = 0;

        for (int i = 0; endyCount < count && i < nums.length; i++) {
            if (isEndy(nums[i])) {
                result[endyCount] = nums[i];
                endyCount++;
            }
        }
        return result;

    }


    private boolean isEndy(int n) {

        if ((n >= 0 && n <= 10) || (n >= 90 && n <= 100)) {
            return true;
        }
        return false;

    }


    // matchUp
    public int matchUp(String[] a, String[] b) {

        int matchCount = 0;

        for (int i = 0; i < a.length && i < b.length; i++) {

            if (!a[i].equals("") && !b[i].equals("")) {
                if (a[i].charAt(0) == b[i].charAt(0)) {
                    matchCount++;
                }
            }


        }
        return matchCount;

    }

    // scoreUp
    public int scoreUp(String[] key, String[] answers) {

        int total = 0;

        for (int i = 0; i < key.length && i < answers.length; i++) {

            if (answers[i].equals("?")) {
                continue;
            } else if (answers[i].equals(key[i])) {
                total += 4;
            } else {
                total -= 1;
            }


        }
        return total;

    }


    // wordsWithout
    public String[] wordsWithout(String[] words, String target) {

        int count = 0;



        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                count++;
            }
        }

        String[] result = new String[words.length - count];

        int j = 0;
        for (int i = 0; i < words.length; i++) {
            if (!words[i].equals(target)) {
                result[j] = words[i];
                j++;
            }
        }


        return result;
    }
















}
