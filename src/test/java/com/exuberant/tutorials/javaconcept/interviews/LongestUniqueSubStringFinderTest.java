package com.exuberant.tutorials.javaconcept.interviews;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestUniqueSubStringFinderTest {

    @Test
    public void findLongestUniqueSubstring() {
        assertEquals("rakesh", LongestUniqueSubStringFinder.findLongestUniqueSubstring("rakesh"));
        assertEquals("MANI", LongestUniqueSubStringFinder.findLongestUniqueSubstring("MANINI"));
    }
}