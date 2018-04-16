package DAO.ModelDAO;


import models.Controller;
import models.System;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerDAO extends AbstractDAO<Controller> {

  public List<Controller> getControllerByIds(HashSet controllerIds){
    List<Controller> all = getAll();

    return all.stream().filter(controller ->
      controllerIds.contains(controller.getCount())).collect(Collectors.toList());
  }
}
