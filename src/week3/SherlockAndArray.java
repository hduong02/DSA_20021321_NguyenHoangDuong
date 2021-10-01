package week3;

import java.util.*;

public class SherlockAndArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        for (int i = 0; i < k; i++) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = in.nextInt();
            }
            System.out.println(balancedSums(arr));
        }
    }

    public static String balancedSums(int[] arr){
        int sum = 0;
        int x = 0;

        for (int i=0; i < arr.length; i++){
            sum += arr[i];
        }
        for (int j = 0; j < arr.length; j++){
            if (x == (sum - arr[j]) / 2) {
                return "YES";
            }
            x += arr[j];
        }
        return "NO";
    }
}