package br.com.crescer.imovie.servico;

import br.com.crescer.imovie.entidade.Comentario;
import br.com.crescer.imovie.entidade.Post;
import br.com.crescer.imovie.entidade.Usuario;
import br.com.crescer.imovie.repositorio.ComentarioRepositorio;
import br.com.crescer.imovie.repositorio.PostRepositorio;
import br.com.crescer.imovie.repositorio.UsuarioRepositorio;
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
        
        comentario.setIdpost(repo2.findOne(post.getIdpost()));
        comentario.setIdusuario(repo3.findOne(user.getIdusuario()));
        return repo.save(comentario);
    }
    
    public void excluir(Comentario comentario){
        repo.delete(comentario);
    }
    
    public Comentario buscarPorId(long id){
        return repo.findOne(id);
    }
    
}
