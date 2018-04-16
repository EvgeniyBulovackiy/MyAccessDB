package UI.TableComboBoxes.Controller;

import DAO.ModelDAO.ControllerDAO;
import models.Controller;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ControllerCellEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {

  private Controller controller;
  private List<Controller> controllerList;

  public ControllerCellEditor() {
    ControllerDAO controllerDAO = new ControllerDAO();
    this.controllerList = controllerDAO.getAll();
  }

  @Override
  public Object getCellEditorValue() {
    return this.controller;
  }

  @Override
  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {

    if (value instanceof Controller){
      this.controller = (Controller) value;
    }

    JComboBox<Controller> jComboBox = new JComboBox<>();
    controllerList.forEach(jComboBox::addItem);

    jComboBox.setSelectedItem(controller);
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
    JComboBox<Controller> jComboBox = (JComboBox<Controller>) e.getSource();
    this.controller = (Controller) jComboBox.getSelectedItem();
  }
}
