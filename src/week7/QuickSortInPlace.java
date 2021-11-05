package week7;

import java.util.ArrayList;
import java.util.Scanner;

public class QuickSortInPlace {

    static void quickSort(ArrayList<Integer> array, int low, int high){

        if(low < high){
            int p = partition(array,low,high);
            print(array);
            quickSort(array,low,p-1);
            quickSort(array,p+1,high);
        }
    }

    static int partition(ArrayList<Integer> array, int low, int high){

        int pivot = array.get(high);
        int i = low;
        for(int j = low; j < high; j++){
            if(array.get(j) < pivot){
                array = swap(array,i,j);
                i++;
            }
        }
        array = swap(array,i,high);

        return i;
    }

    static ArrayList<Integer> swap(ArrayList<Integer> array, int i, int j){
        int n1 = array.get(i);
        int n2 = array.get(j);
        array.set(i,n2);
        array.set(j,n1);
        return array;
    }

    static void print(ArrayList<Integer> array){
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList <Integer> array = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            array.add(sc.nextInt());
        }
        quickSort(array, 0, n-1);
    }
}