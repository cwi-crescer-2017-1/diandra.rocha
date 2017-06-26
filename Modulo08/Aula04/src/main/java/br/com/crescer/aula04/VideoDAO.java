package br.com.crescer.aula04;

import javax.persistence.EntityManager;

/**
 *
 * @author Diandra Rocha
 */
public class VideoDAO extends GenericoDAO<Video, Long>{
    
    public VideoDAO(EntityManager entityManager) {
        super(Video.class, entityManager);
    } 
}