package br.com.crescer.imovie.repositorio;

import br.com.crescer.imovie.entidade.Comentario;
import br.com.crescer.imovie.entidade.Post;
import java.awt.print.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Diandra Rocha
 */
public interface ComentarioRepositorio extends CrudRepository<Comentario, Long> {

  Page<Comentario> findByPostOrderByDatacomentarioDesc(Post post, Pageable pageable);
    
  @Override
  Comentario save(Comentario comentario);
  
  @Override
  void delete(Comentario comentario);
}
