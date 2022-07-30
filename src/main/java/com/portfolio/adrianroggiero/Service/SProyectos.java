package com.portfolio.adrianroggiero.Service;

import com.portfolio.adrianroggiero.Entity.Proyectos;
import com.portfolio.adrianroggiero.Repository.RProyectos;
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
public class SProyectos {

    @Autowired
    RProyectos rProyectos;

    public List<Proyectos> list() {
        return rProyectos.findAll();  //lista todos los proyectos
    }

    public Optional<Proyectos> getOne(int id) {
        return rProyectos.findById(id);   //busca por id
    }

    public Optional<Proyectos> getByNombrePro(String nombrePro) {
        return rProyectos.findByNombrePro(nombrePro);   // busca por nombre
    }

    public void save(Proyectos proy) {
        rProyectos.save(proy);    //guarda datos
    }

    public void delete(int id) {
        rProyectos.deleteById(id); //borra por id
    }

    public boolean existsById(int id) {
        return rProyectos.existsById(id);  //existe objeto por id??
    }

    public boolean existsByNombrePro(String nombrePro) {
        return rProyectos.existsByNombrePro(nombrePro);  // existe por nombre??
    }

}
