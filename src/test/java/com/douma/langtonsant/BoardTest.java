package com.douma.langtonsant;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Test;

import java.util.ArrayList;

public class BoardTest extends TestCase {

    @Test
    public void test_move_5_times_only_3_positions_marked() throws Exception
    {
        Ant ant = new Ant(new Position(0,0), new TurnDegree(0));
        Board board = new Board(ant, 5);

        board.moveAnt();
        ArrayList<Position> marked = board.markedPositions();
        assertEquals("[1,0]", marked.get(0).toString());
        assertEquals("[1,-1]", marked.get(1).toString());
        assertEquals("[0,-1]", marked.get(2).toString());
    }
}
