package br.com.crescer.imovie.servico;

import br.com.crescer.imovie.entidade.Comentario;
import br.com.crescer.imovie.entidade.Curtida;
import br.com.crescer.imovie.entidade.Post;
import br.com.crescer.imovie.entidade.Usuario;
import br.com.crescer.imovie.repositorio.ComentarioRepositorio;
import br.com.crescer.imovie.repositorio.CurtidaRepositorio;
import br.com.crescer.imovie.repositorio.PostRepositorio;
import br.com.crescer.imovie.repositorio.UsuarioRepositorio;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diandra Rocha
 */
@Service
public class CurtidaService {
    
    @Autowired
    CurtidaRepositorio repo;
    @Autowired
    UsuarioRepositorio repo3;
    @Autowired
    PostRepositorio repo2; //Gambi Design Pattern
    
    public Curtida encontrarPorUsuario(Usuario usuario){
        return repo.findByIdusuario(usuario);
    }
    
    public List<Curtida> listar(Post post){
        return repo.findByIdpost(post);
    }
    
    public Curtida salvar(Curtida curtida, Post curtido, Usuario curtidor){
        curtido.getCurtidaSet().add(curtida);
        curtida.setIdpost(curtido);
        curtida.setIdusuario(repo3.findOne(curtidor.getIdusuario()));
        
        repo2.save(curtido);
        return repo.save(curtida);
    }
    
    public void excluir(Curtida curtida){
        long id = curtida.getIdpost().getIdpost();
        Post postagem = repo2.findOne(id);
        postagem.getCurtidaSet().remove(curtida);
        
        repo2.save(postagem);
        repo.delete(curtida);
    }   
}