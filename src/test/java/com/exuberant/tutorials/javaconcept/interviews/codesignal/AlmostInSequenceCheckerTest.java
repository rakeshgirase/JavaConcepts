package com.exuberant.tutorials.javaconcept.interviews.codesignal;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AlmostInSequenceCheckerTest {

    private AlmostInSequenceChecker almostInSequenceChecker = new AlmostInSequenceChecker();

    @Test
    public void isAlmostInSequenceSequence() {
        int[] sequence = {1,2,3};
        assertTrue(almostInSequenceChecker.isAlmostInSequence(sequence));
    }

    @Test
    public void isAlmostInSequenceSingleItem() {
        int[] sequence = {1};
        assertTrue(almostInSequenceChecker.isAlmostInSequence(sequence));
    }

    @Test
    public void isAlmostInSequenceSecondIsOdd() {
        int[] sequence = {1,3,5};
        assertFalse(almostInSequenceChecker.isAlmostInSequence(sequence));
    }

    @Test
    public void isAlmostInSequenceFirstIsOdd() {
        int[] sequence = {1,3,4,5};
        assertTrue(almostInSequenceChecker.isAlmostInSequence(sequence));
    }

    @Test
    public void isAlmostInSequenceForInvalid3() {
        int[] sequence = {1,3,5};
        assertFalse(almostInSequenceChecker.isAlmostInSequence(sequence));
    }

    @Test
    public void isAlmostInSequenceForValid3() {
        int[] sequence = {1,3,2};
        assertTrue(almostInSequenceChecker.isAlmostInSequence(sequence));
    }

    @Test
    public void isAlmostInSequenceForInvalid4() {
        int[] sequence = {1,3,5,6};
        assertFalse(almostInSequenceChecker.isAlmostInSequence(sequence));
    }

    @Test
    public void isAlmostInSequenceForInvalidAnother4() {
        int[] sequence = {1,2,1,2};
        assertFalse(almostInSequenceChecker.isAlmostInSequence(sequence));
    }

    @Test
    public void isAlmostInSequenceForTwo() {
        int[] sequence = {1,2};
        assertTrue(almostInSequenceChecker.isAlmostInSequence(sequence));
    }

    @Test
    public void isAlmostInSequenceForInvalidTwo() {
        int[] sequence = {1,3};
        assertFalse(almostInSequenceChecker.isAlmostInSequence(sequence));
    }

    /*@Test
    public void isAlmostInSequenceForInvalidFive() {
        int[] sequence = {1, 1, 2, 3, 4, 4};
        assertFalse(almostInSequenceChecker.isAlmostInSequence(sequence));
    }*/
}