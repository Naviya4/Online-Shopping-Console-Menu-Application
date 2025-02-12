public class Electronics extends Product{

    private String brand;
    private String warranty;

    public Electronics(String productID, String productName, int numAvailableItems, double price, String brand, String warranty) {
        super(productID, productName, numAvailableItems, price);
        this.brand = brand;
        this.warranty = warranty;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    @Override
    public String getProductType() { return "Electronics"; }

    @Override
    public String getProductDetails() {
        return "Product ID: " + getProductID() + ", Product Name: " + getProductName() + ", Price: " + getPrice() + ", Brand: " + brand + ", Warranty: " + warranty;
    }

    @Override
    public String toFileFormat() {
        return String.format("%-17s %-13s %-23s %-15d %-27.2f %-48s %-20s",
                "Electronics", getProductID(), getProductName(),
                getNumAvailableItems(), getPrice(), brand, warranty);
    }


}
