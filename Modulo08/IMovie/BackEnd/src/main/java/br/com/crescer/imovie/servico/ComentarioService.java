package br.com.crescer.imovie.servico;

import br.com.crescer.imovie.entidade.Comentario;
import br.com.crescer.imovie.entidade.Post;
import br.com.crescer.imovie.repositorio.ComentarioRepositorio;
import br.com.crescer.imovie.repositorio.PostRepositorio;
import java.awt.print.Pageable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

/**
 *
 * @author Diandra Rocha
 */
public class ComentarioService {
    
    @Autowired
    ComentarioRepositorio repo;
    @Autowired
    PostRepositorio repo2; //Gambi Design Pattern
    
    public Page<Comentario> listarComentarios(long id, Pageable pageable){
        Post encontrar = repo2.findOne(id);
        return repo.findByPostOrderByDataComentarioDesc(encontrar, pageable);
    }
        
    public Comentario salvar(Comentario comentario){
        return repo.save(comentario);
    }
    
    public void excluir(Comentario comentario){
        repo.delete(comentario);
    }
    
}
