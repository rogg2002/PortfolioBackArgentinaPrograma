
package com.portfolio.adrianroggiero.Security.Controller;

import com.portfolio.adrianroggiero.Security.Dto.JwtDto;
import com.portfolio.adrianroggiero.Security.Dto.LoginUsuario;
import com.portfolio.adrianroggiero.Security.Dto.NuevoUsuario;
import com.portfolio.adrianroggiero.Security.Entity.Rol;
import com.portfolio.adrianroggiero.Security.Entity.Usuario;
import com.portfolio.adrianroggiero.Security.Enums.RolNombre;
import com.portfolio.adrianroggiero.Security.Service.RolService;
import com.portfolio.adrianroggiero.Security.Service.UsuarioService;
import com.portfolio.adrianroggiero.Security.jwt.JwtProvider;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rogg2
 */
@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    RolService rolService;
    @Autowired
    JwtProvider jwtProvider;
    
    @PostMapping("/nuevo")
    
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje ("Verificar usuario o email"),HttpStatus.BAD_REQUEST);
        if (usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario()))
            return new ResponseEntity(new Mensaje("Usuario ya existe"),HttpStatus.BAD_REQUEST);
        if (usuarioService.existsByEmail(nuevoUsuario.getEmail()))
            return new ResponseEntity(new Mensaje("Email ya existe"),HttpStatus.BAD_REQUEST);
        Usuario usuario=new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(), nuevoUsuario.getEmail(), passwordEncoder.encode(nuevoUsuario.getPassword()));
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
        
        if(nuevoUsuario.getRoles().contains("admin"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        usuario.setRoles(roles);
        usuarioService.save(usuario);
        
        return new ResponseEntity(new Mensaje("Se guardo usuario"),HttpStatus.CREATED);
    }
    
    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
          if (bindingResult.hasErrors())
              return new ResponseEntity(new Mensaje("Error al ingresar campos"),HttpStatus.BAD_REQUEST);
          Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
          
          SecurityContextHolder.getContext().setAuthentication(authentication);
          String jwt = jwtProvider.generateToken(authentication);
          UserDetails userDetails = (UserDetails) authentication.getPrincipal();
          JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
          
          return new ResponseEntity(jwtDto, HttpStatus.OK);
          
    }
}
