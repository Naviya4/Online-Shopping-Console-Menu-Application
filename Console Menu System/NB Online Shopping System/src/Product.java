abstract class Product {

    private String productID;
    private String productName;
    private int numAvailableItems;
    private double price;

    public Product(String productID, String productName, int numAvailableItems, double price) {
        this.productID = productID;
        this.productName = productName;
        this.numAvailableItems = numAvailableItems;
        this.price = price;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getNumAvailableItems() {
        return numAvailableItems;
    }

    public void setNumAvailableItems(int numAvailableItems) {
        this.numAvailableItems = numAvailableItems;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract String getProductType();
    public abstract String getProductDetails();
    public abstract String toFileFormat();
}
