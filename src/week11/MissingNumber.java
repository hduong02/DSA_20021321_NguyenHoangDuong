package week11;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;

public class MissingNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[]= new int[n];
        Integer temp;
        Hashtable<Integer,Integer> ht = new Hashtable<>();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            temp = ht.putIfAbsent(arr[i], 1);
            if (temp != null) {
                ht.put(arr[i], ht.get(arr[i]) + 1);
            }
        }

        int m = sc.nextInt();
        int brr[] = new int[m];
        for (int i = 0; i < m; i++) {
            brr[i] = sc.nextInt();
        }
        Arrays.sort(brr);

        for (int i = 0; i < m; i++) {
            if (ht.containsKey(brr[i]) && ht.get(brr[i]) > 0) {
                ht.put(brr[i], ht.get(brr[i]) - 1);
            } else if (!ht.containsKey(brr[i])) {
                    ht.put(brr[i], -1);
                    System.out.print(brr[i] + " ");
            }
        }
    }
}
