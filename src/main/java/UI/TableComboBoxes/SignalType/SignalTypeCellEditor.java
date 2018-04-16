package UI.TableComboBoxes.SignalType;

import DAO.ModelDAO.SignalTypeDAO;
import models.SignalType;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SignalTypeCellEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {

  private SignalType signalType;
  private List<SignalType> signalTypeList;

  public SignalTypeCellEditor() {
    SignalTypeDAO signalTypeDAO = new SignalTypeDAO();
    this.signalTypeList = signalTypeDAO.getAll();
  }

  @Override
  public Object getCellEditorValue() {
    return this.signalType;
  }

  @Override
  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {

    if (value instanceof SignalType){
      this.signalType = (SignalType) value;
    }

    JComboBox<SignalType> jComboBox = new JComboBox<>();
    signalTypeList.forEach(jComboBox::addItem);

    jComboBox.setSelectedItem(signalType);
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
    JComboBox<SignalType> jComboBox = (JComboBox<SignalType>) e.getSource();
    this.signalType = (SignalType) jComboBox.getSelectedItem();
  }
}
