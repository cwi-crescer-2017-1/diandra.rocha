package br.com.crescer.imovie.servico;

import br.com.crescer.imovie.entidade.Post;
import br.com.crescer.imovie.entidade.Usuario;
import br.com.crescer.imovie.repositorio.PostRepositorio;
import java.awt.print.Pageable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

/**
 *
 * @author Diandra Rocha
 */
public class PostService {

    @Autowired
    PostRepositorio repo;

    public Page<Post> listarPorId(long id, Pageable pageable) {
        return repo.findById(id, pageable);
    }

    public Page<Post> feed(Usuario user, Pageable pageable) {
        return repo.findByUsuarioOrderByDataPostDesc(user.getAmizades(), pageable);
    }

    public Page<Post> meuFeed(Usuario user, Pageable pageable) {
        return repo.findByIdUsuario(user, pageable);
    }

    public Post salvar(Post post) {
        return repo.save(post);
    }

    public void excluir(long id){
        Post deletar = repo.findOne(id);
        repo.delete(deletar);
    }

    public Post buscar(long id) {
        return repo.findOne(id);
    }

}
