package week5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class EqualStacks {
    static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {

        Stack<Integer> st1 = new Stack<Integer>();
        Stack<Integer> st2 = new Stack<Integer>();
        Stack<Integer> st3 = new Stack<Integer>();

        int st1TotalHeight = 0, st2TotalHeight = 0, st3TotalHeight = 0;

        // pushing consolidated height into the stack instead of individual cylinder
        // height
        for (int i = h1.size() - 1; i >= 0; i--) {
            st1TotalHeight += h1.get(i);
            st1.push(st1TotalHeight);
        }
        for (int i = h2.size() - 1; i >= 0; i--) {
            st2TotalHeight += h2.get(i);
            st2.push(st2TotalHeight);
        }
        for (int i = h3.size() - 1; i >= 0; i--) {
            st3TotalHeight += h3.get(i);
            st3.push(st3TotalHeight);
        }

        while (true) {

            // If any stack is empty
            if (st1.isEmpty() || st2.isEmpty() || st3.isEmpty())
                return 0;

            st1TotalHeight = st1.peek();
            st2TotalHeight = st2.peek();
            st3TotalHeight = st3.peek();

            // If sum of all three stack are equal.
            if (st1TotalHeight == st2TotalHeight && st2TotalHeight == st3TotalHeight)
                return st1TotalHeight;

            // Finding the stack with maximum sum and
            // removing its top element.
            if (st1TotalHeight >= st2TotalHeight && st1TotalHeight >= st3TotalHeight)
                st1.pop();
            else if (st2TotalHeight >= st1TotalHeight && st2TotalHeight >= st3TotalHeight)
                st2.pop();
            else if (st3TotalHeight >= st2TotalHeight && st3TotalHeight >= st1TotalHeight)
                st3.pop();
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        List<Integer> h1 = new ArrayList<>(n1);
        for (int h1_i = 0; h1_i < n1; h1_i++) {
            h1.set(h1_i, in.nextInt());
        }
        List<Integer> h2 = new ArrayList<>(n2);
        for (int h2_i = 0; h2_i < n2; h2_i++) {
            h2.set(h2_i, in.nextInt());
        }
        List<Integer> h3 = new ArrayList<>(n3);
        for (int h3_i = 0; h3_i < n3; h3_i++) {
            h3.set(h3_i, in.nextInt());
        }
        System.out.println(equalStacks(h1, h2, h3));
        in.close();
    }
}
