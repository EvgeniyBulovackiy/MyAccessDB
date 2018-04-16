package models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Контроллеры")
public class Controller implements Serializable {
    @Id
    @Column(name="Счетчик")
    private String count;
    @Column(name="Название")
    private String name;
    @Column(name="Поле1")
    private String field1;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    @Override
    public String toString() {
        return name;
    }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Controller that = (Controller) o;
    return Objects.equals(count, that.count) &&
      Objects.equals(name, that.name) &&
      Objects.equals(field1, that.field1);
  }

  @Override
  public int hashCode() {

    return Objects.hash(count, name, field1);
  }
}
