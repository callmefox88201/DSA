package graph;

// undirect, unweighted graph data structure
public interface Graph {
    int size(); // number of edges

    int order(); // number of vertices

    int degree(int u); // degree of a node/vertex u

    Iterable<Integer> adjacency(int u); // get a collection of vertices which are adjacent to u

    void addEdge(int u, int v);
}