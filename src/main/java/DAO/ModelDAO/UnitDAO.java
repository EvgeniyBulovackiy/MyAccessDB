package DAO.ModelDAO;

import models.Unit;

import java.util.List;

public class UnitDAO extends AbstractDAO<Unit> {

  public void printAll(){

    List controllers = getAll();
    controllers.forEach(System.out::println);
  }
}
