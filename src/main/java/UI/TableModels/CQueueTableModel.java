package UI.TableModels;

import DAO.ModelDAO.CData2QueueDAO;
import DAO.ModelDAO.DataDAO;
import UI.TreeNodes.ControllerTreeNode;
import UI.TreeNodes.Object1TreeNode;
import UI.TreeNodes.ObjectTreeNode;
import UI.TreeNodes.SystemTreeNode;
import models.*;
import models.System;

import javax.swing.table.AbstractTableModel;
import javax.swing.tree.TreePath;
import java.util.List;

public class CQueueTableModel extends AbstractTableModel {

  private String[] columnNames = new String[]{
    "Система", "Объект", "Объект 1", "Контроллер", "Позиция по проекту",
    "Наименование параметра", "Клемник: поле/кросс-контроллер", "Тэг", "Номер модуля п/п", "Номер канала",
    "Вид сигнала", "Нижний ПИП", "Верхний ПИП", "Щит, cтойка",
    "Жила поле/кросс-щит", "Тип сигнала", "Коментарий", "Клемма контроллера", "Жила поле-кросс",
    "Кабель поле-кросс"
  };
  private List<CData2Queue> listData;
  private DataDAO dataDAO;
  private TreePath treePath;

  public CQueueTableModel(List<CData2Queue> listData, DataDAO dataDAO, TreePath treePath) {
    this.listData = listData;
    this.dataDAO = dataDAO;
    this.treePath = treePath;
  }

  @Override
  public int getColumnCount() {
    return columnNames.length;
  }

  @Override
  public String getColumnName(int column) {
    return columnNames[column];
  }

  @Override
  public Class<?> getColumnClass(int columnIndex) {
    if (getValueAt(0, columnIndex) != null) {
      return getValueAt(0, columnIndex).getClass();
    }
    return Object.class;
  }

  @Override
  public int getRowCount() {
    return listData.size();
  }

  @Override
  public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    CData2Queue data = listData.get(rowIndex);

    switch (columnIndex) {
      case 0:
        if (aValue.toString() != null){
          data.setSystem((System) aValue);
        } else {
          data.setSystem(null);
        }
        break;
      case 1:
        if (aValue.toString() != null){
          data.setObject((Objects) aValue);
        } else {
          data.setObject(null);
        }
        break;
      case 2:
        if (aValue.toString() != null){
          data.setObject1((Objects1) aValue);
        } else {
          data.setObject1(null);
        }
        break;
      case 3:
        if (aValue.toString() != null){
          data.setController((Controller) aValue);
        } else {
          data.setController(null);
        }
        break;
      case 4:
        data.setPositionInProject((String) aValue);
        break;
      case 5:
        data.setTerminalBlock((String) aValue);
        break;
      case 6:
        data.setTag((String) aValue);
        break;
      case 7:
        data.setModuleNumber((String) aValue);
        break;
      case 8:
        data.setChanelNumber((String) aValue);
        break;
      case 9:
        if (aValue.toString() != null)
          data.setKindOfSignal((SignalKinds) aValue);
        break;
      case 10:
        data.setParameter((String) aValue);
        break;
      case 11:
        data.setLowerPIP((String) aValue);
        break;
      case 12:
        data.setUpperPIP((String) aValue);
        break;
      case 13:
        data.setBoard((String) aValue);
        break;
      case 14:
        data.setConductorFieldCrossBoard((String) aValue);
        break;
      case 15:
        if (aValue.toString() != null)
          data.setSignalType((SignalType) aValue);
        break;
      case 16:
        data.setComment((String) aValue);
        break;
      case 17:
        data.setTerminalController((String) aValue);
        break;
      case 18:
        data.setConductorFieldCross((String) aValue);
        break;
      case 19:
        data.setCableFieldCross((String) aValue);
        break;
    }
    dataDAO.update(data);
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    CData2Queue data = listData.get(rowIndex);

    switch (columnIndex) {
      case 0:
        if (data.getSystem() == null){
          return new System();
        } else {
          return data.getSystem();
        }
      case 1:
        if (data.getObject() == null){
          return new Objects();
        } else {
          return data.getObject();
        }
      case 2:
        if (data.getObject1() == null){
          return new Objects1();
        } else {
          return data.getObject1();
        }
      case 3:
        if (data.getController() == null){
          return new Controller();
        } else {
          return data.getController();
        }
      case 4:
        return data.getPositionInProject();
      case 5:
        return data.getTerminalBlock();
      case 6:
        return data.getTag();
      case 7:
        return data.getModuleNumber();
      case 8:
        return data.getChanelNumber();
      case 9:
        if (data.getKindOfSignal() == null){
          return new SignalKinds();
        } else {
          return data.getKindOfSignal();
        }
      case 10:
        return data.getParameter();
      case 11:
        return data.getLowerPIP();
      case 12:
        return data.getUpperPIP();
      case 13:
        return data.getBoard();
      case 14:
        return data.getConductorFieldCrossBoard();
      case 15:
        if (data.getSignalType() == null){
          return new SignalType();
        } else {
          return data.getSignalType();
        }
      case 16:
        return data.getComment();
      case 17:
        return data.getTerminalController();
      case 18:
        return data.getConductorFieldCross();
      case 19:
        return data.getCableFieldCross();
      default:
        return null;
    }

  }

  @Override
  public boolean isCellEditable(int rowIndex, int columnIndex) {
    return columnIndex >= 0;
  }

  public void addRow(){
    CData2Queue newData = new CData2Queue();
    Utils.fillDataByPath(newData, treePath);
    this.listData.add(newData);
    dataDAO.add(newData);
    this.fireTableStructureChanged();
  }

  public void deleteRow(int row){
    CData2Queue data = listData.get(row);
    listData.remove(row);
    dataDAO.delete(data);
    fireTableDataChanged();
  }
}
