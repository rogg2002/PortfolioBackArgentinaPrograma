
package com.portfolio.adrianroggiero.Controller;

import com.portfolio.adrianroggiero.Dto.dtoEducacion;
import com.portfolio.adrianroggiero.Entity.Educacion;
import com.portfolio.adrianroggiero.Security.Controller.Mensaje;
import com.portfolio.adrianroggiero.Service.SEducacion;
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
@RequestMapping("/educa")
@CrossOrigin(origins = "http://localhost:4200")
public class CEducacion {
    @Autowired
    SEducacion sEducacion;
    // listamos educacion
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = sEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
        @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!sEducacion.existsById(id))
            return new ResponseEntity(new Mensaje("no existe educacion"), HttpStatus.NOT_FOUND);
        Educacion educacion = sEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
        //borro eduacion
       @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe educacion"), HttpStatus.NOT_FOUND);
        }
        sEducacion.delete(id);
        return new ResponseEntity(new Mensaje("se elimino educacion"), HttpStatus.OK);
    }
        //creo educacion
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoedu){      
        if(StringUtils.isBlank(dtoedu.getNombreEdu()))
            return new ResponseEntity(new Mensaje("campo obligtorio"), HttpStatus.BAD_REQUEST);
        if(sEducacion.existsByNombreEdu(dtoedu.getNombreEdu()))
            return new ResponseEntity(new Mensaje("educacion no existe"), HttpStatus.BAD_REQUEST);
        
        Educacion educacion = new Educacion(dtoedu.getNombreEdu(), dtoedu.getDescripcionEdu());
        sEducacion.save(educacion);
        
        return new ResponseEntity(new Mensaje("se agrego educacion"), HttpStatus.OK);
    }
        // update a educacion
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoedu){
        //Validamos si existe el ID
        if(!sEducacion.existsById(id))
            return new ResponseEntity(new Mensaje("ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de educacion
        if(sEducacion.existsByNombreEdu(dtoedu.getNombreEdu()) && sEducacion.getByNombreEdu(dtoedu.getNombreEdu()).get().getId() != id)
            return new ResponseEntity(new Mensaje("educacion ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoedu.getNombreEdu()))
            return new ResponseEntity(new Mensaje("campo obligtorio"), HttpStatus.BAD_REQUEST);
        
        Educacion educacion = sEducacion.getOne(id).get();
        educacion.setNombreEdu(dtoedu.getNombreEdu());
        educacion.setDescripcionEdu((dtoedu.getDescripcionEdu()));
        
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("se actualizo educacion"), HttpStatus.OK);
             
    }
    
}