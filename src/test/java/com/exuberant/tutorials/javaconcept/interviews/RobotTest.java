package com.exuberant.tutorials.javaconcept.interviews;

import org.junit.Test;

import static org.junit.Assert.*;

public class RobotTest {

    @Test
    public void printCurrentPosition() {
        Robot robot = new Robot();
        robot.printCurrentPosition();
    }

    @Test
    public void printPreviousPosition() {
        Robot robot = new Robot();
        robot.printPreviousPosition();
    }

    @Test
    public void printLastMove() {
        Robot robot = new Robot();
        robot.moveX(-5);
        robot.printPreviousPosition();
        robot.printCurrentPosition();
        robot.printLastMove();
    }
}