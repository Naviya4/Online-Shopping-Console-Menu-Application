import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class NBShoppingManager implements ShoppingManager {

    private List<Product> products = new ArrayList<>();
    private static final int MAX_PRODUCTS = 50;
    private static final String FILE_NAME = "products.txt";

    @Override
    public void addProduct(Product product) {
        if (products.size() < MAX_PRODUCTS) {
            products.add(product);
            System.out.println("Product added successfully.");
        } else {
            System.out.println("Cannot add more products. Maximum limit reached.");
        }
    }

    @Override
    public void deleteProduct(String productID) {
        products.removeIf(product -> product.getProductID().equals(productID));
        System.out.println("Product deleted successfully.");
    }

    @Override
    public void printProductList() {
        products.sort(Comparator.comparing(Product::getProductID));
        for (Product product : products) {
            System.out.println(product.getProductType() + " | " + product.getProductDetails());
        }
    }

    @Override
    public void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            // Writing the header row (only once)
            writer.println("|   Type   |" + "   Product ID   |" + "   Product Name   |" + "   Available Items   |" + "   Price   |" + "   Brand if Electronics / Size if Clothing   |" + "   Warranty if Electronics / Color if Clothing   |");

            // Writing product details
            for (Product product : products) {
                writer.println(product.toFileFormat());
            }
            System.out.println("Products saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving products.");
        }
    }

    @Override
    public void loadFromFile() {
        products.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue; // Skip empty lines

                try {
                    String type = line.substring(0, 17).trim();
                    String id = line.substring(17, 30).trim();
                    String name = line.substring(30, 53).trim();
                    int availableItems = Integer.parseInt(line.substring(53, 68).trim());
                    double price = Double.parseDouble(line.substring(68, 95).trim());
                    String attr1 = line.substring(95, 143).trim();
                    String attr2 = line.substring(143, 163).trim();

                    if (type.equals("Electronics")) {
                        products.add(new Electronics(id, name, availableItems, price, attr1, attr2));
                    } else if (type.equals("Clothing")) {
                        products.add(new Clothing(id, name, availableItems, price, attr1, attr2));
                    }
                } catch (Exception e) {
                    System.out.println("Skipping invalid line: " + line);
                }
            }
            System.out.println("Products loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading products: " + e.getMessage());
        }
    }




    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        // Load products from file only once when the application starts
        loadFromFile();

        while (true) {
            System.out.println("\n1. Add Product\n2. Delete Product\n3. Print Products\n4. Save Products\n5. Load Products\n6. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter Product Type (Electronics/Clothing): ");
                    String type = scanner.nextLine();
                    System.out.print("Enter Product ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Available Items: ");
                    int available = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    if (type.equalsIgnoreCase("Electronics")) {
                        System.out.print("Enter Brand: ");
                        String brand = scanner.nextLine();
                        System.out.print("Enter Warranty Period: ");
                        String warranty = scanner.nextLine();
                        addProduct(new Electronics(id, name, available, price, brand, warranty));
                    } else if (type.equalsIgnoreCase("Clothing")) {
                        System.out.print("Enter Size: ");
                        String size = scanner.nextLine();
                        System.out.print("Enter Color: ");
                        String color = scanner.nextLine();
                        addProduct(new Clothing(id, name, available, price, size, color));
                    }
                    break;
                case 2:
                    System.out.print("Enter Product ID to delete: ");
                    deleteProduct(scanner.nextLine());
                    break;
                case 3:
                    printProductList();
                    break;
                case 4:
                    saveToFile();
                    break;
                case 5:
                    loadFromFile();
                    break;
                case 6:
                    return;
            }
        }
    }

    public static void main(String[] args) {
        NBShoppingManager manager = new NBShoppingManager();
        manager.displayMenu();
    }
}