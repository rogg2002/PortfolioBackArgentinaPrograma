
package com.portfolio.adrianroggiero.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author rogg2
 */
public class dtoEducacion {
    @NotBlank
    private String nombreEdu;
    @NotBlank
    private String descripcionEdu;
    
    //constructores

    public dtoEducacion() {
    }

    public dtoEducacion(String nombreEdu, String descripcionEdu) {
        this.nombreEdu = nombreEdu;
        this.descripcionEdu = descripcionEdu;
    }
    
    //consultas g y s

    public String getNombreEdu() {
        return nombreEdu;
    }

    public void setNombreEdu(String nombreEdu) {
        this.nombreEdu = nombreEdu;
    }

    public String getDescripcionEdu() {
        return descripcionEdu;
    }

    public void setDescripcionEdu(String descripcionEdu) {
        this.descripcionEdu = descripcionEdu;
    }
    
    
    
}
