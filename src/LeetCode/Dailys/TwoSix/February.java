package LeetCode.Dailys.TwoSix;

import java.util.*;

public class February {




// 3010. divide an array into subarrays with minimum cost I
    public int minimumCost(int[] nums) {

        int first = nums[0];

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min1) {
                min2 = min1;
                min1 = nums[i];
            } else if (nums[i] < min2) {
                min2 = nums[i];
            }
        }

        return first + min1 + min2;
    }






// 3013. divide an array into subarrays with minimum cost II
class Container {

    private int k;
    private int st1Size;
    private int st2Size;
    // st1 saves the k smallest values, st2 saves the other values
    private TreeMap<Integer, Integer> st1;
    private TreeMap<Integer, Integer> st2;
    // sm represents the sum of the first k smallest elements
    private long sm;

    public Container(int k) {
        this.k = k;
        this.st1 = new TreeMap<>();
        this.st2 = new TreeMap<>();
        this.sm = 0;
        this.st1Size = 0;
        this.st2Size = 0;
    }

    private void removeOne(TreeMap<Integer, Integer> map, int key) {
        int count = map.get(key);
        if (count == 1) {
            map.remove(key);
        } else {
            map.put(key, count - 1);
        }
    }

    private void addOne(TreeMap<Integer, Integer> map, int key) {
        map.put(key, map.getOrDefault(key, 0) + 1);
    }

    private void adjust() {
        while (st1Size < k && !st2.isEmpty()) {
            int x = st2.firstKey();
            addOne(st1, x);
            st1Size++;
            sm += x;
            removeOne(st2, x);
            st2Size--;
        }
        while (st1Size > k) {
            int x = st1.lastKey();
            addOne(st2, x);
            st2Size++;
            removeOne(st1, x);
            st1Size--;
            sm -= x;
        }
    }

    // insert element x
    public void add(int x) {
        if (!st2.isEmpty() && x >= st2.firstKey()) {
            addOne(st2, x);
            st2Size++;
        } else {
            addOne(st1, x);
            st1Size++;
            sm += x;
        }
        adjust();
    }

    // delete element x
    public void erase(int x) {
        if (st1.containsKey(x)) {
            removeOne(st1, x);
            st1Size--;
            sm -= x;
        } else if (st2.containsKey(x)) {
            removeOne(st2, x);
            st2Size--;
        }
        adjust();
    }

    // sum of the first k smallest elements
    public long sum() {
        return sm;
    }
}



        public long minimumCost(int[] nums, int k, int dist) {
            int n = nums.length;
            Container cnt = new Container(k - 2);
            for (int i = 1; i < k - 1; i++) {
                cnt.add(nums[i]);
            }

            long ans = cnt.sum() + nums[k - 1];
            for (int i = k; i < n; i++) {
                int j = i - dist - 1;
                if (j > 0) {
                    cnt.erase(nums[j]);
                }
                cnt.add(nums[i - 1]);
                ans = Math.min(ans, cnt.sum() + nums[i]);
            }

            return ans + nums[0];
        }






// trionic array I
    public boolean isTrionic(int[] nums) {

        int n = nums.length;
        int i = 1;
        while (i < n && nums[i - 1] < nums[i]) {
            i++;
        }
        int p = i - 1;
        while (i < n && nums[i - 1] > nums[i]) {
            i++;
        }
        int q = i - 1;
        while (i < n && nums[i - 1] < nums[i]) {
            i++;
        }
        int flag = i - 1;
        return (p != 0) && (q != p) && (flag == n - 1 && flag != q);

    }




// 3640. trionic array II
public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        long ans = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int j = i + 1;
            long res = 0;

            // first segment: increasing segment
            while (j < n && nums[j - 1] < nums[j]) {
                j++;
            }
            int p = j - 1;

            if (p == i) {
                continue;
            }

            // second segment: decreasing segment
            res += nums[p] + nums[p - 1];
            while (j < n && nums[j - 1] > nums[j]) {
                res += nums[j];
                j++;
            }
            int q = j - 1;

            if (q == p || q == n - 1 || (j < n && nums[j] <= nums[q])) {
                i = q;
                continue;
            }

            // third segment: increasing segment
            res += nums[q + 1];

            // find the maximum sum of the third segment
            long maxSum = 0;
            long sum = 0;
            for (int k = q + 2; k < n && nums[k] > nums[k - 1]; k++) {
                sum += nums[k];
                maxSum = Math.max(maxSum, sum);
            }
            res += maxSum;

            // find the maximum sum of the first segment
            maxSum = 0;
            sum = 0;
            for (int k = p - 2; k >= i; k--) {
                sum += nums[k];
                maxSum = Math.max(maxSum, sum);
            }
            res += maxSum;

            // update answer
            ans = Math.max(ans, res);
            i = q - 1;
        }

        return ans;
    }



    // 3379. transformed array
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = nums[(((i + nums[i]) % n) + n) % n];
        }

        return result;
    }




    // 3634. minimum removals to balance array
    public int minRemoval(int[] nums, int k) {

        int n = nums.length;
        Arrays.sort(nums);

        int answer = n;
        int right = 0;

        for (int left = 0; left < n; left++) {
            while (right < n && nums[right] <= (long) nums[left] * k) {
                right++;
            }
            answer = Math.min(answer, n - (right - left));
        }


        return answer;
    }





// minimum deletions to make string balanced
    public int minimumDeletions(String s) {

        int n = s.length();
        Stack<Character> characterStack = new Stack<>();
        int deleteCount = 0;

        for (int i = 0; i < n; i++) {
            if (!characterStack.isEmpty() && characterStack.peek() == 'b' && s.charAt(i) == 'a') {
                characterStack.pop();
                deleteCount++;
            } else {
                characterStack.push(s.charAt(i));
            }
        }
        return deleteCount;
    }









// 110. balanced binary tree
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){};
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
}

public boolean isBalanced(TreeNode root) {

        return checkHeight(root) != -1;
    }

public int checkHeight(TreeNode node) {

        if (node == null) return -0;

        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;

}




// 1382. balance a binary search tree
    private List<TreeNode> sortedList = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorderTrav(root);
        return sortATtoBST(0, sortedList.size() - 1);
    }

    public void inorderTrav(TreeNode root) {
        if (root == null) return;
        inorderTrav(root.left);
        sortedList.add(root);
        inorderTrav(root.right);
    }

    public TreeNode sortATtoBST(int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = sortedList.get(mid);
        root.left = sortATtoBST(start, mid - 1);
        root.right = sortATtoBST(mid + 1, end);
        return root;
    }






// 3713. longest balanced string I
    public int longestBalanced(String s) {

        int n = s.length();
        int res = 0;

        int[] cnt = new int[26];

        for (int i = 0; i < n; i++) {
            Arrays.fill(cnt, 0);
            for (int j = i; j < n; j++) {
                boolean flag = true;
                int c = s.charAt(j) - 'a';
                cnt[c]++;

                for (int x : cnt) {
                    if (x > 0 && x != cnt[c]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }




// 3714. longest balanced substring II
    private int longestTwoCharSegment(String s,int start,int end){
            start = Math.max(0,start);

            Map<Integer,Integer> parityMap=new HashMap<>();
            parityMap.put(0,start-1);

            int balance=0,best=0,lastChar=-1,sign=-1;

            for(int i=start;i<end;i++){
                int v=s.charAt(i)-'a';

                if(v!=lastChar){
                    lastChar=v;
                    sign*=-1;
                }

                balance+=sign;

                if(parityMap.containsKey(balance))
                    best=Math.max(best,i-parityMap.get(balance));
                else
                    parityMap.put(balance,i);
            }

            return best;
        }

        public int longestBalanced2(String s) {
            Map<String,Integer> diffMap=new HashMap<>();
            diffMap.put("0,0,0",-1);

            int[] counts=new int[3];

            int lastCharVal=-1,lastCharIdx=-1;
            int pair0=-1,pair1=-1;
            int twoCharStart=0;

            int best=0;

            for(int i=0;i<s.length();i++){
                int v=s.charAt(i)-'a';
                counts[v]++;

                int m=Math.min(counts[0],
                        Math.min(counts[1],counts[2]));
                if(m>0)
                    for(int j=0;j<3;j++) counts[j]-=m;

                String key=counts[0]+","+counts[1]+","+counts[2];

                if(diffMap.containsKey(key))
                    best=Math.max(best,i-diffMap.get(key));
                else
                    diffMap.put(key,i);

                if(v!=lastCharVal){
                    best=Math.max(best,i-lastCharIdx);

                    if(v!=pair0 && v!=pair1){
                        pair0=lastCharVal;
                        pair1=v;

                        best=Math.max(best,
                                longestTwoCharSegment(s,twoCharStart,i));

                        twoCharStart=Math.max(0,lastCharIdx);
                    }

                    lastCharVal=v;
                    lastCharIdx=i;
                }
            }

            best=Math.max(best,
                    longestTwoCharSegment(s,
                            Math.max(0,twoCharStart),
                            s.length()));

            best=Math.max(best,s.length()-lastCharIdx);

            return best;
        }





        // 799. champagne tower
    public double champagneTower(int poured, int query_row, int query_glass) {

        double[][] A = new double[102][102];

        A[0][0] = (double) poured;

        for (int r = 0; r <= query_row; r++) {
            for (int c = 0; c <= r; c++) {
                double q = (A[r][c] - 1.0) / 2.0;
                if (q > 0) {
                    A[r + 1][c] += q;
                    A[r + 1][c + 1] += q;
                }
            }
        }

        return Math.min(1, A[query_row][query_glass]);



    }






    // 67. add binary
    public String addBinary(String a, String b) {

        StringBuilder result = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;

        int carry = 0;

        while (i >= 0 || j >= 0 || carry == 1) {
            int sum = carry;

            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';

            result.append(sum % 2);
            carry = sum / 2;
        }
        return result.reverse().toString();
    }




    // 190. reverse bits
    public int reverseBits(int n) {

        int result = 0;

        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result |= (n & 1);
            n >>= 1;
        }

        return result;

    }






// binary watch
    public List<String> readBinaryWatch(int turnedOn) {


        List<String> answer = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    answer.add(h + ":" + (m < 10 ? "0" : "") + m);
                }
            }
        }


        return answer;




    }




    // 693. binary number with alternating bits
    public boolean hasAlternatingbits(int n) {


        String str = Integer.toBinaryString(n);

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                return false;
            }
        }
        return true;


    }





    // 6396. count binary substrings
    public int countBinarySubstrings(String s) {

        int[] groups = new int[s.length()];
        int t = 0;
        groups[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i-1) != s.charAt(i)) {
                groups[++t] = 1;
            } else {
                groups[t]++;
            }
        }

        int ans = 0;
        for (int i = 1; i <= t; i++) {
            ans += Math.min(groups[i-1], groups[i]);
        }
        return ans;

    }





    // 761. special binary strings
    public String makeLargestSpecial(String s) {

        int cnt =0;
        List<String> list = new LinkedList<>();
        int j=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='1')
                cnt++;
            else cnt--;
            if(cnt==0)
            {
                list.add('1'+makeLargestSpecial(s.substring(j+1,i))+'0');
                j= i+1;
            }
        }
        Collections.sort(list,Collections.reverseOrder());
        return String.join("",list);




    }
























































}
