package models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Объекты")
public class Objects implements Serializable, Comparable {
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

  public void setName(String name) {
    this.name = name;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  @Override
  public int compareTo(Object o) {
    return this.name.compareTo(((Objects) o).name);
  }

  @Override
  public String toString() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Objects objects = (Objects) o;
    return java.util.Objects.equals(count, objects.count) &&
      java.util.Objects.equals(name, objects.name) &&
      java.util.Objects.equals(note, objects.note);
  }

  @Override
  public int hashCode() {

    return java.util.Objects.hash(count, name, note);
  }
}
