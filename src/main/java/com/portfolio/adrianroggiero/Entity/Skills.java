
package com.portfolio.adrianroggiero.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author rogg2
 */
@Entity

public class Skills {
    // campos de la tabla
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreH;
    private int progressH;
    
    //construcor

    public Skills() {
    }

    public Skills(String nombreH, int progressH) {
        this.nombreH = nombreH;
        this.progressH = progressH;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreH() {
        return nombreH;
    }

    public void setNombreH(String nombreH) {
        this.nombreH = nombreH;
    }

    public int getProgressH() {
        return progressH;
    }

    public void setProgressH(int progressH) {
        this.progressH = progressH;
    }
    
    
    
}
