package snakeLadder.entity;

import snakeLadder.enums.GameStatus;
import snakeLadder.exceptions.GameAlreadyStartedException;
import snakeLadder.services.DiceService;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Game {
    Board board;
    Dice dice;
    int noOfDices;
    Queue<Player> players;
    GameStatus gameStatus;

    public Game(Board board, Dice dice, int noOfDices) {
        this.board = board;
        this.dice = dice;
        this.noOfDices = noOfDices;
        this.players = new LinkedList<>();
        this.gameStatus = GameStatus.NOT_STARTED;
    }

    public void addPlayers(List<Player> players) throws GameAlreadyStartedException {
        if(gameStatus==GameStatus.NOT_STARTED){
            this.players.addAll(players);
        }else{
            // game started, can't add player
            throw new GameAlreadyStartedException("Game already started, can't add player");
        }
    }

    public void startGame(){
        this.gameStatus = GameStatus.RUNNING;
        board.printBoard();

        while(players.size()>1){
            Player p = players.poll();
            makeMove(p);
            if(p.getPosition()==board.getTotalCells()){
                System.out.println("Player "+ p.getName()+" has finished the game");
            }else{
                players.add(p);
            }
        }

        this.gameStatus = GameStatus.FINISHED;
    }

    private void makeMove(Player player){
        System.out.println();
        System.out.println("Player "+ player.getName()+" 's turn");
        System.out.print("Press any key to roll dice");

        Scanner sc = new Scanner(System.in);
        char ch = sc.next().charAt(0);

        int position = player.getPosition();
        int roll = DiceService.roll(dice, noOfDices);

        System.out.print("Dice "+ roll+"\t");

        int targetPosition = position+roll;

        if(targetPosition > board.getTotalCells()){
            System.out.println("Invalid move");
            return;
        }

        if(board.hasSpecialEntity(targetPosition)){
            targetPosition = board.getSpecialEntity(targetPosition).getEndPosition();
        }
        player.setPosition(targetPosition);
        System.out.println("Position "+targetPosition);
    }
}
