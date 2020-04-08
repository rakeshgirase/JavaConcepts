package com.exuberant.tutorials.javaconcept.data.structures.binarytree;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BinaryTreeTest {

    private static Logger logger = LoggerFactory.getLogger(BinaryTreeTest.class);

    private Random random;
    private BinaryTree binaryTree;

    @Before
    public void setUp() {
        random = new Random();
        binaryTree = new BinaryTree();
    }

    @Test
    public void add() {
        for (int i = 0; i < 10; i++) {
            binaryTree.add(random.nextInt(100));
        }
        BTreePrinter.printNode(binaryTree.root);
    }

    @Test
    public void search() {
        for (int i = 0; i < 10; i++) {
            binaryTree.add(i);
        }
        assertTrue(binaryTree.exist(new Integer(0)));
        assertFalse(binaryTree.exist(new Integer(10)));
    }
}