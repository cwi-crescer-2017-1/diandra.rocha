package br.com.crescer.aula02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Diandra Rocha
 */
public class Lista02Parte03Test {

    @Test
    public void testWrite() throws Exception {
        
        String path = "arquivo.txt";
        String conteudo = "teste";
        
        Lista02Parte03 instance = new Lista02Parte03();
        instance.write(path, conteudo);
        
        final File file = new File(path);
        final Reader reader = new FileReader(file);
        final BufferedReader bufferReader = new BufferedReader(reader);
            
        String aux = bufferReader.readLine();

        assertEquals(aux, conteudo);
    }

    
}
