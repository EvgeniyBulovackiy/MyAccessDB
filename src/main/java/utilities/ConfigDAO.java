package utilities;

import models.*;
import models.System;
import org.hibernate.cfg.Configuration;

public class ConfigDAO {

  public static org.hibernate.cfg.Configuration createConfig(){
    Configuration config = new Configuration();

    config.setProperty("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
    config.setProperty("hibernate.connection.url",
      "jdbc:ucanaccess://D:\\IdeaProjects\\MyAccessDB\\DB\\DB.accdb");
    config.setProperty("hibernate.connection.driver_class",
      "net.ucanaccess.jdbc.UcanaccessDriver");

    config.addAnnotatedClass(CData.class);
    config.addAnnotatedClass(CData2Queue.class);
    config.addAnnotatedClass(Controller.class);
    config.addAnnotatedClass(ControllerCopy.class);
    config.addAnnotatedClass(ExplosionProofMarking.class);
    config.addAnnotatedClass(FData.class);
    config.addAnnotatedClass(FData2Queue.class);
    config.addAnnotatedClass(InsertionErrors.class);
    config.addAnnotatedClass(Objects.class);
    config.addAnnotatedClass(Objects1.class);
    config.addAnnotatedClass(SignalKinds.class);
    config.addAnnotatedClass(SignalType.class);
    config.addAnnotatedClass(System.class);
    config.addAnnotatedClass(UData.class);
    config.addAnnotatedClass(Unit.class);

    return config;
  }
}
