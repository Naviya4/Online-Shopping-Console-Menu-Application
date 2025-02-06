public class Electronics extends Product{

    private char brand;
    private char warranty;

    public Electronics(char product_ID, String product_Name, int numAvailableItems, float price, char brand, char warranty) {
        super(product_ID, product_Name, numAvailableItems, price);
        this.brand = brand;
        this.warranty = warranty;
    }

    public char getBrand() {
        return brand;
    }

    public void setBrand(char brand) {
        this.brand = brand;
    }

    public char getWarranty() {
        return warranty;
    }

    public void setWarranty(char warranty) {
        this.warranty = warranty;
    }
}
