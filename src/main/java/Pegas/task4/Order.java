package Pegas.task4;

public record Order(Customer customer,Item item,int counter) {
    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer +
                ", item=" + item +
                ", counter=" + counter +
                '}';
    }
}
