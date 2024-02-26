package Pegas.homework;

import Pegas.homework.exception.IllegalArgumentException;
import Pegas.homework.exception.InsufficientFundsException;

public class DebitAccount extends Account{
    public DebitAccount() {
    }

    @Override
    public void createAmount(double amount) throws IllegalArgumentException {
        if(amount<=0){
            throw new IllegalArgumentException(String.format("The deposit amount to %s account is less than or equal to 0", this.getClass().getSimpleName()));
        }
        setAmount(amount);
    }

    @Override
    public void createDeposit(double amount) throws IllegalArgumentException {
        if(amount<=0){
            throw new IllegalArgumentException(String.format("The deposit amount to %s account is less than or equal to 0", this.getClass().getSimpleName()));
        }
        setDeposit(amount);
    }

    @Override
    public double withdrawal(double amount) throws InsufficientFundsException {
        if(amount>getAmount()){
            throw new InsufficientFundsException(String.format("The deposit amount to %s account is less than or equal to 0", this.getClass().getSimpleName()));
        }
        setAmount(getAmount()-amount);
        return getAmount();
    }
}
