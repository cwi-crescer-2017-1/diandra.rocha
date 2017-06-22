package br.com.crescer.aula02;

import java.io.FileNotFoundException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Diandra Rocha
 */
public class Lista02Parte02Test {
    
    @Test
    public void testRead() throws Exception {
        
        String string = "arquivo.txt";
        Lista02Parte02 instance = new Lista02Parte02();
        
        String expResult = "teste";
        String result = instance.read(string);
        
        assertEquals(expResult, result);

    }
    
    @Test (expected = FileNotFoundException.class)
     public void testRead2() throws Exception {
        
        String string = "blablabla.txt";
        Lista02Parte02 instance = new Lista02Parte02();
        
        String resultado = instance.read(string);
    }
    
    
}
