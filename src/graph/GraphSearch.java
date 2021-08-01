package graph;

import java.util.LinkedList;
import java.util.Stack;

public class GraphSearch {

    private GraphIO graphIO;
    private Graph graph;

    public GraphSearch(String fileName) {
        this.graphIO = new GraphIO();
        this.graph = graphIO.loadFromFile(fileName);
    }

    public void dfs(int u) {

        int[] visited = new int[graph.order()];
        for (int i = 0; i < visited.length; i++)
            visited[i] = 0;

        visited[u] = 1;

        Stack<Integer> stack = new Stack<>();
        stack.push(u);

        System.out.print(u + "(" + graphIO.getIdxToLabel().get(u) + ")=>");

        while (!stack.isEmpty()) {
            int v = stack.peek();
            boolean back = true;

            for (Integer j : graph.adjacency(v)) {
                if (visited[j] == 0) {
                    System.out.print(j + "(" + graphIO.getIdxToLabel().get(j) + ")=>");
                    stack.push(j);
                    visited[j] = 1;
                    back = false;
                    break;
                }
            }
            if (back)
                stack.pop();
        }
        System.out.println();
    }

    public void bfs(int u) {

        int[] visited = new int[graph.order()];
        for (int i = 0; i < visited.length; i++)
            visited[i] = 0;

        visited[u] = 1;

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(u);
        System.out.print(u + "(" + graphIO.getIdxToLabel().get(u) + ")=>");
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (Integer j : graph.adjacency(v)) {
                if (visited[j] == 0) {
                    System.out.print(j + "(" + graphIO.getIdxToLabel().get(j) + ")=>");
                    queue.add(j);
                    visited[j] = 1;
                }
            }
        }

        System.out.println();

    }

    public int[] getShortestPath(int u, int v) {

        int[] visited = new int[graph.order()];
        int[] trace = new int[graph.order()];

        for (int i = 0; i < visited.length; i++) {
            visited[i] = 0;
            trace[i] = -1;
        }

        visited[u] = 1;

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(u);
        while (!queue.isEmpty() && visited[v] == 0) {
            int t = queue.poll();
            for (Integer j : graph.adjacency(t)) {
                if (visited[j] == 0) {
                    queue.add(j);
                    visited[j] = 1;
                    trace[j] = t;
                }
            }
        }

        if (visited[v] == 1) {
            int count = 0;
            int t = trace[v];
            while (t != -1) {
                count++;
                t = trace[t];
            }

            int[] path = new int[count + 1];
            path[count] = v;

            t = trace[v];
            while (t != -1) {
                count--;
                path[count] = t;
                t = trace[t];
            }

            return path;

        } else
            return new int[0];
    }

    public int dist(int u, int v) {
        return getShortestPath(u, v).length - 1;
    }

    public boolean isConnected(int u, int v) {

        int[] visited = new int[graph.order()];
        for (int i = 0; i < visited.length; i++)
            visited[i] = 0;

        visited[u] = 1;

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(u);

        while (!queue.isEmpty()) {
            int t = queue.poll();
            for (Integer j : graph.adjacency(t)) {
                if (visited[j] == 0) {
                    queue.add(j);
                    visited[j] = 1;
                }
            }
        }

        return visited[v] == 1;
    }

    public int[] getConnectedComponent() {

        int count = 0;
        int[] visited = new int[graph.order()];
        for (int i = 0; i < visited.length; i++)
            visited[i] = 0;

        int start = getCandidate(visited);

        while (start != -1) {
            count++;
            visited[start] = count;

            LinkedList<Integer> queue = new LinkedList<>();

            queue.add(start);

            while (!queue.isEmpty()) {
                int v = queue.poll();

                for (Integer j : graph.adjacency(v)) {
                    if (visited[j] == 0) {
                        visited[j] = count;
                        queue.add(j);
                    }
                }
            }

            start = getCandidate(visited);

        }

        return visited;

    }

    private int getCandidate(int[] visited) {

        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0)
                return i;
        }

        return -1;
    }

    public void printLabelMap() {

        for (int i = 0; i < graph.order(); i++)
            System.out.print(i + " -> [" + graphIO.getIdxToLabel().get(i) + "]; ");

        System.out.println();
    }

    public GraphIO getGraphIO() {
        return graphIO;
    }

    public Graph getGraph() {
        return graph;
    }

    public static void main(String[] args) {

        GraphSearch gs = new GraphSearch("src/adjmatrix.txt");

        gs.printLabelMap();

        Graph graph = gs.getGraph();

        System.out.println("size of the graph = " + graph.size());
        System.out.println("order of the graph = " + graph.order());
        System.out.println("adjacency of 0: " + graph.adjacency(0));
        System.out.println("adjacency of 4: " + graph.adjacency(4));
        System.out.println("adjacency of 2: " + graph.adjacency(2));

        System.out.println("degree of 1: " + graph.degree(1));
        System.out.println("degree of 2: " + graph.degree(2));
        System.out.println("Depth-First Search");
        gs.dfs(0);
        System.out.println("Breadth-First Search");
        gs.bfs(0);
        System.out.println("Shortest path from 0 to 4:");
        int[] path = gs.getShortestPath(0, 4);
        for (int i = 0; i < path.length; i++)
            System.out.print(path[i] + "; ");
        System.out.println();

        System.out.println("Does 0 have a connection to 3?");
        System.out.println(gs.isConnected(0, 3));

        System.out.println("Connected component:");

        int[] cp = gs.getConnectedComponent();

        for (int i = 0; i < cp.length; i++)
            System.out.print(i + "[" + cp[i] + "]; ");
        System.out.println();

    }

}