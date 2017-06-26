package br.com.crescer.aula04;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Diandra Rocha
 */
public abstract class GenericoDAO<Entity, ID> implements CrudDAO<Entity, ID> {
    
    private final EntityManager entityManager;
    private static Session sessao;
    private Transaction transacao;
    private Class<Entity> classe;
    
    public GenericoDAO(Class<Entity> classe, EntityManager entityManager){
        this.classe = classe;
        this.entityManager = entityManager;
    }
    
    @Override
    public Entity save ( Entity ent ) {
        final Session sessao = entityManager.unwrap(Session.class);
        
        entityManager.getTransaction().begin();
        
        sessao.saveOrUpdate(ent);
        
        entityManager.getTransaction().commit();
        
        sessao.close();
         
        return ent;

    }
    
    @Override
    public void remove(Entity ent){
        
        final Session sessao = entityManager.unwrap(Session.class);
        
        entityManager.getTransaction().begin();
        
        sessao.delete(ent);
        
        entityManager.getTransaction().commit();
        
        sessao.close();

    }
    
    @Override
    public List findAll() {
        
        final Session sessao = entityManager.unwrap(Session.class);
        
        List<Entity> retorno = sessao.createCriteria(classe).list();
        
        sessao.close();
        
        return retorno;

    }
    
    @Override
     public Entity loadById(ID id) {

        final Session sessao = entityManager.unwrap(Session.class);
        
        Entity retorno = (Entity) sessao.load(classe, (Serializable) id);
        
        sessao.close();
         
        return retorno;
    }
}