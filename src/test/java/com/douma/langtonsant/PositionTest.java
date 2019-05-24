package com.douma.langtonsant;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Test;

public class PositionTest extends TestCase
{
    @Test
    public void test_position_left()
    {
        Position p = new Position(0,0);
        p = p.left();

        assertEquals(-1, p.x());
        assertEquals(0, p.y());
    }

    @Test
    public void test_position_right()
    {
        Position p = new Position(0,0);
        p = p.right();

        assertEquals("[1,0]", p.toString());
    }

    @Test
    public void test_position_up()
    {
        Position p = new Position(0,0);
        p = p.up();

        assertEquals("[0,1]", p.toString());
    }

    @Test
    public void test_position_down()
    {
        Position p = new Position(0,0);
        p = p.down();

        assertEquals("[0,-1]", p.toString());
    }

    @Test
    public void test_to_string()
    {
        Position p = new Position(0,0);
        p = p.left();
        p = p.down();
        assertEquals("[-1,-1]", p.toString());
    }
}
