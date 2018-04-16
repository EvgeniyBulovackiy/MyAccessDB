package UI.TableModels;

import UI.TreeNodes.ControllerTreeNode;
import UI.TreeNodes.Object1TreeNode;
import UI.TreeNodes.ObjectTreeNode;
import UI.TreeNodes.SystemTreeNode;
import models.*;
import models.System;

import javax.swing.tree.TreePath;

public class Utils {

  public static void fillDataByPath(AbstractData data, TreePath treePath){
    if (treePath.getPathCount() == 6) {
      System system = ((SystemTreeNode) treePath.getPathComponent(2)).getSystem();
      Objects objects = ((ObjectTreeNode) treePath.getPathComponent(3)).getObjects();
      Objects1 objects1 = ((Object1TreeNode) treePath.getPathComponent(4)).getObjects1();
      String position = treePath.getPathComponent(5).toString();

      data.setSystem(system);
      data.setObject(objects);
      data.setObject1(objects1);
      data.setPositionInProject(position);
    } else if (treePath.getPathCount() == 5){
      Controller controller = ((ControllerTreeNode) treePath.getPathComponent(2)).getController();
      String moduleNumber = treePath.getPathComponent(3).toString();
      moduleNumber = moduleNumber.equals("Без названия") ? null : moduleNumber;
      String chanelNumber = treePath.getPathComponent(4).toString();
      chanelNumber = chanelNumber.equals("Без названия") ? null : chanelNumber;

      data.setController(controller);
      data.setModuleNumber(moduleNumber);
      data.setChanelNumber(chanelNumber);
    }
  }
}
