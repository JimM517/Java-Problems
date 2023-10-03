package Recursion;

public class RecursiveProbs {

    // factorial
    public int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }


    // Bunny Ears
    public int bunnyEars2(int bunnies) {
        // base case
        if (bunnies == 0) {
            return 0;
        }

        if (bunnies % 2 == 0) {
            return 3 + bunnyEars2(bunnies - 1);
        } else {
            return 2 + bunnyEars2(bunnies - 1);
        }



    }









}
