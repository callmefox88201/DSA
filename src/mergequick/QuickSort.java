package mergequick;

public class QuickSort {
    private int partition(Comparable[] a, int u, int v) {
        int i = u, j = v + 1;
        while (true) {
            while (lessThan(a[++i], a[u]))
                if (i == v)
                    break;
            while (lessThan(a[u], a[--j]))
                if (j == u)
                    break;
            if (i >= j)
                break;
            swap(a, i, j);
        }
        swap(a, u, j);
        return j;
    }

    boolean lessThan(Comparable x, Comparable y) {
        return x.compareTo(y) < 0;
    }

    private void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private void sort(Comparable[] a, int u, int v) {
        if (v <= u)
            return;
        int j = partition(a, u, v);
        sort(a, u, j - 1);
        sort(a, j + 1, v);
    }

    public void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }
}