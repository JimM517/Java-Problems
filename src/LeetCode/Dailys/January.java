package LeetCode.Dailys;

import java.util.*;

public class January {


    // 1422. maximum score after splitting a string
    public int maxScore(String s) {

        int result = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            int current = 0;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == '0') {
                    current++;
                }
            }

            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) == '1') {
                    current++;
                }
            }
            result = Math.max(result, current);
        }
        return result;
    }




    // 2559 count vowels strings in ranges
    public int[] vowelStrings(String[] words, int[][] queries) {

        int[] result = new int[queries.length];

        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        int[] prefixSum = new int[words.length];
        int sum = 0;

        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];
            if (vowels.contains(currentWord.charAt(0)) && vowels.contains(currentWord.charAt(currentWord.length() - 1))) {
                sum++;
            }
            prefixSum[i] = sum;
        }

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            result[i] = prefixSum[query[1]] - (query[0] == 0 ? 0 : prefixSum[query[0] - 1]);
        }
        return result;
    }




    // 2270. number of ways to split array
    public int waysToSplitArray(int[] nums) {
//        int n = nums.length;
//
//        long[] prefix = new long[n];
//        prefix[0] = nums[0];
//
//        for (int i = 1; i < n; i++) {
//            prefix[i] = prefix[i - 1] + nums[i];
//        }
//
//
//        int count = 0;
//
//        for (int i = 0; i < n - 1; i++) {
//            long leftSum = prefix[i];
//            long rightSum = prefix[n - 1] - prefix[i];
//
//            if (leftSum >= rightSum) {
//                count++;
//            }
//        }
//        return count;


        /** another solution **/
        long leftSum = 0;
        long rightSum = 0;
        int count = 0;

        for (int num : nums) {
            rightSum += num;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            leftSum += nums[i];
            rightSum -= nums[i];

            if (leftSum >= rightSum) {
                count++;
            }
        }
        return count;

    }





    // 1930. unique length-3 palindromic subsequences
    public int countPalindromicSubsequence(String s) {

       Set<Character> letters = new HashSet<>();
       for (Character ch : s.toCharArray()) {
           letters.add(ch);
       }

       int answer = 0;
       for (Character letter : letters) {
           int i = -1;
           int j = 0;


           for (int k = 0; k < s.length(); k++) {
               if (s.charAt(k) == letter) {
                   if (i == -1) {
                       i = k;
                   }
                   j = k;
               }
           }

           Set<Character> between = new HashSet<>();
           for (int k = i + 1; k < j; k++) {
               between.add(s.charAt(k));
           }
           answer += between.size();
       }
        return answer;
    }




    // 2381. shifting letters II
    public String shiftingLetters(String s, int[][] shifts) {

        int n = s.length();
        int[] diffArray = new int[n];

        for (int[] shift : shifts) {
            if (shift[2] == 1) {
                diffArray[shift[0]]++;
                if (shift[1] + 1 < n) {
                    diffArray[shift[1] + 1]--;
                }
            } else {
                diffArray[shift[0]]--;
                if (shift[1] + 1 < n) {
                    diffArray[shift[1] + 1]++;
                }
            }
        }

        StringBuilder answer = new StringBuilder(s);
        int numberOfShifts = 0;

        for (int i = 0; i < n; i++) {
            numberOfShifts = (numberOfShifts + diffArray[i]) % 26;

            if (numberOfShifts < 0) {
                numberOfShifts += 26;
            }

            char shiftedChar = (char) ('a' + ((s.charAt(i) - 'a' + numberOfShifts) % 26));
            answer.setCharAt(i, shiftedChar);
        }
        return answer.toString();
    }



    // 1769. minimum number of operations to move all balls in each box
    public int[] minOperations(String boxes) {
        int[] answer = new int[boxes.length()];
        for (int currentBox = 0; currentBox < boxes.length(); currentBox++) {
            if (boxes.charAt(currentBox) == '1') {
                for (int newPosition = 0; newPosition < boxes.length(); newPosition++) {
                    answer[newPosition] += Math.abs(newPosition - currentBox);
                }
            }
        }
        return answer;
    }




    // 1408. string matching in an array
    public List<String> stringMatching(String[] words) {

        List<String> matchingWords = new ArrayList<>();
        for (int currentWordIndex = 0; currentWordIndex < words.length; currentWordIndex++) {
            for (int otherWordIndex = 0; otherWordIndex < words.length; otherWordIndex++) {
                if (currentWordIndex == otherWordIndex) continue;
                if (isSubstringOf(words[currentWordIndex], words[otherWordIndex])) {
                    matchingWords.add(words[currentWordIndex]);
                    break;
                }
            }
        }
        return matchingWords;
    }

    private boolean isSubstringOf(String sub, String main) {
        for (int startIndex = 0; startIndex < main.length(); startIndex++) {
            boolean subFits = true;

            for (int subIndex = 0; subIndex < sub.length(); subIndex++) {
                if (startIndex + subIndex >= main.length() || main.charAt(startIndex + subIndex) != sub.charAt(subIndex)) {
                    subFits = false;
                    break;
                }
            }
            if (subFits) {
                return true;
            }

        }

        return false;
    }




    // 3042. count prefix and suffix pairs I
    public int countPrefixSuffixPairs(String[] words) {
        int total = 0;

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (i == j) continue;

                if (isPrefixAndSuffix(words[i], words[j])) {
                    total++;
                }

            }
        }
        return total;
    }


    private boolean isPrefixAndSuffix(String str1, String str2) {

        if (str2.startsWith(str1) && str2.endsWith(str1)) {
            return true;
        }

        return false;

    }




    // 2185. Counting words with a given prefix
    public int prefixCount(String[] words, String pref) {

        int total = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                total++;
            }
        }

        return total;
    }



    // 916. word subsets
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxCharFreq = new int[26];
        int[] tempCharFreq = new int[26];

        for (String word : words2) {
            Arrays.fill(tempCharFreq, 0);
            for (char ch : word.toCharArray()) {
                tempCharFreq[ch - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                maxCharFreq[i] = Math.max(maxCharFreq[i], tempCharFreq[i]);
            }
        }

        List<String> universalWords = new ArrayList<>();

        for (String word : words1) {
            Arrays.fill(tempCharFreq, 0);
            for (char ch : word.toCharArray()) {
                tempCharFreq[ch - 'a']++;
            }

            boolean isUniversal = true;
            for (int i = 0; i < 26; i++) {
                if (maxCharFreq[i] > tempCharFreq[i]) {
                    isUniversal = false;
                    break;
                }
            }
            if (isUniversal) {
                universalWords.add(word);
            }
        }

        return universalWords;
    }




    // 1400. construct k palindrome strings
    public boolean canConstruct(String s, int k) {
        if (s.length() < k) {
            return false;
        }


        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        List<Integer> numChars = new ArrayList<>(map.values());
        int totalOdds = 0;

        for (int num : numChars) {
            if (num % 2 == 1) {
                totalOdds++;
            }
        }

        return totalOdds <= k;
    }





    // 2116. check if parentheses string can be valid
    // TODO review this one
    public boolean canBeValid(String s, String locked) {

        int length = s.length();

        if (length % 2 == 1) {
            return false;
        }

        Stack<Integer> openBrackets = new Stack<>();
        Stack<Integer> unlocked = new Stack<>();

        for (int i = 0; i < length; i++) {
            if (locked.charAt(i) == '0') {
                unlocked.push(i);
            } else if (s.charAt(i) == '(') {
                openBrackets.push(i);
            } else if (s.charAt(i) == ')') {
                if (!openBrackets.empty()) {
                    openBrackets.pop();
                } else if (!unlocked.isEmpty()) {
                    unlocked.pop();
                } else {
                    return false;
                }
            }

        }

        while (!openBrackets.isEmpty() && !unlocked.isEmpty() && openBrackets.peek() < unlocked.peek()) {
            openBrackets.pop();
            unlocked.pop();
        }

        if (!openBrackets.empty()) {
            return false;
        }
        return true;
    }



    // 3223. Minimum length of string after operations
    public int minimumLength(String s) {

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }


        int count = 0;
        for (int x : map.values()) {
            if (x % 2 == 1) {
                count += x - 1;
            } else {
                count += x - 2;
            }
        }

        return s.length() - count;

    }


    // 2657. find the prefix common array of two arrays
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] prefixes = new int[n];

        for (int currentIndex = 0; currentIndex < n; currentIndex++) {
            int commonCount = 0;

            for (int aIndex = 0; aIndex <= currentIndex; aIndex++) {
                for (int bIndex = 0; bIndex <= currentIndex; bIndex++) {
                    if (A[aIndex] == B[bIndex]) {
                        commonCount++;
                        break;
                    }
                }
            }
            prefixes[currentIndex] = commonCount;
        }
        return prefixes;
    }






    // 2429. Minimize XOR
    public int minimizeXor(int num1, int num2) {
        // same number of set bits (1s in its binary representation)

        int result = num1;

        int targetSetBitsCount = Integer.bitCount(num2);
        int setBitsCount = Integer.bitCount(result);

        int currentBit = 0;

        while (setBitsCount < targetSetBitsCount) {
            if (!isSet(result, currentBit)) {
                result = setBit(result, currentBit);
                setBitsCount++;
            }
            currentBit++;
        }

        while (setBitsCount > targetSetBitsCount) {
            if (isSet(result, currentBit)) {
                result = unsetBit(result, currentBit);
                setBitsCount--;
            }
            currentBit++;
        }
        return result;
    }


    private boolean isSet(int x, int bit) {
        return (x & (1 << bit)) != 0;
    }

    private int setBit(int x, int bit) {
        return x | (1 << bit);
    }

    private int unsetBit(int x, int bit) {
        return x & ~(1 << bit);
    }



    public int xorAllNums(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        if (m % 2 == 0 && n % 2 == 0) {
            return 0;
        }

        int xor1 = 0;
        int xor2 = 0;


        if (n % 2 != 0) {
            for (int num : nums1) {
                xor1 ^= num;
            }
        }

        if (m % 2 != 0) {
            for (int num : nums2) {
                xor2 ^= num;
            }
        }


        return xor1 ^ xor2;
    }



    // 2683. neighboring bitwise XOR
    public boolean doesValidArrayExist(int[] derived) {
        int[] original = new int[derived.length + 1];
        original[0] = 0;
        for (int i = 0; i < derived.length; i++) {
            original[i + 1] = derived[i] ^ original[i];
        }

        boolean checkForZero = (original[0] == original[original.length - 1]);

        original[0] = 1;
        for (int i = 0; i < derived.length; i++) {
            original[i + 1] = derived[i] ^ original[i];
        }
        boolean checkForOne = (original[0] == original[original.length - 1]);

        return checkForZero || checkForOne;


        // another solution
//        int XOR = 0;
//        for (int element : derived) {
//            XOR = XOR ^ element;
//        }
//        return XOR == 0;


    }





    // 1368. minimum cost to make at least one valid path in a grid
    public int minCost(int[][] grid) {
            int numRows = grid.length, numCols = grid[0].length;
            int[][] minChanges = new int[numRows][numCols];

            // Initialize all cells with max value
            for (int[] row : minChanges) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
            minChanges[0][0] = 0;

            while (true) {
                // Store previous state to check for convergence
                int[][] prevState = new int[numRows][numCols];
                for (int row = 0; row < numRows; row++) {
                    prevState[row] = Arrays.copyOf(minChanges[row], numCols);
                }

                // Forward pass: check cells coming from left and top
                for (int row = 0; row < numRows; row++) {
                    for (int col = 0; col < numCols; col++) {
                        // Check cell above
                        if (row > 0) {
                            minChanges[row][col] = Math.min(
                                    minChanges[row][col],
                                    minChanges[row - 1][col] +
                                            (grid[row - 1][col] == 3 ? 0 : 1)
                            );
                        }
                        // Check cell to the left
                        if (col > 0) {
                            minChanges[row][col] = Math.min(
                                    minChanges[row][col],
                                    minChanges[row][col - 1] +
                                            (grid[row][col - 1] == 1 ? 0 : 1)
                            );
                        }
                    }
                }

                // Backward pass: check cells coming from right and bottom
                for (int row = numRows - 1; row >= 0; row--) {
                    for (int col = numCols - 1; col >= 0; col--) {
                        // Check cell below
                        if (row < numRows - 1) {
                            minChanges[row][col] = Math.min(
                                    minChanges[row][col],
                                    minChanges[row + 1][col] +
                                            (grid[row + 1][col] == 4 ? 0 : 1)
                            );
                        }
                        // Check cell to the right
                        if (col < numCols - 1) {
                            minChanges[row][col] = Math.min(
                                    minChanges[row][col],
                                    minChanges[row][col + 1] +
                                            (grid[row][col + 1] == 2 ? 0 : 1)
                            );
                        }
                    }
                }

                // If no changes were made in this iteration, we've found optimal solution
                if (Arrays.deepEquals(prevState, minChanges)) {
                    break;
                }
            }

            return minChanges[numRows - 1][numCols - 1];
        }




    // trapping rain water II
    // TODO review the below solution
    public int trapRainWater(int[][] heightMap) {

        // Direction arrays
        int[] dRow = { 0, 0, -1, 1 };
        int[] dCol = { -1, 1, 0, 0 };

        int numOfRows = heightMap.length;
        int numOfCols = heightMap[0].length;

        boolean[][] visited = new boolean[numOfRows][numOfCols];

        // Priority queue (min-heap) to process boundary cells in increasing height order
        PriorityQueue<Cell> boundary = new PriorityQueue<>();

        // Add the first and last column cells to the boundary and mark them as visited
        for (int i = 0; i < numOfRows; i++) {
            boundary.offer(new Cell(heightMap[i][0], i, 0));
            boundary.offer(
                    new Cell(heightMap[i][numOfCols - 1], i, numOfCols - 1)
            );
            // Mark left and right boundary cells as visited
            visited[i][0] = visited[i][numOfCols - 1] = true;
        }

        // Add the first and last row cells to the boundary and mark them as visited
        for (int i = 0; i < numOfCols; i++) {
            boundary.offer(new Cell(heightMap[0][i], 0, i));
            boundary.offer(
                    new Cell(heightMap[numOfRows - 1][i], numOfRows - 1, i)
            );
            // Mark top and bottom boundary cells as visited
            visited[0][i] = visited[numOfRows - 1][i] = true;
        }

        // Initialize the total water volume to 0
        int totalWaterVolume = 0;

        // Process cells in the boundary (min-heap will always pop the smallest height)
        while (!boundary.isEmpty()) {
            // Pop the cell with the smallest height from the boundary
            Cell currentCell = boundary.poll();

            int currentRow = currentCell.row;
            int currentCol = currentCell.col;
            int minBoundaryHeight = currentCell.height;

            // Explore all 4 neighboring cells
            for (int direction = 0; direction < 4; direction++) {
                // Calculate the row and column of the neighbor
                int neighborRow = currentRow + dRow[direction];
                int neighborCol = currentCol + dCol[direction];

                // Check if the neighbor is within the grid bounds and not yet visited
                if (
                        isValidCell(
                                neighborRow,
                                neighborCol,
                                numOfRows,
                                numOfCols
                        ) &&
                                !visited[neighborRow][neighborCol]
                ) {
                    // Get the height of the neighbor cell
                    int neighborHeight = heightMap[neighborRow][neighborCol];

                    // If the neighbor's height is less than the current boundary height, water can be trapped
                    if (neighborHeight < minBoundaryHeight) {
                        // Add the trapped water volume
                        totalWaterVolume += minBoundaryHeight - neighborHeight;
                    }

                    // Push the neighbor into the boundary with updated height (to prevent water leakage)
                    boundary.offer(
                            new Cell(
                                    Math.max(neighborHeight, minBoundaryHeight),
                                    neighborRow,
                                    neighborCol
                            )
                    );
                    visited[neighborRow][neighborCol] = true;
                }
            }
        }

        // Return the total amount of trapped water
        return totalWaterVolume;
    }

    // Class to store the height and coordinates of a cell in the grid
    private static class Cell implements Comparable<Cell> {

        int height;
        int row;
        int col;

        // Constructor to initialize a cell
        public Cell(int height, int row, int col) {
            this.height = height;
            this.row = row;
            this.col = col;
        }

        // Overload the compareTo method to make the priority queue a min-heap based on height
        @Override
        public int compareTo(Cell other) {
            // Min-heap comparison
            return Integer.compare(this.height, other.height);
        }
    }

    // Helper function to check if a cell is valid (within grid bounds)
    private boolean isValidCell(
            int row,
            int col,
            int numOfRows,
            int numOfCols
    ) {
        return row >= 0 && col >= 0 && row < numOfRows && col < numOfCols;

    }




    // 2661. first completely painted row or column
    public int firstCompleteIndex(int[] arr, int[][] mat) {

        int numRows = mat.length;
        int numCols = mat[0].length;

       int[] rowCount = new int[numRows];
       int[] colCount = new int[numCols];

       Map<Integer, int[]> numToPos = new HashMap<>();

       for (int row = 0; row < numRows; row++) {
           for (int col = 0; col < numCols; col++) {
               int value = mat[row][col];
               numToPos.put(value, new int[]{row, col});
           }
       }

       for (int i = 0; i < arr.length; i++) {
           int num = arr[i];
           int[] pos = numToPos.get(num);
           int row = pos[0];
           int col = pos[1];

           rowCount[row]++;
           colCount[col]++;

           if (rowCount[row] == numCols || colCount[col] == numRows) {
               return i;
           }
       }

        return -1;
    }





    // 1267. Count servers that communicate
    public int countServers(int[][] grid) {
        int numRows = grid.length;
        int numCols = numRows > 0 ? grid[0].length : 0;
        int communicableServersCount = 0;

        // Traverse through the grid
        for (int row = 0; row < numRows; ++row) {
            for (int col = 0; col < numCols; ++col) {
                if (grid[row][col] == 1) {
                    boolean canCommunicate = false;

                    // Check for communication in the same row
                    for (int otherCol = 0; otherCol < numCols; ++otherCol) {
                        if (otherCol != col && grid[row][otherCol] == 1) {
                            canCommunicate = true;
                            break;
                        }
                    }

                    // If a server was found in the same row, increment
                    // communicableServersCount
                    if (canCommunicate) {
                        communicableServersCount++;
                    } else {
                        // Check for communication in the same column
                        for (int otherRow = 0; otherRow < numRows; ++otherRow) {
                            if (otherRow != row && grid[otherRow][col] == 1) {
                                canCommunicate = true;
                                break;
                            }
                        }

                        // If a server was found in the same column, increment
                        // communicableServersCount
                        if (canCommunicate) {
                            communicableServersCount++;
                        }
                    }
                }
            }
        }

        return communicableServersCount;
    }












}
