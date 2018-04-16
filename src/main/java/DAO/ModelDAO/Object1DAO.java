package DAO.ModelDAO;

import models.Objects1;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Object1DAO extends AbstractDAO<Objects1> {

  public List<Objects1> getObjects1ByNames(HashSet object1Ids){
    List<Objects1> all = getAll();

    return all.stream().filter(objects1 ->
      object1Ids.contains(objects1.getCount())).collect(Collectors.toList());
  }

}
