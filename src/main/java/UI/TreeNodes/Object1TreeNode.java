package UI.TreeNodes;

import models.Objects1;

import javax.swing.tree.DefaultMutableTreeNode;

public class Object1TreeNode extends DefaultMutableTreeNode {

  private Objects1 objects1;

  public Object1TreeNode(Objects1 objects1) {
    super(objects1.getName());
    this.objects1 = objects1;
  }

  public Objects1 getObjects1() {
    return objects1;
  }

  public void setObjects1(Objects1 objects1) {
    this.objects1 = objects1;
  }

}
