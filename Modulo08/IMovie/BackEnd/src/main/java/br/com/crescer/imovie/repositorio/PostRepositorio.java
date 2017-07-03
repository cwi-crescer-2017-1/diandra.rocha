package br.com.crescer.imovie.repositorio;

import br.com.crescer.imovie.entidade.Post;
import br.com.crescer.imovie.entidade.Usuario;
import java.util.Set;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Diandra Rocha
 */
public interface PostRepositorio extends PagingAndSortingRepository<Post, Long> {
    
    
  Page<Post> findByIdusuario(Usuario idusuario, Pageable p);
  
  @Override
  Post findOne(Long id); 
  
  @Override 
  Post save(Post post);
  
  Page<Post> findByIdusuarioInOrderByDatapostDesc(Set<Usuario> usuario, Pageable pageable);
  
  @Override 
  void delete(Post post);
}
