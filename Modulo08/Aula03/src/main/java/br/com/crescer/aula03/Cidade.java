package br.com.crescer.aula03;

/**
 *
 * @author diandra.rocha
 */
public class Cidade {
    
    private long id;
    private String nome;
    private long estado;

    public long getEstado() {
        return estado;
    }

    public String getNome() {
        return nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEstado(long estado) {
        this.estado = estado;
    }
    
}
