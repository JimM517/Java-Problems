package CodeWars.Betas;

import java.util.ArrayDeque;
import java.util.Deque;

public class CodeWarsBetas {



    // the greatest number since
    public class TheGreatestSince {
        private static class Entry {
            String id;
            int value;
            Entry(String id, int value) {
                this.id = id;
                this.value = value;
            }
        }

        private final Deque<Entry> stack = new ArrayDeque<>();

        public String theGreatestSince(String id, int value) {
            // Pop all elements <= current value
            while (!stack.isEmpty() && stack.peek().value <= value) {
                stack.pop();
            }

            String result;
            if (stack.isEmpty()) {
                result = id; // no greater before → itself
            } else {
                result = stack.peek().id; // top has the nearest greater
            }

            // Push current entry
            stack.push(new Entry(id, value));
            return result;
        }
    }















































}
