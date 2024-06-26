package LeetCodeOneFifty.Stacks;

import java.util.Stack;

public class StackProbs {

    /*** Stack problems from leet code 150 ***/


    // 20. Valid parentheses
    public boolean isValid(String s) {

        Stack<Character> paren = new Stack<>();

        for (char c : s.toCharArray()) {

            if (c == '(' || c == '{' || c == '[') {
                paren.push(c);
            } else if (c == ')' || c == '}' || c == ']') {

                if (paren.isEmpty()) {
                    return false;
                }


                char top = paren.pop();

                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return false;
                }


            }
        }

        return paren.isEmpty() ? true : false;

    }





    // 71. Simplify path
    public String simplifyPath(String path) {

        Stack<String> result = new Stack<>();

        StringBuilder sb = new StringBuilder();


        String[] str = path.split("/");


        for (int i = 0; i < str.length; i++) {

            if (!result.isEmpty() && str[i].equals("..")) {
                result.pop();
            } else if (!str[i].equals("") && !str[i].equals(".") && !str[i].equals("..")) {
                result.push(str[i]);
            }

        }

        if (result.isEmpty()) {
            return "/";
        }

        while (!result.isEmpty()) {
            sb.insert(0, result.pop()).insert(0, "/");
        }

        return sb.toString();

    }



    // 678. valid parenthesis string
    public boolean checkValidString(String s) {


        Stack<Integer> brackets = new Stack<>();

        Stack<Integer> star = new Stack<>();

        char[] strs = s.toCharArray();

        for (int i = 0; i < strs.length; i++) {

            char ch = strs[i];

            if (ch == '(') {
                brackets.push(i);
            } else if (ch == '*') {
                star.push(i);
            } else if (!brackets.isEmpty()) {
                brackets.pop();
            } else if (!star.isEmpty()) {
                star.pop();
            } else {
                return false;
            }
        }


        while (!brackets.isEmpty() && !star.isEmpty() && brackets.peek() < star.peek()) {
            brackets.pop();
            star.pop();
        }

        return brackets.isEmpty();

    }






}
