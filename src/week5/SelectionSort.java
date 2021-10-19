package week5;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Scanner;

public class SelectionSort {

    private static void swap(double a[], int i, int j)
    {
        double temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void sort(double a[])
    {
        int N = a.length;
        for (int i = 0; i < N; i++)
        {
            int min = i;
            for (int j = i+1; j < N; j++)
                if (a[j] < a[min])
                    min = j;
            swap(a, i, min);
        }
    }

    public static void main(String[] args)
    {
        long start = System.currentTimeMillis();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double[] a = new double[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform();
        sort(a);
        for (int i = 0; i < N; i++)
            StdOut.println(a[i]);
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("thoi gian chay = " + time);
    }
}
