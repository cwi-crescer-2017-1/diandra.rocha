package br.com.crescer.imovie.controller;

import br.com.crescer.imovie.entidade.Comentario;
import br.com.crescer.imovie.entidade.Post;
import br.com.crescer.imovie.entidade.Usuario;
import br.com.crescer.imovie.servico.ComentarioService;
import br.com.crescer.imovie.servico.ComponenteService;
import br.com.crescer.imovie.servico.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Diandra Rocha
 */
@RestController
public class ComentarioController {
    
    @Autowired
    PostService service2;
    @Autowired
    ComentarioService service; //Gambi Design Pattern
    @Autowired
    ComponenteService componente;
    
    @DeleteMapping("/descomentar/{id}")
    public void deletarComentario(@PathVariable long id){
        Comentario excluir = service.buscarPorId(id);
        service.excluir(excluir);
    }
  
    @PostMapping(value = "/comentar/{id}")
    public Comentario adicionarComentario(@PathVariable long id, @RequestBody Comentario comentario){
        Usuario user = componente.getUserSession();
        Post adicionar = service2.buscar(id);
        
        return service.salvar(adicionar,user,comentario);
    }
}
