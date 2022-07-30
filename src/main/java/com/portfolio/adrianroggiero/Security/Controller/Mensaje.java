
package com.portfolio.adrianroggiero.Security.Controller;

/**
 *
 * @author rogg2
 */
public class Mensaje {
    private String mensaje;
    
    
    //defino constructores

    public Mensaje() {
    }

    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    //consultas g & s

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
     
    
}
