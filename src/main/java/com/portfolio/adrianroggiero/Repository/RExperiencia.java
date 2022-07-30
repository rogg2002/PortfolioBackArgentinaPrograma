
package com.portfolio.adrianroggiero.Repository;

import com.portfolio.adrianroggiero.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rogg2
 */

@Repository
public interface RExperiencia extends JpaRepository<Experiencia, Integer>{
    public Optional<Experiencia> findByNombreE(String nombreE);
    public boolean  existsByNombreE(String nombreE);
}
