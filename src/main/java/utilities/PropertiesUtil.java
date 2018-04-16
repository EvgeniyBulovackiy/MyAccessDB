package utilities;

import java.io.*;
import java.util.Properties;

public class PropertiesUtil {

  public static String getConnectionUrl(){
    Properties properties = new Properties();
    File file = new File("resources", "hibernate.properties");
    try (InputStream input = new FileInputStream(file)) {

      properties.load(input);
      return properties.getProperty("hibernate.connection.url");
    } catch (IOException e) {
      throw new RuntimeException("Не могу найти файл с настройками");
    }
  }

  public static void writePathToProperties(File f){
    Properties properties = new Properties();
    File directory = new File("resources");
    File file = new File(directory, "hibernate.properties");
    if (!directory.exists()) directory.mkdir();
    if (!file.exists()) {
      try {
        file.createNewFile();
      } catch (IOException e) {
        throw new RuntimeException("Не могу создать " + file.getName());
      }
    }

    try (InputStream input = new FileInputStream(file)) {

      properties.load(input);
      properties.clear();
      properties.setProperty("hibernate.connection.url",
        "jdbc:ucanaccess://" + f.getAbsolutePath());
      properties.store(new FileOutputStream(file), "Url for hibernate. Was generated after selected a file");
    } catch (IOException e) {
      throw new RuntimeException("Не могу найти файл с настройками");
    }
  }
}
