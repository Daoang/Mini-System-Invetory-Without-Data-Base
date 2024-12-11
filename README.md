# Mini-System-Invetory-Without-Data-Base

Overview

This project is a Java Swing-based Inventory Management System designed to provide a graphical user interface (GUI) for managing inventory items. The application allows administrators and users to perform various actions, such as logging in, adding, editing, deleting, and searching inventory items. The project is divided into three main classes:

1. CustomTable - Custom implementation of JTable to handle inventory data and apply visual enhancements.
2. Login Window - Provides authentication functionality and role selection.
3. Stabs Window - Main inventory management interface.

Features

Login Window

1 Role-Based Authentication: Supports two roles - ADMINISTRATOR and USER.
2 Username/Password Validation:
  3 ADMINISTRATOR: Username: Admin, Password: Admin
  4 USER: Username: Rey, Password: Pogi
5 Error Handling: Displays error messages for incorrect credentials.

Inventory Management (Stabs Window)

1 Add Items: Add items to the inventory with details like name, quantity, ID, and price.
2 Edit Items: Modify existing item details directly.
3 Delete Items: Remove items from the inventory.
4 Clear Inventory: Option to clear all items from the inventory table.
5 Search Functionality: Search items by name and dynamically filter results.
6 Price Formatting: Automatically formats prices with the Peso (\u20B1) sign and two decimal points.
7 Color-Coded Quantity:
  8 Quantity >= 100: Green
  9 50 <= Quantity < 100: Yellow
  10 Quantity < 50: Red
11 Role Display: Displays the logged-in user's role and username.

Technology Stack

1 Java SE: Core programming language.
2 Swing: For creating GUI components.
3 JTable: For displaying and managing inventory data.
4 TableRowSorter: For dynamic table filtering.
5 DecimalFormat: For price formatting.

Installation

1. Install Java Development Kit (JDK) (version 8 or higher).
2. Use an Integrated Development Environment (IDE) like IntelliJ IDEA or Eclipse.
3. Vscode

Steps

1. Clone this repository:
   git clone https://github.com/your-username/inventory-management-system.git
2. Open the project in your preferred IDE.
3. Build and run the loginnew class to start the application.

Usage

1. Login:
   1 Enter the username, password, and role to access the system.
   2 For testing, use the predefined credentials.

2. Manage Inventory:
   1 Use the Add Item button to insert new items.
   2 Search items using the search bar at the top.
   3 Edit or delete items by selecting them in the table.
   4 Clear all inventory items if needed.

3. Logout:
   1 Use the Sign Out button to return to the login window.

Code Structure

CustomTable
A subclass of JTable with custom rendering and data handling capabilities.
1 Key Features:
   2 ActionListener for the login button validates credentials and launches the main window.

stabs
The primary interface for inventory management.
1 Key Components:
   2 clearFields(): Resets input fields.
   3 deleteItem(): Removes selected items.
   4 filterTable(String): Filters table rows based on input text.
   5 formatPrice(String): Formats prices with a Peso sign.

Future Enhancements
   1 Implement a database for persistent data storage.
   2 Add user registration and dynamic role management.
   3 Enhance the GUI with modern libraries like JavaFX or external themes.
   4 Export inventory data to CSV or Excel.

Acknowledgments
   1 Java Swing Documentation
   2 Open-source Java libraries and examples.



