package models;

import javax.persistence.*;

@Entity
@Table(name = "F_Данные")
public class FData extends AbstractData{

  @Column(name="Жила")
  private String conductor;

  public String getConductor() {
    return conductor;
  }

  public void setConductor(String conductor) {
    this.conductor = conductor;
  }

}
