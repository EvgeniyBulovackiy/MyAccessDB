package UI.TableComboBoxes.Object;

import UI.IconRenderer;
import models.Objects;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class ObjectCellRenderer extends DefaultTableCellRenderer {

  @Override
  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                 boolean hasFocus, int row, int column) {

    if (value instanceof Objects){
      Objects objects = (Objects) value;
      setText(objects.getName());
      setIcon(new ImageIcon(IconRenderer.class.getResource("/images/object.png")));
    }

    if (isSelected) {
      setBackground(table.getSelectionBackground());
    } else {
      setBackground(table.getSelectionForeground());
    }

    return this;
  }
}
