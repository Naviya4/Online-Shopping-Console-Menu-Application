public class Clothing extends Product{

    private char size;
    private String color;

    public Clothing(char product_ID, String product_Name, int numAvailableItems, float price, char size, String color) {
        super(product_ID, product_Name, numAvailableItems, price);
        this.size = size;
        this.color = color;
    }

    public char getSize() {
        return size;
    }

    public void setSize(char size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}