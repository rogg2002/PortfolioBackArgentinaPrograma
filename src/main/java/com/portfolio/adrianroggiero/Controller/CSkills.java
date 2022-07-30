
package com.portfolio.adrianroggiero.Controller;

import com.portfolio.adrianroggiero.Dto.dtoSkills;
import com.portfolio.adrianroggiero.Entity.Skills;
import com.portfolio.adrianroggiero.Security.Controller.Mensaje;
import com.portfolio.adrianroggiero.Service.SSkills;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rogg2
 */

@RestController
@RequestMapping("/skill")
@CrossOrigin(origins = "http://portfolioadrianroggiero.web.app")
public class CSkills {
    @Autowired
    SSkills sSkills;
    //listamos habilidad
    @GetMapping("/lista")
    public ResponseEntity<List<Skills>> list(){
        List<Skills> list = sSkills.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id") int id){
        if(!sSkills.existsById(id))
            return new ResponseEntity(new Mensaje("no existe habilidad"), HttpStatus.NOT_FOUND);
        Skills skills = sSkills.getOne(id).get();
        return new ResponseEntity(skills, HttpStatus.OK);
    }
    //borro habilidad
       @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sSkills.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe habilidad"), HttpStatus.NOT_FOUND);
        }
        sSkills.delete(id);
        return new ResponseEntity(new Mensaje("se elimino habilidad"), HttpStatus.OK);
    } 
    //creo habilidad
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkills dtoski){      
        if(StringUtils.isBlank(dtoski.getNombreH()))
            return new ResponseEntity(new Mensaje("campo obligtorio"), HttpStatus.BAD_REQUEST);
        if(sSkills.existsByNombreH(dtoski.getNombreH()))
            return new ResponseEntity(new Mensaje("Habilidad no existe"), HttpStatus.BAD_REQUEST);
        
        Skills skills = new Skills(dtoski.getNombreH(), dtoski.getProgressH());
        sSkills.save(skills);
        
        return new ResponseEntity(new Mensaje("se agrego habilidad"), HttpStatus.OK);
    }
    
    // update a habilidad
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSkills dtoski){
        //Validamos si existe el ID
        if(!sSkills.existsById(id))
            return new ResponseEntity(new Mensaje("ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de habilidad
        if(sSkills.existsByNombreH(dtoski.getNombreH()) && sSkills.getByNombreH(dtoski.getNombreH()).get().getId() != id)
            return new ResponseEntity(new Mensaje("habilidad ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoski.getNombreH()))
            return new ResponseEntity(new Mensaje("campo obligtorio"), HttpStatus.BAD_REQUEST);
        
        Skills skills = sSkills.getOne(id).get();
        skills.setNombreH(dtoski.getNombreH());
        skills.setProgressH((dtoski.getProgressH()));
        
        sSkills.save(skills);
        return new ResponseEntity(new Mensaje("se actualizo habilidad"), HttpStatus.OK);
             
    }
}
    
  


