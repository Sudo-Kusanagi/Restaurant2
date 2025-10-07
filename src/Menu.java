// Menu.java
// Kelas untuk merepresentasikan item menu di restoran
// Menunjukkan: Class, Object, Constructor, Static Variables

public class Menu {
    // Static variable - menghitung total menu yang dibuat
    private static int totalMenuItems = 0;

    // Instance variables
    private String itemName;
    private double price;
    private String category;
    private boolean available;

    // Constructor default
    public Menu() {
        this.itemName = "Unknown";
        this.price = 0.0;
        this.category = "General";
        this.available = true;
        totalMenuItems++;
    }

    // Constructor dengan parameter
    public Menu(String itemName, double price, String category) {
        this.itemName = itemName;
        this.price = price;
        this.category = category;
        this.available = true;
        totalMenuItems++;
    }

    // Constructor overloading
    public Menu(String itemName, double price, String category, boolean available) {
        this.itemName = itemName;
        this.price = price;
        this.category = category;
        this.available = available;
        totalMenuItems++;
    }

    // Getters dan Setters
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    // Static method untuk mendapatkan total menu items
    public static int getTotalMenuItems() {
        return totalMenuItems;
    }

    // Method untuk menampilkan info menu
    public void displayInfo() {
        System.out.println("Item: " + itemName + " | Kategori: " + category +
                " | Harga: Rp" + price + " | Status: " +
                (available ? "Tersedia" : "Habis"));
    }
}