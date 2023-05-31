public class Main {

    public static void main(String[] args) {
        Exercises exercises = new Exercises();

        int[] nums = {2, 4, 5, 18, 20, 45, 2, 10, 6};

        int[] testArr = {1, 4, 5, 10, 40, 20, 17};

        int[] testTriples = {1, 2, 4, 3, 3, 3, 5, 7, 8};

        int[] triples = {1, 4, 5, 6, 7, 8, 9, 9, 9, 10};

        int[] numberTwoThree = {1, 5};
        int[] numbers = {2, 4};

        int[] numberFourteen = {2, 3, 8, 9, 10, 22, 44, 72};

        int[] more14 = {1, 1, 1, 1, 4, 5, 6, 4, 7, 8};
        int[] forFourMore = {1, 1, 3, 5, 4, 4, 4, 4, 4, 7};


        int[] middle ={1, 2, 3, 4}; //2, 3
        int[] anotherMakeMiddle = {7, 1, 2, 3, 4, 9};  //2, 3
        int[] newMakeMiddle = {1, 2}; // 1, 2

        int[] last = {4, 5, 6};
        int[] anotherLast = {1, 2};

        int a = 20;
        int b = 45;
        int c = 55;

//        System.out.println(Arrays.toString(exercises.fizzArrayThree(5, 10)));

//        System.out.println(exercises.noTriples(triples));

//        System.out.println(exercises.more14(forFourMore));

//        System.out.println(Arrays.toString(exercises.makeLast(anotherLast)));

        System.out.println(exercises.lessBy10(a, b, c));

    }
}
