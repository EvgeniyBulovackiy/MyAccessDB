package UI;

import DAO.ModelDAO.*;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ComboBoxUI extends JComboBox {

  public ComboBoxUI() {
    super(new String[]{
      "С_Данные", "C_Данные_2_очередь", "F_Данные", "F_Данные_2_очередь", "U_Данные"
    });
    addListener();
  }

  private void addListener(){
    ActionListener actionListener = e -> {

      String s = (String) getSelectedItem();

      switch (s) {
        case "С_Данные":
          TreePanelUI.getCurrent().init(new CDataDAO());
          break;
        case "C_Данные_2_очередь":
          TreePanelUI.getCurrent().init(new CData2QueueDAO());
          break;
        case "F_Данные":
          TreePanelUI.getCurrent().init(new FDataDAO());
          break;
        case "F_Данные_2_очередь":
          TreePanelUI.getCurrent().init(new FData2QueueDAO());
          break;
        case "U_Данные":
          TreePanelUI.getCurrent().init(new UDataDAO());
          break;
      }
    };

    this.addActionListener(actionListener);
  }
}
