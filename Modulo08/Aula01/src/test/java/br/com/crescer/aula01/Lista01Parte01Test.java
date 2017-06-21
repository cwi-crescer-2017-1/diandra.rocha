/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula01;
import static org.junit.Assert.*;
/**
 *
 * @author Diandra Rocha
 */
public class Lista01Parte01Test {
    
    public Lista01Parte01Test() {
    }
    

    @org.junit.Test
    public void testIsEmpty() {
        String string = "asasasa";
        Lista01Parte01 instance = new Lista01Parte01();
        
        boolean expResult = false;
        boolean result = instance.isEmpty(string);
        
        assertEquals(expResult, result);
    }
    
     @org.junit.Test
     public void testIsEmptyTrue() {
        String string = "";
        Lista01Parte01 instance = new Lista01Parte01();
        
        boolean expResult = true;
        boolean result = instance.isEmpty(string);
        
        assertEquals(expResult, result);
    }

    @org.junit.Test
    public void testInverter() {
        String string = "diandra";
        Lista01Parte01 instance = new Lista01Parte01();
        
        String expResult = "ardnaid";
        String result = instance.inverter(string);
        
        assertEquals(expResult, result);
    }

    @org.junit.Test
    public void testContaVogais() {
        String string = "ashashashu";
        Lista01Parte01 instance = new Lista01Parte01();
        
        int expResult = 4;
        int result = instance.contaVogais(string);
        
        assertEquals(expResult, result);
    }

    @org.junit.Test
    public void testIsPalindromo() {
        String string = "arara";
        Lista01Parte01 instance = new Lista01Parte01();
        
        boolean expResult = true;
        boolean result = instance.isPalindromo(string);
        
        assertEquals(expResult, result);
    }
    
     @org.junit.Test
     public void testIsPalindromoFalse() {
        String string = "qualquer";
        Lista01Parte01 instance = new Lista01Parte01();
        
        boolean expResult = false;
        boolean result = instance.isPalindromo(string);
        
        assertEquals(expResult, result);
    }
    
}
