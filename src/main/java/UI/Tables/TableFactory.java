package UI.Tables;

import DAO.ModelDAO.DataDAO;
import UI.TableModels.*;

import javax.swing.tree.TreePath;

public class TableFactory {

  public static DataTable createTableForModelByData(TreePath path, DataDAO dataDAO){
    return new DataTable(new CDataTableModel(dataDAO.getDataForModelByPath(path), dataDAO, path));
  }

  public static UDataTable createTableForModelByUData(TreePath path, DataDAO dataDAO){
    return new UDataTable(new UDataTableModel(dataDAO.getDataForModelByPath(path), dataDAO, path));
  }

  public static FDataTable createTableForModelByFData(TreePath path, DataDAO dataDAO){
    return new FDataTable(new FDataTableModel(dataDAO.getDataForModelByPath(path), dataDAO, path));
  }

  public static CQueueTable createTableForModelByCQueue(TreePath path, DataDAO dataDAO){
    return new CQueueTable(new CQueueTableModel(dataDAO.getDataForModelByPath(path), dataDAO, path));
  }

  public static FQueueTable createTableForModelByFQueue(TreePath path, DataDAO dataDAO){
    return new FQueueTable(new FQueueTableModel(dataDAO.getDataForModelByPath(path), dataDAO, path));
  }

  public static DataTable createTableForController(TreePath path, DataDAO dataDAO){
    return new DataTable(new CDataTableModel(dataDAO.getDataForControllerByPath(path), dataDAO, path));
  }

  public static UDataTable createTableForUController(TreePath path, DataDAO dataDAO){
    return new UDataTable(new UDataTableModel(dataDAO.getDataForControllerByPath(path), dataDAO, path));
  }

  public static FDataTable createTableForFController(TreePath path, DataDAO dataDAO){
    return new FDataTable(new FDataTableModel(dataDAO.getDataForControllerByPath(path), dataDAO, path));
  }

  public static CQueueTable createTableForControllerByCQueue(TreePath path, DataDAO dataDAO){
    return new CQueueTable(new CQueueTableModel(dataDAO.getDataForControllerByPath(path), dataDAO, path));
  }

  public static FQueueTable createTableForControllerByFQueue(TreePath path, DataDAO dataDAO){
    return new FQueueTable(new FQueueTableModel(dataDAO.getDataForControllerByPath(path), dataDAO, path));
  }
}
