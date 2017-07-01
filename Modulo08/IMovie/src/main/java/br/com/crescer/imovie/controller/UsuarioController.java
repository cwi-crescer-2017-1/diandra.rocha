package br.com.crescer.imovie.controller;

import br.com.crescer.imovie.entidade.Usuario;
import br.com.crescer.imovie.servico.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author diandra.rocha
 */

@RestController
@RequestMapping("/cadastro")
public class UsuarioController {
    
    
    @Autowired
    private UsuarioService service;
    
    @GetMapping
    public String teste(){
        return "testesndo";
    }

    @GetMapping("/{id}")
    public Usuario obterUsuario(@PathVariable("id") Long id) {
        return service.obterUsuario(id);
    }
    
    @PostMapping(consumes = "application/json")
    public Usuario salvar(@RequestBody Usuario user) throws Exception{
        return service.salvar(user);
    }
    
    
}