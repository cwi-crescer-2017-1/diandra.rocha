package br.com.crescer.aula02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 *
 * @author Diandra Rocha
 */
public class Lista02Parte02 implements ReaderUtils {

    @Override
    public String read(String string) throws Exception{
        try {
            final File file = new File(string);
            final Reader reader = new FileReader(file);
            final BufferedReader bufferReader = new BufferedReader(reader);
            
            if(file.isFile() == false){
                throw new Exception("Não é arquivo .txt");
            }else{
                return bufferReader.readLine();
            }
            
        } catch (FileNotFoundException e) {
            return e.getMessage();
        } catch (IOException ex) {
            return ex.getMessage();
        }   
    }
}
