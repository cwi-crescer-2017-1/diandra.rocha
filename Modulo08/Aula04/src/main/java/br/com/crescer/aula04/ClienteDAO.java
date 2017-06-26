package br.com.crescer.aula04;

import javax.persistence.EntityManager;

/**
 *
 * @author Diandra Rocha
 */
public class ClienteDAO extends GenericoDAO<Cliente, Long>{

    public ClienteDAO(EntityManager entityManager) {
        super(Cliente.class, entityManager);
    }
}