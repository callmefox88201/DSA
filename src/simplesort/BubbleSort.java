package simplesort;

public class BubbleSort {
    void bubbleSort(int[] a, int n) {
        for (int i = n - 1; i > 0; i--)
            for (int j = 1; j <= i; j++)
                if (a[j - 1] > a[j])
                    swap(a, j - 1, j);
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {5, 1, 4, 2, 8};
        new BubbleSort().bubbleSort(a, a.length);
        for (int i : a)
            System.out.print(i + " ");
    }
}
