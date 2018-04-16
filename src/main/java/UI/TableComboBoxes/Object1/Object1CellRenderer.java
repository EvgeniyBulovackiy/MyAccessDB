package UI.TableComboBoxes.Object1;

import UI.IconRenderer;
import models.Objects1;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class Object1CellRenderer extends DefaultTableCellRenderer {

  @Override
  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                 boolean hasFocus, int row, int column) {

    if (value instanceof Objects1){
      Objects1 objects1 = (Objects1) value;
      setText(objects1.getName());
      setIcon(new ImageIcon(IconRenderer.class.getResource("/images/object1.png")));
    }

    if (isSelected) {
      setBackground(table.getSelectionBackground());
    } else {
      setBackground(table.getSelectionForeground());
    }

    return this;
  }}
