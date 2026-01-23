import java.util.Scanner;

public class MenuManager implements Menu {
    private static final Scanner sc = new Scanner(System.in);

    @Override
    public void displayMenu() {
        System.out.println("\n=== CLOTHING STORE MANAGEMENT SYSTEM ===");
        System.out.println("1. Add General Clothing Item");
        System.out.println("2. Add Shirt");
        System.out.println("3. Add Pants");
        System.out.println("4. View All Items");
        System.out.println("5. Show All Items");
        System.out.println("6. View Shirts Only");
        System.out.println("7. View Pants Only");
        System.out.println("8. Sell One Item by ID");
        System.out.println("9. Apply Discount by ID");
        System.out.println("0. Exit");
    }

    @Override
    public void run() {
        while (true) {
            displayMenu();
            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1 -> addGeneralItem();
                case 2 -> addShirt();
                case 3 -> addPants();
                case 4 -> viewAllItems();
                case 5 -> makeAllWork();
                case 6 -> viewShirtsOnly();
                case 7 -> viewPantsOnly();
                case 8 -> sellById();
                case 9 -> discountById();
                case 0 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private void addGeneralItem() {
        // Logic for adding general clothing item
    }

    private void addShirt() {
        // Logic for adding shirt item
    }

    private void addPants() {
        // Logic for adding pants item
    }

    private void viewAllItems() {
        // Logic for viewing all items
    }

    private void makeAllWork() {
        // Logic for making all items work
    }

    private void viewShirtsOnly() {
        // Logic for viewing only shirts
    }

    private void viewPantsOnly() {
        // Logic for viewing only pants
    }

    private void sellById() {
        // Logic for selling item by ID
    }

    private void discountById() {
        // Logic for applying discount by ID
    }

    private int readInt(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Please enter an integer.");
            }
        }
    }
}
