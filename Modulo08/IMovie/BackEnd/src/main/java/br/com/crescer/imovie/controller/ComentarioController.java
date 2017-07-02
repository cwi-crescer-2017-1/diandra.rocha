package br.com.crescer.imovie.controller;

import br.com.crescer.imovie.servico.ComentarioService;
import br.com.crescer.imovie.servico.ComponenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Diandra Rocha
 */
@RestController
public class ComentarioController {
    
    @Autowired
    ComentarioService service;
    @Autowired
    ComponenteService componente;

    
}
