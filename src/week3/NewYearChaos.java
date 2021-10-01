package week3;

import java.util.Scanner;

public class NewYearChaos {

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void bribesNum(int[] arr) {
        int count = 0;
        for (int i = arr.length - 1; i >= 0; i-- ) {
            if (arr[i] != i + 1) {
                if (((i - 1) >= 0) && arr[i - 1] == (i + 1)) {
                    count++;
                    swap(arr, i, i - 1);
                }
                else if (((i - 2) >= 0) && arr[i - 2] == (i + 1)) {
                    count += 2;
                    swap(arr, i - 2, i - 1);
                    swap(arr, i - 1, i);
                }
                else {
                    System.out.println("Too chaotic");
                    return;
                }
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++){
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = in.nextInt();
            }
            bribesNum(arr);
        }
    }
}
