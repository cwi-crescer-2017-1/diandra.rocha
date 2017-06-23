package br.com.crescer.lista03;

import java.io.File;

/**
 * @author carloshenrique
 */
public interface SQLUtils {

    void runFile(String filename) throws Exception;

    String executeQuery(String query);
    
    void importCSV(File file);
    
    File importCSV(String query);

}