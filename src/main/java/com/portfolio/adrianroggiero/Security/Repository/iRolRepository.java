
package com.portfolio.adrianroggiero.Security.Repository;

import com.portfolio.adrianroggiero.Security.Entity.Rol;
import com.portfolio.adrianroggiero.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rogg2
 */

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
