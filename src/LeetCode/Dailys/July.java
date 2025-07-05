package LeetCode.Dailys;

import java.util.*;

public class July {



    // 3330. find the original typed string I
    public int possibleStringCount(String word) {


        int result = 1;

        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                result++;
            }
        }

        return result;
    }










    // 3333. find the original typed string II
    private static final int mod = 1000000007;
    public int possibleStringCount(String word, int k) {
            int n = word.length();
            int cnt = 1;
            List<Integer> freq = new ArrayList<>();
            for (int i = 1; i < n; ++i) {
                if (word.charAt(i) == word.charAt(i - 1)) {
                    ++cnt;
                } else {
                    freq.add(cnt);
                    cnt = 1;
                }
            }
            freq.add(cnt);

            long ans = 1;
            for (int o : freq) {
                ans = (ans * o) % mod;
            }
            if (freq.size() >= k) {
                return (int) ans;
            }

            int[] f = new int[k];
            int[] g = new int[k];
            f[0] = 1;
            Arrays.fill(g, 1);
            for (int i = 0; i < freq.size(); ++i) {
                int[] f_new = new int[k];
                for (int j = 1; j < k; ++j) {
                    f_new[j] = g[j - 1];
                    if (j - freq.get(i) - 1 >= 0) {
                        f_new[j] = (f_new[j] - g[j - freq.get(i) - 1] + mod) % mod;
                    }
                }
                int[] g_new = new int[k];
                g_new[0] = f_new[0];
                for (int j = 1; j < k; ++j) {
                    g_new[j] = (g_new[j - 1] + f_new[j]) % mod;
                }
                f = f_new;
                g = g_new;
            }

            return (int) ((ans - g[k - 1] + mod) % mod);
        }






    // 3304. find the kth character in string game I
    public char kthCharacter(int k) {

        int answer = 0;
        int t;

        while (k != 1) {
            t = 31 - Integer.numberOfLeadingZeros(k);
            if ((1 << t) == k) {
                t--;
            }
            k = k - (1 << t);
            answer++;
        }


        return (char) ('a' + answer);
    }




    // 3307. find the kth character in string game II
    public char kthCharacter(long k, int[] operations) {

        int answer = 0;
        int t;

        while (k != 1) {
            t = 63 - Long.numberOfLeadingZeros(k);
            if ((1L << t) == k) {
                t--;
            }
            k = k - (1L << t);
            if (operations[t] != 0) {
                answer++;
            }

        }

        return (char) ('a' + (answer % 26));
    }




    // 1394. find the lucky integer in an array
    public int findLucky(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }


        int max = -1;

        for (int key : map.keySet()) {
            if (key == map.get(key)) {
                max = Math.max(max, key);
            }
        }
        return max;
    }




































































}
