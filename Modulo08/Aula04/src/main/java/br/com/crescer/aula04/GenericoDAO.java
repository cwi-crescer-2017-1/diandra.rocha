package br.com.crescer.aula04;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Diandra Rocha
 */
public abstract class GenericoDAO<Entity, ID> implements CrudDAO<Entity, ID> {
    
    private static Session sessao;
    private Transaction transacao;
    private Class<Entity> classe;
    
    public GenericoDAO(Class<Entity> classe){
        this.classe = classe;
    }
    
    @Override
    public Entity save ( Entity ent ) {
            sessao = Conexao.getSession();
            transacao = sessao.beginTransaction();
            
            sessao.save(ent);
            sessao.flush();
            transacao.commit();
            
            sessao.close();
            return ent;
    }
    
    @Override
    public void remove(Entity ent){
        
            sessao = Conexao.getSession();
            transacao = sessao.beginTransaction();
            
            sessao.delete(ent);
            sessao.flush();
            transacao.commit();
            
            sessao.close();
    }
    
    @Override
    public List findAll() {
        sessao = Conexao.getSession();
        
        List objts;
        objts = null;
        
        Criteria selectAll = sessao.createCriteria(classe);
        objts = selectAll.list();
        
        sessao.close();
        return objts;
    }
    
    @Override
     public Entity loadById(ID id) {
 
        sessao = Conexao.getSession();
        
        Entity retorno = (Entity) sessao.load(classe, (Serializable) id);

        sessao.flush();
        sessao.close();
        
        return retorno;
    }
}