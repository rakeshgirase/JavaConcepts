package com.exuberant.tutorials.javaconcept.interviews;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SongsDilemmaTest {

    @Test
    public void getCount() {
        List<Integer> songs = Arrays.asList(20, 40, 60);
        SongsDilemma songsDilemma = new SongsDilemma();
        int actual = songsDilemma.getCount(songs);
        assertEquals(1, actual);
    }

    @Test
    public void getCountWhenFour() {
        List<Integer> songs = Arrays.asList(20, 40, 60, 20);
        SongsDilemma songsDilemma = new SongsDilemma();
        int actual = songsDilemma.getCount(songs);
        assertEquals(2, actual);
    }

    @Test
    public void getCountWhenSongsListIsEmpty() {
        List<Integer> songs = Arrays.asList();
        SongsDilemma songsDilemma = new SongsDilemma();
        int actual = songsDilemma.getCount(songs);
        assertEquals(0, actual);
    }

    @Test
    public void getCountWhenMoreElements() {
        List<Integer> songs = Arrays.asList(20, 40, 60, 20, 40, 30, 30);
        SongsDilemma songsDilemma = new SongsDilemma();
        int actual = songsDilemma.getCount(songs);
        assertEquals(5, actual);
    }
}