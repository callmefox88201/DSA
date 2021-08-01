package graph;

import java.util.LinkedList;
import java.util.List;

public class EdgeListGraph extends AbstractGraph {

    class Edge {
        int u;
        int v;

        Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    private List<Edge> edges;

    // (0, 1) -> (0, 2) -> (0, 3) -> (0, 4) -> (1, 2) -> ... -> null
    // (4, 0) -> (1, 0) -> ... -> null

    public EdgeListGraph(int n) {
        super(n);
        edges = new LinkedList<>();
    }

    @Override
    public int size() {
        return edges.size();
    }

    @Override
    public int order() {
        return n;
    }

    @Override
    public int degree(int u) {
        int c = 0;
        for (Edge edge : edges)
            if (edge.u == u || edge.v == u)
                c++;
        return c;
    }

    @Override
    public Iterable<Integer> adjacency(int u) {
        List<Integer> list = new LinkedList<>();
        for (Edge edge : edges)
            if (edge.u == u)
                list.add(edge.v);
            else if (edge.v == u)
                list.add(edge.u);
        return list;
    }

    @Override
    public void addEdge(int u, int v) {
        for (Edge edge : edges)
            if ((edge.u == u && edge.v == v) || (edge.v == u && edge.u == v))
                return;
        edges.add(new Edge(u, v));
    }

}