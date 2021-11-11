package week8;

import java.util.List;
import java.util.PriorityQueue;

public class Cookies {
    public static int cookies(int k, List<Integer> A) {
        // Write your code here
        int count = 0;
        PriorityQueue<Integer> sweetness = new PriorityQueue<Integer>(A.size());
        for (int a : A) {
            sweetness.add(a);
        }
        while (sweetness.peek() < k && sweetness.size() > 1){
            int ne = sweetness.poll() + 2 * sweetness.poll();
            sweetness.add(ne);
            count++;
        }
        if (sweetness.peek() >= k) {
            return count;
        } else {
            return -1;
        }
    }
}
