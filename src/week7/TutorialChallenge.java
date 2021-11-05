package week7;

import java.util.List;

public class TutorialChallenge {

    public static int introTutorial(int V, List<Integer> arr) {
        // Write your code here
        int start = 0, end = arr.size() - 1, mid;
        while (start <= end) {
            mid = start + (end - start) / 2;

            if (arr.get(mid) == V) {
                return mid;
            }
            if (arr.get(mid) < V) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
