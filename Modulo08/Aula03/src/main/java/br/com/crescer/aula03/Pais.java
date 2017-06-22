package br.com.crescer.aula03;
/**
 *
 * @author diandra.rocha
 */
public class Pais {
    
    private long id;
    private String nome;
    private String sigla;

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}