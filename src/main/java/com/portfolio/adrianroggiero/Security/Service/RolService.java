
package com.portfolio.adrianroggiero.Security.Service;

import com.portfolio.adrianroggiero.Security.Entity.Rol;
import com.portfolio.adrianroggiero.Security.Enums.RolNombre;
import com.portfolio.adrianroggiero.Security.Repository.iRolRepository;
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
public class RolService {
    @Autowired
    iRolRepository irolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return irolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        irolRepository.save(rol);
    }
}
