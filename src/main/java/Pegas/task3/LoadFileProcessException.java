package Pegas.task3;

import lombok.Getter;

@Getter
public class LoadFileProcessException extends Throwable {
    private final String line;
    private final int counter;

    public LoadFileProcessException(String message, int counter, String line) {
        super(message);
        this.line = line;
        this.counter = counter;
    }

}
