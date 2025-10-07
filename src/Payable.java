// Payable.java
// Interface untuk entitas yang dapat membayar
// Menunjukkan: Interface

public interface Payable {
    // Method abstract untuk menghitung total pembayaran
    double calculateTotal();

    // Method abstract untuk menampilkan detail pembayaran
    void displayPaymentDetails();

    // Method abstract untuk memproses pembayaran
    boolean processPayment(double amount);
}