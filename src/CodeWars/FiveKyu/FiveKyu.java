package CodeWars.FiveKyu;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FiveKyu {


    public static void main(String[] args) {

        String input =
                "*********\n" +
                        "*       *\n" +
                        "*       *\n" +
                        "*********\n";




        findEndPoints(input);

    }







    // maximum subarray sum
    public static int sequence(int[] arr) {


        if (arr.length == 0) {
            return 0;
        }

        int current = 0;
        int max = 0;

        for (int num : arr) {

            current = Math.max(0, current + num);
            max = Math.max(max, current);

        }
        return max;

    }



    // mean square error
    public static double solution(int[] arr1, int[] arr2) {

        int n = arr1.length;

        double total = 0;

        for (int i = 0; i < n; i++) {
            double diff = arr1[i] - arr2[i];
            total += Math.pow(diff, 2);

        }


        return total / n;


    }


    // land perimeter
    public static String landPerimeter(String[] arr) {
        int perimeter = 0;
        int cols = arr[0].length();
        int rows = arr.length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr[i].charAt(j) == 'x') {
                    // add 4 -> each island has 4 sides
                    perimeter += 4;
                    if (i > 0 && arr[i - 1].charAt(j) == 'x') perimeter -= 1;
                    if (i < rows - 1 && arr[i + 1].charAt(j) == 'x') perimeter -= 1;
                    if (j > 0 && arr[i].charAt(j - 1) == 'x') perimeter -= 1;
                    if (j < cols - 1 && arr[i].charAt(j + 1) == 'x') perimeter -= 1;
                }
            }
        }

        String result = Integer.toString(perimeter);

        return "Total land perimeter: " + result;


    }




    // Rot13
    public static String rot13(String str) {

        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {

            if (c >= 'a' && c <= 'z') {
                // lowercase character
                char shifted = (char) ('a' + ((c - 'a' + 13) % 26));
                sb.append(shifted);
            } else if (c >= 'A' && c <= 'Z') {
                // uppercase character
                char shifted = (char)('A' + ((c - 'A' + 13) % 26));
                sb.append(shifted);
            } else {
                // non-alphabetic character will not change
                sb.append(c);
            }


        }


        return sb.toString();


    }






    // simple string expansion
    public static String solve(String s) {

        char[] a = new StringBuilder(s).reverse().toString().toCharArray();
        String b = "", c;
        for (char ch : a) {
            if (Character.isLetter(ch)) b += ch;
            else if (Character.isDigit(ch)) {
                int i = ch - '0' - 1;
                c = b;
                while (i > 0) {
                    b += c;
                    i--;
                }
            }
        }
        return new StringBuilder(b).reverse().toString();
    }




    // geometric series of events
    private static final List<String> DAYS = Arrays.asList("Mo", "Tu", "We", "Th", "Fr", "Sa", "Su");
    public static BigInteger findNthOccurrence(final String startDay, final int r, final BigInteger n, final String targetDay) {


        final int start = DAYS.indexOf(startDay);
        final int target = DAYS.indexOf(targetDay);
        final List<Integer> cycle = new ArrayList<>();
        int day = start;

        for (int i = 1; i <= 7; i++) {
            cycle.add(day);
            final int pow = BigInteger.valueOf(r).modPow(BigInteger.valueOf(i), BigInteger.valueOf(7)).intValue();
            day = (day + pow) % 7;
            if (day == start) break;
        }

        if (!cycle.contains(target)) return BigInteger.valueOf(-1);

        final int offset = cycle.indexOf(target);
        final int cycleLength = cycle.size();

        return n.subtract(BigInteger.ONE)
                .multiply(BigInteger.valueOf(cycleLength))
                .add(BigInteger.valueOf(offset + 1));


    }





    // string incrementer
    public static String incrementString(String str) {

        StringBuilder sb = new StringBuilder(" " + str);
        for (int i = sb.length() - 1; i >= 0; i--) {
            char ch = sb.charAt(i);
            if (Character.isDigit(ch)) {
                ch = ch == '9' ? '0' : ch++;
                sb.replace(i, i + 1, String.valueOf(ch));
                if (ch != '0') {
                    break;
                }
                continue;
            }
            sb.insert(i + 1, "1");
            break;
        }
        return sb.substring(1);

    }






    // first non-repeating character
    public static String firstNonRepeatingLetter(String s) {

        Map<Character, Integer> freq = new HashMap<>();

        // Count characters in a case-insensitive way
        for (char c : s.toCharArray()) {
            char lower = Character.toLowerCase(c);
            freq.put(lower, freq.getOrDefault(lower, 0) + 1);
        }

        // Second pass: find first non-repeating
        for (char c : s.toCharArray()) {
            char lower = Character.toLowerCase(c);
            if (freq.get(lower) == 1) {
                return String.valueOf(c);  // return original case
            }
        }

        return "";
    }





    // String n iterations
    public static String jumbledString(String s, long n) {

        if (s == null || s.length() < 2 || n == 0) {
            return s;
        }

        String original = s;
        String current = s;

        int cycle = 0;
        do {
            current = shuffle(current);
            cycle++;
        } while (!current.equals(original));

        long effective = n % cycle;
        current = s;

        for (int i = 0; i < effective; i++) {
            current = shuffle(current);
        }

        return current;

    }



    private static String shuffle(String s) {
        StringBuilder even = new StringBuilder();
        StringBuilder odd = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                even.append(s.charAt(i));
            } else {
                odd.append(s.charAt(i));
            }
        }
        return even.append(odd).toString();
    }






    // product of consecutive fib numbers
    public static long[] productFib(long prod) {

        int n = 0;
        long fn = fib(n);
        long fn1 = fib(n + 1);

        while (fn * fn1 < prod) {
            n++;
            fn = fn1;
            fn1 = fib(n + 1);
        }

        return new long[]{fn, fn1, fn * fn1 == prod ? 1 : 0};

    }



    // helper
    public static long fib(int n) {

        long one = 0;
        long two = 1;

        for (int i = 0; i < n; i++) {

            long next = one + two;
            one = two;
            two = next;




        }

        return two;


    }




    // directions reduction
    public static String[] dirReduc(String[] arr) {


        Stack<String> stack = new Stack<>();

        for (String dir : arr) {
            if (!stack.isEmpty() && isOpposite(stack.peek(), dir)) {
                stack.pop();
            } else {
                stack.push(dir);
            }
        }
        return stack.toArray(new String[0]);
    }


    // helper
    private static boolean isOpposite(String a, String b) {

        return (a.equals("NORTH") && b.equals("SOUTH")) ||
                (a.equals("SOUTH") && b.equals("NORTH")) ||
                (a.equals("EAST") && b.equals("WEST")) ||
                (a.equals("WEST") && b.equals("EAST"));



    }





    // integers: recreation one
    public static String listSquared(long m, long n) {

        List<String> result = new ArrayList<>();
        for(long i = m; i <= n; i++){
            long sum = 0;
            for(long j = 1; j <= i; j++){
                if(i % j == 0){
                    sum = sum + (j*j);
                }
            }
            double x = Math.sqrt(sum);
            if(x - Math.floor(x) == 0){
                result.add("[" + i + ", " + sum + "]");
            }
        }
        return result.toString();


    }





    // simple encryption #1 - alternating split
    public static String encrpyt(final String text, final int n) {

        if (text == null || text.isEmpty() || n <= 0) return text;

        String result = text;

        for (int i = 0; i < n; i++) {
            StringBuilder odd = new StringBuilder();
            StringBuilder even = new StringBuilder();

            for (int idx = 0; idx < result.length(); idx++) {
                if (idx % 2 == 1) odd.append(result.charAt(idx));
                else even.append(result.charAt(idx));
            }
            result = odd.append(even).toString();
        }
        return result;

    }


    public static String decrypt(final String encryptedText, final int n) {

        if (encryptedText == null || encryptedText.isEmpty() || n <= 0) return encryptedText;

        String result = encryptedText;

        for (int i = 0; i < n; i++) {
            int half = result.length() / 2;
            String odd = result.substring(0, half);
            String even = result.substring(half);

            StringBuilder sb = new StringBuilder();

            int idxOdd = 0, idxEven = 0;
            for (int idx = 0; idx < result.length(); idx++) {
                if (idx % 2 == 1) sb.append(odd.charAt(idxOdd++));
                else sb.append(even.charAt(idxEven++));
            }
            result = sb.toString();
        }

        return result;

    }




    // regex password validation
    public static final String REGEX = "^(?=.{6,}$)(?=.*[a-z])(?=.*[A-Z])(?=.*\\\\d)[A-Za-z\\\\d]+$";





    // human readable time
    public static String makeReadable(int seconds) {

        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int secs = seconds % 60;


        return String.format("%02d:%02d:%02d", hours, minutes, secs);




    }




    // weight for weight
    public static String orderWeight(String strng) {
        if (strng == null || strng.trim().isEmpty()) {
            return "";
        }

        return Arrays.stream(strng.trim().split("\\s"))
                .sorted((a, b) -> {
                    int weightA = digitSum(a);
                    int weightB = digitSum(b);

                    if (weightA == weightB) {
                        return a.compareTo(b);
                    }
                    return Integer.compare(weightA, weightB);
                })
                .collect(Collectors.joining(" "));

    }


    private static int digitSum(String s) {

        int sum = 0;
        for (char c : s.toCharArray()) {
            sum += c - '0';
        }


        return sum;

    }





// scramblies
    public static boolean scramble(String str1, String str2) {

        Map<Character, Integer> str1Map = new HashMap<>();


        for (char ch : str1.toCharArray()) {
            str1Map.put(ch, str1Map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : str2.toCharArray()) {
            if (str1Map.containsKey(ch) && str1Map.get(ch) > 0) {
                str1Map.put(ch, str1Map.get(ch) - 1);
            } else {
                return false;
            }
        }


        return true;



    }








    // uniform milk production
    /** not my solution, this one threw me off a bit **/
    public static int uniformMilkOutput(int[] a, int x) {

        int resIdx = -1;
        long currSum = 0, maxDiff = -1;
        Deque<Integer> minDeque = new LinkedList<>(), maxDeque = new LinkedList<>();
        for (int i = 0; i < a.length; ++i) {
            if (!minDeque.isEmpty() && minDeque.peekFirst() == i - x) minDeque.pollFirst();
            if (!maxDeque.isEmpty() && maxDeque.peekFirst() == i - x) maxDeque.pollFirst();
            while (!minDeque.isEmpty() && a[minDeque.peekLast()] > a[i]) minDeque.pollLast();
            while (!maxDeque.isEmpty() && a[maxDeque.peekLast()] < a[i]) maxDeque.pollLast();
            minDeque.offerLast(i); maxDeque.offerLast(i);
            currSum += a[i];
            if (i >= x - 1) {
                long avg = currSum * (x - 1);
                for (int j : new int[] {minDeque.peekFirst(), maxDeque.peekFirst()}) {
                    long d = Math.abs(avg - (currSum - a[j]) * x);
                    if (d > maxDiff || d == maxDiff && j < resIdx) {
                        maxDiff = d; resIdx = j;
                    }
                }
                currSum -= a[i - x + 1];
            }
        }
        return resIdx;

    }





    // can you get the loop?
//    public static int loopSize(Node node) {
//        Node a = node;
//        Node b = node.getNext();
//
//        while (a != b)
//        {
//            a = a.getNext();
//            b = b.getNext().getNext();
//        }
//
//        int len = 0;
//
//        do {
//            b = b.getNext();
//            len++;
//        } while (a != b);
//
//        return len;
//    }






// simple pig latin
    public static String pigIt(String str) {

        StringBuilder sb = new StringBuilder();

        String[] splitted = str.split(" ");

        for (int i = 0; i < splitted.length; i++) {

           String word = splitted[i];

           if (Character.isLetter(word.charAt(0))) {
               sb.append(word.substring(1))
                       .append(word.charAt(0))
                       .append("ay");
           } else {
               sb.append(word);
           }


           if (i < splitted.length - 1) {
               sb.append(" ");
           }



        }

        return sb.toString();


    }





    // max contiguous sum
    public static int maxContiguousSum(final int[] arr) {


        int max = 0;
        int curr = 0;

        for (int i = 0; i < arr.length; i++) {
            curr += arr[i];

            if (curr > max) {
                max = curr;
            }

            if (curr < 0) {
                curr = 0;
            }

        }
        return max;

    }




    // divide and maximize
    public static int divideAndMultiply(long[] numbers) {

        int mod = 1000000007;

        int powersOfTwo = 0;
        int largest = 0;

        for (int x = 0; x < numbers.length; x++) {
            while(numbers[x] % 2 == 0) {
                numbers[x] /= 2;
                powersOfTwo++;
            }
            if (numbers[x] > numbers[largest]) {
                largest = x;
            }
        }

        long total = 0;

        for (int x = 0; x < numbers.length; x++) {
            long number = numbers[x];

            if (x == largest) {
                while (powersOfTwo > 0) {
                    number = (number * 2) % mod;
                    powersOfTwo--;
                }
            }
            total = (total + number) % mod;
        }
        return (int) total;
    }



    // even fusc fun
    private static Map<Integer, Integer> memo = new HashMap<>();

    public static int fusc(int n) {
        if (n == 1) return 1;

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int result;

        if (n % 2 == 0) {
            result = fusc(n / 2);
        } else {
            result = fusc(n / 2) + fusc(n / 2 + 1);
        }


        memo.put(n, result);
        return result;


    }


    public static int closestEvenFusc(int n) {

        int m = n;

        while (true) {
            if (fusc(m) % 2 == 0) {
                return m;
            }
            m++;
        }



    }






    // going to zero or to infinity?
    public static double going(int n) {

        double sum = 1.0;
        double term = 1.0;

        for (int i = n; i > 1; i--) {
            term /= i;
            sum += term;
        }
        return sum;
    }


//    public static double factorial(int n) {
//
//        if (n == 1) {
//            return 1;
//        }
//
//        return n * factorial(n - 1);
//    }






// not very secure
    public static boolean alphanumeric(String s) {


        return s.length() > 0 && !s.matches(".*[^a-zA-Z0-9].*");


    }



    
    
    // did you mean...?
    // Levenshtein Distance
    public class Dictionary {

        private final String[] words;

        public Dictionary(String[] words) {
            this.words = words;
        }

        public String findMostSimilar(String to) {
            // TODO: this is your task ;)

            String bestWord = null;
            int bestDistance = Integer.MAX_VALUE;

            for (String word : words) {
                int distance = levenshteinDistance(word, to);

                if (distance < bestDistance) {
                    bestDistance = distance;
                    bestWord = word;
                }

            }
            return bestWord;

        }


        public int levenshteinDistance(String a, String b) {


            int[][] dp = new int[a.length() + 1][b.length() + 1];

            for (int i = 0; i <= a.length(); i++) {
                dp[i][0] = i;
            }

            for (int j = 0; j <= b.length(); j++) {
                dp[0][j] = j;
            }

            for (int i = 1; i <= a.length(); i++) {
                for (int j = 1; j <= b.length(); j++) {
                    int cost = (a.charAt(i - 1) == b.charAt(j - 1)) ? 0 : 1;

                    dp[i][j] = Math.min(
                            Math.min(
                                    dp[i - 1][j] + 1,
                                    dp[i][j - 1] + 1
                            ),
                            dp[i - 1][j - 1] + cost
                    );
                }
            }
            return dp[a.length()][b.length()];

        }



    }



// paginationHelper
    public class PaginationHelper<I> {

        private List<I> collection;
        private int itemsPerPage;

        public PaginationHelper(List<I> collection, int itemsPerPage) {
            this.collection = collection;
            this.itemsPerPage = itemsPerPage;
        }

        public int itemCount() {
            return collection.size();
        }

        public int pageCount() {

            return (collection.size() + itemsPerPage - 1) / itemsPerPage;

        }

        public int pageItemCount(int pageIndex) {
            if (pageIndex < 0 || pageIndex >= pageCount()) {
                return - 1;
            }

            if (pageIndex == pageCount() - 1) {
                return collection.size() - pageIndex * itemsPerPage;
            }
            return itemsPerPage;
        }

        public int pageIndex(int pageIndex) {
            if (pageIndex < 0 || pageIndex >= collection.size()) {
                return  - 1;
            }
            return pageIndex / itemsPerPage;
        }
}








// merged string checker
    public static boolean isMerge(String s, String part1, String part2) {

        if (s.length() != part1.length() + part2.length()) return false;

        boolean[][] dp = new boolean[part1.length() + 1][part2.length() + 1];
        dp[0][0] = true;

        for (int i = 0; i <= part1.length(); i++) {
            for (int j = 0; j <= part2.length(); j++) {
                int k = i + j - 1;
                if (i > 0 && dp[i - 1][j] && part1.charAt(i - 1) == s.charAt(k)) {
                    dp[i][j] = true;
                }
                if (j > 0 && dp[i][j - 1] && part2.charAt(j - 1) == s.charAt(k)) {
                    dp[i][j] = true;
                }
            }
        }

        return dp[part1.length()][part2.length()];
    }





    // josephus survivor
    public static int josephusSurvivor(final int n, final int k) {

        int survivor = 0;

        for (int i = 2; i <= n; i++) {
            survivor = (survivor + k) % i;
        }
        return survivor + 1;
    }










    // the hunger games - zoo disaster
    public static String[] whoEatsWho(final String zooInput) {

        Map<String, Set<String>> eats = buildEatsMap();

        List<String> zoo = new ArrayList<>(List.of(zooInput.split(",")));

        List<String> log = new ArrayList<>();
        log.add(zooInput);

        boolean ateSomething = true;

        while (ateSomething) {
            ateSomething = false;

            for (int i = 0; i < zoo.size(); i++) {
                String animal = zoo.get(i);

                if (!eats.containsKey(animal)) continue;

                // LEFT first
                if (i > 0 && canEat(animal, zoo.get(i - 1), eats)) {
                    String prey = zoo.remove(i - 1);
                    log.add(animal + " eats " + prey);
                    ateSomething = true;
                    break;
                }

                // RIGHT
                if (i < zoo.size() - 1 && canEat(animal, zoo.get(i + 1), eats)) {
                    String prey = zoo.remove(i + 1);
                    log.add(animal + " eats " + prey);
                    ateSomething = true;
                    break;
                }
            }
        }

        log.add(String.join(",", zoo));

        // ✅ Convert List<String> → String[]
        return log.toArray(new String[0]);
    }

    private static boolean canEat(String predator, String prey,
                                  Map<String, Set<String>> eats) {
        return eats.containsKey(predator) && eats.get(predator).contains(prey);
    }

    private static Map<String, Set<String>> buildEatsMap() {
        Map<String, Set<String>> eats = new HashMap<>();

        eats.put("antelope", Set.of("grass"));
        eats.put("big-fish", Set.of("little-fish"));
        eats.put("bug", Set.of("leaves"));

        eats.put("bear", Set.of(
                "big-fish", "bug", "chicken", "cow", "leaves", "sheep"
        ));

        eats.put("chicken", Set.of("bug"));
        eats.put("cow", Set.of("grass"));

        eats.put("fox", Set.of("chicken", "sheep"));
        eats.put("giraffe", Set.of("leaves"));
        eats.put("lion", Set.of("antelope", "cow"));
        eats.put("panda", Set.of("leaves"));
        eats.put("sheep", Set.of("grass"));

        return eats;
    }






    // line safari - find the end points
    // TODO review this one!
    private static final int[][] MOVES = {{1,0}, {1,1}, {1,-1}, {0,1}, {-1,0}, {-1,-1}, {-1,1}, {0,-1}};

    public static String findEndPoints(String s) {

        char[][] arr = Stream.of(s.split("\n")).map(r->r.toCharArray()).toArray(char[][]::new);

        for(int i=0;i<arr.length;i++) for(int j=0;j<arr[0].length;j++)
            if(arr[i][j]=='*' && someAsymetric(i,j,arr))
                arr[i][j]='X';

        return Stream.of(arr).map(String::new).collect(Collectors.joining("\n"))+"\n";
    }

    private static boolean someAsymetric(int x, int y, char[][] arr){
        return Stream.of(MOVES).anyMatch( m ->  isOutOrSpace(arr, x-m[0],   y-m[1])
                && !isOutOrSpace(arr, x+m[0],   y+m[1])
                && !isOutOrSpace(arr, x+2*m[0], y+2*m[1]) );
    }

    private static boolean isOutOrSpace(char[][] arr, int i, int j){
        return i<0 || j<0 || arr.length<=i || arr[i].length<=j ||  arr[i][j]==' ';
    }







    // simple fun #273: powerset
    public static int[][] power(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), result);

        int[][] output = new int[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            output[i] = result.get(i).stream().mapToInt(Integer::intValue).toArray();
        }


        return output;

    }



    public static void dfs(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {

        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        dfs(nums, index + 1, current, result);

        current.add(nums[index]);
        dfs(nums, index + 1, current, result);
        current.remove(current.size() - 1);

    }





    // perimeter of squares in a rectangle
    public static BigInteger perimeter(BigInteger n) {

        BigInteger fib = fibonacciSquares(n.add(BigInteger.valueOf(3)));
       return fib.subtract(BigInteger.ONE).multiply(BigInteger.valueOf(4));
    }



    public static BigInteger fibonacciSquares(BigInteger n) {
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;

        for (BigInteger i = BigInteger.ZERO; i.compareTo(n) < 0; i = i.add(BigInteger.ONE)) {
            BigInteger temp = a.add(b);
            a = b;
            b = temp;
        }
        return a;
    }
















































































































































}
