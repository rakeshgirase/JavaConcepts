package com.exuberant.tutorials.javaconcept.data.structures.tries;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;

public class TrieTest {

    @Test
    public void whenEmptyTrie_thenNoElements() {
        Trie trie = new Trie();

        assertTrue(trie.isEmpty());
    }

    @Test
    public void givenATrie_whenAddingElements_thenTrieNotEmpty() {
        Trie trie = createExampleTrie();

        assertFalse(trie.isEmpty());
    }

    @Test
    public void givenATrie_whenAddingElements_thenTrieHasThoseElements() {
        Trie trie = createExampleTrie();

        assertFalse(trie.containsNode("Practice"));
        assertFalse(trie.containsNode("Perfect"));

        assertTrue(trie.containsNode("Programming"));
        assertTrue(trie.containsNode("is"));
        assertTrue(trie.containsNode("a"));
        assertTrue(trie.containsNode("way"));
        assertTrue(trie.containsNode("of"));
        assertTrue(trie.containsNode("life"));
    }

    @Test
    public void givenATrie_whenLookingForNonExistingElement_thenReturnsFalse() {
        Trie trie = createExampleTrie();

        assertFalse(trie.containsNode("99"));
    }

    @Test
    public void givenATrie_whenDeletingElements_thenTreeDoesNotContainThoseElements() {

        Trie trie = createExampleTrie();

        assertTrue(trie.containsNode("Programming"));
        trie.delete("Programming");
        assertFalse(trie.containsNode("Programming"));
    }

    @Test
    public void givenATrie_whenDeletingOverlappingElements_thenDontDeleteSubElement() {

        Trie trie1 = new Trie();

        trie1.insert("pie");
        trie1.insert("pies");

        trie1.delete("pies");

        Assertions.assertTrue(trie1.containsNode("pie"));
    }

    private Trie createExampleTrie() {
        Trie trie = new Trie();

        trie.insert("Programming");
        trie.insert("is");
        trie.insert("a");
        trie.insert("way");
        trie.insert("of");
        trie.insert("life");

        return trie;
    }
}