/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula07;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Diandra Rocha
 */
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    
  @Override
  List<Cliente> findAll();
  
  @Override
  Cliente save(Cliente cliente);

}
