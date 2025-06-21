package servletClass;

import dao.MedicineDAO;
import model.Medicine;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/SearchMedicineServlet")
public class SearchMedicine extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        MedicineDAO medicineDAO = new MedicineDAO();
        try  {
            Medicine medicine = medicineDAO.findMedicineByName(name);

            if (medicine != null) {
                // Medicine found - set it as a request attribute and forward to JSP
                request.setAttribute("medicine", medicine);
                RequestDispatcher dispatcher = request.getRequestDispatcher("searchMedicine.jsp");
                dispatcher.forward(request, response);
            } else {
                // Medicine not found - redirect with status parameter
                response.sendRedirect("searchMedicine.jsp?status=not_found");
            }
        } catch (SQLException e) {
            response.sendRedirect("searchMedicine.jsp?status=error");
        }
    }
}
