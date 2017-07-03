package br.com.crescer.imovie.controller;

import br.com.crescer.imovie.entidade.Usuario;
import br.com.crescer.imovie.servico.ComponenteService;
import br.com.crescer.imovie.servico.UsuarioService;
import java.util.HashMap;
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
@RequestMapping
public class LoginController {
    
   @Autowired
    private UsuarioService service;
   @Autowired
    private ComponenteService componente;
    
    @GetMapping("/login")
    public HashMap<String, Usuario> getUsuario() {
        
        HashMap<String, Usuario> hash = new HashMap();
        Usuario user =  componente.getUserSession();
        hash.put("dados", user);
        
       return hash;
    }

    @PostMapping("/cadastro")
    public Usuario cadastrar(@Valid @RequestBody Usuario user) throws Exception {
        if (service.encontrarUsuario(user.getEmail()) != null) {
            throw new Exception("Já possui um usuário cadastrado com esse e-mail");
        }
        return service.salvar(user);
    }

}