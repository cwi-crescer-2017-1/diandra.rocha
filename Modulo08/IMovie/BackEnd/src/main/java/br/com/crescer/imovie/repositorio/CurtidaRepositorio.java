package br.com.crescer.imovie.repositorio;

import br.com.crescer.imovie.entidade.Curtida;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Diandra Rocha
 */
public interface CurtidaRepositorio extends CrudRepository<Curtida, Long> {
    
  @Override
  List<Curtida> findAll();
  
  @Override
  Curtida save(Curtida curtida);
  
  @Override
  void delete(Curtida curtida);
    
}
