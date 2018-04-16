package UI.TableComboBoxes.Controller;

import UI.IconRenderer;
import models.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class ControllerCellRenderer extends DefaultTableCellRenderer {

  @Override
  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                 boolean hasFocus, int row, int column) {



    if (value instanceof Controller){
      Controller controller = (Controller) value;
      setText(controller.getName());
      setIcon(new ImageIcon(IconRenderer.class.getResource("/images/controller.png")));
    }

    if (isSelected) {
      setBackground(table.getSelectionBackground());
    } else {
      setBackground(table.getSelectionForeground());
    }

    return this;
  }
}
