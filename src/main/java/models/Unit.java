package models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="[Единицы измерения]")
public class Unit implements Serializable{
    
    @Id
    @Column(name="[Код единицы измерения]")
    private int code;
    
    @Column(name="[Единица измерения]")
    private String unit;
    
    @Column(name="Примечание")
    private String note;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Unit{" +
          "code=" + code +
          ", unit='" + unit + '\'' +
          ", note='" + note + '\'' +
          '}';
    }
}
