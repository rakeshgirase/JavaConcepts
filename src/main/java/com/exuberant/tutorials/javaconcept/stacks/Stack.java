package com.exuberant.tutorials.javaconcept.stacks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {

    private static Logger logger = LoggerFactory.getLogger(Stack.class);

    private List<T> container = new ArrayList<>();

    public synchronized void push(T t) {
        container.add(t);
    }

    public synchronized T pop() {
        return container.remove(container.size() - 1);
    }

    public void printStack() {
        int size = container.size();
        for (int index = size - 1; index >= 0; --index) {
            logger.info("{}", container.get(index));
        }
    }
}
