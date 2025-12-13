package CodeWars.TwoKyu;

public class TwoKyu {


// evaluate mathematical expression
    public class MathEvaluator {

        private String s;
        private int index;

        public double calculate(String expression) {
            this.s = expression;
            this.index = 0;
            return parseExpression();
        }

        private double parseExpression() {
            double value = parseTerm();

            while (true) {
                skipWhitespace();

                if (match('+')) {
                    value += parseTerm();
                } else if (match('-')) {
                    value -= parseTerm();
                } else {
                    break;
                }
            }
            return value;
        }

        private double parseTerm() {
            double value = parseFactor();

            while (true) {
                skipWhitespace();

                if (match('*')) {
                    value *= parseFactor();
                } else if (match('/')) {
                    value /= parseFactor();
                } else {
                    break;
                }
            }
            return value;
        }

            private double parseFactor() {
                skipWhitespace();

                if (match('-')) {
                    return -parseFactor(); // unary minus
                }

                if (match('(')) {
                    double value = parseExpression();
                    match(')');
                    return value;
                }

                return parseNumber();
            }

            private double parseNumber() {
                skipWhitespace();
                int start = index;

                while (index < s.length() &&
                        (Character.isDigit(s.charAt(index)) || s.charAt(index) == '.')) {
                    index++;
                }

                return Double.parseDouble(s.substring(start, index));
            }

            private boolean match(char c) {
                skipWhitespace();
                if (index < s.length() && s.charAt(index) == c) {
                    index++;
                    return true;
                }
                return false;
            }

            private void skipWhitespace() {
                while (index < s.length() && s.charAt(index) == ' ') {
                    index++;
                }
            }



}



































}
