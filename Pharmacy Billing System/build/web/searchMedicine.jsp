<%-- 
    Document   : searchMedicine
    Created on : 10 Nov 2024, 10:20:33 am
    Author     : Akshay Gupta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Search Medicine</title>
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
        h1, h2 {
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
            margin-bottom: 20px;
        }

        /* Label and input styling */
        label {
            display: block;
            margin: 10px 0 5px;
            color: #004d4d;
        }

        input[type="text"] {
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
        }

        /* Hover effect for submit button */
        button[type="submit"]:hover {
            background-color: #006666; /* Darker teal on hover */
        }

        /* Styling for search result */
        .search-result {
            width: 400px;
            text-align: left;
            background-color: #f0f8f8;
            padding: 15px;
            border-radius: 8px;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.2);
            margin-top: 20px;
        }

        /* Error message styling */
        p.error-message {
            color: red;
            margin-top: 15px;
        }
    </style>
</head>
<body>
    <h1>Search for Medicine</h1>
    
    <!-- Form to search for a medicine by name -->
    <form action="SearchMedicine" method="get">
        <label for="name">Enter Medicine Name:</label>
        <input type="text" id="name" name="name" required>
        <button type="submit">Search</button>
    </form>

    <!-- Display Search Result -->
    <c:choose>
        <c:when test="${not empty medicine}">
            <div class="search-result">
                <h2>Medicine Details</h2>
                <p><strong>Name:</strong> ${medicine.name}</p>
                <p><strong>Price:</strong> ${medicine.price}</p>
                <p><strong>Stock:</strong> ${medicine.stock}</p>
            </div>
        </c:when>
        <%-- Uncomment this section if needed for handling 'not found' status --%>
        <%-- 
        <c:when test="${param.status == 'not_found'}">
            <p class="error-message">Medicine not found. Please try again.</p>
        </c:when> 
        --%>
    </c:choose>
</body>
</html>
