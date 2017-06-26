package br.com.crescer.aula04;

import javax.persistence.EntityManager;

/**
 *
 * @author Diandra Rocha
 */
public class FuncionarioDAO extends GenericoDAO<Funcionario, Long>{
    
    public FuncionarioDAO(EntityManager entityManager) {
        super(Funcionario.class, entityManager);
    } 
}
