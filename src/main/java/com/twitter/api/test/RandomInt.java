package com.twitter.api.test;

public class RandomInt {

    public static int getRandomIntegerBetweenRange(int min, int max) {
        return (int)(Math.random()*((max-min)+1))+min;
    }

}
