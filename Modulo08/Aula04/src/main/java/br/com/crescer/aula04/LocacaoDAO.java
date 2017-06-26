package br.com.crescer.aula04;

import javax.persistence.EntityManager;

/**
 *
 * @author Diandra Rocha
 */
public class LocacaoDAO extends GenericoDAO<Locacao, Long>{
    
    public LocacaoDAO(EntityManager entityManager) {
        super(Locacao.class, entityManager);
    } 
}