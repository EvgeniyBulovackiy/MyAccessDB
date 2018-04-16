package models;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@MappedSuperclass
public class AbstractData {

  @OneToOne
  @JoinColumn(name = "Система")
  private System system;

  @OneToOne
  @JoinColumn(name = "Объект")
  private Objects object;

  @OneToOne
  @JoinColumn(name = "[Объект 1]")
  @NotFound(action = NotFoundAction.IGNORE)
  private Objects1 object1;

  @Column(name = "[Позиция по проекту]")
  private String positionInProject;

  @Column(name = "[Наименование параметра]")
  private String parameter;

  @Column(name = "Тэг")
  private String tag;

  @Column(name = "[Номер модуля п/п]")
  private String moduleNumber;

  @Column(name = "[Номер канала]")
  private String chanelNumber;

  @OneToOne
  @JoinColumn(name = "[Вид сигнала]")
  private SignalKinds kindOfSignal;

  @OneToOne
  @JoinColumn(name = "Контроллер")
  private Controller controller;

  @OneToOne
  @JoinColumn(name = "[Код единицы измерения]")
  private Unit unitOfMeasurement;

  @Column(name = "[Нижний ПИП]")
  private String lowerPIP;

  @Column(name = "[Верхний ПИП]")
  private String upperPIP;

  @Column(name = "[ЩитСтойка]")
  private String board;

  @OneToOne
  @JoinColumn(name = "[Тип сигнала]")
  private SignalType signalType;

  @Column(name = "Коментарий")
  private String comment;

  @Column(name = "[Канал контроллера]")
  private String controllerChanel;

  @Column(name = "Примечание")
  private String note;

  @Column(name = "[КонтроллерКлемма]")
  private String terminalController;

  @Column(name = "[Тип Кабеля]")
  private String cableType;

  @Column(name = "Пояснение")
  private String explanation;

  @Column(name = "[Тип контакта]")
  private String contactType;

  @Column(name = "[Тип модуля]")
  private String moduleType;

  @Column(name = "ТипКлапана")
  private String valveType;

  @Column(name = "ТипРегулятора")
  private String controllerType;

  @Column(name = "faceplate")
  private String faceplate;

  @Column(name = "detail")
  private String detail;

  @Column(name = "pic")
  private String pic;

  @Column(name = "klass")
  private String klass;

  @Id
  @Column(name = "s_GUID", unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long sGUID;

  public System getSystem() {
    return system;
  }

  public void setSystem(System system) {
    this.system = system;
  }

  public Objects getObject() {
    return object;
  }

  public void setObject(Objects object) {
    this.object = object;
  }

  public Objects1 getObject1() {
    return object1;
  }

  public void setObject1(Objects1 object1) {
    this.object1 = object1;
  }

  public String getPositionInProject() {
    return positionInProject;
  }

  public void setPositionInProject(String positionInProject) {
    this.positionInProject = positionInProject;
  }

  public String getParameter() {
    return parameter;
  }

  public void setParameter(String parameter) {
    this.parameter = parameter;
  }

  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }

  public String getModuleNumber() {
    return moduleNumber;
  }

  public void setModuleNumber(String moduleNumber) {
    this.moduleNumber = moduleNumber;
  }

  public String getChanelNumber() {
    return chanelNumber;
  }

  public void setChanelNumber(String chanelNumber) {
    this.chanelNumber = chanelNumber;
  }

  public SignalKinds getKindOfSignal() {
    return kindOfSignal;
  }

  public void setKindOfSignal(SignalKinds kindOfSignal) {
    this.kindOfSignal = kindOfSignal;
  }

  public Controller getController() {
    return controller;
  }

  public void setController(Controller controller) {
    this.controller = controller;
  }

  public Unit getUnitOfMeasurement() {
    return unitOfMeasurement;
  }

  public void setUnitOfMeasurement(Unit unitOfMeasurement) {
    this.unitOfMeasurement = unitOfMeasurement;
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

  public String getBoard() {
    return board;
  }

  public void setBoard(String board) {
    this.board = board;
  }

  public SignalType getSignalType() {
    return signalType;
  }

  public void setSignalType(SignalType sygnalType) {
    this.signalType = sygnalType;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getControllerChanel() {
    return controllerChanel;
  }

  public void setControllerChanel(String controllerChanel) {
    this.controllerChanel = controllerChanel;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public String getTerminalController() {
    return terminalController;
  }

  public void setTerminalController(String terminalController) {
    this.terminalController = terminalController;
  }

  public String getCableType() {
    return cableType;
  }

  public void setCableType(String cableType) {
    this.cableType = cableType;
  }

  public String getExplanation() {
    return explanation;
  }

  public void setExplanation(String explanation) {
    this.explanation = explanation;
  }

  public String getContactType() {
    return contactType;
  }

  public void setContactType(String contactType) {
    this.contactType = contactType;
  }

  public String getModuleType() {
    return moduleType;
  }

  public void setModuleType(String moduleType) {
    this.moduleType = moduleType;
  }

  public String getValveType() {
    return valveType;
  }

  public void setValveType(String valveType) {
    this.valveType = valveType;
  }

  public String getControllerType() {
    return controllerType;
  }

  public void setControllerType(String contollerType) {
    this.controllerType = contollerType;
  }

  public String getFaceplate() {
    return faceplate;
  }

  public void setFaceplate(String faceplate) {
    this.faceplate = faceplate;
  }

  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  public String getPic() {
    return pic;
  }

  public void setPic(String pic) {
    this.pic = pic;
  }

  public String getKlass() {
    return klass;
  }

  public void setKlass(String klass) {
    this.klass = klass;
  }

  public long getsGUID() {
    return sGUID;
  }

  public void setsGUID(long sGUID) {
    this.sGUID = sGUID;
  }
}
