public class Shirt extends ClothingItem {
    // child adds 1-2 fields
    private String sleeveType;   // e.g., short/long
    private String fabric;       // e.g., cotton

    // Child: parameterized constructor using super() FIRST LINE
    public Shirt(int itemId, String brand, String size, double price, int stock,
                 String sleeveType, String fabric) {
        super(itemId, brand, size, price, stock); // MUST be first line
        this.sleeveType = sleeveType;
        this.fabric = fabric;
    }

    // Override минимум 2 методов
    @Override
    public String getCategory() {
        return "Shirt";
    }

    @Override
    public void workAction() {
        System.out.println("Shirt #" + itemId + " is hung neatly (sleeves: " + sleeveType + ").");
    }

    // Unique methods (2+)
    public void iron() {
        System.out.println("Shirt #" + itemId + " is ironed. Fabric: " + fabric);
    }

    public void fold() {
        System.out.println("Shirt #" + itemId + " is folded for storage.");
    }

    @Override
    public String toString() {
        return super.toString() + ", Sleeves=" + sleeveType + ", Fabric=" + fabric;
    }
}
