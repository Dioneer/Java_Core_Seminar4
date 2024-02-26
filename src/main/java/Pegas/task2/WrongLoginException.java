package Pegas.task2;

public class WrongLoginException extends Exception{
    private final int currentLength;

    public WrongLoginException(int currentLength) {
        this.currentLength = currentLength;
    }

    public String getMessage() {
        return String.format("You loggin has an uncorrected length. Expected <20, get %d", currentLength);
    }
}
