package br.com.crescer.imovie.repositorio;

import br.com.crescer.imovie.entidade.Post;
import br.com.crescer.imovie.entidade.Usuario;
import java.awt.print.Pageable;
import java.util.Set;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Diandra Rocha
 */
public interface PostRepositorio extends PagingAndSortingRepository<Post, Long> {
    
  Page<Post> findById(long id, Pageable pageable);
  
  Page<Post> findByIdUsuario(Usuario user, Pageable pageable);
  
  @Override
  Post findOne(Long id); 
  
  @Override 
  Post save(Post post);
  
  Page<Post> findByUsuarioOrderByDataPostDesc(Set<Usuario> usuario, Pageable pageable);
  
  @Override 
  void delete(Post post);
}
