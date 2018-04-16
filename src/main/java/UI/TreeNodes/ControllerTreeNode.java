package UI.TreeNodes;

import models.Controller;

import javax.swing.tree.DefaultMutableTreeNode;

public class ControllerTreeNode extends DefaultMutableTreeNode {

  private Controller controller;

  public ControllerTreeNode(Controller controller) {
    super(controller.getName());
    this.controller = controller;
  }

  public Controller getController() {
    return controller;
  }

  public void setController(Controller objects1) {
    this.controller = objects1;
  }

}
