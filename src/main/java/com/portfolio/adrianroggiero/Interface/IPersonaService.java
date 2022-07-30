
package com.portfolio.adrianroggiero.Interface;

import com.portfolio.adrianroggiero.Entity.Persona;
import java.util.List;



/**
 *
 * @author rogg2
 */
public interface IPersonaService {
    
    public List<Persona> getPersona();//trae personas
    
    public void savePersona(Persona persona);//guarda objeto persona
    
    public void deletePersona(Long id); //borra objeto persona
    
    public Persona findPersona(Long id); //busca objeto persona
    
    
}
