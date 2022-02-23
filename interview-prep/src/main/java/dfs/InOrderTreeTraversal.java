package dfs;

import common.Node;

import java.util.ArrayList;
import java.util.List;

public class InOrderTreeTraversal {
    public List<Integer> iterative(Node<Integer> root) {
        return new ArrayList<>();
    }

    public List<Integer> recursive(Node<Integer> root) {
        if (root == null) return new ArrayList<>();
        List<Integer> orderVisited = new ArrayList<>();
        DFSHelper(root, orderVisited);
        return orderVisited;
    }

    public void DFSHelper(Node<Integer> root, List<Integer> orderVisited) {
        if (root == null) {
            return;
        }
        DFSHelper(root.getLeft(), orderVisited);
        orderVisited.add(root.getDatum());
        DFSHelper(root.getRight(), orderVisited);
    }
}
