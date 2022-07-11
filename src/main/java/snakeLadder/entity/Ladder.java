package snakeLadder.entity;

public class Ladder extends SpecialEntity{
    public Ladder(int start, int end) {
        super(start, end);
    }

    @Override
    public String getId() {
        return "L_"+this.getEndPosition();
    }
}
