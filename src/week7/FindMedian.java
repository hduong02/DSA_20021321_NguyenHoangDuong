package week7;

import java.util.ArrayList;
import java.util.List;

public class FindMedian {

    static void quickSort(List<Integer> array, int low, int high){

        if(low < high){
            int p = partition(array,low,high);
            quickSort(array,low,p-1);
            quickSort(array,p+1,high);
        }
    }

    static int partition(List<Integer> array, int low, int high){

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

    static List<Integer> swap(List<Integer> array, int i, int j){
        int n1 = array.get(i);
        int n2 = array.get(j);
        array.set(i,n2);
        array.set(j,n1);
        return array;
    }
    public static int findMedian(List<Integer> arr) {
        // Write your code here
        quickSort(arr,0, arr.size() - 1 );
        if (arr.size() % 2 == 0) {
            return arr.get(arr.size() / 2 - 1);
        } else {
            return arr.get(arr.size() / 2);
        }
    }
}
