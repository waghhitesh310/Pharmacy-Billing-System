# 💊 Pharmacy Billing System

A simple Java-based web application designed to help pharmacies manage medicine inventory efficiently. The system provides features like stock reporting, low-stock alerts, and medicine management (add, view, delete). Built using **JSP**, **Servlets**, and **MySQL**.

## 🚀 Features

- 📦 View all medicines in stock
- ⚠️ Highlight medicines with low stock (less than 10 units) in red
- ➕ Add new medicines to the database
- 🗑️ Delete medicines directly from the stock report
- 🔍 Search medicine by name or ID
- ✏️ Update stock quantity (via backend or additional UI logic)

## 🛠️ Tech Stack

- **Frontend:** JSP, HTML, CSS
- **Backend:** Java Servlets
- **Database:** MySQL
- **Build Tool:** Apache Tomcat (for deployment)

## 📁 Project Structure

PharmacyBillingSystem/
├── src/
│ ├── dao/
│ │ ├── MedicineDAO.java
│ │ └── DatabaseConnection.java
│ ├── model/
│ │ └── Medicine.java
│ └── servletClass/
│ └── StockReportServlet.java
├── web/
│ ├── stockReport.jsp
│ └── other JSP files...
├── WEB-INF/
│ └── web.xml


## 🧪 How It Works

1. The `StockReportServlet` retrieves data from the `medicine` table and forwards it to `stockReport.jsp`.
2. The `stockReport.jsp` dynamically renders all medicines in a styled table.
3. Medicines with stock less than 10 are highlighted in **red**.
4. A **Delete** button next to each record allows deletion of that entry from the database.

## 💻 Setup Instructions

### Prerequisites

- JDK 8+
- Apache Tomcat 9+
- MySQL
- Maven
