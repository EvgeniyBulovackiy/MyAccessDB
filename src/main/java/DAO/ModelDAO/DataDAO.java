package DAO.ModelDAO;

import DAO.DAOManager;
import UI.TreeNodes.*;
import models.*;
import models.Objects;
import models.System;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.swing.tree.TreePath;
import java.util.*;

public class DataDAO<E> extends AbstractDAO<E> {

  public LinkedHashSet getUniqueSystem(){
    Session session = DAOManager.openSession();
    session.beginTransaction();
    LinkedHashSet<System> systemIds =
      new LinkedHashSet<>(session.createQuery(String.format("SELECT D.system FROM %s D " +
        "ORDER BY D.system.name", entityClass.getName())).list());
    session.close();
    return systemIds;
  }

  public LinkedHashSet<Controller> getUniqueController(){
    Session session = DAOManager.openSession();
    session.beginTransaction();
    LinkedHashSet controllerIds =
      new LinkedHashSet(session.createQuery(String.format("SELECT D.controller FROM %s D " +
        "ORDER BY D.controller.name", entityClass.getName())).list());

    session.close();
    return controllerIds;
  }

  public LinkedHashSet<String> getUniqueNumOfModByContr(Controller controller){
    Session session = DAOManager.openSession();
    session.beginTransaction();
    List<String> numberList = session.createQuery(String.format("SELECT D.moduleNumber " +
      "FROM %1s D WHERE D.controller = %2s " +
      "ORDER BY D.moduleNumber", entityClass.getName(), controller.getCount())).list();
    session.close();
    numberList.replaceAll(s -> s = s == null ? "" : s);

    return new LinkedHashSet(numberList);
  }

  public LinkedHashSet<String> getUniqueNumOfChanByContrAndNumOfMod(Controller controller, String number){
    Session session = DAOManager.openSession();
    session.beginTransaction();
    Query query = session.createQuery(String.format("SELECT D.chanelNumber " +
      "FROM %s D WHERE D.controller.count = :contrParam AND D.moduleNumber = :modulParam " +
      "ORDER BY D.chanelNumber", entityClass.getName()));
    query.setParameter("contrParam", controller.getCount());
    query.setParameter("modulParam", number.isEmpty() ? null : number);
    List<String> numberList = query.list();
    session.close();
    return new LinkedHashSet(numberList);
  }


  public LinkedHashSet<Objects> getUniqueObjectIdsBySystem(System system){
    Session session = DAOManager.openSession();
    session.beginTransaction();
    List objectList = session.createQuery(String.format("SELECT D.object " +
      "FROM %1s D WHERE D.system = %2s " +
      "ORDER BY D.object.name", entityClass.getName(), system.getCount())).list();
    session.close();
    return new LinkedHashSet(objectList);
  }

  public LinkedHashSet<Objects1> getUniqueObj1IdsBySysAndObj(Objects objects, System system){
    Session session = DAOManager.openSession();
    session.beginTransaction();
    Query query = session.createQuery(String.format("SELECT D.object1 " +
      "FROM %s D WHERE D.object.count = :objectParam AND D.system.count = :systemParam " +
      "ORDER BY D.object1.name", entityClass.getName()));
    query.setParameter("objectParam", objects.getCount());
    query.setParameter("systemParam", system.getCount());
    List object1List = query.list();

    session.close();

    return new LinkedHashSet(object1List);
  }

  public LinkedHashSet<String> getUniquePosBySysObjAndObj1(System system, Objects objects, Objects1 objects1){
    Session session = DAOManager.openSession();
    session.beginTransaction();
    Query query = session.createQuery(String.format("SELECT D.positionInProject " +
      "FROM %s D WHERE D.system.count = :sysParam " +
      "AND D.object.count = :objParam AND D.object1.count = :obj1Param " +
      "ORDER BY D.positionInProject", entityClass.getName()));
    query.setParameter("sysParam", system.getCount());
    query.setParameter("objParam", objects.getCount());
    query.setParameter("obj1Param", objects1.getCount());
    List<String> positionList = query.list();
    session.close();
    return new LinkedHashSet(positionList);
  }

  public List<CData> getDataForModelByPath(TreePath path){
    System system = ((SystemTreeNode) path.getPathComponent(2)).getSystem();
    Objects objects = ((ObjectTreeNode) path.getPathComponent(3)).getObjects();
    Objects1 objects1 = ((Object1TreeNode) path.getPathComponent(4)).getObjects1();
    String position = path.getPathComponent(5).toString();
    position = position.equals("Без названия") ? null : position;

    Session session = DAOManager.openSession();
    session.beginTransaction();
    Query query = session.createQuery(String.format("FROM %s AS D " +
      "WHERE D.system.count = :systemCount AND D.object.count = :objectCount " +
      "AND D.object1.count = :object1Count AND D.positionInProject = :position", entityClass.getName()));
    query.setParameter("systemCount", system.getCount());
    query.setParameter("objectCount", objects.getCount());
    query.setParameter("object1Count", objects1.getCount());
    query.setParameter("position", position);
    List list = query.list();

    session.close();

    return list;
  }

  public List<CData> getDataForControllerByPath(TreePath path){
    Controller controller = ((ControllerTreeNode) path.getPathComponent(2)).getController();
    String moduleNumber = path.getPathComponent(3).toString();
    moduleNumber = moduleNumber.equals("Без названия") ? null : moduleNumber;

    String chanelNumber = path.getPathComponent(4).toString();
    chanelNumber = chanelNumber.equals("Без названия") ? null : chanelNumber;

    Session session = DAOManager.openSession();
    session.beginTransaction();
    Query query = session.createQuery(String.format("FROM %s AS D " +
      "WHERE D.controller.count = :contrParam AND D.moduleNumber = :moduleParam " +
      "AND D.chanelNumber = :chanelParam", entityClass.getName()));
    query.setParameter("contrParam", controller.getCount());
    query.setParameter("moduleParam", moduleNumber);
    query.setParameter("chanelParam", chanelNumber);

    List list = query.list();

    session.close();

    return list;
  }
}
