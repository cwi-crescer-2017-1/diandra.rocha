package br.com.crescer.imovie.repositorio;

import br.com.crescer.imovie.entidade.Comentario;
import br.com.crescer.imovie.entidade.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Diandra Rocha
 */
public interface ComentarioRepositorio extends PagingAndSortingRepository<Comentario, Long> {

  Page<Comentario> findByIdpostOrderByDatacomentarioDesc(Post post, Pageable pageable);
    
  @Override
  Comentario save(Comentario comentario);
  
  @Override
  void delete(Comentario comentario);
}
