package br.com.crescer.aula04;

/**
 *
 * @author Diandra Rocha
 */
public class ClienteDAO extends GenericoDAO<Cliente, Long>{

    public ClienteDAO() {
        super(Cliente.class);
    }
}