/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servletClass;

import java.io.IOException;
//import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Medicine;
import dao.MedicineDAO;
import java.sql.*;

/**
 *
 * @author Hitesh Koli
 */
// @WebServlet("/InventoryAddServlet")
public class InventoryAddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form parameters from the request
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int stock = Integer.parseInt(request.getParameter("stock"));

        // Create a Medicine object
        Medicine medicine = new Medicine(0, name, price, stock);
        MedicineDAO medicineDAO = new MedicineDAO();
        try {
            // Add the medicine to the database
            boolean success = medicineDAO.addMedicine(medicine);

            // Redirect based on the operation's result
            if (success) {
                response.sendRedirect("inventory.jsp?status=success");
            } else {
                response.sendRedirect("inventory.jsp?status=failure");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("inventory.jsp?status=error");
        }
    }
}
