package snakeLadder.entity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class SpecialEntity {
    private int start;
    private int end;

    public abstract String getId();

    public int getActionPosition() {
        return start;
    }

    public int getEndPosition() {
        return end;
    }
}
