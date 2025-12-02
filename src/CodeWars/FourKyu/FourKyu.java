package CodeWars.FourKyu;

public class FourKyu {


// strip comments
    /** DOESNT WORK YET **/
    public static String stripComments(String text, String[] commentSymbols) {

        String[] lines = text.split("\n");
        StringBuilder result = new StringBuilder();

        for (String line : lines) {
            String cleaned = line;

            for (String symbol : commentSymbols) {
                int index = cleaned.indexOf(symbol);
                if (index != -1) {
                    cleaned = cleaned.substring(0, index);
                }
            }

            cleaned = cleaned.stripTrailing();

            result.append(cleaned).append("\n");


        }



        return result.toString().stripTrailing();


    }



































































































































































}
