package com.douma.langtonsant;

public class InvalidTurnDegreeException extends Exception {

    InvalidTurnDegreeException(String message)
    {
        super(message);
    }

    public static InvalidTurnDegreeException forDegree(int degree)
    {
        return new InvalidTurnDegreeException("Invalid turn degree " + degree);
    }
}
