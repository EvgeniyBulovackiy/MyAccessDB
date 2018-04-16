package DAO.ModelDAO;

import models.Objects;
import models.System;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class ObjectDAO extends AbstractDAO<models.Objects> {

  public List<Objects> getObjectsByIds(HashSet objectIds){
    List<Objects> all = getAll();

    return all.stream().filter(objects ->
      objectIds.contains(objects.getCount())).collect(Collectors.toList());
  }
}
