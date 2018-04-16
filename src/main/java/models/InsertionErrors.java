package models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="[Ошибки вставки]")
public class InsertionErrors implements Serializable {
    @Id
    @Column(name="Поле0")
    private String field0;

    public String getField0() {
        return field0;
    }

    public void setField0(String field0) {
        this.field0 = field0;
    }
    
    
}
