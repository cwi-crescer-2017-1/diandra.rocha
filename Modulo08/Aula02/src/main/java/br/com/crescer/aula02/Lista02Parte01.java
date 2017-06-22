package br.com.crescer.aula02;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diandra Rocha
 */
public class Lista02Parte01 implements FileUtils {

    public boolean mk(String string) {
        File file = new File(string + ".txt");

        try {
            return file.createNewFile();
        } catch (IOException ex) {
            ex.addSuppressed(new IOException("Inválido"));
            return false;
        }
    }

    public boolean rm(String string) {
        final File file = new File(string);
        if (file.isDirectory()) {
            String mensagem = "Inválido";
            return false;
        }
        return file.delete();
    }

    public String ls(String string) {

        File file = new File(string);
             
        if (file.isDirectory()) {
            StringBuilder retorno = new StringBuilder();
            File afile[] = file.listFiles(); 
            int i = 0;
            for (int j = afile.length; i < j; i++) {
                File arquivo = afile[i];
                retorno.append(arquivo.getName());
            }
            return retorno.toString();
        }
        
        return file.getAbsolutePath();
    }
    
    public boolean mv(String in, String out){
        return true;
    }

}
