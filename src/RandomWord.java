import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main(String[] args){
        String s1= StdIn.readString();
        double i= 1;
        while(!StdIn.isEmpty()){
            i++;
            String s2= StdIn.readString();
            if(StdRandom.bernoulli(1/i)){
                s1= s2;
            }
        }
        StdOut.println(s1);
    }
}