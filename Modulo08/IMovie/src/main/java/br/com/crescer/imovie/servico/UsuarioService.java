package br.com.crescer.imovie.servico;

import br.com.crescer.imovie.entidade.Usuario;
import br.com.crescer.imovie.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author diandra.rocha
 */
@Service
public class UsuarioService {
    
    @Autowired
    UsuarioRepositorio repo;
    BCryptPasswordEncoder cript = new BCryptPasswordEncoder();
    
    public Usuario encontrarUsuario(String email){
        return repo.findByEmail(email);
    }
    
    public Usuario salvar(Usuario user) throws Exception{
        
        if(user.getSenha() == null || user.getEmail() == null){
            throw new Exception("Usuário inválido");
        }
        
        user.setSenha(cript.encode(user.getSenha()));
        return repo.save(user);
    }
    
    public Usuario obterUsuario (long id){
        return repo.findOne(id);
    }
    
}