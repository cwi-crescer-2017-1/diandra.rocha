package br.com.crescer.aula04;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;

/**
 *
 * @author Diandra Rocha
 */
public class Conexao {

    private static EntityManager getEntityManager() {

        EntityManagerFactory factory = null;
        EntityManager entityManager = null;

        try {

            factory = Persistence.createEntityManagerFactory("CRESCER");
            entityManager = factory.createEntityManager();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            entityManager.close();
            factory.close();
        }

        return entityManager;
    }

    public static Session getSession() {
        return getEntityManager().unwrap(Session.class);
    }
}
