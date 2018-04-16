package UI.TableComboBoxes.SignalKinds;

import models.Controller;
import models.SignalKinds;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class SignalKindsCellRenderer extends DefaultTableCellRenderer {

  @Override
  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                 boolean hasFocus, int row, int column) {

    if (value instanceof SignalKinds){
      SignalKinds signalKinds = (SignalKinds) value;
      setText(signalKinds.getKind());
    }

    if (isSelected) {
      setBackground(table.getSelectionBackground());
    } else {
      setBackground(table.getSelectionForeground());
    }

    return this;
  }
}
