import java.util.ArrayList;
import java.util.Scanner;

public class ClothingStoreApp {
    private static final ArrayList<ClothingItem> inventory = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> addGeneralItem();   // add parent object
                case 2 -> addShirt();         // add child #1
                case 3 -> addPants();         // add child #2
                case 4 -> viewAllItems();     // polymorphic view
                case 5 -> makeAllWork();      // polymorphism demo (call overridden action)
                case 6 -> viewShirtsOnly();   // instanceof + downcasting
                case 7 -> viewPantsOnly();    // instanceof + downcasting
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

    private static void printMenu() {
        System.out.println("\n=== CLOTHING STORE MANAGEMENT SYSTEM ===");
        System.out.println("1. Add General Clothing Item (Parent)");
        System.out.println("2. Add Shirt (Child 1)");
        System.out.println("3. Add Pants (Child 2)");
        System.out.println("4. View All Items (Polymorphic)");
        System.out.println("5. Show All Items (Work/Action Demo)");
        System.out.println("6. View Shirts Only (+ call Shirt unique methods)");
        System.out.println("7. View Pants Only (+ call Pants unique methods)");
        System.out.println("8. Sell One Item by ID");
        System.out.println("9. Apply Discount by ID");
        System.out.println("0. Exit");
        System.out.println("=======================================");
    }

    // ---------- Add items ----------
    private static void addGeneralItem() {
        int id = readInt("Item ID: ");
        String brand = readString("Brand: ");
        String size = readString("Size (S/M/L/XL etc): ");
        double price = readDouble("Price: ");
        int stock = readInt("Stock: ");

        ClothingItem item = new ClothingItem(id, brand, size, price, stock);
        inventory.add(item);
        System.out.println("Added: " + item);
    }

    private static void addShirt() {
        int id = readInt("Item ID: ");
        String brand = readString("Brand: ");
        String size = readString("Size: ");
        double price = readDouble("Price: ");
        int stock = readInt("Stock: ");

        String sleeveType = readString("Sleeve type (short/long): ");
        String fabric = readString("Fabric (cotton/polyester etc): ");

        Shirt shirt = new Shirt(id, brand, size, price, stock, sleeveType, fabric);
        inventory.add(shirt);
        System.out.println("Added: " + shirt);
    }

    private static void addPants() {
        int id = readInt("Item ID: ");
        String brand = readString("Brand: ");
        String size = readString("Size: ");
        double price = readDouble("Price: ");
        int stock = readInt("Stock: ");

        String fitType = readString("Fit type (slim/regular/loose): ");
        int lengthCm = readInt("Length (cm): ");

        Pants pants = new Pants(id, brand, size, price, stock, fitType, lengthCm);
        inventory.add(pants);
        System.out.println("Added: " + pants);
    }

    // ---------- Views / Polymorphism ----------
    private static void viewAllItems() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        System.out.println("\n--- ALL ITEMS ---");
        for (ClothingItem item : inventory) {
            System.out.println(item); // polymorphic toString + category
        }
    }

    private static void makeAllWork() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        System.out.println("\n--- ACTION / WORK DEMO ---");
        for (ClothingItem item : inventory) {
            item.workAction(); // polymorphism: разных классов — разное поведение
        }
    }

    // ---------- instanceof + downcasting ----------
    private static void viewShirtsOnly() {
        System.out.println("\n--- SHIRTS ONLY ---");
        boolean found = false;

        for (ClothingItem item : inventory) {
            if (item instanceof Shirt) {
                found = true;
                Shirt s = (Shirt) item;  // downcasting
                System.out.println(s);
                // call unique methods
                s.iron();
                s.fold();
            }
        }

        if (!found) System.out.println("No shirts found.");
    }

    private static void viewPantsOnly() {
        System.out.println("\n--- PANTS ONLY ---");
        boolean found = false;

        for (ClothingItem item : inventory) {
            if (item instanceof Pants) {
                found = true;
                Pants p = (Pants) item; // downcasting
                System.out.println(p);
                // call unique methods
                System.out.println("Slim fit? " + p.isSlimFit());
            }
        }

        if (!found) System.out.println("No pants found.");
    }

    // ---------- Extra menu actions ----------
    private static void sellById() {
        int id = readInt("Enter item ID to sell 1 unit: ");
        ClothingItem item = findById(id);
        if (item == null) {
            System.out.println("Item not found.");
            return;
        }
        boolean ok = item.sellOne();
        if (ok) System.out.println("Sold 1 unit. Now: " + item);
        else System.out.println("Out of stock!");
    }

    private static void discountById() {
        int id = readInt("Enter item ID to discount: ");
        ClothingItem item = findById(id);
        if (item == null) {
            System.out.println("Item not found.");
            return;
        }
        double percent = readDouble("Discount percent (0-100): ");
        item.applyDiscount(percent);
        System.out.println("Updated: " + item);
    }

    private static ClothingItem findById(int id) {
        for (ClothingItem item : inventory) {
            if (item.itemId == id) return item; // protected field accessible in same package
        }
        return null;
    }

    // ---------- Safe input ----------
    private static int readInt(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Please enter an integer.");
            }
        }
    }

    private static double readDouble(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Please enter a number.");
            }
        }
    }

    private static String readString(String msg) {
        System.out.print(msg);
        return sc.nextLine().trim();
    }
}
1