package br.com.crescer.aula02;

import java.io.File;
import java.io.IOException;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Diandra Rocha
 */
public class Lista02Parte01Test {
    
     
    @Test
    public void testMk() {

        String string = "arquivo.txt";
        Lista02Parte01 instance = new Lista02Parte01();
        
        boolean expResult = true;
        boolean result = instance.mk(string);
        
        assertEquals(expResult, result);
        
    }

    @Test (expected  = IOException.class)
    public void testRm() throws Exception {
        
        String string = "folder";
        Lista02Parte01 instance = new Lista02Parte01();
        
        boolean expResult = false;
        boolean result = instance.rm(string);
        
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRm2() throws Exception {
        
        String string = "arquivo.txt";
        Lista02Parte01 instance = new Lista02Parte01();
        
        boolean expResult = true;
        boolean result = instance.rm(string);
        
        assertEquals(expResult, result);
    }

    @Test
    public void testLsDiretorio() {
        
        String string = "folder";
        Lista02Parte01 instance = new Lista02Parte01();
        
        String expResult = "teste";
        String result = instance.ls(string);
        
        assertEquals(expResult, result);
    }
    
    @Test
    public void testLsFile() {
        
        String string = "arquivo.txt";
        Lista02Parte01 instance = new Lista02Parte01();
        
        String expResult = "C:\\Users\\Diandra Rocha\\Desktop\\CWI\\diandra.rocha\\Modulo08\\Aula02\\arquivo.txt";
        String result = instance.ls(string);
        
        assertEquals(expResult, result);
    }
    
    @Test
    public void testMv(){
        
    }
}