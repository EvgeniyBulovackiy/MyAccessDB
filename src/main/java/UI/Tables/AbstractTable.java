package UI.Tables;

import UI.TableComboBoxes.Controller.ControllerCellEditor;
import UI.TableComboBoxes.Controller.ControllerCellRenderer;
import UI.TableComboBoxes.Object.ObjectCellEditor;
import UI.TableComboBoxes.Object.ObjectCellRenderer;
import UI.TableComboBoxes.Object1.Object1CellEditor;
import UI.TableComboBoxes.Object1.Object1CellRenderer;
import UI.TableComboBoxes.SignalKinds.SignalKindsCellEditor;
import UI.TableComboBoxes.SignalKinds.SignalKindsCellRenderer;
import UI.TableComboBoxes.SignalType.SignalTypeCellEditor;
import UI.TableComboBoxes.SignalType.SignalTypeCellRenderer;
import UI.TableComboBoxes.System.SystemCellEditor;
import UI.TableComboBoxes.System.SystemCellRenderer;
import models.*;
import models.System;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import java.awt.*;

public class AbstractTable extends JTable{

  public AbstractTable(TableModel dm) {
    super(dm);
    this.setDefaultRenderer(SignalType.class, new SignalTypeCellRenderer());
    this.setDefaultEditor(SignalType.class, new SignalTypeCellEditor());
    this.setDefaultRenderer(Controller.class, new ControllerCellRenderer());
    this.setDefaultEditor(Controller.class, new ControllerCellEditor());
    this.setDefaultRenderer(SignalKinds.class, new SignalKindsCellRenderer());
    this.setDefaultEditor(SignalKinds.class, new SignalKindsCellEditor());
    this.setDefaultRenderer(System.class, new SystemCellRenderer());
    this.setDefaultEditor(System.class, new SystemCellEditor());
    this.setDefaultRenderer(Objects.class, new ObjectCellRenderer());
    this.setDefaultEditor(Objects.class, new ObjectCellEditor());
    this.setDefaultRenderer(Objects1.class, new Object1CellRenderer());
    this.setDefaultEditor(Objects1.class, new Object1CellEditor());
    this.setRowHeight(25);
    this.setAutoResizeMode(AUTO_RESIZE_OFF);
    this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    this.setCellSelectionEnabled(true);
    this.setRowSelectionAllowed(true);
  }

  @Override
  public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
    Component component = super.prepareRenderer(renderer, row, column);
    int rendererWidth = component.getPreferredSize().width;
    TableColumn tableColumn = getColumnModel().getColumn(column);
    tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
    return component;
  }
}
