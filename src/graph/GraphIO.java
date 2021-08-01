package graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class GraphIO {
    private Map<String, Integer> labelToIdx;
    private Map<Integer, String> idxToLabel;

    public GraphIO() {
        this.labelToIdx = new HashMap<>();
        this.idxToLabel = new HashMap<>();
    }

    public void addVertex(String u) {
        if (!labelToIdx.containsKey(u)) {
            int idx = labelToIdx.size();
            labelToIdx.put(u, idx);
            idxToLabel.put(idx, u);
        }
    }

    public Graph loadFromFile(String filename) {
        FileInputStream fis;
        try {
            fis = new FileInputStream(filename);
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(isr);

            String line = "";

            String graphType = reader.readLine();

            if (graphType.equals("AdjacencyListGraph")) {

                int n = Integer.parseInt(reader.readLine());
                Graph graph = new AdjacencyListsGraph(n);

                while ((line = reader.readLine()) != null) {
                    String[] tokens = line.trim().split("\s+");
                    if (tokens.length > 0) {
                        String u = tokens[0];
                        addVertex(u);
                        int uIdx = labelToIdx.get(u);

                        for (int i = 1; i < tokens.length; i++) {
                            addVertex(tokens[i]);
                            int vIdx = labelToIdx.get(tokens[i]);
                            graph.addEdge(uIdx, vIdx);
                        }

                    }
                }
                reader.close();

                return graph;

            }

            if (graphType.equals("AdjacencyMatrixGraph")) {

                int n = Integer.parseInt(reader.readLine());
                Graph graph = new AdjacencyMatrixGraph(n);
                String[] labels = reader.readLine().split("\s+");
                for (String label : labels) {
                    addVertex(label);
                }
                int i = 0;
                while ((line = reader.readLine()) != null) {
                    String[] tokens = line.trim().split("\s+");
                    if (tokens.length == n) {
                        for (int j = 0; j < n; j++) {
                            int value = Integer.parseInt(tokens[j]);
                            if (value > 0) {
                                graph.addEdge(i, j);
                            }
                        }
                        i++;
                    }
                }
                reader.close();
                return graph;

            }

            if (graphType.equals("EdgeListGraph")) {

                int n = Integer.parseInt(reader.readLine());
                Graph graph = new EdgeListGraph(n);

                while ((line = reader.readLine()) != null) {
                    String[] tokens = line.trim().split("\s+");
                    if (tokens.length == 2) {
                        String u = tokens[0];
                        String v = tokens[1];
                        addVertex(u);
                        addVertex(v);
                        graph.addEdge(labelToIdx.get(u), labelToIdx.get(v));
                    }
                }
                reader.close();
                return graph;

            }

            reader.close();

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
        return null;
    }

    public Map<String, Integer> getLabelToIdx() {
        return labelToIdx;
    }

    public Map<Integer, String> getIdxToLabel() {
        return idxToLabel;
    }

}