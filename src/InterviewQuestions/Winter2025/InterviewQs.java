package InterviewQuestions.Winter2025;

import java.util.*;

public class InterviewQs {

    /** Mix of easy, medium and hard interview questions for 2024/25 **/


    // 1529. Minimum suffix flips
    public int minFlips(String target) {

        int max = 0;
        char bit = '0';

        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) != bit) {
                max++;
                bit = target.charAt(i);
            }
        }
        return max;
    }






    // 1200. Minimum absolute difference
    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 1; i++) {
            int difference = arr[i + 1] - arr[i];

            if (difference < min) {
                min = difference;

                result.clear();
                result.add(Arrays.asList(arr[i], arr[i + 1]));
            } else if (difference == min) {
                result.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }
        return result;
    }






    // 387. first unique character in a string
    public int firstUniqChar(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {

            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }


        return -1;
    }




    // 1356. sort integer by number of 1 bits
    public int[] sortByBits(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            arr[i] += Integer.bitCount(arr[i]) * 10001;
        }

        Arrays.sort(arr);


        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] % 10001;
        }
        return arr;
    }





    // 2068. check whether two strings are almost equivalent
    public boolean checkAlmostEquivalent(String word1, String word2) {

        if (word1.length() != word2.length()) {
            return false;
        }

        Map<Character, Integer> answer = new HashMap<>();
        for (int i = 0; i < word1.length(); i++) {
            answer.put(word1.charAt(i), answer.getOrDefault(word1.charAt(i), 0) + 1);
            answer.put(word2.charAt(i), answer.getOrDefault(word2.charAt(i), 0) - 1);

        }

        for (int i : answer.values()) {
            if (i > 3 || i < -3) {
                return false;
            }
        }
        return true;
    }




    // 2273. Find resultant array after removing anagrams
    public List<String> removeAnagrams(String[] words) {
        String prev = "";
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            Arrays.sort(chars);
            String temp = new String(chars);
            if (!temp.equals(prev)) {
                answer.add(words[i]);
                prev = temp;
            }
        }

        return answer;

    }






    // 2602. minimum operations to make all array elements equal
    public List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums);
        List<Long> answer = new ArrayList<>();

        int n = nums.length;

        long[] prefix = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        for (int x : queries) {
            int i = binaryS(nums, x);
            answer.add(x * (2L * i - n) + prefix[n] - 2 * prefix[i]);
        }


        return answer;

    }


    private int binaryS(int[] nums, int x) {
        int low = 0;
        int high = nums.length;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] < x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }




    // 2696. minimum string length after removing substrings
    public int minLength(String s) {

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && ((stack.peek() == 'A' && ch == 'B') || stack.peek() == 'C' && ch == 'D')) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.size();
    }



    // 70. climbing stairs
    public int climbStairs(int n) {
        int one = 1;
        int two = 1;

        for (int i = 0; i < n - 1; i++) {
            int temp = one;
            one = one + two;
            two = temp;
        }
        return one;
    }





    // 1481. Least number of unique integers after k removals
    public int findLeastNumOfUniqueInts(int[] arr, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }


        List<Integer> frequencies = new ArrayList<>(map.values());

        Collections.sort(frequencies);

        int elementsRemoved = 0;

        for (int i = 0; i < frequencies.size(); i++) {

            elementsRemoved += frequencies.get(i);

            if (elementsRemoved > k) {
                return frequencies.size() - i;
            }

        }

        return 0;
    }



    // 1328. break a palindrome
    public String breakPalindrome(String palindrome) {
        int len = palindrome.length();
        if (len == 1) {
            return "";
        }

        char[] chars = palindrome.toCharArray();
        int itrLen = (len / 2) - 1;
        for (int i = 0; i <= itrLen; i++) {
            if (chars[i] != 'a') {
                chars[i] = 'a';
                return String.valueOf(chars);
            }
        }
        chars[len - 1] = 'b';
        return String.valueOf(chars);
    }


    // 412. fizz buzz
    public List<String> fizzBuzz(int n) {

        List<String> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else {
                result.add(Integer.toString(i));
            }
        }


        return result;
    }


    // 263. ugly number
    public boolean isUgly(int n) {
        while (n >= 5 && n % 5 == 0) n /= 5;
        while (n >= 3 && n % 3 == 0) n /= 3;
        while (n >= 2 && n % 2 == 0) n /= 2;

        return n == 1;
    }




    // 752. open the lock
    // bfs -- shortest path
    // dfs will cause TLE because it will search entire branch before searching others
    // TODO need to review this
    public int openLock(String[] deadends, String target) {
        Map<Character, Character> next = Map.of(
                '0', '1',
                '1', '2',
                '2', '3',
                '3', '4',
                '4', '5',
                '5', '6',
                '6', '7',
                '7', '8',
                '8', '9',
                '9', '0'
        );

        Map<Character, Character> prev = Map.of(
                '0', '9',
                '1', '0',
                '2', '1',
                '3', '2',
                '4', '3',
                '5', '4',
                '6', '5',
                '7', '6',
                '8', '7',
                '9', '8'
        );

        Set<String> visited = new HashSet<>(Arrays.asList(deadends));

        Queue<String> pending = new LinkedList<>();

        int turns = 0;

        if (visited.contains("0000")) {
            return -1;
        }

        pending.add("0000");
        visited.add("0000");

        while (!pending.isEmpty()) {
            int currentLevelNode = pending.size();
            for (int i = 0; i < currentLevelNode; i++) {
                String current = pending.poll();

                if (current.equals(target)) {
                    return turns;
                }

                for (int wheel = 0; wheel < 4; wheel += 1) {
                    StringBuilder sb = new StringBuilder(current);
                    sb.setCharAt(wheel, next.get(sb.charAt(wheel)));

                    if (!visited.contains(sb.toString())) {
                        pending.add(sb.toString());
                        visited.add(sb.toString());
                    }

                    sb = new StringBuilder(current);
                    sb.setCharAt(wheel, prev.get(sb.charAt(wheel)));

                    if (!visited.contains(sb.toString())) {
                        pending.add(sb.toString());
                        visited.add(sb.toString());
                    }
                }
            }
            turns += 1;
        }
        return -1;
    }



    // 9. palindrome number
    public boolean isPalindrome(int x) {

        String num = Integer.toString(x);

        int start = 0;
        int end = num.length() - 1;

        while (start < end) {
            if (num.charAt(start) != num.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }


        return true;
    }



    // 53. maximum subarray
    public int maxSubArray(int[] nums) {
        int start = Integer.MIN_VALUE;

        int end = 0;

        for (int i = 0; i < nums.length; i++) {
            end += nums[i];


            if (start < end) {
                start = end;
            }
            if (end < 0) {
                end = 0;
            }


        }
        return start;
    }



    // 56. merge intervals
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();

        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }



    // happy number
    public boolean isHappy(int n) {
        Map<Integer, Integer> checked = new HashMap<>();

        while (n != 1 && !checked.containsKey(n)) {

            checked.put(n, 0);


            String temp = String.valueOf(n);

            int sum = 0;

            for (int i = 0; i < temp.length(); i++) {

                int digit = Character.getNumericValue(temp.charAt(i));

                sum += (digit * digit);
            }

            n = sum;
        }


        return n == 1;
    }




    // 1710. maximum units on a truck
    public int maximumUnits(int[][] boxTypes, int truckSize) {

        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        int count = 0;
        int size = boxTypes.length;

        for (int i = 0; i < size && truckSize > 0; i++) {
            int boxes = boxTypes[i][0];
            int units = boxTypes[i][1];
            truckSize -= boxes;
            count += boxes * units;
            if (truckSize < 0) {
                count += truckSize * units;
                break;
            }
        }
        return count;
    }





    // 22. generate parentheses
    public List<String> generateParentheses(int n) {
        List<String> validCombos = new ArrayList<>();
        backTrack("", 0, 0, n, validCombos);
        return validCombos;
    }

    public void backTrack(String current, int open, int closed, int n, List<String> validCombos) {

        if (current.length() == 2 * n) {
            validCombos.add(current);
            return;
        }

        if (open < n) {
            backTrack(current + "(", open + 1, closed, n, validCombos);
        }

        if (closed < open) {
            backTrack(current + ')', open, closed + 1, n, validCombos);
        }


    }




    // 2104. sum of subarray ranges
    public long subArrayRanges(int[] nums) {
        long result = 0;

        int n = nums.length;

        for (int left = 0; left < n; left++) {
            int minVal = nums[left];
            int maxVal = nums[left];
            for (int right = left; right < n; right++) {
                minVal = Math.min(minVal, nums[right]);
                maxVal = Math.max(maxVal, nums[right]);
                result += maxVal - minVal;
            }
        }
        return result;
    }




    // 5. longest palindromic substring
    public String longestPalindrome(String s) {
        for (int length = s.length(); length > 0; length--) {
            for (int start = 0; start <= s.length() - length; start++) {
                if (checkPal(start, start + length, s)) {
                    return s.substring(start, start + length);
                }
            }
        }
        return "";
    }


    private boolean checkPal(int i, int j, String s) {

        int left = i;
        int right = j - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }



    // 560. subarray equals k
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int answer = 0;

        Map<Integer, Integer> prefix = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (prefix.containsKey(sum - k)) {
                answer += prefix.get(sum - k);
            }

            prefix.put(sum, prefix.getOrDefault(sum, 0) + 1);
        }
        return answer;
    }



    // 1. Two sum
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







    // 121. best time to buy and sell stock I
    public int maxProfit(int[] prices) {

        if (prices.length == 0) {
            return 0;
        }

        int start = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < start) {
                start = prices[i];
            } else {
                int current = prices[i] - start;

                if (current > maxProfit) {
                    maxProfit = current;
                }
            }
        }

        return maxProfit;
    }














}
