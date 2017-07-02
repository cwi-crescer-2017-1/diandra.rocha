package br.com.crescer.imovie.servico;

import br.com.crescer.imovie.entidade.Curtida;
import br.com.crescer.imovie.repositorio.CurtidaRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Diandra Rocha
 */
public class CurtidaService {
    
    @Autowired
    CurtidaRepositorio repo;
    
    public List<Curtida> listar(){
        return repo.findAll();
    }
    
    public Curtida salvar(Curtida curtida){
        return repo.save(curtida);
    }
    
    public void excluir(Curtida curtida){
        repo.delete(curtida);
    }   
}