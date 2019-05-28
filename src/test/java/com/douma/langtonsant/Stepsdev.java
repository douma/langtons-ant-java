package com.douma.langtonsant;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import java.util.ArrayList;

public class Stepsdev {
    private String direction;
    private int startPositionX;
    private int startPositionY;
    private int moves;
    private Board board;
    private Ant ant;

    @Given("I am facing {string}")
    public void i_am_facing(String string) {
        this.direction = string;
    }

    @Given("I start at {int}:{int}")
    public void i_start_at(Integer int1, Integer int2) {
        this.startPositionX = int1;
        this.startPositionY = int2;
    }

    @When("I move {int} times")
    public void i_move_times(Integer int1) throws Exception {
        this.moves = int1;
        int degree = 0;
        if(this.direction.equals("east")) {
            degree = 90;
        } else if(this.direction.equals("south")) {
            degree = 180;
        } else if(this.direction.equals("west")) {
            degree = 270;
        } else if(this.direction.equals("north")) {
            degree = 0;
        }

        this.ant = new Ant(new Position(this.startPositionX,this.startPositionY), new TurnDegree(degree));
        this.board = new Board(ant,this.moves);
        this.board.moveAnt();
    }

    @Then("I should be facing {string}")
    public void i_should_be_facing(String string) throws Exception {
        TurnDegree degree = this.ant.degree();
        if(string.equals("north") && !degree.is0()) {
            throw new Exception("Not facing north");
        } else if(string.equals("east") && !degree.is90()) {
            throw new Exception("Not facing east");
        } else if(string.equals("south") && !degree.is180()) {
            throw new Exception("Not facing south");
        } else if(string.equals("west") && !degree.is270()) {
            throw new Exception("Not facing west");
        }
    }

    @Then("the tile {int}:{int} should be {string}")
    public void the_tile_should_be(Integer int1, Integer int2, String string) throws Exception {
        boolean shouldBeMarked = string.equals("marked");
        ArrayList<MarkedPosition> positions = this.board.positions();
        for(MarkedPosition position : positions) {
            if(position.position().x() == int1 && position.position().y() == int2) {
                if (!(position.isMarked() == shouldBeMarked)) {
                    throw new Exception("Position (" + int1 + "," + int2 + ") is not " + string);
                }
            }
        }
    }
}
