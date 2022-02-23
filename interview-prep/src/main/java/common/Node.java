package common;

public class Node<T> {
    private T datum;
    private Node<T> left;
    private Node<T> right;

    public Node (T datum) {
        this.datum = datum;
    }

    public Node (T datum, Node<T> left, Node<T> right) {
        this.datum = datum;
        this.left = left;
        this.right = right;
    }

    public Node<T> getLeft() {
        return left;
    }

    public Node<T> getRight() {
        return right;
    }

    public T getDatum() {
        return datum;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }
}
