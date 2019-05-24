package com.douma.langtonsant;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Test;

public class TurnDegreeTest extends TestCase {

    @Test
    public void test_a() throws Exception
    {
        new TurnDegree(0);
    }

    public void test_invalid_degree() throws Exception
    {
        boolean thrown = false;
        try
        {
            new TurnDegree(1);
        }
        catch(InvalidTurnDegreeException e)
        {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void test_add() throws Exception
    {
        TurnDegree degree = new TurnDegree(0);
        assertEquals("90", degree.add(new TurnDegree(90)).toString());
        assertEquals("180", degree
                .add(new TurnDegree(90))
                .add(new TurnDegree(90))
                .add(new TurnDegree(90))
                .add(new TurnDegree(90))
                .add(new TurnDegree(90))
                .add(new TurnDegree(90))
                .toString());
        assertEquals("270", degree
                .add(new TurnDegree(90))
                .add(new TurnDegree(90))
                .add(new TurnDegree(90))
                .toString());
        assertEquals("0", degree
                .add(new TurnDegree(90))
                .add(new TurnDegree(90))
                .add(new TurnDegree(90))
                .add(new TurnDegree(90))
                .toString());
    }

    @Test
    public void test_min() throws Exception
    {
        TurnDegree degree = new TurnDegree(0);
        assertEquals("270", degree.min(new TurnDegree(90)).toString());

        assertTrue(degree
                .min(new TurnDegree(90))
                .min(new TurnDegree(90))
                .min(new TurnDegree(90))
                .min(new TurnDegree(90))
                .is0());

        assertTrue(degree
                .min(new TurnDegree(90))
                .min(new TurnDegree(90))
                .min(new TurnDegree(90))
                .min(new TurnDegree(90))
                .min(new TurnDegree(90))
                .is270());
    }
}
