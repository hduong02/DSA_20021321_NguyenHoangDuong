package week3;

import java.util.*;

public class ClosestNumbers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        int minDiff = 2147483647;
        String pairs = "";
        for (int i = 0; i < n - 1; i++) {
            if (arr[i + 1] - arr[i] <= minDiff) {
                if (arr[i + 1] - arr[i] == minDiff) {
                    pairs += " " + arr[i] + " " + arr[i + 1];
                } else {
                    pairs = arr[i] + " " + arr[i + 1];
                }
                minDiff = arr[i + 1] - arr[i];
            }
        }
        System.out.println(pairs);
    }
}