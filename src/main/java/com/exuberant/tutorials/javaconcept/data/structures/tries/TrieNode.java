package com.exuberant.tutorials.javaconcept.data.structures.tries;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    private boolean endOfWord;

    private Map<Character, TrieNode> children = new HashMap<>();

    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    public void setEndOfWord(boolean endOfWord) {
        this.endOfWord = endOfWord;
    }

    public boolean isEndOfWord() {
        return endOfWord;
    }
}