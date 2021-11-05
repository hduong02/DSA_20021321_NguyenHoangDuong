package week6;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class QuickSort {

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(int[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
        assert isSorted(a);
    }

    // quicksort the subarray a[lo .. hi] using 3-way partitioning
    private static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo, gt = hi;
        int v = a[lo];
        int i = lo + 1;
        while (i <= gt) {
            boolean cmp = a[i] < v;
            if      (cmp) exch(a, lt++, i++);
            else if (!cmp) exch(a, i, gt--);
            else              i++;
        }

        // a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi].
        sort(a, lo, lt-1);
        sort(a, gt+1, hi);
        assert isSorted(a, lo, hi);
    }



    /***************************************************************************
     *  Helper sorting functions.
     ***************************************************************************/

    // is v < w ?
    private static boolean less(int v, int w) {
        return v < w;
    }

    // exchange a[i] and a[j]
    private static void exch(int a[], int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


    /***************************************************************************
     *  Check if array is sorted - useful for debugging.
     ***************************************************************************/
    private static boolean isSorted(int[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(int[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }



    // print array to standard output
    private static void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    /**
     * Reads in a sequence of strings from standard input; 3-way
     * quicksorts them; and prints them to standard output in ascending order.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        int[] a = new int[10000];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        long start = System.currentTimeMillis();
        QuickSort.sort(a);
        long end = System.currentTimeMillis();
        long time = end - start;
        StdOut.println("Sorting takes " + time +" milliseconds");
    }
}
