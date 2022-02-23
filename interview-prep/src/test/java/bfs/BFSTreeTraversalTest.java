package bfs;

import common.Node;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BFSTreeTraversalTest {
    BFSTreeTraversal victim = new BFSTreeTraversal();

    @Test
    public void returnsEmptyListWhenRootIsNull() {
        assertThat(victim.breadthFirstSearch(null)).isNullOrEmpty();
    }

    @Test
    public void returnsLevelTraversalOfSimpleTree() {
        Node<Integer> right = new Node<>(3);
        Node<Integer> left = new Node<>(2);
        Node<Integer> root = new Node<>(1, left, right);

        assertThat(victim.breadthFirstSearch(root)).isEqualTo(new ArrayList<>(Arrays.asList(1, 2, 3)));
    }

    @Test
    public void returnsLevelTraversalOfComplexTree() {
        Node<Integer> seven = new Node<>(7);
        Node<Integer> six = new Node<>(6);
        Node<Integer> five = new Node<>(5);
        Node<Integer> four = new Node<>(4);
        Node<Integer> three = new Node<>(3, six, seven);
        Node<Integer> two = new Node<>(2, four, five);
        Node<Integer> root = new Node<>(1, two, three);

        assertThat(victim.breadthFirstSearch(root)).isEqualTo(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
    }

    @Test
    public void returnsLevelTraversalOfMaxDepthTree() {
        Node<Integer> seven = new Node<>(7);
        Node<Integer> six = new Node<>(6, seven, null);
        Node<Integer> five = new Node<>(5, six, null);
        Node<Integer> four = new Node<>(4, five, null);
        Node<Integer> three = new Node<>(3, four, null);
        Node<Integer> two = new Node<>(2, three, null);
        Node<Integer> root = new Node<>(1, two, null);

        assertThat(victim.breadthFirstSearch(root)).isEqualTo(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
    }

    @Test
    public void returnsLevelTraversalOfTreeWithCycle() {
        Node<Integer> seven = new Node<>(7);
        Node<Integer> six = new Node<>(6, seven, null);
        Node<Integer> five = new Node<>(5, six, null);
        Node<Integer> four = new Node<>(4, five, null);
        Node<Integer> three = new Node<>(3, four, null);
        Node<Integer> two = new Node<>(2, three, null);
        Node<Integer> root = new Node<>(1, two, null);
        seven.setLeft(root);

        assertThat(victim.breadthFirstSearch(root)).isEqualTo(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
    }
}