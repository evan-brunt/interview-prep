package bfs;

import common.GraphNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BFSGraphTraversalTest {
    BFSGraphTraversal victim = new BFSGraphTraversal();

    @Test
    public void visitsNodesOnceInGraphWithCycle() {
        GraphNode<Integer> start = new GraphNode<>(1);
        GraphNode<Integer> end = new GraphNode<>(2);
        start.addNodeToAdjacencyList(end);
        end.addNodeToAdjacencyList(start);

        assertThat(victim.bfsGraphNodes(start)).isEqualTo(new ArrayList<>(Arrays.asList(1, 2)));
        assertThat(victim.bfsGraphNodes(end)).isEqualTo(new ArrayList<>(Arrays.asList(2, 1)));
    }

    @Test
    public void returnsEmptyListWhenStartingNodeIsNull() {
        assertThat(victim.bfsGraphNodes(null)).isNullOrEmpty();
    }

    @Test
    public void returnsLevelOrderTraversalOfGraph() {
        GraphNode<Integer> one = new GraphNode<>(1);
        GraphNode<Integer> two = new GraphNode<>(2);
        GraphNode<Integer> three = new GraphNode<>(3);
        GraphNode<Integer> four = new GraphNode<>(4);
        GraphNode<Integer> five = new GraphNode<>(5);

        one.addNodeToAdjacencyList(two);
        one.addNodeToAdjacencyList(three);
        two.addNodeToAdjacencyList(four);
        three.addNodeToAdjacencyList(five);

        assertThat(victim.bfsGraphNodes(one)).isEqualTo(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)));
    }
}