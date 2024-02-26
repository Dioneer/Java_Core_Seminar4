package Pegas.homework;

import Pegas.homework.exception.IllegalArgumentException;
import Pegas.homework.exception.InsufficientFundsException;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public abstract class Account {
    private double amount;
    private double deposit;
    public abstract void createAmount(double amount) throws IllegalArgumentException;
    public abstract void createDeposit(double amount) throws IllegalArgumentException;
    public abstract double withdrawal(double amount) throws InsufficientFundsException;
}
