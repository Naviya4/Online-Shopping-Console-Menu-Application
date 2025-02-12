public class Clothing extends Product{

    private String size;
    private String color;

    public Clothing(String productID, String productName, int numAvailableItems, double price, String size, String color) {
        super(productID, productName, numAvailableItems, price);
        this.size = size;
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getProductType() { return "Clothing"; }

    @Override
    public String getProductDetails() {
        return "Product ID: " + getProductID() + ", Product Name: " + getProductName() + ", Price: " + getPrice() + ", Size: " + size + ", Color: " + color;
    }

    @Override
    public String toFileFormat() {
        return String.format("%-17s %-13s %-23s %-15d %-27.2f %-48s %-20s",
                "Clothing", getProductID(), getProductName(),
                getNumAvailableItems(), getPrice(), size, color);
    }


}