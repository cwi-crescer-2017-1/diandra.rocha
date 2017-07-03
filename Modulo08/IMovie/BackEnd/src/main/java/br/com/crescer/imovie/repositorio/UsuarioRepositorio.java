package br.com.crescer.imovie.repositorio;

import br.com.crescer.imovie.entidade.Usuario;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author diandra.rocha
 */
public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {
    
  List<Usuario> findAll();
  
  Usuario findByEmail(String email);
  
}