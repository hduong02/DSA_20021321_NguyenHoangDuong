package week7;

import java.util.ArrayList;
import java.util.List;


public class CountingSort1 {
    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        List<Integer> count = new ArrayList<Integer>(arr.size());
        for (int i = 0; i < arr.size(); i++) {
            count.add(0);
        }
        for (int num : arr) {
            count.set(num, count.get(num) + 1);
        }

        return count;
    }
}
