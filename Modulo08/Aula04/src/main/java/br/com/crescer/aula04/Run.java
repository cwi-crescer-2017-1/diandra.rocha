/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula04;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author diandra.rocha
 */
public class Run {

    public static void main(String[] args) {
        
        final EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("CRESCER");      
        
        final EntityManager em;
        em = emf.createEntityManager();
  
        
        final Cliente cliente = em.find(Cliente.class, 1L);
        
        
        
        em.getTransaction().begin();
        em.remove(cliente);
        em.getTransaction().commit();
        
        System.out.println(cliente.getNome());
//        
//        final Cliente cliente = new Cliente();
//        cliente.setId(1l);
//        cliente.setNome("Carlos");
//        
//        
//
//        em.persist(cliente);
//        em.getTransaction().commit();
        
        em.close();
        emf.close();

        

    }

}
