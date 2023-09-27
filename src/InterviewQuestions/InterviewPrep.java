package InterviewQuestions;

public class InterviewPrep {

    // 151 Reverse Words in a string
    public String reverseWords(String s) {
//        StringBuilder sb = new StringBuilder();
//
//        String[] strings = s.split(" ");
//        for (int i = strings.length - 1; i >= 0; i--) {
//            sb.append(strings[i]);
//        }
//        return sb.toString();

        // trying another solution to remove white space
        s = s.trim().replaceAll("\\s+", " ");

        String[] strings = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = strings.length - 1; i >= 0; i--) {
            sb.append(strings[i]);
            if (i > 0) {
                sb.append(" ");
            }
        }

        return sb.toString();

    }







}
