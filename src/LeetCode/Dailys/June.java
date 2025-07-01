package LeetCode.Dailys;

import java.util.*;

public class June {



// 2929. distribute candies among children II
    public long distributeCandies(int n, int limit) {

            long result = 0;

            for (int i = 0; i <= Math.min(limit, n); i++) {
                if (n - i > 2 * limit) {
                    continue;
                }
                result += Math.max(Math.min(limit, n - i) - Math.max(0, n - i - limit) + 1, 0);

            }
            return result;
    }




        // 135. Candy
        public int candy(int[] ratings) {
            int n = ratings.length;
            int cnt = 0;
            int[] candies = new int[n];
            for (int i = 0; i < n; i++) candies[i] = 1;
            for (int i = 1; i < n; i++)
                if (ratings[i] > ratings[i - 1])
                    candies[i] = candies[i - 1] + 1;
            for (int i = n - 1; i > 0; i--) {
                if (ratings[i - 1] > ratings[i])
                    candies[i - 1] = Math.max(candies[i] + 1, candies[i - 1]);
                cnt += candies[i - 1];
            }
            return cnt + candies[n - 1];
        }








        // 1298. maximum candies you can get from boxes
        public int maxCandies(
                int[] status,
                int[] candies,
                int[][] keys,
                int[][] containedBoxes,
                int[] initialBoxes
        ) {
            int n = status.length;
            boolean[] canOpen = new boolean[n];
            boolean[] hasBox = new boolean[n];
            boolean[] used = new boolean[n];

            for (int i = 0; i < n; ++i) {
                canOpen[i] = (status[i] == 1);
            }

            Queue<Integer> q = new LinkedList<>();
            int ans = 0;
            for (int box : initialBoxes) {
                hasBox[box] = true;
                if (canOpen[box]) {
                    q.offer(box);
                    used[box] = true;
                    ans += candies[box];
                }
            }

            while (!q.isEmpty()) {
                int bigBox = q.poll();
                for (int key : keys[bigBox]) {
                    canOpen[key] = true;
                    if (!used[key] && hasBox[key]) {
                        q.offer(key);
                        used[key] = true;
                        ans += candies[key];
                    }
                }
                for (int box : containedBoxes[bigBox]) {
                    hasBox[box] = true;
                    if (!used[box] && canOpen[box]) {
                        q.offer(box);
                        used[box] = true;
                        ans += candies[box];
                    }
                }
            }

            return ans;
        }




        // 3403. find the lexicographically largest string from the box I
    public String answerString(String word, int numFriends) {

        if (numFriends == 1) {
            return word;
        }

        int n = word.length();

        String result = "";
        for (int i = 0; i < n; i++) {
            String s = word.substring(i, Math.min(i + n - numFriends + 1, n));
            if (result.compareTo(s) <= 0) {
                result = s;
            }
        }

        return result;
    }





    // 1061. Lexicographically smallest equivalent string
    private int[] parent = new int[26];

    // find with path compression
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // union by choosing the lexicographically smaller root as the new parent
    private void union(int a, int b) {
        int ra = find(a);
        int rb = find(b);
        if (ra == rb) {
            return;
        }
        if (ra < rb) {
            parent[rb] = ra;
        } else {
            parent[ra] = rb;
        }
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        // union find
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        // merge equivalent characters
        for (int i = 0; i < s1.length(); i++) {
            int x = s1.charAt(i) - 'a';
            int y = s2.charAt(i) - 'a';
            union(x, y);
        }

        // build result by mapping each character in baseStr to its group root
        StringBuilder sb = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            int idx = c - 'a';
            int root = find(idx);
            sb.append((char) (root + 'a'));
        }

        return sb.toString();
    }




    // 2434. using a robot to print the lexicographically smallest string
    public String robotWithString(String s) {

        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        char minCharacter = 'a';
        for (char c : s.toCharArray()) {
            stack.push(c);
            cnt[c - 'a']--;
            while (minCharacter != 'z' && cnt[minCharacter - 'a'] == 0) {
                minCharacter++;
            }
            while (!stack.isEmpty() && stack.peek() <= minCharacter) {
                res.append(stack.pop());
            }
        }

        return res.toString();

    }





    // 3170. lexicographically minimum string after removing stars
    public String clearStars(String s) {

        Deque<Integer>[] cnt = new Deque[26];
        for (int i = 0; i < 26; i++) {
            cnt[i] = new ArrayDeque<>();
        }

        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '*') {
                cnt[arr[i] - 'a'].push(i);
            } else {
                for (int j = 0; j < 26; j++) {
                    if (!cnt[j].isEmpty()) {
                        arr[cnt[j].pop()] = '*';
                        break;
                    }
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        for (char ch : arr) {
            if (ch != '*') {
                answer.append(ch);
            }
        }

        return answer.toString();

    }




    // 386. lexicographical numbers
    public List<Integer> lexicalOrder(int n) {

        List<Integer> result = new ArrayList<>();

        int curr = 1;

        for (int i = 0; i < n; i++) {

            result.add(curr);
            if (curr * 10 <= n){
                curr *= 10;
            } else {
                while (curr % 10 == 9 || curr + 1 > n) {
                    curr /= 10;
                }
                curr++;
            }


        }
        return result;

    }





    // 440. k-th smallest in lexicographical order
    public int findKthNumber(int n, int k) {
            int curr = 1;
            k--;

            while (k > 0) {
                int step = countSteps(n, curr, curr + 1);
                // If the steps are less than or equal to k, we skip this prefix's subtree
                if (step <= k) {
                    // Move to the next prefix and decrease k by the number of steps we skip
                    curr++;
                    k -= step;
                } else {
                    // Move to the next level of the tree and decrement k by 1
                    curr *= 10;
                    k--;
                }
            }

            return curr;
        }

        // To count how many numbers exist between prefix1 and prefix2
        private int countSteps(int n, long prefix1, long prefix2) {
            int steps = 0;
            while (prefix1 <= n) {
                steps += Math.min(n + 1, prefix2) - prefix1;
                prefix1 *= 10;
                prefix2 *= 10;
            }
            return steps;
        }




    // 3442. maximum difference between even and odd frequency I
    public int maxDifference(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int maxOdd = 1, minEven = s.length();
        for (int value : map.values()) {
            if (value % 2 == 1) {
                maxOdd = Math.max(maxOdd, value);
            } else {
                minEven = Math.min(minEven, value);
            }
        }
        return maxOdd - minEven;

    }





// 3445. Maximum difference between even and odd frequency II
    public int maxDifference(String s, int k) {


        int n = s.length();
        int answer = Integer.MIN_VALUE;

        for (char a = '0'; a <= '4'; a++) {
            for (char b = '0'; b <= '4'; b++) {
                if (a == b) {
                    continue;
                }
                int[] best = new int[4];
                Arrays.fill(best, Integer.MAX_VALUE);
                int cnt_a = 0, cnt_b = 0;
                int prev_a = 0, prev_b = 0;
                int left = -1;

                for (int right = 0; right < n; right++) {

                    cnt_a += (s.charAt(right) == a) ? 1 : 0;
                    cnt_b += (s.charAt(right) == b) ? 1 : 0;

                    while (right - left >= k && cnt_b - prev_b >= 2) {
                        int left_status = getStatus(prev_a, prev_b);
                        best[left_status] = Math.min(best[left_status], prev_a - prev_b);
                        left++;
                        prev_a += (s.charAt(left) == a) ? 1 : 0;
                        prev_b += (s.charAt(left) == b) ? 1 : 0;
                    }

                    int right_status = getStatus(cnt_a, cnt_b);
                    if (best[right_status ^ 0b10] != Integer.MAX_VALUE) {
                        answer = Math.max(answer, cnt_a - cnt_b - best[right_status ^ 0b10]);
                    }

                }


            }
        }

        return answer;

    }

    private int getStatus(int cnt_a, int cnt_b) {
        return ((cnt_a & 1) << 1) | (cnt_b & 1);
    }






// 3423. maximum difference between adjacent elements in circular array
    public int maxAdjacentDistance(int[] nums) {

            int maxDiff = Math.abs(nums[nums.length - 1] - nums[0]);




            for (int i = 1; i < nums.length; i++) {

                int currDiff = Math.abs(nums[i] - nums[i - 1]);

                if (currDiff > maxDiff) {
                    maxDiff = currDiff;
                }



            }


            return maxDiff;


    }





    // 2616. minimize the maximum difference of pairs
    private int countValidPairs(int[] nums, int threshold) {

        int index = 0, count = 0;

        while (index < nums.length - 1) {

            if (nums[index + 1] - nums[index] <= threshold) {
                count++;
                index++;
            }
            index++;
        }
        return count;
    }


    public int minimizeMax(int[] nums, int p) {

        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = nums[n - 1] - nums[0];

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (countValidPairs(nums, mid) >= p) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }



    // 2566. maximum difference by remapping a digit
    public int minMaxDifference(int num) {

        String s = Integer.toString(num);
        String t = s;
        int pos = 0;
        while (pos < s.length() && s.charAt(pos) == '9') {
            pos++;
        }
        if (pos < s.length()) {
            s = s.replace(s.charAt(pos), '9');
        }
        t = t.replace(t.charAt(0), '0');
        return Integer.parseInt(s) - Integer.parseInt(t);

    }




    // 1432. max difference you can get from changing an integer
    public int maxDiff(int num) {
        int min_num = num;
        int max_num = num;
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                String res = change(num, x, y);

                if (res.charAt(0) != '0') {
                    int res_i = Integer.parseInt(res);
                    min_num = Math.min(min_num, res_i);
                    max_num = Math.max(max_num, res_i);
                }
            }
        }
        return max_num - min_num;
    }


    public String change(int num, int x, int y) {

        StringBuffer num_s = new StringBuffer(String.valueOf(num));
        int length = num_s.length();
        for (int i = 0; i < length; i++) {
            char digit = num_s.charAt(i);
            if (digit - '0' == x) {
                num_s.setCharAt(i, (char) ('0' + y));
            }
        }

        return num_s.toString();
    }







// 2016. maximum difference between increasing elements
    public int maximumDifference(int[] nums) {


        int min = nums[0];
        int max = -1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] > min) {
                max = Math.max(max, nums[i] - min);
            } else {
                min = nums[i];
            }


        }

      return max;
    }






        // 3405. count the number of arrays with k matching adjacent elements
        static final int MOD = (int) 1e9 + 7;
        static final int MX = 100000;
        static long[] fact = new long[MX];
        static long[] invFact = new long[MX];

        static long qpow(long x, int n) {
            long res = 1;
            while (n > 0) {
                if ((n & 1) == 1) {
                    res = (res * x) % MOD;
                }
                x = (x * x) % MOD;
                n >>= 1;
            }
            return res;
        }

        static {
            fact[0] = 1;
            for (int i = 1; i < MX; i++) {
                fact[i] = (fact[i - 1] * i) % MOD;
            }
            invFact[MX - 1] = qpow(fact[MX - 1], MOD - 2);
            for (int i = MX - 1; i > 0; i--) {
                invFact[i - 1] = (invFact[i] * i) % MOD;
            }
        }

        long comb(int n, int m) {
            return (((fact[n] * invFact[m]) % MOD) * invFact[n - m]) % MOD;
        }

        public int countGoodArrays(int n, int m, int k) {
            return (int) ((((comb(n - 1, k) * m) % MOD) * qpow(m - 1, n - k - 1)) %
                    MOD);
        }





        // 2966. divide array into arrays with max difference
    public int[][] divideArray(int[] nums, int k) {

            int n = nums.length / 3;
            Arrays.sort(nums);

            int[][] result = new int[n][3];

            for (int i = 0; i < nums.length; i+=3) {
             if (nums[i + 2] - nums[i] > k) {
                 return new int[0][0];
             }
             result[i / 3] = new int[]{nums[i], nums[i + 1], nums[i + 2]};
            }


            return result;


    }


// 2294. partition array such that maximum difference is k
    public int partitionArray(int[] nums, int k) {

        Arrays.sort(nums);

        int answer = 1;
        int res = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - res > k) {
                answer++;
                res = nums[i];
            }
        }
        return answer;

    }






    // 3443 maximum manhattan distance after k changes
    public int maxDistance(String s, int k) {

          int latitude = 0;
          int longitude = 0;
          int answer = 0;

          int n = s.length();

          for (int i = 0; i < n; i++) {
              char c = s.charAt(i);
              switch (c) {
                  case 'N':
                      latitude++;
                      break;
                  case 'S':
                      latitude--;
                      break;
                  case 'E':
                      longitude++;
                      break;
                  case 'W':
                      longitude--;
                      break;
              }
              answer = Math.max(answer,    Math.min(
                      Math.abs(latitude) + Math.abs(longitude) + k * 2,
                      i + 1
              ));
          }


            return answer;
    }









    // 3085. minimum deletions to make string k-special
    public int minimumDeletions(String word, int k) {

            Map<Character, Integer> count = new HashMap<>();

            for (char ch : word.toCharArray()) {
                count.put(ch, count.getOrDefault(ch, 0) + 1);
            }

            int result = word.length();

            for (int a : count.values()) {
                int deleted = 0;
                for (int b : count.values()) {
                    if (a > b) {
                        deleted += b;
                    } else if (b > a + k) {
                        deleted += b - (a + k);
                    }
                }
                result = Math.min(result, deleted);
            }
            return result;
        }





        // 2138. divide a string into groups of size k
    public String[] divideString(String s, int k, char fill) {

            int len = (s.length() + k - 1) / k;

            String[] result = new String[len];

            for (int i = 0; i < len; i++) {
                int start = i * k;
                int end = Math.min(start + k, s.length());

                String group = s.substring(start, end);

                while (group.length() < k) {
                    group += fill;
                }
                result[i] = group;
            }

            return result;
    }




    // 2081. sum of k-mirror numbers
        private int[] digit = new int[100];

        public long kMirror(int k, int n) {
            int left = 1, count = 0;
            long ans = 0;
            while (count < n) {
                int right = left * 10;
                // op = 0 indicates enumerating odd-length palindromes
                // op = 1 indicates enumerating even-length palindromes
                for (int op = 0; op < 2; ++op) {
                    // enumerate i'
                    for (int i = left; i < right && count < n; ++i) {
                        long combined = i;
                        int x = (op == 0 ? i / 10 : i);
                        while (x > 0) {
                            combined = combined * 10 + (x % 10);
                            x /= 10;
                        }
                        if (isPalindrome(combined, k)) {
                            ++count;
                            ans += combined;
                        }
                    }
                }
                left = right;
            }
            return ans;
        }

        private boolean isPalindrome(long x, int k) {
            int length = -1;
            while (x > 0) {
                ++length;
                digit[length] = (int) (x % k);
                x /= k;
            }
            for (int i = 0, j = length; i < j; ++i, --j) {
                if (digit[i] != digit[j]) {
                    return false;
                }
            }
            return true;
        }






        // 2200. find all k-distant indices in an array
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {

            List<Integer> result = new ArrayList<>();

            int r = 0;
            int n = nums.length;

            for (int j = 0; j < n; j++) {
                if (nums[j] == key) {
                    int l = Math.max(r, j - k);
                    r = Math.min(n - 1, j + k) + 1;
                    for (int i = l; i < r; i++) {
                        result.add(i);
                    }
                }
            }
            return result;
        }




        // 2040. Kth smallest product of two sorted arrays
    public long kthSmallestProduct(int[] nums1, int[] nums2, int k) {
        long left = -10000000000L;
        long right = 10000000000L;

        while (left < right) {
            long mid = left + (right - left) / 2;
            if (countProducts(nums1, nums2, mid) < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }


    private long countProducts(int[] nums1, int[] nums2, long target) {
            long count = 0;
            for (int num : nums1) {
                if (num == 0) {
                    if (target >= 0) count += nums2.length;
                    continue;
                }



                int low = 0, high = nums2.length;
                while (low < high) {
                    int mid = low + (high - low) / 2;
                    long product = (long) num * nums2[mid];
                    if (product <= target) {
                        if (num > 0) low = mid + 1;
                        else high = mid;
                    } else {
                        if (num > 0) high = mid;
                        else low = mid + 1;
                    }
                }
                count += (num > 0) ? low : nums2.length - high;
            }


            return count;

    }





    // 2311. longest binary subsequence less than or equal to k
    public int longestSubsequence(String s, int k) {

            int sm = 0;
            int count = 0;

            int bits = (int) (Math.log(k) / Math.log(2)) + 1;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(s.length() - 1 - i);
                if (ch == '1') {
                    if (i < bits && sm + (1 << i) <= k) {
                        sm += 1 << i;
                        count++;
                    }
                } else {
                    count++;
                }
            }

            return count;

    }





    // 2014. longest subsequence repeated k times
        public String longestSubsequenceRepeatedK(String s, int k) {
            int[] freq = new int[26];
            for (char ch : s.toCharArray()) {
                freq[ch - 'a']++;
            }
            List<Character> candidate = new ArrayList<>();
            for (int i = 25; i >= 0; i--) {
                if (freq[i] >= k) {
                    candidate.add((char) ('a' + i));
                }
            }

            Queue<String> q = new LinkedList<>();
            for (char ch : candidate) {
                q.add(String.valueOf(ch));
            }
            String ans = "";
            while (!q.isEmpty()) {
                String curr = q.poll();
                if (curr.length() > ans.length()) {
                    ans = curr;
                }
                // generate the next candidate string
                for (char ch : candidate) {
                    String next = curr + ch;
                    if (isKRepeatedSubsequence(s, next, k)) {
                        q.add(next);
                    }
                }
            }

            return ans;
        }

        private boolean isKRepeatedSubsequence(String s, String t, int k) {
            int pos = 0, matched = 0;
            int m = t.length();
            for (char ch : s.toCharArray()) {
                if (ch == t.charAt(pos)) {
                    pos++;
                    if (pos == m) {
                        pos = 0;
                        matched++;
                        if (matched == k) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }






    // 2099 find subsequence of length k with the largest sum
    public int[] maxSubsequence(int[] nums, int k) {

        int n = nums.length;

        int[][] vals = new int[n][2];
        for (int i = 0; i < n; i++) {
            vals[i][0] = i;
            vals[i][1] = nums[i];
        }


        Arrays.sort(vals, (a, b) -> Integer.compare(b[1], a[1]));

        Arrays.sort(vals, 0, k, (a, b) -> Integer.compare(a[0], b[0]));
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = vals[i][1];
        }
        return result;
    }




    // 1498. number of subsequences that satisfy the given sum condition
    public int numSubseq(int[] nums, int target) {
        int mod = 1_000_000_007;
        Arrays.sort(nums);

        int n = nums.length;
        int left = 0, right = n - 1;
        int result = 0;

        // precompute powers of 2
        int[] pow2 = new int[n];
        pow2[0] = 1;
        for (int i = 1; i < n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % mod;
        }

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                // all subsequences formed with nums[left] as min and any subset of [left+1..right]
                result = (result + pow2[right - left]) % mod;
                left++;
            } else {
                right--;
            }
        }

        return result;
    }



    // 594. longest harmonious subsequence
    public int findLHS(int[] nums) {

            Arrays.sort(nums);
            int j = 0;
            int maxLen = 0;

            for (int i = 0; i < nums.length; i++) {
                while (nums[i] - nums[j] > 1) {
                    j++;
                }
                if (nums[i] - nums[j] == 1) {
                    maxLen = Math.max(maxLen, i - j + 1);
                }
            }
            return maxLen;
    }































































































































}
