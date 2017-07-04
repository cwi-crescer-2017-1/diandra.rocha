package br.com.crescer.imovie.servico;

import br.com.crescer.imovie.entidade.Comentario;
import br.com.crescer.imovie.entidade.Post;
import br.com.crescer.imovie.entidade.Usuario;
import br.com.crescer.imovie.repositorio.ComentarioRepositorio;
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
public class ComentarioService {
    
    @Autowired
    ComentarioRepositorio repo;
    @Autowired
    UsuarioRepositorio repo3;
    @Autowired
    PostRepositorio repo2; //Gambi Design Pattern
    
    public Page<Comentario> listarComentarios(long id, Pageable pageable){
        Post encontrar = repo2.findOne(id);
        return repo.findByIdpostOrderByDatacomentarioDesc(encontrar, pageable);
    }
        
    public Comentario salvar(Post post, Usuario user, Comentario comentario){
        Post postagem = repo2.findOne(post.getIdpost());
        comentario.setIdpost(postagem);
        comentario.setIdusuario(repo3.findOne(user.getIdusuario()));
        comentario.setDatacomentario(new Date());
        postagem.getComentarioSet().add(comentario);
        repo2.save(postagem);
        return repo.save(comentario);
    }
    
    public void excluir(Comentario comentario){
        long id = comentario.getIdpost().getIdpost();
        Post postagem = repo2.findOne(id);
        postagem.getComentarioSet().remove(comentario);
        
        repo2.save(postagem);
        repo.delete(comentario);
    }
    
    public Comentario buscarPorId(long id){
        return repo.findOne(id);
    }
    
}
