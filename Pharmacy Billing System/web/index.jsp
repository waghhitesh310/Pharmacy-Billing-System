<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            /* Set the body background color */
            body {
                background-color: white;
                color: #004d4d; /* Dark teal text color */
                font-family: Arial, sans-serif;
                text-align: center; /* Center content */
            }

            /* Style for the main heading */
            h1 {
                color: #008080; /* Teal color for the main heading */
                padding: 20px;
            }

            /* Style for buttons */
            .button {
                background-color: #008080; /* Teal background for buttons */
                color: white;
                padding: 10px 20px;
                margin: 10px;
                border: none;
                border-radius: 5px;
                font-size: 16px;
                font-weight: bold;
                cursor: pointer;
                text-decoration: none;
                display: inline-block;
            }

            /* Add hover effect to buttons */
            .button:hover {
                background-color: #006666; /* Darker teal on hover */
            }
        </style>
    </head>
    <body>
        <h1>Welcome to Our Pharmacy Billing System</h1>
        <a href="login.jsp" class="button">Login</a>
        <a href="register.jsp" class="button">Registration</a>
    </body>
</html>

