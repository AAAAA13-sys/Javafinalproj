import java.util.Scanner;

public class Order {
    private Menu menu;
    private int[] foodQty;
    private int[] drinkQty;

    public Order(Menu menu) {
        this.menu = menu;
        foodQty = new int[6];
        drinkQty = new int[3];
    }

    public void takeOrder() {
    Scanner scanner = new Scanner(System.in);
    String code = "";

    System.out.println("\n--- Menu Reference ---");
    menu.displayMenu();
    System.out.println("\nType the item code (like m1 or d2). Type 'x' to finish your order.");

    while (true) {
        System.out.print("Enter code: ");
        code = scanner.next().toLowerCase();

        if (code.equals("x")) {
            break;
        }

        if (code.length() > 2) {
            code = code.substring(0, 2);
        }

        if (code.equals("m1")) {
            System.out.print("Enter quantity: ");
            if (scanner.hasNextInt()) {
                int qty = scanner.nextInt();
                if (qty >= 0) {
                    foodQty[0] += qty;
                } else {
                    System.out.println("Quantity must be positive.");
                }
            } else {
                System.out.println("Invalid input.");
                scanner.next();
            }
        } 
        else if (code.equals("m2")) {
            System.out.print("Enter quantity: ");
            if (scanner.hasNextInt()) {
                int qty = scanner.nextInt();
                if (qty >= 0) {
                    foodQty[1] += qty;
                } else {
                    System.out.println("Quantity must be positive.");
                }
            } else {
                System.out.println("Invalid input.");
                scanner.next();
            }
        }

        else {
            System.out.println("Invalid code. Try again.");
        }
    }
    }


private int getQuantity(Scanner scanner) {
    while (true) {
        System.out.print("Enter quantity (1 or more): ");
        String input = scanner.nextLine().trim();
        try {
            int qty = Integer.parseInt(input);
            if (qty >= 1) {
                return qty;
            } else {
                System.out.println("Quantity must be 1 or more.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }
}
    public void printReceipt() {
        double total = 0;
        Food[] foods = menu.getFoods();
        Drink[] drinks = menu.getDrinks();

        System.out.println("\n================== RECEIPT =====================");
        System.out.printf("%-25s %-5s %-10s %-10s\n", "Item", "Qty", "Price", "Total");
        System.out.println("--------------------------------------------------");

        for (int i = 0; i < foods.length; i++) {
            if (foodQty[i] > 0) {
                double cost = foodQty[i] * foods[i].getPrice();
                System.out.printf("%-25s %-5d %-10.2f %-10.2f\n",
                    foods[i].getName(), foodQty[i], foods[i].getPrice(), cost);
                total += cost;
            }
        }

        for (int i = 0; i < drinks.length; i++) {
            if (drinkQty[i] > 0) {
                double cost = drinkQty[i] * drinks[i].getPrice();
                System.out.printf("%-25s %-5d %-10.2f %-10.2f\n",
                    drinks[i].getName(), drinkQty[i], drinks[i].getPrice(), cost);
                total += cost;
            }
        }

        System.out.println("--------------------------------------------------");
        System.out.printf("%-25s %-5s %-10s %-10.2f\n", "", "", "Total:", total);
        System.out.println("=================================================");
    }
}
