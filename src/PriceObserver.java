public class PriceObserver implements OrderObserver {
    @Override
    public void update(Order order) {
        if (order.getTotalPrice() > 200) {
            double discount = 20;
            order.setPrice(order.getTotalPrice() - discount);
        }
    }
}
