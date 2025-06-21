package dao;

import model.Customer;
import java.sql.*;

public class CustomerDAO {
    private Connection connection;

    public CustomerDAO(Connection connection) {
        this.connection = connection;
    }
     public CustomerDAO (){
        connection = DatabaseConnection.initializeDatabase();
    }
    public Customer getCustomerById(int customerId) throws SQLException {
        String query = "SELECT * FROM customers WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, customerId);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            return new Customer(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("address")
            );
        }
        return null;
    }
}

