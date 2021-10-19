package week5;

import java.util.*;
import static java.lang.Math.abs;

public class BalanceBracket {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
        // Write your code here
        Stack<Character> brackets = new Stack<Character>();
        for (Character c : s.toCharArray()) {
            if (c == '[' || c == '{' || c == '(')
                brackets.push(c);
            else {
                if (brackets.empty() || abs(brackets.peek() - c) > 2) return "NO";
                else brackets.pop();
            }
        }
        if (brackets.empty()) return "YES";
        return "NO";
    }
}
