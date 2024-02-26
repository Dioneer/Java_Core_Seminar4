package Pegas.homework;

import Pegas.homework.exception.ExecutedException;

public class Transaction<T extends CreditAccount, K extends DebitAccount> {
    private final T from;
    private final K to;
    private final double summ;

    public Transaction(T from, K to, double summ) {
        this.from = from;
        this.to = to;
        this.summ = summ;
    }

    public double executedCToD() throws ExecutedException {
        if(from.getAmount()>=summ){
            from.setAmount(from.getAmount()-summ);
            to.setAmount(to.getAmount()+summ);
            return to.getAmount();
        }else{
            throw new ExecutedException("You haven't got enough money");
        }

    }
    public double  executedDToC() throws ExecutedException {
        if(to.getAmount()>=summ){
            to.setAmount(to.getAmount()-summ);
            from.setAmount(from.getAmount()+summ);
            return from.getAmount();
        }else{
            throw new ExecutedException("You haven't got enough money");
        }

    }
}
