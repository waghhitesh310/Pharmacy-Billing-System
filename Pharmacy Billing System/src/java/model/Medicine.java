package model;

public class Medicine {
    private int medicineId;
    private String name;
    private double price;
    private int stock;

    // Constructor
    public Medicine(int medicineId, String name, double price, int stock) {
        this.medicineId = medicineId;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    // Getters and Setters
    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
