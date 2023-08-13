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






}