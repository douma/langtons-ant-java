package com.douma.langtonsant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class Board {

    Ant ant;
    int length;
    LinkedHashMap<String,Position> marked;

    Board(Ant ant, int length) {
        this.ant = ant;
        this.length = length;
        this.marked = new LinkedHashMap<String, Position>();
    }

    public void moveAnt() throws Exception
    {
        for(int x = 0; x < this.length; x++) {
            Position position = this.ant.position();
            if(this.isMarked(position)) {
                this.ant.forwardLeft();
                this.unmark(position);
            } else {
                this.ant.forwardRight();
                this.mark(position);
            }
        }
    }

    private boolean isMarked(Position position)
    {
        return this.marked.containsKey(position.toString());
    }

    private void mark(Position position)
    {
        this.marked.put(position.toString(), position);
    }

    private void unmark(Position position)
    {
        this.marked.remove(position.toString());
    }

    public ArrayList<Position> markedPositions()
    {
        return new ArrayList<Position>(this.marked.values());
    }
}
