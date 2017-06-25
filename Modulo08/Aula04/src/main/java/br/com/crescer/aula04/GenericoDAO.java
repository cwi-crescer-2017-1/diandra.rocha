package br.com.crescer.aula04;

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
    public List findAll(Entity ent) {
        sessao = Conexao.getSession();
        
        List objts;
        objts = null;
        
        Criteria selectAll = sessao.createCriteria(ent.getClass());
        objts = selectAll.list();
        
        sessao.close();
        return objts;
    }
    
    @Override
     public Entity loadById(ID id) {
 
        sessao = Conexao.getSession();
        
        Entity retorno = (Entity) sessao.load(classe, id.getClass());

        sessao.flush();
        sessao.close();
        
        return retorno;
    }
}