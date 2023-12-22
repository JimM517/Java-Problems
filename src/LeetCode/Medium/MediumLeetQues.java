package LeetCode.Medium;

import java.util.*;

public class MediumLeetQues {


    // 7. Reverse Integer

    public int reverse(int x) {

        boolean isNegative = x < 0;


        long num = Math.abs((long) x);


        long reversed = 0;
        while (num > 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }


        if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
            return 0;
        }


        if (isNegative) {
            reversed = -reversed;
        }

        return (int) reversed;


    }



    // 334. increasing triplet subsequence
    public boolean increasingTriplet(int[] nums) {

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;


        for (int num : nums) {
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
            } else {
                return true;
            }
        }

        return false;

    }



    // 392. Is subsequence
    public boolean isSubsequence(String s, String t) {

        int sPointer = 0;

        for (int tPointer = 0; tPointer < t.length() && sPointer < s.length(); tPointer++) {
            if (s.charAt(sPointer) == t.charAt(tPointer)) {
                sPointer++;
            }
        }

        return sPointer == s.length();


    }



    // 153. Find Minimum in Rotated Sorted Array

    public int findMin(int[] nums) {
        // need in O(log n)
        int left = 0;
        int right = nums.length - 1;


        while (left < right) {

            int mid = left + (right - left) / 2;


            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }
        return nums[left];

    }





    // 3. Longest Substring without repeating characters
    public int lengthOfLongestSubstring(String s) {

        // sliding window
        // O(n)

        Set<Character> characterSet = new HashSet<>();

        int left = 0;
        int right = 0;

        int count = 0;

        while (right < s.length()) {

            if (characterSet.contains(s.charAt(right))) {
               characterSet.remove(s.charAt(left));
               left++;
            } else {
                characterSet.add(s.charAt(right));
                count = Math.max(count, right - left + 1);
                right++;
            }


        }


        return count;



    }



    // 424. longest repeating character replacement
    public int characterReplacement(String s, int k) {

        // O(n)
        // sliding window
        // the longest substring that contains a single character
        // HashMap

        int left = 0;
        int right = 0;

        int result = 0;
        int maxCount = 0;

        Map<Character, Integer> charMap = new HashMap<>();


        while (right < s.length()) {

            charMap.put(s.charAt(right), charMap.getOrDefault(s.charAt(right), 0) + 1);

            maxCount = Math.max(maxCount, charMap.get(s.charAt(right)));


            if ((right - left + 1) - maxCount > k) {
                charMap.put(s.charAt(left), charMap.get(s.charAt(left) - 1));
                left++;
            }

            result = Math.max(result, right - left + 1);
            right++;


        }

        return result;
    }



    // 567. Permutation in String

    public boolean checkInclusion(String s1, String s2) {

        // sliding window

        // check length because is s1 is greater it's impossible for s1 to be a permutation
        if (s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> stringOne = new HashMap<>();
        Map<Character, Integer> stringTwo = new HashMap<>();

        // populate the s1 map
        for (char c : s1.toCharArray()) {
            stringOne.put(c, stringOne.getOrDefault(c, 0) + 1);
        }

        // subtract length from s2 to ensure there are valid number of characters
        for (int i = 0; i <= s2.length() - s1.length(); i++) {

            String subString = s2.substring(i, i + s1.length());

            // populate stringTwo map with the substring characters
            for (char s : subString.toCharArray()) {
                stringTwo.put(s, stringTwo.getOrDefault(s, 0) + 1);
            }

            // if maps are equal, true
            if (stringOne.equals(stringTwo)) {
                return true;
            } else {
                stringTwo.clear();
            }



        }
        return false;
    }



    // 153. Find Minimum in Rotated Sorted Array
    public int findMinAgain(int[] nums) {

        int left = 0;
        int right = nums.length - 1;


        while (left < right) {


            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }

        return nums[left];


    }


    // 49. Group Anagrams

    public List<List<String>> groupAnagrams(String[] strs) {

        // map where key is the sorted word, and the list is all the words that are anagrams
        Map<String, List> testAnagram = new HashMap<>();

        // loop through strs array
        for (String word : strs) {

            // split each word into char array
            char[] chars = word.toCharArray();

            // sort chars
            Arrays.sort(chars);

            // change word back to string
            String sortedWord = new String(chars);

            // if the map doesn't contain the sorted word, we add it
            if (!testAnagram.containsKey(sortedWord)) {
                testAnagram.put(sortedWord, new ArrayList<>());
            }

            // add original word to the list associated with the sorted key
            testAnagram.get(sortedWord).add(word);

        }


        // return list of all values

       // ** HAD TO COMMENT THIS OUT TO RUN MAIN?? **
       // return new ArrayList<>(testAnagram.values());

        return null;
    }


    // 347. top K frequent elements
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> frequency = new HashMap<>();

        // count frequency of each number
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        // create a list from the entries of frequency map
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(frequency.entrySet());

        // sort list of frequencies in descending order
        entries.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));


        // get the k most frequent elements
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = entries.get(i).getKey();
        }

        return result;


    }


    // 238. product of array except self
    public int[] productExceptSelf(int[] nums) {


        int n = nums.length;

        int[] result = new int[nums.length];

        // calculate prefix products
        int prefix = 1;
        for (int i = 0; i < n; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }

        // calculate postfix products and multiply with prefix products
        int postfix = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= postfix;
            postfix *= nums[i];
        }

        return result;
    }



    // 167. Two Sum II - sorted input array
    public int[] twoSum(int[] numbers, int target) {


        int start = 0;
        int end = numbers.length - 1;


        while (start < end) {

            int sum = numbers[start] + numbers[end];

            if (sum > target) {
                end--;
            } else if (sum < target) {
                start++;
            } else {
                return new int[]{start + 1, end + 1};
            }


        }


        return null;

    }

    // 15. 3Sum

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> results = new ArrayList<>();

        // Sort input array
        Arrays.sort(nums);


        for (int i = 0; i < nums.length - 2; i++) {

            // skip duplicates
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;


            while (j < k) {

                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    // found a triplet with zero sum, add to list
                    results.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    // skip duplicates for j
                    while(j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    // skip duplicates for k
                    while(j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    // move pointers
                    j++;
                    k--;

                } else if (sum < 0) {
                    // sum is less than zero, increase j
                    j++;
                } else {
                    // sum is greater than zero, decrease k
                    k--;
                }




            }



        }



        return results;
    }




    // 5. Longest Palindromic Substring
    public String longestPalindrome(String s) {

        // expand around center approach


        String result = "";
        int resultLen = 0;


        for (int i = 0; i < s.length(); i++) {
            // odd length
            int left = i;
            int right = i;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if ((right - left + 1) > resultLen) {
                    result = s.substring(left, right + 1);
                    resultLen = right - left + 1;
                }
                left -= 1;
                right += 1;
            }

            // even
            left = i;
            right = i + 1;

            while ((left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))) {
                if ((right - left + 1) > resultLen) {
                    result = s.substring(left, right + 1);
                    resultLen = right - left + 1;
                }
                left -= 1;
                right += 1;
            }



        }


        return result;
    }


    // 46. Permutations
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> answer = new ArrayList<>();

        backTrack(nums, 0, answer);

        return answer;

    }



    private void backTrack(int[] nums, int index, List<List<Integer>> answer) {

        if (index == nums.length) {
            List<Integer> rs = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                rs.add(nums[i]);
            }
            answer.add(rs);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            int temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;


            backTrack(nums, index + 1, answer);

            temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;

        }


    }



    // 80. Remove Duplicates from Sorted Array II

    public int removeDuplicates(int[] nums) {

        if (nums.length <= 2) {
            return nums.length;
        }

        int index = 2;

        for (int i = 2; i < nums.length; i++) {

            if (nums[i] != nums[index - 2]) {
                nums[index] = nums[i];
                index++;
            }


        }
        return index;
    }



    // 189. Rotate Array

    public static void rev(int[] arr, int start, int end) {

        while (start < end) {

            int temp = arr[start];

            arr[start] = arr[end];

            arr[end] = temp;

            start++;

            end--;
        }
    }




    public void rotate(int[] nums, int k) {

        k = k % nums.length;

        int d = nums.length - k;

        rev(nums, 0, d - 1);

        rev(nums, d, nums.length - 1);

        rev(nums, 0, nums.length - 1);

    }



    // 55. Jump Game
    public boolean canJump(int[] nums) {

        // get first index
        // each index is how far you can jump

        int len = nums.length - 1;
        int firstIndex = nums[0];

        for (int i = 0; i <= firstIndex; i++) {

            // first index will be changed to max jump with current position
            firstIndex = Math.max(firstIndex, i + nums[i]);

            // if this is greater than or equal to last index, return true
            if (firstIndex >= len) {
                return true;
            }

        }


        return false;

    }



    // 1328. Break a palindrome
    public String breakPalindrome(String palindrome) {

        int length = palindrome.length();

        // handle edge case
        if (length == 1) {
            return "";
        }

        // break down palindrome to char array
        char[] ch = palindrome.toCharArray();

        // check first half of string excluding middle character
        int testLen = (length / 2) - 1;

        for (int i = 0; i <= testLen; i++) {

            // character isn't a, replace with a to make ensure it is lexicographically smaller
            if (ch[i] != 'a') {
                ch[i] = 'a';
                return String.valueOf(ch);
            }



        }

        // replace ch with b in case all previous chars are a's
        ch[length - 1] = 'b';
        return String.valueOf(ch);


    }



    // 45. Jump Game II
    public int jump(int[] nums) {

        int len = nums.length;

        int end = 0;

        int maxPosition = 0;

        int steps = 0;


        for (int i = 0; i < len - 1; i++) {

            maxPosition = Math.max(maxPosition, i + nums[i]);

            if (i == end) {
                end = maxPosition;
                steps++;
            }



        }

        return steps;

    }

    // 122. Best Time to Buy and Sell Stock II
    public int maxProfit(int[] prices) {

        if (prices.length == 0) {
            return 0;
        }

        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            // check if current price is greater than previous day's price
            if (prices[i] > prices[i - 1]) {
                // if so, add the difference to maxProfit
                maxProfit += prices[i] - prices[i - 1];
            }

        }

        return maxProfit;

    }


    // 274. H-Index
    public int hIndex(int[] citations) {

        Arrays.sort(citations);

        int n = citations.length;

        for (int i = 0; i < n; i++) {

            int h = n - i;

            if (citations[i] >= h) {
                return h;
            }



        }
       return 0;

    }


    /** memory limit exceeded, need to optimize **/
    // Zigzag Conversion
    public String convert(String s, int numRows) {

        int n = s.length();

        StringBuffer[] arr = new StringBuffer[numRows];

        for (int i = 0; i < numRows; i++) arr[i] = new StringBuffer();

        int i = 0;

        while (i < n) {

            for (int index = 0; index < numRows && i < n; index++) {
                arr[index].append(s.charAt(i));
            }

            for (int index = numRows - 2; index > 0 && i < n; index--) {
                arr[index].append(s.charAt(i++));
            }


        }

        StringBuffer ans = new StringBuffer();

        for (StringBuffer el : arr) {
            ans.append(el);
        }

        return ans.toString();
    }



    // 209. Minimum size subarray sum
    public int minSubArrayLen(int target, int[] nums) {

        // sliding window
        int n = nums.length;
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int currentSum = 0;


        for (int right = 0; right < n; right++) {
            // expand the window by including the current element
            currentSum += nums[right];

            // shrink the window from the left until the sum is less than target
            while (currentSum >= target) {
                // update the minimum length
                minLen = Math.min(minLen, right - left + 1);

                // shrink the window from the left
                currentSum -= nums[left];

                left++;
            }
        }
        // if minLen is still Integer.MAX_VALUE, no subarray found
        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;



    }



    // 33. Search in Rotated Sorted Array
    public int search(int[] nums, int target) {

        // binary search


        int start = 0;
        int end = nums.length - 1;


        while (start <= end) {

            int mid = (start + end) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            // left portion
            else if (nums[start] <= nums[mid]) {
                    if (target > nums[mid] || target < nums[start]) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
             // right portion
            } else {
                if (target < nums[mid] || target > nums[end]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return -1;
    }















}
