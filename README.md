# Mini-System-Invetory-Without-Data-Base

Overview

This project is a Java Swing-based Inventory Management System designed to provide a graphical user interface (GUI) for managing inventory items. The application allows administrators and users to perform various actions, such as logging in, adding, editing, deleting, and searching inventory items. The project is divided into three main classes:

1. CustomTable - Custom implementation of JTable to handle inventory data and apply visual enhancements.
2. Login Window - Provides authentication functionality and role selection.
3. Stabs Window - Main inventory management interface.

Features

Login Window

• Role-Based Authentication: Supports two roles - ADMINISTRATOR and USER.
• Username/Password Validation:
  • ADMINISTRATOR: Username: Admin, Password: Admin
  • USER: Username: Rey, Password: Pogi
• Error Handling: Displays error messages for incorrect credentials.

Inventory Management (Stabs Window)

• Add Items: Add items to the inventory with details like name, quantity, ID, and price.
• Edit Items: Modify existing item details directly.
• Delete Items: Remove items from the inventory.
• Clear Inventory: Option to clear all items from the inventory table.
• Search Functionality: Search items by name and dynamically filter results.
• Price Formatting: Automatically formats prices with the Peso (\u20B1) sign and two decimal points.
• Color-Coded Quantity:
  • Quantity >= 100: Green
  • 50 <= Quantity < 100: Yellow
  • Quantity < 50: Red
• Role Display: Displays the logged-in user's role and username.

Technology Stack

• Java SE: Core programming language.
• Swing: For creating GUI components.
• JTable: For displaying and managing inventory data.
• TableRowSorter: For dynamic table filtering.
• DecimalFormat: For price formatting.

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
   • Enter the username, password, and role to access the system.
   • For testing, use the predefined credentials.

2. Manage Inventory:
   • Use the Add Item button to insert new items.
   • Search items using the search bar at the top.
   • Edit or delete items by selecting them in the table.
   • Clear all inventory items if needed.

3. Logout:
   • Use the Sign Out button to return to the login window.

Code Structure

CustomTable
A subclass of JTable with custom rendering and data handling capabilities.
• Key Features:
   • ActionListener for the login button validates credentials and launches the main window.

stabs
The primary interface for inventory management.
• Key Components:
   • clearFields(): Resets input fields.
   • deleteItem(): Removes selected items.
   • filterTable(String): Filters table rows based on input text.
   • formatPrice(String): Formats prices with a Peso sign.

Future Enhancements
   • Implement a database for persistent data storage.
   • Add user registration and dynamic role management.
   • Enhance the GUI with modern libraries like JavaFX or external themes.
   • Export inventory data to CSV or Excel.

Acknowledgments
   • Java Swing Documentation
   • Open-source Java libraries and examples.



