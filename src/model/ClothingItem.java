package model;

public abstract class ClothingItem {
    protected int itemId;
    protected String brand;
    protected String size;
    protected double price;
    protected int stock;

    public ClothingItem(int itemId, String brand, String size, double price, int stock) {
        this.itemId = itemId;
        this.brand = brand;
        this.size = size;
        this.price = price;
        this.stock = stock;
    }

    public int getItemId() {
        return itemId;
    }

    public abstract String getCategory();

    public void workAction() {
        System.out.println("Item #" + itemId + " is displayed on the rack.");
    }

    public boolean sellOne() {
        if (stock <= 0) return false;
        stock--;
        return true;
    }

    public void restock(int qty) {
        if (qty > 0) stock += qty;
    }

    public void applyDiscount(double percent) {
        if (percent > 0 && percent <= 100) {
            price = price * (1 - percent / 100.0);
        }
    }

    @Override
    public String toString() {
        return "[" + getCategory() + "] ID=" + itemId +
                ", Brand=" + brand +
                ", Size=" + size +
                ", Price=" + price +
                ", Stock=" + stock;
    }
}
