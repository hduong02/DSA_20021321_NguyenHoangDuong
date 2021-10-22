package week6;

import java.util.List;

public class InsertionSortPart1 {

    public static void insertionSort1(int n, List<Integer> arr) {
        // Write your code here
        int num, j;
        // Loop through the array
        for (int i = 1; i < n; i++) {
            num = arr.get(i);
            j = i - 1;
            // Perform shifting of elements
            while (j >= 0 && arr.get(j) > num) {
                arr.set(j + 1, arr.get(j));
                --j;
                // Print the array at every step
                for (int k = 0; k < n; k++)
                    System.out.print(arr.get(k) + " ");
                System.out.print("\n");
            }
            arr.set(j + 1, num);
        }
        // Print the final sorted array
        for (int k = 0; k < n; k++)
            System.out.print(arr.get(k) + " ");
    }
}
