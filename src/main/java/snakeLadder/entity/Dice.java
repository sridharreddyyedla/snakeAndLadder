package snakeLadder.entity;

import lombok.Getter;

public class Dice {
    @Getter
    private int maxValue;

    public Dice(int maxValue) {
        this.maxValue = maxValue;
    }

    public int roll(){
        return (int) Math.floor(Math.random()*maxValue+1);
    }

}
