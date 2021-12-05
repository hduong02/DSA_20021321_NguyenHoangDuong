package week11;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class RunningMedian {

    public static double runningMedian(TreeSet<Double> ts) {
        ArrayList<Double> arr = new ArrayList<>(ts);
        int n = arr.size();
        if (n == 1) {
            return arr.get(0);
        }
        else if (n % 2 != 0)
            return arr.get(n / 2);
        else {
            return (arr.get(n / 2) + arr.get((n / 2) - 1)) / 2;
        }
    }


    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        double n = sc.nextDouble();
        TreeSet<Double> ts = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            double x = sc.nextDouble();
            ts.add(x);
            System.out.println(runningMedian(ts));
        }
    }
}
