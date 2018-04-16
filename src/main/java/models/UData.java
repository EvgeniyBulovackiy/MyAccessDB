package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "U_Данные")
public class UData extends AbstractData {

  @Column(name = "[Кабель поле-кросс]")
  private String cableFieldCross;

  @Column(name="[Кабель поле/кросс-щит]")
  private String cabelFieldCrosBoard;

  @Column(name = "[Жила поле-кросс]")
  private String conductorFieldCross;

  @Column(name = "[Жила поле/кросс-щит]")
  private String conductorFieldCrossBoard;

  @Column(name = "[Клемник: поле/кросс-контроллер]")
  private String terminalBlock;

  public String getCabelFieldCrosBoard() {
    return cabelFieldCrosBoard;
  }

  public void setCabelFieldCrosBoard(String cabelFieldCrosBoard) {
    this.cabelFieldCrosBoard = cabelFieldCrosBoard;
  }

  public String getCableFieldCross() {
    return cableFieldCross;
  }

  public void setCableFieldCross(String cableFieldCross) {
    this.cableFieldCross = cableFieldCross;
  }

  public String getConductorFieldCross() {
    return conductorFieldCross;
  }

  public void setConductorFieldCross(String conuctorFieldCross) {
    this.conductorFieldCross = conuctorFieldCross;
  }

  public String getConductorFieldCrossBoard() {
    return conductorFieldCrossBoard;
  }

  public void setConductorFieldCrossBoard(String conductorFieldCrossBoard) {
    this.conductorFieldCrossBoard = conductorFieldCrossBoard;
  }

  public String getTerminalBlock() {
    return terminalBlock;
  }

  public void setTerminalBlock(String terminalBlock) {
    this.terminalBlock = terminalBlock;
  }

}
