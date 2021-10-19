package week5;

import java.util.*;

public class QueueUsing2Stacks {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        for (int i=0; i < n; i++) {
            int k = sc.nextInt();
            if (k == 1) {
                int x = sc.nextInt();
                stack1.push(x);
            }
            else {
                if (stack2.isEmpty()) {
                    while (!stack1.isEmpty()) {
                        stack2.push(stack1.pop());
                    }
                }
                if (k == 2)
                    stack2.pop();
                else if (k == 3) {
                    System.out.println(stack2.peek());
                }
            }
        }
    }
}
