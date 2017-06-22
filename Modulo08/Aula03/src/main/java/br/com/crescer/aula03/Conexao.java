package br.com.crescer.aula03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author diandra.rocha
 */
public final class Conexao {

    private final static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private final static String user = "MODULOJAVA";
    private final static String pass = "CRESCER2017";

    private Conexao() {
    }

    public static Connection getConexao() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }
    
}
