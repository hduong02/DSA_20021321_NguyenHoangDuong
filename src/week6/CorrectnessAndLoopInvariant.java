package week6;

import java.util.Scanner;

public class CorrectnessAndLoopInvariant {

    public static void insertionSort(int[] A){
        int i, j, value;
        for (i = 1; i < A.length; i++)
        {
            value = A[i];
            j = i - 1;
            // Only the following line was modified ('>=' instead of the original '>')
            while (j >= 0 && value < A[j])
            {
                A[j + 1] = A[j];
                j = j - 1;
            }
            A[j + 1] = value;
        }
        printArray(A);
    }


    static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i]=in.nextInt();
        }
        insertionSort(ar);
    }
}
