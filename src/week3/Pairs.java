package week3;

import java.util.*;

public class Pairs {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int count=0;
        int arr[]=new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = in.nextInt();
        Arrays.sort(arr);

        int i = 0, j = 1;
        while(j < n) {
            int diff = arr[j] - arr[i];
            if (diff == k) {
                count++;
                j++;
            } else if (diff > k) {
                i++;
            } else  {
                j++;
            }
        }
        System.out.println(count);
    }
}