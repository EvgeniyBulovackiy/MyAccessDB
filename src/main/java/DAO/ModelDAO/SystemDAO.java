package DAO.ModelDAO;

import models.System;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class SystemDAO extends AbstractDAO<models.System> {

  public List<System> getSystemsByIds(HashSet systemIds){
    List<System> all = getAll();

    return all.stream().filter(system ->
      systemIds.contains(system.getCount())).collect(Collectors.toList());
  }
}
