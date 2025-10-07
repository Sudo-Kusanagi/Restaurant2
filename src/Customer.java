// Customer.java
// Subclass dari Person untuk merepresentasikan pelanggan
// Menunjukkan: Inheritance, Polymorphism

public class Customer extends Person {
    // Instance variables khusus Customer
    private int loyaltyPoints;
    private String membershipType; // Regular, Silver, Gold

    // Static variable untuk menghitung total customer
    private static int totalCustomers = 0;

    // Constructor default
    public Customer() {
        super();
        this.loyaltyPoints = 0;
        this.membershipType = "Regular";
        totalCustomers++;
    }

    // Constructor dengan parameter
    public Customer(String name, String id, String phoneNumber) {
        super(name, id, phoneNumber);
        this.loyaltyPoints = 0;
        this.membershipType = "Regular";
        totalCustomers++;
    }

    // Constructor lengkap
    public Customer(String name, String id, String phoneNumber, int loyaltyPoints, String membershipType) {
        super(name, id, phoneNumber);
        this.loyaltyPoints = loyaltyPoints;
        this.membershipType = membershipType;
        totalCustomers++;
    }

    // Implementasi abstract method dari Person
    @Override
    public void displayRole() {
        System.out.println("Role: Customer (Pelanggan)");
    }

    // Method overriding untuk menunjukkan Polymorphism
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Loyalty Points: " + loyaltyPoints + " | Membership: " + membershipType);
    }

    // Method untuk menambah loyalty points
    public void addLoyaltyPoints(int points) {
        this.loyaltyPoints += points;

        // IF dengan multiple operands - upgrade membership berdasarkan points
        if (loyaltyPoints >= 1000 && membershipType.equals("Regular")) {
            membershipType = "Silver";
            System.out.println("Selamat! Anda naik ke membership Silver!");
        } else if (loyaltyPoints >= 2500 && (membershipType.equals("Regular") || membershipType.equals("Silver"))) {
            membershipType = "Gold";
            System.out.println("Selamat! Anda naik ke membership Gold!");
        }
    }

    // Getters
    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public static int getTotalCustomers() {
        return totalCustomers;
    }
}