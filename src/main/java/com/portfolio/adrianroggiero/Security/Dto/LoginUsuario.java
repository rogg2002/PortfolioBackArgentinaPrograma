
package com.portfolio.adrianroggiero.Security.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author rogg2
 */
public class LoginUsuario {
    @NotBlank 
    private String nombreUsuario;
    @NotBlank
    private String password;
    
    // consultas g & s

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
