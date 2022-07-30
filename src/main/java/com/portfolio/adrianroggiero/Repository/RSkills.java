
package com.portfolio.adrianroggiero.Repository;

import com.portfolio.adrianroggiero.Entity.Skills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rogg2
 */
@Repository
public interface RSkills extends JpaRepository<Skills, Integer>{
    public Optional<Skills> findByNombreH(String nombreH);
    public boolean existsByNombreH(String nombreH);
}
