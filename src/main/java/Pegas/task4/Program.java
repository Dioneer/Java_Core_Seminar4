package Pegas.task4;

import Pegas.task4.exception.AmountException;
import Pegas.task4.exception.CustomerException;
import Pegas.task4.exception.ProductException;

public class Program {
    public static void main(String[] args) {
        try {
            Shop.buy(new Customer("Igor", 25, "+7asdasd"), new Item("Ball", 100.15),
                    5);
        } catch (CustomerException e) {
            System.out.println(e.getMessage());
        } catch (ProductException e) {
            System.out.println(e.getMessage());
        } catch (AmountException e) {
            System.out.println(e.getMessage());
        }

    }
}
