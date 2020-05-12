package com.exuberant.tutorials.javaconcept.interviews;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Robot {

    private static Logger logger = LoggerFactory.getLogger(Robot.class);

    private int currentX;
    private int currentY;
    private int previousX;
    private int previousY;
    private boolean isXDirection = true;

    public Robot() {
        this(0, 5);
    }

    public Robot(int currentX, int currentY) {
        this.currentX = currentX;
        this.currentY = currentY;
        this.previousX = currentX;
        this.previousY = currentY;
    }

    public void printCurrentPosition() {
        logger.info("X: {}, Y: {}", currentX, currentY);
    }

    public void printPreviousPosition() {
        logger.info("Previous X: {}, Previous Y: {}", previousX, previousY);
    }

    public void printLastMove() {
        logger.info("Moved From-> X: {}, Y: {} TO X: {}, Y: {} by distance: {}", previousX, previousY, currentX, currentY, isXDirection?(currentX-previousX): (currentY-previousY));
    }

    public void moveX(int dx) {
        this.previousX = this.currentX;
        this.currentX += dx;
        isXDirection = true;
    }

    public void moveY(int dy) {
        this.previousY = this.currentY;
        this.currentY += dy;
        isXDirection = false;
    }
}
