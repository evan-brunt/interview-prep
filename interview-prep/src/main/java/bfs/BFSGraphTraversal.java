package bfs;

import common.GraphNode;

import java.util.*;

public class BFSGraphTraversal {
    public List<Integer> bfsGraphNodes(GraphNode<Integer> start) {
        if (start == null) return new ArrayList<>();

        List<Integer> orderVisited = new ArrayList<>();
        Set<GraphNode<Integer>> nodesVisited = new HashSet<>();
        Queue<GraphNode<Integer>> nodesToVisit = new ArrayDeque<>();
        nodesToVisit.add(start);

        while(!nodesToVisit.isEmpty()) {
            GraphNode<Integer> currentNode = nodesToVisit.poll();
            visitCurrentNode(currentNode, orderVisited, nodesVisited);
            addNeighborNodesToQueue(currentNode, nodesToVisit, nodesVisited);
        }
        return orderVisited;
    }

    private void addNeighborNodesToQueue(GraphNode<Integer> currentNode, Queue<GraphNode<Integer>> nodesToVisit, Set<GraphNode<Integer>> nodesVisited) {
        for(var node : currentNode.getAdjacencyList()) {
            if (node != null && !nodesVisited.contains(node)) {
                nodesToVisit.add(node);
            }
        }
    }

    private void visitCurrentNode(GraphNode<Integer> currentNode,
                                  List<Integer> orderVisited,
                                  Set<GraphNode<Integer>> nodesVisited) {
        orderVisited.add(currentNode.getDatum());
        nodesVisited.add(currentNode);
    }
}
