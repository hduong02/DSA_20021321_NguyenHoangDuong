package week2;

import edu.princeton.cs.algs4.*;
public class sum2 {
    public static void main(String[] args) {
        In in = new In("E:\\DSA\\algs4-data\\4Kints.txt");
        int[] a = in.readAllInts();
        // xử lý dữ liệu trong mảng a
        for (int i=0; i< a.length; i++){
            for (int j=i+1; j< a.length-i; j++){
                if(a[i]+a[j]==0){
                    System.out.println(a[i]+" "+ a[j]);
                }
            }
        }
    }
}
