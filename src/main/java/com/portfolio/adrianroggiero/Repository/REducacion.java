
package com.portfolio.adrianroggiero.Repository;

import com.portfolio.adrianroggiero.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rogg2
 */

@Repository
public interface REducacion extends JpaRepository<Educacion, Integer>{
    public Optional<Educacion> findByNombreEdu(String nombreEdu);
    public boolean  existsByNombreEdu(String nombreEdu);
    
}
