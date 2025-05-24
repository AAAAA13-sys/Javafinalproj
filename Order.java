import java.util.Scanner;

public class Order {
    private Menu menu;
    private int[] foodQty;
    private int[] drinkQty;
    clearscreen cls = new clearscreen();

    public Order(Menu menu) {
        this.menu = menu;
        foodQty = new int[6];
        drinkQty = new int[3];
    }

    public void takeOrder() {
        Scanner scanner = new Scanner(System.in);
        String code = "";

        System.out.println("                             --- Menu Reference ---");
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
            scanner.nextLine();
            if (code.equals("m1")) {
                System.out.println("m1      Adobong Manok is chosen.");
                System.out.print("Enter quantity: ");
                if (scanner.hasNextInt()) {
                    int qty = scanner.nextInt();
                    if (qty >= 0) {
                        foodQty[0] += qty;
                        System.out.println("m1 "+ menu.getFoods()[0].getName() + " is added.");
                    } else {
                        System.out.println("Quantity must be positive.");
                    }
                } else {
                    System.out.println("Invalid input.");
                    scanner.next();
                }
            } else if (code.equals("m2")) {
                System.out.println("m2      Sinigang na Baboy is chosen.");
                System.out.print("Enter quantity: ");
                if (scanner.hasNextInt()) {
                    int qty = scanner.nextInt();
                    if (qty >= 0) {
                        foodQty[1] += qty;
                        System.out.println("m2 "+ menu.getFoods()[1].getName() + " is added.");
                    } else {
                        System.out.println("Quantity must be positive.");
                    }
                } else {
                    System.out.println("Invalid input.");
                    scanner.next();
                }
            } else if (code.equals("m3")) {
                System.out.println("m3      Paksiw na Bangus is chosen.");
                System.out.print("Enter quantity: ");
                if (scanner.hasNextInt()) {
                    int qty = scanner.nextInt();
                    if (qty >= 0) {
                        foodQty[2] += qty;
                        System.out.println("m3 "+ menu.getFoods()[2].getName() + " is added.");
                    } else {
                        System.out.println("Quantity must be positive.");
                    }
                } else {
                    System.out.println("Invalid input.");
                    scanner.next();
                }
            } else if (code.equals("m4")) {
                System.out.println("m4      Fried Galunggong is chosen.");
                System.out.print("Enter quantity: ");
                if (scanner.hasNextInt()) {
                    int qty = scanner.nextInt();
                    if (qty >= 0) {
                        foodQty[3] += qty;
                        System.out.println("m4 "+ menu.getFoods()[3].getName() + " is added.");
                    } else {
                        System.out.println("Quantity must be positive.");
                    }
                } else {
                    System.out.println("Invalid input.");
                    scanner.next();
                }
            } else if (code.equals("m5")) {
                System.out.println("m5      Bicol Express is chosen.");
                System.out.print("Enter quantity: ");
                if (scanner.hasNextInt()) {
                    int qty = scanner.nextInt();
                    if (qty >= 0) {
                        foodQty[4] += qty;
                        System.out.println("m5 "+ menu.getFoods()[4].getName() + " is added.");
                    } else {
                        System.out.println("Quantity must be positive.");
                    }
                } else {
                    System.out.println("Invalid input.");
                    scanner.next();
                }
            }

            else if (code.equals("m6")) {
                System.out.println("m6      Rice is chosen.");
                System.out.print("Enter quantity: ");
                if (scanner.hasNextInt()) {
                    int qty = scanner.nextInt();
                    if (qty >= 0) {
                        foodQty[5] += qty;
                        System.out.println("m6 "+ menu.getFoods()[5].getName() + " is added.");
                    } else {
                        System.out.println("Quantity must be positive.");
                    }
                } else {
                    System.out.println("Invalid input.");
                    scanner.next();
                }
            }

            else if (code.equals("d1")) {
                System.out.println("d1      Sprite (bottle) is chosen.");
                System.out.print("Enter quantity: ");
                if (scanner.hasNextInt()) {
                    int qty = scanner.nextInt();
                    if (qty >= 0) {
                        drinkQty[0] += qty;
                        System.out.println("d1 "+ menu.getDrinks()[0].getName() + " is added.");
                    } else {
                        System.out.println("Quantity must be positive.");
                    }
                } else {
                    System.out.println("Invalid input.");
                    scanner.next();
                }
            }

            else if (code.equals("d2")) {
                System.out.println("d2      Coke (bottle) is chosen.");
                System.out.print("Enter quantity: ");
                if (scanner.hasNextInt()) {
                    int qty = scanner.nextInt();
                    if (qty >= 0) {
                        drinkQty[1] += qty;
                        System.out.println("d2 "+ menu.getDrinks()[1].getName() + " is added.");
                    } else {
                        System.out.println("Quantity must be positive.");
                    }
                } else {
                    System.out.println("Invalid input.");
                    scanner.next();
                }
            }
            
            else if (code.equals("d3")) {
                System.out.println("d3      Royal (bottle) is chosen.");
                System.out.print("Enter quantity: ");
                if (scanner.hasNextInt()) {
                    int qty = scanner.nextInt();
                    if (qty >= 0) {
                        drinkQty[2] += qty;
                        System.out.println("d3 "+ menu.getDrinks()[2].getName() + " is added.");
                    } else {
                        System.out.println("Quantity must be positive.");
                    }
                } else {
                    System.out.println("Invalid input.");
                    scanner.next();
                }
            } else {
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

    public void viewOrders() {
        Food[] foods = menu.getFoods();
        Drink[] drinks = menu.getDrinks();
        System.out.printf("                        " + "%-25s %-5s %-10s\n", "Item", "Qty", "Price");
        System.out.println("                        --------------------------------------");
        boolean hasOrders = false;
        for (int i = 0; i < foods.length; i++) {
            if (foodQty[i] > 0) {
                hasOrders = true;
                System.out.printf("                        " + "%-25s %-5d %-10.2f\n",
                        foods[i].getName(), foodQty[i], foods[i].getPrice());
            }
        }

        for (int i = 0; i < drinks.length; i++) {
            if (drinkQty[i] > 0) {
                hasOrders = true;
                System.out.printf("                        " + "%-25s %-5d %-10.2f\n",
                        drinks[i].getName(), drinkQty[i], drinks[i].getPrice());
            }
        }
        if (!hasOrders) {
            System.out.println("                        No items in the current order yet.");
        }
        System.out.println("                        =====================================\n");
    }

    public void printReceipt() {
        cls.clearScreen();
        double total = 0;
        Food[] foods = menu.getFoods();
        Drink[] drinks = menu.getDrinks();
        System.out.println("                        ================== RECEIPT =====================");
        System.out.println();
        System.out.printf("                        " + "%-25s %-5s %-10s %-10s\n", "Item", "Qty", "Price", "Total");
        System.out.println("                        ------------------------------------------------");
        for (int i = 0; i < foods.length; i++) {
            if (foodQty[i] > 0) {
                double cost = foodQty[i] * foods[i].getPrice();
                System.out.printf("                        " + "%-25s %-5d %-10.2f %-10.2f\n",
                        foods[i].getName(), foodQty[i], foods[i].getPrice(), cost);
                total += cost;
            }
        }
        for (int i = 0; i < drinks.length; i++) {
            if (drinkQty[i] > 0) {
                double cost = drinkQty[i] * drinks[i].getPrice();
                System.out.printf("                        " + "%-25s %-5d %-10.2f %-10.2f\n",
                        drinks[i].getName(), drinkQty[i], drinks[i].getPrice(), cost);
                total += cost;
            }
        }
        System.out.println("                        ------------------------------------------------");
        System.out.printf("                        " + "%-25s %-5s %-10s %-10.2f\n", "", "", "Total:", total);
        System.out.println("                        ================================================");
        System.out.println();
    }

    public double getTotal() {
        double total = 0;
        Food[] foods = menu.getFoods();
        Drink[] drinks = menu.getDrinks();
        for (int i = 0; i < foods.length; i++) {
            total += foodQty[i] * foods[i].getPrice();
        }
        for (int i = 0; i < drinks.length; i++) {
            total += drinkQty[i] * drinks[i].getPrice();
        }
        return total;
    }

    public void updateOrder() {
        Scanner scanner = new Scanner(System.in);
        Food[] foods = menu.getFoods();
        Drink[] drinks = menu.getDrinks();
        while (true) {
            viewOrders();
            System.out.println("Enter the item code to update quantity (e.g., m1 or d2), or 'x' to cancel:");
            String code = scanner.next().toLowerCase();
            scanner.nextLine();
            if (code.equals("x")) {
                break;
            }
            int index = -1;
            if (code.startsWith("m") && code.length() == 2) {
                try {
                    index = Integer.parseInt(code.substring(1)) - 1;
                    if (index >= 0 && index < foodQty.length) {
                        System.out.print("Enter new quantity for " + foods[index].getName() + ": ");
                        int qty = scanner.nextInt();
                        scanner.nextLine();
                        if (qty >= 0) {
                            foodQty[index] = qty;
                            System.out.println("Updated successfully.");
                        } else {
                            System.out.println("Quantity must be 0 or more.");
                        }
                    } else {
                        System.out.println("Invalid food code.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid code format.");
                }
            } else if (code.startsWith("d") && code.length() == 2) {
                try {
                    index = Integer.parseInt(code.substring(1)) - 1;
                    if (index >= 0 && index < drinkQty.length) {
                        System.out.print("Enter new quantity for " + drinks[index].getName() + ": ");
                        int qty = scanner.nextInt();
                        scanner.nextLine();
                        if (qty >= 0) {
                            drinkQty[index] = qty;
                            System.out.println("Updated successfully.");
                        } else {
                            System.out.println("Quantity must be 0 or more.");
                        }
                    } else {
                        System.out.println("Invalid drink code.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid code format.");
                }
            } else {
                System.out.println("Invalid item code.");
            }
        }
    }

}
