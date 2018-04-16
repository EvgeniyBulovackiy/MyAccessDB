package UI.TreeNodes;

import models.System;

import javax.swing.tree.DefaultMutableTreeNode;

public class SystemTreeNode extends DefaultMutableTreeNode {

  private System system;

  public SystemTreeNode(System system){
    super(system.getName());
    this.system = system;
  }

  public System getSystem() {
    return system;
  }

  public void setSystem(System system) {
    this.system = system;
  }
}
