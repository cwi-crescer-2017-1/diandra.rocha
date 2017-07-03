package br.com.crescer.imovie.seguranca;

import br.com.crescer.imovie.entidade.Usuario;
import br.com.crescer.imovie.servico.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author carloshenrique
 */
@Service
public class SocialUserDetailsService implements UserDetailsService {
    
    @Autowired
    UsuarioService user;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario u =  user.encontrarUsuario(email);
        
        if (u == null) {
            throw new UsernameNotFoundException(String.format("Não encontrado um usuário com esse e-mail %s", email));
        }
        
        return new User( u.getEmail() , u.getSenha(), SocialRoles.valuesToList() );
    }

}