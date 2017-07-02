package br.com.crescer.imovie.repositorio;

import br.com.crescer.imovie.entidade.Curtida;
import br.com.crescer.imovie.entidade.Post;
import br.com.crescer.imovie.entidade.Usuario;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Diandra Rocha
 */
public interface CurtidaRepositorio extends CrudRepository<Curtida, Long> {
    
  List<Curtida> findByIdpost(Post post);
  
  Curtida findByIdusuario(Usuario usuario);
  
  @Override
  Curtida save(Curtida curtida);
  
  @Override
  void delete(Curtida curtida);
    
}
