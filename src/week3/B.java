package week3;

public class B {
    public static void main(String[] args) {
        int a = 1, b = 2;

        System.out.println(A.sum(a, b));
        System.out.println(A.sum(A.square(a), A.square(b)));
    }
}
