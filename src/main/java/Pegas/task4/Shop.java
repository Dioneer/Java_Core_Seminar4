package Pegas.task4;

import Pegas.task4.exception.AmountException;
import Pegas.task4.exception.CustomerException;
import Pegas.task4.exception.ProductException;
import lombok.Getter;

@Getter
public class Shop {
    private static Customer[] customers={
            new Customer("Ivan", 20, "+7-222-111-44-55"),
            new Customer("Pavel", 25, "+7-222-111-44-56"),
    };
    private static Item[] items={
            new Item("Ball", 100.15),
            new Item("Table", 1100.15),
            new Item("Car", 1500.15),
            new Item("Star", 10.15),
            new Item("Spoon", 25.15),
    };
    public static Order buy(Customer customer, Item item, int amount) throws CustomerException, ProductException, AmountException {
        if(!isInArray(customers, customer)){
            throw new CustomerException("Unknown buyer: " + customer);
        }
        if(!isInArray(items, item)){
            throw new ProductException("Unknown item" + item);
        }
        if(amount<0 ||amount>10){
            throw new AmountException("Uncorrect amout" + amount);
        }
        return  new Order(customer,item,amount);
    }

    private static <T> boolean isInArray(T[] items, T item) {
        for(T t: items){
            if(t.equals(item))return true;
        }
        return false;
    }
}
