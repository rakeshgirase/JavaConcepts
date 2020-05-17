package com.exuberant.tutorials.javaconcept.interviews.amazon;

import java.util.Arrays;

/**
 * Created by rakesh on 28-Mar-2020.
 * Packet transmission is a phenomenon where the server which has the the packet(symbolized as X) transmits the packet to next server which is above/below/left/right.
 * Given a state of packed in a server, calculate the number of cycles you need for packet to reach to all servers.
 */
public class PacketSupply {

    public static final char NOT_RECEIVED = '0';
    public static final char RECEIVED = 'X';

    public static int countSupply(char[][] matrix) {
        printMatrix(matrix);
        char[][] copy = copyMatrix(matrix);
        int cycles = 0;
        while (!packetReached(copy)) {
            cycles++;
            passPacket(matrix, copy);
            printMatrix(copy);
            matrix = copyMatrix(copy);
        }
        System.err.println("Total Cycles: " + cycles);
        return cycles;
    }

    private static boolean packetReached(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                if (aChar == NOT_RECEIVED) {
                    return false;
                }
            }
        }
        return true;
    }

    private static char[][] copyMatrix(char[][] original) {
        char[][] copy = new char[original.length][original[0].length];
        for (int row = 0; row < original.length; row++) {
            for (int column = 0; column < original[row].length; column++) {
                copy[row][column] = original[row][column];
            }
        }
        return copy;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            System.err.println(Arrays.toString(row));
        }
        System.err.println("---------------------");
    }

    private static void passPacket(char[][] matrix, char[][] copy) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                if (matrix[row][column] == RECEIVED) {
                    updateLeftServer(copy, row, column);
                    updateRightServer(copy, row, column);
                    updateTopServer(copy, row, column);
                    updateBottomServer(copy, row, column);
                }
            }
        }
    }

    private static void updateLeftServer(char[][] matrix, int row, int column) {
        int leftColumn = column - 1;
        if (leftColumn > -1) {
            matrix[row][leftColumn] = RECEIVED;
        }
    }

    private static void updateRightServer(char[][] matrix, int row, int column) {
        int rightColumn = column + 1;
        if (rightColumn < matrix[0].length) {
            matrix[row][rightColumn] = RECEIVED;
        }
    }

    private static void updateTopServer(char[][] matrix, int row, int column) {
        int topRow = row - 1;
        if (topRow > -1) {
            matrix[topRow][column] = RECEIVED;
        }
    }

    private static void updateBottomServer(char[][] matrix, int row, int column) {
        int bottomRow = row + 1;
        if (bottomRow < matrix.length) {
            matrix[bottomRow][column] = RECEIVED;
        }
    }
}
