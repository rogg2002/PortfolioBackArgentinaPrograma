
package com.portfolio.adrianroggiero.Service;

import com.portfolio.adrianroggiero.Entity.Educacion;
import com.portfolio.adrianroggiero.Repository.REducacion;
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
public class SEducacion {
    @Autowired
    REducacion rEducacion;
public List<Educacion> list(){
        return rEducacion.findAll();  //lista todas la educacion
    }
    public Optional<Educacion> getOne(int id){
        return rEducacion.findById(id);   //busca por id
    }
    public Optional<Educacion> getByNombreEdu(String nombreEdu){
        return rEducacion.findByNombreEdu(nombreEdu);   // busca por nombre
    }
    public void save(Educacion edu){
        rEducacion.save(edu);    //guarda datos
    }
    public void delete(int id){
        rEducacion.deleteById(id); //borra por id
    }
    public boolean existsById(int id){
        return rEducacion.existsById(id);  //existe objeto por id??
    }
    public boolean existsByNombreEdu(String nombreEdu){
        return rEducacion.existsByNombreEdu(nombreEdu);  // existe por nombre??
    }
    
}
