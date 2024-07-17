
public class TestBehaviorPattern {
    public static void main(String[] args) {
        Order order = new Order();

        OrderObserver priceObserver = new PriceObserver();
        OrderObserver quantityObserver = new QuantityObserver();

        order.attach(priceObserver);
        order.attach(quantityObserver);

        order.addItem("Item 1", 50);
        order.addItem("Item 2", 60);
        order.addItem("Item 3", 40);
        order.addItem("Item 4", 30);
        order.addItem("Item 5", 10);
        order.addItem("Item 6", 20);

        System.out.println(order);
    }
}
