<%-- 
    Document   : inventory
    Created on : 10 Nov 2024, 2:55:02 am
    Author     : Akshay Gupta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.List,model.Medicine" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Inventory Management</title>
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
        h1 {
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

        input[type="text"], input[type="number"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            border: 1px solid #008080; /* Teal border */
            border-radius: 4px;
            box-sizing: border-box;
        }

        /* Submit button styling */
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

        /* Optional status message styling */
        p.status-message {
            color: green;
            margin-top: 15px;
        }

        p.status-message.error {
            color: red;
        }
    </style>
</head>
<body>
    <h1>Add New Medicine to Inventory</h1>
    
    <!-- Form to add medicine -->
    <form action="InventoryAddServlet" method="post">
        <label for="name">Medicine Name:</label>
        <input type="text" id="name" name="name" required>

        <label for="price">Price:</label>
        <input type="number" id="price" name="price" step="0.01" required>

        <label for="stock">Stock:</label>
        <input type="number" id="stock" name="stock" required>

        <button type="submit">Add Medicine</button>
    </form>
</body>
</html>

