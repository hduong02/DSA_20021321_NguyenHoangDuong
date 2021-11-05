package week6;

import java.util.List;

public class InsertionSortPart2 {

    public static void insertionSort2(int n, List<Integer> arr) {
        // Write your code here
        int num, j;

        for (int i = 1; i < n; i++) {
            num = arr.get(i);
            j = i - 1;

            while (j >= 0 && arr.get(j) > num) {
                arr.set(j + 1, arr.get(j));
                j--;
            }
            arr.set(j + 1, num);

            for (int k = 0; k < n; k++)
                System.out.print(arr.get(k) + " ");
            System.out.print("\n");
        }
    }
}
