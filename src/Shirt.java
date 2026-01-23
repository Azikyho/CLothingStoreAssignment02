public class Shirt extends ClothingItem {
    private String sleeveType;
    private String fabric;

    public Shirt(int itemId, String brand, String size, double price, int stock, String sleeveType, String fabric) {
        super(itemId, brand, size, price, stock);
        this.sleeveType = sleeveType;
        this.fabric = fabric;
    }

    @Override
    public String getCategory() {
        return "Shirt";
    }

    @Override
    public void workAction() {
        System.out.println("Shirt #" + itemId + " is hung neatly (sleeves: " + sleeveType + ").");
    }

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
