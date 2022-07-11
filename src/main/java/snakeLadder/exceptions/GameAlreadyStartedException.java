package snakeLadder.exceptions;

public class GameAlreadyStartedException extends Exception{

    public GameAlreadyStartedException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Game is in running state. Can't add player";
    }
}
