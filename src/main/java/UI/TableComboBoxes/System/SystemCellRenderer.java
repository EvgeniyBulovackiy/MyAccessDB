package UI.TableComboBoxes.System;

import UI.IconRenderer;
import models.System;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class SystemCellRenderer extends DefaultTableCellRenderer {

  @Override
  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                 boolean hasFocus, int row, int column) {

    if (value instanceof System){
      System system = (System) value;
      setText(system.getName());
      setIcon(new ImageIcon(IconRenderer.class.getResource("/images/system.png")));
    }

    if (isSelected) {
      setBackground(table.getSelectionBackground());
    } else {
      setBackground(table.getSelectionForeground());
    }

    return this;
  }
}
