package br.com.crescer.imovie.controller;

import br.com.crescer.imovie.entidade.Curtida;
import br.com.crescer.imovie.entidade.Post;
import br.com.crescer.imovie.entidade.Usuario;
import br.com.crescer.imovie.servico.ComponenteService;
import br.com.crescer.imovie.servico.CurtidaService;
import br.com.crescer.imovie.servico.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Diandra Rocha
 */

@RestController
public class CurtidaController {
    
    @Autowired
    CurtidaService service;
    
    @Autowired
    PostService serviceP;
    
    @Autowired
    ComponenteService componente;
  
    
    @GetMapping(value = "/curtir/{id}")
    public Curtida adicionarCurtida(@PathVariable long id){
        Usuario curtidor = componente.getUserSession();
        Post curtido = serviceP.buscar(id);
        Curtida curtida = new Curtida(curtidor, curtido);
        
        service.salvar(curtida, curtido, curtidor);
        return curtida;
        
    }
    
    @DeleteMapping(value = "/descurtir/{id}")
    public void retirarCurtida(@PathVariable long id){
        Usuario user = componente.getUserSession();
        Curtida excluir = service.encontrarPorUsuario(user);
        service.excluir(excluir);
    }
}
