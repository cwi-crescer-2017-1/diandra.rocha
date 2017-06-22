package br.com.crescer.aula02;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 *
 * @author Diandra Rocha
 */
public class Lista02Parte01 implements FileUtils {

    @Override
    public boolean mk(String string) {
        final File file = new File(string);
        try {
            return file.createNewFile();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean rm(String string) throws Exception {
        final File file = new File(string);
        if (file.isDirectory() == false) {
            return file.delete();
        } else {
            throw new IOException("Arquivo é um diretório, não pode ser excluído");
        }
    }

    @Override
    public String ls(String string) {

        final File file = new File(string);

        if (file.isDirectory()) {
            StringBuilder retorno = new StringBuilder();
            File[] afile = file.listFiles();
            int i = 0;
            for (int j = afile.length; i < j; i++) {
                File arquivo = afile[i];
                retorno.append(arquivo.getName());
            }
            return retorno.toString();
        }

        return file.getAbsolutePath();
    }

    @Override
    public boolean mv(String in, String out) {
        
        try {
           File entrada = new File(in);
            File saida = new File(out);                
            
            if(entrada.isDirectory() || saida.isDirectory()){
                throw new IOException("Arquivo é um diretório");
            }
            
            if (entrada.exists()) {
                Files.move(entrada.toPath(), saida.toPath(), REPLACE_EXISTING);
                return true;
            }
            return false;

        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }
}
