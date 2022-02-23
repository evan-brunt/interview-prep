package dfs;

import common.Node;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class InOrderTreeTraversalTest {
    InOrderTreeTraversal victim = new InOrderTreeTraversal();
    @Test
    public void recursiveInOrderProducesCorrectResult() {
        Node<Integer> five = new Node<>(5);
        Node<Integer> four = new Node<>(4);
        Node<Integer> three = new Node<>(3, null, five);
        Node<Integer> two = new Node<>(2, four, null);
        Node<Integer> one = new Node<>(1, two, three);

        assertThat(victim.recursive(one)).isEqualTo(Arrays.asList(4, 2, 1, 3, 5));
    }

    @Test
    public void recursiveInOrderProducesCorrectResultForBiggerLeftSubTree() {
        Node<Integer> five = new Node<>(5);
        Node<Integer> four = new Node<>(4);
        Node<Integer> three = new Node<>(3, null, null);
        Node<Integer> two = new Node<>(2, four, five);
        Node<Integer> one = new Node<>(1, two, three);

        assertThat(victim.recursive(one)).isEqualTo(Arrays.asList(4, 2, 5, 1, 3));
    }
}