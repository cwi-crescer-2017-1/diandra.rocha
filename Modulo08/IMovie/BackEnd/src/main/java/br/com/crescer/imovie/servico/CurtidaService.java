package br.com.crescer.imovie.servico;

import br.com.crescer.imovie.entidade.Curtida;
import br.com.crescer.imovie.entidade.Post;
import br.com.crescer.imovie.entidade.Usuario;
import br.com.crescer.imovie.repositorio.CurtidaRepositorio;
import java.util.List;
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
    public Curtida encontrarPorUsuario(Usuario usuario){
        return repo.findByIdusuario(usuario);
    }
    
    public List<Curtida> listar(Post post){
        return repo.findByIdpost(post);
    }
    
    public Curtida salvar(Curtida curtida){
        return repo.save(curtida);
    }
    
    public void excluir(Curtida curtida){
        repo.delete(curtida);
    }   
}