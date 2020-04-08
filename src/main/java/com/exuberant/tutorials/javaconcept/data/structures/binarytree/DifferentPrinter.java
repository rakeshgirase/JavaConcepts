package com.exuberant.tutorials.javaconcept.data.structures.binarytree;

public class DifferentPrinter {

    public <T extends Comparable<T>> void traversePreOrder(StringBuilder sb, Node<T> node) {
        if (node != null) {
            sb.append(node.value);
            sb.append("\n");
            traversePreOrder(sb, node.left);
            traversePreOrder(sb, node.right);
        }
    }
}
