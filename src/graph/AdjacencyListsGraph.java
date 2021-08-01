package graph;

import java.util.LinkedList;
import java.util.List;

public class AdjacencyListsGraph extends AbstractGraph {

    private List<Integer>[] adj;

    public AdjacencyListsGraph(int n) {
        super(n);
        this.adj = new List[n];
        for (int u = 0; u < n; u++)
            adj[u] = new LinkedList<>();
    }

    @Override
    public int size() {
        int m = 0;
        for (int u = 0; u < n; u++)
            m += adj[u].size();
        return m / 2;
    }

    @Override
    public int order() {
        return n;
    }

    @Override
    public int degree(int u) {
        return adj[u].size();
    }

    @Override
    public Iterable<Integer> adjacency(int u) {
        return adj[u];
    }

    @Override
    public void addEdge(int u, int v) {
        // if there does not exist edge (u, v) then add (u, v)
        if (!adj[u].contains(v)) {
            adj[u].add(v);
            adj[v].add(u);
        }
    }

}