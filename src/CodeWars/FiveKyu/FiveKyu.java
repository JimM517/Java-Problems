package CodeWars.FiveKyu;

public class FiveKyu {



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



















































































































































}
