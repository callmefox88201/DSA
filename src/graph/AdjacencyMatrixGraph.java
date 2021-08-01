package graph;

import java.util.LinkedList;
import java.util.List;

public class AdjacencyMatrixGraph extends AbstractGraph {

    private boolean[][] a;

    public AdjacencyMatrixGraph(int n) {
        super(n);
        this.a = new boolean[n][n];
    }

    @Override
    public int size() {
        int m = 0;
        for (int u = 0; u < n; u++)
            for (int v = 0; v < n; v++)
                if (a[u][v])
                    m++;
        return m / 2;
    }

    @Override
    public int order() {
        return n;
    }

    @Override
    public int degree(int u) {
        int d = 0;
        for (int v = 0; v < n; v++)
            if (a[u][v])
                d++;
        return d;
    }

    @Override
    public Iterable<Integer> adjacency(int u) {
        List<Integer> adj = new LinkedList<>(); // boxing: int => Integer; unboxing: Integer => int
        for (int v = 0; v < n; v++)
            if (a[u][v])
                adj.add(v);
        return adj;
    }

    @Override
    public void addEdge(int u, int v) {
        a[u][v] = true;
        a[v][u] = true;
    }

    public static void main(String[] args) {
        // Graph graph = new AdjacencyMatrixGraph(5);
        // Graph graph = new AdjacencyListsGraph(5);
        Graph graph = new EdgeListGraph(5);
        // 0 => H, 1 => D, 2 => T, 3 => H, 4 => B
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);

        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(1, 3);

        System.out.println("size of the graph = " + graph.size());
        System.out.println("adjacency of 0: " + graph.adjacency(0));
        System.out.println("adjacency of 4: " + graph.adjacency(4));
        System.out.println("adjacency of 2: " + graph.adjacency(2));

        System.out.println("degree of 1: " + graph.degree(1));
        System.out.println("degree of 2: " + graph.degree(2));
    }
}

//                  AdjacencyLists | AdjacencyMatrix | EdgeList

// addEdge(u, v) |   O(n)          |  O(1)           | O(m)
// degree(u)     |   O(1)          |  O(n)           | O(m)