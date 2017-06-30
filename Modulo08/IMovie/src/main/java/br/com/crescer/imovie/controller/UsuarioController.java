package br.com.crescer.imovie.controller;

import br.com.crescer.imovie.entidade.Usuario;
import br.com.crescer.imovie.servico.UsuarioService;
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
@RequestMapping("/public")
public class UsuarioController {
    
    @Autowired
    private UsuarioService service;

    @GetMapping
    public String passou() {
        return "Passou";
    }
    
    @PostMapping
    public Usuario salvar(Usuario user) throws Exception{
        return service.salvar(user);
    }
    
}