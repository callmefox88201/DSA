package simplesort;

public class SelectionSort {
    void selectionSort(int a[], int n) {
        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++)
                if (a[i] > a[j])
                    swap(a, i, j);
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {5, 1, 4, 2, 8};
        new SelectionSort().selectionSort(a, a.length);
        for (int i : a)
            System.out.print(i + " ");
    }
}
