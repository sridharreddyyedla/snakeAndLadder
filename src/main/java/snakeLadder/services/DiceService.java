package snakeLadder.services;

import snakeLadder.entity.Dice;

import java.util.Random;

public class DiceService {
    private static Random  r = new Random();
    public static int roll(Dice dice, int noOfDices) {
        int min = noOfDices;
        int max = noOfDices*dice.getMaxValue();
        return r.nextInt(max-min)+min;
    }
}
