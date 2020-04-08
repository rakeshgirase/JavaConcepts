package com.exuberant.tutorials.javaconcept.data.structures.tries;

public class Trie {
    private TrieNode root;

    public void insert(String word) {
        if (root == null) {
            root = new TrieNode();
        }
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            current = current.getChildren()
                    .computeIfAbsent(ch, c -> new TrieNode());
        }
        current.setEndOfWord(true);
    }

    public boolean find(String word) {
        TrieNode current = null;
        if (!isEmpty()) {
            current = root;
            for (char ch : word.toCharArray()) {
                TrieNode node = current.getChildren().get(ch);
                if (node == null) {
                    return false;
                }
                current = node;
            }
        }
        return current != null && current.isEndOfWord();
    }

    public void delete(String word) {
        delete(root, word, 0);
    }

    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isEndOfWord()) {
                return false;
            }
            current.setEndOfWord(false);
            return current.getChildren().isEmpty();
        }
        char ch = word.charAt(index);
        TrieNode node = current.getChildren().get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.isEndOfWord();

        if (shouldDeleteCurrentNode) {
            current.getChildren().remove(ch);
            return current.getChildren().isEmpty();
        }
        return false;
    }

    boolean containsNode(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.getChildren().get(ch);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.isEndOfWord();
    }

    public boolean isEmpty() {
        return root == null;
    }
}