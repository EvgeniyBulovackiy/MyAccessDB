package UI.TableComboBoxes.SignalType;

import models.SignalType;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class SignalTypeCellRenderer extends DefaultTableCellRenderer {

  @Override
  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                 boolean hasFocus, int row, int column) {

    if (value instanceof SignalType){
      SignalType signalType = (SignalType) value;
      setText(signalType.getSignalType());
    }

    if (isSelected) {
      setBackground(table.getSelectionBackground());
    } else {
      setBackground(table.getSelectionForeground());
    }

    return this;
  }
}
