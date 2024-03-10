package entities;

import entities.enums.OrderStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private LocalDate moment;
    private OrderStatus status;

    private List<OrderItem> items = new ArrayList<>();

    public Order(){
    }

    public Order(LocalDate moment, OrderStatus status) {
        this.moment = moment;
        this.status = status;
    }

    public LocalDate getMoment() {
        return moment;
    }

    public void setMoment(LocalDate moment) {
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

    @Override
    public String toString() {
        return "Order{" +
                "moment=" + moment +
                ", status=" + status +
                ", items=" + items +
                '}';
    }
}
