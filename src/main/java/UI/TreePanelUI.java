package UI;

import DAO.ModelDAO.*;
import UI.TreeNodes.*;
import UI.Tables.TableFactory;
import models.Controller;
import models.Objects;
import models.Objects1;
import models.System;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedHashSet;

public class TreePanelUI extends JScrollPane {

  private static TreePanelUI current;

  public TreePanelUI() {
    super();
    current = this;
  }

  public void init(DataDAO dataDAO){
    DefaultMutableTreeNode root = new DefaultMutableTreeNode("root");
    DefaultMutableTreeNode modules = new DefaultMutableTreeNode("Модули");
    DefaultMutableTreeNode controller = new DefaultMutableTreeNode("Контроллеры");

    initCDataToModuleNode(modules, dataDAO);
    initCDataToControllerNode(controller, dataDAO);

    root.add(modules);
    root.add(controller);


    JTree tree = new JTree(root);
    tree.setCellRenderer(new IconRenderer());
    tree.setRootVisible(false);

    tree.addMouseListener(getMouseListener(tree, dataDAO));
    this.setViewportView(tree);
  }

  private MouseListener getMouseListener(JTree tree, DataDAO dataDAO) {
    return new MouseAdapter() {
        public void mousePressed(MouseEvent e) {
          int selRow = tree.getRowForLocation(e.getX(), e.getY());
          TreePath selPath = tree.getPathForLocation(e.getX(), e.getY());
          if(selRow != -1) {
            if(e.getClickCount() == 2) {
              switch (selPath.getPathComponent(1).toString()){
                case "Модули":
                  if (selPath.getPathCount() == 6) {
                    MainUI ui = MainUI.getCurrentUI();
                    switch (dataDAO.getClass().getSimpleName()){
                      case "CDataDAO":
                        ui.setTableUI(TableFactory.createTableForModelByData(selPath, dataDAO));
                        break;
                      case "UDataDAO":
                        ui.setTableUI(TableFactory.createTableForModelByUData(selPath, dataDAO));
                        break;
                      case "FDataDAO":
                        ui.setTableUI(TableFactory.createTableForModelByFData(selPath, dataDAO));
                        break;
                      case "CData2QueueDAO":
                        ui.setTableUI(TableFactory.createTableForModelByCQueue(selPath, dataDAO));
                        break;
                      case "FData2QueueDAO":
                        ui.setTableUI(TableFactory.createTableForModelByFQueue(selPath, dataDAO));
                        break;
                    }
                  }
                  break;
                case "Контроллеры":
                  if (selPath.getPathCount() == 5) {
                    MainUI ui = MainUI.getCurrentUI();
                    switch (dataDAO.getClass().getSimpleName()){
                      case "CDataDAO":
                        ui.setTableUI(TableFactory.createTableForController(selPath, dataDAO));
                        break;
                      case "UDataDAO":
                        ui.setTableUI(TableFactory.createTableForUController(selPath, dataDAO));
                        break;
                      case "FDataDAO":
                        ui.setTableUI(TableFactory.createTableForFController(selPath, dataDAO));
                        break;
                      case "CData2QueueDAO":
                        ui.setTableUI(TableFactory.createTableForControllerByCQueue(selPath, dataDAO));
                        break;
                      case "FData2QueueDAO":
                        ui.setTableUI(TableFactory.createTableForControllerByFQueue(selPath, dataDAO));
                        break;
                    }
                  }
                  break;
              }
            }
          }
        }
      };
  }

  private void initCDataToModuleNode(DefaultMutableTreeNode modules, DataDAO dataDAO) {
    LinkedHashSet<System> systems = dataDAO.getUniqueSystem();

    systems.forEach(system -> {
      SystemTreeNode systemTreeNode = new SystemTreeNode(system);
      LinkedHashSet<Objects> uniqueObjects = dataDAO.getUniqueObjectIdsBySystem(system);

      uniqueObjects.forEach(objects -> {
        ObjectTreeNode objectTreeNode = new ObjectTreeNode(objects);
        LinkedHashSet<Objects1> uniqueObjects1 = dataDAO.getUniqueObj1IdsBySysAndObj(objects, system);
        uniqueObjects1.forEach(objects1 -> {
          Object1TreeNode object1TreeNode = new Object1TreeNode(objects1);
          LinkedHashSet<String> positions = dataDAO.getUniquePosBySysObjAndObj1(system, objects, objects1);
          positions.forEach(s -> {
            PositionTreeNode node = new PositionTreeNode(s == null ? "Без названия" : s);
            object1TreeNode.add(node);
          });

          objectTreeNode.add(object1TreeNode);
        });

        systemTreeNode.add(objectTreeNode);
      });

      modules.add(systemTreeNode);
    });
  }

  private void initCDataToControllerNode(DefaultMutableTreeNode controllerNode, DataDAO dataDAO){

    LinkedHashSet<Controller> controllers = dataDAO.getUniqueController();
    controllers.forEach(controller -> {
      ControllerTreeNode controllerTreeNode = new ControllerTreeNode(controller);
      LinkedHashSet<String> moduleNumbers = dataDAO.getUniqueNumOfModByContr(controller);

      moduleNumbers.forEach(moduleNumber -> {
        ModuleNumberTreeNode number =
          new ModuleNumberTreeNode(moduleNumber == null ? "Без названия" : moduleNumber);
        LinkedHashSet<String> chanelNumbers = dataDAO.getUniqueNumOfChanByContrAndNumOfMod(controller, moduleNumber);

        chanelNumbers.forEach(chanelNumber -> {
          ChannelNumberTreeNode chanelNumberNode =
            new ChannelNumberTreeNode(chanelNumber == null ? "Без названия" : chanelNumber);
          number.add(chanelNumberNode);
        });

        controllerTreeNode.add(number);
      });

      controllerNode.add(controllerTreeNode);
    });
  }

  public static TreePanelUI getCurrent(){
    return current;
  }
}
