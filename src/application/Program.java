package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Birth date (DD/MM/YYYY): ");
        String date = sc.next();
        LocalDate birthDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Client client = new Client(name, email, birthDate);

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        String status = sc.next();
        System.out.print("How many items to this order? ");
        int n = sc.nextInt();
        Order order = new Order(LocalDateTime.now(), OrderStatus.valueOf(status));
        for (int i = 1; i <= n; i++){
            System.out.println("Enter #" + i + " item data:");
            System.out.print("Product name: ");
            String nameProduct = sc.next();
            System.out.print("Product price: ");
            Double price = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();
            OrderItem orderItem = new OrderItem(quantity, price, new Product(nameProduct, price));
            order.addItem(orderItem);
        }

        System.out.println();

        System.out.println("ORDER SUMMARY:");
        System.out.println("Order moment: " + order.getMoment().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
        System.out.println("Order status: " + order.getStatus());
        System.out.println("Client: " + client);
        System.out.println("Order items:");
        System.out.println(order);
        System.out.printf("Total price: $%.2f", order.total());

        sc.close();

    }
}
