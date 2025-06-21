/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.*;

public class UserDAO {
    private Connection connection;

    // Constructor to initialize database connection
    public UserDAO() {
        connection = DatabaseConnection.initializeDatabase();
    }

    // Method to validate user login
    public User validateUser(String email, String password) throws SQLException {
        String query = "SELECT * FROM users WHERE email = ? AND password = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, email);
        statement.setString(2, password);

        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            // Create a User object with the retrieved data
            User user = new User();
            user.setUserId(resultSet.getInt("user_id"));
            user.setName(resultSet.getString("name"));
            user.setEmail(resultSet.getString("email"));
            // No need to set password in this context
            return user;
        }
        // Return null if no matching user is found
        return null;
    }

    // Method to register a new user
    public boolean registerUser(User user) throws SQLException {
        String query = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, user.getName());
        statement.setString(2, user.getEmail());
        statement.setString(3, user.getPassword());

        int rowsInserted = statement.executeUpdate();
        return rowsInserted > 0; // Return true if user was registered successfully
    }

    // Close database connection when done
    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}

