package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "[Виды сигналов]")
public class SignalKinds {

  @Id
  @Column(name="Счетчик")
  private String count;

  @Column(name="Вид")
  private String kind;

  @Column(name="Примечание")
  private String note;

  public String getCount() {
    return count;
  }

  public void setCount(String count) {
    this.count = count;
  }

  public String getKind() {
    return kind;
  }

  public void setKind(String kind) {
    this.kind = kind;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  @Override
  public String toString() {
    return kind;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    SignalKinds that = (SignalKinds) o;
    return Objects.equals(count, that.count) &&
      Objects.equals(kind, that.kind) &&
      Objects.equals(note, that.note);
  }

  @Override
  public int hashCode() {

    return Objects.hash(count, kind, note);
  }
}
