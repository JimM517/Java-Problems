package LeetCode.Easy;

import java.util.*;

public class EasyLeetQues {

    // 13 Roman to Integer

    public int romanToInt(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int ans = 0;


        for(int i=0;i<s.length()-1;i++){
            char ch= s.charAt(i);
            char chc= s.charAt(i+1);
            if(ch=='I' && (chc=='V' || chc=='X')){
                ans+=-1*map.get(ch);
            }
            else if(ch=='X' && (chc=='L' || chc=='C')){
                ans+=-1*map.get(ch);
            }
            else if(ch=='C' && (chc=='D' || chc=='M')){
                ans+=-1*map.get(ch);
            }
            else ans+=map.get(ch);
        }
        char ch=s.charAt(s.length()-1);
        ans+=map.get(ch);
        return ans;
    }



    // 283 Move Zeroes
    public void moveZeroes(int[] nums) {

            int start = 0;


            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    if (i != start) {
                        int temp = nums[start];
                        nums[start] = nums[i];
                        nums[i] = temp;
                    }
                }
                start++;
            }


    }


    // 1827 Minimum operations to make the array increasing

    public int minOperations(int[] nums) {

       int n = nums.length;

       int[] numMoves = new int[n];

       for (int i = 1; i < n; i++) {

           numMoves[i] = Math.max(0, nums[i - 1] + 1 - nums[i]);
           nums[i] += Math.max(0, nums[i - 1] + 1 - nums[i]);
           numMoves[i] += numMoves[i - 1];


       }
       return numMoves[n - 1];



    }


    // 206 Reverse Linked List
//    public ListNode reverseList(ListNode head) {
//        ListNode prev = null;
//        ListNode curr = head;
//
//        while(curr != null) {
//            ListNode next = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = next;
//        }
//        return prev;
//
//
//    }


    // 2235 Add two integers
    public int sum(int num1, int num2) {
        return num1 + num2;
    }



    // 1108 defanging an IP address
    public String defangIPaddr(String address) {


        return address.replace(".", "[.]");

    }



    // 1672 richest customer wealth

    public int maximumWealth(int[][] accounts) {

        int max = 0;

        for (int i = 0; i < accounts.length; i++) {
            int temp = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                temp += accounts[i][j];
            }


            if (temp > max) {
                max = temp;
            }
        }
        return max;

    }


    // 1470 shuffle the array
    public int[] shuffle(int[] nums, int n) {

        int[] results = new int[2 * n];


        for (int i = 0; i < n; i++) {

        results[2 * i] = nums[i];
        results[2 * i + 1] = nums[i + n];


        }
        return results;

    }


    // 1512 Number of good pairs
    public int numIdenticalPairs(int[] nums) {

        HashMap<Integer, Integer> count = new HashMap<>();

        int result = 0;

        for (int num : nums) {


            count.put(num, count.getOrDefault(num, 0) + 1);
            result += count.get(num) - 1;
        }
        return result;

    }


    // 771 Jewels and Stones
    public int numJewelsInStones(String jewels, String stones) {

        Set<Character> jewelSet = new HashSet<>();


        for (char jewel : jewels.toCharArray()) {
            jewelSet.add(jewel);
        }

        int count = 0;

        for (char stone : stones.toCharArray()) {
            if (jewelSet.contains(stone)) {
                count++;
            }
        }

        return count;


    }


    // 1603 Design Parking System

//    private int numBigSlots;
//    private int numMediumSlots;
//    private int numSmallSlots;
//
//    public ParkingSystem(int big, int medium, int small) {
//        this.numBigSlots = big;
//        this.numMediumSlots = medium;
//        this.numSmallSlots = small;
//    }

//    public boolean addCar(int carType) {
//
//        if (carType == 1) {
//            if (this.numBigSlots > 0) {
//                this.numBigSlots -= 1;
//                return true;
//            }
//        }
//        if (carType == 2) {
//            if (this.numMedSlots > 0) {
//                this.numMedSlots -= 1;
//                return true;
//            }
//        }
//        if (carType == 3) {
//            if (this.numSmallSlots > 0) {
//                this.numSmallSlots -= 1;
//                return true;
//            }
//        }
//        return false;
//
//    }


    // 1365 How many numbers are smaller than the current number
    public int[] smallerNumbersThanCurrent(int[] nums) {

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < nums[i] && j != i) {
                    count++;
                }
            }
            result[i] = count;
        }

        return result;
    }



    // 938 - Sum Range BST
//    public int rangeSumBST(TreeNode root, int low, int high) {
//
//        if (root == null) {
//            return 0;
//        }
//
//        if (root.val < low) {
//            return rangeSumBST(root.right, low, high);
//        } else if (root.val > high) {
//            return rangeSumBST(root.left, low high);
//        } else {
//            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
//        }
//
//
//
//    }



    // 1290 Convert Binary Number in a Linked List to Integer
//    public int getDecimalValue(LeetCode.LeetCode.ListNode head) {
//        int decimalValue = 0;
//
//        LeetCode.LeetCode.ListNode current = head;
//
//        while (current != null) {
            // left shift << is essentially multiplying by 2
            // 101 = 5 but left shit becomes 1010 which is 10
//            decimalValue = (decimalValue << 1) | current.val;
//            current = current.next;
//        }
//        return decimalValue;
//    }



    // 557 Reverse Words in a String
    public String reverseWords(String s) {

        String[] words = s.split(" ");

        StringBuilder sb = new StringBuilder();

        for (String word : words) {

            StringBuilder reversed = new StringBuilder(word);
            sb.append(reversed.reverse()).append(" ");

        }

        return sb.toString().trim();
    }





    // 202. Happy Number
    public boolean isHappy(int n) {

        HashSet<Integer> seenNumbers = new HashSet<>();

        while (n != 1 && !seenNumbers.contains(n)) {

            seenNumbers.add(n);

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


    // 217. Contains duplicates
    public boolean containsDuplicates(int[] nums) {

        Map<Integer, Integer> result = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (result.containsKey(nums[i])) {
                return true;
            } else {
                result.put(nums[i], 1);
            }
        }

       return false;

    }



    // 242. Valid Anagram
    public boolean isAnagram(String s, String t) {

        Map<Character, Integer> result = new HashMap<>();

        Map<Character, Integer> tMap = new HashMap<>();

        // populate result with chars and count from s
        for (int i = 0; i < s.length(); i++) {
           result.put(s.charAt(i), result.getOrDefault(s.charAt(i), 0) + 1);
        }
        // populate tMap with chars and count from t
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);

        }

        // if the two maps are equal they are anagrams
        return result.equals(tMap);
    }


    // 1. Two sum
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> result = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (result.containsKey(target - nums[i])) {
                return new int[]{result.get(target - nums[i]), i};
            } else {
                result.put(nums[i], i);
            }
        }


        return new int[]{-1, -1};

    }


    // 125 Valid Palindrome

    public boolean isPalindrome(String s) {


        s = s.toLowerCase().replaceAll("[a-z0-9]", "");

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {

            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;

        }

        return true;

    }


    // 20. Valid Parentheses
    public boolean inValid(String s) {


        Stack<Character> checkParen = new Stack<>();



        for (char c : s.toCharArray()) {

            if (c == '(' || c == '[' || c == '{') {
                checkParen.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (checkParen.isEmpty()) {
                    return false;
                }


                char top = checkParen.pop();
                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                    return false;
                }

            }

        }



        return checkParen.isEmpty() ? true : false;

    }



    // 283. Move Zeros
    public void moveZeros(int[] nums) {

        int nonZeroIndex = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != 0) {
                if (i != nonZeroIndex) {
                    int temp = nums[nonZeroIndex];
                    nums[nonZeroIndex] = nums[i];
                    nums[i] = temp;
                }
                nonZeroIndex++;
            }


        }
    }




    // 724. Find Pivot Index
    /** Doesn't work **/
    public int pivotIndex(int[] nums) {

        // start and end points
        int start = 0;
        int end = nums.length - 1;

        // keep track of our sums
        int sumLeft = 0;
        int sumRight = 0;

        // store final index
        int pivot = -1;

        while (start <= end) {
            if (sumLeft == sumRight) {
                pivot = start;
            }

            if (sumLeft <= sumRight) {
                sumLeft += nums[start];
                start++;
            } else {
                sumRight += nums[end];
                end--;
            }


        }
        return pivot;
    }

    /** This works **/
    public int pivotPartTwo(int[] nums) {

        if (nums.length == 0) {
            return -1;
        }

        int leftSum = 0;
        int rightSum = 0;

        for (int num : nums) {
            rightSum += num;
        }

        for (int i = 0; i < nums.length; i++) {

            rightSum -= nums[i];

            if (rightSum == leftSum) {
                return i;
            }
            leftSum += nums[i];


        }

        return -1;
    }


    // 88. Merge sorted array

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;

        int k = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

    }



    // 169. Majority Element

    public int majorityElement(int[] nums) {

        // majority element > n / 2?

        int n = nums.length;

        // majority element > n / 2?
        int maj = 0;
        int majorityCount = 0;

        Map<Integer, Integer> result = new HashMap<>();

        for (int num : nums) {
            result.put(num, result.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> res : result.entrySet()) {
            int count = res.getValue();

            if (count > majorityCount && count > n / 2) {
                maj = res.getKey();
                majorityCount = count;
            }
        }

        return maj;

    }


    // 14. Longest Common Prefix

    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }


        int minLen = Integer.MAX_VALUE;

        // find the minimum length of strings in the array
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }


        StringBuilder common = new StringBuilder();


        for (int i = 0; i < minLen; i++) {

            char currentChar = strs[0].charAt(i);

            // check if the current character is common among all strings
            for (int j = 1; j < strs.length; j++) {
                if (currentChar != strs[j].charAt(i)) {
                    // if not common, return the current common prefix
                    return common.toString();
                }
            }
            // if common, append the character to the result;
            common.append(currentChar);

        }

        return common.toString();

    }


    // 28. Find the index of the first occurrence in a string
    public int strStr(String haystack, String needle) {


        return haystack.indexOf(needle);


    }


    // 383. Ransom Note

    public boolean canConstruct(String ransomNote, String magazine) {

       int[] charCount = new int[26];

       for (char c : magazine.toCharArray()) {
           charCount[c - 'a']++;

       }

       for (char c : ransomNote.toCharArray()) {

           if (--charCount[c - 'a'] < 0) {
               return false;
           }

       }

       return true;



    }


    // 35. Search Insert Position
    public int searchInsert(int[] nums, int target) {

        // binary search

        int start = 0;
        int end = nums.length - 1;


        while (start <= end) {


            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }



        }


        return start;

    }


    // 2215. Find the Difference of Two Arrays
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        List<List<Integer>> result = new ArrayList<>();


        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();


        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            set2.add(num);
        }


        List<Integer> diffOne = new ArrayList<>(set1);
        diffOne.removeAll(set2);


        List<Integer> diffTwo = new ArrayList<>(set2);
        diffTwo.removeAll(set1);


        result.add(diffOne);
        result.add(diffTwo);


        return result;

    }




    // 1207 Unique Number of Occurrences
    public boolean uniqueOccurrences(int[] arr) {

        Map<Integer, Integer> results = new HashMap<>();

        // count the occurences of each value
        for (int num : arr) {

            results.put(num, results.getOrDefault(num, 0) + 1);
        }

        // check if the counts are unique
        Set<Integer> unique = new HashSet<>(results.values());

        return unique.size() == results.size();

    }


    // 933. Number of Recent Calls
//    class RecentCounter {
//
//        private Queue<Integer> requests;
//
//        public RecentCounter() {
//            this.requests = new LinkedList<>();
//        }
//
//        public int ping(int t) {
//            requests.add(t);
//
//            while (requests.peek() < t - 3000) {
//                requests.poll();
//            }
//
//            return requests.size();
//
//        }
//    }


    // 66. Plus one
    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {

            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;

        }

        digits = new int[digits.length + 1];
        digits[0] = 1;

        return digits;
    }


    // 209. Word Pattern
    public boolean wordPattern(String pattern, String s) {

        String[] arr = s.split(" ");

        if(pattern.length()!=arr.length)
            return false;

        HashMap<Character, String> map = new HashMap<Character, String>();

        for(int i=0; i<arr.length; i++)
        {
            char c = pattern.charAt(i);
            String str = arr[i];
            if(map.containsKey(c))
            {
                if(!map.get(c).equals(str))
                    return false;
            }
            else
            {
                if(map.containsValue(str))
                    return false;
                map.put(c, str);
            }
        }
        return true;



        }







    // 219. Contains Duplicates II
    public boolean containsNearByDuplicates(int[] nums, int k) {


        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];

            if (map.containsKey(num) && i - map.get(num) <= k) {
                return true;
            }
            map.put(num, i);

        }
        return false;
    }



    // 643. Maximum Average Subarray 1

    public double findMaxAverage(int[] nums, int k) {

        // sliding window approach


       int sum = 0;

        // first calculate the sum of the first k elements
       for (int i = 0; i < k; i++) {
           sum += nums[i];
       }


        // initialize the maximum sum with the sum of the first k elements
       int maxSum = sum;


       // iterate through the array starting from index k
       for (int i = k; i < nums.length; i++) {

           // update the sum by adding the current element and subtracting the element k steps back
           sum = sum + nums[i] - nums[i - k];

           // update the maximum sum if the current sum is greater
           maxSum = Math.max(maxSum, sum);

       }

        // return the maximum average by dividing the maximum sum by k
        return (double) maxSum / k;
    }



    //
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


    // 374. Guess Number Higher or Lower
    /** This solution works **/
//    public int guessNumber(int n) {
//
//        int start = 1;
//        int end = n;
//
//        while (start <= n) {
//
//            int mid = start + (end - start)/ 2;
//
//            int result = guess(mid);
//
//            if (result > 0) {
//                start = mid + 1;
//            } else if (result < 0) {
//                end = mid - 1;
//            } else {
//                return mid;
//            }
//        }
//
//
//        return -1;
//
//    }



    // 605. Can Place Flowers
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

       int size = flowerbed.length;

       if (n == 0) return true;

       for (int i = 0; i < size; i++) {

           if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == size - 1 || flowerbed[i + 1] == 0)) {
               n--;
               if (n == 0) return true;
               flowerbed[i] = 1;
           }


       }
        return false;
    }



    // 167. Two Sum II
    public int[] twoSumTwo(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;


        while (left < right) {

            int sum = nums[left] + nums[right];

            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                return new int[]{left + 1, right + 1};
            }



        }

        return null;
    }



    // 206. Reverse Linked List
//    public ListNode reverseList(ListNode head) {
//
//        ListNode prev = null;
//        ListNode curr = head;
//
//
//        while (curr != null) {
//
//            ListNode next = curr.next;
//
//            curr.next = prev;
//
//            prev = curr;
//
//            curr = next;
//
//
//        }
//        return prev;
//
//    }



    // 26. Remove Duplicates from Sorted Array
    public int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        Set<Integer> dups = new HashSet<>();

        int k = 0;

        for (int i = 0; i < nums.length; i++) {

            if (!dups.contains(nums[i])) {
                nums[k++] = nums[i];
                dups.add(nums[i]);
            }


        }

        return k;



    }



    // 349. Intersection of Two Arrays
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> num1Count = new HashSet<>();

        Set<Integer> num2Count = new HashSet<>();

        for (int num : nums1) {
            num1Count.add(num);
        }
        for (int num : nums2) {
            if (num1Count.contains(num)) {
                num2Count.add(num);
            }
        }


        int[] result = new int[num2Count.size()];

        int index = 0;

        for (int num : num2Count) {
            result[index++] = num;
        }

        return result;

    }




    // 263. Ugly Number
    public boolean isUgly(int n) {

        while (n >= 5 && n % 5 == 0) n /= 5;
        while (n >= 3 && n % 3 == 0) n /= 3;
        while (n >= 2 && n % 2 == 0) n /= 2;

        return n == 1;

    }






    // 58. Length of Last word
    public int lengthOfLastWord(String s) {

        String[] splitStr = s.split(" ");


        Stack<String> resStack = new Stack<>();

        for (int i = 0; i < splitStr.length; i++) {
            resStack.push(splitStr[i]);
        }
        return resStack.pop().length();

    }





    // 412. FizzBuzz
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






    // 1200. Minimum absolute difference
    public List<List<Integer>> minimumAbDiff(int[] arr) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 1; i++) {

            int diff = arr[i + 1] - arr[i];

            if (diff < min) {
                min = diff;

                result.clear();

                result.add(Arrays.asList(arr[i], arr[i + 1]));
            } else if (diff == min) {
                result.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }

        return result;

    }



    // 929. Unique Email Addresses
    public int numUniqueEmails(String[] emails) {

            Set<String> uniqueEmails = new HashSet<>();

            for (String email : emails) {

                String[] parts = email.split("@");

                String local = parts[0];
                String domain = parts[1];

                // remove everything after the first "+"
                local = local.split("\\+")[0];

                // remove "." and normalize local name
                local = local.replaceAll("\\.", "");


                // combine the local and domain
                String normalized = local + "@" + domain;

                // add the email to set to ensure unique
                uniqueEmails.add(normalized);


            }

            return uniqueEmails.size();
    }






    // 27. Remove Element
    public int removeElement(int[] nums, int val) {

        int k = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }


        }

        return k;

    }




    // 977. Sqaures of a Sorted Array
    public int[] sortedSquares(int[] nums) {

        int[] result = new int[nums.length];

        int left = 0;
        int right = nums.length - 1;

        int index = nums.length - 1;

        while (left <= right) {


            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[index] = nums[left] * nums[left];
                left++;
            }
            else {
                result[index] = nums[right] * nums[right];
                right--;
            }


            index--;
        }

        return result;

    }





    // 680 Valid Palindrome II
    public boolean validPalindromeTwo(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                if (isPalindrome(s, left + 1, right)) {
                    return true;
                }

                if (isPalindrome(s, left, right - 1)) {
                    return true;
                }

                return false;
            }

            left++;
            right--;


        }
        return true;

    }


    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }




    // 344. Reverse String
    public void reverseString(char[] s) {

        int start = 0;
        int end = s.length - 1;


        while (start < end) {

            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;

            start++;
            end--;
        }


    }




    // 1299. Replace elements with greatest element on right side
    public int[] replaceElements(int[] arr) {

        if (arr.length == 1) {
            return new int[]{-1};
        }


        int[] result = new int[arr.length];

        result[result.length - 1] = -1;

        int max = Integer.MIN_VALUE;

        for (int i = arr.length - 2; i >= 0; i--) {

            int before = arr[i + 1];

            max = Math.max(max, before);

            result[i] = max;


        }

        return result;
    }



    // 496. Next Greater Element
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Map<Integer, Integer> result = new HashMap<>();

        Stack<Integer> st = new Stack<>();

        for (int num : nums2) {

            while (!st.isEmpty() && st.peek() < num) {
                result.put(st.pop(), num);
            }
            st.push(num);

        }


        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = result.getOrDefault(nums1[i], -1);
        }



        return nums1;



    }






    // 1189. Maximum number of balloons
    public int maxNumberOfBalloons(String text) {

      int[] charCount = new int[26];

      for (int i = 0; i < text.length(); i++) {
          charCount[text.charAt(i) - 'a']++;
      }

      int min = charCount[1];
      min = Math.min(min, charCount[0]);
      min = Math.min(min, charCount[11] / 2);
      min = Math.min(min, charCount[14] / 2);
      min = Math.min(min, charCount[13]);

      return min;


    }






    // 136. Single Number
    public int singleNumber(int[] nums) {

        Map<Integer,Integer> res = new HashMap<>();

        for (int num : nums) {
            res.put(num, res.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : res.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }


        return -1;

    }





    // 509. fibonacci
    public int fib(int n) {

        if (n == 0 || n == 1) {
            return n;
        }


        return fib(n - 1) + fib(n - 2);


    }







    // 2073. time needed to buy tickets
    public int timeRequiredToBuy(int[] tickets, int k) {

        Queue<Integer> ticketQueue = new LinkedList<>();

        int time = 0;

        for (int i = 0; i < tickets.length; i++) {
            ticketQueue.add(i);
        }

        while (!ticketQueue.isEmpty()) {
            int idx = ticketQueue.poll();
            tickets[idx]--;
            time++;


            if (tickets[idx] == 0 && idx == k) {
                return time;
            }

            if (tickets[idx] > 0) {
                ticketQueue.add(idx);
            }

        }

        return time;

    }



    // 682. Baseball Game
    public int calPoints(String[] operations) {


            Stack<Integer> stack = new Stack<>();

            for (String idx : operations) {

                if (idx.equals("+")) {
                    int top = stack.pop();
                    int next = top + stack.peek();
                    stack.push(top);
                    stack.push(next);
                } else if (idx.equals("D")) {
                    stack.push(2 * stack.peek());
                } else if (idx.equals("C")) {
                    stack.pop();
                } else {
                    stack.push(Integer.parseInt(idx));
                }
            }


            int total = 0;

            for (int i : stack) {
                total += i;
            }

        return total;
    }





    // 389 Find the difference
    public char findTheDifference(String s, String t) {

            char c = 0;

            for (char cs : s.toCharArray()) {
                c ^= cs;
            }

            for (char ct : t.toCharArray()) {
                c ^= ct;
            }

            return c;

    }





    // 896 monotonic array
    public boolean isMonotonic(int[] nums) {

        boolean increasing = true;
        boolean decreasing = true;


        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                decreasing = false;
            } else if (nums[i] < nums[i - 1]) {
                increasing = false;
            }
        }


        return increasing || decreasing;
    }




    // 118. pascals triangle
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();

        if (numRows == 0) {
            return result;
        }


        if (numRows == 1) {
            List<Integer> firstRow = new ArrayList<>();

            firstRow.add(1);
            result.add(firstRow);
            return result;
        }



        result = generate(numRows - 1);
        List<Integer> prevRow = result.get(numRows - 2);
        List<Integer> currentRow = new ArrayList<>();
        currentRow.add(1);



        for (int i = 1; i < numRows - 1; i++) {
            currentRow.add(prevRow.get(i - 1) + prevRow.get(i));
        }


        currentRow.add(1);
        result.add(currentRow);



        return result;
    }




    // 119. pascals triangle II
    public List<Integer> getRow(int rowIndex) {

        List<Integer> result = new ArrayList<>();

        if (rowIndex < 0) {
            return result;
        }


        for (int i = 0; i <= rowIndex; i++) {

           result.add(1);

           for (int j = i - 1; j > 0; j--) {
               result.set(j, result.get(j - 1) + result.get(j));
            }
        }


        return result;
    }





    /** this is a duplicate, it's just in the problem set so doing again **/
    // 121. best time to buy and sell stock
    public int maxProfit(int[] prices) {

        if (prices.length == 0) {
            return 0;
        }


        int start = prices[0];
        int maxProfit = 0;


        for (int i = 0; i < prices.length; i++) {

            if (prices[i] < start) {
                start = prices[i];
            } else {
                int current = prices[i] - start;

                if (current > maxProfit) {
                    current = maxProfit;
                }
            }
        }
        return maxProfit;

    }





    // 1544. Make the string great

    public String makeGood(String s) {

       Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (!stack.isEmpty() && Math.abs(c - stack.peek()) == 32) {
                stack.pop();
            } else {
                stack.push(c);
            }

        }

        StringBuilder result = new StringBuilder();

        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        return result.toString();
    }




    // 697. degree of an array
    public int findShortestSubArray(int[] nums) {

        Map<Integer, Integer> freqMap = new HashMap<>();

        Map<Integer, Integer> firstOccurrence = new HashMap<>();

        Map<Integer, Integer> lastOccurrence = new HashMap<>();


        int maxFrequency = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            maxFrequency = Math.max(maxFrequency, freqMap.get(num));

            if (!firstOccurrence.containsKey(num)) {
                firstOccurrence.put(num, i);
            }
            lastOccurrence.put(num, i);

        }


        int minLength = nums.length;

        for (int num : freqMap.keySet()) {
            if (freqMap.get(num) == maxFrequency) {

                int length = lastOccurrence.get(num) - firstOccurrence.get(num) + 1;

                minLength = Math.min(minLength, length);

            }
        }
        return minLength;

    }






    // 448. find all numbers disappeared in an array
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> result = new ArrayList<>();

        int i = 0;

        while (i < nums.length) {

            if (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }


        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                result.add(j + 1);
            }
        }

        return result;
    }






    // 1971. find if path exists in graph
    public boolean validPath(int n, int[][] edges, int source, int destination) {

            Map<Integer, List<Integer>> graph = new HashMap<>();

            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];

                graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
                graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
            }

            Set<Integer> visited = new HashSet<>();


            return searchPath(source, destination, graph, visited);


    }




    private boolean searchPath(int node, int destination, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        if (node == destination) {
            return true;
        }

        visited.add(node);

        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                if (searchPath(neighbor, destination, graph, visited)) {
                    return true;
                }
            }
        }
        return false;
    }








    // 409. longest palindrome
    public int longestPalindrome(String s) {


        Map<Character, Integer> map = new HashMap<>();


        for (Character ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int len = 0;
        boolean hasOdd = false;


        for (int count : map.values()) {
            if (count % 2 == 0) {
                len += count;
            } else {
                len += count - 1;
                hasOdd = true;
            }
        }

        return hasOdd ? len + 1 : len;

    }


    // 459. repeated substring pattern
    public boolean repeatedSubstringPattern(String s) {

       int n = s.length();

       for (int i = 1; i <= n / 2; i++) {
           if (n % i == 0) {
               String sub = s.substring(0, i);

               StringBuilder sb = new StringBuilder();

               for (int j = 0; j < n / i; j++) {
                   sb.append(sub);
               }
               if (sb.toString().equals(s)) {
                   return true;
               }
           }
       }

        return false;
    }



    // 1732. find the highest altitude
    public int largestAltitude(int[] gain) {

        int maxAltitude = 0;



        int[] temp = new int[gain.length + 1];

        temp[0] = 0;

        for (int i = 1; i < temp.length; i++) {
            temp[i] = temp[i - 1] + gain[i - 1];

            if (temp[i] > maxAltitude) {
                maxAltitude = temp[i];
            }

        }



        return maxAltitude;

    }






    // 506. relative ranks
    public String[] findRelativeRanks(int[] score) {


        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> (b - a));

        int n = score.length;

        for (int i = 0; i < n; i++) {
            heap.offer(score[i]);
        }

        String[] s = new String[heap.peek() + 1];

        String[] s1 = new String[n];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                s[heap.poll()] = "Gold Medal";
            } else if (i == 1) {
                s[heap.poll()] = "Silver Medal";
            } else if (i == 2) {
                s[heap.poll()] = "Bronze Medal";
            } else {
                s[heap.poll()] = String.valueOf(i + 1);
            }
        }

        for (int i = 0; i < n; i++) {
            s1[i] = s[score[i]];
        }

        return s1;
    }






    // 2000. reverse prefix of word
    public String reversePrefix(String word, char ch) {

        int firstOcc = word.indexOf(ch);

        if (firstOcc == -1) {
            return word;
        }

        StringBuilder sb = new StringBuilder(word.substring(0, firstOcc + 1)).reverse();

        StringBuilder remaining = new StringBuilder(word.substring(firstOcc + 1));


        sb.append(remaining);

        return sb.toString();

    }





    // 2441 Largest positive integer that exists with its negative
    public int findMaxK(int[] nums) {

        Set<Integer> set = new HashSet<>();


        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            set.add(num);

            if (set.contains(-num)) {
                max = Math.max(max, Math.abs(num));
            }

        }

        return max == Integer.MIN_VALUE ? -1 : max;
    }





    // 3074. apple redistribution in boxes
    public int minimumBoxes(int[] apple, int[] capacity) {

        int totalApples = 0;
        for (int app : apple) {
            totalApples += app;
        }


        Arrays.sort(capacity);

        int boxesUsed = 0;
        int currCap = 0;

        for (int i = capacity.length - 1; i >= 0; i--) {
            currCap += capacity[i];
            boxesUsed++;

            if (currCap >= totalApples) {
                return boxesUsed;
            }


        }
        return capacity.length;



    }





    // 1002. Find common characters
    public List<String> commonChars(String[] words) {

      int[][] occurrences = new int[words.length][26];
      for (int i = 0; i < words.length; i++) {
          for (char c : words[i].toCharArray()) {
              occurrences[i][c - 'a']++;
          }
      }

      List<String> result = new ArrayList<>();

      for (int i = 'a'; i <= 'z'; i++) {
          int min = Integer.MAX_VALUE;

          for (int j = 0; j < occurrences.length; j++) {
              min = Math.min(min, occurrences[j][i - 'a']);
          }
          for (int j = 0; j < min; j++) {
              result.add(String.valueOf((char) i));
          }
      }

        return result;


    }





    // 1051. height checker
    public int heightChecker(int[] heights) {

        int[] expected = new int[heights.length];

        for (int i = 0; i < heights.length; i++) {

          expected[i] = heights[i];

        }

        Arrays.sort(expected);

        int count = 0;

        for (int i = 0; i < expected.length; i++) {
            if (expected[i] != heights[i]) {
                count++;
            }
        }

        return count;

    }




    // 1122. relative sort array
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

            Map<Integer, Integer> map = new HashMap<>();

            int counter = 0;

            for (int num : arr2) {
                map.put(num, 0);
            }

            for (int i = 0; i < arr1.length; i++) {
                if (map.containsKey(arr1[i])) {
                    map.put(arr1[i], map.get(arr1[i]) + 1);
                    arr1[i] = -1;
                }
            }

            Arrays.sort(arr1);
            for (int num : arr2) {
                int size = map.remove(num);

                while (size > 0) {
                    arr1[counter++] = num;
                    size--;
                }
            }
            return arr1;

    }




    // 2864. Maximum odd binary number
    public String maximumOddBinary(String s) {

        int countOnes = 0;
        int countZeros = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                countOnes++;
            } else {
                countZeros++;
            }
        }


        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < countOnes - 1; i++) {
            sb.append('1');
        }

        for (int i = 0; i < countZeros; i++) {
            sb.append('0');
        }


        sb.append('1');

        return sb.toString();

    }




    // 2037. minimum number of moves to seat everyone
    public int minMovesToSeat(int[] seats, int[] students) {

        int result = 0;

        Arrays.sort(seats);
        Arrays.sort(students);

        for (int i = 0; i < seats.length; i++) {
            result += Math.abs(seats[i] - students[i]);
        }

        return result;

    }








    // 455. assign cookies
    public int findContentChildren(int[] g, int[] s) {

     Arrays.sort(g);
     Arrays.sort(s);

     int i = 0;

     for (int j = 0; i < g.length && j < s.length; j++) {
         if (g[i] <= s[j]) {
             i++;
         }
     }
        return i;
    }





    // 1791. find center of star graph
    public int findCenter(int[][] edges) {

        if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) {
            return edges[0][0];
        } else {
            return edges[0][1];
        }



    }




    // 1550. Three consecutive odds
    public boolean threeConsecutiveOdds(int[] arr) {

        boolean foundOdd = false;

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] % 2 == 1) {
                foundOdd = true;
            }
            if (foundOdd) {
                if (arr[i - 1] % 2 == 1 && arr[i - 2] % 2 == 1) {
                    return true;
                }
            }
        }

        return false;



    }




    // 350. Intersection of two arrays II
    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map1 = new HashMap<>();

        for (int num : nums1) {
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }


        List<Integer> checkNums2 = new ArrayList<>();
        for (int num : nums2) {

            if (map1.containsKey(num) && map1.get(num) > 0) {
                checkNums2.add(num);
                map1.put(num, map1.getOrDefault(num, 0) - 1);
            }


        }


        int[] result = new int[checkNums2.size()];
        for (int i = 0; i < checkNums2.size(); i++) {
            result[i] = checkNums2.get(i);
        }

        return result;


    }




    // 2582. Pass the Pillow
    public int passThePillow(int n, int time) {
        return n - Math.abs(n - 1 - time % (n * 2 - 2));
    }




    // 1518. Water Bottles
    public int numWaterBottles(int numBottles, int numExchange) {


        int totalBottles = numBottles;

        while (numBottles >= numExchange) {

            totalBottles += numBottles / numExchange;

            numBottles = (numBottles / numExchange) + (numBottles % numExchange);
        }
        return totalBottles;
    }






    // 1598. Crawler log folder
    public int minOperations(String[] logs) {

        int count = 0;

        for (String log : logs) {

            if (log.equals("../")) {
                count = Math.max(0, --count);
            } else if (!log.equals("./")) {
                count++;
            }



        }

        return count;

    }



    // 1380. lucky numbers in a matrix
    public List<Integer> luckyNumbers(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {

            int num = Integer.MAX_VALUE;
            int index = -1;

            for (int j = 0; j < m; j++) {

                if (matrix[i][j] < num) {
                    num = matrix[i][j];
                    index = j;
                }

            }

            boolean flag = true;
            for (int row = 0; row < n; row++) {
                if (matrix[row][index] > num) {
                    flag = false;
                }
            }
            if (flag) {
                result.add(num);
            }
        }

        return result;

    }




    // 2418. Sort the people
    public String[] sortPeople(String[] names, int[] heights) {

        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }

        Arrays.sort(heights);


        String[] result = new String[heights.length];
        int index = 0;

        for (int i = heights.length - 1; i >= 0; i--) {

            result[index] = map.get(heights[i]);
            index++;

        }

        return result;

    }





    // 1636. sort array by increasing frequency
    public int[] frequencySort(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }



        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }



        list.sort((a, b) -> {
            int freqA = map.get(a);
            int freqB = map.get(b);
            if (freqA != freqB) {
                return Integer.compare(freqA, freqB);
            } else {
                return Integer.compare(b, a);
            }
        });



        int[] result = new int[nums.length];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;

    }



    // 2027. Minimum moves to convert string
    public int minimumMoves(String s) {

        int numX = 0;

        int i = 0;

        while (i < s.length()) {

            if (s.charAt(i) == 'X') {
                i += 2;
                numX++;
            }
            i++;

        }



        return numX;
    }





    // 2124 check if all A's appear before all b's
    public boolean checkString(String s) {

        boolean found = true;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == 'b' && s.charAt(i + 1) == 'a') {
                found = false;
            }



        }
        return found;


    }




    // 2678. number of senior citizens
    public int countSeniors(String[] details) {

        int count = 0;

        for (String x : details) {

            String ageStr = x.substring(11, 13);

            int age = Integer.parseInt(ageStr);

            if (age > 60) {
                count++;
            }


        }
        return count;
    }



    // 1460. make two arrays equal by reversing subarrays
    public boolean canBeEqual(int[] target, int[] arr) {

        Arrays.sort(target);
        Arrays.sort(arr);

        return Arrays.equals(arr, target);


    }




    // 2053. kth distinct string in an array
    public String kthDistinct(String[] arr, int k) {

        Map<String, Integer> map = new HashMap<>();


        for (String x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int distinct = 0;
        for (String x : arr) {
            if (map.get(x) == 1) {
                distinct++;
                if (distinct == k) {
                    return x;
                }
            }
        }


        return "";

    }






    // 860. Lemonade Change
    public boolean lemonadeChange(int[] bills) {

        int fiveCount = 0;
        int tenCount = 0;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                fiveCount++;
            } else if (bills[i] == 10) {
                if (fiveCount == 0) {
                    return false;
                }
                fiveCount--;
                tenCount++;
            } else if (bills[i] == 20) {
                if (tenCount > 0 && fiveCount > 0) {
                    tenCount--;
                    fiveCount--;
                } else if (fiveCount >= 3) {
                    fiveCount -= 3;
                } else {
                    return false;
                }
            }
        }


        return true;


    }




    // 476. Number complement
    public int findComplement(int num) {
        int temp = (int) (Math.pow(2, digits(num)) - 1);
        return temp - num;
    }


    public int digits(int n) {
        int count = 0;
        while (n > 0) {
            n /= 2;
            count++;
        }
        return count;
    }




    // 703. Kth Largest Element in a Stream
    private class KthLargest {
        private int k;
        private PriorityQueue<Integer> minHeap;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            minHeap = new PriorityQueue<>(k);

            for (int num : nums) {
                if (minHeap.size() < k) {
                    minHeap.offer(num);
                } else if (num > minHeap.peek()) {
                    minHeap.offer(num);
                    if (minHeap.size() > k){
                        minHeap.poll();
                    }
                }
            }
        }

        public int add(int val) {
            if (minHeap.size() < k) {
                minHeap.offer(val);
            } else if (val > minHeap.peek()) {
                minHeap.offer(val);
                minHeap.poll();
            }
            return minHeap.peek();
        }




    }


    // 2022. convert 1D array into 2D array
    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] result = new int[m][n];

        if (m * n != original.length) {
            return new int[0][0];
        }

        for (int i = 0; i < m * n; i++) {
            result[i / n][i % n] = original[i];
        }


        return result;

    }




    // 1945. Sum of digits of string after convert
    public int getLucky(String s, int k) {

        StringBuilder number = new StringBuilder();

        for (char x : s.toCharArray()) {
            number.append(x - 'a' + 1);
        }




        while (k > 0) {
            int temp = 0;
            for (char x : number.toString().toCharArray()) {
                temp += x - '0';
            }
            number = new StringBuilder(String.valueOf(temp));
            k--;
        }
        return Integer.parseInt(number.toString());
    }




    // 2220. Minimum bit flips to convert number
    public int minBitFlips(int start, int goal) {

      int count = 0;

      int diff = start ^ goal;

      while (diff > 0) {
          count++;
          diff = diff & (diff - 1);
      }


      return count;
    }




    // 1684. count the number of consistent strings
    public int countConsistentStrings(String allowed, String[] words) {

        int count = words.length;
        int[] store = new int[26];


        for (char c : allowed.toCharArray()) {
            store[c - 'a']++;
        }

        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (store[c - 'a'] <= 0) {
                    count--;
                    break;
                }
            }
        }
        return count;
    }




    // 884. Uncommon words from two sentences
    public String[] uncommonFromSentences(String s1, String s2) {


        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        String[] words1 = s1.split(" ");
        String[] words2 = s2.split(" ");

        List<String> total = new ArrayList<>();

        for (String word : words1) {
            map1.put(word, map1.getOrDefault(word, 0) + 1);
        }

        for (String word : words2) {
            map2.put(word, map2.getOrDefault(word, 0) + 1);
        }


        for (String x : map1.keySet()) {
          if (map1.get(x) == 1 && !map2.containsKey(x)) {
              total.add(x);
          }
        }

        for (String x : map2.keySet()) {
            if (map2.get(x) == 1 && !map1.containsKey(x)) {
                total.add(x);
            }
        }


        String[] result = new String[total.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = total.get(i);
        }


        return result;


    }





    // 1331. rank transform of an array
    public int[] arrayRankTransform(int[] arr) {

        int[] temp = arr.clone();
        Arrays.sort(temp);

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < temp.length; i++) {

            map.putIfAbsent(temp[i], map.size() + 1);

        }

        for (int i = 0; i < temp.length; i++) {
            temp[i] = map.get(arr[i]);
        }

        return temp;


    }



















































}










