/*
 

    Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
    Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template*/

package servletClass;

import dao.MedicineDAO;
import model.Medicine;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import dao.*;

/**
 *
 * 
 * 
 * @author Hitesh Koli
 */

public class StockReportServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (Connection connection = DatabaseConnection.initializeDatabase()) {
            MedicineDAO medicineDAO = new MedicineDAO();
            List<Medicine> lowStockMedicines = medicineDAO.getLowStockMedicines(10); // Threshold of 10 units

            // Pass the stock data to the JSP page
            request.setAttribute("lowStockMedicines", lowStockMedicines);
            request.getRequestDispatcher("stockReport.jsp").forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}