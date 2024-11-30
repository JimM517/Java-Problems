package InterviewQuestions.Winter2025;

public class InterviewQs {


    // 1529. Minimum suffix flips
    public int minFlips(String target) {

        int max = 0;
        char bit = '0';

        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) != bit) {
                max++;
                bit = target.charAt(i);
            }
        }
        return max;
    }






















}
