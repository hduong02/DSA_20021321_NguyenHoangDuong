package week3;

import java.util.Scanner;

public class BinarySearch {

    public static int binarySearch(int[] a, int number) {
        int left = 0;
        int right = a.length - 1;
        while (left < right) {
            int mid = left + ((right - left) / 2);
            if (a[mid] == number) {
                return mid + 1;
            }
            else if (number < a [mid]) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }

        int number = 712;
        System.out.println(binarySearch(arr, number));
    }
}
//abcdxyz