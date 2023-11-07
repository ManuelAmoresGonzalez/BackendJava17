package org.example.app;

import org.example.model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Product p1 = new Product("Ps4", 12);
        Product p2 = new Product("Ps4", 12);
        System.out.println(p1.equals(p2));
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter client data: ");
        String name = sc.nextLine();
        System.out.println("Enter email data: ");
        String email = sc.nextLine();
        System.out.println("Enter birthdate data: (YYY-MM-DD)");
        LocalDate birthDate = LocalDate.parse(sc.nextLine());

        Client client = new Client(name, email, birthDate);
        System.out.println(client);

        System.out.println("Enter order data");

        System.out.println("Status");
        OrderStatus status = OrderStatus.valueOf(sc.nextLine());
        Order order = new Order(LocalDateTime.now(), status, client, new ArrayList<>());

        System.out.println("How many items to this order?");
        int numberOfItems = sc.nextInt();

        for(int i = 1; i <= numberOfItems; i++){
            System.out.println("Enter # " + i +" tem data: ");
            System.out.println("Product name");
            sc.nextLine();
            String productName = sc.nextLine();
            System.out.println("Product price");
            double price = sc.nextDouble();
            System.out.println("Product quantity");
            int quantity = sc.nextInt();
            Product product = new Product(productName,price);
            OrderItem orderItem = new OrderItem(quantity, price, product);
            order.additem(orderItem);
        }
        System.out.println("Order Summary");
        System.out.println(order);
    }
}
