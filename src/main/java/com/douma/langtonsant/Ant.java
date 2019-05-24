package com.douma.langtonsant;

import java.util.ArrayList;
import java.util.List;

public class Ant
{
    private TurnDegree degree;
    private List<Position> eventHistory;
    private Position position;

    public Ant(Position position, TurnDegree turnDegree)
    {
        this.position = position;
        this.degree = turnDegree;
        this.eventHistory = new ArrayList<Position>();
        this.eventHistory.add(this.position);
    }

    public void forwardLeft() throws Exception
    {
        this.degree = this.degree.min(new TurnDegree(90));
        updatePosition();
    }

    public void forwardRight() throws Exception
    {
        this.degree = this.degree.add(new TurnDegree(90));
        updatePosition();
    }

    private void updatePosition() throws Exception
    {
        if(this.degree.toString().equals("0")) {
            position = position.up();
        } else if(this.degree.toString().equals("90")) {
            position = position.right();
        } else if(this.degree.toString().equals("180")) {
            position = position.down();
        } else if(this.degree.toString().equals("270")) {
            position = position.left();
        } else if(this.degree.toString().equals("360")) {
            position = position.up();
        } else {
            throw new Exception("Cannot calculate position for degree " + this.degree.toString());
        }
        this.eventHistory.add(position);
    }

    public TurnDegree degree()
    {
        return degree;
    }

    public List<Position> eventHistory()
    {
        return eventHistory;
    }

    public Position position()
    {
        return position;
    }
}
