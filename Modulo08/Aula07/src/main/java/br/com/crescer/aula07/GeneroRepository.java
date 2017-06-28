package br.com.crescer.aula07;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Carlos H. Nonnemacher
 */
public interface GeneroRepository extends CrudRepository<Genero, Long> {
    
  @Override
  List<Genero> findAll();
  
  @Override
  Genero save(Genero genero);

}