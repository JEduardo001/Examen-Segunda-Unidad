package paquete;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;

public class tabla extends JButton implements TableCellRenderer{
	
	
	public tabla() {
        setOpaque(true);
    }
    
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        if (isSelected) {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
          // System.out.println("ss: "+nombre);
        } else {
            setForeground(table.getForeground());
            setBackground(UIManager.getColor("Button.background"));
        }
        setText("Eliminar");
        //setText((value == null) ? "" : value.toString());
        return this;
    }

}
