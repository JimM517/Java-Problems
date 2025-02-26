package LeetCode.Dailys;

import java.util.*;
import java.util.stream.Collectors;

public class February {


    // 3151. Special Array I
    public boolean isArraySpecial(int[] nums) {


        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int prev = nums[i - 1];

            if ((curr % 2 == 0) && (prev % 2 == 0)) {
                return false;
            }

            if ((curr % 2 == 1) && (prev % 2 == 1)) {
                return false;
            }

        }
        return true;
    }





    // 1752. check if array is sorted and rotated
    public boolean check(int[] nums) {

        int n = nums.length;

        int[] checkedSorted = new int[n];

        for (int rotationOffSet = 0; rotationOffSet < n; rotationOffSet++) {
            int currInx = 0;
            for (int index = rotationOffSet; index < n; index++) {
                checkedSorted[currInx++] = nums[index];
            }
            for (int index = 0; index < rotationOffSet; index++) {
                checkedSorted[currInx++] = nums[index];
            }

            boolean isSorted = true;
            for (int index = 0; index < n - 1; index++) {
                if (checkedSorted[index] > checkedSorted[index + 1]) {
                    isSorted = false;
                    break;
                }
            }

            if (isSorted) {
                return true;
            }

        }
        return false;
    }



    // 3105. longest strictly increasing or strictly decreasing subarray
    public int longestMonotonicSubarray(int[] nums) {
            int maxLength = 0;

            // Find longest strictly increasing subarray
            for (int start = 0; start < nums.length; start++) {
                int currLength = 1;
                for (int pos = start + 1; pos < nums.length; pos++) {
                    // Extend subarray if next element is larger
                    if (nums[pos] > nums[pos - 1]) {
                        currLength++;
                    } else {
                        // Break if sequence is not increasing anymore
                        break;
                    }
                }
                maxLength = Math.max(maxLength, currLength);
            }

            // Find longest strictly decreasing subarray
            for (int start = 0; start < nums.length; start++) {
                int currLength = 1;
                for (int pos = start + 1; pos < nums.length; pos++) {
                    // Extend subarray if next element is smaller
                    if (nums[pos] < nums[pos - 1]) {
                        currLength++;
                    } else {
                        // Break if sequence is not decreasing anymore
                        break;
                    }
                }
                maxLength = Math.max(maxLength, currLength);
            }

            return maxLength; // Return the longer of increasing or decreasing sequences
        }





        // 1800 maximum ascending subarray sum
        public int maxAscendingSum(int[] nums) {

            int maxSum = 0;
            int currentSubarraySum = nums[0];

            for (int currentIdx = 1; currentIdx < nums.length; currentIdx++) {
                if (nums[currentIdx] <= nums[currentIdx - 1]) {
                    maxSum = Math.max(maxSum, currentSubarraySum);

                    currentSubarraySum = 0;
                }
                currentSubarraySum += nums[currentIdx];
            }

            return Math.max(maxSum, currentSubarraySum);
        }







        // 1790. check if one string swap can make strings equal
        public boolean areAlmostEqual(String s1, String s2) {

            int firstIndexDiff = 0;
            int secondIndexDiff = 0;
            int numDifference = 0;

            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    numDifference++;

                    if (numDifference > 2) {
                        return false;
                    } else if (numDifference == 1) {
                        firstIndexDiff = i;
                    } else {
                        secondIndexDiff = i;
                    }

                }
            }

            return (s1.charAt(firstIndexDiff) == s2.charAt(secondIndexDiff) && (s1.charAt(secondIndexDiff) == s2.charAt(firstIndexDiff)));
        }




        // 1726. tuple with same product
        public int tupleSameProduct(int[] nums) {

            int numsLength = nums.length;
            Arrays.sort(nums);

            int totalNumberOfTuples = 0;

            for (int aIndex = 0; aIndex < numsLength; aIndex++) {

                for (int bIndex = nums.length - 1; bIndex >= aIndex + 1; bIndex--) {

                    int product = nums[aIndex] * nums[bIndex];

                    Set<Integer> possibleDValues = new HashSet<>();

                    for (int cIndex = aIndex + 1; cIndex < bIndex; cIndex++) {

                        if (product % nums[cIndex] == 0) {
                            int dValue = product / nums[cIndex];

                            if (possibleDValues.contains(dValue)) {
                                totalNumberOfTuples += 8;
                            }

                            possibleDValues.add(nums[cIndex]);
                        }

                    }
                }

            }

            return totalNumberOfTuples;
        }






        // 3160. find the number of distinct colors among the balls
        public int[] queryResults(int limit, int[][] queries) {
            int n = queries.length;
            int[] result = new int[n];
            Map<Integer, Integer> colorMap = new HashMap<>();
            Map<Integer, Integer> ballMap = new HashMap<>();

            // Iterate through queries
            for (int i = 0; i < n; i++) {
                // Extract ball label and color from query
                int ball = queries[i][0];
                int color = queries[i][1];

                // Check if ball is already colored
                if (ballMap.containsKey(ball)) {
                    // Decrement count of the previous color on the ball
                    int prevColor = ballMap.get(ball);
                    colorMap.put(prevColor, colorMap.get(prevColor) - 1);

                    // If there are no balls with previous color left, remove color from color map
                    if (colorMap.get(prevColor) == 0) {
                        colorMap.remove(prevColor);
                    }
                }
                // Set color of ball to the new color
                ballMap.put(ball, color);

                // Increment the count of the new color
                colorMap.put(color, colorMap.getOrDefault(color, 0) + 1);

                result[i] = colorMap.size();
            }
            return result;
        }







        // 2349. design a number container system
    class NumberContainers {

            // Maps from number to set of indices and from index to number
            private Map<Integer, TreeSet<Integer>> numberToIndices;
            private Map<Integer, Integer> indexToNumbers;

            // Constructor
            public NumberContainers() {
                // Initialize the data structures
                numberToIndices = new HashMap<>();
                indexToNumbers = new HashMap<>();
            }

            public void change(int index, int number) {
                // If index already has a number, remove it from the old number's index set
                if (indexToNumbers.containsKey(index)) {
                    int previousNumber = indexToNumbers.get(index);
                    numberToIndices.get(previousNumber).remove(index);
                    if (numberToIndices.get(previousNumber).isEmpty()) {
                        numberToIndices.remove(previousNumber);
                    }
                }
                // Update the number and add the index to the new number's set
                indexToNumbers.put(index, number);
                numberToIndices.putIfAbsent(number, new TreeSet<>());
                numberToIndices.get(number).add(index);
            }

            public int find(int number) {
                // Return the smallest index for the given number, or -1 if not found
                if (numberToIndices.containsKey(number)) {
                    return numberToIndices.get(number).first(); // Get the smallest index
                }
                return -1;
            }



        }


        // 2364. Count number of bad pairs
        public long countBadPairs(int[] nums) {

                long pairs = 0;
                Map<Integer, Integer> diffCount = new HashMap<>();

                for (int i = 0; i < nums.length; i++) {
                    int diff = i - nums[i];

                    int goodPairs = diffCount.getOrDefault(diff, 0);

                    pairs += i - goodPairs;

                    diffCount.put(diff, goodPairs + 1);

                }
                return pairs;
        }



        // 3174. clear digits
        public String clearDigits(String s) {
            // delete digits and first closest non-digit to its left

            StringBuilder result = new StringBuilder();

            Stack<Character> stacks = new Stack<>();

            for (char ch : s.toCharArray()) {

                if (Character.isDigit(ch)) {
                    while (!stacks.isEmpty() && Character.isDigit(stacks.peek())) {
                        stacks.pop();
                    }
                    if (!stacks.isEmpty()) {
                        stacks.pop();
                    }
                } else {
                    stacks.push(ch);
                }
            }

            for (char ch : stacks) {
                result.append(ch);
            }


            return result.toString();

        }


        // 1910. remove all occurrences of a substring
        public String removeOccurrences(String s, String part) {


            StringBuilder sb = new StringBuilder(s);

            while (s.indexOf(part) != -1) {

                int idx = sb.indexOf(part);

                sb.delete(idx, idx + part.length());



            }




            return sb.toString();

    }




    // 2342. max sum of a pair with equal sum of digits
    public int maximumSum(int[] nums) {

        int maxSum = -1;

        Map<Integer, Integer> maxes = new HashMap<>();
        for (int num : nums) {
            int summedDigits = sumDigits(num);

            if (maxes.containsKey(summedDigits)) {
                maxSum = Math.max(maxSum, num + maxes.get(summedDigits));
                maxes.put(summedDigits, Math.max(maxes.get(summedDigits), num));

            } else {
                maxes.put(summedDigits, num);
            }

        }
        return maxSum;

    }

    public int sumDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }




    // 3066. minimum operations to exceed threshold II
    public int minOperations(int[] nums, int k) {

        PriorityQueue<Long> queue = new PriorityQueue<>(
                Arrays.stream(nums)
                .mapToLong(i -> (long) i)
                .boxed()
                .collect(Collectors.toList())
            );

        int result = 0;

        while (queue.peek() < k) {
            long num1 = queue.remove();
            long num2 = queue.remove();

            long numToAdd = num1 * 2 + num2;
            queue.add(numToAdd);
            result++;
        }

        return result;
    }






    // 1352. product of the last k numbers
    class ProductOfNumbers {
        private List<Integer> list;

        public ProductOfNumbers() {
            this.list = new ArrayList<>();
            list.add(1);
        }

        public void add(int num) {
            if (num == 0) {
                list.clear();
                list.add(1);
            } else {
                int last = list.get(list.size() - 1);
                list.add(last * num);
            }
        }

        public int getProduct(int k) {
            int n = list.size();

            if (k >= n) {
                return 0;
            }

            return list.get(n - 1) / list.get(n - 1 - k);
        }


    }





    // 2698. find the punishment number of an integer
    public int punishmentNumber(int n) {
            int punishNum = 0;

            for (int i = 0; i <= n; i++) {
                int squared = i * i;

                if (checkPartition(squared, i)) {
                    punishNum += squared;
                }
            }
        return punishNum;
    }



    public boolean checkPartition(int num, int target) {

        if (target < 0 || num < target) {
            return false;
        }

        if (num == target) {
            return true;
        }

        return (
                checkPartition(num / 10, target - (num % 10)) ||
                checkPartition(num / 100, target - (num % 100)) ||
                checkPartition(num / 1000, target - (num % 1000))
                );



    }



    // 1718. construct the lexiographically largest valid sequence
    public int[] constructDistancedSequence(int n) {

        int[] resultSequence = new int[n * 2 - 1];

        boolean[] isNumberUsed = new boolean[n + 1];

        findLexicographicallyLargestSequence(0, resultSequence, isNumberUsed, n);

        return resultSequence;

    }

    private boolean findLexicographicallyLargestSequence(int currentIndex, int[] resultSequence, boolean[] isNumberUsed, int targetNumber) {

        if (currentIndex == resultSequence.length) {
            return true;
        }

        if (resultSequence[currentIndex] != 0) {
            return findLexicographicallyLargestSequence(currentIndex + 1, resultSequence, isNumberUsed, targetNumber);
        }

        for (int numberToPlace = targetNumber; numberToPlace >= 1; numberToPlace--) {
            if (isNumberUsed[numberToPlace]) continue;

            isNumberUsed[numberToPlace] = true;
            resultSequence[currentIndex] = numberToPlace;

            if (numberToPlace == 1){
                if (findLexicographicallyLargestSequence(currentIndex + 1, resultSequence, isNumberUsed, targetNumber)) {
                    return true;
                }
            } else if (currentIndex + numberToPlace < resultSequence.length && resultSequence[currentIndex + numberToPlace] == 0) {
                resultSequence[currentIndex + numberToPlace] = numberToPlace;

                if (findLexicographicallyLargestSequence(currentIndex + 1, resultSequence, isNumberUsed, targetNumber)) {
                    return true;
                }
                resultSequence[currentIndex + numberToPlace] = 0;
            }
            resultSequence[currentIndex] = 0;
            isNumberUsed[numberToPlace] = false;
        }



        return false;


    }




    // 1079. letter tile possibilities
    public int numTilePositions(String tiles) {

        Set<String> result = new HashSet<>();
        boolean[] used = new boolean[tiles.length()];
        checkPermutations(tiles, new StringBuilder(), used, result);

        return result.size();

    }

    public void checkPermutations(String s, StringBuilder sb, boolean[] used, Set<String> result) {

        if (sb.length() > 0) {
            result.add(sb.toString());
        }

        for (int i = 0; i < s.length(); i++) {

            if (used[i]) continue;

            used[i] = true;
            sb.append(s.charAt(i));

            checkPermutations(s, sb, used, result);

            sb.deleteCharAt(sb.length() - 1);
            used[i] = false;
        }


    }


    // 2375. construct smallest number from DI string
    public String smallestNumber(String pattern) {

        Stack<Integer> numStack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= pattern.length(); i++) {

            numStack.add(i + 1);

            if (i == pattern.length() || pattern.charAt(i) == 'I') {
                while (!numStack.isEmpty()) {
                    sb.append(numStack.pop());
                }
            }


        }
        return sb.toString();
    }




    // 1415. The k-th lexicographical string of all happy strings of length n
    List<String> happyStrings = new ArrayList<>();
    public String getHappyString(int n, int k) {

        String currentString = "";

        generateHappyString(n, currentString);

        if (happyStrings.size() < k) {
            return "";
        }

        Collections.sort(happyStrings);

        return happyStrings.get(k - 1);

    }

    public void generateHappyString(int n, String currentString) {

        if (currentString.length() == n) {
            happyStrings.add(currentString);
            return;
        }

        for (char curr = 'a'; curr <= 'c'; curr++) {

            if (currentString.length() > 0 && currentString.charAt(currentString.length() - 1) == curr) {
                continue;
            }

            generateHappyString(n, currentString + curr);
        }


    }




    // 1980. Find unique binary string
    public String findDifferentBinaryString(String[] nums) {

            // cantors diagonal argument
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < nums.length; i++) {
                Character current = nums[i].charAt(i);
                sb.append(current == '0' ? '1' : '0');
            }

            return sb.toString();

    }





    // 1524. number of subarrays with odd sum
    public int numOfSubarrays(int[] arr) {

        int MOD = (int) Math.pow(10, 9) + 7;
        int n = arr.length;

        for (int num = 0; num < n; num++) {
            arr[num] %= 2;
        }


        int[] dpEven = new int[n], dpOdd = new int[n];

        if (arr[n - 1] == 0) {
            dpEven[n - 1] = 1;
        } else {
            dpOdd[n - 1] = 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] == 1) {
                dpOdd[i] = (1 + dpEven[i + 1]) % MOD;
                dpEven[i] = dpOdd[i + 1];
            } else {
                dpEven[i] = (1 + dpEven[i + 1]) % MOD;
                dpOdd[i] = dpOdd[i + 1];
            }
        }

        int count = 0;
        for (int odd : dpOdd) {
            count += odd;
            count %= MOD;
        }
        return count;
    }





    // definition for binary tree
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {};
        TreeNode(int val) {
            this.val = val;
        };
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }



    // 1028. recover a tree from preorder traversal
    static int index = 0;

    public TreeNode recoverFromPreorder(String traversal) {

        index = 0;
        return helper(traversal, index);


    }

    private TreeNode helper(String traversal, int depth) {

        if (index >= traversal.length()) return null;

        int dashCount = 0;
        while ((index + dashCount) < traversal.length() && traversal.charAt(index + dashCount) == '-') {
            dashCount++;
        }
        if (dashCount != depth) return null;

        index += dashCount;

        int value = 0;
        while (index < traversal.length() && Character.isDigit(traversal.charAt(index))) {
            value = value * 10 + (traversal.charAt(index++) - '0');
        }

        TreeNode node = new TreeNode(value);

        node.left = helper(traversal, depth + 1);
        node.right = helper(traversal, depth + 1);
        return node;
    }






    // 889. Construct binary tree from preorder and postorder traversal
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {

        int numOfNodes = preorder.length;
        return constructTree(0, numOfNodes - 1, 0, preorder, postorder);



    }


    private TreeNode constructTree(int preStart, int preEnd, int postStart, int[] preorder, int[] postorder) {


        if (preStart > preEnd) {
            return null;
        }

        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        int leftRoot = preorder[preStart + 1];

        int numOfNodesInLeft = 1;
        while (postorder[postStart + numOfNodesInLeft - 1] != leftRoot) {
            numOfNodesInLeft++;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        root.left = constructTree(preStart + 1, preStart + numOfNodesInLeft, postStart, preorder, postorder);
        root.right = constructTree(preStart + numOfNodesInLeft + 1, preEnd, postStart + numOfNodesInLeft, preorder, postorder);

        return root;
    }
























































































































































































































































}
