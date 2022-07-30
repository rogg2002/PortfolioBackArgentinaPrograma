
package com.portfolio.adrianroggiero.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author rogg2
 */
public class dtoSkills {
    @NotBlank
    private String nombreH;
    @NotBlank
    private int progressH;
    
    //constructores

    public dtoSkills() {
    }

    public dtoSkills(String nombreH, int progressH) {
        this.nombreH = nombreH;
        this.progressH = progressH;
    }
    
    // consultas g y s

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
