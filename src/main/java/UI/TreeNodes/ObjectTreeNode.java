package UI.TreeNodes;

import models.Objects;

import javax.swing.tree.DefaultMutableTreeNode;

public class ObjectTreeNode extends DefaultMutableTreeNode {

  private Objects objects;

  public ObjectTreeNode(Objects objects) {
    super(objects.getName());
    this.objects = objects;
  }

  public Objects getObjects() {
    return objects;
  }

  public void setObjects(Objects objects) {
    this.objects = objects;
  }
}
