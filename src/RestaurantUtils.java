// RestaurantUtils.java
// Utility class dengan static methods
// Menunjukkan: Static Methods, Passing by Value, Passing by Reference

public class RestaurantUtils {

    // Static method untuk menghitung tip yang disarankan
    // Menunjukkan: Passing by value (primitive type)
    public static double calculateSuggestedTip(double billAmount, int serviceQuality) {
        double tipPercentage = 0.0;

        // IF dengan multiple operands
        if (serviceQuality >= 9 && serviceQuality <= 10) {
            tipPercentage = 0.15; // Excellent service: 15%
        } else if (serviceQuality >= 7 && serviceQuality < 9) {
            tipPercentage = 0.10; // Good service: 10%
        } else if (serviceQuality >= 5 && serviceQuality < 7) {
            tipPercentage = 0.05; // Average service: 5%
        }

        return billAmount * tipPercentage;
    }

    // Static method untuk validasi nomor telepon
    // Menunjukkan: Passing by value (String)
    public static boolean isValidPhoneNumber(String phoneNumber) {
        // IF dengan multiple operands
        if (phoneNumber != null && phoneNumber.length() >= 10 && phoneNumber.length() <= 13) {
            return true;
        }
        return false;
    }

    // Static method untuk mencari menu berdasarkan nama
    // Menunjukkan: Passing by reference (Array dan Object), Loop dengan break
    public static Menu findMenuByName(Menu[] menuList, String name) {
        // Loop dengan break
        for (int i = 0; i < menuList.length; i++) {
            if (menuList[i] != null && menuList[i].getItemName().equalsIgnoreCase(name)) {
                return menuList[i]; // Return langsung (implicit break)
            }
        }
        return null; // Tidak ditemukan
    }

    // Static method untuk menampilkan menu berdasarkan kategori
    // Menunjukkan: Loop dengan continue
    public static void displayMenuByCategory(Menu[] menuList, String category) {
        System.out.println("\n=== Menu Kategori: " + category + " ===");
        boolean found = false;

        // Loop dengan continue
        for (int i = 0; i < menuList.length; i++) {
            // Continue jika menu null atau kategori tidak sesuai
            if (menuList[i] == null || !menuList[i].getCategory().equalsIgnoreCase(category)) {
                continue;
            }

            menuList[i].displayInfo();
            found = true;
        }

        if (!found) {
            System.out.println("Tidak ada menu dalam kategori ini.");
        }
    }

    // Static method untuk menghitung total pendapatan dari array order
    // Menunjukkan: Passing by reference (Array), Loop
    public static double calculateTotalRevenue(Order[] orders) {
        double totalRevenue = 0.0;

        // Loop menggunakan for-each (enhanced for)
        for (Order order : orders) {
            if (order != null && order.isPaid()) {
                totalRevenue += order.calculateTotal();
            }
        }

        return totalRevenue;
    }

    // Static method untuk memodifikasi harga menu (demonstrasi passing by reference)
    // Menunjukkan: Passing by reference - object bisa dimodifikasi
    public static void applyDiscount(Menu menu, double discountPercentage) {
        if (menu != null && discountPercentage > 0 && discountPercentage < 100) {
            double originalPrice = menu.getPrice();
            double newPrice = originalPrice * (1 - discountPercentage / 100);
            menu.setPrice(newPrice);
            System.out.println("Diskon " + discountPercentage + "% diterapkan pada " +
                    menu.getItemName() + ". Harga baru: Rp" + newPrice);
        }
    }

    // Static method untuk demonstrasi passing by value vs reference
    public static void demonstratePassingMechanism(int value, Menu menu) {
        System.out.println("\n=== Demonstrasi Passing Mechanism ===");

        // Passing by value - primitive type
        System.out.println("Nilai awal (int): " + value);
        value = 100; // Perubahan tidak mempengaruhi variabel asli
        System.out.println("Nilai setelah diubah di method: " + value);

        // Passing by reference - object
        System.out.println("\nMenu awal: " + menu.getItemName() + " - Rp" + menu.getPrice());
        menu.setPrice(50000); // Perubahan mempengaruhi object asli
        System.out.println("Menu setelah diubah di method: " + menu.getItemName() + " - Rp" + menu.getPrice());
    }

    // Static method untuk generate ID acak
    public static String generateRandomId(String prefix) {
        int random = (int)(Math.random() * 10000);
        return prefix + String.format("%04d", random);
    }
}