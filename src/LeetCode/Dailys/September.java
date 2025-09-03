package LeetCode.Dailys;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

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















































































































}
