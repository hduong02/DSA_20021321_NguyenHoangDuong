package week7;

import java.util.ArrayList;
import java.util.List;

public class Quicklsort1 {

    public static List<Integer> quickSort(List<Integer> arr) {
        // Write your code here
        int pivot = arr.get(0);

        int index = arr.size() - 1;
        for (int i = arr.size() - 1; i > 0; i--) {
            if (arr.get(i) > pivot) {
                swap(arr, i, index);
                index--;
            }
        }
        swap(arr, index, 0);
        return arr;
    }
    private static void swap(List<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
