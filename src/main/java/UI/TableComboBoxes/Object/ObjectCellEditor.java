package UI.TableComboBoxes.Object;

import DAO.ModelDAO.ObjectDAO;
import models.Objects;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ObjectCellEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {

  private Objects objects;
  private List<Objects> objectsList;

  public ObjectCellEditor() {
    ObjectDAO objectDAO = new ObjectDAO();
    this.objectsList = objectDAO.getAll();
  }

  @Override
  public Object getCellEditorValue() {
    return this.objects;
  }

  @Override
  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {

    if (value instanceof Objects){
      this.objects = (Objects) value;
    }

    JComboBox<Objects> jComboBox = new JComboBox<>();
    objectsList.forEach(jComboBox::addItem);

    jComboBox.setSelectedItem(objects);
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
    JComboBox<Objects> jComboBox = (JComboBox<Objects>) e.getSource();
    this.objects = (Objects) jComboBox.getSelectedItem();
  }
}
