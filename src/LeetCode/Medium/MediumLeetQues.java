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


    // 2486. Append characters to string to make subsequence
    public int appendCharacter(String s, String t) {

        int sPointer = 0;
        int tPointer = 0;

        while (sPointer < s.length() && tPointer < t.length()) {
            if (s.charAt(sPointer) == t.charAt(tPointer)) {
                tPointer++;
            }
            sPointer++;
        }
        return t.length() - tPointer;

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
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    // skip duplicates for k
                    while (j < k && nums[k] == nums[k - 1]) {
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


    // 3Sum closest
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int closestSum = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                    closestSum = sum;
                }

                if (sum > target) {
                    k--;
                } else {
                    j++;
                }

            }
        }
        return closestSum;
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


    /**
     * memory limit exceeded, need to optimize
     **/
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


    // 78. Subsets
    public List<List<Integer>> subsets(int[] nums) {

        // O(n * 2^n)

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> list = new ArrayList<>();

        dfs(nums, result, list, nums.length, 0);

        return result;

    }


    private void dfs(int[] nums, List<List<Integer>> result, List<Integer> list, int n, int start) {

        result.add(new ArrayList<>(list));

        for (int i = start; i < n; i++) {

            list.add(nums[i]);

            dfs(nums, result, list, n, i + 1);

            list.remove(list.size() - 1);

        }


    }


    // 47. Permutations II
    // TODO review this
    public List<List<Integer>> permuteUnique(int[] nums) {

        // backtracking

        List<List<Integer>> ans = new ArrayList<>();

        Set<List<Integer>> matrix = new HashSet<>();

        permutation(nums, 0, matrix);

        for (List<Integer> elem : matrix) {
            ans.add(elem);
        }

        return ans;

    }

    private static void permutation(int[] arr, int x, Set<List<Integer>> matrix) {

        if (x == arr.length - 1) {

            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < arr.length; i++) {
                temp.add(arr[i]);
            }

            matrix.add(temp);

            return;
        }

        for (int i = x; i < arr.length; i++) {
            swap(arr, i, x);
            permutation(arr, x + 1, matrix);
            swap(arr, i, x);
        }

    }

    private static void swap(int[] arr, int i, int x) {

        int temp = arr[i];
        arr[i] = arr[x];
        arr[x] = temp;

    }


    // 438. Find All Anagrams in a String
    // TODO Review!!
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();
        Map<Character, Integer> pCount = new HashMap<>();
        Map<Character, Integer> sCount = new HashMap<>();

        if (p.length() > s.length()) {
            return new ArrayList<>();
        }


        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            pCount.put(ch, pCount.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < p.length(); i++) {
            char ch = s.charAt(i);
            sCount.put(ch, sCount.getOrDefault(ch, 0) + 1);
        }


        int i = p.length();
        int count = 0;

        while (i < s.length()) {

            if (compareMap(pCount, sCount)) {
                count++;
                ans.add(i - p.length());
            }


            char ch = s.charAt(i);
            sCount.put(ch, sCount.getOrDefault(ch, 0) + 1);


            char cha = s.charAt(i - p.length());

            if (sCount.get(cha) == 1) {
                sCount.remove(cha);
            } else {
                sCount.put(cha, sCount.get(cha) - 1);
            }
            i++;

        }

        if (compareMap(pCount, sCount)) {
            count++;
            ans.add(i - p.length());
        }
        return ans;
    }


    private static boolean compareMap(Map<Character, Integer> pCount, Map<Character, Integer> sCount) {

        for (char ch : sCount.keySet()) {

            if (!Objects.equals(pCount.getOrDefault(ch, 0), sCount.get(ch))) {
                return false;
            }

        }

        return true;
    }


    // 187. Repeated DNA Sequences
    public List<String> findRepeatedDnaSequences(String s) {

        Set<String> seen = new HashSet<>();

        Set<String> repeated = new HashSet<>();

        for (int i = 0; i + 9 < s.length(); i++) {

            String ten = s.substring(i, i + 10);

            if (!seen.add(ten)) {
                repeated.add(ten);
            }

        }


        return new ArrayList<>(repeated);


    }


    // 17. Letter Combinations of a Phone Number
    public List<String> letterCombinations(String digits) {

        // backtracking

        if (digits.isEmpty()) {
            return Collections.emptyList();
        }

        String[] phone_Nums = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        List<String> result = new ArrayList<>();

        stringBT("", digits, phone_Nums, result);

        return result;
    }


    private void stringBT(String combination, String next_digits, String[] phone_Nums, List<String> result) {

        if (next_digits.isEmpty()) {
            result.add(combination);
        } else {
            String letters = phone_Nums[next_digits.charAt(0) - '2'];
            for (char letter : letters.toCharArray()) {
                stringBT(combination + letter, next_digits.substring(1), phone_Nums, result);
            }
        }
    }


    // 560. Subarray Sum equals k
    public int subarraySum(int[] nums, int k) {

        int sum = 0;
        int ans = 0;

        Map<Integer, Integer> prefix = new HashMap<>();

        prefix.put(0, 1);

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];

            if (prefix.containsKey(sum - k)) {
                ans += prefix.get(sum - k);
            }
            prefix.put(sum, prefix.getOrDefault(sum, 0) + 1);

        }
        return ans;

    }


    // 665. Non-decreasing array
    public boolean checkPossibility(int[] nums) {

        int n = nums.length;

        int count = 0;

        for (int i = 0; i < n - 1; i++) {

            if (nums[i] > nums[i + 1]) {
                count++;
                if (count > 1) {
                    return false;
                }
                if (i > 0 && nums[i - 1] > nums[i + 1]) {
                    nums[i + 1] = nums[i];
                }
            }


        }
        return true;
    }


    // 1911. Maximum Alternating Subsequence Sum
    public long maxAlternatingSum(int[] nums) {


        int n = nums.length;

        long[][] dp = new long[n][2];

        dp[0][0] = nums[0];

        for (int i = 1; i < n; i++) {

            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + nums[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - nums[i]);


        }

        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }


    // 494. Target Sum
    public int findTargetSumWays(int[] nums, int target) {
        return targetHelper(nums, 0, target, 0);
    }


    private int targetHelper(int[] nums, int ans, int target, int index) {

        if (index == nums.length && ans != target) {
            return 0;
        }

        if (index == nums.length && ans == target) {
            return 1;
        }

        int left = targetHelper(nums, ans + nums[index], target, index + 1);
        int right = targetHelper(nums, ans - nums[index], target, index + 1);

        return left + right;
    }


    // 46. permutations
    public List<List<Integer>> permuteAgain(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();

        permuteBacktrack(list, new ArrayList<>(), nums);

        return list;

    }


    private void permuteBacktrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {

        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {

                if (tempList.contains(nums[i])) {
                    continue;
                }

                tempList.add(nums[i]);

                permuteBacktrack(list, tempList, nums);

                tempList.remove(tempList.size() - 1);
            }
        }


    }


    // 79. Word Search

    // TODO doesn't pass yet!!
    public boolean exist(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == word.charAt(0) && boardSearch(board, word, i, j, 0, visited)) {
                    return true;
                }


            }

        }

        return false;
    }


    private boolean boardSearch(char[][] board, String word, int i, int j, int index, boolean[][] visited) {

        if (index == word.length()) {
            return true;
        }


        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        visited[i][j] = true;

        if (boardSearch(board, word, i + 1, j, index + 1, visited) || boardSearch(board, word, i, j + 1, index + 1, visited)) {
            return true;
        }

        visited[i][j] = false;


        return false;
    }


    // 1481. Least Number of Unique Integers after K removals
    public int findLeastNumOfUniqueInts(int[] arr, int k) {


        Map<Integer, Integer> result = new HashMap<>();

        // count occurrences of each int
        for (int j : arr) {
            result.put(j, result.getOrDefault(j, 0) + 1);
        }


        // create list of entries for sorting
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(result.entrySet());

        // sort entries based on the count of occurrences
        entries.sort(Map.Entry.comparingByValue());

        int count = result.size();


        // remove the least frequent elements until k is reached
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (k >= entry.getValue()) {
                k -= entry.getValue();
                count--;
            } else {
                break;
            }
        }

        return count;

    }


    // 81. Search in rotated sorted array II
    public boolean searchTwo(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;


        while (start <= end) {

            int mid = (start + end) / 2;


            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] == nums[start] && nums[mid] == nums[end]) {
                start += 1;
                end -= 1;
            } else if (nums[mid] >= nums[start]) {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (nums[mid] <= nums[end]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }


        }


        return false;

    }


    // 279. Perfect Squares
    public int numSquares(int n) {
        return (int) numSquares(n, new HashMap<>());
    }


    private static double numSquares(int n, HashMap<Integer, Double> memo) {

        if (n == 0) {
            return 0;
        }


        if (memo.containsKey(n)) {
            return memo.get(n);
        }


        double minSquares = Double.POSITIVE_INFINITY;

        for (int i = 1; i <= Math.sqrt(n); i++) {

            int square = i * i;

            double numSqaures = 1 + numSquares(n - square, memo);


            if (numSqaures < minSquares) {
                minSquares = numSqaures;
            }

        }


        double result = minSquares;
        memo.put(n, result);


        return result;

    }


    // 90. Subsets II
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        getSubs(0, nums, new ArrayList<>(), results);
        return results;
    }

    private void getSubs(int idx, int[] nums, List<Integer> currentSubset, List<List<Integer>> result) {

        result.add(new ArrayList<>(currentSubset));

        for (int i = idx; i < nums.length; i++) {
            if (i != idx && nums[i] == nums[i - 1]) {
                continue;
            }
            currentSubset.add(nums[i]);
            getSubs(i + 1, nums, currentSubset, result);
            currentSubset.remove(currentSubset.size() - 1);
        }


    }


    // combination sum II
    public List<List<Integer>> combinationSumII(int[] nums, int target) {

        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(nums);

        comboBack(list, new ArrayList<>(), nums, target, 0);

        return list;


    }


    public void comboBack(List<List<Integer>> list, List<Integer> temp, int[] nums, int remain, int start) {

        if (remain < 0) {
            return;
        } else if (remain == 0) {
            list.add(new ArrayList<>(temp));
        } else {
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                temp.add(nums[i]);
                comboBack(list, temp, nums, remain - nums[i], i + 1);
                temp.remove(temp.size() - 1);
            }
        }


    }


    //  216. combination sum III
    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> result = combo3BackTrack(k, n, 1, new ArrayList<>());


        if (n < k) {
            return result;
        }

        return result;

    }


    public List<List<Integer>> combo3BackTrack(int k, int n, int i, List<Integer> temp) {

        if (n == 0 && k == 0) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>(temp));
            return res;
        }
        List<List<Integer>> answer = new ArrayList<>();
        for (int j = i; j <= 9; j++) {
            if (n - j < 0 || k - 1 < 0) {
                break;
            }
            temp.add(j);
            answer.addAll(combo3BackTrack(k - 1, n - j, j + 1, temp));
            temp.remove(temp.size() - 1);
        }

        return answer;

    }


    // 1838 Frequence of the most frequent element
    // TODO complete
    public int maxFrequency(int[] nums, int k) {

        // O(n log n)
        // sliding window approach

        // sort array to look at least (left) values that can be incemented by k
        Arrays.sort(nums);


//        int left = 0;
//        int right = 0;
//
//        int result = 0;
//        int total = 0;


        int maxFrequency = 0;
        long currentSum = 0;


        for (int left = 0, right = 0; right < nums.length; right++) {
            currentSum += nums[right];

            while (currentSum + k < (long) nums[right] * (right - left + 1)) {
                currentSum -= nums[left];
                left++;
            }

            maxFrequency = Math.max(maxFrequency, right - left + 1);

        }

        return maxFrequency;


//        while (right < nums.length) {
//
//            total += nums[right];
//
//            // while are window is invalid
//            while (nums[right] * (right - left + 1) > total + k) {
//
//                // shrink window
//
//                total -= nums[left];
//
//                left++;
//
//            }
//
//            result = Math.max(result, right - left + 1);
//
//            right++;
//        }
//        return result;
    }


    // 1679. Max Number of k-sum pairs
    public int maxOperations(int[] nums, int k) {

        int count = 0;

        Arrays.sort(nums);

        int i = 0;
        int j = nums.length - 1;


        while (i < j) {
            if ((nums[i] + nums[j]) == k) {
                count++;
                i++;
                j--;
            } else if ((nums[i] + nums[j]) > k) {
                j--;
            } else {
                i++;
            }
        }

        return count;
    }


    // 1657. Determine if two strings are close
    public boolean closeString(String word1, String word2) {

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (int i = 0; i < word1.length(); ++i) {
            freq1[word1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < word2.length(); ++i) {
            freq2[word2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; ++i) {
            if ((freq1[i] > 0 && freq2[i] == 0) || (freq2[i] > 0 && freq1[i] == 0)) {
                return false;
            }
        }

        Arrays.sort(freq1);
        Arrays.sort(freq2);

        for (int i = 0; i < 26; ++i) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }
        return true;

    }


    // 2390. Removing Stars from a string
    public String removeStars(String s) {

        char[] chars = s.toCharArray();

        Stack<Character> stack = new Stack<>();

        for (char c : chars) {
            if (c != '*') {
                stack.push(c);
            } else {
                stack.pop();
            }
        }

        char[] result = new char[stack.size()];

        int i = result.length - 1;

        while (!stack.isEmpty()) {
            result[i--] = stack.pop();
        }

        return new String(result);

    }


    // 71. Simplify Path
    public String simplifyPath(String path) {

        Stack<String> res = new Stack<>();

        StringBuilder sb = new StringBuilder();

        String[] str = path.split("/");

        for (int i = 0; i < str.length; i++) {
            if (!res.isEmpty() && str[i].equals("..")) {
                res.pop();
            } else if (!str[i].equals("") && !str[i].equals(".") && !str[i].equals("..")) {
                res.push(str[i]);
            }
        }

        if (res.isEmpty()) {
            return "/";
        }

        while (!res.isEmpty()) {
            sb.insert(0, res.pop()).insert(0, "/");
        }

        return sb.toString();

    }


    // 402. remove k digits
    public String removeKDigits(String num, int k) {


        Stack<Character> stack = new Stack<>();

        for (char digit : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }


        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }


        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        sb.reverse();


        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }


        return sb.length() > 0 ? sb.toString() : "0";

    }


    // 2370. longest ideal subsequence
    public int longestIdealString(String s, int k) {

        int[] dp = new int[26];

        for (int i = 0; i < s.length(); i++) {

            int a = s.charAt(i) - 'a', mx = 0;

            for (int b = Math.max(0, a - k); b <= Math.min(25, a + k); b++) {
                mx = Math.max(mx, dp[b]);
            }
            dp[a] = 1 + mx;


        }

        return Arrays.stream(dp).max().getAsInt();
    }


    // 3075. Maximize happiness of selected children
    public long maximumHappinessSum(int[] happiness, int k) {

        Arrays.sort(happiness);
        reverseHap(happiness);

        int i = 0;

        long result = 0;

        while (k-- > 0) {
            happiness[i] = Math.max(happiness[i] - i, 0);
            result += happiness[i++];
        }

        return result;

    }


    private void reverseHap(int[] happiness) {
        int start = 0;
        int end = happiness.length - 1;

        while (start < end) {

            int temp = happiness[start];
            happiness[start] = happiness[end];
            happiness[end] = temp;
            start++;
            end--;
        }

    }


    // 2300 successful pairs or spells and potions
    public int[] successfulPairs(int[] spells, int[] potions, long success) {

        int n = spells.length;
        int m = potions.length;


        int[] result = new int[n];

        Arrays.sort(potions);

        for (int i = 0; i < n; i++) {

            int spell = spells[i];

            int left = 0;

            int right = m - 1;

            while (left <= right) {

                int mid = left + (right - left) / 2;

                long product = (long) spell * potions[mid];

                if (product >= success) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }


            }
            result[i] = m - left;


        }

        return result;


    }


    private int maxGold;

    // 1219. Path with Maximum Gold
    public int getMaximumGold(int[][] grid) {

        maxGold = 0;

        int rows = grid.length;
        int cols = grid[0].length;


        // looping each cell in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] > 0) {
                    findPath(grid, i, j, 0);
                }
            }
        }
        return maxGold;

    }


    public void findPath(int[][] grid, int row, int col, int currentGold) {

        // checking out of bounds or empty cell
        if (row < 0 || row >= grid.length || col < 0 || col > grid[0].length || grid[row][col] == 0) {
            return;
        }

        // adds gold in current cell to current total
        currentGold += grid[row][col];

        // updates the max
        maxGold = Math.max(maxGold, currentGold);

        // save gold amount in current cell and mark it visited by 0
        int temp = grid[row][col];
        grid[row][col] = 0;


        // check all directions
        findPath(grid, row - 1, col, currentGold);
        findPath(grid, row + 1, col, currentGold);
        findPath(grid, row, col - 1, currentGold);
        findPath(grid, row, col + 1, currentGold);


        // restore the gold amount
        grid[row][col] = temp;

    }


    // 165. Compare Version Numbers
    public int compareVersion(String version1, String version2) {

        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");


        int maxLen = Math.max(v1.length, v2.length);

        for (int i = 0; i < maxLen; i++) {
            int num1 = (i < v1.length) ? Integer.parseInt(v1[i]) : 0;
            int num2 = (i < v2.length) ? Integer.parseInt(v2[i]) : 0;

            if (num1 < num2) {
                return -1;
            }
            if (num1 > num2) {
                return 1;
            }


        }

        return 0;


    }


    // 881. Boats to save people
    public int numRescueBoats(int[] people, int limit) {

        int count = 0;

        int start = 0;
        int end = people.length - 1;

        while (start <= end) {

            if (people[start] + people[end] <= limit) {
                start++;
            }
            end--;
            count++;


        }


        return count;

    }


    // 1208. Get equal substrings within budget
    public int equalSubstring(String s, String t, int maxCost) {

        int n = s.length();
        int start = 0;
        int currentCost = 0;
        int maxLen = 0;

        for (int end = 0; end < n; end++) {

            currentCost += Math.abs(s.charAt(end) - t.charAt(end));


            while (currentCost > maxCost) {
                currentCost -= Math.abs(s.charAt(start) - t.charAt(start));
                start++;
            }

            maxLen = Math.max(maxLen, end - start + 1);

        }
        return maxLen;
    }


    // 2401. Longest Nice Subarray
    public int longestNiceSubarray(int[] nums) {

        int start = 0;
        int maxLen = 1;
        int subOr = 0;

        for (int i = 0; i < nums.length; i++) {


            while (((subOr & nums[i]) != 0)) {
                subOr ^= nums[start++];
            }

            subOr |= nums[i];

            int currentLen = i - start + 1;
            maxLen = Math.max(maxLen, currentLen);


        }

        return maxLen;

    }


    // 846 hand of straights
    public boolean isNStraightHand(int[] hand, int groupSize) {

        if (hand.length % groupSize != 0) {
            return false;
        }


        Map<Integer, Integer> count = new HashMap<>();

        Arrays.sort(hand);


        for (int card : hand) {
            count.put(card, count.getOrDefault(card, 0) + 1);
        }


        for (int card : hand) {
            if (count.get(card) > 0) {


                for (int i = 0; i < groupSize; i++) {
                    int currentCard = card + i;

                    if (count.getOrDefault(currentCard, 0) <= 0) {
                        return false;
                    }

                    count.put(currentCard, count.get(currentCard) - 1);
                }


            }
        }

        return true;
    }


    // 648. replace words
    public String replaceWords(List<String> dictionary, String sentence) {

        Set<String> rootSet = new HashSet<>(dictionary);

        StringBuilder sb = new StringBuilder();

        String[] words = sentence.split("\\s+");

        for (String word : words) {

            String prefix = "";

            for (int i = 1; i <= word.length(); i++) {
                prefix = word.substring(0, i);
                if (rootSet.contains(prefix)) {
                    break;
                }
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(prefix);

        }

        return sb.toString();


    }


    // 523. continuous subarray sum
    public boolean checkSubarraySum(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            int remainder = sum % k;

            if (remainder < 0) {
                remainder += k;
            }

            if (map.containsKey(remainder)) {
                if (i - map.get(remainder) > 1) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }

        }
        return false;

    }



    // 974. subarray sums divisible by k
    public int subarraysDivByK(int[] nums, int k) {

            int total = 0;

            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);


            int sum = 0;

            for (int num : nums) {
                sum += num;

                int remainer = sum % k;

                if (remainer < 0) {
                    remainer += k;
                }


                if (map.containsKey(remainer)) {
                    total += map.get(remainer);
                }

                map.put(remainer, map.getOrDefault(remainer, 0) + 1);

            }
        return total;
    }





    // 2845. count of interesting subarrays
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {

            Map<Integer, Integer> map = new HashMap<>();

            map.put(0, 1);

            int countModk = 0;
            long interestingCount = 0;


            for (int num : nums) {
                if (num % modulo == k) {
                    countModk++;
                }


                int current = countModk % modulo;

                int required = (current - k + modulo) % modulo;


                interestingCount += map.getOrDefault(required, 0);

                map.put(current, map.getOrDefault(current, 0) + 1);

            }

            return interestingCount;
    }



    // 75. sort colors
    public void sortColors(int[] nums) {

        int countZeros = 0;
        int countOnes = 0;
        int countTwos = 0;

        for (int num : nums) {
            if (num == 0) {
                countZeros++;
            } else if (num == 1) {
                countOnes++;
            } else {
                countTwos++;
            }
        }



        int idx = 0;

        while (countZeros > 0) {
            nums[idx] = 0;
            countZeros--;
            idx++;
        }

        while (countOnes > 0) {
            nums[idx] = 1;
            countOnes--;
            idx++;
        }

        while (countTwos > 0) {
            nums[idx] = 2;
            countTwos--;
            idx++;
        }



    }




    // 945. minimum increment to make array unique
    public int minIncrementForUnique(int[] nums) {

        Arrays.sort(nums);

        int idx = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                int x = nums[i - 1] + 1;
                idx = idx + (x - nums[i]);
                nums[i] = x;
            }
        }


        return idx;
    }



    // 260. single number III
    public int[] singleNumber(int[] nums) {

        int[] result = new int[2];


        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int idx = 0;

        for (Map.Entry<Integer, Integer> checker : map.entrySet()) {
            if (checker.getValue() == 1) {
                result[idx] = checker.getKey();
                idx++;
            }
        }


        return result;


    }



    // 633. sum of square numbers
    public boolean judgeSquareSum(int c) {


       long a = 0;
       long b = (long) Math.sqrt(c);


       while (a <= b) {

           long midSum = (a * a) + (b * b);


           if (midSum == c) {
               return true;
           }
           else if (midSum > c) {
               b--;
           }
           else {
               a++;
           }

       }
        return false;

    }




    // 826. Most profit assigning work
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {


        int n = difficulty.length;
        int[][] jobs = new int[n][2];

        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }

        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        Arrays.sort(worker);

        int maxProfit = 0;
        int i = 0;
        int best = 0;

        for (int ability : worker) {
            while (i < n && ability >= jobs[i][0]) {
                best = Math.max(best, jobs[i][1]);
                i++;
            }
            maxProfit += best;
        }

        return maxProfit;
    }




    // 2610. convert an array into a 2D array with conditions
    public List<List<Integer>> findMatrix(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> result = new ArrayList<>();

        int max = Collections.max(map.values());

        for (int i = 0; i < max; i++) {
            result.add(new ArrayList<>());
        }

        for (Map.Entry<Integer, Integer> idx : map.entrySet()) {
            int value = idx.getKey();
            int count = idx.getValue();

            for (int i = 0; i < count; i++) {
                result.get(i).add(value);
            }
        }

        return result;
    }






    // 1482. minimum number of days to make m bouquets
    public int minDays(int[] bloomDay, int m, int k) {

        if (m * k > bloomDay.length) {
            return -1;
        }

        int result = -1;

        int start = 1;
        int end = 1000000000;


        while (start <= end) {

            int mid = start + (end - start) / 2;

            int consecutiveLen = 0;
            int bouquets = 0;

            for (int i = 0; i < bloomDay.length; i++) {
                if (bloomDay[i] <= mid) {
                    consecutiveLen++;
                    if (consecutiveLen == k) {
                        consecutiveLen = 0;
                        bouquets++;
                    }
                } else {
                    consecutiveLen = 0;
                }
                if (bouquets >= m) {
                    break;
                }
            }
            if (bouquets >= m) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }



        }
        return result;
    }




    // 1552. magnetic force between two balls
    public int maxDistance(int[] position, int m) {

        Arrays.sort(position);

        int l = 1;
        int r = position[position.length - 1] - position[0];
        int result = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            int lastPosition = position[0];
            int balls = 1;

            for (int i = 1; i < position.length; i++) {
                if (position[i] - lastPosition >= mid) {
                 lastPosition = position[i];
                 balls++;
                }
            }
            if (balls >= m) {
                result = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;




    }


    // 1052 grumpy bookstore owner
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

        int sum = 0;

        int n = customers.length;

        for (int i = 0; i < n; i++) {
            sum += customers[i] * (1 - grumpy[i]);
            grumpy[i] = customers[i] * grumpy[i];
        }

        int max = 0;
        for (int i = 0; i < minutes; i++) {
            max += grumpy[i];
        }

        int save = max;
        for (int i = minutes; i < n; i++) {
            save += grumpy[i] - grumpy[i - minutes];
            max = save > max ? save : max;
        }

        return sum + max;
    }





    // 1248. count number of nice subarrays
    public int numberofSubarrays(int[] nums, int k) {

        int total = 0;

        int sum = 0;

       for (int i = 0; i < nums.length; i++) {
           if (nums[i] % 2 == 0) {
               nums[i] = 0;
           }
           else {
               nums[i] = 1;
           }
       }



       Map<Integer, Integer> map = new HashMap<>();
       map.put(0, 1);

       for (int i = 0; i < nums.length; i++) {
           sum += nums[i];

           if (map.containsKey(sum - k)) {
               total += map.get(sum - k);
           }
           map.put(sum, map.getOrDefault(sum, 0) + 1);
       }

        return total;
    }




}
