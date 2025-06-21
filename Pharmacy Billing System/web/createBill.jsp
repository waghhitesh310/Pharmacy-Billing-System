<%@ page import="dao.MedicineDAO" %>
<%@ page import="model.Medicine" %>
<%@ page import="java.util.List" %>

<%
    MedicineDAO medicineDAO = new MedicineDAO();
    List<Medicine> medicines = medicineDAO.getAllMedicines();
%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create Bill</title>
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

        /* Form styling */
        form {
            background-color: #f0f8f8; /* Light teal background for form */
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.2);
            width: 400px;
            text-align: left;
        }

        /* Label and input styling */
        label {
            display: block;
            margin: 10px 0 5px;
            color: #004d4d;
        }

        input[type="number"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            border: 1px solid #008080; /* Teal border */
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type="checkbox"] {
            margin-right: 10px;
        }

        /* Button styling */
        button[type="submit"] {
            background-color: #008080; /* Teal background for button */
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            font-weight: bold;
            cursor: pointer;
            width: 100%;
            margin-top: 10px;
        }

        /* Hover effect for submit button */
        button[type="submit"]:hover {
            background-color: #006666; /* Darker teal on hover */
        }

        /* Optional spacing and layout for checkbox and quantity fields */
        .medicine-item {
            margin-bottom: 10px;
        }

        .medicine-item input[type="number"] {
            width: 50px;
            margin-left: 10px;
        }
    </style>
</head>
<body>
    <h2>Create Bill</h2>
    <form action="CreateBillServlet" method="post">
        <label>Customer ID:</label>
        <input type="number" name="customerId" required><br>

        <h3>Select Medicines:</h3>
        <%
            for (Medicine medicine : medicines) {
        %>
            <div class="medicine-item">
                <input type="checkbox" name="medicineId" value="<%= medicine.getMedicineId() %>">
                <%= medicine.getName() %> (Price: <%= medicine.getPrice() %>, Stock: <%= medicine.getStock() %>)<br>
                Quantity: <input type="number" name="quantity" min="1" max="<%= medicine.getStock() %>"><br>
            </div>
        <%
            }
        %>

        <button type="submit">Create Bill</button>
    </form>
</body>
</html>
