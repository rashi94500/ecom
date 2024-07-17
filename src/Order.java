import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderObserver> observers = new ArrayList<>();
    private List<String> items = new ArrayList<>();
    private double totalPrice = 0.0;
    private int itemCount = 0;
    private double shippingCost = 10.0;

    public void attach(OrderObserver observer) {
        observers.add(observer);
    }

    public void detach(OrderObserver observer) {
        observers.remove(observer);
    }

    public void addItem(String item, double price) {
        items.add(item);
        totalPrice += price;
        itemCount++;
        notifyObservers();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getItemCount() {
        return itemCount;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    private void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public String toString() {
        return "Order : " +
                "\nYou have " + itemCount + "item(s)."+
                "\nThe shipping cost is : "+ shippingCost + "$."+
                "\nThe total price is : " + totalPrice + "$." ;
    }
}
