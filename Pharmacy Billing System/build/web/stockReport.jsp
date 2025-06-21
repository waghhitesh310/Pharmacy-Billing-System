<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.Medicine" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Stock Report</title>
    <style>
        /* General body styling */
        body {
            background-color: white;
            color: #004d4d; /* Dark teal text color */
            font-family: Arial, sans-serif;
            display: flex;
            flex-direction: column;
            align-items: center;
            padding-top: 50px;
            margin: 0;
        }

        /* Heading styling */
        h2 {
            color: #008080; /* Teal color for heading */
            margin-bottom: 20px;
        }

        /* Table styling */
        table {
            width: 80%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 10px;
            text-align: center;
            border: 1px solid #008080; /* Teal border */
        }

        th {
            background-color: #008080; /* Teal background for header */
            color: white;
        }

        td {
            background-color: #f0f8f8; /* Light teal background for table rows */
        }

        /* No data message styling */
        td[colspan="4"] {
            color: #ff0000; /* Red text for no data */
            text-align: center;
        }
    </style>
</head>
<body>
    <h2>Stock Report</h2>

    <table>
        <tr>
            <th>Medicine ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Stock</th>
        </tr>

        <%
            List<Medicine> lowStockMedicines = (List<Medicine>) request.getAttribute("lowStockMedicines");
            if (lowStockMedicines != null && !lowStockMedicines.isEmpty()) {
                for (Medicine medicine : lowStockMedicines) {
        %>
        <tr>
            <td><%= medicine.getMedicineId() %></td>
            <td><%= medicine.getName() %></td>
            <td><%= medicine.getPrice() %></td>
            <td><%= medicine.getStock() %></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="4">No medicines are currently low on stock.</td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
