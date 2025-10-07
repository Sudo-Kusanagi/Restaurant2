// Order.java
// Kelas untuk merepresentasikan pesanan di restoran
// Menunjukkan: Class, Object, Array, Interface Implementation

public class Order implements Payable {
    // Static variable untuk order ID
    private static int orderCounter = 0;

    // Instance variables
    private int orderId;
    private Customer customer;
    private Waiter waiter;
    private Menu[] orderedItems; // Array untuk menyimpan menu yang dipesan
    private int itemCount; // Jumlah item yang sudah dipesan
    private double totalAmount;
    private boolean isPaid;

    // Constructor default
    public Order() {
        this.orderId = ++orderCounter;
        this.orderedItems = new Menu[10]; // Maksimal 10 item per order
        this.itemCount = 0;
        this.totalAmount = 0.0;
        this.isPaid = false;
    }

    // Constructor dengan parameter
    public Order(Customer customer, Waiter waiter) {
        this.orderId = ++orderCounter;
        this.customer = customer;
        this.waiter = waiter;
        this.orderedItems = new Menu[10];
        this.itemCount = 0;
        this.totalAmount = 0.0;
        this.isPaid = false;
    }

    // Method untuk menambah item ke order
    // Menunjukkan: Array manipulation, IF condition
    public boolean addItem(Menu item) {
        // IF dengan multiple operands
        if (itemCount < orderedItems.length && item != null && item.isAvailable()) {
            orderedItems[itemCount] = item;
            itemCount++;
            totalAmount += item.getPrice();
            return true;
        } else {
            System.out.println("Tidak bisa menambah item: " +
                    (itemCount >= orderedItems.length ? "Order penuh" : "Item tidak tersedia"));
            return false;
        }
    }

    // Implementasi method dari interface Payable
    @Override
    public double calculateTotal() {
        double subtotal = 0.0;

        // Loop untuk menghitung total menggunakan array.length
        for (int i = 0; i < itemCount; i++) {
            subtotal += orderedItems[i].getPrice();
        }

        // IF dengan multiple operands - diskon berdasarkan membership
        double discount = 0.0;
        if (customer != null && customer.getMembershipType().equals("Silver")) {
            discount = subtotal * 0.05; // 5% discount
        } else if (customer != null && customer.getMembershipType().equals("Gold")) {
            discount = subtotal * 0.10; // 10% discount
        }

        totalAmount = subtotal - discount;
        return totalAmount;
    }

    @Override
    public void displayPaymentDetails() {
        System.out.println("\n========== DETAIL PEMBAYARAN ==========");
        System.out.println("Order ID: #" + orderId);
        if (customer != null) {
            System.out.println("Customer: " + customer.getName() + " (" + customer.getMembershipType() + ")");
        }
        if (waiter != null) {
            System.out.println("Dilayani oleh: " + waiter.getName());
        }
        System.out.println("---------------------------------------");

        // Loop untuk menampilkan semua item
        for (int i = 0; i < itemCount; i++) {
            System.out.println((i+1) + ". " + orderedItems[i].getItemName() +
                    " - Rp" + orderedItems[i].getPrice());
        }

        System.out.println("---------------------------------------");
        System.out.println("Total: Rp" + calculateTotal());
        System.out.println("Status: " + (isPaid ? "LUNAS" : "BELUM DIBAYAR"));
        System.out.println("=======================================\n");
    }

    @Override
    public boolean processPayment(double amount) {
        // IF dengan multiple operands
        if (!isPaid && amount >= totalAmount) {
            isPaid = true;
            double change = amount - totalAmount;
            System.out.println("Pembayaran berhasil! Kembalian: Rp" + change);

            // Tambah loyalty points untuk customer
            if (customer != null) {
                int points = (int)(totalAmount / 10000); // 1 point per 10000
                customer.addLoyaltyPoints(points);
            }

            // Waiter melayani order
            if (waiter != null) {
                waiter.serveOrder();
            }

            return true;
        } else if (isPaid) {
            System.out.println("Order sudah dibayar!");
            return false;
        } else {
            System.out.println("Jumlah pembayaran kurang! Kurang: Rp" + (totalAmount - amount));
            return false;
        }
    }

    // Getters
    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public Menu[] getOrderedItems() {
        return orderedItems;
    }

    public int getItemCount() {
        return itemCount;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public static int getOrderCounter() {
        return orderCounter;
    }
}