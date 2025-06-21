package dao;

import model.Bill;
import model.BillItem;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillDAO {
    private Connection connection;

    public BillDAO(Connection connection) {
        this.connection = connection;
    }

    public int createBill(Bill bill) throws SQLException {
        String query = "INSERT INTO bills (customer_id, bill_date) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, bill.getCustomerId());
        statement.setTimestamp(2, new Timestamp(bill.getBillDate().getTime()));
        statement.executeUpdate();

        ResultSet rs = statement.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1); // returning generated bill ID
        }
        return 0;
    }

    public void addBillItems(List<BillItem> billItems) throws SQLException {
        String query = "INSERT INTO bill_items (bill_id, medicine_id, quantity, total_price) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        for (BillItem item : billItems) {
            statement.setInt(1, item.getBillId());
            statement.setInt(2, item.getMedicineId());
            statement.setInt(3, item.getQuantity());
            statement.setDouble(4, item.getTotalPrice());
            statement.addBatch();
        }
        statement.executeBatch();
    }

    // Method to retrieve a specific bill by its ID
    public Bill getBillById(int billId) throws SQLException {
        String query = "SELECT * FROM bills WHERE bill_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, billId);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            int customerId = resultSet.getInt("customer_id");
            Date billDate = resultSet.getTimestamp("bill_date");
            return new Bill(billId, customerId, billDate, getBillItems(billId));
        }
        return null; // If bill is not found
    }

    // Method to retrieve all items for a specific bill by bill ID
    public List<BillItem> getBillItems(int billId) throws SQLException {
        List<BillItem> billItems = new ArrayList<>();
        String query = "SELECT * FROM bill_items WHERE bill_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, billId);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            int itemId = resultSet.getInt("item_id");
            int medicineId = resultSet.getInt("medicine_id");
            int quantity = resultSet.getInt("quantity");
            double totalPrice = resultSet.getDouble("total_price");

            billItems.add(new BillItem(itemId, billId, medicineId, quantity, totalPrice));
        }
        return billItems;
    }
}
