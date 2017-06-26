/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.lista03;

import br.com.crescer.aula03.Conexao;
import br.com.crescer.aula03.Pais;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Diandra Rocha
 */
public class ObjetoGenericoDAO {
    private static final String LOAD_OG = "SELECT * FROM OBJETOGENERICO WHERE ID = ?";
    
    public ObjetoGenerico loadBy(Long id) {
        final ObjetoGenerico obj = new ObjetoGenerico();
        
        try (final PreparedStatement preparedStatement
                = Conexao.getConexao().prepareStatement(LOAD_OG)) {
            preparedStatement.setLong(1, id);
            
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    obj.setId(resultSet.getLong("ID"));
                    obj.setNome(resultSet.getString("NOME"));
                }
                
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
            
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        
        return obj;
    }
}
