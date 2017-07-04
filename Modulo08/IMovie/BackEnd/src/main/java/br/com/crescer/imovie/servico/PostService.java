package br.com.crescer.imovie.servico;

import br.com.crescer.imovie.entidade.Comentario;
import br.com.crescer.imovie.entidade.Post;
import br.com.crescer.imovie.entidade.Usuario;
import br.com.crescer.imovie.repositorio.PostRepositorio;
import br.com.crescer.imovie.repositorio.UsuarioRepositorio;
import java.util.Date;
import java.util.Set;
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
    @Autowired
    UsuarioRepositorio repo2;

    public Page<Post> feedAlheio(Usuario user, Pageable p) {
        return repo.findByIdusuario(user, p);
    }

    public Page<Post> feed(Usuario user, Pageable pageable) {
        return repo.findByIdusuarioInOrderByDatapostDesc(user.getAmizades(), pageable);
    }

    public Page<Post> meuFeed(Usuario user,Pageable p) {
        return repo.findByIdusuario(user, p);
    }
    
    public int getCurtidas(long id){
        Post post = repo.findOne(id);
        return post.getCurtidaSet().size();
    }
    
    public Set<Comentario> getComentarios(long id){
        Post post = repo.findOne(id);
        return post.getComentarioSet();
    }

    public Post salvar(Post post, Usuario user) {
        Usuario usuario = repo2.findByEmail(user.getEmail());
        post.setIdusuario(usuario);
        post.setDatapost(new Date());
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
