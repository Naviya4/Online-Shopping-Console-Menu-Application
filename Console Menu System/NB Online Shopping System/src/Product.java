abstract class Product {

    private char product_ID;
    private String product_Name;
    private int numAvailableItems;
    private float price;

    public Product(char product_ID, String product_Name, int numAvailableItems, float price) {
        this.product_ID = product_ID;
        this.product_Name = product_Name;
        this.numAvailableItems = numAvailableItems;
        this.price = price;
    }

    public char getProduct_ID() {
        return product_ID;
    }

    public void setProduct_ID(char product_ID) {
        this.product_ID = product_ID;
    }

    public String getProduct_Name() {
        return product_Name;
    }

    public void setProduct_Name(String product_Name) {
        this.product_Name = product_Name;
    }

    public int getNumAvailableItems() {
        return numAvailableItems;
    }

    public void setNumAvailableItems(int numAvailableItems) {
        this.numAvailableItems = numAvailableItems;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
