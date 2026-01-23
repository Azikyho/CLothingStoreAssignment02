import java.util.ArrayList;
import java.util.Scanner;

public class MenuManager implements Menu {
    private static final Scanner sc = new Scanner(System.in);
    private static final ArrayList<ClothingItem> inventory = new ArrayList<>();

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
        int id = readInt("Item ID: ");
        String brand = readString("Brand: ");
        String size = readString("Size (S/M/L/XL): ");
        double price = readDouble("Price: ");
        int stock = readInt("Stock: ");

        System.out.println("Choose item type (1 for Shirt, 2 for Pants): ");
        int itemType = readInt("Enter 1 or 2: ");

        ClothingItem item = null;
        if (itemType == 1) {
            String sleeveType = readString("Sleeve Type (short/long): ");
            String fabric = readString("Fabric (cotton/polyester): ");
            item = new Shirt(id, brand, size, price, stock, sleeveType, fabric);
        } else if (itemType == 2) {
            String fitType = readString("Fit Type (slim/regular/loose): ");
            int lengthCm = readInt("Length (cm): ");
            item = new Pants(id, brand, size, price, stock, fitType, lengthCm);
        }

        if (item != null) {
            inventory.add(item);
            System.out.println("Added: " + item);
        } else {
            System.out.println("Invalid option. Item not added.");
        }
    }

    private void addShirt() {
        int id = readInt("Item ID: ");
        String brand = readString("Brand: ");
        String size = readString("Size: ");
        double price = readDouble("Price: ");
        int stock = readInt("Stock: ");
        String sleeveType = readString("Sleeve Type (short/long): ");
        String fabric = readString("Fabric (cotton/polyester): ");

        Shirt shirt = new Shirt(id, brand, size, price, stock, sleeveType, fabric);
        inventory.add(shirt);
        System.out.println("Added: " + shirt);
    }

    private void addPants() {
        int id = readInt("Item ID: ");
        String brand = readString("Brand: ");
        String size = readString("Size: ");
        double price = readDouble("Price: ");
        int stock = readInt("Stock: ");
        String fitType = readString("Fit Type (slim/regular/loose): ");
        int lengthCm = readInt("Length (cm): ");

        Pants pants = new Pants(id, brand, size, price, stock, fitType, lengthCm);
        inventory.add(pants);
        System.out.println("Added: " + pants);
    }

    private void viewAllItems() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        System.out.println("\n--- ALL ITEMS ---");
        for (ClothingItem item : inventory) {
            System.out.println(item);
        }
    }

    private void makeAllWork() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        System.out.println("\n--- ACTION / WORK DEMO ---");
        for (ClothingItem item : inventory) {
            item.workAction();
        }
    }

    private void viewShirtsOnly() {
        System.out.println("\n--- SHIRTS ONLY ---");
        boolean found = false;

        for (ClothingItem item : inventory) {
            if (item instanceof Shirt) {
                found = true;
                Shirt s = (Shirt) item;
                System.out.println(s);
                s.iron();
                s.fold();
            }
        }

        if (!found) System.out.println("No shirts found.");
    }

    private void viewPantsOnly() {
        System.out.println("\n--- PANTS ONLY ---");
        boolean found = false;

        for (ClothingItem item : inventory) {
            if (item instanceof Pants) {
                found = true;
                Pants p = (Pants) item;
                System.out.println(p);
                p.hem(p.lengthCm + 5);
            }
        }

        if (!found) System.out.println("No pants found.");
    }

    private void sellById() {
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

    private void discountById() {
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

    private ClothingItem findById(int id) {
        for (ClothingItem item : inventory) {
            if (item.itemId == id) return item;
        }
        return null;
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

    private double readDouble(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private String readString(String msg) {
        System.out.print(msg);
        return sc.nextLine().trim();
    }
}
