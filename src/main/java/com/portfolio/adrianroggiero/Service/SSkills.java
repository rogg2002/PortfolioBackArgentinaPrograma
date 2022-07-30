
package com.portfolio.adrianroggiero.Service;

import com.portfolio.adrianroggiero.Entity.Skills;
import com.portfolio.adrianroggiero.Repository.RSkills;
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
public class SSkills {
    @Autowired
    RSkills rSkills;
    public List<Skills> list(){
        return rSkills.findAll();  //lista todas las habilidades
    }
    public Optional<Skills> getOne(int id){
        return rSkills.findById(id);   //busca por id
    }
    public Optional<Skills> getByNombreH(String nombreH){
        return rSkills.findByNombreH(nombreH);   // busca por nombre
    }
    public void save(Skills ski){
        rSkills.save(ski);    //guarda datos
    }
    public void delete(int id){
        rSkills.deleteById(id); //borra por id
    }
    public boolean existsById(int id){
        return rSkills.existsById(id);  //existe objeto por id??
    }
    public boolean existsByNombreH(String nombreH){
        return rSkills.existsByNombreH(nombreH);  // existe por nombre??
    }
    
}
