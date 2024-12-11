package surenatalaga;

/*  Reeeeey Prject

*/

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

class CustomTable extends JTable {
    private List<List<Object>> tableData; // ADT to store table data

    public CustomTable() {
        // Initialize the table data storage
        tableData = new ArrayList<>();

        // Set up default table model
        setModel(new DefaultTableModel(
            new Object[]{"Item", "Quantity"}, // Column names
            0 // Initial row count
        ));
    }

    // Add a row to the table and ADT
    public void addRow(Object[] rowData) {
        // Add to the ADT
        List<Object> row = new ArrayList<>();
        for (Object cell : rowData) {
            row.add(cell);
        }
        tableData.add(row);

        // Add to the JTable
        ((DefaultTableModel) getModel()).addRow(rowData);
    }

    // Retrieve data from the ADT
    public List<Object> getRowData(int rowIndex) {
        return tableData.get(rowIndex);
    }

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component c = super.prepareRenderer(renderer, row, column);

        // Apply custom cell background color logic
        if (column == 1) { // Assuming column 1 is "Quantity"
            int quantity = Integer.parseInt(getValueAt(row, column).toString());
            if (quantity >= 100) {
                c.setBackground(Color.GREEN);
                c.setForeground(Color.BLACK);
            } else if (quantity >= 50) {
                c.setBackground(Color.YELLOW);
                c.setForeground(Color.BLACK);
            } else {
                c.setBackground(Color.RED);
                c.setForeground(Color.BLACK);
            }
        } else {
            c.setBackground(Color.WHITE);
            c.setForeground(Color.BLACK);
        }

        return c;
    }

    // Display all data in the ADT (for debugging or inspection)
    public void printTableData() {
        for (List<Object> row : tableData) {
            System.out.println(row);
        }
    }
}
