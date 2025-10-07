// Waiter.java
// Subclass dari Person untuk merepresentasikan pelayan
// Menunjukkan: Inheritance, Polymorphism

public class Waiter extends Person {
    // Instance variables khusus Waiter
    private int ordersServed;
    private double tipReceived;

    // Constructor default
    public Waiter() {
        super();
        this.ordersServed = 0;
        this.tipReceived = 0.0;
    }

    // Constructor dengan parameter
    public Waiter(String name, String id, String phoneNumber) {
        super(name, id, phoneNumber);
        this.ordersServed = 0;
        this.tipReceived = 0.0;
    }

    // Implementasi abstract method dari Person
    @Override
    public void displayRole() {
        System.out.println("Role: Waiter (Pelayan)");
    }

    // Method overriding - Polymorphism
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Orders Served: " + ordersServed + " | Total Tip: Rp" + tipReceived);
    }

    // Method untuk menambah pesanan yang dilayani
    public void serveOrder() {
        ordersServed++;
    }

    // Method untuk menerima tip
    public void receiveTip(double amount) {
        tipReceived += amount;
    }

    // Getters
    public int getOrdersServed() {
        return ordersServed;
    }

    public double getTipReceived() {
        return tipReceived;
    }
}