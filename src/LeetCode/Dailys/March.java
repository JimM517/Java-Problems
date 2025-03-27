package LeetCode.Dailys;

import java.util.*;

public class March {

    // march 2025 dailys
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        int[] modifiedNums = new int[n];
        int zeroCount = 0;

        // Step 1: Apply operations on the array
        for (int index = 0; index < n - 1; index++) {
            if (nums[index] == nums[index + 1] && nums[index] != 0) {
                nums[index] *= 2;
                nums[index + 1] = 0;
            }
        }

        // Step 2: Move non-zero elements to the front
        for (int num : nums) {
            if (num != 0) {
                modifiedNums[zeroCount++] = num;
            }
        }

        // Step 3: Append zeros to maintain the original size
        while (zeroCount < n) {
            modifiedNums[zeroCount++] = 0;
        }

        return modifiedNums;
    }


    // 2570. merge two 2D arrays by summing values
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {

        Map<Integer, Integer> map = new TreeMap<>();

        for (int[] nums : nums1) {
            map.put(nums[0], nums[1]);
        }

        for (int[] nums : nums2) {
            map.put(nums[0], map.getOrDefault(nums[0], 0) + nums[1]);
        }

        List<int[]> merged = new ArrayList<>();
        for (Map.Entry<Integer, Integer> x : map.entrySet()) {
            merged.add(new int[] {x.getKey(), x.getValue()});
        }


        int[][] result = new int[merged.size()][2];
        for (int i = 0; i < merged.size(); i++) {
            result[i] = merged.get(i);
        }
        return result;
    }



    // 2161. partition array according to given pivot
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> less = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();

        for (int num : nums) {
            if (num < pivot) {
                less.add(num);
            } else if (num > pivot) {
                greater.add(num);
            } else {
                equal.add(num);
            }
        }

        less.addAll(equal);
        less.addAll(greater);

        int[] result = new int[nums.length];
        int idx = 0;
        for (int num : less) {
            result[idx++] = num;
        }

        return result;
    }




    // 1780. check if number is a sum of powers of three
    public boolean checkPowersOfThree(int n) {

        while (n > 0) {

            if (n % 3 == 2) {
                return false;
            }

            n /= 3;
        }


        return true;

    }




    // 2579. Count total number of colored cells
    public long coloredCells(int n) {
        return (long) Math.pow(n, 2) + (long) Math.pow((n - 1), 2);
    }



    // find missing and repeated values
    public int[] findMissingAndRepeatedValues(int[][] grid) {

        int n = grid.length;
        int missing = -1;
        int repeat = -1;

        Map<Integer, Integer> freq = new HashMap<>();
        for (int[] row : grid) {
            for (int num : row) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }
        }


        for (int num = 1; num <= n * n; num++) {
            if (!freq.containsKey(num)) {
                missing = num;
            } else if (freq.get(num) == 2) {
                repeat = num;
            }
        }



        return new int[] {repeat, missing};


    }



    // 2523. closest prime numbers in a range
    public int[] closestPrimes(int left, int right) {

        int[] sieveArray = sieve(right);

        List<Integer> primeNumbers = new ArrayList<>();
        for (int num = left; num <= right; num++) {
            if (sieveArray[num] == 1) {
                primeNumbers.add(num);
            }
        }


        if (primeNumbers.size() < 2) {
            return new int[]{-1, -1};
        }

        int minDiff = Integer.MAX_VALUE;
        int[] closestPair = new int[2];
        Arrays.fill(closestPair, -1);

        for (int i = 1; i < primeNumbers.size(); i++) {
            int diff = primeNumbers.get(i) - primeNumbers.get(i - 1);
            if (diff < minDiff) {
                minDiff = diff;
                closestPair[0] = primeNumbers.get(i - 1);
                closestPair[1] = primeNumbers.get(i);
            }
        }
        return closestPair;
    }



    public int[] sieve(int upper) {

        int[] sieve = new int[upper + 1];

        Arrays.fill(sieve, 1);
        sieve[0] = 0;
        sieve[1] = 0;

        for (int p = 2; p * p <= upper; p++) {
            if (sieve[p] == 1) {
                for (int j = p * p; j <= upper; j += p) {
                    sieve[j] = 0;
                }
            }
        }

        return sieve;
    }



    // 2379. minimum recolors to get k consecutive black blocks
    public int minimumRecolors(String blocks, int k) {

        int left = 0;
        int numWhites = 0;
        int numRecolors = Integer.MAX_VALUE;

        for (int right = 0; right < blocks.length(); right++) {

            if (blocks.charAt(right) == 'W') {
                numWhites++;
            }


            if (right - left + 1 == k) {
                numRecolors = Math.min(numRecolors, numWhites);


                if (blocks.charAt(left) == 'W') {
                    numWhites--;
                }
                left++;

            }


        }


        return numRecolors;

    }




    // alternating groups II
    public int numOfAlternatingGroups(int[] colors, int k) {

        int length = colors.length;
        int result = 0;

        int alternatingElems = 1;
        int lastColor = colors[0];

        for (int i = 1; i < length + k - 1; i++) {
            int index = i % length;

            if (colors[index] == lastColor) {
                alternatingElems = 1;
                lastColor = colors[index];
                continue;
            }

            alternatingElems++;

            if (alternatingElems >= k) {
                result++;
            }

            lastColor = colors[index];
        }


        return result;

    }




    // 3306. count of substrings containing every vowel and k consonants II
    public long countOfSubstrings(String word, int k) {
            long numValidSubstrings = 0;
            int start = 0;
            int end = 0;
            // keep track of counts of vowels and consonants
            HashMap<Character, Integer> vowelCount = new HashMap<>();
            int consonantCount = 0;

            // compute index of next consonant for all indices
            int[] nextConsonant = new int[word.length()];
            int nextConsonantIndex = word.length();
            for (int i = word.length() - 1; i >= 0; i--) {
                nextConsonant[i] = nextConsonantIndex;
                if (!isVowel(word.charAt(i))) {
                    nextConsonantIndex = i;
                }
            }

            // start sliding window
            while (end < word.length()) {
                // insert new letter
                char newLetter = word.charAt(end);

                // update counts
                if (isVowel(newLetter)) {
                    vowelCount.put(
                            newLetter,
                            vowelCount.getOrDefault(newLetter, 0) + 1
                    );
                } else {
                    consonantCount++;
                }

                // shrink window if too many consonants in our window
                while (consonantCount > k) {
                    char startLetter = word.charAt(start);
                    if (isVowel(startLetter)) {
                        vowelCount.put(
                                startLetter,
                                vowelCount.get(startLetter) - 1
                        );
                        if (vowelCount.get(startLetter) == 0) {
                            vowelCount.remove(startLetter);
                        }
                    } else {
                        consonantCount--;
                    }
                    start++;
                }

                // while we have a valid window, try to shrink it
                while (
                        start < word.length() &&
                                vowelCount.keySet().size() == 5 &&
                                consonantCount == k
                ) {
                    // count the current valid substring, as well as valid substrings produced by appending more vowels
                    numValidSubstrings += nextConsonant[end] - end;
                    char startLetter = word.charAt(start);
                    if (isVowel(startLetter)) {
                        vowelCount.put(
                                startLetter,
                                vowelCount.get(startLetter) - 1
                        );
                        if (vowelCount.get(startLetter) == 0) {
                            vowelCount.remove(startLetter);
                        }
                    } else {
                        consonantCount--;
                    }

                    start++;
                }
                end++;
            }

            return numValidSubstrings;
        }

        private boolean isVowel(char c) {
            return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
        }





    // 2529. maximum count of positive and negative integers
    public int maximumCount(int[] nums) {

        int pos = 0;
        int neg = 0;

        for (int num : nums) {
            if (num > 0) {
                pos++;
            } else if (num < 0) {
                neg++;
            }
        }



        return Math.max(pos, neg);
    }




// 2226. maximum candies allocated to k children
   public int maximumCandies(int[] candies, long k) {

        int maxCandies = 0;


        for (int i = 0; i < candies.length; i++) {
            maxCandies = Math.max(maxCandies, candies[i]);
        }

        int left = 0;
        int right = maxCandies;

        while (left < right) {
            int mid = (left + right + 1) / 2;

            if (canAllocate(candies, k, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }


        return left;

   }


    private boolean canAllocate(int[] candies, long k, int numOfCandies) {

        long maxNumOfChildren = 0;

        for (int index = 0; index < candies.length; index++) {
            maxNumOfChildren += candies[index] / numOfCandies;
        }

        return maxNumOfChildren >= k;



    }





    // 2560. house robber IV
    public int minCapability(int[] nums, int k) {

        int min = 1;
        int max = Arrays.stream(nums).max().getAsInt();
        int total = nums.length;

        while (min < max) {

            int mid = (min + max) / 2;

            int possible = 0;

            for (int i = 0; i < total; i++) {
                if (nums[i] <= mid) {
                    possible++;
                    i++;
                }
            }

            if (possible >= k) {
                max = mid;
            } else {
                min = mid + 1;
            }

        }

      return min;
    }





    // 2594. minimum time to repair car
    public long repairCars(int[] ranks, int cars) {
            int minRank = ranks[0], maxRank = ranks[0];

            // Find min and max rank dynamically
            for (int rank : ranks) {
                minRank = Math.min(minRank, rank);
                maxRank = Math.max(maxRank, rank);
            }
            // Frequency array to count mechanics with each rank
            int[] freq = new int[maxRank + 1];
            for (int rank : ranks) {
                minRank = Math.min(minRank, rank);
                freq[rank]++;
            }

            // Minimum possible time, Maximum possible time
            long low = 1, high = 1L * minRank * cars * cars;

            // Perform binary search to find the minimum time required
            while (low < high) {
                long mid = (low + high) / 2;
                long carsRepaired = 0;

                // Calculate the total number of cars that can be repaired in 'mid' time
                for (int rank = 1; rank <= maxRank; rank++) {
                    carsRepaired +=
                            freq[rank] * (long) Math.sqrt(mid / (long) rank);
                }

                // Adjust the search boundaries based on the number of cars repaired
                if (carsRepaired >= cars) {
                    high = mid; // Try to find a smaller time
                } else {
                    low = mid + 1; // Need more time
                }
            }

            return low;
        }





        // 2206. divide array into pairs
        public boolean divideArray(int[] nums) {
            // count frequencies of each number
            Map<Integer, Integer> countPairs = new HashMap<>();

            for (int num : nums) {
                countPairs.put(num, countPairs.getOrDefault(num, 0) + 1);
            }

            // iterate over map and if each value is not divisible by 2, then it can't be broken into pairs -> return false
            for (Map.Entry<Integer, Integer> x : countPairs.entrySet()) {

                int temp = x.getValue();

                if (temp % 2 != 0) {
                    return false;
                }
            }
            return true;
        }




    // 2401. longest nice subarray
    public int longestNiceSubarray(int[] nums) {

        int usedBits = 0;
        int windowStart = 0;
        int maxLen = 0;


        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            while((usedBits & nums[windowEnd]) != 0) {
                usedBits ^= nums[windowStart];
                windowStart++;
            }

            usedBits |= nums[windowEnd];

            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
        }
        return maxLen;

    }





    // 3191. minimum operations to make binary array elements equal to one I
    public int minOperations(int[] nums) {
        int count = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i - 2] == 0) {
                count++;
                nums[i - 2] = nums[i - 2] ^ 1;
                nums[i - 1] = nums[i - 1] ^ 1;
                nums[i] = nums[i] ^ 1;
            }
        }
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum == nums.length) return count;
        return -1;
    }




    // 2115. find all possible recipes from given supplies
    public List<String> findAllRecipes(
            String[] recipes,
            List<List<String>> ingredients,
            String[] supplies
    ) {
        // Store available supplies
        Set<String> availableSupplies = new HashSet<>();
        // Map recipe to its index
        Map<String, Integer> recipeToIndex = new HashMap<>();
        // Map ingredient to recipes that need it
        Map<String, List<String>> dependencyGraph = new HashMap<>();

        // Initialize available supplies
        for (String supply : supplies) {
            availableSupplies.add(supply);
        }

        // Create recipe to index mapping
        for (int idx = 0; idx < recipes.length; idx++) {
            recipeToIndex.put(recipes[idx], idx);
        }

        // Count of non-supply ingredients needed for each recipe
        int[] inDegree = new int[recipes.length];

        // Build dependency graph
        for (int recipeIdx = 0; recipeIdx < recipes.length; recipeIdx++) {
            for (String ingredient : ingredients.get(recipeIdx)) {
                if (!availableSupplies.contains(ingredient)) {
                    // Add edge: ingredient -> recipe
                    dependencyGraph.putIfAbsent(
                            ingredient,
                            new ArrayList<String>()
                    );
                    dependencyGraph.get(ingredient).add(recipes[recipeIdx]);
                    inDegree[recipeIdx]++;
                }
            }
        }

        // Start with recipes that only need supplies
        Queue<Integer> queue = new LinkedList<>();
        for (int recipeIdx = 0; recipeIdx < recipes.length; recipeIdx++) {
            if (inDegree[recipeIdx] == 0) {
                queue.add(recipeIdx);
            }
        }

        // Process recipes in topological order
        List<String> createdRecipes = new ArrayList<>();
        while (!queue.isEmpty()) {
            int recipeIdx = queue.poll();
            String recipe = recipes[recipeIdx];
            createdRecipes.add(recipe);

            // Skip if no recipes depend on this one
            if (!dependencyGraph.containsKey(recipe)) continue;

            // Update recipes that depend on current recipe
            for (String dependentRecipe : dependencyGraph.get(recipe)) {
                if (--inDegree[recipeToIndex.get(dependentRecipe)] == 0) {
                    queue.add(recipeToIndex.get(dependentRecipe));
                }
            }
        }

        return createdRecipes;
    }







    // 3169. count days without meetings
    public int countDays(int days, int[][] meetings) {

        int freeDays = 0, latestEnd = 0;

        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];

            if (start > latestEnd + 1) {
                freeDays += start - latestEnd - 1;
            }
            latestEnd = Math.max(latestEnd, end);

        }
        freeDays += days - latestEnd;

        return freeDays;

    }



    // 2033. Minimum operations to make uni-value grid
    public int minOperations(int[][] grid, int x) {

            int operations = 0;

            List<Integer> flat = new ArrayList<>();

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    flat.add(grid[i][j]);
                }
            }

            Collections.sort(flat);


            int len = flat.size();

            int finalCommon = flat.get(len / 2);

            for (int num : flat) {
                if (num % x != finalCommon % x) {
                    return - 1;
                }
                operations += Math.abs(finalCommon - num) / x;
            }
            return operations;
    }




    // minimum index of a valid split
    public int minimumIndex(List<Integer> nums) {

        Map<Integer, Integer> firstMap = new HashMap<>();
        Map<Integer, Integer> secondMap = new HashMap<>();
        int n = nums.size();

        // Add all elements of nums to secondMap
        for (int num : nums) {
            secondMap.put(num, secondMap.getOrDefault(num, 0) + 1);
        }

        for (int index = 0; index < n; index++) {
            // Create split at current index
            int num = nums.get(index);
            secondMap.put(num, secondMap.get(num) - 1);
            firstMap.put(num, firstMap.getOrDefault(num, 0) + 1);

            // Check if valid split
            if (
                    firstMap.get(num) * 2 > index + 1 &&
                            secondMap.get(num) * 2 > n - index - 1
            ) {
                return index;
            }
        }

        // No valid split exists
        return -1;
    }








































}
