package mergequick;

public class MergeSort {
    void merge(Comparable[] a, Comparable[] b, int u, int m, int v) {
        for (int k = u; k <= v; k++)
            b[k] = a[k];
        // merge
        int i = u;
        int j = m + 1;
        for (int k = u; k <= v; k++) {
            if (i > m)
                a[k] = b[j++];
            else if (j > v)
                a[k] = b[i++];
            else if (lessThan(b[j], b[i]))
                a[k] = b[j++];
            else
                a[k] = b[i++];
        }
    }

    boolean lessThan(Comparable x, Comparable y) {
        return x.compareTo(y) < 0;
    }

    void sort(Comparable[] a, Comparable[] b, int u, int v) {
        if (v <= u)
            return;
        int m = u + (v - u) / 2;
        sort(a, b, u, m);
        sort(a, b, m + 1, v);
        merge(a, b, u, m, v);
    }

    public void sort(Comparable[] a) {
        Comparable[] b = new Comparable[a.length];
        sort(a, b, 0, a.length - 1);
    }

    public static void main(String[] args) {
        String s = "MERGESORTEXAMPLE";
        Character[] a = new Character[s.length()];
        for (int i = 0; i < a.length; i++)
            a[i] = s.charAt(i);
        new MergeSort().sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }
}
