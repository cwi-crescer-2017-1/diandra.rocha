package br.com.crescer.aula07;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author diandra.rocha
 */

@RestController
@RequestMapping("/genero")
public class Controller {
    
    @Autowired
    GeneroService service;
    
   @GetMapping
    public List<Genero> list() {
        return service.findAll(); 
    }   
    
    @PostMapping
    public Genero salvar(Genero genero){
        return service.save(genero);
    }
    
}