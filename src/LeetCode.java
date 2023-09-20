import java.util.*;

public class LeetCode {



//    1. Reconstruct Original Digits from English
    public String originalDigits(String s) {
        int[] count = new int[26];
        for(char c : s.toCharArray()) count[c-'a']++;

        int[] num = new int[10];

        //Unique Cases
        num[0] = count['z' - 'a'];
        num[2] = count['w' - 'a'];
        num[4] = count['u' - 'a'];
        num[6] = count['x' - 'a'];
        num[8] = count['g' - 'a'];

        //Derived Cases
        num[1] = count['o' - 'a'] - num[0] -num[2] -num[4];
        num[3] = count['h' - 'a'] - num[8];
        num[5] = count['f' - 'a'] - num[4];
        num[7] = count['s' - 'a'] - num[6];
        num[9] = count['i' - 'a'] - num[5] -num[6] -num[8];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            while(num[i] --> 0)
                sb.append(i);
        }
        return sb.toString();



    }



//    2. Group Anagrams
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            char[] c = word.toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(word);
        }
        return new ArrayList<>(map.values());
    }




//    3. Maximum Subarray

    public int maxSubArray(int[] nums) {
        int globalMax = nums[0];
        int currentMax = nums[0];
        for (int i = 0; i < nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            globalMax = Math.max(currentMax, globalMax);
        }
        return globalMax;
    }



//    4. Even odd tree


             public class TreeNode {
                int val;
                TreeNode left;
                TreeNode right;
                TreeNode() {}
                TreeNode(int val) { this.val = val; }
                TreeNode(int val, TreeNode left, TreeNode right) {
                    this.val = val;
                    this.left = left;
                    this.right = right;
                }
  }


    public Boolean isEvenOddTree(TreeNode root) {
        //traverse tree level by level
        //time complexity O(n)

        if (root == null) return true;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean evenLevel = true;

        while(q.size() > 0) {
            int size = q.size();
            int prev = evenLevel ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            while(size-- > 0) {
                root = q.poll();
                if (evenLevel && (root.val % 2 == 0 || root.val <= prev)) return false;
                if (!evenLevel && (root.val % 2 == 1 || root.val >= prev)) return false;
                prev = root.val;
                if (root.left != null)
                    q.add(root.left);
                if (root.right != null)
                    q.add(root.right);
            }
            evenLevel = !evenLevel;
        }
        return true;
    }


//    5. Best time to buy and sell stock
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int minBuy = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minBuy) {
                minBuy = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minBuy);
            }
        }
        return maxProfit;
    }


//    6. Add Two Numbers  LINKED LIST PROBLEM

      public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode pre = new ListNode(-1);
        ListNode tmp = pre;
        while(l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            tmp.next = new ListNode(sum % 10);
            tmp = tmp.next;
            carry = sum / 10;
        }
        if (carry != 0) {
            tmp.next = new ListNode(carry);
        }
        return pre.next;
    }

//    7. TwoSum
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

//    8. Maximum units on a truck
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int totalUnits = 0;
        int loadedBoxes = 0;
        for (int i = 0; i < boxTypes.length; i++) {
            int number  = boxTypes[i][0];
            while(loadedBoxes < truckSize && number > 0) {
                totalUnits += boxTypes[i][1];
                number--;
                loadedBoxes++;
            }
        }
        return totalUnits;
    }

//    9. Minimum value to get positive number
    public int minStartValues(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            min = Math.min(sum, min);
        }
        return min > 0 ? 1 : Math.abs(min) + 1;
    }


//    10. Maxmium number of events that can be attended
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int maxEvents = 0;
        int i = 0;
        for (int day = 1; day <= 100000; day++) {
            while (i < events.length && events[i][0] == day) {
                heap.offer(events[i++][1]);
            }
        while (heap.size() > 0 && heap.peek() < day) {
            heap.poll();
        }
        if (heap.size() > 0) {
            heap.poll();
            maxEvents++;
        }
    }
        return maxEvents;
    }

//    11. Minimum absolute difference
public List<List<Integer>> minimumAbsDifference(int[] arr) {
    Arrays.sort(arr);
    int minimumDiff = arr[1] - arr[0];
    List result = new ArrayList();
    result.add(Arrays.asList(arr[0], arr[1]));
    for (int i = 1; i < arr.length - 1; i++) {
        int diff = arr[i + 1] - arr[i];
        if (minimumDiff == diff) {
            result.add(Arrays.asList(arr[i], arr[i + 1]));
        } else if (minimumDiff > diff) {
            minimumDiff = diff;
            result = new ArrayList();
            result.add(Arrays.asList(arr[i], arr[i + 1]));
        }
    }
    return result;
}


 // 27. REMOVE ELEMENT
// Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
// The order of the elements may be changed.
// Then return the number of elements in nums which are not equal to val.

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            //check if element is not want we want to remove
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    // 26. REMOVE ELEMENT FROM SORTED ARRAY
    public int removeDuplicates(int[] nums) {
        int count = 0; //array length

        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                continue;
            }
            //update array in place
            nums[count] = nums[i];
            count++;
        }
        return count;
    }


    // Reversed Words in a string
    // Given an input string s, reverse the order of the words
    // "the sky is blue" should return "blue is sky the"

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();

        String[] splitStr = s.trim().split(" ");

        for (int i = splitStr.length - 1; i >= 0; i--) {
            if (!splitStr[i].isEmpty()) {
                sb.append(splitStr[i]);
                if (i > 0) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();

    }


    // PRODUCT OF ARRAY EXCEPT SELF
    //Given an integer array nums, return an array answer such that
    // answer[i] is equal to the product of all the elements of nums except nums[i].
    // The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
    // You must write an algorithm that runs in O(n) time and without using the division operation.


    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] results = new int[n];

        int leftProd = 1;
        for (int i = 0; i < n; i++) {
            results[i] = leftProd;
            leftProd *= nums[i];
        }


        int rightProd = 1;
        for (int i = n - 1; i >= 0; i--) {
            results[i] *= rightProd;
            rightProd *= nums[i];
        }

        return results;


    }


                        // *** EASY BINARY SEARCH ***
//    We are playing the Guess Game. The game is as follows:
//    I pick a number from 1 to n. You have to guess which number I picked.
//    Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
//    You call a pre-defined API int guess(int num), which returns three possible results:
//     -1: Your guess is higher than the number I picked (i.e. num > pick).
//     1: Your guess is lower than the number I picked (i.e. num < pick).
//     0: your guess is equal to the number I picked (i.e. num == pick).
//    Return the number that I picked.

    /**
     * Forward declaration of guess API.
     * @param  num   your guess
     * @return 	     -1 if num is higher than the picked number
     *			      1 if num is lower than the picked number
     *               otherwise return 0
     * int guess(int num);
     */

    public int guessNumber(int n) {

        int low = 0;
        int high = n;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // this is supposed to be a built in api call on leetcode
            // commented out so no errors but solution was int target = guess(mid)
            // int target = guess(mid);
            int target = mid;
            if (target == 0) {
                return mid;
            } else if (target == 1) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;

    }


    // String compression
    // #443

    public int compress(char[] chars) {

        // pointer for our compressed
        int pointer = 0;
        // iterator for input
        int i = 0;


        while (i < chars.length) {
            char currentChar = chars[i];

            //count consecutive characters
            int count = 0;

            while (i < chars.length && chars[i] == currentChar) {
                i++;
                count++;
            }

            chars[pointer++] = currentChar;
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[pointer++] = c;
                }
            }
        }
        return pointer;

    }



    // CHECK DUPLICATES
    // Given an int array nums, return true if any value appears at least twice
    // and return false is every element is distinct
    public boolean containsDuplicate(int[] nums) {

        // create set as all values must be distinct
        Set<Integer> checkDups = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (checkDups.contains(nums[i])) {
                return true;
            } else {
                checkDups.add(nums[i]);
            }
        }
        return false;


    }


    // VALID ANAGRAM
    public boolean isAnagram(String s, String t) {

        // if lengths are not the same, can't be anagram
        if (s.length() != t.length()) {
            return false;
        }


        Map<Character, Integer> checkS = new HashMap<>();
        Map<Character, Integer> checkT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            checkS.put(s.charAt(i), checkS.getOrDefault(s.charAt(i), 0) + 1);
            checkT.put(t.charAt(i), checkT.getOrDefault(t.charAt(i), 0) + 1);
        }

        return checkS.equals(checkT);
    }



    // TWO SUM better solution with O(n) time
    public int[] twoSumTwo(int[] nums, int target) {

        Map<Integer, Integer> sums = new HashMap<>();


        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (sums.containsKey(diff)) {
                return new int[]{sums.get(diff), i};
            }
            sums.put(nums[i], i);

        }
        return new int[]{-1, -1};
    }



    // 347 Top K Frequent Elements
    // Given an integer array nums and an integer k, return
    // the k most frequent elements.
    // You may return the answer in any order
    public int[] topKFrequent(int[] nums, int k) {

        // create hashmap to count the frequency of numbers
        Map<Integer, Integer> countNums = new HashMap<>();

        // count frequency
        for (int num : nums) {
            countNums.put(num, countNums.getOrDefault(num, 0) + 1);
        }

        // keep track of k most frequent
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((num1, num2) -> countNums.get(num1) - countNums.get(num2));


        for (int num : countNums.keySet()) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // now return the array
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll();
        }

        return result;

    }


    // 36 Valid sudoku
    public boolean isValidSudoku(char[][] board) {

        for(int i = 0; i < 9; i++) {
            Set<Character> rows = new HashSet<>();
            Set<Character> cols = new HashSet<>();
            Set<Character> cubes = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !rows.add(board[i][j])) return false;
                if (board[j][i] != '.' && !cols.add(board[j][i])) return false;
                int colOffset = j % 3, rowOffset = j / 3;
                int colStart = 3 * (i % 3), rowStart = 3 * (i / 3);
                int row = rowStart + rowOffset, col = colStart + colOffset;
                if (board[row][col] != '.' && !cubes.add(board[row][col]) )return false;
            }
        }
        return true;

    }


    // 128 Longest Consecutive Sequence
    // Given an unsorted array of integers nums,
    // return the length of the longest consecutive elements sequence.
    // You must write an algorithm that runs in O(n) time

    public int longestConsecutive(int[] nums) {

        Set<Integer> numSet = new HashSet<>();

        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;


                while(numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }



    // 167 Two Sum II -> medium
    public int[] sumTwo(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;


        while (left < right) {
            int tempSum = nums[left] + nums[right];

            if (tempSum > target) {
                right--;
            } else if (tempSum < target) {
                left++;
            } else {
                return new int[]{left + 1, right + 1};
            }

        }

        return new int[]{-1, -1};
    }


    // 15 3Sum
    // Given an integer array nums, return all the triplets
    // [nums[i], nums[j], nums[k]]
    // such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        // sort input array
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // we already saw this value, skip
            if (i > 0 && (nums[i] == nums[i - 1])) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right) {
                int threeSum = nums[i] + nums[left] + nums[right];
                if (threeSum == 0) {
                    results.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (threeSum < 0) {
                    left++;
                } else {
                    right--;
                }
            }

        }


        return results;


    }



    // 11. Container with most water
    // given an array height of length n. There are n vertical lines drawn such that
    // the two endpoints of ith line are (i, 0) and (i, height[i]).
    // Find two lines that together with the x-axis form a container, contains the most water

    public int maxArea(int[] height) {

        // two pointers
        int left = 0;
        int right = height.length - 1;

        int max = 0;
        while(left < right) {
            int width = right - left;
            int hi = Math.min(height[left], height[right]);
            int area = width * hi;
            max = Math.max(max, area);
            if (height[left] < height[right]) left++;
            else if (height[left] > height[right]) right--;
            else {
                left++;
                right--;
            }
        }
        return max;
    }



    // 42 Trapping Rain Water

    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        int max = Integer.MIN_VALUE;

        // find left max
        for (int i = 0; i < height.length; i++) {
            if (max < height[i]) {
                max = height[i];
            }
            leftMax[i] = max;
        }

        max = Integer.MIN_VALUE;
        // Find right max
        for (int i = height.length - 1; i >= 0; i--) {
            if (max < height[i]) {
                max = height[i];
            }
            rightMax[i] = max;
        }

        // Find how many units of rain water is trapped
        int count = 0;
        for (int j = 0; j < height.length; j++) {
            count += (Math.min(leftMax[j], rightMax[j] - height[j]));
        }

        return count;


    }


    // 20 Valid Parentheses
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();


        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();
                if ((ch == ')' && top != '(') || (ch == ']' && top != '[') || (ch == '}' && top != '{')) {
                    return false;
                }

            }
        }

        return stack.isEmpty() ? true : false;
    }


    // 704 Binary Search -> Easy
    public int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;

    }



    // 206 Reverse a linked list
   public ListNode reverseList(ListNode head) {

       ListNode prev = null;
       ListNode curr = head;

       while(curr != null) {
           ListNode next = curr.next;
           curr.next = prev;
           prev = curr;
           curr = next;
       }

       return prev;
    }


    // 155 Min Stack

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    public void Minstack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);

        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            if (stack.peek().equals(minStack.peek())) {
                minStack.pop();
            }
            stack.pop();
        }
    }

    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        throw new IllegalArgumentException("Stack empty");
    }

    public int getMin() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        }
        throw new IllegalArgumentException("Minstack is empty");
    }



    // 74. Search a 2D Matrix
    public boolean searchMatrix(int[][] matrix, int target) {

        // we can use binary search

        int left = 0;
        int right = matrix.length - 1;


        while (left <= right) {
            int row = (left + right) / 2;
            if (target > matrix[row][matrix[row].length - 1]) {
                left = row + 1;
            } else if (target < matrix[row][0]) {
                right = row - 1;
            } else {
                int l = 0;
                int r = matrix[row].length - 1;

                while(l <= r) {
                    int m = (l + r) / 2;

                    if (target > matrix[row][m]) {
                        l = m + 1;
                    } else if (target < matrix[row][m]) {
                        r = m - 1;
                    } else {
                        return true;
                    }
                }
                break;

            }

        }




        return false;


    }




    // 567 Permutation in String

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> stringOne = new HashMap<>();
        Map<Character, Integer> stringTwo = new HashMap<>();

        // Initialize stringOne hash map with character frequencies from s1
        for (char c : s1.toCharArray()) {
            stringOne.put(c, stringOne.getOrDefault(c, 0) + 1);
        }

        int matches = 0;

        // Initialize the sliding window with the length of s1
        for (int i = 0; i < s1.length(); i++) {
            char c = s2.charAt(i);
            stringTwo.put(c, stringTwo.getOrDefault(c, 0) + 1);

            // Compare the current window of characters
            if (stringTwo.get(c).equals(stringOne.get(c))) {
                matches++;
            }
        }

        // Slide the window across s2
        for (int i = s1.length(); i < s2.length(); i++) {
            // Check if the current window has the same character frequencies
            // as the stringOne hash map
            if (matches == stringOne.size()) {
                return true;
            }

            char addChar = s2.charAt(i);
            char removeChar = s2.charAt(i - s1.length());

            // Update stringTwo hash map for the sliding window
            stringTwo.put(addChar, stringTwo.getOrDefault(addChar, 0) + 1);
            if (stringTwo.get(addChar).equals(stringOne.get(addChar))) {
                matches++;
            }

            stringTwo.put(removeChar, stringTwo.get(removeChar) - 1);
            if (stringTwo.get(removeChar).equals(stringOne.get(removeChar))) {
                matches--;
            }
        }

        // Check for the last window
        return matches == stringOne.size();
    }




    // 150 Evaluate Reverse Polish Notation
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (tokens[i].equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if (tokens[i].equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (tokens[i].equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }

        return stack.get(0);


    }




    // 22. Generate Parentheses
    public List<String> generateParenthesis(int n) {
        // only add open parentheses if open < n
        // only add a closing parentheses if closed < open
        // valid if open == closed == n
        List<String> validCombos = new ArrayList<>();
        backTrack("", 0, 0, n, validCombos);
        return validCombos;
    }


    public void backTrack(String current, int open, int closed, int n, List<String> validCombos) {
        if (current.length() < 2 * n) {
            validCombos.add(current);
            return;
        }

        if (open < n) {
            backTrack(current + "(", open + 1, closed, n, validCombos);
        }

        if (closed < open) {
            backTrack(current + ")", open, closed + 1, n, validCombos);
        }


    }


    // 739 Given an array of integers temperatures represents the daily temperatures,
    // return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
    // If there is no future day for which this is possible, keep answer[i] == 0 instead.

    public int[] dailyTemperatures(int[] temperatures) {
            int[] results = new int[temperatures.length];

            int n = temperatures.length;

            // monotonic decreasing order -> stack problem
            Stack<Integer> temps = new Stack<>();

            for (int i = n - 1; i >= 0; i--) {
                while(!stack.isEmpty() && temperatures[i] > temperatures[temps.peek()]) {
                    int stackIndex = stack.pop();
                    results[stackIndex] = i - stackIndex;
                }
                stack.push(i);
            }
        return results;

    }




    // 853 Car Fleet
    public int carFleet(int target, int[] position, int[] speed) {

        // O(n log n) solution
        // calculate what time each car going to reach the destination????
        // (target - position) / speed ???

       int n = position.length;
       int[][] cars = new int[n][2];

       for (int i = 0; i < n; i++) {

           cars[i][0] = position[i];
           cars[i][1] = (target - position[i]) / speed[i];
       }


       Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

       int count = 0;
       double prevTime = -1;


       for (int i = 0; i < n; i++) {

           double currentTime = cars[i][1];

           if (currentTime > prevTime) {
               count++;
               prevTime = currentTime;
           }
       }

        return count;
    }



    // 875 Koko Eating Bananas

    public int minEatingSpeed(int[] piles, int h) {

        // binary search solution?
        // h must be greater than or equal to the piles.length

        int left = 1;

        int right = piles[0];
        for (int pile : piles) {
            if (pile > right) {
                right = pile;
            }
        }

        int result = right;

        while (left <= right) {
            int k = (left + right) / 2;
            int hours = 0;

            for (int p : piles) {
                hours += Math.ceil(((double) p / k));
            }

            if (hours <= h) {
                result = Math.min(result, k);
                right = k - 1;
            } else {
                left = k + 1;
            }




        }
        return result;
    }



    // 1523 Count Odd Numbers in an interval range
    // Given two non-negative integers low and high.
    // Return the count of odd numbers between low and high (inclusive).

    public int countOdds(int low, int high) {

        // check for even
        if (low % 2 == 0 && high % 2 == 0) {
            return (high - low) / 2;
        } else {
            return (high - low) / 2 + 1;
        }

    }



    // 204 Count Primes
    // Given an integer n,
    // return the number of prime numbers that are strictly less than n

    public int countPrimes(int n) {

      if (n <= 2) {
          return 0;
      }

      boolean[] isPrime = new boolean[n];
      Arrays.fill(isPrime, true);


      isPrime[0] = false;
      isPrime[1] = false;

      for (int i = 2; i * i < n; i++) {
          if (isPrime[i]) {
              for (int j = i * i; j < n; j+=i) {
                  isPrime[j] = false;
              }
          }
      }


      int count = 0;
      for (boolean prime : isPrime) {
          if (prime) {
              count++;
          }
      }

      return count;

    }









}
