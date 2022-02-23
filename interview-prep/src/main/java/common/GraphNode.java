package common;

import java.util.ArrayList;
import java.util.List;

public class GraphNode<T extends Number> {
    private final T datum;
    private final List<GraphNode<T>> adjacencyList;

    public GraphNode(T datum) {
        this.datum = datum;
        adjacencyList = new ArrayList<>();
    }

    public T getDatum() {
        return datum;
    }

    public List<GraphNode<T>> getAdjacencyList() {
        return adjacencyList;
    }

    public boolean addNodeToAdjacencyList(GraphNode<T> node) {
        return adjacencyList.add(node);
    }
}
