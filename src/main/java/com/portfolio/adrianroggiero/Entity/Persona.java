
package com.portfolio.adrianroggiero.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author rogg2
 */
@Getter
@Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 3, max = 50)
    private String nombre;
    @NotNull
    @Size(min=3, max=50)
    private String apellido;
    @NotNull
    @Size(min=1, max=50)
    private String img;
    
    
    //constructor

    public Persona() {
    }

    public Persona(String nombre, String apellido, String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
    }
    
    
    
}
