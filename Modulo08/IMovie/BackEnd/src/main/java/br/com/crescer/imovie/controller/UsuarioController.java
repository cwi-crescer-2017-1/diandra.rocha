package br.com.crescer.imovie.controller;

import br.com.crescer.imovie.entidade.Post;
import br.com.crescer.imovie.entidade.Usuario;
import br.com.crescer.imovie.servico.ComponenteService;
import br.com.crescer.imovie.servico.UsuarioService;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Diandra Rocha
 */
@RestController
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @Autowired
    ComponenteService componente;

    @GetMapping(value = "/todosusuarios")
    public List<Usuario> listarTodos() {
        return service.listar();
    }

    @GetMapping(value = "usuario/{id}")
    public Usuario gerPorId(@PathVariable long id) {
        return service.obterUsuario(id);
    }

    @GetMapping(value = "/amigos")
    public Set<Usuario> geTodosOsUsuario() {
        Usuario user = componente.getUserSession();
        return user.getAmizades();
    }

    @DeleteMapping(value = "/excluiramigo/{id}")
    public void deletarAmigo(@PathVariable long id) {
        Usuario user = componente.getUserSession();
        service.removerAmigo(user, id);
    }

    @PutMapping(value = "/atualizarusuario")
    public void updateUsuario(@RequestBody Usuario usuario) throws Exception {
        service.salvar(usuario);
    }

    @GetMapping(value = "/convidar/{id}")
    public void enviarSolicitacao(@PathVariable long id) throws Exception {
        Usuario usuarioSolicitante = componente.getUserSession();
        service.enviarSolicitacao(usuarioSolicitante, id);
    }

    @GetMapping(value = "/aceitar/{id}")
    public void aceitarSolicitacao(@PathVariable long id) {
        Usuario usuarioQueAceita = componente.getUserSession();
        service.aceitarSolicitacao(usuarioQueAceita, id);
    }

    @DeleteMapping(value = "/excluirusuario")
    public void deletarUsuario() {
        Usuario user = componente.getUserSession();
        service.exluir(user);
    }
    
    @GetMapping("/solicitacoes")
    public Set<Usuario> obterPendentes(){
        return service.obterPendentes(componente.getUserSession());
    }

}
