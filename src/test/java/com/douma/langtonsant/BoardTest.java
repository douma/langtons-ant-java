package com.douma.langtonsant;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Test;

import java.util.ArrayList;

public class BoardTest extends TestCase {

    @Test
    public void test_move_6_times() throws Exception
    {
        Ant ant = new Ant(new Position(0,0), new TurnDegree(0));
        Board board = new Board(ant, 6);

        board.moveAnt();
        ArrayList<MarkedPosition> marked = board.positions();
        assertEquals("[0,0]", marked.get(0).position().toString());
        assertEquals(true, marked.get(0).isMarked());
        assertEquals("[1,0]", marked.get(1).position().toString());
        assertEquals(true, marked.get(1).isMarked());
        assertEquals("[1,-1]", marked.get(2).position().toString());
        assertEquals(true, marked.get(2).isMarked());
        assertEquals("[0,-1]", marked.get(3).position().toString());
        assertEquals(true, marked.get(3).isMarked());
        assertEquals("[0,0]", marked.get(4).position().toString());
        assertEquals(false, marked.get(4).isMarked());
        assertEquals("[-1,0]", marked.get(5).position().toString());
        assertEquals(true, marked.get(5).isMarked());
    }
}
