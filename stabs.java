package surenatalaga;

/*  Reeeeey Prject

*/

import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class stabs extends JFrame {
    private JFrame loginFrame;
    private JPanel jPanel1, jPanel2;
    private JLabel txtUser;
    private JTextField txtPrice, txtItemName, txtQuantity, txtIDNumber, txtSearch;
    private JTable jTable1;
    private JScrollPane jScrollPane2;
    private JButton btnSignOut, btnSearch, btnAddItem, btnDelete, btnClear;

    // Constructor to initialize the StoreTab with user details
    public stabs(JFrame loginFrame, String username, String role) {
        this.loginFrame = loginFrame; // Store reference to the login frame
        initComponents(); // Initialize components
        txtUser.setText(username + " (" + role + ")"); // Display the user's role and username
    }

    private void clearFields() {
        // Clear all text fields
        txtItemName.setText("");
        txtQuantity.setText("");
        txtIDNumber.setText("");
        txtPrice.setText("");
    }

    private void initComponents() {
        // Initialize panels and set layout
        jPanel1 = new JPanel(null);

        jTable1 = new CustomTable();
        jTable1.setModel(new DefaultTableModel(
        new Object[][] {},
        new String[] { "Item Name", "Quantity", "ID Number", "Price" }
        ));
        
        
        
        jScrollPane2 = new JScrollPane(jTable1);
        jScrollPane2.setBounds(20, 100, 350, 250);
        jPanel1.add(jScrollPane2);

        // User label initialization
        txtUser = new JLabel("User: Admin (ADMINISTRATOR)");
        txtUser.setBounds(450, 20, 300, 30);
        jPanel1.add(txtUser);

        // Sign Out Button
        btnSignOut = new JButton("Sign Out");
        btnSignOut.setBounds(720, 20, 100, 30);
        btnSignOut.addActionListener(evt -> {
        this.setVisible(false); // Hide the stabs window
        if (loginFrame != null) loginFrame.setVisible(true); // Show the login frame again
        System.exit(0);
      });
        jPanel1.add(btnSignOut);

        // Label for the header
        JLabel lblSearch = new JLabel("King Kong Galaxy Trading");
        lblSearch.setBounds(20, 70, 300, 25);
        lblSearch.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 22));
        jPanel1.add(lblSearch);

        // Search Button
        btnSearch = new JButton("Search");
        btnSearch.setBounds(450, 70, 90, 25);
        btnSearch.addActionListener(evt -> filterTable(txtSearch.getText()));
        jPanel1.add(btnSearch);

        // Search Text Field
        txtSearch = new JTextField();
        txtSearch.setBounds(550, 70, 150, 25); 
        jPanel1.add(txtSearch);

        // Clear Search Button
        JButton btnClearSearch = new JButton("Clear");
        btnClearSearch.setBounds(710, 70, 90, 25); 
        btnClearSearch.addActionListener(evt -> {
            txtSearch.setText("");
            filterTable(""); // Clears the filter when search box is empty
        });
        jPanel1.add(btnClearSearch);

        // Item details panel
        jPanel2 = new JPanel(null);
        jPanel2.setBounds(400, 100, 400, 250);
        jPanel2.setBorder(BorderFactory.createTitledBorder("Item Details"));

        // Item name label and field
        JLabel lblItemName = new JLabel("Item Name:");
        lblItemName.setBounds(20, 30, 100, 25);
        jPanel2.add(lblItemName);
        txtItemName = new JTextField();
        txtItemName.setBounds(120, 30, 200, 25);
        jPanel2.add(txtItemName);

        // Quantity label and field
        JLabel lblQuantity = new JLabel("Quantity:");
        lblQuantity.setBounds(20, 70, 100, 25);
        jPanel2.add(lblQuantity);
        txtQuantity = new JTextField();
        txtQuantity.setBounds(120, 70, 200, 25);
        jPanel2.add(txtQuantity);

        // ID Number label and field
        JLabel lblIDNumber = new JLabel("ID Number:");
        lblIDNumber.setBounds(20, 110, 100, 25);
        jPanel2.add(lblIDNumber);
        txtIDNumber = new JTextField();
        txtIDNumber.setBounds(120, 110, 200, 25);
        jPanel2.add(txtIDNumber);

        // Price label and field
        JLabel lblPrice = new JLabel("Price:");
        lblPrice.setBounds(20, 150, 100, 25);
        jPanel2.add(lblPrice);
        txtPrice = new JTextField();
        txtPrice.setBounds(120, 150, 200, 25);
        jPanel2.add(txtPrice);

        // Add Item button
        btnAddItem = new JButton("Add Item");
        btnAddItem.setBounds(30, 200, 100, 30);
       btnAddItem.addActionListener(evt -> {
    String itemName = txtItemName.getText();
    String quantity = txtQuantity.getText();
    String idNumber = txtIDNumber.getText();
    String price = txtPrice.getText();

    // Validate the inputs first
    if (itemName.isEmpty() || quantity.isEmpty() || idNumber.isEmpty() || price.isEmpty()) {
        JOptionPane.showMessageDialog(this, "All fields must be filled out!", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Format the price with a peso sign
    String formattedPrice = formatPrice(price);

    // Check if the price was formatted correctly
    if (formattedPrice.equals("Invalid Price")) {
        JOptionPane.showMessageDialog(this, "Please enter a valid price!", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

    // Add the new item to the table
    model.addRow(new Object[]{itemName, quantity, idNumber, formattedPrice});

    // Ask the user if they want to add another item
    int option = JOptionPane.showConfirmDialog(this, 
            "Do you want to add another item?", 
            "Add Another Item", 
            JOptionPane.YES_NO_OPTION);

    if (option == JOptionPane.YES_OPTION) {
        clearFields(); // Clear the fields for the next input
    } else {
        clearFields(); // Clear fields after adding
    }
});
        jPanel2.add(btnAddItem);

        // Delete Item button
        btnDelete = new JButton("Delete");
        btnDelete.setBounds(150, 200, 100, 30);
        btnDelete.addActionListener(evt -> deleteItem());
        jPanel2.add(btnDelete);

        // Clear button
        btnClear = new JButton("Clear");
        btnClear.setBounds(270, 200, 100, 30);
        btnClear.addActionListener(evt -> clearTable());
        jPanel2.add(btnClear);

        // Add the panel to the frame
        jPanel1.add(jPanel2);

        // JFrame settings
        setTitle("Galaxy Trading Inventory");
        setSize(850, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(jPanel1);
    }
    
    // Method to format the price with pesos sign and decimal places
    private String formatPrice(String price) {
    try {
        // Remove any existing non-numeric characters
        price = price.replaceAll("[^\\d.]", "");

        // Parse the price as a number
        double parsedPrice = Double.parseDouble(price);

        // Create a NumberFormat instance for formatting the price
        NumberFormat format = new DecimalFormat("#,###.00");

        // Format the price and add the peso sign
        return "₱" + format.format(parsedPrice);
    } catch (NumberFormatException e) {
        // If invalid price input is entered
        return "Invalid Price";
    }
    }

    

    private void deleteItem() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow != -1) {
            model.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "No item selected to delete!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void clearTable() {
        // Show confirmation dialog before clearing
        int option = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to clear all items from the table?",
                "Confirm Clear",
                JOptionPane.YES_NO_OPTION
        );

        if (option == JOptionPane.YES_OPTION) {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0); // Clear all rows
        }
    }
private void filterTable(String searchText) {
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
    jTable1.setRowSorter(sorter);

    if (searchText.trim().isEmpty()) {
        sorter.setRowFilter(null);
    } else {
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText));
    }

    if (model.getRowCount() > 0) {
        for (int i = 0; i < model.getRowCount(); i++) {
            String itemName = (String) model.getValueAt(i, 0);
            if (itemName.equalsIgnoreCase(searchText)) {
                showItemEditPrompt(itemName,
                                   (String) model.getValueAt(i, 1),
                                   (String) model.getValueAt(i, 2),
                                   formatPrice((String) model.getValueAt(i, 3))); // Ensure price is formatted
                break;
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Item not found!", "Search Result", JOptionPane.INFORMATION_MESSAGE);
    }

}
   private void showItemEditPrompt(String itemName, String quantity, String idNumber, String price) {
    // Format the price before displaying
    String formattedPrice = formatPrice(price);

    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    JTextField txtItemName = new JTextField(itemName);
    JTextField txtQuantity = new JTextField(quantity);
    JTextField txtIDNumber = new JTextField(idNumber);
    JTextField txtPrice = new JTextField(formattedPrice);

    panel.add(new JLabel("Item Name:"));
    panel.add(txtItemName);
    panel.add(new JLabel("Quantity:"));
    panel.add(txtQuantity);
    panel.add(new JLabel("ID Number:"));
    panel.add(txtIDNumber);
    panel.add(new JLabel("Price:"));
    panel.add(txtPrice);

    int option = JOptionPane.showOptionDialog(this, 
                                              panel, 
                                              "Edit or Delete Item?", 
                                              JOptionPane.DEFAULT_OPTION, 
                                              JOptionPane.PLAIN_MESSAGE, 
                                              null, 
                                              new String[]{"Edit", "Delete"}, 
                                              "Edit");

    if (option == 0) {
        editItemDetails(txtItemName.getText(), txtQuantity.getText(), txtIDNumber.getText(), txtPrice.getText());
    } else if (option == 1) {
        deleteItemFromTable(itemName);
    }

}
private void editItemDetails(String itemName, String quantity, String idNumber, String price) {
    // Create a panel to allow the user to edit the item details
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    // Create text fields for the item details
    JTextField txtItemName = new JTextField(itemName);
    JTextField txtQuantity = new JTextField(quantity);
    JTextField txtIDNumber = new JTextField(idNumber);
    JTextField txtPrice = new JTextField(price);

    // Add fields to the panel
    panel.add(new JLabel("Edit Item Name:"));
    panel.add(txtItemName);
    panel.add(new JLabel("Edit Quantity:"));
    panel.add(txtQuantity);
    panel.add(new JLabel("Edit ID Number:"));
    panel.add(txtIDNumber);
    panel.add(new JLabel("Edit Price:"));
    panel.add(txtPrice);

    // Create the dialog for editing the fields
    int option = JOptionPane.showOptionDialog(this,
                                              panel,
                                              "Edit Item Details",
                                              JOptionPane.OK_CANCEL_OPTION,
                                              JOptionPane.PLAIN_MESSAGE,
                                              null,
                                              new String[]{"Save", "Cancel"},
                                              "Save");

    // If Save is clicked, update the item details in the table
    if (option == JOptionPane.OK_OPTION) {
        String updatedItemName = txtItemName.getText();
        String updatedQuantity = txtQuantity.getText();
        String updatedID = txtIDNumber.getText();
        String updatedPrice = txtPrice.getText();

        updateItemInTable(itemName, updatedItemName, updatedQuantity, updatedID, updatedPrice);
    }
}
    private void updateItemInTable(String oldItemName, String updatedItemName, String updatedQuantity, String updatedID, String updatedPrice) {
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    int rowCount = model.getRowCount();

    for (int i = 0; i < rowCount; i++) {
        String currentItemName = (String) model.getValueAt(i, 0);
        if (currentItemName.equalsIgnoreCase(oldItemName)) {
            model.setValueAt(updatedItemName, i, 0); // Update item name
            model.setValueAt(updatedQuantity, i, 1); // Update quantity
            model.setValueAt(updatedID, i, 2);       // Update ID
            model.setValueAt(formatPrice(updatedPrice), i, 3); // Format and update price
            break;
        }
    }

}

private void deleteItemFromTable(String itemName) {
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    int rowCount = model.getRowCount();

    for (int i = 0; i < rowCount; i++) {
        String currentItemName = (String) model.getValueAt(i, 0); // Assuming item name is in the first column
        if (currentItemName.equalsIgnoreCase(itemName)) {
            model.removeRow(i); // Remove the row corresponding to the item
            break; // Exit loop after removing the item
        }
    }
}
}
