package dao;

import model.Medicine;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicineDAO {
    private Connection connection;

    // Constructor to initialize database connection
    public MedicineDAO() {
        connection = DatabaseConnection.initializeDatabase();
    }

    // Method to add a new medicine to the database
    public boolean addMedicine(Medicine medicine) throws SQLException {
        String query = "INSERT INTO medicine (name, price, stock) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, medicine.getName());
        statement.setDouble(2, medicine.getPrice());
        statement.setInt(3, medicine.getStock());

        int rowsInserted = statement.executeUpdate();
        return rowsInserted > 0; // Returns true if the medicine was added successfully
    }

    // Method to retrieve all medicines from the database
    public List<Medicine> getAllMedicines() throws SQLException {
        List<Medicine> medicines = new ArrayList<>();
        String query = "SELECT * FROM medicine";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            Medicine medicine = new Medicine(
                resultSet.getInt("medicine_id"),
                resultSet.getString("name"),
                resultSet.getDouble("price"),
                resultSet.getInt("stock")
            );
            medicines.add(medicine);
        }
        return medicines;
    }
    public List<Medicine> getLowStockMedicines(int threshold) throws SQLException {
    List<Medicine> lowStockMedicines = new ArrayList<>();
    String query = "SELECT * FROM medicine WHERE stock <= ?";
    PreparedStatement statement = connection.prepareStatement(query);
    statement.setInt(1, threshold); // Set a threshold for low stock
    ResultSet resultSet = statement.executeQuery();

    while (resultSet.next()) {
        Medicine medicine = new Medicine(
            resultSet.getInt("medicine_id"),
            resultSet.getString("name"),
            resultSet.getDouble("price"),
            resultSet.getInt("stock")
        );
        lowStockMedicines.add(medicine);
    }
    return lowStockMedicines;
}
    // Method to search for a medicine by name
 public Medicine findMedicineByName(String name) throws SQLException {
    String query = "SELECT * FROM medicine WHERE name = ?";
    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setString(1, name);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            return new Medicine(
                resultSet.getInt("medicine_id"),
                resultSet.getString("name"),
                resultSet.getDouble("price"),
                resultSet.getInt("stock")
            );
        }
    }
    return null; // Returns null if the medicine was not found
}

    // Method to update the stock of a specific medicine
    public boolean updateMedicineStock(int medicineId, int newStock) throws SQLException {
        String query = "UPDATE medicine SET stock = ? WHERE medicine_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, newStock);
        statement.setInt(2, medicineId);

        int rowsUpdated = statement.executeUpdate();
        return rowsUpdated > 0; // Returns true if the stock was updated successfully
    }
    public Medicine findMedicineById(int medicineId) throws SQLException {
        String query = "SELECT * FROM medicine WHERE medicine_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, medicineId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Medicine(
                    resultSet.getInt("medicine_id"),
                    resultSet.getString("name"),
                    resultSet.getDouble("price"),
                    resultSet.getInt("stock")
                );
            }
        }
        return null; // Returns null if the medicine was not found
    }
    // Method to close the database connection
    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}