package br.com.crescer.imovie.servico;

import br.com.crescer.imovie.entidade.Usuario;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

/**
 *
 * @author Diandra Rocha
 */
@Component
public class ComponenteService {
    
    @Autowired
    UsuarioService service;
    
    public Usuario getUserSession() {
        return Optional
                .ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .map(Authentication::getPrincipal)
                .map(User.class::cast)
                .map(User::getUsername)
                .map(service::encontrarUsuario)
                .orElse(null);
    }
    
}
