package br.com.crescer.aula03;

/**
 *
 * @author diandra.rocha
 */

public interface IDAO<T> {
    
    void insert(T t);

    void update(T t);

    void delete(T t);
    
    T loadBy(Long id);

}
