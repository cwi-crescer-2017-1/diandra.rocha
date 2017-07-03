package br.com.crescer.imovie.servico;

import br.com.crescer.imovie.entidade.Post;
import br.com.crescer.imovie.entidade.Usuario;
import br.com.crescer.imovie.repositorio.PostRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diandra Rocha
 */
@Service
public class PostService {

    @Autowired
    PostRepositorio repo;

    public Page<Post> feedAlheio(Usuario user, Pageable p) {
        return repo.findByIdusuario(user, p);
    }

    public Page<Post> feed(Usuario user, Pageable pageable) {
        return repo.findByIdusuarioInOrderByDatapostDesc(user.getAmizades(), pageable);
    }

    public Page<Post> meuFeed(Usuario user,Pageable p) {
        return repo.findByIdusuario(user, p);
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
    
    public Post buscarPorId(long id){
        return repo.findOne(id);
    }

}
