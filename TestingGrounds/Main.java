import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();

        System.out.println("=== Welcome to Kaon ta Bai ^_^ Billing System ===");
        System.out.print("Please enter your name: ");
        String name = scanner.nextLine().trim();

        String choice = "";
        while (true) {
            System.out.println("\nHello, " + name + "! What do you want to do?");
            System.out.println("1. Make an Order");
            System.out.println("2. View Menu");
            System.out.println("3. Exit");
            System.out.print("Enter choice (1-3): ");

            choice = scanner.nextLine().trim();

            if (choice.length() > 0) {
                choice = choice.substring(0, 1);
            }

            if (choice.equals("1")) {
                clearScreen();
                Order order = new Order(menu);
                order.takeOrder();
                order.printReceipt();

                String again = "";
                while (true) {
                    System.out.print("Do you want to make another order? (yes/no): ");
                    again = scanner.nextLine().trim().toLowerCase();

                    if (again.equals("yes")) {
                        clearScreen();
                        order = new Order(menu);
                        order.takeOrder();
                        order.printReceipt();
                    } else if (again.equals("no")) {
                        clearScreen();
                        break;
                    } else {
                        System.out.println("Invalid input. Please type 'yes' or 'no'.");
                    }
                }
            } else if (choice.equals("2")) {
                clearScreen();
                System.out.println("=== Menu ===");
                menu.displayMenu();
            } else if (choice.equals("3")) {
                System.out.println("Goodbye, " + name + "!");
                System.exit(0);
            } else {
                System.out.println("Invalid input. Try again.");
            }
        }
    }

    public static void clearScreen() {
    try {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    } catch (Exception e) {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
}
