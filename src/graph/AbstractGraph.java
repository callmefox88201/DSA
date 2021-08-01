package graph;

public abstract class AbstractGraph implements Graph {
    protected int n;

    protected AbstractGraph(int n) {
        this.n = n;
    }
}