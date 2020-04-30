package com.exuberant.tutorials.javaconcept.data.structures;

public class CircularQueue {
    private int position;
    private int[] data;

    public CircularQueue(int maxsize) {
        this.data = new int[maxsize];
        this.position = -1;
    }

    public boolean isEmpty() {
        return this.position < 0;
    }

    public boolean isFull() {
        return this.position + 1 == data.length;
    }

    public int first() {
        if (position > 0) {
            return data[0];
        }
        return -1;
    }

    public int last() {
        if (isFull()) {
            return data[data.length - 1];
        }
        return -1;
    }

    public boolean enqueue(int item) {
        if (!isFull()) {
            this.position = position + 1;
            data[position] = item;
            return true;
        }
        return false;
    }

    public int dequeue() {
        if (!isEmpty()) {
            int item = data[position];
            position = position - 1;
            return item;
        }
        return -1;
    }
}
