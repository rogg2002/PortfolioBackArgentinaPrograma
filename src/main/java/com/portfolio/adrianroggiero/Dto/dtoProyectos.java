
package com.portfolio.adrianroggiero.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author rogg2
 */


public class dtoProyectos {
    @NotBlank
    private String nombrePro;
    @NotBlank
    private String descripcionPro;
    
    private String linkPro;
    
    //constructores

    public dtoProyectos() {
    }

    public dtoProyectos(String nombrePro, String descripcionPro, String linkPro) {
        this.nombrePro = nombrePro;
        this.descripcionPro = descripcionPro;
        this.linkPro = linkPro;
    }
    
    //consultas g y s

    public String getNombrePro() {
        return nombrePro;
    }

    public void setNombrePro(String nombrePro) {
        this.nombrePro = nombrePro;
    }

    public String getDescripcionPro() {
        return descripcionPro;
    }

    public void setDescripcionPro(String descripcionPro) {
        this.descripcionPro = descripcionPro;
    }

    public String getLinkPro() {
        return linkPro;
    }

    public void setLinkPro(String linkPro) {
        this.linkPro = linkPro;
    }
    
    
}
