<%-- 
    Document   : dashboard
    Created on : 10 Nov 2024, 2:30:56 am
    Author     : Hitesh Koli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="model.User"%>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
    <style>
        /* General body styling */
        body {
            background-color: white;
            color: #004d4d; /* Dark teal text color */
            font-family: Arial, sans-serif;
            display: flex;
            flex-direction: column;
            align-items: center;
            margin: 0;
            padding-top: 50px;
        }

        /* Heading styling */
        h2 {
            color: #008080; /* Teal color for heading */
            margin-bottom: 20px;
        }

        /* Paragraph styling */
        p {
            color: #004d4d;
            font-size: 18px;
        }

        /* Link styling for navigation */
        a {
            background-color: #008080; /* Teal background for links */
            color: white;
            padding: 10px 20px;
            margin: 10px;
            border-radius: 5px;
            text-decoration: none;
            font-weight: bold;
            display: inline-block;
        }

        /* Hover effect for links */
        a:hover {
            background-color: #006666; /* Darker teal on hover */
        }

        /* Container for the dashboard links */
        .link-container {
            display: flex;
            justify-content: center;
            align-items: center;
            gap: 10px; /* Spacing between buttons */
            margin-top: 20px;
            flex-wrap: wrap; /* Wraps to a new line if needed on smaller screens */
        }
    </style>
</head>
<body>
    <h2>Welcome, <%= ((User) session.getAttribute("user")).getName() %>!</h2>
    <p>You are now logged in.</p>

    <div class="link-container">
        <a href="logout">Logout</a>
        <a href="stockReport.jsp">Stock Alert!</a>
        <a href="createBill.jsp">Creating Bill</a>
        <a href="searchMedicine.jsp">Search Medicine</a>
        <a href="inventory.jsp">Entry Medicine</a>
    </div>
</body>
</html>

