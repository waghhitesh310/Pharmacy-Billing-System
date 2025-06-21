💊 Pharmacy Billing System
A simple web-based Pharmacy Billing System developed using Java, JSP/Servlets, and MySQL. This system allows pharmacists to manage medicine inventory, track stock levels, and handle basic billing functionalities efficiently.

🚀 Features
🔍 View All Medicines: Display all available medicines with price and stock levels.

📉 Low Stock Alert: Medicines with stock less than 10 are highlighted in red.

➕ Add New Medicines: Easily add new medicine entries to the database.

🔁 Update Stock: Modify stock quantities directly through the system.

❌ Delete Medicines: Delete individual medicine records with one click.

📊 Stock Report: Get a quick overview of current stock levels and low stock alerts.

🛠️ Technologies Used
Java (JSP & Servlets)

JDBC (Java Database Connectivity)

MySQL (Relational Database)

HTML & CSS (Frontend)

Apache Tomcat (Web Server)

📁 Project Structure
pgsql
Copy
Edit
├── dao/
│   └── MedicineDAO.java
├── model/
│   └── Medicine.java
├── servletClass/
│   └── StockReportServlet.java
├── web/
│   └── stockReport.jsp
├── database/
│   └── schema.sql
⚙️ Setup Instructions
Clone the repository:

bash
Copy
Edit
git clone https://github.com/your-username/pharmacy-billing-system.git
Import the project into your IDE (Eclipse/NetBeans/IntelliJ).

Set up the MySQL database using the provided schema and update your database credentials in DatabaseConnection.java.

Deploy on Apache Tomcat and run the application.

📌 Note
This project is ideal for beginners learning JSP/Servlets, database integration with JDBC, and CRUD operations in Java web development.
