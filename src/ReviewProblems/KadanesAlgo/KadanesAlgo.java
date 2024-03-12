package ReviewProblems.KadanesAlgo;

public class KadanesAlgo {


    /*** Kadane algorithm problems from leet code 150 ***/


    // 53. maximum subarry
    public int maxSubArray(int[] nums) {

        int start = Integer.MIN_VALUE;

        int end = 0;


        for (int i = 0; i < nums.length; i++) {

            end += nums[i];

            if (start < end) {
                start = end;
            }

            if (end < 0) {
                end = 0;
            }

        }

        return start;



    }




}
