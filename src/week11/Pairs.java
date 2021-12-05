package week11;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Pairs {

    static int pairs(int[] arr, int k) {

        int count = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(arr.length);

        for (int value : arr) {
            if (map.containsKey(value)) {
                map.put(value, map.get(value) + 1);
            } else {
                map.put(value, 1);
            }
        }

        for (int value : arr) {
            int target = value + k;
            if (map.containsKey(target)) {
                count += map.get(target);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(pairs(arr, k));
    }
}