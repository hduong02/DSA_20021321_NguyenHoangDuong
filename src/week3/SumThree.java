package week3;

import java.util.Arrays;

public class SumThree {

    public static void threeSum(int arr[], int n)
    {
        boolean found = false;
        
        Arrays.sort(arr);

        for (int i=0; i<n-1; i++)
        {
            int left = i + 1;
            int right = n - 1;
            int x = arr[i];
            while (left < right)
            {
                if (x + arr[left] + arr[right] == 0)
                {
                    System.out.print(x + " ");
                    System.out.print(arr[left] + " ");
                    System.out.println(arr[right] + " ");
                    left++;
                    right--;
                    found = true;
                }
                else if (x + arr[left] + arr[right] < 0)
                    left++;
                else
                    right--;
            }
        }
        if (!found)
            System.out.println("Not found");
    }
    public static void main (String[] args) {

        int arr[] = {0, 7, 1, 2, 20, 5};
        int n = arr.length;
        threeSum(arr, n);
    }
}
