package com.exuberant.tutorials.javaconcept.data.structures.binarytree;

public class BinaryTree<T extends Comparable<T>> {
    Node<T> root;

    public void add(T value) {
        root = addRecursive(root, value);
    }

    public boolean exist(T value) {
        root = searchRecursive(root, value);
        return root != null;
    }

    private Node<T> searchRecursive(Node<T> root, T key) {
        if (root == null || root.value.compareTo(key) == 0) {
            return root;
        }
        if (key.compareTo(root.value) < 0) {
            return searchRecursive(root.left, key);
        }

        return searchRecursive(root.right, key);
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                '}';
    }

    private Node<T> addRecursive(Node<T> current, T value) {
        if (current == null) {
            return new Node(value);
        }
        if (value.compareTo(current.value) <= 0) {
            current.left = addRecursive(current.left, value);
        } else if (value.compareTo(current.value) > 0) {
            current.right = addRecursive(current.right, value);
        }
        return current;
    }
}

class Node<T extends Comparable<T>> {
    T value;
    Node left;
    Node right;

    Node(T value) {
        this.value = value;
        right = null;
        left = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}