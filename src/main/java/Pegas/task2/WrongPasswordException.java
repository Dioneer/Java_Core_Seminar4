package Pegas.task2;

public class WrongPasswordException extends Exception{
    private final int currentLength;
    private final boolean conf;

    public WrongPasswordException(int currentLength, boolean conf) {
        this.currentLength = currentLength;
        this.conf = conf;
    }

    public String getMessage() {
        boolean badLength = currentLength <= 20;
        return badLength ? String.format("You password has an uncorrected length. Expected >= 20, get %d", currentLength):
               "You password is not confirm";
    }
}
