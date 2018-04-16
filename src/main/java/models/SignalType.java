
package models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="[Типы сигналов]")
public class SignalType implements Serializable{
    
    @Id
    @Column(name = "[Код сигнала]")
    private String codeOfSignal;

    @Column(name="[Тип сигнала]")
    private String signalType;
    
    @Column(name="Поле1")
    private String field1;
    
    @Column(name="[Объект 1]")
    private String object1;
    
    @Column(name="[Позиция по проекту]")
    private String positionInProject;
    
    @Column(name="Тэг")
    private String tag;
    
    @Column(name="[Наименование параметра]")
    private String parameterName;
    
    @Column(name="[Вид сигнала]")
    private String signalKind;
    
    @Column(name="[Тип сигнала1]")
    private String signalTypeSecond;
    
    @Column(name="[Код единицы измерения]")
    private String unit;
    
    @Column(name="[Нижний ПИП]")
    private String lowerPIP;
    
    @Column(name="[Верхний ПИП]")
    private String upperPIP;
    
    @Column(name="LoLo")
    private String loLo;
    
    @Column(name="Lo")
    private String lo;
    
    @Column(name="Hi")
    private String hi;
    
    @Column(name="HiHi")
    private String hiHi;
    
    @Column(name="[Кабель поле-щит]")
    private String cabelFieldBoard;
    
    @Column(name="[Жила поле-щит]")
    private String conductorFieldBoard;
    
    @Column(name="[Клемник: поле-контроллер]")
    private String terminalBlockFieldController;
    
    @Column(name="[ЩитСтойка]")
    private String board;
    
    @Column(name="Контроллер")
    private String controller;
    
    @Column(name="[Канал контроллера]")
    private String controllerChanel;
    
    @Column(name="[Номер шасси п/п]")
    private String numberOfChassis;
    
    @Column(name="[Номер модуля п/п]")
    private String numberOfModule;
    
    @Column(name="[Номер канала]")
    private String numberOfChanel;
    
    @Column(name="КонтроллерКлемма")
    private String controllerTerminal;
    
    @Column(name="[Тип контакта]")
    private String contactType;
    
    @Column(name="Примечание")
    private String note;

    public String getCodeOfSignal() {
        return codeOfSignal;
    }

    public void setCodeOfSignal(String codeOfSignal) {
        this.codeOfSignal = codeOfSignal;
    }

    public String getSignalType() {
        return signalType;
    }

    public void setSignalType(String signalType) {
        this.signalType = signalType;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getObject1() {
        return object1;
    }

    public void setObject1(String object1) {
        this.object1 = object1;
    }

    public String getPositionInProject() {
        return positionInProject;
    }

    public void setPositionInProject(String positionInProject) {
        this.positionInProject = positionInProject;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public String getSignalKind() {
        return signalKind;
    }

    public void setSignalKind(String signalKind) {
        this.signalKind = signalKind;
    }

    public String getSignalTypeSecond() {
        return signalTypeSecond;
    }

    public void setSignalTypeSecond(String signalTypeSecond) {
        this.signalTypeSecond = signalTypeSecond;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getLowerPIP() {
        return lowerPIP;
    }

    public void setLowerPIP(String lowerPIP) {
        this.lowerPIP = lowerPIP;
    }

    public String getUpperPIP() {
        return upperPIP;
    }

    public void setUpperPIP(String upperPIP) {
        this.upperPIP = upperPIP;
    }

    public String getLoLo() {
        return loLo;
    }

    public void setLoLo(String loLo) {
        this.loLo = loLo;
    }

    public String getLo() {
        return lo;
    }

    public void setLo(String lo) {
        this.lo = lo;
    }

    public String getHi() {
        return hi;
    }

    public void setHi(String hi) {
        this.hi = hi;
    }

    public String getHiHi() {
        return hiHi;
    }

    public void setHiHi(String hiHi) {
        this.hiHi = hiHi;
    }

    public String getCabelFieldBoard() {
        return cabelFieldBoard;
    }

    public void setCabelFieldBoard(String cabelFieldBoard) {
        this.cabelFieldBoard = cabelFieldBoard;
    }

    public String getConductorFieldBoard() {
        return conductorFieldBoard;
    }

    public void setConductorFieldBoard(String conductorFieldBoard) {
        this.conductorFieldBoard = conductorFieldBoard;
    }

    public String getTerminalBlockFieldController() {
        return terminalBlockFieldController;
    }

    public void setTerminalBlockFieldController(String terminalBlockFieldController) {
        this.terminalBlockFieldController = terminalBlockFieldController;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public String getController() {
        return controller;
    }

    public void setController(String controller) {
        this.controller = controller;
    }

    public String getControllerChanel() {
        return controllerChanel;
    }

    public void setControllerChanel(String controllerChanel) {
        this.controllerChanel = controllerChanel;
    }

    public String getNumberOfChassis() {
        return numberOfChassis;
    }

    public void setNumberOfChassis(String numberOfChassis) {
        this.numberOfChassis = numberOfChassis;
    }

    public String getNumberOfModule() {
        return numberOfModule;
    }

    public void setNumberOfModule(String numberOfModule) {
        this.numberOfModule = numberOfModule;
    }

    public String getNumberOfChanel() {
        return numberOfChanel;
    }

    public void setNumberOfChanel(String numberOfChanel) {
        this.numberOfChanel = numberOfChanel;
    }

    public String getControllerTerminal() {
        return controllerTerminal;
    }

    public void setControllerTerminal(String controllerTerminal) {
        this.controllerTerminal = controllerTerminal;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return signalType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SignalType that = (SignalType) o;
        return Objects.equals(codeOfSignal, that.codeOfSignal) &&
          Objects.equals(signalType, that.signalType) &&
          Objects.equals(field1, that.field1) &&
          Objects.equals(object1, that.object1) &&
          Objects.equals(positionInProject, that.positionInProject) &&
          Objects.equals(tag, that.tag) &&
          Objects.equals(parameterName, that.parameterName) &&
          Objects.equals(signalKind, that.signalKind) &&
          Objects.equals(signalTypeSecond, that.signalTypeSecond) &&
          Objects.equals(unit, that.unit) &&
          Objects.equals(lowerPIP, that.lowerPIP) &&
          Objects.equals(upperPIP, that.upperPIP) &&
          Objects.equals(loLo, that.loLo) &&
          Objects.equals(lo, that.lo) &&
          Objects.equals(hi, that.hi) &&
          Objects.equals(hiHi, that.hiHi) &&
          Objects.equals(cabelFieldBoard, that.cabelFieldBoard) &&
          Objects.equals(conductorFieldBoard, that.conductorFieldBoard) &&
          Objects.equals(terminalBlockFieldController, that.terminalBlockFieldController) &&
          Objects.equals(board, that.board) &&
          Objects.equals(controller, that.controller) &&
          Objects.equals(controllerChanel, that.controllerChanel) &&
          Objects.equals(numberOfChassis, that.numberOfChassis) &&
          Objects.equals(numberOfModule, that.numberOfModule) &&
          Objects.equals(numberOfChanel, that.numberOfChanel) &&
          Objects.equals(controllerTerminal, that.controllerTerminal) &&
          Objects.equals(contactType, that.contactType) &&
          Objects.equals(note, that.note);
    }

    @Override
    public int hashCode() {

        return Objects.hash(codeOfSignal, signalType, field1, object1, positionInProject, tag, parameterName, signalKind, signalTypeSecond, unit, lowerPIP, upperPIP, loLo, lo, hi, hiHi, cabelFieldBoard, conductorFieldBoard, terminalBlockFieldController, board, controller, controllerChanel, numberOfChassis, numberOfModule, numberOfChanel, controllerTerminal, contactType, note);
    }
}
