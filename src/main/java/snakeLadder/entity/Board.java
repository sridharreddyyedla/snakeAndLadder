package snakeLadder.entity;

import lombok.Getter;

import java.util.HashMap;

public class Board {

    @Getter
    int dimension;

    HashMap<Integer, SpecialEntity> specialEntities;

    public Board(int dimension) {
        this.dimension = dimension;
        this.specialEntities = new HashMap<>();
    }

    // print board
    public void printBoard(){

    }

    // get total cells on board
    public int getTotalCells(){
        return dimension * dimension;
    }

    public void addSpecialEntity(SpecialEntity specialEntity){
        if(hasSpecialEntity(specialEntity.getActionPosition()) || hasSpecialEntity(specialEntity.getEndPosition())){
            return;
        }
        specialEntities.put(specialEntity.getActionPosition(), specialEntity);
    }

    public boolean hasSpecialEntity(int position){
        return specialEntities.containsKey(position);
    }

    public SpecialEntity getSpecialEntity(int position){
        return specialEntities.getOrDefault(position, null);
    }
}
