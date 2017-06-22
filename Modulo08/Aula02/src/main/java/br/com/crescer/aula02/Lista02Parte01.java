package br.com.crescer.aula02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

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

        InputStream aux1;
        OutputStream aux2;

        try {
            File toFile = new File(in);
            File fromFile = new File(out);

            if (!fromFile.exists()) {
                if (!fromFile.getParentFile().exists()) {
                    fromFile.getParentFile().mkdir();
                }
            }
            fromFile.createNewFile();

            aux1 = new FileInputStream(in);
            aux2 = new FileOutputStream(out);

            byte[] buffer = new byte[1024];
            int length;

            while ((length = aux1.read(buffer)) > 0) {

                aux2.write(buffer, 0, length);
            }

            if (in.equals(out)) {
                toFile.delete();
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }
}
