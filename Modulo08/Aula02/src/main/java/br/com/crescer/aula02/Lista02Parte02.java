package br.com.crescer.aula02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

/**
 *
 * @author Diandra Rocha
 */
public class Lista02Parte02 implements ReaderUtils {

    public String read(String string) {
        try {
            final File file = new File(string);
            final Reader reader = new FileReader(file);
            final BufferedReader bufferReader = new BufferedReader(reader);
            
            if(!file.isFile()){
                new Exception("Não é arquivo .txt");
            }
            
            return bufferReader.toString();
                    
        } catch (FileNotFoundException e) {
            return e.getMessage();
        }
        
    }

}
