package br.com.crescer.lista03;

import br.com.crescer.aula03.Conexao;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diandra Rocha
 */
public class Lista03 implements SQLUtils {

    public void runFile(String fileName) throws Exception {
        File file = new File(fileName);

        List<String> comandos = new ArrayList<>();

        try {
            comandos = Files.readAllLines(file.toPath());

            for (int i = 0; i < comandos.size(); i++) {
                String query = comandos.get(i);

                if (query.contains("DROP")) {
                    throw new Exception("Query inválida, contém drop");

                } else {

                    try (final PreparedStatement preparedStatement
                            = Conexao.getConexao().prepareStatement(query)) {

                        preparedStatement.executeUpdate();

                    } catch (final SQLException e) {
                        System.err.format("SQLException: %s", e);
                    }
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String executeQuery(String query) {

        String retorno = "";
        ObjetoGenerico obj = new ObjetoGenerico();

        try (final PreparedStatement preparedStatement
                = Conexao.getConexao().prepareStatement(query)) {

            try (final ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    obj.setId(resultSet.getLong("ID"));
                    obj.setNome(resultSet.getString("NOME"));
                    retorno = retorno + String.format("Coluna ID: %d, Coluna Nome: %s \n", obj.getId(), obj.getNome());
                }

            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }

        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        return retorno;
    }

    public void importCSV(File file) {

        String caminho = file.toPath().toString();
        String query = "LOAD DATA INFILE '" + caminho
                + "' INTO TABLE ObjetoGenerico (Id,Nome)";

        try (final PreparedStatement preparedStatement
                = Conexao.getConexao().prepareStatement(query)) {

            preparedStatement.executeUpdate();

        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }
    
    public File exportCSV(String query) throws IOException {
        
        ObjetoGenerico obj = new ObjetoGenerico();
        List<ObjetoGenerico> data = new ArrayList<>();
        StringBuilder retorno = new StringBuilder();
        File file = new File("resultado.txt");
        

        try (final PreparedStatement preparedStatement
                = Conexao.getConexao().prepareStatement(query)) {

            try (final ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    obj.setId(resultSet.getLong("ID"));
                    obj.setNome(resultSet.getString("NOME"));
                    data.add(obj);
                }
                
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }

        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        
        String montagem = "";
        for(ObjetoGenerico objetoGenerico : data){
            montagem = String.format("ID:%d Nome:%s,\n", objetoGenerico.getId(), objetoGenerico.getNome());
            retorno.append(montagem);
        }
        
        FileWriter escrito = new FileWriter(file);
        BufferedWriter escrever = new BufferedWriter(escrito);
        escrever.append(retorno);
        
        return file;
    }

}
