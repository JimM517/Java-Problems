package LeetCode.Dailys;

import java.util.*;
import java.util.stream.Collectors;

public class September {




    // 1792. maximum average pass ratio
    // time limit exceeded
        public double maxAverageRatio(int[][] classes, int extraStudents) {
            List<Double> passRatios = new ArrayList<>();

            // Calculate initial pass ratios
            for (int classIndex = 0; classIndex < classes.length; classIndex++) {
                double initialRatio =
                        (double) classes[classIndex][0] / classes[classIndex][1];
                passRatios.add(initialRatio);
            }

            while (extraStudents > 0) {
                List<Double> updatedRatios = new ArrayList<>();

                // Calculate updated pass ratios if an extra student is added
                for (
                        int classIndex = 0;
                        classIndex < classes.length;
                        classIndex++
                ) {
                    double newRatio =
                            (double) (classes[classIndex][0] + 1) /
                                    (classes[classIndex][1] + 1);
                    updatedRatios.add(newRatio);
                }

                int bestClassIndex = 0;
                double maximumGain = 0;

                // Find the class that gains the most from an extra student
                for (
                        int classIndex = 0;
                        classIndex < updatedRatios.size();
                        classIndex++
                ) {
                    double gain =
                            updatedRatios.get(classIndex) - passRatios.get(classIndex);
                    if (gain > maximumGain) {
                        bestClassIndex = classIndex;
                        maximumGain = gain;
                    }
                }

                // Update the selected class
                passRatios.set(bestClassIndex, updatedRatios.get(bestClassIndex));
                classes[bestClassIndex][0]++;
                classes[bestClassIndex][1]++;

                extraStudents--;
            }

            // Calculate the total average pass ratio
            double totalPassRatio = 0;
            for (double passRatio : passRatios) {
                totalPassRatio += passRatio;
            }

            return totalPassRatio / classes.length;
        }





        // this solution works
        public double maxAverageRatioTwo(int[][] classes, int extraStudents) {
            // Lambda to calculate the gain of adding an extra student
            PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) ->
                    Double.compare(b[0], a[0])
            );

            for (int[] singleClass : classes) {
                int passes = singleClass[0];
                int totalStudents = singleClass[1];
                double gain = calculateGain(passes, totalStudents);
                maxHeap.offer(new double[] { gain, passes, totalStudents });
            }

            // Distribute extra students
            while (extraStudents-- > 0) {
                double[] current = maxHeap.poll();
                double currentGain = current[0];
                int passes = (int) current[1];
                int totalStudents = (int) current[2];
                maxHeap.offer(
                        new double[] {
                                calculateGain(passes + 1, totalStudents + 1),
                                passes + 1,
                                totalStudents + 1,
                        }
                );
            }

            // Calculate the final average pass ratio
            double totalPassRatio = 0;
            while (!maxHeap.isEmpty()) {
                double[] current = maxHeap.poll();
                int passes = (int) current[1];
                int totalStudents = (int) current[2];
                totalPassRatio += (double) passes / totalStudents;
            }

            return totalPassRatio / classes.length;
        }

        private double calculateGain(int passes, int totalStudents) {
            return (
                    (double) (passes + 1) / (totalStudents + 1) -
                            (double) passes / totalStudents
            );
        }




        // 3025. find the number of ways to place people I
    public int numberOfPairs(int[][] points) {

         int answer = 0;
         int n = points.length;

         for (int i = 0; i < n; i++) {
             int[] pointA = points[i];
             for (int j = 0; j < n; j++) {
                 int[] pointB = points[j];
                 if (i == j || !(pointA[0] <= pointB[0] && pointA[1] >= pointB[1])) {
                     continue;
                 }
                 if (n == 2) {
                     answer++;
                     continue;
                 }

                 boolean illegal = false;
                 for (int k = 0; k < n; k++) {
                     if (k == i || k == j) {
                         continue;
                     }
                     int[] pointTemp = points[k];
                     boolean isXContained = pointTemp[0] >= pointA[0] && pointTemp[0] <= pointB[0];
                     boolean isYContained = pointTemp[1] <= pointA[1] && pointTemp[1] >= pointB[1];
                     if (isXContained && isYContained) {
                         illegal = true;
                         break;
                     }
                 }
                 if (!illegal) {
                     answer++;
                 }
             }
         }


        return answer;


    }




    // 3027. find the number of ways to place people II
    public int numberOfPairsTwo(int[][] points) {
            int ans = 0;
            Arrays.sort(points, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
            for (int i = 0; i < points.length - 1; i++) {
                int[] pointA = points[i];
                int xMin = pointA[0] - 1;
                int xMax = Integer.MAX_VALUE;
                int yMin = Integer.MIN_VALUE;
                int yMax = pointA[1] + 1;

                for (int j = i + 1; j < points.length; j++) {
                    int[] pointB = points[j];
                    if (
                            pointB[0] > xMin &&
                                    pointB[0] < xMax &&
                                    pointB[1] > yMin &&
                                    pointB[1] < yMax
                    ) {
                        ans++;
                        xMin = pointB[0];
                        yMin = pointB[1];
                    }
                }
            }
            return ans;
        }






    // 3516. find the closest person
    public int findClosest(int x, int y, int z) {

            int xCord = Math.abs(z - x);
            int yCord = Math.abs(z - y);

            if (xCord < yCord) {
                return 1;
            } else if (xCord > yCord) {
                return 2;
            }
        return 0;
    }





    // 2749. minimum operations to make the integer zero
    public int makeTheIntegerZero(int num1, int num2) {

            int k = 1;
            while (true) {
                long x = num1 - (long) num2 * k;
                if (x < k) {
                    return -1;
                }
                if (k >= Long.bitCount(x)) {
                    return k;
                }
                k++;
            }
        }





    // 3495. minimum operations to make array elements zero
    // no clue
    private long get(int num) {
        long count = 0;
        int i = 1;
        int base = 1;
        while (base <= num) {
            int end = Math.min(base * 2 - 1, num);
            count += (long) ((i + 1) / 2) * (end - base + 1);
            i++;
            base *= 2;
        }
        return count;
    }

    public long minOperations(int[][] queries) {
        long result = 0;
        for (int[] q : queries) {
            long count1 = get(q[1]);
            long count2 = get(q[0] - 1);
            result += (count1 - count2 + 1) / 2;
        }
        return result;
    }





    // 1304. find N unique integers sum up to zero
    public int[] sumZero(int n) {

            int[] answer = new int[n];
            int idx = 0;

            for (int i = 1; i <= n / 2; i++) {
                answer[idx++] = i;
                answer[idx++] = -i;
            }
            if (n % 2 == 1) {
                answer[idx] = 0;
            }


            return answer;


    }





    // 1317. convert integer to the sum of two no-zero integers
    public int[] getNoZeroIntegers(int n) {

        for (int A = 1; A < n; A++) {
            int B = n - A;
            if (!String.valueOf(A).contains("0") && !String.valueOf(B).contains("0")) {
                return new int[] {A, B};
            }
        }
        return new int[0];
    }



    // 2327. number of people aware of a secret
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int MOD = 1_000_000_007;
        long[] dp = new long[n + 1];
        dp[1] = 1;
        long share = 0;

        for (int day = 2; day <= n; day++) {
            if (day - delay >= 1) {
                share = (share + dp[day - delay]) % MOD;
            }

            if (day - forget >= 1) {
                share = (share - dp[day - forget] + MOD) % MOD;
            }
            dp[day] = share;
        }

        long result = 0;
        for (int i = n - forget + 1; i <= n; i++) {
            if (i >= 1) {
                result = (result + dp[i]) % MOD;
            }
        }
        return (int) result;
    }





    // minimum number of people to teach
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {

            Set<Integer> cncon = new HashSet<>();
            for (int[] friendship : friendships) {
                Map<Integer, Integer> mp = new HashMap<>();
                boolean conm = false;
                for (int lan : languages[friendship[0] - 1]) {
                    mp.put(lan, 1);
                }
                for (int lan : languages[friendship[1] - 1]) {
                    if (mp.containsKey(lan)) {
                        conm = true;
                        break;
                    }
                }
                if (!conm) {
                    cncon.add(friendship[0] - 1);
                    cncon.add(friendship[1] - 1);
                }
            }

            int max_count = 0;
            int[] cnt = new int[n + 1];
            for (int friendship : cncon) {
                for (int lan : languages[friendship]) {
                    cnt[lan]++;
                    max_count = Math.max(max_count, cnt[lan]);
                }
            }


            return cncon.size() - max_count;
    }





    // 2785. sort vowels in a string
        // Returns true if the character is a vowel.
        boolean isVowel(Character c) {
            return c == 'a' || c == 'e' || c == 'o'|| c == 'u'|| c == 'i'
                    || c == 'A' || c == 'E' || c == 'O'|| c == 'U'|| c == 'I';
        }

        public String sortVowels(String s) {
            ArrayList<Character> temp = new ArrayList<>();

            // Store the vowels in the temporary string.
            for (char c : s.toCharArray()) {
                if (isVowel(c)) {
                    temp.add(c);
                }
            }

            // Sort the temporary string characters in ascending order.
            Collections.sort(temp);

            StringBuilder ans = new StringBuilder();
            int j = 0;
            for (int i = 0; i < s.length(); i++) {
                // If the character is a vowel, replace it with the character in the string temp.
                if (isVowel(s.charAt(i))) {
                    ans.append(temp.get(j));
                    j++;
                } else {
                    ans.append(s.charAt(i));
                }
            }

            return ans.toString();
        }




        // 3227. vowels game in a string
    public boolean doesAliceWin(String s) {
        return s
                .chars()
                .anyMatch(c -> {
                    return "aeiou".indexOf(c) != -1;
                });
    }



    // 3541. find most frequent vowel and consonant
    public int maxFreqSum(String s) {

         Map<Character, Integer> vowels = new HashMap<>();
         Map<Character, Integer> consonants = new HashMap<>();

         for (int i = 0; i < s.length(); i++) {

             if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
                 vowels.put(s.charAt(i), vowels.getOrDefault(s.charAt(i), 0) + 1);
             } else {
                 consonants.put(s.charAt(i), consonants.getOrDefault(s.charAt(i), 0) + 1);
             }


         }

         int vowelMax = 0;
         int consonantMax = 0;

         for (int x : vowels.values()) {
           vowelMax = Math.max(vowelMax, x);
         }

         for (int x : consonants.values()) {
             consonantMax = Math.max(consonantMax, x);
         }

        return vowelMax + consonantMax;
    }



    // 966 vowel spellchecker
    Set<String> words_perfect;
    Map<String, String> words_cap;
    Map<String, String> words_vow;
    public String[] spellChecker(String[] wordList, String[] queries) {

            words_perfect = new HashSet<>();
            words_cap = new HashMap<>();
            words_vow = new HashMap<>();

            for (String word : wordList) {
                words_perfect.add(word);

                String wordLow = word.toLowerCase();
                words_cap.putIfAbsent(wordLow, word);

                String wordlowDV = devowel(wordLow);
                words_vow.putIfAbsent(wordlowDV, word);
            }

            String[] answer = new String[queries.length];
            int t = 0;
            for (String query : queries) {
                answer[t++] = solve(query);
            }
            return answer;

    }

    public String solve(String query) {

        if (words_perfect.contains(query)) {
            return query;
        }

        String queryL = query.toLowerCase();
        if (words_cap.containsKey(queryL)) {
            return words_cap.get(queryL);
        }

        String queryLV = devowel(queryL);
        if (words_vow.containsKey(queryLV)) {
            return words_vow.get(queryLV);
        }
        return "";
    }

    public String devowel(String word) {
        StringBuilder answer = new StringBuilder();
        for (char c : word.toCharArray()) {
            answer.append(isVowel(c) ? '*' : c);
        }
        return answer.toString();
    }


    boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }





    // 1935. maximum number of words you can type
    public int canBeTypedWords(String text, String brokenLetters) {


        int total = 0;

        String[] strings = text.split(" ");

        for (String str : strings) {
            boolean canType = true;
            for (char ch : brokenLetters.toCharArray()) {
                if (str.indexOf(ch) != -1) {
                    canType = false;
                    break;
                }
            }
            if (canType) {
                total++;
            }
        }

        return total;
    }



    // 2197. replace non-coprime numbers in array
        private long gcd(long a,long b){
            while(b!=0){
                long temp=b;
                b=a%b;
                a=temp;
            }
            return a;
        }
        public List<Integer> replaceNonCoprimes(int[] nums) {
            int n=nums.length;
            Stack<Long> st=new Stack<>();
            st.push(1l*nums[0]);
            for(int i=1;i<n;i++){
                long gcd=gcd(st.peek(),1l*nums[i]);
                if(gcd==1) st.push(1l*nums[i]);
                else{
                    long lcm=(st.pop()*nums[i])/gcd;
                    if(!st.isEmpty()) gcd=gcd(st.peek(),lcm);
                    while(!st.isEmpty()&&gcd!=1){
                        lcm=(st.pop()*lcm)/gcd;
                        if(!st.isEmpty()) gcd=gcd(st.peek(),lcm);
                    }
                    st.push(lcm);
                }
            }
            List<Integer> ans=new ArrayList<>();
            while(!st.isEmpty()){
                long a=st.pop();
                ans.add(0,(int)a);
            }
            return ans;
        }






    // 2353. design a food rating system
    class Food implements Comparable<Food> {
        public int foodRating;
        public String foodName;

        public Food(int foodRating, String foodName) {
            this.foodRating = foodRating;
            this.foodName = foodName;
        }

        @Override
        public int compareTo(Food other) {
            if (foodRating == other.foodRating) {
                return foodName.compareTo(other.foodName);
            }
            return -1 * Integer.compare(foodRating, other.foodRating);
        }
    }

    class FoodRatings {

        private Map<String, Integer> foodRatingMap;
        private Map<String, String> foodCuisineMap;
        private Map<String, PriorityQueue<Food>> cuisineFoodMap;

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
                foodRatingMap = new HashMap<>();
                foodCuisineMap = new HashMap<>();
                cuisineFoodMap = new HashMap<>();

                for (int i = 0; i < foods.length; i++) {
                    foodRatingMap.put(foods[i], ratings[i]);
                    foodCuisineMap.put(foods[i], cuisines[i]);
                    cuisineFoodMap.computeIfAbsent(cuisines[i], k -> new PriorityQueue<>()).add(new Food(ratings[i], foods[i]));
                }
        }

        public void changeRating(String food, int newRating) {
            foodRatingMap.put(food, newRating);
            String cuisineName = foodCuisineMap.get(food);
            cuisineFoodMap.get(cuisineName).add(new Food(newRating, food));
        }


        public String highestRated(String cuisine) {
            Food highestRated = cuisineFoodMap.get(cuisine).peek();

            while (foodRatingMap.get(highestRated.foodName) != highestRated.foodRating) {
                cuisineFoodMap.get(cuisine).poll();
                highestRated = cuisineFoodMap.get(cuisine).peek();
            }
            return highestRated.foodName;
        }
    }





    // 3408 Design Task Manager
    class TaskManager {

        private static class Task implements Comparable<Task> {
            int userId;
            int taskId;
            int priority;



            Task(int userId, int taskId, int priority) {
                this.userId = userId;
                this.taskId = taskId;
                this.priority = priority;
            }

            @Override
            public int compareTo(Task other) {
                if (this.priority != other.priority) {
                    return Integer.compare(other.priority, this.priority);
                }
                return Integer.compare(other.taskId, this.taskId);
            }


        }

        private final TreeMap<Task, Integer> sortedTasks;
        private final Map<Integer, Task> taskMap;

        public TaskManager(List<List<Integer>> tasks) {
            sortedTasks = new TreeMap<>();
            taskMap = new HashMap<>();

            for (List<Integer> task : tasks) {
                int userId = task.get(0);
                int taskId = task.get(1);
                int priority = task.get(2);
                add(userId, taskId, priority);
            }
        }

        public void add(int userId, int taskId, int priority) {
            Task task = new Task(userId, taskId, priority);
            sortedTasks.put(task, userId);
            taskMap.put(taskId, task);
        }

        public void edit(int taskId, int newPriority) {
            Task task = taskMap.get(taskId);
            if (task != null) {
                sortedTasks.remove(task);
                task.priority = newPriority;
                sortedTasks.put(task, task.userId);
            }
        }

        public void rmv(int taskId) {
            Task task = taskMap.get(taskId);
            if (task != null) {
                sortedTasks.remove(task);
                taskMap.remove(taskId);
            }
        }

        public int execTop() {
            if (sortedTasks.isEmpty()) {
                return -1;
            }
            Task topTask = sortedTasks.firstKey();
            sortedTasks.remove(topTask);
            taskMap.remove(topTask.taskId);
            return topTask.userId;
        }




    }




    // 3484. design spreadsheet
    class Spreadsheet {

        private int rows;
        private Map<String, Integer> cells;

        public Spreadsheet(int rows) {
            this.rows = rows;
            this.cells = new HashMap<>();
        }

        public void setCell(String cell, int value) {
            cells.put(cell, value);
        }

        public void resetCell(String cell) {
            cells.remove(cell);
        }

        public int getValue(String formula) {
            String[] parts = formula.substring(1).split("\\+");
            return get(parts[0]) + get(parts[1]);
        }

        private int get(String s) {
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                return cells.getOrDefault(s, 0);
            }
        }


    }




    // 3508. implement router
    class Router {

        private final int size;
        private final Map<Integer, List<Integer>> counts;
        private final Map<Long, int[]> packets;
        private final Queue<Long> queue;

        public Router(int memoryLimit) {
            this.size = memoryLimit;
            this.packets = new HashMap<>();
            this.counts = new HashMap<>();
            this.queue = new LinkedList<>();
        }

        public boolean addPacket(int source, int destination, int timestamp) {
            final long key = encode(source, destination, timestamp);
            if (packets.containsKey(key)) {
                return false;
            }
            if (packets.size() >= size) {
                forwardPacket();
            }
            packets.put(key, new int[] { source, destination, timestamp });
            queue.offer(key);

            counts.putIfAbsent(destination, new ArrayList<>());
            counts.get(destination).add(timestamp);

            return true;
        }

        public int[] forwardPacket() {
            if (packets.isEmpty()) {
                return new int[] {};
            }
            final long key = queue.poll();
            final int[] packet = packets.remove(key);

            if (packet == null) {
                return new int[]{};
            }
            final int destination = packet[1];
            final List<Integer> list = counts.get(destination);

            list.remove(0);
            return packet;
        }

        public int getCount(int destination, int startTime, int endTime) {
            final List<Integer> list = counts.get(destination);
            if (list == null || list.isEmpty()) {
                return 0;
            }
            final int left = lowerBound(list, startTime);
            final int right = upperBound(list, endTime);

            return right - left;
        }

        private long encode(final int source, final int destination, final int timestamp) {
            return ((long) source << 40) | ((long) destination << 20) | timestamp;
        }

        private int lowerBound(final List<Integer> list, final int target) {
            int low = 0;
            int high = list.size();

            while (low < high) {
                final int mid = (low + high) >>> 1;
                if (list.get(mid) < target) low = mid + 1;
                else high = mid;
            }
            return low;
        }


        private int upperBound(final List<Integer> list, final int target) {
            int low = 0;
            int high = list.size();

            while (low < high) {
                final int mid = (low + high) >>> 1;

                if (list.get(mid) <= target) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }


    }





// 1912. design movie rental system
class MovieRentingSystem {

        private static class Node {
            final int shop;
            final int movie;
            final int price;

            Node(int shop, int movie, int price) {
                this.shop = shop;
                this.movie = movie;
                this.price = price;
            }
        }

    private static final Comparator<Node> CMP =
            (a, b) -> {
                int c = Integer.compare(a.price, b.price);
                if (c != 0) return c;
                c = Integer.compare(a.shop, b.shop);
                if (c != 0) return c;
                return Integer.compare(a.movie, b.movie);
            };


        private final Map<Integer, TreeSet<Node>> availableByMovie = new HashMap<>();
        private final TreeSet<Node> rentedSet = new TreeSet<>(CMP);
        private final Map<Long, Node> byPair = new HashMap<>();

        private static long key(int shop, int movie) {
            return (((long) shop) << 32) ^ (movie & 0xffffffffL);
        }

        public MovieRentingSystem(int n, int[][] entries) {
            for (int[] e : entries) {
                int shop = e[0], movie = e[1], price = e[2];
                Node node = new Node(shop, movie, price);
                byPair.put(key(shop, movie), node);
                availableByMovie.computeIfAbsent(movie, k -> new TreeSet<>(CMP)).add(node);
            }
        }

        public List<Integer> search(int movie) {
            List<Integer> answer = new ArrayList<>();
            TreeSet<Node> set = availableByMovie.get(movie);
            if (set == null || set.isEmpty()) return answer;
            Iterator<Node> it = set.iterator();
            for (int i = 0; i < 5 && it.hasNext(); i++) {
                answer.add(it.next().shop);
            }
            return answer;
        }

        public void rent(int shop, int movie) {
            long k = key(shop, movie);
            Node node = byPair.get(k);
            if (node == null) return;
            TreeSet<Node> set = availableByMovie.get(movie);
            if (set != null) set.remove(node);
            rentedSet.add(node);
        }

        public void drop(int shop, int movie) {
            long k = key(shop, movie);
            Node node = byPair.get(k);
            if (node == null) return;
            rentedSet.remove(node);
            availableByMovie.computeIfAbsent(movie, x -> new TreeSet<>(CMP)).add(node);
        }

        public List<List<Integer>> report() {
            List<List<Integer>> answer = new ArrayList<>(5);
            Iterator<Node> it = rentedSet.iterator();
            for (int i = 0; i < 5 && it.hasNext(); i++) {
                Node n = it.next();
                answer.add(Arrays.asList(n.shop, n.movie));
            }
            return answer;
        }










}






// 3005. count the elements with maximum frequency
    public int maxFrequencyElements(int[] nums) {

        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int maxFreq = 0;
        for (int f : freq.values()) {
            maxFreq = Math.max(maxFreq, f);
        }

        int res = 0;
        for (int f : freq.values()) {
            if (f == maxFreq) {
                res += f;
            }
        }


        return res;

    }




    // 165. compare version numbers
    public int compareVersion(String version1, String version2) {

        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        for (int i = 0; i < v1.length || i < v2.length; i++) {
            int num1 = 0;
            int num2 = 0;
            if (i < v1.length) {
                num1 = Integer.parseInt(v1[i]);
            }
            if (i < v2.length) {
                num2 = Integer.parseInt(v2[i]);
            }
            if (num1 > num2) {
                return 1;
            }
            if (num1 < num2) {
                return -1;
            }

        }


        return 0;

    }




    // 166. fraction to recurring decimal
    public String fractionToDecimal(int numerator, int denominator) {

        if (numerator == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        if (numerator < 0 ^ denominator < 0) {
            sb.append("-");
        }

        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));

        sb.append(dividend / divisor);
        long remainder = dividend % divisor;
        if (remainder == 0) {
            return sb.toString();
        }

        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                sb.insert(map.get(remainder), "(");
                sb.append(")");
                break;
            }
            map.put(remainder, sb.length());
            remainder *= 10;
            sb.append(remainder / divisor);
            remainder %= divisor;
        }

        return sb.toString();

    }




    // 120. Triangle
    public int minimumTotal(List<List<Integer>> triangle) {

        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int val = Math.min(triangle.get(i).get(j) + triangle.get(i + 1).get(j),
                        triangle.get(i).get(j) + triangle.get(i + 1).get(j + 1)
                );
                triangle.get(i).set(j, val);
            }
        }

        return triangle.get(0).get(0);


    }



    // 611. valid triangle number
    // binary search
        int binarySearch(int nums[], int l, int r, int x) {
            while (r >= l && r < nums.length) {
                int mid = (l + r) / 2;
                if (nums[mid] >= x)
                    r = mid - 1;
                else
                    l = mid + 1;
            }
            return l;
        }
        public int triangleNumber(int[] nums) {
            int count = 0;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) {
                int k = i + 2;
                for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
                    k = binarySearch(nums, k, nums.length - 1, nums[i] + nums[j]);
                    count += k - j - 1;
                }
            }
            return count;
        }




        // 812. largest triangle area
    public double largestTriangleArea(int[][] points) {

            // Gauss's area formula -> area = 0.5 * [x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)]

            int N = points.length;

            double result = 0;

            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    for (int k = j + 1; k < N; k++) {
                        result = Math.max(result, area(points[i], points[j], points[k]));
                    }
                }
            }

        return result;

    }


    public double area(int[] P, int[] Q, int[] R) {

        return 0.5 * Math.abs(P[0] * Q[1] + Q[0] * R[1] + R[0] * P[1] - P[1] * Q[0] - Q[1] * R[0] - R[1] * P[0]);
    }





// 976. largest triangle perimeter
    public int largestPerimeter(int[] nums) {

        Arrays.sort(nums);

        for (int i = nums.length - 3; i >= 0; i--) {
            if (nums[i] + nums[i + 1] > nums[i + 2]) {
                return nums[i] + nums[i + 1] + nums[i + 2];
            }
        }
        return 0;
    }




    // 1039. minimum score triangulation of polygon
    int n;
    int[] values;
    Map<Integer, Integer> memo = new HashMap<>();
    public int minScoreTriangulation(int[] values) {

        this.n = values.length;
        this.values = values;
        return dp(0, n - 1);



    }

    public int dp(int i, int j) {

        if (i + 2 > j) {
            return 0;
        }
        if (i + 2 == j) {
            return values[i] * values[i + 1] * values[j];
        }
        int key = i * n + j;
        if (!memo.containsKey(key)) {
            int minScore = Integer.MAX_VALUE;
            for (int k = i + 1; k < j; k++) {
                minScore = Math.min(minScore, values[i] * values[k] * values[j] + dp(i, k) + dp(k, j));
            }
            memo.put(key, minScore);
        }
        return memo.get(key);
    }




// 2221. find triangular sum of an array
    public int triangularSum(int[] nums) {

        List<Integer> current = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toList());

        while (current.size() > 1) {

            List<Integer> newNums = new ArrayList<>();
            for (int i = 0; i < current.size() - 1; i++) {
                newNums.add((current.get(i) + current.get(i + 1)) % 10);
            }
            current = newNums;

        }
        return current.get(0);

    }






































































































}
