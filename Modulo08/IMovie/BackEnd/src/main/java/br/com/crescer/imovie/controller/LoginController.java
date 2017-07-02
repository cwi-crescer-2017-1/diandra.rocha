package br.com.crescer.imovie.controller;

import br.com.crescer.imovie.entidade.Usuario;
import br.com.crescer.imovie.servico.ComponenteService;
import br.com.crescer.imovie.servico.UsuarioService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author diandra.rocha
 */

@RestController
@RequestMapping("/home")
public class LoginController {
    
   @Autowired
    private UsuarioService service;
    private ComponenteService componente;
    
    @GetMapping("/login")
    public Usuario getUsuario() {
        return componente.getUserSession();
    }

    @PostMapping("/cadastro")
    public Usuario cadastrar(@Valid @RequestBody Usuario user) throws Exception {
        if (service.encontrarUsuario(user.getEmail()) != null) {
            throw new Exception("Já possui um usuário cadastrado com esse e-mail");
        }
        return service.salvar(user);
    }

}