package UI;

import DAO.DAOManager;
import utilities.PropertiesUtil;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Properties;

public class MenuUI extends JMenuBar {

  public MenuUI() {
    init();
  }

  public void init() {
    JMenu menu = new JMenu("Меню");
    JMenuItem chooseFile = new JMenuItem("Выбрать файл");
    chooseFile.addActionListener(e -> {
      JFileChooser fileOpen = new JFileChooser();
      fileOpen.setFileFilter(new FileFilter() {
        @Override
        public boolean accept(File f) {
          if (f.isDirectory()) {
            return true;
          } else {
            String path = f.getAbsolutePath().toLowerCase();
            return (path.endsWith(getDescription())
              && (path.charAt(path.length() - getDescription().length() - 1)) == '.');
            }
        }

        @Override
        public String getDescription() {
          return "accdb";
        }
      });
      int ret = fileOpen.showDialog(null, "Открыть файл");
      if (ret == JFileChooser.APPROVE_OPTION) {
        File file = fileOpen.getSelectedFile();
        PropertiesUtil.writePathToProperties(file);
        DAOManager.buildSession();
        MainUI mainUI = MainUI.getCurrentUI();
        mainUI.initUI();
      }
    });
    menu.add(chooseFile);
    this.add(menu);
  }


}
