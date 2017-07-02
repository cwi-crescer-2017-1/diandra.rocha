package br.com.crescer.imovie.repositorio;

import br.com.crescer.imovie.entidade.Usuario;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author diandra.rocha
 */
public interface UsuarioRepositorio extends PagingAndSortingRepository<Usuario, Long> {
    
  @Override
  List<Usuario> findAll();
  
  Usuario findByEmail(String email);
  
  @Override
  Usuario save(Usuario user);
  
  @Override
  void delete(Usuario user);
  
}