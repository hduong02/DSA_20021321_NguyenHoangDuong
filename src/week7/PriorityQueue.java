package week7;

public class PriorityQueue {

    private int k;
    private int q = 0;
    int[] arr = new int[k];
    public void insert(int n) {
        arr[q] = n;
        q++;
    }

    int deleteMin() {
        int min = 0;
        for (int i = 0; i < q; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        for (int i = min; i < q - 1; i++) {
            arr[i] = arr[i + 1];
        }

        return min;
    }
}
