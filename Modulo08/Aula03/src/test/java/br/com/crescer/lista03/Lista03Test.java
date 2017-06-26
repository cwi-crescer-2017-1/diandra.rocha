package br.com.crescer.lista03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Diandra Rocha
 */
public class Lista03Test {
    
    @Test
    public void testRunFile() throws Exception {
        
        String fileName = "arquivo.txt";
        Lista03 instance = new Lista03();
        instance.runFile(fileName);
        
        ObjetoGenericoDAO dao = new ObjetoGenericoDAO();
        ObjetoGenerico resultado = dao.loadBy(1l);
        ObjetoGenerico expected = new ObjetoGenerico();
        expected.setId(1);
        expected.setNome("TESTE");
        
        assertEquals(expected.getId(), resultado.getId());
    }

    @Ignore
    @Test
    public void testExecuteQuery() {
        
        String query = "SELECT * FROM OBJETOGENERICO;";
        Lista03 instance = new Lista03();
        
        String expResult = "Coluna ID: 1, Coluna Nome: TESTE";
        String result = instance.executeQuery(query);
        
        assertEquals(expResult, result);
    }
    
    @Ignore
    @Test
    public void testImportCSV() {
        
        File file = new File("arquivo2.txt");
        Lista03 instance = new Lista03();
        instance.importCSV(file);
        
        ObjetoGenericoDAO dao = new ObjetoGenericoDAO();
        ObjetoGenerico resultado = dao.loadBy(2l);
        
        ObjetoGenerico expected = new ObjetoGenerico();
        expected.setId(2);
        expected.setNome("TESTE2");
        
        assertEquals(expected.getId(), resultado.getId());     
    }

    @Ignore
    @Test
    public void testExportCSV() throws Exception {
        
        String query = "SELECT * FROM OBJETOGENERICO;";
        Lista03 instance = new Lista03();
        
        File expResult = new File("arquivo3.txt");
        File result = instance.exportCSV(query);
        
        final Reader reader = new FileReader(expResult);
        final BufferedReader bufferReader = new BufferedReader(reader);
        String conteudo = bufferReader.readLine();
        
        final Writer writer = new FileWriter(expResult);
        final BufferedWriter bufferWriter = new BufferedWriter(writer);
        bufferWriter.append(conteudo);
        bufferWriter.flush();
        
        assertEquals(expResult, result);

    }
    
}
