package FinalExam;

import java.util.Arrays;

public class Q2_2018 {
    public boolean check(int[] a, int[] b, int n) {
        int[] arr = Arrays.copyOf(a, n * 2);
        for (int i = 0; i < n; i++)
            arr[n + i] = b[i];
        for (int i = 0; i < 2 * n; i++) {
            int index = Math.abs(arr[i]) - 1;
            if (arr[index] < 0)
                return false;
            arr[index] = -arr[index];
        }
        return true;
    }
}
