package com.codeup.springblog.services;

public class Dice {
    private int numberOfSides;

    public Dice(int numberOfSides) {
        this.numberOfSides = numberOfSides;
    }

    public int roll() {
        return (int)(Math.random() * this.numberOfSides + 1);
    }
}
