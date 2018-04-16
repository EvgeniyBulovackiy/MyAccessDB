package UI.TableModels;

import DAO.ModelDAO.DataDAO;
import DAO.ModelDAO.FDataDAO;
import models.*;
import models.System;

import javax.swing.table.AbstractTableModel;
import javax.swing.tree.TreePath;
import java.util.List;

public class FDataTableModel extends AbstractTableModel{

  private String[] columnNames =
    new String[]{"Система", "Объект", "Объект 1", "Контроллер", "Позиция по проекту",
     "Наименование параметра", "Тэг", "Номер модуля п/п", "Номер канала",
    "Вид сигнала", "Нижний ПИП", "Верхний ПИП", "Щит, cтойка",
    "Тип сигнала", "Коментарий", "Клемма контроллера", "Жила"};
  private List<FData> listData;
  private DataDAO dataDAO;
  private TreePath treePath;

  public FDataTableModel(List<FData> listData, DataDAO dataDAO, TreePath treePath) {
    this.treePath = treePath;
    this.listData = listData;
    this.dataDAO = dataDAO;
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
    FData data = listData.get(rowIndex);

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
        data.setParameter((String) aValue);
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
        data.setLowerPIP((String) aValue);
        break;
      case 11:
        data.setUpperPIP((String) aValue);
        break;
      case 12:
        data.setBoard((String) aValue);
        break;
      case 13:
        if (aValue.toString() != null)
          data.setSignalType((SignalType) aValue);
        break;
      case 14:
        data.setComment((String) aValue);
        break;
      case 15:
        data.setTerminalController((String) aValue);
        break;
      case 16:
        data.setConductor((String) aValue);
        break;
    }
    dataDAO.update(data);
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    FData data = listData.get(rowIndex);

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
        return data.getParameter();
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
        return data.getLowerPIP();
      case 11:
        return data.getUpperPIP();
      case 12:
        return data.getBoard();
      case 13:
        if (data.getSignalType() == null){
          return new SignalType();
        } else {
          return data.getSignalType();
        }
      case 14:
        return data.getComment();
      case 15:
        return data.getTerminalController();
      case 16:
        return data.getConductor();
      default:
        return null;
    }
  }

  @Override
  public boolean isCellEditable(int rowIndex, int columnIndex) {
    return columnIndex >= 0;
  }

  public void addRow(){
    FData newData = new FData();
    Utils.fillDataByPath(newData, treePath);
    this.listData.add(newData);
    dataDAO.add(newData);
    this.fireTableDataChanged();
  }

  public void deleteRow(int row){
    FData data = listData.get(row);
    listData.remove(row);
    dataDAO.delete(data);
    fireTableDataChanged();
  }

}
