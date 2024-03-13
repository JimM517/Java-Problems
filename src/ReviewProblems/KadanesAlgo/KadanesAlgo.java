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




    // 918. Maximum sum circular array
    public int maxSubarraySumCircular(int[] nums) {

      int n = nums.length;

      int sum = 0;
      for (int num : nums) {
          sum += num;
      }


      int current = nums[0];
      int max = nums[0];

      int currentMin = nums[0];
      int min = nums[0];


      for (int i = 1; i < n; i++) {

          current = Math.max(current + nums[i], nums[i]);
          max = Math.max(max, current);


          currentMin = Math.min(currentMin + nums[i], nums[i]);
          min = Math.min(min, currentMin);



      }

      if (min == sum) {
          return max;
      }

        return Math.max(max, sum - min);
    }




}
