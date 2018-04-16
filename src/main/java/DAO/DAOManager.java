package DAO;


import UI.MainUI;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilities.ConfigDAO;
import utilities.PropertiesUtil;

import java.io.File;
import java.net.URL;

public class DAOManager {

  private static SessionFactory sessionFactory;

  static {
    Configuration configuration = ConfigDAO.createConfig();
    String url = PropertiesUtil.getConnectionUrl();
    if (url != null){
      configuration.setProperty("hibernate.connection.url", url);
      sessionFactory = configuration.buildSessionFactory();
      MainUI mainUI = MainUI.getCurrentUI();
      mainUI.initUI();
    }
  }

  public static void buildSession(){
    if (sessionFactory != null && sessionFactory.isOpen()) sessionFactory.close();
    Configuration configuration = ConfigDAO.createConfig();
    configuration.setProperty("hibernate.connection.url", PropertiesUtil.getConnectionUrl());
    sessionFactory = configuration.buildSessionFactory();
  }

  public static Session openSession(){
    try{
      return sessionFactory.openSession();
    } catch (HibernateException e){
      throw new RuntimeException("Не могу открыть сессию");
    }
  }
}
