
package com.portfolio.adrianroggiero.Service;

import com.portfolio.adrianroggiero.Entity.Experiencia;
import com.portfolio.adrianroggiero.Repository.RExperiencia;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author rogg2
 */
@Service
@Transactional 
public class SExperiencia {
    @Autowired
    RExperiencia rExperiencia;
    public List<Experiencia> list(){
        return rExperiencia.findAll();  //lista todas las experiencias
    }
    public Optional<Experiencia> getOne(int id){
        return rExperiencia.findById(id);   //busca por id
    }
    public Optional<Experiencia> getByNombreE(String nombreE){
        return rExperiencia.findByNombreE(nombreE);   // busca por nombre
    }
    public void save(Experiencia expe){
        rExperiencia.save(expe);    //guarda datos
    }
    public void delete(int id){
        rExperiencia.deleteById(id); //borra por id
    }
    public boolean existsById(int id){
        return rExperiencia.existsById(id);  //existe objeto por id??
    }
    public boolean existsByNombreE(String nombreE){
        return rExperiencia.existsByNombreE(nombreE);  // existe por nombre??
    }
    
}
