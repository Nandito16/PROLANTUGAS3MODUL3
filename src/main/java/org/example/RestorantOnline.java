package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RestorantOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Daftar menu
        List<MenuItem> menu = new ArrayList<>();
        menu.add(new MenuItem("Nasi Goreng", 15000));
        menu.add(new MenuItem("Mie Goreng", 17000));
        menu.add(new MenuItem("Ayam Bakar", 15000));
        menu.add(new MenuItem("Es Teh", 4000));
        menu.add(new MenuItem("Jus Jeruk", 10000));

        // Buat pesanan baru
        Order order = new Order();

        System.out.println("=== Daftar Menu ===");
        for (int i = 0; i < menu.size(); i++) {
            System.out.printf("%d. %s - Rp %.2f\n", i + 1, menu.get(i).name, menu.get(i).price);
        }

        // Input pesanan
        while (true) {
            System.out.print("Masukkan nomor menu (0 untuk selesai): ");
            int menuNumber = scanner.nextInt();

            if (menuNumber == 0) break;

            System.out.print("Masukkan jumlah: ");
            int quantity = scanner.nextInt();

            if (menuNumber > 0 && menuNumber <= menu.size()) {
                order.addItem(menu.get(menuNumber - 1), quantity);
            } else {
                System.out.println("Menu tidak valid.");
            }
        }

        // Tampilkan nota
        order.printReceipt();
    }
}

// Model untuk item menu
class MenuItem {
    String name;
    double price;

    MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

// Model untuk item pesanan
class OrderItem {
    MenuItem menuItem;
    int quantity;

    OrderItem(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    double getSubtotal() {
        return menuItem.price * quantity;
    }
}

// Model untuk mengelola pesanan
class Order {
    List<OrderItem> items;

    Order() {
        items = new ArrayList<>();
    }

    void addItem(MenuItem menuItem, int quantity) {
        items.add(new OrderItem(menuItem, quantity));
    }

    double calculateTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getSubtotal();
        }
        return total;
    }

    void printReceipt() {
        System.out.println("=== Nota Pemesanan ===");
        for (OrderItem item : items) {
            System.out.printf("%s x %d - Rp %.2f\n", item.menuItem.name, item.quantity, item.getSubtotal());
        }
        System.out.printf("Total: Rp %.2f\n", calculateTotal());
    }
}