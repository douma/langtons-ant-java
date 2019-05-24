package com.douma.langtonsant;

import java.util.Arrays;

public class TurnDegree
{
    private int degree = 0;

    TurnDegree(int degree) throws InvalidTurnDegreeException
    {
        this.degree = degree;

        if(!isValid(degree)) {
            throw InvalidTurnDegreeException.forDegree(degree);
        }
    }

    public TurnDegree add(TurnDegree turnDegree) throws InvalidTurnDegreeException
    {
        int newDegree = this.degree + turnDegree.degree;
        newDegree = (newDegree + 360) % 360;
        return new TurnDegree(newDegree);
    }

    public TurnDegree min(TurnDegree turnDegree) throws InvalidTurnDegreeException
    {
        int newDegree = this.degree - turnDegree.degree;
        newDegree = (newDegree + 360) % 360;
        return new TurnDegree(newDegree);
    }

    private boolean isValid(int degree)
    {
        int[] valid = {0,90,180,270,360};
        for(int num : valid) {
            if(num == degree) {
                return true;
            }
        }
        return false;
    }

    public boolean is90()
    {
        return this.toString().equals("90");
    }

    public boolean is180()
    {
        return this.toString().equals("180");
    }

    public boolean is270()
    {
        return this.toString().equals("270");
    }

    public boolean is0()
    {
        return this.toString().equals("360") || this.toString().equals("0");
    }

    public String toString()
    {
        return "" + this.degree;
    }
}
