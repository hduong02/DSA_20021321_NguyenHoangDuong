package week2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.UF;

public class UFClient2 {
    public static void main(String args[]){
        int n= StdIn.readInt();
        int unionCount= 0;
        int pairs= 0;
        UF uf= new UF(n);
        while(!StdIn.isEmpty()) {
            pairs++;
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.find(p)!=uf.find(q)){
                uf.union(p, q);
                unionCount++;
            }
            if (unionCount==n-1){
                System.out.println(pairs);
                System.exit(0);
            }
        }
        System.out.println("FAILED");
    }
}

