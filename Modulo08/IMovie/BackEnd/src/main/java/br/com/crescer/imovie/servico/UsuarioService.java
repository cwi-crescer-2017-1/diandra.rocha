package br.com.crescer.imovie.servico;

import br.com.crescer.imovie.entidade.Usuario;
import br.com.crescer.imovie.repositorio.UsuarioRepositorio;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author diandra.rocha
 */
@Service
public class UsuarioService {

    @Autowired
    UsuarioRepositorio repo;
    BCryptPasswordEncoder cript = new BCryptPasswordEncoder();

    public List<Usuario> listar() {
        return repo.findAll();
    }

    public Usuario encontrarUsuario(String email) {
        return repo.findByEmail(email);
    }

    public Usuario salvar(Usuario user) throws Exception {

        if (user.getSenha() == null || user.getEmail() == null) {
            throw new Exception("Usuário inválido");
        }

        if (user.getIdusuario() != 0) {
            Usuario usuario = repo.findByEmail(user.getEmail());
            if (usuario != null) {
                throw new Exception("Email já existente na base de dados");
            }
            return repo.save(user);
        } else {
            user.setSenha(cript.encode(user.getSenha()));
            return repo.save(user);
        }

    }

    public Usuario obterUsuario(long id) {
        return repo.findOne(id);
    }

    public void exluir(Usuario user) {
        repo.delete(user);
    }

    public void enviarSolicitacao(Usuario user, long id) throws Exception {
        Usuario adicionar = repo.findOne(id);
        Set<Usuario> pendentes = adicionar.getAmizadesPendentes();

        if (pendentes.contains(user)) {
            throw new Exception("Você já mandou solicitação para este usuário");
        }

        if (adicionar.getAmizades().contains(user) && user.getAmizades().contains(adicionar)) {
            throw new Exception("Usuário já esta na sua lista de amigos");
        }

        if (adicionar.equals(user)) {
            throw new Exception("Você não pode adicionar você mesmo");
        }

        pendentes.add(user);
        repo.save(adicionar);

    }

    public void aceitarSolicitacao(Usuario user, long id) {
        Usuario aceitar = repo.findOne(id);

        user.getAmizades().add(aceitar);
        aceitar.getAmizades().add(user);

        user.getAmizadesPendentes().remove(aceitar);

        repo.save(user);
        repo.save(aceitar);
    }

    public void removerAmigo(Usuario user, long id) {
        Usuario remover = repo.findOne(id);

        user.getAmizades().remove(remover);
        remover.getAmizades().remove(user);

        repo.save(user);
        repo.save(remover);
    }

}
