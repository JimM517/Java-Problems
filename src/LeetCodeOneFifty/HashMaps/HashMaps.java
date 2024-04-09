package LeetCodeOneFifty.HashMaps;

import java.util.*;

public class HashMaps {

    /*** Hashmap problems from leet code 150 ***/



    // 383 Ransom Note
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> result = new HashMap<>();

        for (Character c : magazine.toCharArray()) {

            if (!result.containsKey(c)) {
                result.put(c, 1);
            } else {
                result.put(c, result.get(c) + 1);
            }

        }



        for (Character c : ransomNote.toCharArray()) {

            if (result.containsKey(c) && result.get(c) > 0) {
                result.put(c, result.get(c) - 1);
            } else {
                return false;
            }



        }


        return true;



    }





    // 205. Isomorphic Strings
    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }


        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Boolean> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if (map1.containsKey(ch1)) {
                if (map1.get(ch1) != ch2) {
                    return false;
                }
            } else {
                if (map2.containsKey(ch2)) {
                    return false;
                } else {
                    map1.put(ch1, ch2);
                    map2.put(ch2, true);
                }
            }
        }
        return true;
    }






    // 290. Word Pattern
    public boolean wordPattern(String pattern, String s) {

        String[] arr = s.split(" ");

        if (pattern.length() != arr.length) {
            return false;
        }


        Map<Character, String> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            char c = pattern.charAt(i);

            String str = arr[i];

            if (map.containsKey(c)) {
                if (!map.get(c).equals(str)) {
                    return false;
                }
            } else {
                if (map.containsValue(str)) {
                    return false;
                }
                map.put(c, str);
            }
        }
        return true;
    }



    // 242. Valid Anagram
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();

        Map<Character, Integer> tMap = new HashMap<>();

        for (Character ch : s.toCharArray()) {
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
        }

        for (Character cha : t.toCharArray()) {
            tMap.put(cha, tMap.getOrDefault(cha, 0) + 1);
        }

        return sMap.equals(tMap);



    }





    // 49. Group Anagrams
    public List<List<String>> groupAnagrams(String[] strs) {


        Map<String, List<String>> checkAnagram = new HashMap<>();

        for (String curr : strs) {

            char[] chr = curr.toCharArray();

            Arrays.sort(chr);

            String sortedWord = new String(chr);

            if (!checkAnagram.containsKey(sortedWord)) {
                checkAnagram.put(sortedWord, new ArrayList<>());
            }

            checkAnagram.get(sortedWord).add(curr);

        }

        return new ArrayList<>(checkAnagram.values());


    }




    // 1. obligatory Two Sum
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }


        }

        return new int[]{-1, -1};



    }





    // 202. Happy Number
    public boolean isHappy(int n) {

        Map<Integer, Integer> result = new HashMap<>();


        while (n != 1 && !result.containsKey(n)) {

            result.put(n, 0);

            String str = String.valueOf(n);

            int sum = 0;

            for (int i = 0; i < str.length(); i++) {

                int digit = Character.getNumericValue(str.charAt(i));

                sum += digit * digit;

            }

            n = sum;

        }



        return n == 1;


    }







    // 219. Contains duplicates two
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int currVal = nums[i];

            if (map.containsKey(currVal) && i - map.get(currVal) <= k) {
                return true;
            }

            map.put(currVal, i);


        }

        return false;
    }





    // 128. Longest consecutive sequence
    public int longestConsecutive(int[] nums) {

        Set<Integer> numSet = new HashSet<>();

        for (int num : nums) {
            numSet.add(num);
        }



        int longest = 0;

        for (int num : nums) {

            int next = num + 1;
            int prev = num - 1;
            int current = 1;

            while (numSet.remove(prev--)) {
                current++;
            }

            while (numSet.remove(next++)) {
                current++;
            }

            if (current > longest) {
                longest = current;
            }

        }

        return longest;
    }

}
