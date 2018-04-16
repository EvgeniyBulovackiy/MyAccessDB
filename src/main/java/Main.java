import DAO.ModelDAO.AbstractDAO;
import DAO.ModelDAO.ControllerCopyDAO;
import DAO.ModelDAO.ControllerDAO;
import DAO.ModelDAO.UnitDAO;
import UI.MainUI;
import org.hibernate.cfg.Configuration;

import javax.swing.*;
import java.io.File;

public class Main {

  public static void main(String[] args) {



    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    SwingUtilities.invokeLater(new Runnable() {

      @Override
      public void run() {
        new MainUI();
      }
    });  }
}
