
package com.portfolio.adrianroggiero.Repository;

import com.portfolio.adrianroggiero.Entity.Persona;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rogg2
 */

@Repository
public interface IPersonaRepository extends JpaRepository<Persona,Long>{
    
}


