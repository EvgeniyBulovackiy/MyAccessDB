package UI.TableComboBoxes.System;

import DAO.ModelDAO.SystemDAO;
import models.System;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SystemCellEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {

  private System system;
  private List<System> systemList;

  public SystemCellEditor() {
    SystemDAO systemDAO = new SystemDAO();
    this.systemList = systemDAO.getAll();
  }

  @Override
  public Object getCellEditorValue() {
    return this.system;
  }

  @Override
  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {

    if (value instanceof System){
      this.system = (System) value;
    }

    JComboBox<System> jComboBox = new JComboBox<>();
    systemList.forEach(jComboBox::addItem);

    jComboBox.setSelectedItem(system);
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
    JComboBox<System> jComboBox = (JComboBox<System>) e.getSource();
    this.system = (System) jComboBox.getSelectedItem();
  }
}
