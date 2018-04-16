package UI.TableComboBoxes.Object1;

import DAO.ModelDAO.Object1DAO;
import models.Objects1;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Object1CellEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {

  private Objects1 objects1;
  private List<Objects1> objects1List;

  public Object1CellEditor() {
    Object1DAO object1DAO = new Object1DAO();
    this.objects1List = object1DAO.getAll();
  }

  @Override
  public Object getCellEditorValue() {
    return this.objects1;
  }

  @Override
  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {

    if (value instanceof Objects1){
      this.objects1 = (Objects1) value;
    }

    JComboBox<Objects1> jComboBox = new JComboBox<>();
    objects1List.forEach(jComboBox::addItem);

    jComboBox.setSelectedItem(objects1);
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
    JComboBox<Objects1> jComboBox = (JComboBox<Objects1>) e.getSource();
    this.objects1 = (Objects1) jComboBox.getSelectedItem();
  }}
