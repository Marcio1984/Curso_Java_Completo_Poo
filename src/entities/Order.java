package entities;

import entities.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private LocalDateTime moment;
    private OrderStatus status;

    private List<OrderItem> items = new ArrayList<OrderItem>();

    public Order(){
    }

    public Order(LocalDateTime moment, OrderStatus status) {
        this.moment = moment;
        this.status = status;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void addItem(OrderItem item){
        items.add(item);
    }

    public void removeItem(OrderItem item){
        items.remove(item);
    }

    public double total(){
        double sum = 0.f;
        for (OrderItem c : items){
            sum += c.subTotal();
        }return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
      for (OrderItem c : items) {
              sb.append(c.getProduct().getName());
                    sb.append(", $");
                    sb.append(String.format("%.2f", c.getPrice()));
                    sb.append(", Quantity: ");
                    sb.append(c.getQuantity());
                    sb.append(", Subtotal: $");
                    sb.append(String.format("%.2f", c.subTotal()));
                    sb.append("\n");
        }
        return sb.toString();
    }
}