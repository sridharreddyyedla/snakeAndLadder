package snakeLadder.entity;

import lombok.Getter;
import lombok.Setter;

public class Player {

    @Getter
    @Setter
    private int position;

    @Getter
    private String name;

    public Player(String name) {
        this.name = name;
        this.position = 0;
    }
}
