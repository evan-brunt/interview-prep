package bfs;

import common.Node;

import java.util.*;

public class BFSTreeTraversal {
    public List<Integer> breadthFirstSearch(Node<Integer> root) {
        List<Integer> orderVisited = new ArrayList<>();
        if (root == null) return orderVisited;

        Queue<Node<Integer>> nodesToVisit = new ArrayDeque<>();
        nodesToVisit.add(root);

        Set<Node<Integer>> visitedNodes = new HashSet<>();
        while(!nodesToVisit.isEmpty()) {
            Node<Integer> currentNode = nodesToVisit.poll();
            orderVisited.add(currentNode.getDatum());
            visitedNodes.add(currentNode);

            if(currentNode.getLeft() != null && !visitedNodes.contains(currentNode.getLeft())) {
                nodesToVisit.add(currentNode.getLeft());
            }
            if(currentNode.getRight() != null && !visitedNodes.contains(currentNode.getRight())) {
                nodesToVisit.add(currentNode.getRight());
            }
        }

        return orderVisited;
    }
}
