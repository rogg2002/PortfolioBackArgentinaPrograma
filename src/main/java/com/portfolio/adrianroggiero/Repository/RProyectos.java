
package com.portfolio.adrianroggiero.Repository;

import com.portfolio.adrianroggiero.Entity.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rogg2
 */
@Repository
public interface RProyectos extends JpaRepository<Proyectos, Integer>{
    public Optional<Proyectos> findByNombrePro(String nombrePro);
    public boolean  existsByNombrePro(String nombrePro);
    
}
