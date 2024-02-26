package Pegas.task1;

import lombok.Getter;

@Getter
public abstract class CustomArrayException extends Exception{
    private final int x;
    private final int y;

    public CustomArrayException(String message,int x, int y) {
        super(message);
        this.x = x;
        this.y = y;
    }
}
