public class Pants extends ClothingItem {
    private String fitType;
    private int lengthCm;

    public Pants(int itemId, String brand, String size, double price, int stock, String fitType, int lengthCm) {
        super(itemId, brand, size, price, stock);
        this.fitType = fitType;
        this.lengthCm = lengthCm;
    }

    @Override
    public String getCategory() {
        return "Pants";
    }

    @Override
    public void workAction() {
        System.out.println("Pants #" + itemId + " are placed on a shelf (fit: " + fitType + ").");
    }

    public void hem(int newLengthCm) {
        if (newLengthCm > 0) {
            lengthCm = newLengthCm;
            System.out.println("Pants #" + itemId + " hemmed to " + lengthCm + " cm.");
        }
    }

    public boolean isSlimFit() {
        return fitType != null && fitType.equalsIgnoreCase("slim");
    }

    @Override
    public String toString() {
        return super.toString() + ", Fit=" + fitType + ", Length=" + lengthCm + "cm";
    }
}
