package servletClass;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import dao.BillDAO;
import dao.MedicineDAO;
import model.Bill;
import model.BillItem;
import model.Medicine;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.DatabaseConnection;

public class CreateBillServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        String[] medicineIds = request.getParameterValues("medicineId");
        String[] quantities = request.getParameterValues("quantity");

        try (Connection connection = DatabaseConnection.initializeDatabase()) {
            BillDAO billDAO = new BillDAO(connection);
            MedicineDAO medicineDAO = new MedicineDAO();

            List<BillItem> billItems = new ArrayList<>();

            for (int i = 0; i < medicineIds.length; i++) {
                int medicineId = Integer.parseInt(medicineIds[i]);
                int quantity = Integer.parseInt(quantities[i]);

                Medicine medicine = medicineDAO.findMedicineById(medicineId);

                if (medicine != null && medicine.getStock() >= quantity) {
                    double totalPrice = medicine.getPrice() * quantity;

                    BillItem billItem = new BillItem(0, 0, medicineId, quantity, totalPrice);
                    billItems.add(billItem);

                    medicineDAO.updateMedicineStock(medicineId, medicine.getStock() - quantity);
                } else {
                    response.sendRedirect("createBill.jsp?status=out_of_stock");
                    return;
                }
            }

            Bill bill = new Bill(0, customerId, new Date(), billItems);
            int billId = billDAO.createBill(bill);

            for (BillItem item : billItems) {
                item.setBillId(billId);
            }
            billDAO.addBillItems(billItems);

            response.sendRedirect("billConfirmation.jsp?billId=" + billId);

        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("createBill.jsp?status=error");
        }
    }
}
