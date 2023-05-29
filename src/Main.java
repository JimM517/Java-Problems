public class Main {

    public static void main(String[] args) {
        Exercises exercises = new Exercises();

        int[] nums = {2, 4, 5, 18, 20, 45, 2, 10, 6};

        int[] testArr = {1, 4, 5, 10, 40, 20, 17};

        int[] testTriples = {1, 2, 4, 3, 3, 3, 5, 7, 8};

        int[] triples = {1, 4, 5, 6, 7, 8, 9, 9, 9, 10};

//        System.out.println(Arrays.toString(exercises.fizzArrayThree(5, 10)));

        System.out.println(exercises.noTriples(triples));

    }
}
