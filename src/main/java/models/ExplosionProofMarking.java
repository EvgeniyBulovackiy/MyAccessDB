package models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="[Маркировка взрывозащиты]")
public class ExplosionProofMarking implements Serializable {
    @Id
    @Column(name="Код")
    private int code;
    
    @Column(name="Ex")
    private String ex;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }
}
