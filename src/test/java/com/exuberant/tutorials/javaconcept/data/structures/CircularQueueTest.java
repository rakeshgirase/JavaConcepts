package com.exuberant.tutorials.javaconcept.data.structures;

import org.junit.Test;

import static org.junit.Assert.*;

public class CircularQueueTest {

    private CircularQueue circularQueue;

    @Test
    public void isEmpty() {
        circularQueue = new CircularQueue(3);
        assertTrue(circularQueue.isEmpty());
    }

    @Test
    public void isFull() {
        circularQueue = new CircularQueue(3);
        circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        circularQueue.enqueue(3);
        assertTrue(circularQueue.isFull());
    }

    @Test
    public void first() {
        circularQueue = new CircularQueue(3);
        assertTrue(circularQueue.isEmpty());
        circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        circularQueue.enqueue(3);
        assertEquals(1,circularQueue.first());
        assertTrue(circularQueue.isFull());
    }

    @Test
    public void last() {
        circularQueue = new CircularQueue(3);
        assertTrue(circularQueue.isEmpty());
        circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        circularQueue.enqueue(3);
        assertEquals(3,circularQueue.last());
        assertTrue(circularQueue.isFull());
    }

    @Test
    public void enqueue() {
        circularQueue = new CircularQueue(3);
        assertTrue(circularQueue.isEmpty());
        circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        circularQueue.enqueue(3);
        assertEquals(3,circularQueue.last());
        assertTrue(circularQueue.isFull());
    }

    @Test
    public void enqueueReturnsFalseWhenQueueIsFull() {
        circularQueue = new CircularQueue(3);
        assertTrue(circularQueue.isEmpty());
        circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        circularQueue.enqueue(3);
        assertEquals(3,circularQueue.last());
        assertTrue(circularQueue.isFull());
        assertFalse(circularQueue.enqueue(5));
    }

    @Test
    public void dequeue() {
        circularQueue = new CircularQueue(3);
        assertTrue(circularQueue.isEmpty());
        circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        circularQueue.enqueue(3);
        assertEquals(3,circularQueue.dequeue());
        assertEquals(2,circularQueue.dequeue());
        assertEquals(1,circularQueue.dequeue());
        assertTrue(circularQueue.isEmpty());
    }

    @Test
    public void dequeueReturnsNegativeWhenEmpty() {
        circularQueue = new CircularQueue(3);
        assertTrue(circularQueue.isEmpty());
        assertEquals(-1, circularQueue.dequeue());
    }
}