<%-- 
    Document   : register
    Created on : 10 Nov 2024, 12:26:33 am
    Author     : Hitesh Koli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
    <style>
        /* General body styling */
        body {
            background-color: white;
            color: #004d4d; /* Dark teal text color */
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        /* Form styling */
        form {
            background-color: #f0f8f8; /* Light teal background for form */
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.2);
            width: 300px;
            text-align: center;
        }

        /* Heading styling */
        h2 {
            color: #008080; /* Teal color for headings */
            margin-bottom: 20px;
        }

        /* Label and input styling */
        label {
            display: block;
            margin: 10px 0 5px;
            color: #004d4d;
        }

        input[type="text"], input[type="email"], input[type="password"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #008080; /* Teal border */
            border-radius: 4px;
            box-sizing: border-box;
        }

        /* Submit button styling */
        input[type="submit"] {
            background-color: #008080; /* Teal background for button */
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            font-weight: bold;
            cursor: pointer;
            margin-top: 10px;
        }

        /* Hover effect for submit button */
        input[type="submit"]:hover {
            background-color: #006666; /* Darker teal on hover */
        }
    </style>
</head>
<body>
    <form action="register" method="post">
        <h2>Register</h2>
        <label>Name:</label>
        <input type="text" name="name" required>
        
        <label>Email:</label>
        <input type="email" name="email" required>
        
        <label>Password:</label>
        <input type="password" name="password" required>
        
        <input type="submit" value="Register">
    </form>
</body>
</html>

