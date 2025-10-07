// RestaurantDemo.java
// Main class untuk mendemonstrasikan semua konsep
// Menunjukkan: Main Method, semua konsep yang diminta

public class Restaurant2Demo {

    public static void main(String[] args) {
        System.out.println("====================================================");
        System.out.println("     SELAMAT DATANG DI RESTAURANT NUSANTARA");
        System.out.println("====================================================\n");

        // ============ MEMBUAT MENU ITEMS ============
        // Menunjukkan: Object creation, Constructor (default dan dengan parameter)
        System.out.println(">>> Membuat Menu Items...\n");

        Menu[] menuList = new Menu[15]; // Array declaration

        // Constructor dengan berbagai parameter
        menuList[0] = new Menu("Nasi Goreng Spesial", 25000, "Makanan Utama");
        menuList[1] = new Menu("Mie Goreng", 20000, "Makanan Utama");
        menuList[2] = new Menu("Ayam Bakar", 35000, "Makanan Utama");
        menuList[3] = new Menu("Sate Ayam", 30000, "Makanan Utama");
        menuList[4] = new Menu("Gado-Gado", 18000, "Makanan Utama");
        menuList[5] = new Menu("Es Teh Manis", 5000, "Minuman");
        menuList[6] = new Menu("Es Jeruk", 7000, "Minuman");
        menuList[7] = new Menu("Jus Alpukat", 12000, "Minuman");
        menuList[8] = new Menu("Kopi Hitam", 8000, "Minuman");
        menuList[9] = new Menu("Pisang Goreng", 10000, "Dessert");
        menuList[10] = new Menu("Es Krim", 15000, "Dessert");
        menuList[11] = new Menu(); // Constructor default

        System.out.println("Total menu items yang dibuat: " + Menu.getTotalMenuItems());
        System.out.println("(Menunjukkan Static Variable)\n");

        // ============ MENAMPILKAN MENU ============
        // Menunjukkan: Loop (for), Array.length, Method call
        System.out.println(">>> Daftar Menu Lengkap:\n");
        for (int i = 0; i < menuList.length; i++) {
            if (menuList[i] != null) { // IF condition
                menuList[i].displayInfo();
            }
        }

        // ============ MENAMPILKAN MENU BERDASARKAN KATEGORI ============
        // Menunjukkan: Static method call, Loop dengan continue
        RestaurantUtils.displayMenuByCategory(menuList, "Minuman");

        // ============ MEMBUAT CUSTOMER & WAITER ============
        // Menunjukkan: Inheritance, Polymorphism, Abstract class implementation
        System.out.println("\n>>> Membuat Customer dan Waiter...\n");

        // Array of Person (Polymorphism - parent class reference)
        Person[] people = new Person[4];

        Customer customer1 = new Customer("Budi Santoso", "C001", "081234567890", 500, "Regular");
        Customer customer2 = new Customer("Siti Aminah", "C002", "081298765432");

        Waiter waiter1 = new Waiter("Andi Wijaya", "W001", "081223344556");
        Waiter waiter2 = new Waiter("Rina Kusuma", "W002", "081334455667");

        // Polymorphism - storing subclass objects in parent class array
        people[0] = customer1;
        people[1] = customer2;
        people[2] = waiter1;
        people[3] = waiter2;

        // Menunjukkan: Polymorphism & Dynamic Binding
        System.out.println("=== Demonstrasi Polymorphism & Dynamic Binding ===");
        for (int i = 0; i < people.length; i++) {
            if (people[i] != null) {
                people[i].displayRole(); // Polymorphic method call
                people[i].displayInfo(); // Method overriding
                System.out.println();
            }
        }

        System.out.println("Total customers terdaftar: " + Customer.getTotalCustomers());
        System.out.println("(Menunjukkan Static Variable dalam Subclass)\n");

        // ============ MEMBUAT PESANAN (ORDER 1) ============
        // Menunjukkan: Interface implementation, Object interaction
        System.out.println("\n>>> MEMBUAT PESANAN #1 (Customer: Budi Santoso)...\n");

        Order order1 = new Order(customer1, waiter1);

        // Menambahkan items ke order
        // Menunjukkan: IF dengan multiple operands dalam method addItem
        order1.addItem(menuList[0]); // Nasi Goreng
        order1.addItem(menuList[2]); // Ayam Bakar
        order1.addItem(menuList[5]); // Es Teh
        order1.addItem(menuList[6]); // Es Jeruk

        // Menampilkan detail pembayaran (Interface method)
        order1.displayPaymentDetails();

        // ============ PROSES PEMBAYARAN ============
        // Menunjukkan: Interface method, IF conditions
        System.out.println(">>> Memproses Pembayaran Order #1...\n");
        double billAmount = order1.calculateTotal();

        // Menghitung tip yang disarankan (Static method, Passing by value)
        int serviceQuality = 9; // Rating pelayanan (1-10)
        double suggestedTip = RestaurantUtils.calculateSuggestedTip(billAmount, serviceQuality);
        System.out.println("Saran Tip (Service Quality " + serviceQuality + "/10): Rp" + suggestedTip);

        // Proses pembayaran
        double payment = billAmount + suggestedTip;
        order1.processPayment(payment);
        waiter1.receiveTip(suggestedTip);

        // ============ MEMBUAT PESANAN (ORDER 2) ============
        System.out.println("\n\n>>> MEMBUAT PESANAN #2 (Customer: Siti Aminah)...\n");

        Order order2 = new Order(customer2, waiter2);
        order2.addItem(menuList[1]); // Mie Goreng
        order2.addItem(menuList[7]); // Jus Alpukat
        order2.addItem(menuList[9]); // Pisang Goreng

        order2.displayPaymentDetails();
        order2.processPayment(50000);

        // ============ DEMONSTRASI LOOP DENGAN BREAK DAN CONTINUE ============
        System.out.println("\n>>> Demonstrasi Loop dengan BREAK dan CONTINUE...\n");

        // Loop dengan BREAK - mencari menu tertentu
        System.out.println("Mencari menu 'Ayam Bakar'...");
        boolean found = false;
        for (int i = 0; i < menuList.length; i++) {
            if (menuList[i] == null) {
                continue; // Skip jika null
            }

            if (menuList[i].getItemName().equals("Ayam Bakar")) {
                System.out.println("Ditemukan di index " + i);
                menuList[i].displayInfo();
                found = true;
                break; // Keluar dari loop
            }
        }

        if (!found) {
            System.out.println("Menu tidak ditemukan.");
        }

        // Loop WHILE - menampilkan menu sampai index tertentu
        System.out.println("\n>>> Demonstrasi WHILE loop...\n");
        System.out.println("Menampilkan 5 menu pertama:");
        int index = 0;
        while (index < 5 && menuList[index] != null) {
            System.out.print((index + 1) + ". ");
            menuList[index].displayInfo();
            index++;
        }

        // ============ DEMONSTRASI PASSING BY VALUE VS REFERENCE ============
        System.out.println("\n>>> Demonstrasi Passing by Value vs Passing by Reference...\n");

        int testValue = 50;
        Menu testMenu = menuList[0];

        System.out.println("SEBELUM method call:");
        System.out.println("testValue (primitive): " + testValue);
        System.out.println("testMenu price: " + testMenu.getItemName() + " - Rp" + testMenu.getPrice());

        // Memanggil method yang mendemonstrasikan passing mechanism
        RestaurantUtils.demonstratePassingMechanism(testValue, testMenu);

        System.out.println("\nSETELAH method call:");
        System.out.println("testValue (primitive): " + testValue + " - TIDAK BERUBAH (Passing by Value)");
        System.out.println("testMenu price: " + testMenu.getItemName() + " - Rp" + testMenu.getPrice() + " - BERUBAH (Passing by Reference)");

        // Kembalikan harga asli
        testMenu.setPrice(25000);

        // ============ DEMONSTRASI STATIC METHOD - FIND MENU ============
        System.out.println("\n>>> Demonstrasi Static Method - Mencari Menu...\n");

        Menu foundMenu = RestaurantUtils.findMenuByName(menuList, "Sate Ayam");
        if (foundMenu != null) {
            System.out.println("Menu ditemukan:");
            foundMenu.displayInfo();
        } else {
            System.out.println("Menu tidak ditemukan.");
        }

        // ============ DEMONSTRASI APPLY DISCOUNT ============
        System.out.println("\n>>> Menerapkan Diskon pada Menu...\n");

        // Passing by reference - object akan berubah
        RestaurantUtils.applyDiscount(menuList[10], 20); // 20% discount

        // ============ MEMBUAT PESANAN UNTUK UPGRADE MEMBERSHIP ============
        System.out.println("\n\n>>> MEMBUAT PESANAN BESAR untuk Upgrade Membership...\n");

        Order order3 = new Order(customer1, waiter1);

        // Menambahkan banyak item untuk dapat loyalty points
        // Loop dengan IF
        for (int i = 0; i < 8; i++) {
            if (menuList[i] != null && menuList[i].isAvailable()) {
                order3.addItem(menuList[i]);
            }
        }

        order3.displayPaymentDetails();

        // Proses pembayaran
        double total3 = order3.calculateTotal();
        System.out.println("\nCustomer " + customer1.getName() + " membayar pesanan besar...");
        order3.processPayment(total3);

        // Tampilkan info customer setelah dapat loyalty points
        System.out.println("\nInfo Customer setelah transaksi:");
        customer1.displayInfo();

        // ============ ARRAY OF ORDERS - CALCULATE REVENUE ============
        System.out.println("\n\n>>> Menghitung Total Pendapatan Restoran...\n");

        Order[] allOrders = new Order[5];
        allOrders[0] = order1;
        allOrders[1] = order2;
        allOrders[2] = order3;

        double totalRevenue = RestaurantUtils.calculateTotalRevenue(allOrders);
        System.out.println("Total Pendapatan: Rp" + totalRevenue);
        System.out.println("Total Order yang diproses: " + Order.getOrderCounter());

        // ============ MENAMPILKAN PERFORMA WAITER ============
        System.out.println("\n>>> Performa Waiter...\n");

        System.out.println("Waiter 1:");
        waiter1.displayInfo();

        System.out.println("\nWaiter 2:");
        waiter2.displayInfo();

        // ============ VALIDASI NOMOR TELEPON ============
        System.out.println("\n>>> Validasi Nomor Telepon (Static Method)...\n");

        String[] phoneNumbers = {"081234567890", "08123", "081298765432100", "0812345678"};

        for (int i = 0; i < phoneNumbers.length; i++) {
            boolean isValid = RestaurantUtils.isValidPhoneNumber(phoneNumbers[i]);
            System.out.println("Nomor: " + phoneNumbers[i] + " - " +
                    (isValid ? "VALID" : "TIDAK VALID"));
        }

        // ============ DEMONSTRASI IF DENGAN MULTIPLE OPERANDS ============
        System.out.println("\n>>> Demonstrasi IF dengan Multiple Operands...\n");

        // Cek apakah customer layak dapat reward
        int points = customer1.getLoyaltyPoints();
        String membership = customer1.getMembershipType();

        if (points > 1000 && (membership.equals("Silver") || membership.equals("Gold"))) {
            System.out.println(customer1.getName() + " layak mendapat reward khusus!");
            System.out.println("Points: " + points + " | Membership: " + membership);
        } else if (points > 500 && membership.equals("Regular")) {
            System.out.println(customer1.getName() + " hampir mencapai Silver membership!");
        } else {
            System.out.println(customer1.getName() + " belum memenuhi syarat reward.");
        }

        // ============ GENERATE RANDOM ID ============
        System.out.println("\n>>> Generate Random ID untuk Customer Baru...\n");

        for (int i = 0; i < 3; i++) {
            String newId = RestaurantUtils.generateRandomId("CUST");
            System.out.println("ID Baru #" + (i+1) + ": " + newId);
        }

        // ============ RINGKASAN AKHIR ============
        System.out.println("\n\n====================================================");
        System.out.println("                 RINGKASAN SISTEM");
        System.out.println("====================================================");
        System.out.println("Total Menu Items: " + Menu.getTotalMenuItems());
        System.out.println("Total Customers: " + Customer.getTotalCustomers());
        System.out.println("Total Orders: " + Order.getOrderCounter());
        System.out.println("Total Revenue: Rp" + totalRevenue);
        System.out.println("====================================================");
        System.out.println("        TERIMA KASIH TELAH BERKUNJUNG!");
        System.out.println("====================================================\n");

        // ============ DEMONSTRASI KONSEP YANG TELAH DITUNJUKKAN ============
        System.out.println("\n=== KONSEP JAVA YANG DITUNJUKKAN DALAM PROGRAM ===");
        System.out.println("1. Good Programming Styles - Penamaan yang jelas, kode rapi");
        System.out.println("2. IF dengan Multiple Operands - &&, || di berbagai method");
        System.out.println("3. Loop - for, while, for-each, continue, break");
        System.out.println("4. Array - deklarasi, manipulasi, array.length");
        System.out.println("5. Class & Object - 7 classes: Menu, Person, Customer, Waiter, Order, RestaurantUtils, RestaurantDemo");
        System.out.println("6. Static Variables - totalMenuItems, totalCustomers, orderCounter");
        System.out.println("7. Static Methods - RestaurantUtils class dengan 8 static methods");
        System.out.println("8. Constructor - default dan dengan parameter di semua class");
        System.out.println("9. Passing by Value - primitive types (int, double)");
        System.out.println("10. Passing by Reference - objects dan arrays");
        System.out.println("11. Interface - Payable interface diimplementasi oleh Order");
        System.out.println("12. Abstract Class - Person sebagai superclass abstract");
        System.out.println("13. Inheritance - Customer dan Waiter extends Person");
        System.out.println("14. Polymorphism - Method overriding (displayInfo, displayRole)");
        System.out.println("15. Dynamic Binding - Array Person[] menyimpan Customer dan Waiter");
        System.out.println("===================================================\n");
    }
}