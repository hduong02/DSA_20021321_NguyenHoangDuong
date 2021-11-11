package week9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClosetNumbers {

    public static List<Integer> closestNumbers(List<Integer> arr) {
        // Write your code here
        List<Integer> a = mergeSort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.size() - 1; i++) {
            min = Math.min(min, a.get(i + 1) - a.get(i));
        }
        List<Integer> pairs = new ArrayList<>();
        for (int i = 0; i < a.size() - 1; i++) {
            if (a.get(i + 1) - a.get(i) == min) {
                pairs.add(a.get(i));
                pairs.add(a.get(i + 1));
            }
        }
        return pairs;
    }

    public static List<Integer> mergeSort(List<Integer> unsortedList) {
        if (unsortedList.size() <= 1) {
            return unsortedList;
        }
        List<Integer> sortedList;

        List<Integer> left = new ArrayList<Integer>();
        List<Integer> right = new ArrayList<Integer>();
        int middle = unsortedList.size() / 2;

        for (int i = 0; i < unsortedList.size(); i++) {
            if (i < middle) {
                left.add(unsortedList.get(i));
            }
            else {
                right.add(unsortedList.get(i));
            }
        }
        left = mergeSort(left);
        right = mergeSort(right);

        sortedList = merge(left, right);
        return sortedList;
    }

    public static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> mergedList = new ArrayList<Integer>();
        while (left.size() > 0 || right.size() > 0) {
            if (left.size() > 0 && right.size() > 0) {
                if (left.get(0) < right.get(0)) {
                    mergedList.add(left.get(0));
                    left.remove(0);
                }
                else {
                    mergedList.add(right.get(0));
                    right.remove(0);
                }
            }
            else if (left.size() > 0) {
                mergedList.add(left.get(0));
                left.remove(0);
            }
            else {
                mergedList.add(right.get(0));
                right.remove(0);
            }
        }
        return mergedList;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        List<Integer> result = closestNumbers(arr);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
