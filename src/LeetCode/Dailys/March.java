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























}
