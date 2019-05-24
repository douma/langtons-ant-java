package com.douma.langtonsant;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Test;

public class AntTest extends TestCase {

    @Test
    public void test_ant_forward_left() throws Exception
    {
        Ant ant = new Ant(new Position(0,0), new TurnDegree(0));
        ant.forwardLeft();
        ant.forwardLeft();

        assertEquals("180", ant.degree().toString());
        assertEquals("[0,0]", ant.eventHistory().get(0).toString());
        assertEquals("[-1,0]", ant.eventHistory().get(1).toString());
        assertEquals("[-1,-1]", ant.eventHistory().get(2).toString());
    }

    @Test
    public void test_ant_forward_right() throws Exception
    {
        Ant ant = new Ant(new Position(0,0), new TurnDegree(0));
        ant.forwardRight();
        ant.forwardRight();

        assertEquals("180", ant.degree().toString());
        assertEquals("[0,0]", ant.eventHistory().get(0).toString());
        assertEquals("[1,0]", ant.eventHistory().get(1).toString());
        assertEquals("[1,-1]", ant.eventHistory().get(2).toString());
    }

    public void test_left_and_right() throws Exception
    {
        Ant ant = new Ant(new Position(0,0), new TurnDegree(0));
        ant.forwardRight();
        ant.forwardRight();
        ant.forwardLeft();
        ant.forwardLeft();

        assertEquals("0", ant.degree().toString());
        assertEquals("[0,0]", ant.eventHistory().get(0).toString());
        assertEquals("[1,0]", ant.eventHistory().get(1).toString());
        assertEquals("[1,-1]", ant.eventHistory().get(2).toString());
        assertEquals("[2,-1]", ant.eventHistory().get(3).toString());
        assertEquals("[2,0]", ant.eventHistory().get(4).toString());
    }
}
