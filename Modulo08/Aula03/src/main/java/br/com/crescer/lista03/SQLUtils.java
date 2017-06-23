package br.com.crescer.lista03;

import java.io.File;
import java.io.IOException;

/**
 * @author carloshenrique
 */
public interface SQLUtils {

    void runFile(String filename) throws Exception;

    String executeQuery(String query);
    
    void importCSV(File file);
    
    File exportCSV(String query) throws IOException;

}