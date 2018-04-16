package UI;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

public class IconRenderer extends DefaultTreeCellRenderer {
  private ImageIcon systemIcon;
  private ImageIcon objectIcon;
  private ImageIcon object1Icon;
  private ImageIcon controllerIcon;
  private ImageIcon moduleIcon;
  private ImageIcon channelIcon;
  private ImageIcon positionIcon;

  public IconRenderer() {
    systemIcon = new ImageIcon(IconRenderer.class.getResource("/images/system.png"));
    objectIcon = new ImageIcon(IconRenderer.class.getResource("/images/object.png"));
    object1Icon = new ImageIcon(IconRenderer.class.getResource("/images/object1.png"));
    controllerIcon = new ImageIcon(IconRenderer.class.getResource("/images/controller.png"));
    moduleIcon = new ImageIcon(IconRenderer.class.getResource("/images/module.png"));
    channelIcon = new ImageIcon(IconRenderer.class.getResource("/images/channel.png"));
    positionIcon = new ImageIcon(IconRenderer.class.getResource("/images/position.png"));
  }

  public Component getTreeCellRendererComponent(JTree tree,
                                                Object value, boolean sel, boolean expanded, boolean leaf,
                                                int row, boolean hasFocus) {

    super.getTreeCellRendererComponent(tree, value, sel,
      expanded, leaf, row, hasFocus);

    switch (value.getClass().getSimpleName()) {
      case "SystemTreeNode":
        setIcon(systemIcon);
        break;
      case "ObjectTreeNode":
        setIcon(objectIcon);
        break;
      case "Object1TreeNode":
        setIcon(object1Icon);
        break;
      case "ControllerTreeNode":
        setIcon(controllerIcon);
        break;
      case "PositionTreeNode":
        setIcon(positionIcon);
        break;
      case "ModuleNumberTreeNode":
        setIcon(moduleIcon);
        break;
      case "ChannelNumberTreeNode":
        setIcon(channelIcon);
        break;
    }

      return this;
  }
}
