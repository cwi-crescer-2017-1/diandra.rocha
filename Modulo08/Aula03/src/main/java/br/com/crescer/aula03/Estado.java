package br.com.crescer.aula03;

/**
 *
 * @author diandra.rocha
 */
public class Estado {
    
    private long id;
    private String nome;
    private long uf;
    private long pais;

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public long getUf() {
        return uf;
    }

    public long getPais() {
        return pais;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUf(long uf) {
        this.uf = uf;
    }

    public void setPais(long pais) {
        this.pais = pais;
    }
}