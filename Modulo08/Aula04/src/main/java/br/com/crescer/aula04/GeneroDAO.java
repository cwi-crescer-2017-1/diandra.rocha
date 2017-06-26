package br.com.crescer.aula04;

import javax.persistence.EntityManager;

/**
 *
 * @author Diandra Rocha
 */
public class GeneroDAO extends GenericoDAO<Genero, Long>{
    
    public GeneroDAO(EntityManager entityManager) {
        super(Genero.class, entityManager);
    } 
}