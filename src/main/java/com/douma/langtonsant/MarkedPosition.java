package com.douma.langtonsant;

public class MarkedPosition
{
    private boolean marked = false;
    private Position position;

    MarkedPosition(boolean marked, Position position)
    {
        this.marked = marked;
        this.position = position;
    }

    public boolean isMarked()
    {
        return marked;
    }

    public Position position()
    {
        return position;
    }
}
