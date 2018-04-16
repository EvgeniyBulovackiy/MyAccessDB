package DAO.ModelDAO;

import DAO.DAOManager;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractDAO<E> {

  private static final Logger LOG = LoggerFactory.getLogger(AbstractDAO.class);

  protected Class<E> entityClass = (Class<E>) ((ParameterizedType) getClass()
    .getGenericSuperclass()).getActualTypeArguments()[0];

  public List<E> getAll() {
    Session session = DAOManager.openSession();
    session.beginTransaction();
    List models = session.createCriteria(entityClass).list();
    session.close();
    return models;
  }

  public void add(E model) {
    try (Session session = DAOManager.openSession()) {
      session.beginTransaction();
      session.save(model);
      session.getTransaction().commit();
    } catch (Exception e){
      LOG.error("Не могу сохранить данные!");
    }
  }

  public void update(E model) {
    try(Session session = DAOManager.openSession()){
      session.beginTransaction();
      session.update(model);
      session.getTransaction().commit();
    } catch (Exception e){
      LOG.error("Не могу обновить данные!");
    }
  }

  public void delete(E model) {
    try(Session session = DAOManager.openSession()){
      session.beginTransaction();
      session.delete(model);
      session.getTransaction().commit();
    } catch (Exception e){
      LOG.error("Не могу удалить данные!");
    }
  }
}
