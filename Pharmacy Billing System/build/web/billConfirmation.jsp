<%@page import="dao.DatabaseConnection"%>
<%@ page import="dao.BillDAO" %>
<%@ page import="model.Bill" %>
<%@ page import="model.BillItem" %>
<%@ page import="java.util.List" %>

<%
    int billId = Integer.parseInt(request.getParameter("billId"));
    BillDAO billDAO = new BillDAO(DatabaseConnection.initializeDatabase());
    Bill bill = billDAO.getBillById(billId);
    List<BillItem> billItems = billDAO.getBillItems(billId);
%>

<html>
<head>
    <title>Bill Confirmation</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <h2>Bill Confirmation</h2>
    <p>Bill ID: <%= bill.getBillId() %></p>
    <p>Customer ID: <%= bill.getCustomerId() %></p>
    <p>Date: <%= bill.getBillDate() %></p>

    <h3>Bill Items</h3>
    <table border="1">
        <tr>
            <th>Medicine ID</th>
            <th>Quantity</th>
            <th>Total Price</th>
        </tr>
        <%
            for (BillItem item : billItems) {
        %>
            <tr>
                <td><%= item.getMedicineId() %></td>
                <td><%= item.getQuantity() %></td>
                <td><%= item.getTotalPrice() %></td>
            </tr>
        <%
            }
        %>
    </table>
</body>
</html>
