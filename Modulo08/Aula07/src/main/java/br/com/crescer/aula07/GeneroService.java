package br.com.crescer.aula07;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author diandra.rocha
 */
@Service
public class GeneroService {
    
    @Autowired
    GeneroRepository repo;
    
    
    public List<Genero> findAll(){
        return repo.findAll();
    }
    
    public Genero save(Genero genero){
        return repo.save(genero);
        
    }
    
}
