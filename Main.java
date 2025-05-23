import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        clearscreen cls = new clearscreen();
        ArrayList<Order> allOrders = new ArrayList<>();
        int orderCount = 0;
        System.out.println("                   === Welcome to Kaon ta Bai ^_^ Billing System ===");
        System.out.print("Please enter your name: ");
        String name = scanner.nextLine().trim();
        String choice = "";
        while (true) {
            System.out.println("\nHello, " + name + "! What do you want to do?");
            System.out.println("1. Make an Order");
            System.out.println("2. View Orders");
            System.out.println("3. Update Order");
            System.out.println("4. Exit");
            System.out.print("Enter choice (1-4): ");
            choice = scanner.nextLine().trim();
            if (choice.length() > 0) {
                choice = choice.substring(0, 1);
            }
            if (choice.equals("1")) {
                cls.clearScreen();
                Order order = new Order(menu);
                order.takeOrder();
                order.printReceipt();
                allOrders.add(order);
                orderCount++;
                String again = "";
                while (true) {
                    System.out.print("Do you want to make another order? (yes/no): ");
                    again = scanner.nextLine().trim().toLowerCase();
                    if (again.equals("yes")) {
                        cls.clearScreen();
                        order = new Order(menu);
                        order.takeOrder();
                        order.printReceipt();
                        allOrders.add(order);
                        orderCount++;
                    } else if (again.equals("no")) {
                        cls.clearScreen();
                        break;
                    } else {
                        System.out.println("Invalid input. Please type 'yes' or 'no'.");
                    }
                }
            } else if (choice.equals("2")) {
                cls.clearScreen();
                if (allOrders.isEmpty()) {
                    System.out.println("                        No orders have been made yet.\n");
                } else {
                    double grandTotal = 0;
                    for (int i = 0; i < allOrders.size(); i++) {
                        System.out.println("                        ========= ORDER #" + (i + 1) + " =========");
                        allOrders.get(i).viewOrders();
                        grandTotal += allOrders.get(i).getTotal();
                    }
                    System.out.printf("                        ======= GRAND TOTAL: %.2f ========\n\n", grandTotal);
                }
            } else if (choice.equals("3")) {
                cls.clearScreen();
                if (allOrders.isEmpty()) {
                    System.out.println("                        No orders available to update.\n");
                } else {
                    System.out.print("Enter the order number to update (1 to " + allOrders.size() + "): ");
                    String input = scanner.nextLine();
                    try {
                        int orderNum = Integer.parseInt(input);
                        if (orderNum >= 1 && orderNum <= allOrders.size()) {
                            allOrders.get(orderNum - 1).updateOrder();
                            allOrders.get(orderNum - 1).printReceipt();
                        } else {
                            System.out.println("Invalid order number.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Must be a number.");
                    }
                }
            } else if (choice.equals("4")) {
                System.out.println("Goodbye, " + name + "!");
                System.exit(0);
            }
        }
    }
}
