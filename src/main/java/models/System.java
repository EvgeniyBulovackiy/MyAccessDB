package models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Система")
public class System implements Serializable, Comparable {

  @Id
  @Column(name = "Счетчик")
  private String count;

  @Column(name = "Название")
  private String name;

  @Column(name = "Примечание")
  private String note;

  public String getCount() {
    return count;
  }

  public void setCount(String count) {
    this.count = count;
  }

  public String getName() {
    return name;
  }

  public void setName(String type) {
    this.name = type;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  @Override
  public int compareTo(Object o) {
    return this.getName().compareTo(((System) o).getName());
  }

  @Override
  public String toString() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    System system = (System) o;
    return Objects.equals(count, system.count) &&
      Objects.equals(name, system.name) &&
      Objects.equals(note, system.note);
  }

  @Override
  public int hashCode() {

    return Objects.hash(count, name, note);
  }
}
