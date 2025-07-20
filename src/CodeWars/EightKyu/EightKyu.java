package CodeWars.EightKyu;

import java.util.*;

public class EightKyu {

    // well of ideas
    public String well(String[] x) {

        int count = 0;

        for (String idx : x) {
            if (idx.equals("good")) {
                count++;
            }
        }

        if (count > 2) {
            return "I smell a series!";
        } else if (count == 1 || count == 2) {
            return "Publish!";
        } else {
            return "Fail!";
        }


    }




    // sum arrays
    public double sum(double[] numbers) {

        return Arrays.stream(numbers).sum();
    }





    // beginner series #4 Cockroach
    public int cockroachSpeed(double x) {

        double cmsPerSec = x * 100000 / 3600;


        return (int) Math.floor(cmsPerSec);
    }




    // sentence smash
    public String smash(String... words) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);

            if (i < words.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }





    // collinear vectors
    public boolean collinearity(int x1, int y1, int x2, int y2) {

        return x1 * y2 == y1 * x2;

    }




    // calculate BMI
    public String bmi(double weight, double height) {

        double BMI = weight / Math.pow(height, 2);


        if (BMI <= 18.5) {
            return "Underweight";
        } else if (BMI <= 25.0) {
            return "Normal";
        } else if (BMI <= 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }




    }






    // find th nth occurrence of a word in a string
    public static int findNthOccurrence(String subStr, String str, int occurrence) {


        int count = 0;

        for (int i = 0; i <= str.length() - subStr.length(); i++) {
            if (str.substring(i, i + subStr.length()).equals(subStr)) {
                count++;
                if (count == occurrence) {
                    return i;
                }
            }
        }

        return -1;


    }



// 1948. Delete duplicate folders in system
        class Trie {

            String serial; // current node structure's serialized representation
            Map<String, Trie> children = new HashMap<>(); // current node's child nodes
        }

        public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
            Trie root = new Trie(); // root node

            // build a trie tree
            for (List<String> path : paths) {
                Trie cur = root;
                for (String node : path) {
                    cur.children.putIfAbsent(node, new Trie());
                    cur = cur.children.get(node);
                }
            }

            Map<String, Integer> freq = new HashMap<>(); // hash table records the occurrence times of each serialized representation
            // post-order traversal based on depth-first search, calculate the serialized representation of each node structure
            construct(root, freq);
            List<List<String>> ans = new ArrayList<>();
            List<String> path = new ArrayList<>();
            // operate the trie, delete duplicate folders
            operate(root, freq, path, ans);
            return ans;
        }

        private void construct(Trie node, Map<String, Integer> freq) {
            if (node.children.isEmpty()) return; // if it is a leaf node, no operation is needed.

            List<String> v = new ArrayList<>();
            for (Map.Entry<String, Trie> entry : node.children.entrySet()) {
                construct(entry.getValue(), freq);
                v.add(entry.getKey() + "(" + entry.getValue().serial + ")");
            }

            Collections.sort(v);
            StringBuilder sb = new StringBuilder();
            for (String s : v) {
                sb.append(s);
            }
            node.serial = sb.toString();
            freq.put(node.serial, freq.getOrDefault(node.serial, 0) + 1);
        }

        private void operate(
                Trie node,
                Map<String, Integer> freq,
                List<String> path,
                List<List<String>> ans
        ) {
            if (freq.getOrDefault(node.serial, 0) > 1) return; // if the serialization representation appears more than once, it needs to be deleted

            if (!path.isEmpty()) {
                ans.add(new ArrayList<>(path));
            }

            for (Map.Entry<String, Trie> entry : node.children.entrySet()) {
                path.add(entry.getKey());
                operate(entry.getValue(), freq, path, ans);
                path.remove(path.size() - 1);
            }
        }
































}
