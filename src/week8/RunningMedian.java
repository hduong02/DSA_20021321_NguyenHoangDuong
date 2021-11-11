package week8;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RunningMedian {

    public static List<Double> runningMedian(List<Integer> a) {
        // Write your code here
        PriorityQueue<Double> minHeap = new PriorityQueue<>();
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        List<Double> result = null;

        for (double v : a) {
            if (maxHeap.isEmpty() || (v < maxHeap.peek())) {
                maxHeap.offer(v);
            } else {
                minHeap.offer(v);
            }

            if (maxHeap.size() > (minHeap.size() + 1)) {
                minHeap.offer(maxHeap.poll());
            }

            if (minHeap.size() > (maxHeap.size() + 1)) {
                maxHeap.offer(minHeap.poll());
            }

            if (maxHeap.size() > minHeap.size()) {
                result.add(maxHeap.peek());
            } else if (minHeap.size() > maxHeap.size()) {
                result.add(minHeap.peek());
            } else {
                result.add(0.5 * (minHeap.peek() + maxHeap.peek()));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> a = null;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n ; i++) {
            a.add(sc.nextInt());
        }
        List<Double> result = runningMedian(a);
        for (double v : result) {
            System.out.println(v);
        }
    }
}
