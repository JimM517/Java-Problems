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



    // scoresSpecial
    public int scoresSpecial(int[] a, int[] b) {

       int largestInA = largestSpecialScore(a);
       int largestInB = largestSpecialScore(b);

       return largestInA + largestInB;


    }


    private int largestSpecialScore(int[] nums) {

        int largest = 0;

        for (int num : nums) {
            if (num % 10 == 0 && num > largest) {
                largest = num;
            }
        }


        return largest;

    }



    // sumHeights
    public int sumHeights(int[] heights, int start, int end) {
        int total = 0;

        for (int i = start; i < end; i++) {
            total += Math.abs(heights[i] - heights[i + 1]);
        }

        return total;
    }


    // sumHeights2
    public int sumHeights2(int[] heights, int start, int end) {
        int total = 0;

        for (int i = start; i < end; i++) {

            int heightChange = heights[i + 1] - heights[i];
            if (heightChange > 0) {
                total += heightChange * 2;
            } else {
                total += Math.abs(heightChange);
            }


        }
        return total;
    }



    public int bigHeights(int[] heights, int start, int end) {
        int total = 0;

       for (int i = start; i < end; i++) {
           int heightDiff = heights[i + 1] - heights[i];
           if (Math.abs(heightDiff) >= 5) {
               total++;
           }
       }
        return total;

    }


    // TODO userCompare -> correct for more than half, still failing two tests
    public int userCompare(String aName, int aId, String bName, int bId) {

        if (aName.compareTo(bName) < 0) {
            return -1;
        } else if (aName.compareTo(bName) > 0) {
            return 1;
        } else if (aId < bId) {
            return -1;
        } else if (aId > bId) {
            return 1;
        }

        return 0;
    }


    // TODO mergeTwo
    public String[] mergeTwo(String[] a, String[] b, int n) {

        String[] result = new String[n];

        int aIndex = 0;
        int bIndex = 0;
        int resultIndex = 0;


        while (resultIndex < n) {

            int compare = a[aIndex].compareTo(b[bIndex]);

            if (compare <= 0) {

                if (resultIndex == 0 || !a[aIndex].equals(result[resultIndex - 1])) {
                    result[resultIndex] = a[aIndex];
                    resultIndex++;
                }
                aIndex++;
            } else {
                if (resultIndex == 0 || !b[bIndex].equals(result[resultIndex - 1])) {
                    result[resultIndex] = b[bIndex];
                    resultIndex++;
                }
                bIndex++;
            }




        }
        return result;
    }


    // TODO commonTwo
    public int commonTwo(String[] a, String[] b) {

      int common = 0;

      int i = 0;
      int j = 0;

      while (i < a.length && j < b.length) {
          int compare = a[i].compareTo(b[j]);

          if (compare == 0) {
              common++;

              i++;
              j++;
          } else if (compare < 0) {
              i++;
          } else {
              j++;
          }
      }
      return common;

    }



    // countEvens
    public int countEvens(int[] nums) {

        int totalEvens = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                totalEvens++;
            }
        }
        return totalEvens;

    }

    // bigDiff
    public int bigDiff(int[] nums) {

        int smallest = nums[0];
        int largest = nums[0];

        for (int i = 1; i < nums.length; i++) {
            smallest = Math.min(smallest, nums[i]);
            largest = Math.max(largest, nums[i]);
        }
        return largest - smallest;

    }


    // centeredAverage
    public int centeredAverage(int[] nums) {

      // find smallest and largest in array
      int max = nums[0];
      int min = nums[0];

      int sum = 0;

      for (int i = 0; i < nums.length; i++) {
          sum += nums[i];

          max = Math.max(max, nums[i]);
          min = Math.min(min, nums[i]);
      }

      return (sum - max - min) / (nums.length - 2);


    }


    // sum13
    public int sum13(int[] nums) {

        int total = 0;
        int i = 0;

        while (i < nums.length) {
            if (nums[i] == 13) {
                i += 2;
            } else {
                total += nums[i];
                i++;
            }
        }
        return total;
    }


    // sum67
    public int sum67(int[] nums) {

        boolean inRange = false;
        int total = 0;

        for (int num : nums) {
            if (num == 6) {
                inRange = true;
            } else if (inRange && num == 7) {
                inRange = false;
            } else if (!inRange) {
                total += num;
            }
        }
        return total;
    }


    // has22
    public boolean has22(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] == 2 && nums[i + 1] == 2) {
                return true;
            }

        }
        return false;
    }


    // lucky13
    public boolean lucky13(int[] nums) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1 || nums[i] == 3) {
                count++;
            }
        }

        if (count > 0) {
            return false;
        }
        return true;

    }



    // sum28
    public boolean sum28(int[] nums) {

        int twentyEight = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 2) {
                twentyEight += nums[i];
            }
        }
        if (twentyEight == 8) {
            return true;
        }
        return false;

    }


    // more14
    public boolean more14(int[] nums) {

        int oneCount = 0;
        int fourCount = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 1) {
                oneCount++;
            }
            if (nums[i] == 4) {
                fourCount++;
            }
        }

        if (oneCount > fourCount) {
            return true;
        }
        return false;

    }


    // fizzArray
    public int[] fizzArray(int n) {

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = i;
        }
        return result;

    }


    // only14
    public boolean only14(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 1 && nums[i] != 4)
                return false;
        }

        return true;
    }


    // fizzArray2
    public String[] fizzArray2(int n) {

        String[] result = new String[n];


        for (int i = 0; i < n; i++) {
            result[i] = String.valueOf(i);
        }

        return result;
    }



    // no14
    public boolean no14(int[] nums) {

      boolean hasOne = false;
      boolean hasFour = false;


      for (int num : nums) {
          if (num == 1) {
              hasOne = true;
          }
          if (num == 4) {
              hasFour = true;
          }
      }

      return !(hasOne && hasFour);
    }


    // isEverywhere
    public boolean isEverywhere(int[] nums, int val) {

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != val && nums[i + 1] != val) {
                return false;
            }
        }
        return true;
    }




    // either24
    public boolean either24(int[] nums) {

        boolean found22 = false;
        boolean found44 = false;


        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] == 2 && nums[i + 1] == 2) {
                found22 = true;
            }

            if (nums[i] == 4 && nums[i + 1] == 4) {
                found44 = true;
            }


        }

        return (found22 || found44) && !(found22 && found44);

    }




    // matchUp
    public int matchUp(int[] nums1, int[] nums2) {


        int count = 0;

        for (int i = 0; i < nums1.length && i < nums2.length; i++) {


            int diff = Math.abs(nums1[i] - nums2[i]);

            if (diff <= 2 && diff > 0) {
                count++;
            }
        }


        return count;

    }


    // has77
     public boolean has77(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 7 && nums[i + 1] == 7) {
                return true;
            } else if (i < nums.length - 2 && nums[i] == 7 && nums[i + 2] == 7) {
                return true;
            }
        }

        return false;

     }


    // has12
    public boolean has12(int[] nums) {

        boolean foundAOne = false;

        for (int num : nums) {
            if (num == 1) {
                foundAOne = true;
            }
            if (foundAOne && num == 2) {
                return true;
            }
        }
        return false;
    }


    // modThree
    public boolean modThree(int[] nums) {
//
//        int oddCount = 0;
//        int evenCount = 0;


        for (int i = 0; i < nums.length - 2; i++) {
           if (nums[i] % 2 == 0) {
               if (nums[i + 1] % 2 == 0 && nums[i + 2] % 2 == 0) {
                   return true;
               }
           }
            if (nums[i] % 2 == 1) {
                if (nums[i + 1] % 2 == 1 && nums[i + 2] % 2 == 1) {
                    return true;
                }
            }

        }
        return false;


    }

    // haveThree
    public boolean haveThree(int[] nums) {

        int threeCount = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 3) {
                threeCount++;
                if (i > 0 && nums[i - 1] == 3) {
                    return false;
                }
            }


        }
        return threeCount == 3;


    }


    // twoTwo
    public boolean twoTwo(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 2) {
                if (i > 0 && nums[i - 1] == 2) {
                    continue;
                }
                if (i < nums.length - 1 && nums[i + 1] == 2) {
                    continue;
                }
                return false;
            }


        }

        return true;

    }


    // sameEnds
    public boolean sameEnds(int[] nums, int len) {

       int length = nums.length;


        if (len < 0 || len > length) {
            return false;
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] != nums[length - len + i]) {
                return false;
            }
        }

        return true;

    }

    //tripleUp
    public boolean tripleUp(int[] nums) {

        for (int i = 0; i < nums.length - 2; i++) {
           if (nums[i] + 1 == nums[i + 1] && nums[i + 1] + 1 == nums[i + 2]) {
               return true;
           }
        }

        return false;
    }


    // fizzArray3
    public int[] fizzArray3(int start, int end) {

        int len = end - start;
        int[] result = new int[end - start];

        int count = 0;

        while(start < end) {
            result[count] = start;
            count++;
            start++;
        }

        return result;

    }


    // shiftLeft
    public int[] shiftLeft(int[] nums) {
       // check length
      if (nums.length <= 1) {
          return nums;
      }

      // this will be first element, capture with variable
      int firstElement = nums[0];
      for (int i = 0; i < nums.length - 1; i++) {
          // shift everything to the left;
          nums[i] = nums[i + 1];
      }
      // swap out that last element
      nums[nums.length - 1] = firstElement;

      return nums;

    }



    // tenRun
    public int[] tenRun(int[] nums) {

        int[] result = new int[nums.length];

        boolean isInRange = false;

        int tenValue = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] % 10 == 0) {


                isInRange = true;
                tenValue = nums[i];
            }

            if (isInRange) {
                result[i] = tenValue;
            } else {
                result[i] = nums[i];
            }



        }
        return result;

    }



    // pre4
    public int[] pre4(int[] nums) {

        int len = 0;


        //first occurrence of 4 to determin length
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 4) {
                len = i;
                break;
            }
        }


        int[] result = new int[len];

        for (int i = 0; i < len; i++) {
            result[i] = nums[i];
        }

        return result;
    }


    // post4
    public int[] post4(int[] nums) {

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 4) {
                int[] res = new int[nums.length - i - 1];


                for (int j = 0; j < res.length; j++) {
                    res[j] = nums[i + j + 1];
                }
                return res;

            }
        }

        return null;
    }

    // notAlone
    public int[] notAlone(int[] nums, int val) {

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == val) {


                if (i > 0 && i < nums.length - 1 && nums[i - 1] != val && nums[i + 1] != val) {
                    result[i] = Math.max(nums[i - 1], nums[i + 1]);
                } else {
                    result[i] = nums[i];
                }

            } else {
                result[i] = nums[i];
            }



        }
        return result;
    }





    // zeroFront
    public int[] zeroFront(int[] nums) {

        int[] result = new int[nums.length];

        int zeroIndex = 0;

        for (int num : nums) {
            if (num == 0) {
                result[zeroIndex] = 0;
                zeroIndex++;
            }
        }



        for (int num : nums) {
            if (num != 0) {
                result[zeroIndex] = num;
                zeroIndex++;
            }
        }
        return result;
    }



    // withoutTen
    public int[] withoutTen(int[] nums) {

      int[] result = new int[nums.length];
      int zeroIndex = 0;

        // copying all elements that are not ten into result array
      for (int num : nums) {

          if (num != 10) {
              result[zeroIndex] = num;
              zeroIndex++;
          }
      }


    // filling in the remaining space with zeros
      while (zeroIndex < result.length) {
          result[zeroIndex] = 0;
          zeroIndex++;
      }
    return result;

    }



    // zeroMax
    public int[] zeroMax(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int maxOdd = 0;


                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] % 2 == 1 && nums[j] > maxOdd) {
                        maxOdd = nums[j];
                    }
                }

                if (maxOdd > 0) {
                    nums[i] = maxOdd;
                }
            }
        }
        return nums;
    }


    // maxSpan
    public int maxSpan(int[] nums) {

        int maxSpan = 0;

        for (int i = 0; i < nums.length; i++) {

            int value = nums[i];
            int firstOccurrence = i;
            int lastOccurence = i;



            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == value) {
                    lastOccurence = j;
                }
            }


            int span  = lastOccurence - firstOccurrence + 1;



            if (span > maxSpan) {
                maxSpan = span;
            }


        }

        return maxSpan;

    }



    // evenOdd
    public int[] evenOdd(int[] nums) {

        int[] result = new int[nums.length];
        int evenIndex = 0;

        for (int num : nums) {
            if (num % 2 == 0) {
                result[evenIndex] = num;
                evenIndex++;
            }
        }



        for (int num : nums) {
            if (num % 2 == 1) {
                result[evenIndex] = num;
                evenIndex++;
            }
        }

        return result;

    }



    // fizzBuzz
    public String[] fizzBuzz(int start, int end) {

        int len = end - start;
        String[] results = new String[len];


        for (int i = start; i < end; i++) {

            int index = i - start;

            if (i % 5 == 0 && i % 3 == 0) {
                results[index] = "FizzBuzz";
            } else if (i % 5 == 0) {
                results[index] = "Buzz";
            } else if (i % 3 == 0) {
                results[index] = "Fizz";
            } else {
                results[index] = String.valueOf(i);
            }



        }


        return results;

    }

    /******* Medium and Harder string method problems below ********/


    // doubleChar
    public String doubleChar(String str) {

        String result = "";

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);
            result += String.valueOf(str.charAt(i)) + String.valueOf(str.charAt(i));
        }
        return result;
    }



    // countHi

    public int countHi(String str) {

        int count = 0;


        if (str.length() < 2) {
            return 0;
        }

        for (int i = 0; i < str.length() - 1; i++) {

            if (str.charAt(i) == 'h' && str.charAt(i + 1) == 'i') {
                count++;
            }


        }


        return count;
    }



    // catDog
    public boolean catDog(String str) {

        int catCount = 0;
        int dogCount = 0;


        String catSub = "cat";
        String dogSub = "dog";

        int index = 0;

        while (index < str.length()) {

            if (str.indexOf(catSub, index) == index) {
                catCount++;
                index += catSub.length();
            } else if (str.indexOf(dogSub, index) == index) {
                dogCount++;
                index += dogSub.length();
            } else {
                index++;
            }


        }



        return catCount == dogCount;
    }


    // makeOutWord
    public String makeOutWord(String out, String word) {

        String first = out.substring(0, out.length() / 2);
        String second = out.substring(out.length() / 2);



        return first + word + second;


    }




    // extraEnd
    public String extraEnd(String str) {

        String end = str.substring(str.length() - 2);

        return end + end + end;


    }

    // firstTwo
    public String firstTwo(String str) {

        if (str.length() < 2) {
            return str;
        }
        return str.substring(0, 2);
    }


    // right2
    public String right2(String str) {

        String lastTwo = str.substring(str.length() - 2);
        String rest = str.substring(0, str.length() - 2);


        return lastTwo + rest;
    }



    // theEnd
    public String theEnd(String str, boolean front) {

        String result = "";

        if (front) {
            result = str.substring(0, 1);
        } else {
            result = str.substring(str.length() - 1);
        }

        return result;
    }


    // withouEnd2
    public String withouEnd2(String str) {

        if (str.length() > 2) {
            return str.substring(1, str.length() - 1);
        } else {
            return "";
        }
    }



    // middleTwo
    public String middleTwo(String str) {

        if (str.length() < 2) {
            return str;
        }

        return str.substring((str.length() / 2) - 1, (str.length() / 2) + 1);

    }


    // nTwice
    public String nTwice(String str, int n) {

        if (str.length() < n) {
            return str;
        }


        return str.substring(0, n) + str.substring(str.length() - n);
    }


    // twoChar
    public String twoChar(String str, int index) {

        if (index < 0 || index + 2 > str.length()) {
            return str.substring(0, 2);
        }

        return str.substring(index, index + 2);


    }


    // middleThree
    public String middleThree(String str) {

        if (str.length() < 3) {
            return str;
        }

        return str.substring((str.length() / 2 - 1), (str.length() / 2 + 2));

    }


    //hasBad
    public boolean hasBad(String str) {
        if (str.length() >= 3 && (str.substring(0, 3).equals("bad") || (str.length() >= 4 && str.substring(1, 4).equals("bad")))) {
            return true;
        }
        return false;
    }


    // lastChars
    public String lastChars(String a, String b) {

        if (a.length() == 0 && b.length() == 0) {
            return "@@";
        }

        if (a.length() == 0) {
            return "@" + b.substring(b.length() - 1);
        }
        if (b.length() == 0) {
            return a.substring(0, 1) + "@";
        }



        return a.substring(0, 1) + b.substring(b.length() - 1);


    }

    // conCat
    public String conCat(String a, String b) {

        if (a.length() == 0) {
            return b;
        }

        if (b.length() == 0) {
            return a;
        }

        if (a.substring(a.length() - 1).equals(b.substring(0, 1))) {
            return a.substring(0, 2) + b;
        }

        return a + b;

    }


    // lastTwo
    public String lastTwo(String str) {

        if (str.length() < 2) {
            return str;
        }

        char first = str.charAt(str.length() - 1);
        char second = str.charAt(str.length() - 2);

        return str.substring(0, str.length() - 2) + first + second;
    }


    // seeColor
    public String seeColor(String str) {

      if (str.startsWith("red")) {
          return "red";
      } else if (str.startsWith("blue")) {
          return "blue";
      } else {
          return "";
      }
    }



    // frontAgain
    public boolean frontAgain(String str) {

        if (str.length() < 2) {
            return false;
        }

        return str.substring(0, 2).equals(str.substring(str.length() - 2));

    }


    // minCat
    public String minCat(String a, String b) {


        int aLen = a.length();
        int bLen = b.length();

        if (a.length() > b.length()) {
            return a.substring(aLen - bLen) + b;
        } else if (b.length() > a.length()) {
            return a + b.substring(bLen - aLen);
        } else {
            return a + b;
        }

    }


    // extraFront
    public String extraFront(String str) {

        if (str.length() < 2) {
            return str + str + str;
        }

        String firstTwo = str.substring(0, 2);
        return firstTwo + firstTwo + firstTwo;
    }

    // without2
    public String without2(String str) {

        if (str.length() >= 2 && str.substring(0, 2).equals(str.substring(str.length() - 2))) {
            return str.substring(2);
        } else {
            return str;
        }

    }

    // deFront
    public String deFront(String str) {

       if (str.length() == 1 && str.charAt(0) != 'a') {
           return "";
       }

       if (str.length() >= 2) {
           if (str.charAt(0) != 'a' && str.charAt(1) != 'b') {
               return str.substring(2);
           } else if (str.charAt(0) != 'a') {
               return str.substring(1);
           } else if (str.charAt(1) != 'b') {
               return "a" + str.substring(2);
           }
       }
        return str;

    }


    // startWord
    public String startWord(String str, String word) {

        if (str.length() >= 1 && word.length() >= 1) {
            char strFirstChar = str.charAt(0);
            char wordFirstChar = word.charAt(0);


            if (str.substring(1).startsWith(word.substring(1))) {
                return strFirstChar + word.substring(1);
            }


        }

        return "";
    }


    // withoutX
    public String withoutX(String str) {

        if (str.length() >= 1) {
            if (str.charAt(0) == 'x') {
                str = str.substring(1);
            }
            if (str.length() >= 1 && str.charAt(str.length() - 1) == 'x') {
                str = str.substring(0, str.length() - 1);
            }
        }
        return str;
    }


    // wihtoutX2
    public String withoutX2(String str) {
        if (str.length() == 1 && str.charAt(0) == 'x') {
            return "";
        }


        if (str.length() >= 2) {
            if (str.charAt(0) == 'x' && str.charAt(1) == 'x') {
                return str.substring(2);
            } else if (str.charAt(0) == 'x') {
                return str.substring(1);
            } else if (str.charAt(1) == 'x') {
                return str.charAt(0) + str.substring(2);
            }
        }

        return str;
    }



    // countCode
    public int countCode(String str) {

//        String codePattern = "co[a-z]e";
//        int count = 0;
//
//
//        Matcher matcher = Pattern.compile(codePattern).matcher(str);
//
//        while(matcher.find()) {
//            count++;
//        }

        int count = 0;
        for (int i = 0; i < str.length() - 3; i++) {
            if (str.charAt(i) == 'c' && str.charAt(i + 1) == 'o' && str.charAt(i + 3) == 'e' && Character.isLowerCase(str.charAt(i + 2))) {
                count++;
            }
        }

        return count;
    }


    // endOther
    public boolean endOther(String a, String b) {

        a = a.toLowerCase();
        b = b.toLowerCase();


        return a.endsWith(b) || b.endsWith(a);

    }



    // xyzThere
    public boolean xyzThere(String str) {

       if (str.length() >= 3 && str.substring(0, 3).equals("xyz")) {
           return true;
       }

       for (int i = 1; i < str.length() - 2; i++) {
           if (str.charAt(i - 1) != '.' && str.substring(i, i + 3).equals("xyz")) {
               return true;
           }
       }
        return false;
    }



    // bobThere
    public boolean bobThere(String str) {

      for (int i = 0; i < str.length() - 2; i++) {
          if (str.charAt(i) == 'b' && str.charAt(i + 2) == 'b') {
              return true;
          }
      }

        return false;
    }



    // xyBalance
    public boolean xyBalance(String str) {

        boolean hasY = false;


        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == 'y') {
                hasY = true;
            }


            if (str.charAt(i) == 'x' && !hasY) {
                return false;
            }
        }
      return true;
    }


    // mixString
    public String mixString(String a, String b) {


        StringBuilder result = new StringBuilder();


        int maxLength = Math.max(a.length(), b.length());


        for (int i = 0; i < maxLength; i++) {
            if (i < a.length()) {
                result.append(a.charAt(i));
            }
            if (i < b.length()) {
                result.append(b.charAt(i));
            }
        }
        return result.toString();
    }


    // repeatEnd
    public String repeatEnd(String str, int n) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(str.substring(str.length() - n));
        }

        return sb.toString();
    }


    // repeatFront
    public String repeatFront(String str, int n) {

        StringBuilder sb = new StringBuilder();

        int len = 0;

       while (n > 0) {
           sb.append(str.substring(0, n));
           n--;
       }

        return sb.toString();
    }


    // repeatSeparator
    public String repeatSeparator(String word, String sep, int count) {

        if (count == 0) {
            return "";
        }


        StringBuilder sb = new StringBuilder();


        for (int i = 1; i < count; i++) {
            sb.append(word).append(sep);
        }

        sb.append(word);

        return sb.toString();

    }


    // prefixAgain
    public boolean prefixAgain(String str, int n) {

            for (int i = 1; i <= str.length() - n; i++) {

                String pre = str.substring(0, n);
                String sub = str.substring(i, i + n);

                if (pre.equals(sub)) {
                    return true;
                }


            }
            return false;

    }



    // xyzMiddle
    public boolean xyzMiddle(String str) {

        if (str.length() < 3) {
            return false;
        }



        int start1 = str.length() / 2 - 2;
        int start2 = str.length() / 2 - 1;

        if (str.length() % 2 == 0) {
            return str.substring(start1, start1 + 3).equals("xyz") || str.substring(start2, start2 + 3).equals("xyz");

        }

        return str.startsWith("xyz", start2);
    }



    // getSandwich
    public String getSandwich(String str) {

        // find first instance of bread, get next word, stop at bread

       int firstOcc = str.indexOf("bread");
       int lastOcc = str.lastIndexOf("bread");


       if (firstOcc != -1 && lastOcc != -1 && firstOcc != lastOcc) {
           return str.substring(firstOcc + 5, lastOcc);
       } else {
           return "";
       }


    }


    // sameStarChar
    public boolean sameStarChar(String str) {

        for (int i = 1; i < str.length() - 1; i++) {
            if (str.charAt(i) == '*') {
                if (str.charAt(i - 1) != str.charAt(i + 1)) {
                    return false;
                }
            }
        }
        return true;
    }


































































}
