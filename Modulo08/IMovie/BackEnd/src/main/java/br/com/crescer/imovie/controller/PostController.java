package br.com.crescer.imovie.controller;

import br.com.crescer.imovie.entidade.Post;
import br.com.crescer.imovie.entidade.Usuario;
import br.com.crescer.imovie.servico.ComponenteService;
import br.com.crescer.imovie.servico.PostService;
import br.com.crescer.imovie.servico.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Diandra Rocha
 */
@RestController
public class PostController {

    @Autowired
    PostService service;
    @Autowired
    ComponenteService componente;
    @Autowired
    UsuarioService service1;
    

    @GetMapping(value = "/feed/{id}")
    public Page<Post> feedAlheio(@PathVariable long id, Pageable p) {
        Usuario user = service1.obterUsuario(id);
        return service.feedAlheio(user, p);
    }

    @GetMapping(value = "/feed")
    public Page<Post> meuFeed(Pageable pageable) {
        Usuario user = componente.getUserSession();
        return service.feed(user, pageable);
    }

    @GetMapping(value = "/meufeed")
    public Page<Post> feed(Pageable p) {
        Usuario user = componente.getUserSession();
        return service.meuFeed(user, p);
    }
    
    @PostMapping(value = "/salvarpost")
    public Post salvarPost(@RequestBody Post post){
        
        return service.salvar(post, componente.getUserSession());
    }
    
    @DeleteMapping(value = "/deletarpost/{id}")
    public void deletarPost(@PathVariable long id){
        service.excluir(id);
    }
    
    @GetMapping("/post/{id}")
    public Post obterTodoPost(@PathVariable long id){
        return service.buscarPorId(id);
    }
}