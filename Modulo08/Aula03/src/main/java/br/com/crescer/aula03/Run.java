package br.com.crescer.aula03;

import static br.com.crescer.aula03.Conexao.getConexao;
import java.sql.Connection;
import java.sql.SQLException;

public class Run {
    
    private static TesteDAO testeDAO;

    public static void main(String[] args) throws SQLException {
          
        try (Connection conexao1 = getConexao()) {
           
            testeDAO = new TesteDAO(conexao1);
            
            testeDAO.create();
            testeDAO.insert();
            testeDAO.delete();

        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }
}