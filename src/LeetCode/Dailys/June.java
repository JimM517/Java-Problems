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




















































































}
