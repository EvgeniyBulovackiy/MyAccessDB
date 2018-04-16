package UI.TableComboBoxes.SignalKinds;

import DAO.ModelDAO.SignalKindsDAO;
import models.SignalKinds;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SignalKindsCellEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {

  private SignalKinds signalKinds;
  private List<SignalKinds> signalKindsList;

  public SignalKindsCellEditor() {
    SignalKindsDAO signalKindsDAO = new SignalKindsDAO();
    this.signalKindsList = signalKindsDAO.getAll();
  }

  @Override
  public Object getCellEditorValue() {
    return this.signalKinds;
  }

  @Override
  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {

    if (value instanceof SignalKinds){
      this.signalKinds = (SignalKinds) value;
    }

    JComboBox<SignalKinds> jComboBox = new JComboBox<>();
    signalKindsList.forEach(jComboBox::addItem);

    jComboBox.setSelectedItem(signalKinds);
    jComboBox.addActionListener(this);

    if (isSelected) {
      jComboBox.setBackground(table.getSelectionBackground());
    } else {
      jComboBox.setBackground(table.getSelectionForeground());
    }

    return jComboBox;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    JComboBox<SignalKinds> jComboBox = (JComboBox<SignalKinds>) e.getSource();
    this.signalKinds = (SignalKinds) jComboBox.getSelectedItem();
  }
}
