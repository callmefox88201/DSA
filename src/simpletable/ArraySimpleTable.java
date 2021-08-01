package simpletable;

import java.util.ArrayList;
import java.util.List;

public class ArraySimpleTable<Key extends Comparable<Key>, Value> extends AbstractSimpleTable<Key, Value> {

    private Key[] keys;
    private Value[] vals;
    private int n;

    public ArraySimpleTable() {
        n = 0;
        keys = (Key[]) new Comparable[100];
        vals = (Value[]) new Comparable[100];
    }

    private int rank(Key key) {
        int u = 0;
        int v = n - 1;
        while (u <= v) {
            int m = u + (v - u) / 2;
            int c = key.compareTo(keys[m]);
            if (c < 0) {
                v = m - 1;
            } else if (c > 0) {
                u = m + 1;
            } else {
                return m;
            }
        }
        return u;
    }

    @Override
    public void put(Key key, Value value) {
        // TODO Auto-generated method stub
        int r = rank(key);
        if (get(key) != null) {
            vals[r] = value;
        } else {
            n++;
            for (int j = n - 1; j > r; j--) {
                keys[j] = keys[j - 1];
                vals[j] = vals[j - 1];
            }
            keys[r] = key;
            vals[r] = value;
        }
    }

    @Override
    public Value get(Key key) {
        // TODO Auto-generated method stub
        if (isEmpty())
            return null;
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0)
            return vals[i];
        return null;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        int count = 0;
        for (int i = 0; i < n; i++)
            if (vals[i] != null)
                count++;
        return count;
    }

    @Override
    public Iterable<Key> keys() {
        // TODO Auto-generated method stub
        List<Key> list = new ArrayList<Key>();
        for (int i = 0; i < n; i++)
            if (vals[i] != null)
                list.add(keys[i]);
        return list;
    }

}
