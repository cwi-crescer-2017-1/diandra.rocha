package br.com.crescer.aula02;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 *
 * @author Diandra Rocha
 */
public class Lista02Parte03 implements WriterUtils {

    @Override
    public void write(String path, String conteudo) throws Exception {
        try {
            final File file = new File(path);
            final Writer writer = new FileWriter(file);
            final BufferedWriter bufferReader = new BufferedWriter(writer);
            bufferReader.append(conteudo);
            bufferReader.flush();
            
            if(file.isFile() == false){
                throw new Exception("Não é arquivo .txt");
            }
                              
        } catch (FileNotFoundException e) {
            e.getMessage();
        } catch (IOException ex) {
            ex.getMessage();
        }
    }

}
