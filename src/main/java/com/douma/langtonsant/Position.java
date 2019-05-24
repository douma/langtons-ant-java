package com.douma.langtonsant;

public class Position
{
    int x, y;

    Position(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public Position left()
    {
        return new Position(this.x -= 1, this.y);
    }

    public Position right()
    {
        return new Position(this.x += 1, this.y);
    }

    public Position up()
    {
        return new Position(this.x, this.y -= 1);
    }

    public Position down()
    {
        return new Position(this.x, this.y += 1);
    }

    public int x()
    {
        return this.x;
    }

    public int y()
    {
        return this.y;
    }

    public String toString()
    {
        return "["+this.x+","+this.y+"]";
    }
}
