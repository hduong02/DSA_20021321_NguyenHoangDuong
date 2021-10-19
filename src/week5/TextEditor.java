package week5;

import java.util.Scanner;
import java.util.Stack;

public class TextEditor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
            Stack<String> stack = new Stack<String>();
            String s = "";
            stack.push(s);
            while (q-- > 0) {
                int operation = sc.nextInt();
                switch (operation) {
                    case 1:
                        String append;
                        append = sc.next();
                        s += append;
                        stack.push(s);
                        break;
                    case 2:
                        int k = sc.nextInt();
                        s = s.substring(0, s.length() - k);
                        stack.push(s);
                        break;
                    case 3:
                        int n = sc.nextInt();
                        System.out.println(s.charAt(n - 1));
                        break;
                    case 4:
                        stack.pop();
                        s = stack.peek();
                }
            }
        }
    }

