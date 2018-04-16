package models;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Data extends AbstractData{

  @Column(name="Жила")
  private String conductor;

  @Column(name="[Кабель поле/кросс-щит]")
  private String cabelFieldCrosBoard;

  @Column(name="[Клеммник поле-кросс]")
  private String terminalBlockFieldCross;

  @Column(name = "[Кабель поле-кросс]")
  private String cableFieldCross;

  @Column(name = "[Жила поле-кросс]")
  private String conductorFieldCross;

  @Column(name = "[Жила поле/кросс-щит]")
  private String conductorFieldCrossBoard;

  @Column(name = "[Клемник: поле/кросс-контроллер]")
  private String terminalBlock;

  public String getCableFieldCross() {
    return cableFieldCross;
  }

  public void setCableFieldCross(String cableFieldCross) {
    this.cableFieldCross = cableFieldCross;
  }

  public String getConductor() {
    return conductor;
  }

  public void setConductor(String conductor) {
    this.conductor = conductor;
  }

  public String getCabelFieldCrosBoard() {
    return cabelFieldCrosBoard;
  }

  public void setCabelFieldCrosBoard(String cabelFieldCrosBoard) {
    this.cabelFieldCrosBoard = cabelFieldCrosBoard;
  }

  public String getTerminalBlockFieldCross() {
    return terminalBlockFieldCross;
  }

  public void setTerminalBlockFieldCross(String terminalBlockFieldCross) {
    this.terminalBlockFieldCross = terminalBlockFieldCross;
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
