public interface ShoppingManager {

    void addProduct(Product product);
    void deleteProduct(String productID);
    void printProductList();
    void saveToFile();
    void loadFromFile();
}