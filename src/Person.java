// Person.java
// Abstract class untuk merepresentasikan orang di restoran
// Menunjukkan: Abstract Class, Superclass (Inheritance)

public abstract class Person {
    // Instance variables
    protected String name;
    protected String id;
    protected String phoneNumber;

    // Constructor default
    public Person() {
        this.name = "Unknown";
        this.id = "000";
        this.phoneNumber = "000-000-0000";
    }

    // Constructor dengan parameter
    public Person(String name, String id, String phoneNumber) {
        this.name = name;
        this.id = id;
        this.phoneNumber = phoneNumber;
    }

    // Abstract method - harus diimplementasi oleh subclass
    public abstract void displayRole();

    // Concrete method
    public void displayInfo() {
        System.out.println("Nama: " + name + " | ID: " + id + " | Telepon: " + phoneNumber);
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}