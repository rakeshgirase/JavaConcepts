package com.exuberant.tutorials.javaconcept.interviews.amazon;

import org.junit.Test;

import java.util.Arrays;

import static com.exuberant.tutorials.javaconcept.interviews.amazon.PacketSupply.NOT_RECEIVED;
import static com.exuberant.tutorials.javaconcept.interviews.amazon.PacketSupply.RECEIVED;
import static org.junit.Assert.*;

public class PacketSupplyTest {

    @Test
    public void testCountFromSinglePacket(){
        char[][] matrix = new char[5][8];
        for (char[] row : matrix) {
            Arrays.fill(row, NOT_RECEIVED);
        }
        matrix[2][4] = RECEIVED;
        assertEquals(6, PacketSupply.countSupply(matrix));
    }

    @Test
    public void testCountFromMultiplePacket(){
        char[][] matrix = new char[5][8];
        for (char[] row : matrix) {
            Arrays.fill(row, NOT_RECEIVED);
        }
        matrix[2][4] = RECEIVED;
        matrix[2][0] = RECEIVED;
        assertEquals(5, PacketSupply.countSupply(matrix));
    }

    @Test
    public void testCountForAlreadyReceivedServers(){
        char[][] matrix = new char[5][8];
        for (char[] row : matrix) {
            Arrays.fill(row, RECEIVED);
        }
        assertEquals(0, PacketSupply.countSupply(matrix));
    }

    @Test
    public void testCountForOneServerRemaining(){
        char[][] matrix = new char[5][8];
        for (char[] row : matrix) {
            Arrays.fill(row, RECEIVED);
        }
        matrix[2][4] = NOT_RECEIVED;
        assertEquals(1, PacketSupply.countSupply(matrix));
    }
}